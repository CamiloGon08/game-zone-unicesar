/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jxsxs
 */



public class Return {
    
    private final String id;
    private final LocalDate returnDate;
    private final Sale originalSale;
    private final List<Product> returnedProducts;
    private final String reason;
    private double refundAmount;
    
    public Return (String  id, LocalDate returnDate, Sale originalSale, List<Product> returnedProducts, String reason){
        this.id = id;
        this.originalSale= originalSale;
        this.reason= reason;
        this.returnDate= returnDate;
        this.returnedProducts = returnedProducts;
        
    }

    
    public String getId() {
        return id;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Sale getOriginalSale() {
        return originalSale;
    }

    public List<Product> getReturnedProducts() {
        return returnedProducts;
    }

    public String getReason() {
        return reason;
    }

    public double getRefundAmount() {
        return refundAmount;
    }
    
    public double calculateRefundAmount(){
         double total = 0.0;
        for (Product product : returnedProducts) {
            total += product.getPrice();
        }
        this.refundAmount = total;
        return total;
    }
    
    public String generateReturnReceipt(){
           StringBuilder receipt = new StringBuilder();
        receipt.append("Devolución: ").append(id).append("\n");
        receipt.append("Fecha: ").append(returnDate).append("\n");
        receipt.append("Venta original: ").append(originalSale.getId()).append("\n");
        receipt.append("Productos devueltos:\n");
        for (Product product : returnedProducts) {
            receipt.append("  - ").append(product.getTitle())
                   .append(" ($").append(product.getPrice()).append(")\n");
        }
        receipt.append("Motivo: ").append(reason).append("\n");
        receipt.append("Monto reembolsado: $").append(refundAmount).append("\n");
        return receipt.toString();
    }
    
}
