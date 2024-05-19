package GUI;

public class Wilcze_Jagody extends Roslina {

    public Wilcze_Jagody(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 99;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.TypObiektu = 9;
    }

    public Wilcze_Jagody(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void kolizja() {
        ptrOrganizmPoZjedzeniu.setWiek(-1);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaWilcze_jagody);
    }
}
