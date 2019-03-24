package com.vend.pathum.model;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Objects;

public class LineItem extends Base{
    private Product product;
    private int noOfProducts;

    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal lineTotal;

    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal discountProportion;

    public LineItem() {
    }

    public LineItem(Product product, int noOfProducts, BigDecimal lineTotal, BigDecimal discountProportion) {
        super();
        this.product = product;
        this.noOfProducts = noOfProducts;
        this.lineTotal = lineTotal;
        this.discountProportion = discountProportion;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNoOfProducts() {
        return noOfProducts;
    }

    public void setNoOfProducts(int noOfProducts) {
        this.noOfProducts = noOfProducts;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }

    public BigDecimal getDiscountProportion() {
        return discountProportion;
    }

    public void setDiscountProportion(BigDecimal discountProportion) {
        this.discountProportion = discountProportion;
    }



    @Override
    public int hashCode() {
        return Objects.hash(product, noOfProducts, lineTotal, discountProportion);
    }
}
