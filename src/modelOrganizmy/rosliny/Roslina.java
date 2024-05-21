package modelOrganizmy.rosliny;

import GUI.Grafiki;
import pomocnicze.OrganizmyDoDodania;
import GUI.Swiat;
import modelOrganizmy.Organizm;

import java.util.Random;

public class Roslina extends Organizm {
    Grafiki grafika = new Grafiki();
    protected Organizm ptrOrganizmPoZjedzeniu;

    public Roslina(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
    }

    public Roslina(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
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

            for (int i = 0; i < 4; ++i) {
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
    }

    @Override
    public void kolizja() {
        // Do nothing for now
    }

    @Override
    public void rysowanie() {
        // Do nothing for now
    }

    @Override
    public void reakcja(Organizm ptrOrganizm) {
        ptrOrganizmPoZjedzeniu = ptrOrganizm;
        this.kolizja();
    }
}

