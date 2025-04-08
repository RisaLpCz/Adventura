package Console;

import Characters.Hrac;
import Command.*;
import Command.Exit;
import Settings.Controller;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Třída Konzole poskytuje uživatelské rozhraní pro komunikaci s hrou prostřednictvím textových příkazů.
 * Zpracovává příkazy zadané uživatelem, vykonává odpovídající akce a poskytuje zpětnou vazbu.
 */
public class Konzole {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();

    Controller controller;

    /**
     * Inicializuje hru a připraví všechny potřebné komponenty pro spuštění.
     * Vytváří instanci třídy Controller, načítá mapu světa a mapuje příkazy na příslušné implementace.
     */
    public void inicialization() {
        controller = new Controller();
        controller.incialization();
        controller.getSvet().loadMap();
        controller.getDialogLoader().nactiDialogy();

        map.put("goto", new Move(controller));
        map.put("showinventory", new ShowInventory());
        map.put("search", new Search(controller));
        map.put("stop", new Exit(controller));
        map.put("takeitem", new TakeItem(controller));
        map.put("throwitem", new ThrowItem(controller));
        map.put("interact", new Interact());
    }

    private Scanner scanner = new Scanner(System.in);

    /**
     * Zpracovává příkaz zadaný uživatelem a vykonává odpovídající akci.
     * Pokud příkaz není definován, informuje uživatele o neznámém příkazu.
     */
    public void doCommand() {
        System.out.println("Co si přejete udělat: ");
        System.out.println("Pro změnu lokace napište 'goto'" +
                "\npro zobrazení inventáře napište 'showinventory'," +
                "\npro hledání předmětů v lokaci napište 'search'," +
                "\npro sebrání předmětu napište 'takeitem'," +
                "\npro zahození předmětu napište 'throwitem'," +
                "\npro použití předmětu napišřte 'interact'" +
                "\na pro ukončení hry napište 'stop'");
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim().toLowerCase();
        if (map.containsKey(command)) {
            try {
                System.out.println(">> " + map.get(command).execute());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(">> Neidentifikovatelný příkaz");
        }
    }

    /**
     * Spustí hlavní cyklus konzole, který opakovaně přijímá příkazy od uživatele
     * a vykonává je, dokud není hra ukončena.
     */
    public void start() {
        inicialization();
        String uvodniText = Text.loadFile();
        System.out.println(uvodniText);
        Hrac hrac = new Hrac(scanner.nextLine());
        try {
            do {
                doCommand();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
