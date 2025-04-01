package World;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;
import Characters.Postava;

import java.io.*;
import java.util.*;

/**
 * Třída Svet reprezentuje herní svět, který obsahuje různé lokace, kam se může hráč přesouvat.
 * Třída umožňuje načítání mapy světa z externího souboru a správu přesunů mezi jednotlivými lokacemi.
 */
public class Svet {
    private HashMap<Integer, Lokace> world = new HashMap<>();
    private int start = 1;
    private int currentPosition = start;

    /**
     * Konstruktor třídy Svet.
     * Inicializuje svět a pokusí se načíst mapu světa z externího souboru.
     */
    public Svet() {
        if (!loadMap()) {
            System.out.println("Svet load failed");
        }
    }

    /**
     * Načte mapu světa z externího textového souboru.
     *
     * @return true, pokud byla mapa načtena úspěšně, jinak false.
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("hreniSvet2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String[] locations = parts.length > 2 ? parts[2].split(",") : new String[0];
                String[] items = parts.length > 3 ? parts[3].split(",") : new String[0];

                Lokace location = new Lokace(name, id, locations, items);
                world.put(id, location);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Chyba při načítání souboru: " + e.getMessage());
            return false;
        }
    }

    /**
     * Umožňuje hráči změnit lokaci na základě volby ze seznamu propojených lokací.
     * V případě, že hráč je opilý, může se stát, že zamíří do jiné lokace, než zamýšlel.
     */
    public void zmenLokaci() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        Lokace currentLocation = world.get(currentPosition);
        if (currentLocation == null) {
            System.out.println("Chyba: Aktuální lokace neexistuje!");
            return;
        }

        System.out.println("Jste v lokaci: " + currentLocation);
        System.out.print("Zde můžete jít do následujících místností: ");

        int[] connectedLocations = currentLocation.getLocations();
        if (connectedLocations.length == 0) {
            System.out.println("Žádné propojené místnosti.");
            return;
        } else {
            for (int loc : connectedLocations) {
                System.out.print(loc + " ");
            }
            System.out.println();
        }

        List<Item> items = currentLocation.getItems();
        System.out.println("Předměty v lokaci: " + (items.isEmpty() ? "Žádné" : items));

        System.out.print("Vyberte číslo místnosti, do které chcete jít (nebo 0 pro zůstat): ");
        try {
            int choice = Integer.parseInt(reader.readLine());

            if (choice == 0) {
                System.out.println("Zůstáváte v aktuální lokaci.");

            } else if (isValidChoice(choice, connectedLocations)) {
                double drunkenness = Postava.getDrunkenness();
                Postava.setDrunkenness(drunkenness - 0.5);

                if (drunkenness > 2 && random.nextDouble() < 0.5) {
                    choice = connectedLocations[random.nextInt(connectedLocations.length)];
                    System.out.println("Jste moc opilý a omylem jste se vydali jinam...");
                } else if (drunkenness > 1 && random.nextDouble() < 0.25) {
                    choice = connectedLocations[random.nextInt(connectedLocations.length)];
                    System.out.println("Motáte se trochu a nakonec jdete jinam...");
                } else if (drunkenness > 0.5 && random.nextDouble() < 0.1) {
                    choice = connectedLocations[random.nextInt(connectedLocations.length)];
                    System.out.println("Zavrávorali jste a nechtěně jste se vydali jinam...");
                }

                currentPosition = choice;
                System.out.println("Přesouváte se do lokace " + choice);
            } else {
                System.out.println("Neplatná volba! Zkuste to znovu.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Chyba při čtení vstupu. Zkuste to znovu.");
        }
    }

    /**
     * Zkontroluje, zda je volba pro změnu lokace platná.
     *
     * @param choice Zvolená lokalita.
     * @param connectedLocations Seznam propojených lokalit.
     * @return true, pokud je volba platná, jinak false.
     */
    private boolean isValidChoice(int choice, int[] connectedLocations) {
        for (int loc : connectedLocations) {
            if (loc == choice) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ověří, zda hráč nasbíral všechny požadované předměty a otevře přístup do konečné lokace.
     */
    public void finalLocation() {
        Inventar inventar = Hrac.getInventar();
        if (inventar.allItemsCollected()) {
            System.out.println("Prisup do jeskyne byl otevren");
        }
    }

    /**
     * Získá aktuální lokaci podle jejího ID.
     *
     * @return Aktuální Lokace.
     */
    public Lokace getCurrentPosition() {
        return world.get(currentPosition);
    }

    public HashMap<Integer, Lokace> getWorld() {
        return world;
    }

    @Override
    public String toString() {
        return getWorld().toString();
    }
}
