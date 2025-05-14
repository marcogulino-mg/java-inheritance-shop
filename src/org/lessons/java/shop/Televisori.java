package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Televisori extends Prodotto {

    // Context: Attributes
    private BigDecimal screenSize;
    private boolean isSmart;

    // Context: Methods

    // Context: Constructors
    public Televisori() {
        this.screenSize = new BigDecimal(0);
        this.isSmart = false;
    }

    public Televisori(String name, String brand, BigDecimal price, BigDecimal iva, BigDecimal screenSize,
            boolean isSmart) {
        super(name, brand, price, iva);
        this.screenSize = screenSize;
        this.isSmart = isSmart;
    }

    // Context: Getters
    public BigDecimal getScreenSize() {
        return this.screenSize;
    }

    public boolean getIsSmart() {
        return this.isSmart;
    }

    // Context: Setters
    public void setScreenSize(BigDecimal screenSize) {
        this.screenSize = screenSize;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    // Context: Custom Methods
    @Override
    public String toString() {
        return super.toString() + String.format(", Screen Size: %.2f, Smart TV: %b", this.screenSize, this.isSmart);
    }

    @Override
    protected BigDecimal finalPrice(boolean isCoupon) {
        // Explanation: Calculate VAT accurately: (price * vat) / 100
        BigDecimal taxedPrice = this.price.add(this.price.multiply(this.iva.divide(BigDecimal.valueOf(100))));

        // Explanation: Check isSmart and isCoupon
        if (isCoupon && this.isSmart) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.02));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else if (isCoupon && !this.isSmart) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.10));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else {
            // Explanation: Round the final price to two decimal places
            return taxedPrice.setScale(2, RoundingMode.HALF_UP);
        }
    }
}
