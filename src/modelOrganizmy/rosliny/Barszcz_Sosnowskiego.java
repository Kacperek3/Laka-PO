package modelOrganizmy.rosliny;

import pomocnicze.OrganizmyDoDodania;
import GUI.Swiat;
import modelOrganizmy.Organizm;

import java.util.Random;

public class Barszcz_Sosnowskiego extends Roslina {

    public Barszcz_Sosnowskiego(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 10;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.TypObiektu = 10;
    }

    public Barszcz_Sosnowskiego(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void akcja() {
        Random rd = new Random();
        boolean szansaNaNieRozprzestrzenienie = rd.nextInt(11) == 0;

        if (szansaNaNieRozprzestrzenienie) {
            int rodzicX = getPolozenieX();
            int rodzicY = getPolozenieY();

            int[][] przesuniecia = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

            for (int i = 0; i < 4; i++) {
                int potomekX = rodzicX + przesuniecia[i][0];
                int potomekY = rodzicY + przesuniecia[i][1];

                if (swiat.wolneMiejsce(potomekX, potomekY) &&
                        potomekX >= 1 && potomekX <= swiat.getSzerokoscPlanszy() &&
                        potomekY >= 1 && potomekY <= swiat.getWysokoscPlanszy()) {
                    swiat.rozmnazaneOrganizmy.add(new OrganizmyDoDodania(TypObiektu, potomekX, potomekY));
                    break;
                }
            }
        }

        for (Organizm ptrOrganizm : swiat.organizmy) {
            if (ptrOrganizm.TypObiektu != 10 &&
                    ptrOrganizm.TypObiektu != 6 &&
                    ptrOrganizm.TypObiektu != 8 &&
                    ptrOrganizm.TypObiektu != 7 &&
                    ptrOrganizm.TypObiektu != 9) {
                int deltaX = ptrOrganizm.getPolozenieX() - this.getPolozenieX();
                int deltaY = ptrOrganizm.getPolozenieY() - this.getPolozenieY();

                if ((Math.abs(deltaX) == 1 && deltaY == 0) || (Math.abs(deltaY) == 1 && deltaX == 0)) {
                    ptrOrganizm.setWiek(-1);
                    swiat.labels[ptrOrganizm.polozenieX][ptrOrganizm.polozenieY].setIcon(null);
                    swiat.labels[ptrOrganizm.polozenieX][ptrOrganizm.polozenieY].setIcon(grafika.scaledSquareIcon);
                }
            }
        }
    }

    @Override
    public void kolizja() {
        ptrOrganizmPoZjedzeniu.setWiek(-1);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaBarszcz_sosnowskiego);
    }
}

