package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuffie extends Prodotto {

    // Context: Attributes
    private String color;
    private boolean isWireless;

    // Context: Methods

    // Context: Constructors
    public Cuffie() {
        this.color = "";
        this.isWireless = false;
    }

    public Cuffie(String name, String brand, BigDecimal price, BigDecimal iva, String color,
            boolean isWireless) {
        super(name, brand, price, iva);
        this.color = color;
        this.isWireless = isWireless;
    }

    // Context: Getters
    public String getColor() {
        return this.color;
    }

    public boolean getIsWireless() {
        return this.isWireless;
    }

    // Context: Setters
    public void setColor(String color) {
        this.color = color;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    // Context: Custom Methods
    @Override
    public String toString() {
        return super.toString() + String.format(", Color: %s, Wireless: %b", this.color, this.isWireless);
    }

    @Override
    protected BigDecimal finalPrice(boolean isCoupon) {
        // Explanation: Calculate VAT accurately: (price * vat) / 100
        BigDecimal taxedPrice = this.price.add(this.price.multiply(this.iva.divide(BigDecimal.valueOf(100))));

        // Explanation: Check isWireless and isCoupon
        if (isCoupon && this.isWireless) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.02));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else if (isCoupon && !this.isWireless) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.07));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else {
            // Explanation: Round the final price to two decimal places
            return taxedPrice.setScale(2, RoundingMode.HALF_UP);
        }
    }
}
