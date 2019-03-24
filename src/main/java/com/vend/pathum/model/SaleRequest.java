package com.vend.pathum.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class SaleRequest extends Base{
    private List<LineItem> lineItems;
    private BigDecimal discountPercentage;


    public SaleRequest() {
    }

    public SaleRequest(List<LineItem> lineItems) {
        super();
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleRequest that = (SaleRequest) o;
        return Objects.equals(lineItems, that.lineItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineItems);
    }
}
