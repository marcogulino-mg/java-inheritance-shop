package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Context: Class Instances
        Prodotto empty = new Prodotto();
        Prodotto prodotto01 = new Prodotto(10, "Nome Prodotto", "Nome Brand", new BigDecimal(20.30),
                new BigDecimal(22));

        // Context: Methods
        // Note: Print Product Info
        System.out.println(empty.toString());
        System.out.println(prodotto01.toString());
    }
}
