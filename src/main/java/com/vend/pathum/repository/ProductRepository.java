package com.vend.pathum.repository;

import com.vend.pathum.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class ProductRepository {
    private static ProductRepository instance;
    private static Map<Product, Integer> productRepo;

    private ProductRepository(){
        productRepo = new HashMap<>();
        productRepo.put(new Product(1, "Chrome Toaster", new BigDecimal(100)), 100);
        productRepo.put(new Product(2, "Copper Kettle", new BigDecimal(49.99)), 50);
        productRepo.put(new Product(3, "Mixing Bowl", new BigDecimal(20)), 30);

    }

    public static synchronized ProductRepository getInstance(){
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public static List<Product> getProductList() {
        return new ArrayList<Product>(productRepo.keySet());
    }

    public static Map<Product, Integer> getProductRepo() {
        return productRepo;
    }
}
