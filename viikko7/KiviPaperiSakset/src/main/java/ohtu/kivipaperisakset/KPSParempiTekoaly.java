package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends Pelioperaatio {

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);

        peli(tuomari, null, tekoaly);
    }

}
