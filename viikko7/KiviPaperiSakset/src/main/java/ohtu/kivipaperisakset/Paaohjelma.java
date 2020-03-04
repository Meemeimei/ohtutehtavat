package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            tulostaOhjeet();
            
            String vastaus = scanner.nextLine();
            Pelioperaatio pelioperaatio = new Pelioperaatio() {
                @Override
                protected void pelaa() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            
            if (vastaus.endsWith("a")) {
                tulostaPeliohjeet();
                pelioperaatio.getKPSPelaajaVsPelaaja().pelaa();
            } else if (vastaus.endsWith("b")) {
                tulostaPeliohjeet();
                pelioperaatio.KPSTekoaly().pelaa();
            } else if (vastaus.endsWith("c")) {
                tulostaPeliohjeet();
                pelioperaatio.KPSParempiTekoaly().pelaa();
            } else {
                break;
            }
        }
    }
    
    private static void tulostaPeliohjeet() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }
    
    private static void tulostaOhjeet() {
        System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
    }
}
