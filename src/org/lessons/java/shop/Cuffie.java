package org.lessons.java.shop;

import java.math.BigDecimal;

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

    public Cuffie(int code, String name, String brand, BigDecimal price, BigDecimal iva, String color,
            boolean isWireless) {
        super(code, name, brand, price, iva);
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
}
