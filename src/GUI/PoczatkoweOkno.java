package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoczatkoweOkno extends JFrame {

    private Swiat lakaGUI; // Referencja do okna gry
    private LogiGry logiGry;

    public PoczatkoweOkno() {
        setTitle("Podawanie Informacji");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150); // Zmniejszyłem rozmiar okna

        JTextField szPrzycisk_WysokoscPlanszy = new JTextField(10);
        JTextField wyPrzycisk_WysokoscPlanszy = new JTextField(10);

        szPrzycisk_WysokoscPlanszy.setToolTipText("Podaj szerokość planszy");
        wyPrzycisk_WysokoscPlanszy.setToolTipText("Podaj wysokość planszy");

        JButton confirmButton = new JButton("Zatwierdź");
        JButton odczytZPliku = new JButton("Odczyt z pliku");


        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int wyPlanszy = Integer.parseInt(wyPrzycisk_WysokoscPlanszy.getText());
                    int szPlanszy = Integer.parseInt(szPrzycisk_WysokoscPlanszy.getText());

                    setVisible(false);
                    logiGry = new LogiGry();
                    lakaGUI = new Swiat(wyPlanszy, szPlanszy, "", logiGry);
                    lakaGUI.setVisible(true);
                    lakaGUI.rysujSwiat();





                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawną liczbę całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        odczytZPliku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OkienkoOdczytZpliku okienkoOdczytZPliku = new OkienkoOdczytZpliku();
                okienkoOdczytZPliku.setVisible(true);
                dispose();
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Szerokość planszy: "));
        panel.add(szPrzycisk_WysokoscPlanszy);
        panel.add(new JLabel("Wysokość planszy: "));
        panel.add(wyPrzycisk_WysokoscPlanszy);
        panel.add(confirmButton);
        panel.add(odczytZPliku);
        add(panel);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PoczatkoweOkno::new);
    }
}
