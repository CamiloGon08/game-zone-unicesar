package com.gamezone;

import com.gamezone.persistence.ProductRepository;
import com.gamezone.persistence.SaleRepository;
import com.gamezone.service.PersonService;
import com.gamezone.service.ProductService;
import com.gamezone.service.SaleService;
import com.gamezone.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository("data/products.txt");
        ProductService productService = new ProductService(productRepository);

        PersonService personService = new PersonService();

        SaleRepository saleRepository = new SaleRepository();
        SaleService saleService = new SaleService(saleRepository);

        ConsoleMenu menu = new ConsoleMenu(productService, personService, saleService);
        menu.start();
    }
}