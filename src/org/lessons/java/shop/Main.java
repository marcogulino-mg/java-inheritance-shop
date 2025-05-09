package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Context: Class Instances
        // Note: Prodotto
        Prodotto empty = new Prodotto();
        Prodotto prodotto01 = new Prodotto("Nome Prodotto", "Nome Brand", new BigDecimal(20.30),
                new BigDecimal(22));

        // Note: Smartphone
        Smartphone emptySmartphone = new Smartphone();
        Smartphone smartphone01 = new Smartphone("Samsung Galaxy S25", "Samsung", new BigDecimal(899.99),
                new BigDecimal(22), "352099001761487", new BigDecimal(256));

        // Note: Televisori
        Televisori emptyTelevisori = new Televisori();
        Televisori televisori01 = new Televisori("Samsung OLED 4K 55 Pollici", "Samsung", new BigDecimal(1299.99),
                new BigDecimal(22), new BigDecimal(55), true);

        // Note: Cuffie
        Cuffie emptyCuffie = new Cuffie();
        Cuffie cuffie01 = new Cuffie("Sony WH-CH520 Wireless Headphone", "Sony", new BigDecimal(39.00),
                new BigDecimal(22), "Black", true);

        // Context: Methods
        // Note: Print Products Info
        System.out.println(empty.toString());
        System.out.println(prodotto01.toString());

        // Note: Print Smartphones Info
        System.out.println(emptySmartphone.toString());
        System.out.println(smartphone01.toString());

        // Note: Print Televisori Info
        System.out.println(emptyTelevisori.toString());
        System.out.println(televisori01.toString());

        // Note: Print Cuffie Info
        System.out.println(emptyCuffie.toString());
        System.out.println(cuffie01.toString());
    }
}
