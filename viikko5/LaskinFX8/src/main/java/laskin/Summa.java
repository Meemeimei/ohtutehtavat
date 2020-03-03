package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    TextField tuloskentta;
    TextField syotekentta;
    int aiempiLuku;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka io) {
        super(io);
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        aiempiLuku = Integer.parseInt(syotekentta.getText());
        io.plus(aiempiLuku);
        tuloskentta.setText(Integer.toString(io.tulos()));
    }

    @Override
    public void peru() {
        io.miinus(aiempiLuku);
        tuloskentta.setText(Integer.toString(io.tulos()));
    }
}
