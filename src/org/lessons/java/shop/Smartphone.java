package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphone extends Prodotto {

    // Context: Attributes
    private String imei;
    private BigDecimal storageCapacity;

    // Context: Methods

    // Context: Constructors
    public Smartphone() {
        super();
        this.imei = "000000000000000";
        this.storageCapacity = BigDecimal.ZERO;
    }

    public Smartphone(String name, String brand, BigDecimal price, BigDecimal iva, String imei,
            BigDecimal storageCapacity) {
        super(name, brand, price, iva);
        this.imei = imei;
        this.storageCapacity = storageCapacity;
    }

    // Context: Getters
    public String getImei() {
        return this.imei;
    }

    public BigDecimal getStorageCapacity() {
        return this.storageCapacity;
    }

    // Context: Setters
    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setStorageCapacity(BigDecimal storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    // Context: Custom Methods
    @Override
    public String toString() {
        return super.toString()
                + String.format(", IMEI: %s, Storage Capacity: %.2fGB", this.imei, this.storageCapacity);
    }

    @Override
    protected BigDecimal finalPrice(boolean isCoupon) {
        // Explanation: Calculate VAT accurately: (price * vat) / 100
        BigDecimal taxedPrice = this.price.add(this.price.multiply(this.iva.divide(BigDecimal.valueOf(100))));

        // Explanation: Check storageCapacity and isCoupon
        if (isCoupon && this.storageCapacity.compareTo(BigDecimal.valueOf(32)) >= 0) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.02));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else if (isCoupon && this.storageCapacity.compareTo(BigDecimal.valueOf(32)) == -1) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.05));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else {
            // Explanation: Round the final price to two decimal places
            return taxedPrice.setScale(2, RoundingMode.HALF_UP);
        }
    }

}
