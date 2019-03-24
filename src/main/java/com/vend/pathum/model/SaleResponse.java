package com.vend.pathum.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class SaleResponse {
    private static final DecimalFormat FORMAT = new DecimalFormat("$#.00");
    private List<LineItem> lineItems;

    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal saleTotal;

    public SaleResponse() {
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(BigDecimal saleTotal) {
        this.saleTotal = saleTotal;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal totalDiscount;



}
