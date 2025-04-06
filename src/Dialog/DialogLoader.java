package Dialog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DialogLoader {
    private final HashMap<Integer, Dialog> dialogy = new HashMap<>();

    public boolean nactiDialogy(String nazevSouboru) {
        try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                if (radek.trim().isEmpty()) continue;

                String[] casti = radek.split(";", 4);
                if (casti.length < 4) continue;

                int id = Integer.parseInt(casti[0].trim());
                String jmeno = casti[1].trim();
                String popis = casti[2].trim();
                String replika = casti[3].trim();

                dialogy.put(id, new Dialog(jmeno, popis, replika));
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Chyba při načítání dialogů: " + e.getMessage());
            return false;
        }
    }

    public Dialog ziskejDialog(int lokaceId) {
        return dialogy.get(lokaceId);
    }

    public void vypisDialog(int lokaceId) {
        Dialog dialog = dialogy.get(lokaceId);
        if (dialog != null) {
            System.out.println(dialog.vypisDialog());
        }
    }
}

