package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Pelioperaatio {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void peli(Tuomari tuomari, Tekoaly tekoaly, TekoalyParannettu tekoalyParannettu) {
        while(true) {
            if (!tuomaroi(tuomari, tekoaly, null)) {
                break;
            }
        }

        tuomari.tulostaLopetus();
    }
    
    public boolean tuomaroi(Tuomari tuomari, Tekoaly tekoaly, TekoalyParannettu tekoalyParannettu) {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = SCANNER.nextLine();

        String tokanSiirto;

        if (tekoaly == null && tekoalyParannettu == null) {
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = SCANNER.nextLine();
        } else {
            if (tekoaly != null) {
                tokanSiirto = tekoaly.annaSiirto();
                System.out.println("Tietokone valitsi: " + tokanSiirto);
            } else {
                tokanSiirto = tekoalyParannettu.annaSiirto();
                if (!tekoalyParannettu.onkoEkaSiirto()) {
                    tekoalyParannettu.asetaSiirto(ekanSiirto);
                }
            }
        }

        if (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            return true;
        }
        return false;
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract void pelaa();
    
    public Pelioperaatio getKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public Pelioperaatio KPSTekoaly() {
        return new KPSTekoaly();
    }
    
    public Pelioperaatio KPSParempiTekoaly() {
        return new KPSParempiTekoaly();
    }

}
