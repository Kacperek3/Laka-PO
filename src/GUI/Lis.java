package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Lis extends Zwierze {
    Grafiki grafika = new Grafiki();
    public Lis(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 3;
        this.inicjatywa = 9;
        this.wiek = 0;
        this.TypObiektu = 3;
    }

    public Lis(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void akcja() {
        Random rd = new Random();
        int[] kierunki = new int[4];
        int iloscWylosowanych = 0;

        do {
            int kierunek = rd.nextInt(4);

            if (kierunki[kierunek] == 0) {
                iloscWylosowanych++;
                kierunki[kierunek] = 1;

                switch (kierunek) {
                    case 0:
                        if (getPolozenieY() > 1 && swiat.wolneMiejscelubPrzeciwnikLis(getPolozenieX(), getPolozenieY() - 1, this)) {
                            setPolozenieY(getPolozenieY() - 1);
                            kolizja();
                            return;
                        }
                        break;
                    case 1:
                        if (getPolozenieY() < swiat.getWysokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnikLis(getPolozenieX(), getPolozenieY() + 1, this)) {
                            setPolozenieY(getPolozenieY() + 1);
                            kolizja();
                            return;
                        }
                        break;
                    case 2:
                        if (getPolozenieX() > 1 && swiat.wolneMiejscelubPrzeciwnikLis(getPolozenieX() - 1, getPolozenieY(), this)) {
                            setPolozenieX(getPolozenieX() - 1);
                            kolizja();
                            return;
                        }
                        break;
                    case 3:
                        if (getPolozenieX() < swiat.getSzerokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnikLis(getPolozenieX() + 1, getPolozenieY(), this)) {
                            setPolozenieX(getPolozenieX() + 1);
                            kolizja();
                            return;
                        }
                        break;
                }
            }

            if (iloscWylosowanych == 4) {
                break;
            }

        } while (true);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaLisa);
    }
}
