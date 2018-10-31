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

    public DataLoader(CategoryRepository categoryRepository, ProductRepository productRepository, AccountRepository accountRepository, CustomerRepository customerRepository, Order1Repository order1Repository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.order1Repository = order1Repository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category();
        category1.setName("Electronic");
        category1.setDescription("This is demo Spring Framework");


        Category category2 = new Category();
        category2.setName("Clothing");
        category2.setDescription("This is demo Spring Framework");

        Category category3 = new Category();
        category3.setName("Movie");
        category3.setDescription("This is demo Spring Framework");

        Category saveCategory1 = categoryRepository.save(category1);
        Category saveCategory2 = categoryRepository.save(category2);
        Category saveCategory3 = categoryRepository.save(category3);

        Product product1 = new Product();
        product1.setName("Iphone");
        product1.setCost(3000);
        product1.setAmount(3);
        product1.setDescription("This is a smart phone");
        product1.setImage(null);
        product1.setCategory(saveCategory1);
        Product saveProduct1 = productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("T-shirt");
        product2.setCost(150);
        product2.setAmount(2);
        product2.setDescription("This is a shirt");
        product2.setImage(null);
        product2.setCategory(saveCategory2);
        Product saveProduct2 = productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("The Infinity War 3");
        product3.setCost(450);
        product3.setAmount(5);
        product3.setDescription("This is a action film");
        product3.setImage(null);
        product3.setCategory(saveCategory3);
        Product saveProduct3 = productRepository.save(product3);

        Account account1 = new Account();
        account1.setUsername("tailam");
        account1.setPassword("123");

        Account account2 = new Account();
        account2.setUsername("thunguyen");
        account2.setPassword("456");

        Account account3 = new Account();
        account3.setUsername("hocnguyen");
        account3.setPassword("789");

        Account saveAccount1 = accountRepository.save(account1);
        Account saveAccount2 = accountRepository.save(account2);
        Account saveAccount3 = accountRepository.save(account3);

        Customer customer1 = new Customer();
        customer1.setName("Tai Lam");
        customer1.setPhone("12345678");
        customer1.setEmail("tailam@gmail.com");
        customer1.setAccount(saveAccount1);
        account1.setCustomer(customer1);
        Customer saveCustomer1 = customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Thu Nguyen");
        customer2.setPhone("0909898998");
        customer2.setEmail("thunguyen@gmail.com");
        customer2.setAccount(saveAccount2);
        account2.setCustomer(customer2);
        Customer saveCustomer2 = customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setName("Tai Lam");
        customer3.setPhone("12345678");
        customer3.setEmail("tailam@gmail.com");
        customer3.setAccount(saveAccount3);
        account3.setCustomer(customer3);
        Customer saveCustomer3 = customerRepository.save(customer3);

//        Order1 order1 = new Order1();
//        order1.setPrice(200);
//        order1.setAmount(3);
//        order1.setItems(saveProduct1.getItems());
//        order1.setDateCreated("31-10-2018");
//        order1.setCustomer(saveCustomer1);
//        order1Repository.save(order1);
    }
}
