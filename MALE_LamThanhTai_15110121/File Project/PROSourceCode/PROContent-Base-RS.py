import pandas as pd
# Reading user file:
from numpy.core.tests.test_mem_overlap import xrange
from numpy.ma import sqrt

u_cols =  ['user_id', 'age', 'sex', 'occupation', 'zip_code']
users = pd.read_csv('C:/Users/IT/Desktop/MALE_LamThanhTai_15110121/File Project/DATARecommendSystem/u.user', sep='|', names=u_cols,
 encoding='latin-1')

n_users = users.shape[0]
print ('Number of users:', n_users)
# users.head() #uncomment this to see some few examples

#Reading ratings file:
r_cols = ['user_id', 'movie_id', 'rating', 'unix_timestamp']

ratings_base = pd.read_csv('C:/Users/IT/Desktop/MALE_LamThanhTai_15110121/File Project/DATAContent-Based RS/ua.base', sep='\t', names=r_cols, encoding='latin-1')
ratings_test = pd.read_csv('C:/Users/IT/Desktop/MALE_LamThanhTai_15110121/File Project/DATAContent-Based RS/ua.test', sep='\t', names=r_cols, encoding='latin-1')

rate_train = ratings_base.as_matrix()
rate_test = ratings_test.as_matrix()

print ('Number of traing rates:', rate_train.shape[0])
print ('Number of test rates:', rate_test.shape[0])

#Reading items file:
i_cols = ['movie id', 'movie title' ,'release date','video release date', 'IMDb URL', 'unknown', 'Action', 'Adventure',
 'Animation', 'Children\'s', 'Comedy', 'Crime', 'Documentary', 'Drama', 'Fantasy',
 'Film-Noir', 'Horror', 'Musical', 'Mystery', 'Romance', 'Sci-Fi', 'Thriller', 'War', 'Western']

items = pd.read_csv('C:/Users/IT/Desktop/MALE_LamThanhTai_15110121/File Project/DATAContent-Based RS/u.item', sep='|', names=i_cols,
 encoding='latin-1')

n_items = items.shape[0]
print ('Number of items:', n_items)

X0 = items.as_matrix()
X_train_counts = X0[:, -19:]
# print X0

#tfidf
from sklearn.feature_extraction.text import TfidfTransformer
transformer = TfidfTransformer(smooth_idf=True, norm ='l2')
tfidf = transformer.fit_transform(X_train_counts.tolist()).toarray()
import numpy as np
def get_items_rated_by_user(rate_matrix, user_id):
    """
    return (item_ids, scores)
    """
    y = rate_matrix[:,0] # all users
    # item indices rated by user_id
    # we need to +1 to user_id since in the rate_matrix, id starts from 1
    # but id in python starts from 0
    ids = np.where(y == user_id +1)[0]
    item_ids = rate_matrix[ids, 1] - 1 # index starts from 0
    scores = rates[ids, 2]
    return (item_ids, scores)


from sklearn.linear_model import Ridge
from sklearn import linear_model

d = tfidf.shape[1]  # data dimension
W = np.zeros((d, n_users))
b = np.zeros((1, n_users))

for n in range(n_users):
    ids, scores = get_items_rated_by_user(rate_train, n)
    clf = Ridge(alpha=0.01, fit_intercept=True)
    Xhat = tfidf[ids, :]

    clf.fit(Xhat, scores)
    W[:, n] = clf.coef_
    b[0, n] = clf.intercept_

# predicted scores
Yhat = tfidf.dot(W) + b

# user có id 100
n = 100
ids, scores = get_items_rated_by_user(rate_test, 10)
Yhat[n, ids]
print ('Rated movies ids:', ids)
print ('True ratings:', scores)
print ('Predicted ratings:', Yhat[ids, n])

def evaluate(Yhat, rates, W, b):
    se = 0
    cnt = 0
    for n in xrange(n_users):
        ids, scores_truth = get_items_rated_by_user(rates, n)
        scores_pred = Yhat[ids, n]
        e = scores_truth - scores_pred
        se += (e*e).sum(axis = 0)
        cnt += e.size
    return sqrt(se/cnt)

print ('RMSE for training:', evaluate(Yhat, rate_train, W, b))
print ('RMSE for test    :', evaluate(Yhat, rate_test, W, b))