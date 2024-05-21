package modelOrganizmy;
import GUI.Swiat;


public class Organizm {
    public static final int WILK = 1;
    public static final int OWCA = 2;
    public static final int LIS = 3;
    public static final int ZOLW = 4;
    public static final int ANTYLOPA = 5;
    public static final int TRAWA = 6;
    public static final int MLECZ = 7;
    public static final int GUARANA = 8;
    public static final int WILCZE_JAGODY = 9;
    public static final int BARSZCZSOSNOWSKIEGO = 10;
    public static final int CZLOWIEK = 0;




    protected int sila;
    protected int inicjatywa;
    protected int wiek;
    public int polozenieX;
    public int polozenieY;
    public Swiat swiat;

    public int PozycjaXprzedRuszeniem;
    public int PozycjaYprzedRuszeniem;
    public int TarczaAlzura;
    public int TarczaCoolDown;
    public int kierunekRuchu;
    public boolean TarczaKliknieta;

    public int liczbaDniBezplodnych;
    public int TypObiektu;


    public Organizm(int xPoz, int yPoz, Swiat w) {
        this.polozenieX = xPoz;
        this.polozenieY = yPoz;
        this.swiat = w;
    }

    public Organizm(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczacool) {
        this.polozenieX = xPoz;
        this.polozenieY = yPoz;
        this.swiat = w;
        this.TypObiektu = typ;
        this.wiek = wiek;
        this.sila = sila;
        this.liczbaDniBezplodnych = liczbaDniBezpl;
        this.TarczaAlzura = tarcza;
        this.TarczaCoolDown = tarczacool;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public int getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(int nowePolozenie) {
        this.polozenieX = nowePolozenie;
    }

    public int getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(int nowePolozenie) {
        this.polozenieY = nowePolozenie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int ustawWiek) {
        this.wiek = ustawWiek;
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int ustawSile) {
        this.sila = ustawSile;
    }

    public void akcja() {
        // To be implemented in subclasses
    }

    public void kolizja() {
        // To be implemented in subclasses
    }

    public void reakcja(Organizm ptrOrganizm) {
        // To be implemented in subclasses
    }

    public void rysowanie() {
        // To be implemented in subclasses
    }
}
