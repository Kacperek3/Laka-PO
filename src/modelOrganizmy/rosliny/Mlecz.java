package modelOrganizmy.rosliny;

import pomocnicze.OrganizmyDoDodania;
import GUI.Swiat;

import java.util.Random;

public class Mlecz extends Roslina {

    public Mlecz(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 0;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.TypObiektu = 7;
    }

    public Mlecz(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void akcja() {
        Random rd = new Random();

        for (int i = 0; i < 3; i++) {
            boolean szansaNaNieRozprzestrzenienie = rd.nextInt(11) == 0;

            if (szansaNaNieRozprzestrzenienie) {
                int rodzicX = getPolozenieX();
                int rodzicY = getPolozenieY();

                int[][] przesuniecia = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

                for (int j = 0; j < 4; ++j) {
                    int potomekX = rodzicX + przesuniecia[j][0];
                    int potomekY = rodzicY + przesuniecia[j][1];

                    if (swiat.wolneMiejsce(potomekX, potomekY) &&
                            potomekX >= 1 && potomekX <= swiat.getSzerokoscPlanszy() &&
                            potomekY >= 1 && potomekY <= swiat.getWysokoscPlanszy()) {
                        swiat.rozmnazaneOrganizmy.add(new OrganizmyDoDodania(TypObiektu, potomekX, potomekY));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaMlecza);
    }
}

