package GUI;
import java.util.Random;

public class LosowanieZwierzat {
    private Swiat swiat;
    private Random random;

    public LosowanieZwierzat(Swiat w) {
        this.swiat = w;
        this.random = new Random();
    }

    public void losuj(){
        int iloscZwierzat = (int) (swiat.getSzerokoscPlanszy() * swiat.getWysokoscPlanszy() * 0.05);

        for (int i = 0; i < iloscZwierzat; i++) {
            int wylosowanyTypZwierzecia = random.nextInt(10) + 1;
            int wylosowanyX = random.nextInt(swiat.getSzerokoscPlanszy()) + 1;
            int wylosowanyY = random.nextInt(swiat.getWysokoscPlanszy()) + 1;

            System.out.println("Wylosowano: " + wylosowanyTypZwierzecia + " na pozycji: " + wylosowanyX + " " + wylosowanyY);

            // Sprawdzenie, czy na wylosowanej pozycji nie ma już organizmu
            if (swiat.wolneMiejsce(wylosowanyX, wylosowanyY)) {
                switch (wylosowanyTypZwierzecia) {
                    case 1:
                        swiat.DodajOrganizm(new Wilk(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 2:
                        swiat.DodajOrganizm(new Owca(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 3:
                        swiat.DodajOrganizm(new Lis(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 4:
                        swiat.DodajOrganizm(new Zolw(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 5:
                        swiat.DodajOrganizm(new Antylopa(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 6:
                        swiat.DodajOrganizm(new Trawa(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 7:
                        swiat.DodajOrganizm(new Mlecz(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 8:
                        swiat.DodajOrganizm(new Guarana(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 9:
                        swiat.DodajOrganizm(new Wilcze_Jagody(wylosowanyX, wylosowanyY, swiat));
                        break;
                    case 10:
                        swiat.DodajOrganizm(new Barszcz_Sosnowskiego(wylosowanyX, wylosowanyY, swiat));
                        break;
                    default:
                        // Domyślny przypadek
                        System.out.println("Nieznany typ zwierzęcia: " + wylosowanyTypZwierzecia);
                        break;
                }
            } else {
                // Jeśli pole jest zajęte, zmniejszamy licznik i losujemy ponownie
                i--;
            }
        }
    }
}
