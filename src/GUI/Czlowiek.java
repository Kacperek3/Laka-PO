package GUI;

import modelOrganizmy.Zwierze;

public class Czlowiek extends Zwierze {
    Grafiki grafika = new Grafiki();

    public Czlowiek(int xPoz, int yPoz, Swiat swiat, int typ, int wiek, int sila, int liczbaDniBezplodnych, int tarczaAlzura, int tarczaCoolDown) {
        super(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarczaAlzura, tarczaCoolDown);
        this.TarczaKliknieta = false;
        this.kierunekRuchu = 0;
    }

    public Czlowiek(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 5;
        this.inicjatywa = 4;
        this.wiek = 0;
        this.TypObiektu = 0;
        this.TarczaAlzura = 0;
        this.TarczaCoolDown = 0;
        this.TarczaKliknieta = false;
        this.kierunekRuchu = 0;
        this.kierunekRuchu = 0;
        this.TarczaKliknieta = false;
    }

    @Override
    public void akcja() {
        System.out.println("Ruch Czlowieka");

        if (this.TarczaAlzura > 0) {
            System.out.println("Tarcza dostępna przez: " + this.TarczaAlzura + " tury");
        }
        CzyTarcza();

        if (kierunekRuchu == 1) {
            System.out.println("Ruch Czlowieka: GORA");
            if (this.getPolozenieY() > 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() - 1, this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX(), this.getPolozenieY() - 1, this)) return;
                this.setPolozenieY(this.getPolozenieY() - 1);
                this.kolizja(); kierunekRuchu = 0;
                return;
            }
        }
        else if (kierunekRuchu == 2) {
            System.out.println("Ruch Czlowieka: DOL");
            if (this.getPolozenieY() < swiat.getWysokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX(), this.getPolozenieY() + 1, this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX(), this.getPolozenieY() + 1, this)) return;
                this.setPolozenieY(this.getPolozenieY() + 1);
                this.kolizja(); kierunekRuchu = 0;
                return;
            }
        }
        else if (kierunekRuchu == 3) {
            System.out.println("Ruch Czlowieka: LEWO");
            if (this.getPolozenieX() > 1 && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() - 1, this.getPolozenieY(), this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX() - 1, this.getPolozenieY(), this)) return;
                this.setPolozenieX(this.getPolozenieX() - 1);
                this.kolizja(); kierunekRuchu = 0;
                return;
            }
        }
        else if (kierunekRuchu == 4) {
            System.out.println("Ruch Czlowieka: PRAWO");
            if (this.getPolozenieX() < swiat.getSzerokoscPlanszy() && swiat.wolneMiejscelubPrzeciwnik(this.getPolozenieX() + 1, this.getPolozenieY(), this)) {
                if (swiat.czySlabszyNizZolw(this.getPolozenieX() + 1, this.getPolozenieY(), this)) return;
                this.setPolozenieX(this.getPolozenieX() + 1);
                this.kolizja(); kierunekRuchu = 0;
                return;
            }
        }

    }
    private void CzyTarcza(){
        if (TarczaKliknieta) {
            if (TarczaAlzura == 0 && TarczaCoolDown == 0) {
                System.out.println("Tarcza Użyta, będzie dostępna przez 5 tur");
                this.TarczaAlzura = 5;
                this.TarczaCoolDown = 10;
            } else {
                System.out.println("Tarcze będzie można użyć za: " + TarczaCoolDown);
            }
        }
        TarczaKliknieta = false;
    }
    @Override
    public void kolizja() {
        if (this.TarczaAlzura != 0) this.TarczaAlzura--;
        if (this.TarczaCoolDown != 0) this.TarczaCoolDown--;

        for (Organizm ptrOrganizm : swiat.organizmy) {
            if (this.TypObiektu != ptrOrganizm.TypObiektu) {
                if (ptrOrganizm.getPolozenieX() == this.getPolozenieX() && ptrOrganizm.getPolozenieY() == this.getPolozenieY()) {
                    if (this.sila >= ptrOrganizm.getSila()) {
                        ptrOrganizm.reakcja(this);
                        ptrOrganizm.setWiek(-1);
                    } else {
                        this.setWiek(-1);
                    }
                }
            }
        }
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaCzlowieka);
    }
}