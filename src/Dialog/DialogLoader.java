package Dialog;

import Settings.Controller;
import Settings.Statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Třída pro načítání a správu dialogů postav v hře. Tato třída se stará o načítání dialogů
 * z externího souboru a o jejich interakci s hráčem, včetně přidávání úkolů a sledování
 * počtu interakcí a úkolů hráče.
 */
public class DialogLoader {
    private final HashMap<Integer, Dialog> dialogy = new HashMap<>();
    private Statistics stats = new Statistics();

    /**
     * Konstruktor pro inicializaci objektu DialogLoader s předanou statistikou.
     *
     * @param statistics Objekt třídy Statistics pro sledování statistik hráče.
     */
    public DialogLoader(Statistics statistics) {
        stats = statistics;
    }

    /**
     * Načte dialogy z externího souboru "dialogyPostavy.txt". Každý řádek v souboru
     * obsahuje informace o dialogu (ID, jméno, popis, repliku a úkol), které jsou
     * následně uloženy do mapy podle ID.
     *
     * @return true, pokud se dialogy úspěšně načetly, false v případě chyby.
     */
    public boolean nactiDialogy() {
        try (BufferedReader br = new BufferedReader(new FileReader("dialogyPostavy.txt"))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                if (radek.trim().isEmpty()) continue;

                String[] casti = radek.split(";", 5);
                if (casti.length < 5) continue;

                int id = Integer.parseInt(casti[0].trim());
                String jmeno = casti[1].trim();
                String popis = casti[2].trim();
                String replika = casti[3].trim();
                String ukol = casti[4].trim();

                dialogy.put(id, new Dialog(jmeno, popis, replika, ukol));
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Chyba při načítání dialogů: " + e.getMessage());
            return false;
        }
    }

    public Dialog getDialog(int lokaceId) {
        return dialogy.get(lokaceId);
    }

    /**
     * Vypíše dialog nebo úkol hráči na základě toho, zda byl dialog již zobrazen.
     * Pokud byl dialog již zobrazen, vypíše úkol pro hráče.
     *
     * @param lokaceId ID lokace, pro kterou chceme zobrazit dialog nebo úkol.
     * @return Textový řetězec obsahující dialog nebo úkol.
     */
    public String vypisDialog(int lokaceId) {
        Dialog dialog = dialogy.get(lokaceId);
        if (!dialog.isRead()) {
            dialog.setRead(true);
            stats.setNumberOfInteractions(stats.getNumberOfInteractions() + 1);
            return dialog.vypisDialog();
        }
        stats.setNumberOfQuests(stats.getNumberOfQuests() + 1);
        return dialog.vypisUkol();
    }

    /**
     * Vrátí textovou reprezentaci objektu DialogLoader, která zahrnuje seznam všech
     * dialogů načtených v rámci této instance.
     *
     * @return Textová reprezentace objektu DialogLoader.
     */
    @Override
    public String toString() {
        return "DialogLoader{" +
                "dialogy=" + dialogy +
                '}';
    }
}
