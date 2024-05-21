package GUI;

import modelOrganizmy.rosliny.*;
import modelOrganizmy.zwierzeta.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodawanieZwierzeciaFrame extends JFrame {

    private JList<String> listaZwierzat;
    private JButton potwierdzButton;
    private String[] zwierzeta = {"Wilk", "Owca", "Lis", "Zolw", "Antylopa", "Trawa", "Mlecz", "Guarana", "Wilcze Jagody", "Barszcz Sosnowskiego"};

    public DodawanieZwierzeciaFrame(Swiat swiat, int i, int j) {
        setTitle("Dodaj Zwierzę");
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tworzenie listy zwierząt
        listaZwierzat = new JList<>(zwierzeta);
        listaZwierzat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Dodawanie listy do JScrollPane, aby była przewijana
        JScrollPane scrollPane = new JScrollPane(listaZwierzat);
        scrollPane.setPreferredSize(new Dimension(250, 100));

        // Tworzenie przycisku "Potwierdź"
        potwierdzButton = new JButton("Potwierdź");
        potwierdzButton.setEnabled(false); // Początkowo wyłączony

        // Dodaj ActionListener do listy, aby włączać/wyłączać przycisk
        listaZwierzat.addListSelectionListener(e -> potwierdzButton.setEnabled(!listaZwierzat.isSelectionEmpty()));

        // Dodaj ActionListener do przycisku
        potwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybraneZwierze = listaZwierzat.getSelectedValue();
                if (wybraneZwierze != null) {
                    switch (wybraneZwierze) {
                        case "Wilk":
                            swiat.DodajOrganizm(new Wilk(i, j, swiat));
                            break;
                        case "Owca":
                            swiat.DodajOrganizm(new Owca(i, j, swiat));
                            break;
                        case "Lis":
                            swiat.DodajOrganizm(new Lis(i, j, swiat));
                            break;
                        case "Zolw":
                            swiat.DodajOrganizm(new Zolw(i, j, swiat));
                            break;
                        case "Antylopa":
                            swiat.DodajOrganizm(new Antylopa(i, j, swiat));
                            break;
                        case "Trawa":
                            swiat.DodajOrganizm(new Trawa(i, j, swiat));
                            break;
                        case "Mlecz":
                            swiat.DodajOrganizm(new Mlecz(i, j, swiat));
                            break;
                        case "Guarana":
                            swiat.DodajOrganizm(new Guarana(i, j, swiat));
                            break;
                        case "Wilcze Jagody":
                            swiat.DodajOrganizm(new Wilcze_Jagody(i, j, swiat));
                            break;
                        case "Barszcz Sosnowskiego":
                            swiat.DodajOrganizm(new Barszcz_Sosnowskiego(i, j, swiat));
                            break;
                    }
                    swiat.rysujSwiatbezTury();
                }
                dispose();
            }
        });



        JPanel buttonPanel = new JPanel();
        buttonPanel.add(potwierdzButton);

        // Dodawanie komponentów do okna
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
