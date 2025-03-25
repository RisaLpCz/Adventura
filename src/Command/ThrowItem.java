package Command;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;
import Settings.Controller;
import World.Lokace;
import World.Svet;

import java.util.Scanner;

public class ThrowItem implements Command {

    private Scanner sc = new Scanner(System.in);
    private Controller controller;
    private Inventar inventar = Hrac.getInventar();
    private Svet svet;
    private Item item;
    private Lokace lokace;

    public ThrowItem(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    @Override
    public String execute() {
        lokace = svet.getCurrentPosition();
        System.out.println("choose which item you want to throw away");
        String itemName = sc.nextLine();
        if (inventar.removeItem(itemName)) {
            this.item = inventar.containsItem(itemName);
            lokace.addItem(item);
            return "You threw away " + item.getName();
        }
        return itemName + " isnt in the inventory";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
