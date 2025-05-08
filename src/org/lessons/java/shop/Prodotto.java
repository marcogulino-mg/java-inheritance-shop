package org.lessons.java.shop;

import java.math.BigDecimal;

public class Prodotto {

    // Context: Attributes
    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal iva;

    // Context: Methods

    // Context: Constructors
    public Prodotto() {
        this.code = 0;
        this.name = "";
        this.brand = "";
        this.price = new BigDecimal(0);
        this.iva = new BigDecimal(0);
    }

    public Prodotto(int code, String name, String brand, BigDecimal price, BigDecimal iva) {
        this.code = code;
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
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getIva() {
        return iva;
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
        return String.format("Info Product| Code: %d, Name: %s, Brand: %s, Price: %.2f, IVA: %.2f;", this.code,
                this.name,
                this.brand, this.price, this.iva);
    }
}
