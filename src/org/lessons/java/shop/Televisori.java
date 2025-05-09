package org.lessons.java.shop;

import java.math.BigDecimal;

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

    public Televisori(int code, String name, String brand, BigDecimal price, BigDecimal iva, BigDecimal screenSize,
            boolean isSmart) {
        super(code, name, brand, price, iva);
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

}
