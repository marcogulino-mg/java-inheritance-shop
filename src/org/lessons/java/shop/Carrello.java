package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        int choice;
        int index = 0;
        Scanner in = new Scanner(System.in);

        // Note: Read an input from the User with Scanner Class
        System.out.println("Quanti prodotti vuoi inserire?");
        int numProds = in.nextInt();

        // Note: Array of Products
        Prodotto[] prodotti = new Prodotto[numProds];

        // Note: Products Selection Menu
        do {
            System.out
                    .println("Che tipo di prodotto vuoi inserire? 1. Smartphone | 2. Televisore | 3. Cuffie | 4. Esci");

            // Note: Check in input value is an integer
            while (!in.hasNextInt()) {
                System.out.println("Errore: inserisci una scelta valida!");
                in.next(); // Scarta input non valido
                System.out.print("Riprova: ");
            }

            // Note: Save input value in choice
            choice = in.nextInt();

            if (choice == 4) {
                System.out.println("Fine Acquisti");
                break;
            }

            in.nextLine();

            // Note: Add a Product using Construct
            System.out.println("Inserisci il nome del prodotto");
            String nameProduct = in.nextLine();
            System.out.println("Inserisci il brand del prodotto");
            String brandProduct = in.nextLine();
            System.out.println("Inserisci il prezzo");
            BigDecimal priceProduct = in.nextBigDecimal();
            System.out.println("Inserisci l'IVA");
            BigDecimal iva = in.nextBigDecimal();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Inserisci l'IMEI dello Smartphone");
                    String imei = in.nextLine();
                    System.out.println("Inserisci il quantitativo di memoria dello Smartphone");
                    BigDecimal storageProduct = in.nextBigDecimal();

                    // Note: new instance of Smartphone
                    Smartphone newSmartphone = new Smartphone(nameProduct, brandProduct, priceProduct, iva, imei,
                            storageProduct);

                    // Note: Save Product in Array prodotti
                    prodotti[index] = newSmartphone;

                    index++;
                    break;

                case 2:
                    System.out.println("Inserisci i pollici del televisore");
                    BigDecimal tvScreenSize = in.nextBigDecimal();
                    System.out.println("Il televisore è una Smart TV?");
                    boolean tvSmart = in.nextBoolean();

                    // Note: new instance of Smartphone
                    Televisori newTelevison = new Televisori(nameProduct, brandProduct, priceProduct, iva, tvScreenSize,
                            tvSmart);

                    // Note: Save Product in Array prodotti
                    prodotti[index] = newTelevison;

                    index++;
                    break;

                case 3:
                    System.out.println("Inserisci il colore");
                    String color = in.nextLine();

                    System.out.println("Le cuffie sono Wireless?");
                    Boolean wireless = in.nextBoolean();

                    // Note: new instance of Smartphone
                    Cuffie newHeadphone = new Cuffie(nameProduct, brandProduct, priceProduct, iva, color,
                            wireless);

                    // Note: Save Product in Array prodotti
                    prodotti[index] = newHeadphone;

                    index++;
                    break;

                default:
                    System.out.println("Valore inserito non valido");
                    break;
            }

        } while (index < numProds);

        System.out.println("Carrello");
        for (int i = 0; i < index; i++) {
            System.out.println(prodotti[i]);
        }

        // Note: Close Scanner
        in.close();
    }
}
