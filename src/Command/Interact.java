package Command;

import Belongings.Inventar;
import Characters.Hrac;
import Belongings.Item;
import Characters.Postava;

import java.util.Scanner;

public class Interact implements Command {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        Inventar inventar = Hrac.getInventar();
        System.out.println("Choose which item you want to use");
        Item item = inventar.containsItem(scanner.nextLine());

        if (item != null && item.isUseable()) {
            item.useItem(item);
            System.out.println("You have used " + item.getName() + " your current state is: " + Postava.playerStete());
        }
        scanner.close();
        return "You used your item";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
