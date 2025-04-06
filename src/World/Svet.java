package World;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;
import Characters.Postava;
import Command.Exit;
import Settings.Controller;

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
    private Controller controller;

    /**
     * Konstruktor třídy Svet.
     * Inicializuje svět a pokusí se načíst mapu světa z externího souboru.
     */
    public Svet() {
        controller = new Controller();
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
        try (BufferedReader br = new BufferedReader(new FileReader("hreniSvet.txt"))) {
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

        checkSpecialAccess();
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
                revalidateState();
                double drunkenness = Postava.getDrunkenness();

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
        encounterWithCreditor();
    }

    /**
     * Zkontroluje, zda je volba pro změnu lokace platná.
     *
     * @param choice             Zvolená lokalita.
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
     * Ověří, zda daná lokace obsahuje propojení na konkrétní lokaci.
     *
     * @param location Lokace, kterou kontrolujeme.
     * @param targetID ID lokace, kterou hledáme v propojených lokacích.
     * @return true, pokud daná lokace obsahuje propojení na targetID, jinak false.
     */
    private boolean containsLocation(Lokace location, int targetID) {
        for (int locID : location.getLocations()) {
            if (locID == targetID) {
                return true;
            }
        }
        return false;
    }


    /**
     * Ověří, zda hráč nasbíral všechny požadované předměty a otevře přístup do konečné lokace.
     */
    private void checkSpecialAccess() {
        Inventar inventar = Hrac.getInventar();

        if (inventar.allItemsCollected()) {
            Lokace loc4 = world.get(4);
            Lokace loc5 = world.get(5);

            if (!containsLocation(loc4, 6)) {
                loc4.addLocation(6);
                System.out.println("Speciální lokace 6 byla zpřístupněna z lokace 4!");
            }

            if (!containsLocation(loc5, 6)) {
                loc5.addLocation(6);
                System.out.println("Speciální lokace 6 byla zpřístupněna z lokace 5!");
            }
        }
    }

    /**
     * Metoda pro zajištění, že stav hráče (jídlo, pití a opilost) je správně upraven po každé akci.
     * Tato metoda sníží hodnoty jídla, pití a opilosti o určité množství:
     * - Jídlo je sníženo o 1 (pokud je více než 1, jinak na 0).
     * - Pití je sníženo o 1 (pokud je více než 1, jinak na 0).
     * - Opilost je snížena o 0.5 (pokud je více než 0.5, jinak na 0).
     *
     * Tato metoda se volá po každé akci, která ovlivňuje stav hráče, jako je pohyb mezi lokacemi nebo interakce s okolím.
     */
    private void revalidateState() {
        int food = Postava.getFood();
        int drink = Postava.getDrink();
        double drunkenness = Postava.getDrunkenness();

        if (food > 1) {
            Postava.setFood(food - 1);
        } else {
            Postava.setFood(0);
        }

        if (drink > 1) {
            Postava.setDrink(drink - 1);
        } else {
            Postava.setDrink(0);
        }

        if (drunkenness > 0.5) {
            Postava.setDrunkenness(drunkenness - 0.5);
        } else if (drunkenness <= 0.5) {
            Postava.setDrunkenness(0);
        }
    }


    /**
     * Metoda simuluje náhodné setkání hráče s věřitelem a rozhoduje o dalším průběhu na základě stavu hráče.
     * Hráč má šanci narazit na věřitele, přičemž pravděpodobnost je 1 ku 6. Pokud věřitel je nalezen,
     * hráč musí mít dostatek jídla (minimálně 6), pití (minimálně 6) a opilost nesmí přesáhnout hodnotu 1,
     * aby mohl věřiteli utéct. V opačném případě musí zaplatit 50 korun.
     *
     * Pokud hráč nemá dostatek peněz na zaplacení (méně než 50 korun), věřitel ho zabije a hra končí.
     *
     * Pokud hráč unikne věřiteli, vypíše se příslušná zpráva, a pokud zaplatí, jeho peníze se sníží o 50.
     *
     * @see Postava
     */
    public void encounterWithCreditor() {
        Exit exit = new Exit(controller);
        Random random = new Random();
        boolean metCreditor = random.nextInt(6) == 0;

        if (metCreditor) {
            System.out.println("Narazil jsi na věřitele!");

            int food = Postava.getFood();
            int drink = Postava.getDrink();
            double drunkenness = Postava.getDrunkenness();

            if (food >= 6 && drink >= 6 && drunkenness <= 1) {
                System.out.println("Utekl jsi věřiteli!");
            } else {
                System.out.println("Nebyl jsi schopen utéct a musíš zaplatit věřiteli 50 korun.");
                Postava.setMoney(Postava.getMoney() - 50);
                System.out.println("Nyní máš u sebe " + Postava.getMoney() + " korun.");
            }
        } else if (Postava.getMoney() < 50) {
            System.out.println("Jelikož nemáš dostatek peněz na splátku tak tě věřitel zabil.");
            System.out.println("Hra končí!");
            exit.execute();
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

