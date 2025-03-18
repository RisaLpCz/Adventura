package Command;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;

import java.util.Scanner;

public class ThrowItem implements Command {

    Scanner sc = new Scanner(System.in);
    Inventar inventar;
    Item item;

    @Override
    public String execute() {
        String itemName = sc.nextLine();
        if (inventar.removeItem(itemName)) {
            return "You threw away " + item.getName();
        }
        return itemName + " isnt in the inventory";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
