package GUI;

import modelOrganizmy.Zwierze;

public class Owca extends Zwierze {
    Grafiki grafika = new Grafiki();
    public Owca(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 4;
        this.inicjatywa = 4;
        this.wiek = 0;
        this.TypObiektu = 2;
    }

    public Owca(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczacool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczacool);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaOwcy);
    }
}
