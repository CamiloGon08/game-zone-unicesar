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

        public void start() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int option = readInt();
            switch (option) {
                case 1 -> registerVideoGame();
                case 2 -> registerConsole();
                case 3 -> listProducts();
                case 4 -> registerClient();
                case 5 -> listClients();
                case 6 -> listSellers();
                case 7 -> registerSale();
                case 8 -> viewAllSales();
                case 9 -> viewSalesByCustomer();
                case 10 -> viewSalesBySeller();
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMainMenu() {
        System.out.println("\n===== GameZone Unicesar =====");
        System.out.println("1. Register video game");
        System.out.println("2. Register console");
        System.out.println("3. List all products");
        System.out.println("4. Register client");
        System.out.println("5. List all clients");
        System.out.println("6. List all sellers");
        System.out.println("7. Register a new sale");
        System.out.println("8. View all sales");
        System.out.println("9. View sales by client");
        System.out.println("10. View sales by seller");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}