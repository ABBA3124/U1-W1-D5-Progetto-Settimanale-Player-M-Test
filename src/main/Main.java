package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LettoreMultimediale lettore = LettoreMultimediale.creaLettoreMultimediale(scanner);

        while (true) {
            System.out.print("Inserisci un numero da 1 a 5 per eseguire un elemento, oppure 0 per uscire: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Per favore inserisci un numero valido da 1 a 5, oppure 0 per uscire: ");
                scanner.next();
            }
            int scelta = scanner.nextInt();
            if (scelta == 0) {
                break;
            }
            lettore.esegui(scelta);
        }

        scanner.close();
    }
}
