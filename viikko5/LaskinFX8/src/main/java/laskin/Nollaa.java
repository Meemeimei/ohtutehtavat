package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    TextField tuloskentta;
    TextField syotekentta;
    int aiempiLuku;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka io) {
        super(io);
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        aiempiLuku = Integer.parseInt(tuloskentta.getText());
        io.nollaa();
        tuloskentta.setText(Integer.toString(io.tulos()));
    }

    @Override
    public void peru() {
        io.plus(aiempiLuku);
        tuloskentta.setText(Integer.toString(io.tulos()));
    }
}
