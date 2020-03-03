
package laskin;

public abstract class Komento {
    protected Sovelluslogiikka io;
    public Komento(Sovelluslogiikka io) {
        this.io = io;
    }

    public abstract void suorita();
    
    public abstract void peru();
}