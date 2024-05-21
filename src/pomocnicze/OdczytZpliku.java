package pomocnicze;

import GUI.Swiat;
import modelOrganizmy.zwierzeta.*;
import modelOrganizmy.rosliny.*;
import modelOrganizmy.Organizm;

import java.io.*;
import java.util.Scanner;

public class OdczytZpliku {
    private String nazwaPliku;
    public OdczytZpliku(String nazwa) {
        this.nazwaPliku = nazwa;
    }

    public void dodajZwierzetaZPliku(Swiat swiat) {
        try {
            String currentDirectory = new File("").getAbsolutePath();
            File parentDirectory = new File(currentDirectory).getParentFile();
            File zapisyPlanszyDir = new File(parentDirectory, "ZapisyPlanszy");
            File plik = new File(zapisyPlanszyDir, nazwaPliku);

            Scanner scanner = new Scanner(plik);
            if (scanner.hasNextInt()) {
                int szerokosc = scanner.nextInt();
                System.out.println("szerokosc: " + szerokosc);
                int wysokosc = scanner.nextInt();
                swiat.setSzerokoscPlanszy(szerokosc);
                swiat.setWysokoscPlanszy(wysokosc);


                while (scanner.hasNextInt()) {
                    int xPoz = scanner.nextInt();
                    int yPoz = scanner.nextInt();
                    int typ = scanner.nextInt();
                    int wiek = scanner.nextInt();
                    int sila = scanner.nextInt();
                    int liczbaDniBezplodnych = scanner.nextInt();
                    int tarcza = scanner.nextInt();
                    int tarczaCoolDown = scanner.nextInt();

                    switch (typ) {
                        case 0:
                            swiat.DodajOrganizm(new Czlowiek(xPoz, yPoz,swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 1:
                            swiat.DodajOrganizm(new Wilk(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 2:
                            swiat.DodajOrganizm(new Owca(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 3:
                            swiat.DodajOrganizm(new Lis(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 4:
                            swiat.DodajOrganizm(new Zolw(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 5:
                            swiat.DodajOrganizm(new Antylopa(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 6:
                            swiat.DodajOrganizm(new Trawa(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 7:
                            swiat.DodajOrganizm(new Mlecz(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 8:
                            swiat.DodajOrganizm(new Guarana(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 9:
                            swiat.DodajOrganizm(new Wilcze_Jagody(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                        case 10:
                            swiat.DodajOrganizm(new Barszcz_Sosnowskiego(xPoz, yPoz, swiat, typ, wiek, sila, liczbaDniBezplodnych, tarcza, tarczaCoolDown));
                            break;
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie można otworzyć pliku do odczytu: " + e.getMessage());
        }
    }
}
