/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.persistence;

/**
 *
 * @author jxsxs
 */

import com.gamezone.service.ProductService;
import com.gamezone.service.SaleService;




public class ReturnRepository {

    private static final String FILE_PATH = "data/returns.csv";

    private final SaleService saleService;
    private final ProductService productService;

    public ReturnRepository(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

  
}

