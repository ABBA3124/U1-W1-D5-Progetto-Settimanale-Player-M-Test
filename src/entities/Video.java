package entities;

import interfaces.Luminosita;
import interfaces.Riproducibile;

public class Video extends ElementoMultimediale implements Riproducibile, Luminosita {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }


    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }

    @Override
    public void abbassaVolume() {
        volume--;
    }

    @Override
    public void alzaVolume() {
        volume++;
    }

    @Override
    public void aumentaLuminosita() {
        luminosita++;
    }

    @Override
    public void diminuisciLuminosita() {
        luminosita--;
    }
}
