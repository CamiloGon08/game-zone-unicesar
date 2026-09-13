    /*
    * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
    */
    package com.gamezone.service;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    import com.gamezone.model.Console;
    import com.gamezone.model.Product;
    import com.gamezone.model.VideoGame;
    import com.gamezone.persistence.ProductRepository;


    public class ProductService {

        private final ProductRepository productRepository;
        private final List<Product> products;

       
        public ProductService(ProductRepository productRepository) {
            this.productRepository = productRepository;
            this.products = new ArrayList<>(productRepository.loadAll());
        }

    
        public void registerVideoGame(String id, String title, double price, int stock,
                                    String platform, String genre, String ageRating) {
            addProduct(new VideoGame(id, title, price, stock, platform, genre, ageRating));
        }

        
        public void registerConsole(String id, String title, double price, int stock,
                                    String brand, String model, String generation) {
            addProduct(new Console(id, title, price, stock, brand, model, generation));
        }

        private void addProduct(Product product) {
            products.add(product);
            productRepository.saveAll(products);
        }

        
        public List<Product> listProducts() {
            return List.copyOf(products);
        }

       
        public Optional<Product> findById(String id) {
            return products.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
        }

        
        public boolean hasSufficientStock(String id, int quantity) {
            return findById(id)
                    .map(p -> p.getStock() >= quantity)
                    .orElse(false);
        }

        
        public void updateStock(String id, int amount) {
        Product product = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
        product.adjustStock(amount);   // ← le delega el cálculo al propio objeto Product
        productRepository.saveAll(products);
    }

    public void restoreStock(String id, int quantity) {
    Product product = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
                
    product.setStock(product.getStock() + quantity);
    List<Product> allProducts = productRepository.loadAll();
    
    for (int i = 0; i < allProducts.size(); i++) {
        if (allProducts.get(i).getId().equals(id)) {
            allProducts.set(i, product);
            break;
        }
    }
    productRepository.saveAll(allProducts);
}

    }
