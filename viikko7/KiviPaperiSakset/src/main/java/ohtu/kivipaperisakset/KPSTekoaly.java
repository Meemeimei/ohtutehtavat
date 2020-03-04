package ohtu.kivipaperisakset;

public class KPSTekoaly extends Pelioperaatio {

    public void peli() {

    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        Tekoaly tekoaly = new Tekoaly();

        peli(tuomari, tekoaly, null);
    }
}
