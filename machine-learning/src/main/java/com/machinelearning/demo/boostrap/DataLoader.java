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
    private final OrderRepository orderRepository;

    public DataLoader(CategoryRepository categoryRepository, ProductRepository productRepository, AccountRepository accountRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
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
        accountRepository.save(account1);
    }
}
