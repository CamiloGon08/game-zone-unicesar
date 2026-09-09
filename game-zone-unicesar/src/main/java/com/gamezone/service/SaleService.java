package com.gamezone.service;

import java.time.LocalDate;
import java.util.List;

import com.gamezone.model.Client;
import com.gamezone.model.Product;
import com.gamezone.model.Sale;
import com.gamezone.model.Seller;
import com.gamezone.persistence.SaleRepository;

public class SaleService {

    private SaleRepository repository;
    private List<Sale> sales;

    public SaleService(SaleRepository repository){
        this.repository = repository;
        this.sales = repository.load();
    }
    
   public Sale registerSale(Client customer, Seller seller, List<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("A sale must contain at least one product.");
        }

        // Validate stock for each product
        for (Product product : products) {
            if (product.getStock() <= 0) {
                throw new IllegalArgumentException("Insufficient stock for product: " + product.getTitle());
            }
        }

        // Generate a simple sale ID
        String saleId = "SALE-" + (sales.size() + 1);
        Sale sale = new Sale(LocalDate.now(), saleId, products, seller, customer);

        // Decrease stock for each purchased product
        for (Product product : products) {
            product.adjustStock(-1);  // Assumes each product line represents 1 unit
        }

        sales.add(sale);
        repository.save(sales);

        return sale;
    }


}
