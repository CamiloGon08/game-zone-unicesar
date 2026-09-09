package com.gamezone.ui;

import java.util.Scanner;

import com.gamezone.service.PersonService;
import com.gamezone.service.ProductService;
import com.gamezone.service.SaleService;

public class ConsoleMenu {

    private final Scanner scanner;
    private final ProductService productService;
    private final PersonService personService;
    private final SaleService saleService;

    public ConsoleMenu(ProductService productService, PersonService personService, SaleService saleService) {
        this.scanner = new Scanner(System.in);
        this.productService = productService;
        this.personService = personService;
        this.saleService = saleService;
    }
}