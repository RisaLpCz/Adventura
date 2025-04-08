package Dialog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dialog {

    private final String jmenoPostavy;
    private final String popis;
    private final String replika;
    private final String ukol;
    private boolean read;
    private HashMap<Integer, Dialog> dialogy = new HashMap<>();

    public Dialog(String jmenoPostavy, String popis, String replika, String ukol) {
        this.jmenoPostavy = jmenoPostavy;
        this.popis = popis;
        this.replika = replika;
        this.ukol = ukol;
        this.read = false;
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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getUkol() {
        return ukol;
    }

    public String vypisDialog() {
        return "\n======================================\n"
                + "👤 " + jmenoPostavy + "\n"
                + "📜 " + popis + "\n\n"
                + jmenoPostavy + ": \"" + replika + "\""
                + "\n======================================\n";
    }

    public String vypisUkol() {
        return "\n======================================\n"
                + "Od " + jmenoPostavy + " jsi se dozvěděl následující" + "\n"
                + " " + "" + "\n\n"
                + ukol + "\""
                + "\n======================================\n";
    }
}
