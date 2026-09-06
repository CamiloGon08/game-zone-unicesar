package com.gamezone.persistence;

import com.gamezone.model.Sale;

public class SaleRepository {
    private static final String FILE_PATH = "data/sales.txt";

    private String toLine(Sale sale){
        StringBuilder productNames = new StringBuilder();
        List<Product> = sale.getProducts();
        for (int i = 0; i < products.size(); i++) {
            if(i > 0){
                productNames.append(";");
            }
            productNames.append(products.get(1).getTitle());
        }
        return sale.getId()+ "," + sale.getDate()+ ","
        + sale.getCustomer().getName()+ "," + sale.getSeller().getName()+
        "," +productNames+ "," +sale.getTotal();
    }
}
