package GUI;

import java.util.Random;

public class Antylopa extends Zwierze {
    Grafiki grafika = new Grafiki();
    public Antylopa(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 4;
        this.inicjatywa = 4;
        this.wiek = 0;
        this.TypObiektu = 5;
    }

    public Antylopa(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void akcja() {
        Random rd = new Random();
        int iloscWylosowanych = 0;

        do {
            int kierunek = rd.nextInt(8);

            if (kierunek == 0 && this.getPolozenieY() > 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() - 1, this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX(), this.getPolozenieY() - 1, this)) return;
                this.setPolozenieY(this.getPolozenieY() - 1);
                this.kolizja();
                return;
            } else if (kierunek == 1 && this.getPolozenieY() < swiat.getWysokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() + 1, this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX(), this.getPolozenieY() + 1, this)) return;
                this.setPolozenieY(this.getPolozenieY() + 1);
                this.kolizja();
                return;
            } else if (kierunek == 2 && this.getPolozenieX() > 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() - 1, this.getPolozenieY(), this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX() - 1, this.getPolozenieY(), this)) return;
                this.setPolozenieX(this.getPolozenieX() - 1);
                this.kolizja();
                return;
            } else if (kierunek == 3 && this.getPolozenieX() < swiat.getSzerokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() + 1, this.getPolozenieY(), this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX() + 1, this.getPolozenieY(), this)) return;
                this.setPolozenieX(this.getPolozenieX() + 1);
                this.kolizja();
                return;
            } else if (kierunek == 4 && this.getPolozenieY() > 2 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() - 2, this)) {
                this.setPolozenieY(this.getPolozenieY() - 2);
                this.kolizja();
                return;
            } else if (kierunek == 5 && this.getPolozenieY() < swiat.getWysokoscPlanszy() - 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() + 2, this)) {
                this.setPolozenieY(this.getPolozenieY() + 2);
                this.kolizja();
                return;
            } else if (kierunek == 6 && this.getPolozenieX() > 2 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() - 2, this.getPolozenieY(), this)) {
                this.setPolozenieX(this.getPolozenieX() - 2);
                this.kolizja();
                return;
            } else if (kierunek == 7 && this.getPolozenieX() < swiat.getSzerokoscPlanszy() - 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() + 2, this.getPolozenieY(), this)) {
                this.setPolozenieX(this.getPolozenieX() + 2);
                this.kolizja();
                return;
            }

            if (++iloscWylosowanych == 8) {
                break;
            }

        } while (true);
    }
    @Override
    public void kolizja() {
        Random rd = new Random();
        int szansaNaUcieczke = rd.nextInt(2);

        for (Organizm ptrOrganizm : swiat.organizmy) {
            if (this.TypObiektu != ptrOrganizm.TypObiektu) {
                if (ptrOrganizm.getPolozenieX() == this.getPolozenieX() && ptrOrganizm.getPolozenieY() == this.getPolozenieY()) {
                    if (this.sila >= ptrOrganizm.getSila()) {
                        ptrOrganizm.reakcja(this);
                        ptrOrganizm.setWiek(-1);
                    } else {
                        if (szansaNaUcieczke == 0) this.setWiek(-1);
                        else {
                            int rodzicX = getPolozenieX();
                            int rodzicY = getPolozenieY();

                            int[][] przesuniecia = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

                            for (int i = 0; i < 4; ++i) {
                                int potomekX = rodzicX + przesuniecia[i][0];
                                int potomekY = rodzicY + przesuniecia[i][1];

                                if (swiat.wolneMiejsce(potomekX, potomekY) &&
                                        potomekX >= 1 && potomekX <= swiat.getSzerokoscPlanszy() &&
                                        potomekY >= 1 && potomekY <= swiat.getWysokoscPlanszy()) {
                                    setPolozenieX(potomekX);
                                    setPolozenieY(potomekY);
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (this != ptrOrganizm && this.TypObiektu == ptrOrganizm.TypObiektu && ptrOrganizm.liczbaDniBezplodnych == 0 && liczbaDniBezplodnych == 0
                    && CzyRozmnozenie(ptrOrganizm)) {
                dodajPotomka(ptrOrganizm);
                liczbaDniBezplodnych = 10;
            }
        }
    }
    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaAntylopy);
    }
}