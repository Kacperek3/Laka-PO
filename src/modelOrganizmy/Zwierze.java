package modelOrganizmy;

import GUI.Organizm;
import GUI.OrganizmyDoDodania;
import GUI.Swiat;

import java.util.Random;

public class Zwierze extends Organizm {

    public Zwierze(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
    }

    public Zwierze(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczacool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczacool);
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
                        if (getPolozenieY() > 1 && swiat.wolneMiejscelubPrzeciwnik(getPolozenieX(), getPolozenieY() - 1, this)) {
                            if (swiat.czySlabszyNizZolw(getPolozenieX(), getPolozenieY() - 1, this)) return;
                            if (swiat.czyTarczaAlzura(getPolozenieX(), getPolozenieY() - 1, this)) return;
                            setPolozenieY(getPolozenieY() - 1);
                            kolizja();
                            return;
                        }
                        break;
                    case 1:
                        if (getPolozenieY() < swiat.getWysokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(getPolozenieX(), getPolozenieY() + 1, this)) {
                            if (swiat.czySlabszyNizZolw(getPolozenieX(), getPolozenieY() + 1, this)) return;
                            if (swiat.czyTarczaAlzura(getPolozenieX(), getPolozenieY() + 1, this)) return;
                            setPolozenieY(getPolozenieY() + 1);
                            kolizja();
                            return;
                        }
                        break;
                    case 2:
                        if (getPolozenieX() > 1 && swiat.wolneMiejscelubPrzeciwnik(getPolozenieX() - 1, getPolozenieY(), this)) {
                            if (swiat.czySlabszyNizZolw(getPolozenieX() - 1, getPolozenieY(), this)) return;
                            if (swiat.czyTarczaAlzura(getPolozenieX() - 1, getPolozenieY(), this)) return;
                            setPolozenieX(getPolozenieX() - 1);
                            kolizja();
                            return;
                        }
                        break;
                    case 3:
                        if (getPolozenieX() < swiat.getSzerokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(getPolozenieX() + 1, getPolozenieY(), this)) {
                            if (swiat.czySlabszyNizZolw(getPolozenieX() + 1, getPolozenieY(), this)) return;
                            if (swiat.czyTarczaAlzura(getPolozenieX() + 1, getPolozenieY(), this)) return;
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
    public void kolizja() {
        for (Organizm ptrOrganizm : swiat.organizmy) {
            //atak
            if (this.TypObiektu != ptrOrganizm.TypObiektu) {
                if (ptrOrganizm.getPolozenieX() == this.getPolozenieX() && ptrOrganizm.getPolozenieY() == this.getPolozenieY()) {
                    if (this.sila >= ptrOrganizm.getSila()) {
                        ptrOrganizm.reakcja(this);
                        ptrOrganizm.setWiek(-1);
                        this.rysowanie();
                    } else {
                        this.setWiek(-1);
                        ptrOrganizm.rysowanie();
                    }
                }
            }
            //rozmnazanie
            else if (this != ptrOrganizm && this.TypObiektu == ptrOrganizm.TypObiektu && ptrOrganizm.liczbaDniBezplodnych == 0 && liczbaDniBezplodnych == 0 && CzyRozmnozenie(ptrOrganizm)) {
                dodajPotomka(ptrOrganizm);
                liczbaDniBezplodnych = 10;
            }
        }
    }
    protected boolean CzyRozmnozenie(Organizm ptrOrganizm){
        if (getPolozenieY() > 1) {
            if(getPolozenieX() == ptrOrganizm.getPolozenieX() && getPolozenieY() - 1 == ptrOrganizm.getPolozenieY()) {
                return true;
            }
        }
        if (getPolozenieY() < swiat.getWysokoscPlanszy()) {
            if (getPolozenieX() == ptrOrganizm.getPolozenieX() && getPolozenieY() + 1 == ptrOrganizm.getPolozenieY()) {
                return true;
            }
        }
        if (getPolozenieX() > 1 && this.TypObiektu == ptrOrganizm.TypObiektu) {
            if (getPolozenieX() - 1 == ptrOrganizm.getPolozenieX() && getPolozenieY() == ptrOrganizm.getPolozenieY()) {
                return true;
            }
        }
        if (getPolozenieX() < swiat.getSzerokoscPlanszy()) {
            if (getPolozenieX() + 1 == ptrOrganizm.getPolozenieX() && getPolozenieY() == ptrOrganizm.getPolozenieY()) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void reakcja(Organizm ptrOrganizm) {
        // To be implemented
    }

    protected void dodajPotomka(Organizm partner) {
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
                partner.liczbaDniBezplodnych = 10;
                break;
            }
        }
    }

    @Override
    public void rysowanie() {

    }


}

