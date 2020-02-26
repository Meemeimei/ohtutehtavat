package ohtu.intjoukkosovellus;

import java.util.ArrayList;

public class IntJoukko {

    private ArrayList<Integer> joukonLuvut;

    public IntJoukko() {
        joukonLuvut = new ArrayList<>();
    }

    public IntJoukko(int a) {
        joukonLuvut = new ArrayList<>();
    }

    public IntJoukko(int a, int b) {
        joukonLuvut = new ArrayList<>();
    }

    public boolean lisaa(int luku) {
        if (joukonLuvut.contains(luku)) {
            return false;
        }
        joukonLuvut.add(luku);
        return true;

    }

    public boolean kuuluu(int luku) {
        if (joukonLuvut.contains(luku)) {
            return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        if (joukonLuvut.remove(Integer.valueOf(luku))) {
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    @Override
    public String toString() {
        if (joukonLuvut.isEmpty()) {
            return "{}";
        }
        String returnString = "{";
        for (int i : joukonLuvut) {
            if (joukonLuvut.indexOf(i) == joukonLuvut.size() - 1) {
                returnString += i + "}";
            } else {
                returnString += i + ", ";
            }
        }
        return returnString;

    }

    public int mahtavuus() {
        return joukonLuvut.size();
    }

    public int[] toIntArray() {
        int[] returnArray = new int[joukonLuvut.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = joukonLuvut.get(i);
        }
        return returnArray;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko palaute = new IntJoukko();
        for (int i : a.joukonLuvut) {
            palaute.joukonLuvut.add(i);
        }
        for (int i : b.joukonLuvut) {
            palaute.joukonLuvut.add(i);
        }
        return palaute;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko palaute = new IntJoukko();
        for (int i : a.joukonLuvut) {
            if (b.joukonLuvut.contains(i)) {
                palaute.joukonLuvut.add(i);
            }
        }
        return palaute;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko palaute = new IntJoukko();
        for (int i : a.joukonLuvut) {
            if (!b.joukonLuvut.contains(i)) {
                palaute.joukonLuvut.add(i);
            }
        }
        return palaute;
    }

}
