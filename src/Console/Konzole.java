package Console;

import Characters.Hrac;
import Command.*;
import Command.Exit;
import Settings.Controller;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();

    Controller controller;

    public void inicialization() {
        controller = new Controller();
        System.out.println("Type your name: ");
        controller.incialization();
        controller.getSvet().loadMap();

        map.put("goto", new Move(controller));
        map.put("showinventory", new ShowInventory());
        map.put("search", new Search(controller));
        map.put("stop", new Exit());
        map.put("takeitem", new TakeItem(controller));
        map.put("throwitem", new ThrowItem(controller));
        map.put("interact", new Interact());
    }


    private Scanner scanner = new Scanner(System.in);

    public void doCommand() {
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        if (map.containsKey(command)) {
            System.out.println(">> " + map.get(command).execute());
        } else {
            System.out.println(">> Nondefined command");
        }
    }

    public void start() {
        inicialization();
        try {
            do {
                doCommand();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void message(Hrac hrac) {
    }

    public void clear(Hrac hrac) {
    }
}
