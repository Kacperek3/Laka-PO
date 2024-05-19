package GUI;

public class Trawa extends Roslina {

    public Trawa(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 0;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.TypObiektu = 6;
    }

    public Trawa(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaTrawy);
    }
}

