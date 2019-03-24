package com.vend.pathum.service;

import com.vend.pathum.exception.ApplicationException;
import com.vend.pathum.model.LineItem;
import com.vend.pathum.model.Product;
import com.vend.pathum.model.SaleRequest;
import com.vend.pathum.model.SaleResponse;
import com.vend.pathum.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {


    public SaleResponse makeSale(SaleRequest saleRequest) throws ApplicationException{
        Map<Product, Integer> productRepo = ProductRepository.getInstance().getProductRepo();
        List<LineItem> lineItems = saleRequest.getLineItems();

        SaleResponse saleResponse = new SaleResponse();
        BigDecimal totalSale = new BigDecimal(0);
        BigDecimal totalDiscount = new BigDecimal(0);
//        for (LineItem lineItem : lineItems) {
//            Product product = lineItem.getProduct();
//            if (productRepo.containsKey(product)) {
//                int currentNoOfProducts = productRepo.get(product);
//                int noOfItemsAfterSale = currentNoOfProducts - lineItem.getNoOfProducts();
//                productRepo.put(product, noOfItemsAfterSale);
//            }
//        }

        for (LineItem lineItem : lineItems) {
            Product product = lineItem.getProduct();
            if (productRepo.containsKey(product)) {
                Product productToSale = productRepo.keySet().stream().filter(c -> c.getProductName().equals(lineItem.getProduct().getProductName())).findFirst().get();
                int currentNoOfProducts = productRepo.get(product);
                if (currentNoOfProducts > 0) {
                    int noOfItemsAfterSale = currentNoOfProducts - lineItem.getNoOfProducts();
                    productRepo.put(product, noOfItemsAfterSale);
                    BigDecimal lineItemTotal = ((new BigDecimal(lineItem.getNoOfProducts()).multiply(productToSale.getProductPrice()).multiply(new BigDecimal(100).subtract(saleRequest.getDiscountPercentage())))).divide(new BigDecimal(100));
                    BigDecimal lineItemDiscountProportion =
                            ((saleRequest.getDiscountPercentage().multiply(new BigDecimal(lineItem.getNoOfProducts())).multiply(productToSale.getProductPrice()))).divide(new BigDecimal(100));
                    totalSale = totalSale.add(((new BigDecimal(lineItem.getNoOfProducts()).multiply(productToSale.getProductPrice()).multiply(new BigDecimal(100).subtract(saleRequest.getDiscountPercentage())))).divide(new BigDecimal(100)));

                    totalDiscount = totalDiscount.add(((saleRequest.getDiscountPercentage().multiply(new BigDecimal(lineItem.getNoOfProducts())).multiply(productToSale.getProductPrice()))).divide(new BigDecimal(100)));
                }else{
                    throw new ApplicationException("Product not available");
                }
            }
        }


        // create correct sales response and return
        saleResponse.setLineItems(lineItems);
        saleResponse.setSaleTotal(totalSale);
        saleResponse.setTotalDiscount(totalDiscount);
        return saleResponse;

    }
}
