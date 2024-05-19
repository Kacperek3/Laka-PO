package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkienkoOdczytZpliku extends JFrame {

    public OkienkoOdczytZpliku() {
        setTitle("Odczyt pliku");
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField Przycisk_odczytZpliku = new JTextField(14);
        JButton confirmButton = new JButton("Zatwierdź");
        JButton wstecz = new JButton("Wstecz");

        confirmButton.addActionListener(e -> {
            String nazwaPliku = Przycisk_odczytZpliku.getText();
            if (nazwaPliku.equals("")) {
                JOptionPane.showMessageDialog(null, "Wprowadź nazwę pliku.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
            else {
                setVisible(false);
                Swiat swiat = new Swiat(0,0, nazwaPliku);
                swiat.setVisible(true);
                swiat.rysujSwiat();
            }
        });


        wstecz.addActionListener(e -> {
            PoczatkoweOkno pierwszeOkienko = new PoczatkoweOkno();
            pierwszeOkienko.setVisible(true);
            dispose();
        });



        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Ustawienie FlowLayout, który ustawi komponenty obok siebie
        panel.add(new JLabel("Nazwa pliku: "));
        panel.add(Przycisk_odczytZpliku);
        panel.add(confirmButton);
        panel.add(wstecz);
        add(panel);

        setResizable(false); // Blokowanie zmiany rozmiaru okna
        setLocationRelativeTo(null); // Ustawienie lokalizacji okna na środek ekranu
        setVisible(true);
    }
}
