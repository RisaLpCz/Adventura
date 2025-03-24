package Command;

import Belongings.Inventar;
import Characters.Hrac;
import Belongings.Item;

import java.util.Scanner;

public class Interact implements Command {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        Inventar inventar = Hrac.getInventar();
        Item item = inventar.containsItem(scanner.nextLine());

        if (item != null) {

        }


        System.out.println(item.getName() + " " + item.getDescription());
        //case item.isUsable usetIt?...
        scanner.close();
        return "You used your item";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
