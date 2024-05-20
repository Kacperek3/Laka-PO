package GUI;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;



public class Swiat extends JFrame implements KeyListener{

    private int wysokoscPlanszy;
    private int szerokoscPlanszy;
    private int kwadratSize = 30;
    public JLabel[][] labels;
    public ArrayList<Organizm> organizmy;
    public ArrayList<OrganizmyDoDodania> rozmnazaneOrganizmy;
    private int[][] planszaGry;
    Grafiki grafiki = new Grafiki();
    private ZapisDoPliku zapisDoPliku;
    private Random randomowaLiczba;


    public Swiat(int szerokoscPlanszy, int wysokoscPlanszy, String nazwaPliku) {
        this.szerokoscPlanszy = szerokoscPlanszy;
        this.wysokoscPlanszy = wysokoscPlanszy;
        randomowaLiczba = new Random();

        setTitle("Gra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        organizmy = new ArrayList<>();
        rozmnazaneOrganizmy = new ArrayList<>();


        if(nazwaPliku.length() != 0){
            OdczytZpliku odczytZPliku = new OdczytZpliku(nazwaPliku);
            odczytZPliku.dodajZwierzetaZPliku(this);
        }
        else{

            LosowanieZwierzat losowanieZwierzat = new LosowanieZwierzat(this);
            losowanieZwierzat.losuj();

            /*
            DodajOrganizm(new Owca(5,5,this));

            DodajOrganizm(new Owca(4,3,this));
            DodajOrganizm(new Owca(4,3,this));
            DodajOrganizm(new Owca(9,9,this));
            DodajOrganizm(new Wilk(3,1,this));
            //DodajOrganizm(new Zolw(1,1,this));
            //DodajOrganizm(new Barszcz_Sosnowskiego(3,3,this)); */
        }

        int szerokoscPanelu = this.szerokoscPlanszy * kwadratSize;
        int wysokoscPanelu = this.wysokoscPlanszy * kwadratSize;
        setSize(szerokoscPanelu, wysokoscPanelu);


        JButton drawButton = new JButton("Wykonaj Ture");


        // Create a JPanel to hold the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawButton);
        add(buttonPanel, BorderLayout.SOUTH);
        drawButton.addKeyListener(this);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rysujSwiat();
            }
        });

        try {
            ImageIcon squareIcon = new ImageIcon(getClass().getResource("/Grafiki/kwadrat_plansza.png"));
            Image squareImage = squareIcon.getImage();
            Image scaledSquareImage = squareImage.getScaledInstance(kwadratSize, kwadratSize, Image.SCALE_SMOOTH);
            ImageIcon scaledSquareIcon = new ImageIcon(scaledSquareImage);

            labels = new JLabel[this.wysokoscPlanszy + 1][this.szerokoscPlanszy + 1];

            for (int i = 1; i <= this.wysokoscPlanszy; i++) {
                for (int j = 1; j <= this.szerokoscPlanszy; j++) {
                    JLabel squareLabel = new JLabel(scaledSquareIcon);
                    squareLabel.setPreferredSize(new Dimension(kwadratSize, kwadratSize));
                    labels[i][j] = squareLabel;

                    Swiat kopiaSwiat = this; int kordynatI = i; int kordynatj = j;
                    labels[i][j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                           DodawanieZwierzeciaFrame dodawanieZwierzeciaFrame =
                                   new DodawanieZwierzeciaFrame(kopiaSwiat,kordynatI,kordynatj);
                           dodawanieZwierzeciaFrame.setVisible(true);
                        }
                    });
                }
            }

        }
        catch (Exception e) {
            System.out.println("Nie udało się wczytać obrazka");
        }

        planszaGry = new int[this.szerokoscPlanszy][this.wysokoscPlanszy];
        setVisible(true);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        for (Organizm org : organizmy) {
            if (org.TypObiektu == 0) {
                System.out.println(org.TarczaAlzura);
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    org.kierunekRuchu = 3;
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    org.kierunekRuchu = 2;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    org.kierunekRuchu = 1;
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    org.kierunekRuchu = 4;
                }
                else if (e.getKeyCode() == KeyEvent.VK_P) {
                    org.TarczaKliknieta = true;
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            int klucz = randomowaLiczba.nextInt(999999) + 100000;
            zapisDoPliku = new ZapisDoPliku(String.valueOf(klucz) + ".txt");
            zapisDoPliku.zapisz(organizmy,szerokoscPlanszy, wysokoscPlanszy);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void rysujSwiat() {
        JPanel panel = new JPanel(new GridLayout(wysokoscPlanszy, szerokoscPlanszy, 0, 0));

       wykonajTure();
        for (int i = 1; i <= wysokoscPlanszy; i++) {
            for (int j = 1; j <= szerokoscPlanszy; j++) {
                JPanel cellPanel = new JPanel(new BorderLayout());
                cellPanel.add(labels[i][j], BorderLayout.CENTER);

                panel.add(cellPanel);
            }
        }
        add(panel);
        System.out.println("Rysowanie zakończone");
    }
    public void rysujSwiatbezTury() {
        JPanel panel = new JPanel(new GridLayout(wysokoscPlanszy, szerokoscPlanszy, 0, 0));
        for (Organizm org : organizmy) {
            org.rysowanie();
        }
        for (int i = 1; i <= wysokoscPlanszy; i++) {
            for (int j = 1; j <= szerokoscPlanszy; j++) {

                JPanel cellPanel = new JPanel(new BorderLayout());
                cellPanel.add(labels[i][j], BorderLayout.CENTER);

                panel.add(cellPanel);
            }
        }
        add(panel);
        System.out.println("Rysowanie zakończone");
    }

    public void wykonajTure() {
        organizmy.sort(new Comparator<Organizm>() {
            @Override
            public int compare(Organizm a, Organizm b) {
                if (a.getInicjatywa() == b.getInicjatywa()) {
                    return Integer.compare(b.getWiek(), a.getWiek());
                } else {
                    return Integer.compare(b.getInicjatywa(), a.getInicjatywa());
                }
            }
        });

        Iterator<Organizm> iterator = organizmy.iterator();
        while (iterator.hasNext()) {
            Organizm org = iterator.next();
            if (org.getWiek() == -1) {
                iterator.remove();
            } else {
                labels[org.polozenieX][org.polozenieY].setIcon(grafiki.scaledSquareIcon);

                org.akcja();

                if(org.getWiek() == -1){
                    iterator.remove();
                }
                else{
                    org.rysowanie();
                    org.setWiek(org.getWiek() + 1);
                    if (org.liczbaDniBezplodnych != 0) org.liczbaDniBezplodnych--;
                }
            }
        }
        for (OrganizmyDoDodania dodanyOrganizm : rozmnazaneOrganizmy) {
            switch (dodanyOrganizm.Typ) {
                case 1:
                    DodajOrganizm(new Wilk(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this));
                    break;
                case 2:
                    Owca owca = new Owca(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    owca.rysowanie();
                    DodajOrganizm(owca);
                    break;
                case 3:
                    Lis lis = new Lis(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    lis.rysowanie();
                    DodajOrganizm(lis);
                    break;
                case 4:
                    Zolw zolw = new Zolw(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    zolw.rysowanie();
                    DodajOrganizm(zolw);
                    break;
                case 5:
                    Antylopa antylopa = new Antylopa(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    antylopa.rysowanie();
                    DodajOrganizm(antylopa);
                    break;
                case 6:
                    Trawa trawa = new Trawa(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    trawa.rysowanie();
                    DodajOrganizm(trawa);
                    break;
                case 7:
                    Mlecz mlecz = new Mlecz(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    mlecz.rysowanie();
                    DodajOrganizm(mlecz);
                    break;
                case 8:
                    Guarana guarana = new Guarana(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    guarana.rysowanie();
                    DodajOrganizm(guarana);
                    break;
                case 9:
                    Wilcze_Jagody wilcze_jagody = new Wilcze_Jagody(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    wilcze_jagody.rysowanie();
                    DodajOrganizm(wilcze_jagody);
                    break;
                case 10:
                    Barszcz_Sosnowskiego barszcz_sosnowskiego = new Barszcz_Sosnowskiego(dodanyOrganizm.xPos, dodanyOrganizm.yPos, this);
                    barszcz_sosnowskiego.rysowanie();
                    DodajOrganizm(barszcz_sosnowskiego);
                    break;
                default:
                    break;
            }
        }
        rozmnazaneOrganizmy.clear();
    }


    public void DodajOrganizm(Organizm noweZwierze) {
        organizmy.add(noweZwierze);
    }

//---------------------------------------------------------------------------
    //juz zamienione na dobre (raczej)

    public int getSzerokoscPlanszy() {
        return szerokoscPlanszy;
    }

    public void setSzerokoscPlanszy(int sz) {
        szerokoscPlanszy = sz;
    }

    public int getWysokoscPlanszy() {
        return wysokoscPlanszy;
    }

    public void setWysokoscPlanszy(int wy) {
        wysokoscPlanszy = wy;
    }

    public boolean wolneMiejsce(int xPoz, int yPoz) {
        for (Organizm org : organizmy) {
            if (org.getPolozenieX() == xPoz && org.getPolozenieY() == yPoz) {
                return false;
            }
        }
        for (OrganizmyDoDodania org : rozmnazaneOrganizmy) {
            if (org.xPos == xPoz && org.yPos == yPoz) {
                return false;
            }
        }
        return true;
    }

    public boolean wolneMiejscelubPrzeciwnik(int xPoz, int yPoz, Organizm tymczasowyOrganizm) {
        for (Organizm org : organizmy) {
            if (org.TypObiektu == tymczasowyOrganizm.TypObiektu &&
                    org.getPolozenieY() == yPoz &&
                    org.getPolozenieX() == xPoz) {
                return false;
            }
        }
        return true;
    }

    public boolean wolneMiejscelubPrzeciwnikLis(int xPoz, int yPoz, Organizm tymczasowyOrganizm) {
        for (Organizm org : organizmy) {
            if ((org.getPolozenieY() == yPoz &&
                    org.getPolozenieX() == xPoz &&
                    org.TypObiektu != tymczasowyOrganizm.TypObiektu &&
                    org.getSila() > tymczasowyOrganizm.getSila()) ||
                    (org.TypObiektu == tymczasowyOrganizm.TypObiektu &&
                            org.getPolozenieY() == yPoz &&
                            org.getPolozenieX() == xPoz)) {
                return false;
            }
        }
        return true;
    }

    public boolean czySlabszyNizZolw(int xPoz, int yPoz, Organizm tymczasowyOrganizm) {
        for (Organizm org : organizmy) {
            if (org.getPolozenieX() == xPoz && org.getPolozenieY() == yPoz && org != tymczasowyOrganizm && org.TypObiektu == Organizm.ZOLW) {
                return true;
            }
        }
        return false;
    }

    public boolean czyTarczaAlzura(int xPoz, int yPoz, Organizm tymczasowyOrganizm) {
        for (Organizm org : organizmy) {
            if (org.getPolozenieY() == yPoz &&
                    org.getPolozenieX() == xPoz &&
                    org.TypObiektu == Organizm.CZLOWIEK &&
                    org.TarczaAlzura > 0) {
                return true;
            }
        }
        return false;
    }

    public Organizm getOrganizmNaPozycji(int pozycja) {
        if (pozycja < organizmy.size()) {
            return organizmy.get(pozycja);
        } else {
            return null;
        }
    }
//---------------------------------------------------------------------------

}
