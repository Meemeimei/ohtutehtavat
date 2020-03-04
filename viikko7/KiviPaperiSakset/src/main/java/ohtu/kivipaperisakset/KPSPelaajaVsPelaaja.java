package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Pelioperaatio {

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        peli(tuomari, null, null);
    }
}