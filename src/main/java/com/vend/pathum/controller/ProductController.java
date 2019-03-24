package com.vend.pathum.controller;

import com.vend.pathum.VendApplication;
import com.vend.pathum.exception.ApplicationException;
import com.vend.pathum.model.ApiResponse;
import com.vend.pathum.model.Product;
import com.vend.pathum.model.ProductsRequest;
import com.vend.pathum.repository.ProductRepository;
import com.vend.pathum.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ApiResponse<List<Product>> getAllProducts() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Returning All Products.", productService.getAllProducts());

    }

    @PostMapping("/products")
    public ApiResponse<Product> addProduct(@RequestBody ProductsRequest productsRequest) {
        try {
            productService.addProduct(productsRequest);
            logger.info("Added Product to the repository.");
        } catch (ApplicationException aex) {
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), aex.getMessage(), productsRequest);
        }

        return new ApiResponse<>(HttpStatus.OK.value(), "Added Product to the repository.", productService.getAllProducts());

    }
}
