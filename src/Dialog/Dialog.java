package Dialog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dialog {

    private final String jmenoPostavy;
    private final String popis;
    private final String replika;
    private HashMap<Integer, Dialog> dialogy = new HashMap<>();

    public Dialog(String jmenoPostavy, String popis, String replika) {
        this.jmenoPostavy = jmenoPostavy;
        this.popis = popis;
        this.replika = replika;
    }

    public String getJmeno() {
        return jmenoPostavy;
    }

    public String getPopis() {
        return popis;
    }

    public String getReplika() {
        return replika;
    }

    public String vypisDialog() {
        return jmenoPostavy + popis + jmenoPostavy + ": \"" + replika;
    }

    public boolean loadDialogy() {
        try (BufferedReader br = new BufferedReader(new FileReader("dialogyPostavy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";", 4);
                int locationID = Integer.parseInt(parts[0].trim());
                String jmeno = parts[1].trim();
                String popis = parts[2].trim();
                String replika = parts[3].trim();

                dialogy.put(locationID, new Dialog(jmeno, popis, replika));
            }
            return true;
        } catch (IOException e) {
            System.out.println("Chyba při načítání: " + e.getMessage());
            return false;
        }
    }
}
