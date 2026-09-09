/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.service;

/**
 *
 * @author jxsxs
 */

import com.gamezone.model.Product;
import com.gamezone.model.Return;
import com.gamezone.model.Sale;
import com.gamezone.persistence.ReturnRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ReturnService {

    private final ReturnRepository returnRepository;
    private final SaleService saleService;
    private final ProductService productService;

    public ReturnService(ReturnRepository returnRepository, SaleService saleService,
                          ProductService productService) {
        this.returnRepository = returnRepository;
        this.saleService = saleService;
        this.productService = productService;
    }

  
    public Return registerReturn(String saleId, List<String> productIds, String reason) {
        Sale sale = saleService.findById(saleId);
        if (sale == null) {
            throw new IllegalArgumentException("The specified sale does not exist.");
        }

        if (!sale.canBeReturned()) {
            throw new IllegalArgumentException(
                    "The return cannot be registered: more than 30 days have passed since the sale.");
        }

        List<Product> returnedProducts = new ArrayList<>();
        for (String productId : productIds) {
            Product product = findProductInSale(sale, productId);
            if (product == null) {
                throw new IllegalArgumentException(
                        "The Product " + productId + " It does not belong to the indicated sale.");
            }
            returnedProducts.add(product);
        }

        Return newReturn = new Return(
                UUID.randomUUID().toString(),
                LocalDate.now(),
                sale,
                returnedProducts,
                reason);
        newReturn.calculateRefundAmount();

        for (Product product : returnedProducts) {
            productService.restoreStock(product.getId(), 1);
        }

        List<Return> allReturns = returnRepository.loadAll();
        allReturns.add(newReturn);
        returnRepository.saveAll(allReturns);

        return newReturn;
    }

    public List<Return> viewAllReturns() {
        return returnRepository.loadAll();
    }

    public List<Return> viewReturnsByCustomer(String customerId) {
        List<Return> result = new ArrayList<>();
        for (Return r : returnRepository.loadAll()) {
            if (r.getOriginalSale().getCustomerId().equals(customerId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<Return> viewReturnsBySale(String saleId) {
        List<Return> result = new ArrayList<>();
        for (Return r : returnRepository.loadAll()) {
            if (r.getOriginalSale().getId().equals(saleId)) {
                result.add(r);
            }
        }
        return result;
    }

    
    public double generateMonthlyBalance(int month, int year) {
        double totalSales = 0.0;
        for (Sale sale : saleService.listAllSales()) {
            if (sale.getDate().getMonthValue() == month && sale.getDate().getYear() == year) {
                totalSales += sale.getTotal();
            }
        }

        double totalReturns = 0.0;
        for (Return r : returnRepository.loadAll()) {
            if (r.getReturnDate().getMonthValue() == month && r.getReturnDate().getYear() == year) {
                totalReturns += r.getRefundAmount();
            }
        }

        return totalSales - totalReturns;
    }

    private Product findProductInSale(Sale sale, String productId) {
        for (Product product : sale.getProducts()) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
