package com.dsevoluction.sales.test;

import com.dsevoluction.sales.entities.Cliente;
import com.dsevoluction.sales.entities.ItemOrder;
import com.dsevoluction.sales.entities.Order;
import com.dsevoluction.sales.entities.Product;
import com.dsevoluction.sales.repositories.ClienteRepository;
import com.dsevoluction.sales.repositories.ItemOrderRepository;
import com.dsevoluction.sales.repositories.OrderRepository;
import com.dsevoluction.sales.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiations implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    @Override
    public void run(String... args) throws Exception {

        Cliente cli1 = new Cliente(null, "douglas");
        Cliente cli2 = new Cliente(null, "Bruno");
        Cliente cli3 = new Cliente(null, "Goiaba");

        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));


        Product p1 = new Product(null, "auto-ajuda", 100.0);
        Product p2 = new Product(null, "iphone 14", 1000.0);
        Product p3 = new Product(null, "apple watch", 2500.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
