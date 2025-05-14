package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

    // Context: Attributes
    protected int code;
    protected String name;
    protected String brand;
    protected BigDecimal price;
    protected BigDecimal iva;

    // Context: Methods

    // Context: Constructors
    public Prodotto() {
        this.code = 0;
        this.name = "";
        this.brand = "";
        this.price = BigDecimal.ZERO;
        this.iva = BigDecimal.ZERO;
    }

    public Prodotto(String name, String brand, BigDecimal price, BigDecimal iva) {
        this.code = codeGenerator();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.iva = iva;
    }

    // Context: Getters
    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getIva() {
        return this.iva;
    }

    // Context: Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    // Context: Custom Methods
    @Override
    public String toString() {
        return String.format("Info Product| Code: %d, Name: %s, Brand: %s, Price: %.2f, IVA: %s", this.code,
                this.name,
                this.brand, this.price, this.iva);
    }

    // Explanation: Random Code Generator (0 to 99999999)
    private int codeGenerator() {
        Random r = new Random();
        return r.nextInt(100000000);
    }

    // Explanation: Calc Final Price with IVA and Coupon Code (if true)
    protected BigDecimal finalPrice(boolean isCoupon) {
        // Explanation: Calculate VAT accurately: (price * vat) / 100
        BigDecimal taxedPrice = this.price.add(this.price.multiply(this.iva.divide(BigDecimal.valueOf(100))));

        // Explanation: Check storageCapacity and isCoupon
        if (isCoupon) {
            BigDecimal discountedPrice = taxedPrice.multiply(BigDecimal.valueOf(0.02));
            discountedPrice = taxedPrice.subtract(discountedPrice);
            return discountedPrice.setScale(2, RoundingMode.HALF_UP);
        } else {
            // Explanation: Round the final price to two decimal places
            return taxedPrice.setScale(2, RoundingMode.HALF_UP);
        }
    }

}
