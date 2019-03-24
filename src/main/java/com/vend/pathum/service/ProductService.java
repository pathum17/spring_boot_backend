package com.vend.pathum.service;

import com.vend.pathum.exception.ApplicationException;
import com.vend.pathum.model.Product;
import com.vend.pathum.model.ProductsRequest;
import com.vend.pathum.repository.ProductRepository;
import org.springframework.stereotype.Service;
import sun.applet.AppletIOException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public List<Product> getAllProducts(){
       return ProductRepository.getInstance().getProductList();
    }

    public void addProduct(ProductsRequest productsRequest) throws ApplicationException {
        List<Product> productList = getAllProducts();

        Optional<Product> matchingObject = productList.stream().
                filter(p -> p.getProductName().equals(productsRequest.getProduct().getProductName())).
                findFirst();
        Product matchingProduct = matchingObject.orElse(null);

        if (matchingProduct == null) {
            int currentMaxProductId = Collections.max(productList, Comparator.comparing(prod -> prod.getProductId())).getProductId();
            productsRequest.getProduct().setProductId(currentMaxProductId + 1);
            ProductRepository.getInstance().getProductRepo().put(productsRequest.getProduct(), productsRequest.getQuantity());
        }else {
            throw new ApplicationException("Product already exists.");
        }
    }
}
