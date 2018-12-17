package com.machinelearning.demo.boostrap;

import com.machinelearning.demo.domain.*;
import com.machinelearning.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final Order1Repository order1Repository;
    private final ItemRepository itemRepository;
    private final RatingRepository ratingRepository;

    public DataLoader(CategoryRepository categoryRepository, ProductRepository productRepository, AccountRepository accountRepository, CustomerRepository customerRepository, Order1Repository order1Repository, ItemRepository itemRepository, RatingRepository ratingRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.order1Repository = order1Repository;
        this.itemRepository = itemRepository;
        this.ratingRepository = ratingRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        //Category-------------------------------------------------------------------------
        Category category1 = new Category();
        category1.setName("Electronic");
        category1.setDescription("This is electronic category");


        Category category2 = new Category();
        category2.setName("Clothing");
        category2.setDescription("This is clothing category");

        Category category3 = new Category();
        category3.setName("Movie");
        category3.setDescription("This is movie category");

        Category category4 = new Category();
        category4.setName("Book");
        category4.setDescription("This is marketing category");

        Category category5 = new Category();
        category5.setName("Course");
        category5.setDescription("This is development category");

        Category saveCategory1 = categoryRepository.save(category1);
        Category saveCategory2 = categoryRepository.save(category2);
        Category saveCategory3 = categoryRepository.save(category3);
        Category saveCategory4 = categoryRepository.save(category4);
        Category saveCategory5 = categoryRepository.save(category5);

        //Product-------------------------------------------------------------------------
        Product product1 = new Product();
        product1.setName("Phone");
        product1.setCost(1500);
        product1.setDescription("This is a phone's product");
        product1.setImage(new Image("fuck image"));
        product1.setCategory(saveCategory1);
        Product saveProduct1 = productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("T-shirt");
        product2.setCost(150);
        product2.setDescription("This is a clothing's products");
        product2.setImage(new Image("motherfucker"));
        product2.setCategory(saveCategory2);
        Product saveProduct2 = productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Action Film");
        product3.setCost(450);
        product3.setDescription("This is film's products");
        product3.setImage(new Image("fuck code"));
        product3.setCategory(saveCategory3);
        Product saveProduct3 = productRepository.save(product3);

        Product product4 = new Product();
        product4.setName("Marketing Book");
        product4.setCost(700);
        product4.setDescription("This is book's products");
        product4.setImage(new Image("fuck spring"));
        product4.setCategory(saveCategory4);
        Product saveProduct4 = productRepository.save(product4);

        Product product5 = new Product();
        product5.setName("Course");
        product5.setCost(925);
        product5.setDescription("This is a course's products");
        product5.setImage(new Image("fuck back-end"));
        product5.setCategory(saveCategory5);
        Product saveProduct5 = productRepository.save(product5);

        //Account-------------------------------------------------------------------------
        Account account1 = new Account();
        account1.setUsername("tailam");
        account1.setPassword("123");

        Account account2 = new Account();
        account2.setUsername("thunguyen");
        account2.setPassword("456");

        Account account3 = new Account();
        account3.setUsername("hocnguyen");
        account3.setPassword("789");

        Account account4 = new Account();
        account4.setUsername("will");
        account4.setPassword("10JQ");

        Account account5 = new Account();
        account5.setUsername("john");
        account5.setPassword("KA2");

        Account saveAccount1 = accountRepository.save(account1);
        Account saveAccount2 = accountRepository.save(account2);
        Account saveAccount3 = accountRepository.save(account3);
        Account saveAccount4 = accountRepository.save(account4);
        Account saveAccount5 = accountRepository.save(account5);

        //Customer-------------------------------------------------------------------------
        Customer customer1 = new Customer();
        customer1.setName("Tai Lam");
        customer1.setPhone("12345678");
        customer1.setEmail("tailam@gmail.com");
        customer1.setAccount(saveAccount1);

        Customer customer2 = new Customer();
        customer2.setName("Thu Nguyen");
        customer2.setPhone("0909898998");
        customer2.setEmail("thunguyen@gmail.com");
        customer2.setAccount(saveAccount2);

        Customer customer3 = new Customer();
        customer3.setName("Hoc Nguyen");
        customer3.setPhone("0128721587");
        customer3.setEmail("hocnguyen@gmail.com");
        customer3.setAccount(saveAccount3);

        Customer customer4 = new Customer();
        customer4.setName("Will Thompson");
        customer4.setPhone("089765431");
        customer4.setEmail("will@gmail.com");
        customer4.setAccount(saveAccount4);

        Customer customer5 = new Customer();
        customer5.setName("John Michale");
        customer5.setPhone("088997765");
        customer5.setEmail("john@gmail.com");
        customer5.setAccount(saveAccount5);

        Customer saveCustomer1 = customerRepository.save(customer1);
        Customer saveCustomer2 = customerRepository.save(customer2);
        Customer saveCustomer3 = customerRepository.save(customer3);
        Customer saveCustomer4 = customerRepository.save(customer4);
        Customer saveCustomer5 = customerRepository.save(customer5);

        //Order-------------------------------------------------------------------------
        Order1 order1 = new Order1();
        order1.setPrice(200);
        order1.setDateCreated("31-10-2018");
        order1.setCustomer(saveCustomer1);
        Order1 saveOrder1 = order1Repository.save(order1);

        Order1 order2 = new Order1();
        order2.setPrice(350);
        order2.setDateCreated("01-11-2018");
        order2.setCustomer(saveCustomer2);
        Order1 saveOrder2 = order1Repository.save(order2);

        Order1 order3 = new Order1();
        order3.setPrice(450);
        order3.setDateCreated("01-11-2018");
        order3.setCustomer(saveCustomer3);
        Order1 saveOrder3 = order1Repository.save(order3);

        Order1 order4 = new Order1();
        order4.setPrice(700);
        order4.setDateCreated("05-11-2018");
        order4.setCustomer(saveCustomer4);
        Order1 saveOrder4 = order1Repository.save(order4);

        Order1 order5 = new Order1();
        order5.setPrice(900);
        order5.setDateCreated("05-11-2018");
        order5.setCustomer(saveCustomer5);
        Order1 saveOrder5 = order1Repository.save(order5);

        //Item-------------------------------------------------------------------------
        Item item1 = new Item();
        item1.setItemName("Iphone X");
        item1.setAmount(1);
        item1.setCost(3000);
        item1.setOrder1(saveOrder1);
        item1.setProduct(saveProduct1);
        Item saveItem1 = itemRepository.save(item1);

        Item item11 = new Item();
        item11.setItemName("Samsung J7");
        item11.setAmount(1);
        item11.setCost(2500);
        item11.setOrder1(saveOrder1);
        item11.setProduct(saveProduct1);
        Item saveItem11 = itemRepository.save(item11);

        Item item12 = new Item();
        item12.setItemName("Iphone 7");
        item12.setAmount(1);
        item12.setCost(1250);
        item12.setOrder1(saveOrder1);
        item12.setProduct(saveProduct1);
        Item saveItem12 = itemRepository.save(item12);

        Item item2 = new Item();
        item2.setItemName("T-shirt Bape");
        item2.setAmount(2);
        item2.setCost(150);
        item2.setOrder1(saveOrder2);
        item2.setProduct(saveProduct2);
        Item saveItem2 = itemRepository.save(item2);

        Item item21 = new Item();
        item21.setItemName("T-shirt HNBMG");
        item21.setAmount(4);
        item21.setCost(450);
        item21.setOrder1(saveOrder2);
        item21.setProduct(saveProduct2);
        Item saveItem21 = itemRepository.save(item21);

        Item item22 = new Item();
        item22.setItemName("T-shirt HFWTH");
        item22.setAmount(3);
        item22.setCost(560);
        item22.setOrder1(saveOrder2);
        item22.setProduct(saveProduct2);
        Item saveItem22 = itemRepository.save(item22);

        Item item3 = new Item();
        item3.setItemName("The Infinity War 3");
        item3.setAmount(1);
        item3.setCost(150);
        item3.setOrder1(saveOrder3);
        item3.setProduct(saveProduct3);
        Item saveItem3 = itemRepository.save(item3);

        Item item31 = new Item();
        item31.setItemName("The NUN");
        item31.setAmount(1);
        item31.setCost(250);
        item31.setOrder1(saveOrder3);
        item31.setProduct(saveProduct3);
        Item saveItem31 = itemRepository.save(item31);

        Item item4 = new Item();
        item4.setItemName("Winter Business School Book");
        item4.setAmount(1);
        item4.setCost(450);
        item4.setOrder1(saveOrder4);
        item4.setProduct(saveProduct4);
        Item saveItem4 = itemRepository.save(item4);

        Item item41 = new Item();
        item41.setItemName("Grand Ecole Program Book");
        item41.setAmount(2);
        item41.setCost(550);
        item41.setOrder1(saveOrder4);
        item41.setProduct(saveProduct4);
        Item saveItem41 = itemRepository.save(item41);

        Item item5 = new Item();
        item5.setItemName("Java Spring Boot");
        item5.setAmount(3);
        item5.setCost(700);
        item5.setOrder1(saveOrder5);
        item5.setProduct(saveProduct5);
        Item saveItem5 = itemRepository.save(item5);

        Item item51 = new Item();
        item51.setItemName("React JS Course");
        item51.setAmount(5);
        item51.setCost(1200);
        item51.setOrder1(saveOrder5);
        item51.setProduct(saveProduct5);
        Item saveItem51 = itemRepository.save(item51);

        //Rating-------------------------------------------------------------------------
        Rating rating1 = new Rating();
        rating1.setRatingCount(3.5);
        rating1.setAccount(saveAccount1);
        rating1.setItem(saveItem1);
        ratingRepository.save(rating1);

        Rating rating11 = new Rating();
        rating11.setRatingCount(4.1);
        rating11.setAccount(saveAccount2);
        rating11.setItem(saveItem11);
        ratingRepository.save(rating11);

        Rating rating12 = new Rating();
        rating12.setRatingCount(5.0);
        rating12.setAccount(saveAccount3);
        rating12.setItem(saveItem12);
        ratingRepository.save(rating12);

        Rating rating2 = new Rating();
        rating2.setRatingCount(1.5);
        rating2.setAccount(saveAccount2);
        rating2.setItem(saveItem2);
        ratingRepository.save(rating2);

        Rating rating21 = new Rating();
        rating21.setRatingCount(2.5);
        rating21.setAccount(saveAccount2);
        rating21.setItem(saveItem21);
        ratingRepository.save(rating21);

        Rating rating22 = new Rating();
        rating22.setRatingCount(3.3);
        rating22.setAccount(saveAccount2);
        rating22.setItem(saveItem22);
        ratingRepository.save(rating22);

        Rating rating3 = new Rating();
        rating3.setRatingCount(4.5);
        rating3.setAccount(saveAccount3);
        rating3.setItem(saveItem3);
        ratingRepository.save(rating3);

        Rating rating31 = new Rating();
        rating31.setRatingCount(3.6);
        rating31.setAccount(saveAccount3);
        rating31.setItem(saveItem31);
        ratingRepository.save(rating31);

        Rating rating4 = new Rating();
        rating4.setRatingCount(2.5);
        rating4.setAccount(saveAccount4);
        rating4.setItem(saveItem4);
        ratingRepository.save(rating4);

        Rating rating41 = new Rating();
        rating41.setRatingCount(3.5);
        rating41.setAccount(saveAccount4);
        rating41.setItem(saveItem41);
        ratingRepository.save(rating41);

        Rating rating5 = new Rating();
        rating5.setRatingCount(5.0);
        rating5.setAccount(saveAccount5);
        rating5.setItem(saveItem5);
        ratingRepository.save(rating5);

        Rating rating51 = new Rating();
        rating51.setRatingCount(4.2);
        rating51.setAccount(saveAccount5);
        rating51.setItem(saveItem51);
        ratingRepository.save(rating51);
    }
}
