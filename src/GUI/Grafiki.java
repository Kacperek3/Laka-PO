package GUI;

import javax.swing.*;
import java.awt.*;

public class Grafiki {
    private ImageIcon squareIcon = new ImageIcon(getClass().getResource("/Grafiki/kwadrat_plansza.png"));
    private Image squareImage = squareIcon.getImage();
    private Image scaledSquareImage = squareImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon scaledSquareIcon = new ImageIcon(scaledSquareImage);

    private ImageIcon wilkIkona = new ImageIcon(getClass().getResource("/Grafiki/wilk.jpg"));
    private Image wilkZdjecie = wilkIkona.getImage();
    private Image przeskalowaneZdjecieWilka = wilkZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaWilka = new ImageIcon(przeskalowaneZdjecieWilka);

    private ImageIcon owcaIkona = new ImageIcon(getClass().getResource("/Grafiki/owca.jpg"));
    private Image owcaZdjecie = owcaIkona.getImage();
    private Image przeskalowaneZdjecieOwcy = owcaZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaOwcy = new ImageIcon(przeskalowaneZdjecieOwcy);

    private ImageIcon LisIkona = new ImageIcon(getClass().getResource("/Grafiki/lis.jpg"));
    private Image LisZdjecie = LisIkona.getImage();
    private Image przeskalowaneZdjecieLisa = LisZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaLisa = new ImageIcon(przeskalowaneZdjecieLisa);

    private ImageIcon ZolwIkona = new ImageIcon(getClass().getResource("/Grafiki/zolw.jpg"));
    private Image ZolwZdjecie = ZolwIkona.getImage();
    private Image przeskalowaneZdjecieZolwia = ZolwZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaZolwia = new ImageIcon(przeskalowaneZdjecieZolwia);

    private ImageIcon AntylopaIkona = new ImageIcon(getClass().getResource("/Grafiki/antylopa.jpeg"));
    private Image antylopaZdjecie = AntylopaIkona.getImage();
    private Image przeskalowaneZdjecieAntylopy = antylopaZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaAntylopy = new ImageIcon(przeskalowaneZdjecieAntylopy);



    private ImageIcon TrawaIkona = new ImageIcon(getClass().getResource("/Grafiki/trawa.jpg"));
    private Image trawaZdjecie = TrawaIkona.getImage();
    private Image przeskalowaneZdjecieTrawy = trawaZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaTrawy = new ImageIcon(przeskalowaneZdjecieTrawy);

    private ImageIcon MleczIkona = new ImageIcon(getClass().getResource("/Grafiki/mlecz.jpg"));
    private Image mleczZdjecie = MleczIkona.getImage();
    private Image przeskalowaneZdjecieMlecza = mleczZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaMlecza = new ImageIcon(przeskalowaneZdjecieMlecza);

    private ImageIcon GuaranaIkona = new ImageIcon(getClass().getResource("/Grafiki/guarana.jpg"));
    private Image guaranaZdjecie = GuaranaIkona.getImage();
    private Image przeskalowaneZdjecieGuarany = guaranaZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaGuarany = new ImageIcon(przeskalowaneZdjecieGuarany);

    private ImageIcon wilcze_jagodyIkona = new ImageIcon(getClass().getResource("/Grafiki/wilcze_jagody.jpg"));
    private Image wilcze_jagodyZdjecie = wilcze_jagodyIkona.getImage();
    private Image przeskalowaneZdjecieWilcze_jagody = wilcze_jagodyZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaWilcze_jagody = new ImageIcon(przeskalowaneZdjecieWilcze_jagody);

    private ImageIcon barszcz_sosnowskieIkona = new ImageIcon(getClass().getResource("/Grafiki/barszcz_sosnowskiego.jpg"));
    private Image barszcz_sosnowskieZdjecie = barszcz_sosnowskieIkona.getImage();
    private Image przeskalowaneZdjecieBarszcz_sosnowskie = barszcz_sosnowskieZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaBarszcz_sosnowskiego = new ImageIcon(przeskalowaneZdjecieBarszcz_sosnowskie);


    private ImageIcon czlowiekIkona = new ImageIcon(getClass().getResource("/Grafiki/czlowiek.jpg"));
    private Image czlowiekZdjecie = czlowiekIkona.getImage();
    private Image przeskalowaneZdjecieCzlowieka = czlowiekZdjecie.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    public ImageIcon przeskalowanaIkonaCzlowieka = new ImageIcon(przeskalowaneZdjecieCzlowieka);


}
