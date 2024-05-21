package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class LogiGry {
    private JFrame okno;
    private JTextArea obszarTekstowy;

    public LogiGry() {
        okno = new JFrame("Logi Gry");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(500, 400);

        obszarTekstowy = new JTextArea();
        obszarTekstowy.setEditable(false);

        JScrollPane przewijanie = new JScrollPane(obszarTekstowy);
        przewijanie.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        okno.getContentPane().add(przewijanie, BorderLayout.CENTER);

        //PrintStream strumieńDruku = new PrintStream(new NiestandardowyStrumieńWyjściowy(obszarTekstowy));
        //System.setOut(strumieńDruku);
        //System.setErr(strumieńDruku);

        okno.setVisible(true);
    }

    /* private static class NiestandardowyStrumieńWyjściowy extends OutputStream {
        private JTextArea obszarTekstowy;

        public NiestandardowyStrumieńWyjściowy(JTextArea obszarTekstowy) {
            this.obszarTekstowy = obszarTekstowy;
        }

        @Override
        public void write(int b) {
            SwingUtilities.invokeLater(() -> {
                obszarTekstowy.append(String.valueOf((char) b));
                obszarTekstowy.setCaretPosition(obszarTekstowy.getDocument().getLength());
            });
        }

        @Override
        public void write(byte[] b, int off, int len) {
            SwingUtilities.invokeLater(() -> {
                obszarTekstowy.append(new String(b, off, len));
                obszarTekstowy.setCaretPosition(obszarTekstowy.getDocument().getLength());
            });
        }
    }*/

    public void log(String wiadomosc) {
        SwingUtilities.invokeLater(() -> {
            obszarTekstowy.append(wiadomosc + "\n");
            obszarTekstowy.setCaretPosition(obszarTekstowy.getDocument().getLength());
        });
    }

    public void wyczysc() {
        SwingUtilities.invokeLater(() -> {
            obszarTekstowy.setText("");
        });
    }
}
