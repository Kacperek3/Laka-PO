package GUI;

import javax.swing.*;
import java.awt.*;

public class Wilk extends Zwierze {
    Grafiki grafika = new Grafiki();
    public Wilk(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 9;
        this.inicjatywa = 5;
        this.wiek = 0;
        this.TypObiektu = 1;
    }

    public Wilk(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczacool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczacool);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaWilka);
    }
}

