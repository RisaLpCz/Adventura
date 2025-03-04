import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Svet {

    private HashMap<Integer, Lokace> world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("hernisvetS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] lines = line.split(";");

                String[] locations = lines.length > 2 ? lines[2].split(",") : new String[0];

                Lokace location = new Lokace(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        locations
                );
                world.put(Integer.valueOf(lines[0]), location);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void zmenLokaci() {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

        currentPosition = 1;

        while (true) {
            Lokace currentLocation = world.get(currentPosition);

            System.out.println("Jste v lokaci: " + currentLocation);
            System.out.print("Zde můžete jít do následujících místností: ");

            int[] connectedLocations = currentLocation.getLocations();
            if (connectedLocations.length == 0) {
                System.out.println("Žádné propojené místnosti.");
            } else {
                for (int i = 0; i < connectedLocations.length; i++) {
                    System.out.print(connectedLocations[i] + " ");
                }
                System.out.println();
            }

            System.out.print("Vyberte číslo místnosti, do které chcete jít (nebo 0 pro zůstat): ");
            try {
                int choice = Integer.parseInt(reader.readLine());


                if (choice == 0) {
                    System.out.println("Zůstáváte v aktuální lokaci.");
                } else if (isValidChoice(choice, connectedLocations)) {

                    currentPosition = choice;
                    System.out.println("Přesouváte se do lokace " + choice);
                } else {
                    System.out.println("Neplatná volba! Zkuste to znovu.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Chyba při čtení vstupu. Zkuste to znovu.");
            }
        }
    }

    private boolean isValidChoice(int choice, int[] connectedLocations) {
        for (int location : connectedLocations) {
            if (location == choice) {
                return true;
            }
        }
        return false;
    }


    public Lokace getCurrentPosition() {
        return world.get(currentPosition);
    }

    public HashMap<Integer, Lokace> getWorld() {
        return world;
    }
}
