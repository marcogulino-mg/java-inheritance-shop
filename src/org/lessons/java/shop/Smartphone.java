package org.lessons.java.shop;

import java.math.BigDecimal;

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

    public Smartphone(int code, String name, String brand, BigDecimal price, BigDecimal iva, String imei,
            BigDecimal storageCapacity) {
        super(code, name, brand, price, iva);
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
}
