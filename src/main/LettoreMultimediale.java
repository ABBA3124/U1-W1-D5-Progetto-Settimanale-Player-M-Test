package main;

import entities.Audio;
import entities.ElementoMultimediale;
import entities.Immagine;
import entities.Video;
import interfaces.Riproducibile;

import java.util.Scanner;

public class LettoreMultimediale {
    private ElementoMultimediale[] elementi = new ElementoMultimediale[5];

    public static LettoreMultimediale creaLettoreMultimediale(Scanner scanner) {
        LettoreMultimediale lettore = new LettoreMultimediale();

        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci il tipo di elemento (1: Audio, 2: Video, 3: Immagine): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Per favore inserisci un numero valido (1: Audio, 2: Video, 3: Immagine): ");
                scanner.next();
            }
            int tipo = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            if (tipo == 1) {
                System.out.print("Inserisci la durata del file audio: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Per favore inserisci un numero intero valido per la durata del file audio: ");
                    scanner.next();
                }
                int durata = scanner.nextInt();

                System.out.print("Inserisci il volume del file audio: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Per favore inserisci un numero intero valido per il volume del file audio: ");
                    scanner.next();
                }
                int volume = scanner.nextInt();
                lettore.aggiungiElemento(i, new Audio(titolo, durata, volume));
            } else if (tipo == 2) {
                System.out.print("Inserisci la durata del file video: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Per favore inserisci un numero intero valido per la durata del file video: ");
                    scanner.next();
                }
                int durata = scanner.nextInt();

                System.out.print("Inserisci il volume del file video: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Per favore inserisci un numero intero valido per il volume del file video: ");
                    scanner.next();
                }
                int volume = scanner.nextInt();

                System.out.print("Inserisci la luminosità del file video: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Per favore inserisci un numero intero valido per la luminosità del file video: ");
                    scanner.next();
                }
                int luminosita = scanner.nextInt();
                lettore.aggiungiElemento(i, new Video(titolo, durata, volume, luminosita));
            } else if (tipo == 3) {
                System.out.print("Inserisci la luminosità del file immagine: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Per favore inserisci un numero intero valido per la luminosità del file immagine: ");
                    scanner.next();
                }
                int luminosita = scanner.nextInt();
                lettore.aggiungiElemento(i, new Immagine(titolo, luminosita));
            }
        }

        return lettore;
    }

    public void aggiungiElemento(int index, ElementoMultimediale elemento) {
        elementi[index] = elemento;
    }

    public void esegui(int scelta) {
        if (scelta > 0 && scelta <= 5) {
            ElementoMultimediale elemento = elementi[scelta - 1];
            if (elemento instanceof Riproducibile) {
                ((Riproducibile) elemento).play();
            } else if (elemento instanceof Immagine) {
                ((Immagine) elemento).show();
            }
        }
    }
}
