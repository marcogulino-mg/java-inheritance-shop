package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Context: Class Instances
        // Note: Prodotto
        Prodotto empty = new Prodotto();
        Prodotto prodotto01 = new Prodotto(10, "Nome Prodotto", "Nome Brand", new BigDecimal(20.30),
                new BigDecimal(22));

        // Note: Smartphone
        Smartphone emptySmartphone = new Smartphone();
        Smartphone smartphone01 = new Smartphone(12, "Samsung Galaxy S25", "Samsung", new BigDecimal(899.99),
                new BigDecimal(22), "352099001761487", new BigDecimal(256));

        // Context: Methods
        // Note: Print Products Info
        System.out.println(empty.toString());
        System.out.println(prodotto01.toString());

        // Note: Print Smartphones Info
        System.out.println(emptySmartphone.toString());
        System.out.println(smartphone01.toString());
    }
}
