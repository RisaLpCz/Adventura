package Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Text {

    public static String loadFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("UvdniText.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Nastala chyba při načítání";
        }
        return content.toString().trim();
    }


}