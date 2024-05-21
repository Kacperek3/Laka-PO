package pomocnicze;

import modelOrganizmy.Organizm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ZapisDoPliku {
    private String filename;

    public ZapisDoPliku(String filename) {
        this.filename = filename;
    }

    public void zapisz(List<Organizm> organizmy, int szerokoscPlanszy, int wysokoscPlanszy) {
        try {
            // Pobierz bieżący katalog roboczy
            String currentDirectory = new File("").getAbsolutePath();
            // Przejdź jeden katalog w górę
            File parentDirectory = new File(currentDirectory).getParentFile();

            // Utwórz ścieżkę do katalogu ZapisyPlanszy, który jest równoległy do GUI
            File zapisyPlanszyDir = new File(parentDirectory, "ZapisyPlanszy");

            // Upewnij się, że katalog ZapisyPlanszy istnieje
            if (!zapisyPlanszyDir.exists()) {
                zapisyPlanszyDir.mkdirs(); // Utwórz katalog, jeśli nie istnieje
            }

            // Połącz katalog i nazwę pliku, aby uzyskać pełną ścieżkę do pliku
            File file = new File(zapisyPlanszyDir, filename);
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Zapisz szerokość i wysokość planszy
            bufferedWriter.write(szerokoscPlanszy + " " + wysokoscPlanszy);
            bufferedWriter.newLine();

            // Zapisz informacje o każdym organizmie
            for (Organizm org : organizmy) {
                bufferedWriter.write(org.getPolozenieX() + " " + org.getPolozenieY() + " " +
                        org.TypObiektu + " " + org.getWiek() + " " + org.getSila() + " " +
                        org.liczbaDniBezplodnych + " " + org.TarczaAlzura + " " + org.TarczaCoolDown);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Zapisano obiekty do pliku: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania danych do pliku.");
            e.printStackTrace();
        }
    }
}
