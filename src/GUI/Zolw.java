package GUI;

import modelOrganizmy.Zwierze;

import java.util.Random;

public class Zolw extends Zwierze {
    Grafiki grafika = new Grafiki();
    public Zolw(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 2;
        this.inicjatywa = 1;
        this.wiek = 0;
        this.TypObiektu = 4;
    }

    public Zolw(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void akcja() {
        Random rd = new Random();
        int iloscWylosowanych = 0;

        do {
            boolean czyNieRuszy = rd.nextBoolean();
            if (!czyNieRuszy) {
                int kierunek = rd.nextInt(4);

                if (kierunek == 0 && this.getPolozenieY() > 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() - 1, this)) {
                    this.setPolozenieY(this.getPolozenieY() - 1);
                    this.kolizja();
                    return;
                } else if (kierunek == 1 && this.getPolozenieY() < swiat.getWysokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() + 1, this)) {
                    this.setPolozenieY(this.getPolozenieY() + 1);
                    this.kolizja();
                    return;
                } else if (kierunek == 2 && this.getPolozenieX() > 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() - 1, this.getPolozenieY(), this)) {
                    this.setPolozenieX(this.getPolozenieX() - 1);
                    this.kolizja();
                    return;
                } else if (kierunek == 3 && this.getPolozenieX() < swiat.getSzerokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() + 1, this.getPolozenieY(), this)) {
                    this.setPolozenieX(this.getPolozenieX() + 1);
                    this.kolizja();
                    return;
                }

                if (++iloscWylosowanych == 4) {
                    break;
                }
            } else {
                break;
            }
        } while (true);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaZolwia);
    }
}

