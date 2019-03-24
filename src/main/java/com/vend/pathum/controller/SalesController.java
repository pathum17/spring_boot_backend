package com.vend.pathum.controller;

import com.vend.pathum.exception.ApplicationException;
import com.vend.pathum.model.*;
import com.vend.pathum.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/sales")
    public ApiResponse<SaleResponse>  makeSale(@RequestBody SaleRequest saleRequest){
        try{
            SaleResponse saleResponse = saleService.makeSale(saleRequest);
            return new ApiResponse<>(HttpStatus.OK.value(), "Added Product to the repository.", saleResponse);

        }catch (ApplicationException aex) {
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), aex.getMessage(), saleRequest);
        }



    }
}
