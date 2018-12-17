import pandas as pd
#Đọc file user(u) - u.user 
u_cols = ['user_id', 'age', 'sex', 'occupation', 'zip_code']
#Đường dẫn file dataset
users = pd.read_csv('E:/15110CL4/ML/Project/Code/ml-100k/u.user', 
sep = '|', names = u_cols, encoding='latin-1')
#In số lượng user trong file data
n_users = users.shape[0]
print('number users:', n_users)


#Đọc file ratings(r)-ua.base, ua.test
r_cols = ['user_id', 'movie_id', 'rating','unix_timestamp']

ratings_base = pd.read_csv('E:/15110CL4/ML/Project/Code/ml-100k/ua.base',
 sep = '\t', names = r_cols, encoding='latin-1')
ratings_test = pd.read_csv('E:/15110CL4/ML/Project/Code/ml-100k/ua.test',
 sep = '\t', names = r_cols, encoding='latin-1')

rate_train = ratings_base.as_matrix()
rate_test = ratings_test.as_matrix()

print ('number of training rates:', rate_train.shape[0])
print ('number of test rates:', rate_test.shape[0])



#Đọc file item(i)- u.item
i_cols = ['movie id', 'movie title' ,'release date','video release date', 'IMDb URL', 'unknown', 'Action', 'Adventure',
 'Animation', 'Children\'s', 'Comedy', 'Crime', 'Documentary', 'Drama', 'Fantasy',
 'Film-Noir', 'Horror', 'Musical', 'Mystery', 'Romance', 'Sci-Fi', 'Thriller', 'War', 'Western']
#load toàn bộ thông tin của items vào biến items
items = pd.read_csv('E:/15110CL4/ML/Project/Code/ml-100k/u.item',
 sep='|', names=i_cols, encoding='latin-1')

n_items = items.shape[0]
print ('Number of items:', n_items)



#Vì đang recommen dựa vào thể loại phim nên chỉ quan tâm đến 19 giá trị nhị phân cuối mỗi hàng
#X0: Danh sách items
X0 = items.as_matrix()
#X_train_counts: Mảng có 19 cột mang các giá trị 0, 1
X_train_counts = X0[:, -19:]
print (X0)
print (X_train_counts)


#Xây dựng feature vector cho mỗi item dựa trên ma trận thể loại phim (X_train_counts)
#TfidfTransformer (TF-IDF): chuyển đổi dạng biểu diễn văn bản thành dạng không gian vector (VSM)
from sklearn.feature_extraction.text import TfidfTransformer
transformer = TfidfTransformer(smooth_idf=True, norm ='l2')
tfidf = transformer.fit_transform(X_train_counts.tolist()).toarray()
#Mỗi hàng của ma trận tfids là feature vector của một bộ phim
print(tfidf)


#Với mỗi user, xác định những vộ phim mà user đó đã rate và giá trị của rating đó
import numpy as np
def get_items_rated_by_user(rate_matrix, user_id):
    """ return (item_ids, scores) """
    #Của tất cả user
    y = rate_matrix[:,0] 
    # item indices rated by user_id
    ids = np.where(y == user_id +1)[0] 
    #python đếm bắt đầu bằn 0 nên -1
    item_ids = rate_matrix[ids, 1] - 1 
    scores = rate_matrix[ids, 2]
    return (item_ids, scores)

#Tìm hệ số Ridge Regression cho mỗi user
from sklearn.linear_model import Ridge
from sklearn import linear_model

# data dimension
d = tfidf.shape[1] 
W = np.zeros((d, n_users))
b = np.zeros((1, n_users))

for n in range(n_users):    
    ids, scores = get_items_rated_by_user(rate_train, n)
    #Biến số fit_intercept = False: Không tính toán những điểm cắt với trục y. True: Biến các điểm chắc chắn nằm trên đường thẳng đi qua gốc tọa độ
    clf = Ridge(alpha=0.01, fit_intercept  = True)
    Xhat = tfidf[ids, :]
    
    #Method của class LinearRegression
    #fit(X, y): Tiến hành tìm phương trình hồi quy tuyến tính
    clf.fit(Xhat, scores) 
    #Attribute của class LinearRegression
    #coef_: Trả về hệ số hồi quy
    W[:, n] = clf.coef_
    #intercept_: Trả về sai số
    b[0, n] = clf.intercept_

print ('W: ', W)
print ('b: ', b)

#Ratind cho mỗi items được dự đoán bằng cách tính
Yhat = tfidf.dot(W) + b
print ('Yhat: ', Yhat)

#Example/ Test
#user id
n = 100
 # 2 chữ số sau dấu .
np.set_printoptions(precision=2)
ids, scores = get_items_rated_by_user(rate_test, n)
Yhat[n, ids]
print('Rated movies ids :', ids )
print('True ratings     :', scores)
print('Predicted ratings:', Yhat[ids, n])