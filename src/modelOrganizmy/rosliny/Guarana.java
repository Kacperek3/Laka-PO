package modelOrganizmy.rosliny;

import GUI.Swiat;

public class Guarana extends Roslina {

    public Guarana(int xPoz, int yPoz, Swiat w) {
        super(xPoz, yPoz, w);
        this.sila = 0;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.TypObiektu = 8;
    }

    public Guarana(int xPoz, int yPoz, Swiat w, int typ, int wiek, int sila, int liczbaDniBezpl, int tarcza, int tarczaCool) {
        super(xPoz, yPoz, w, typ, wiek, sila, liczbaDniBezpl, tarcza, tarczaCool);
    }

    @Override
    public void kolizja() {
        ptrOrganizmPoZjedzeniu.setSila(ptrOrganizmPoZjedzeniu.getSila() + 3);
    }

    @Override
    public void rysowanie() {
        swiat.labels[polozenieX][polozenieY].setIcon(null);
        swiat.labels[polozenieX][polozenieY].setIcon(grafika.przeskalowanaIkonaGuarany);
    }
}
