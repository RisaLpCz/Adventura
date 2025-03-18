package Command;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;
import Belongings.Inventar;
import Settings.SETTINGS;
import World.Lokace;

import java.util.Scanner;

public class TakeItem implements Command {

    private Lokace lokace = new Lokace();
    private Inventar inventar;
    private Item item;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        if (inventar.addItem(chooseItem()) && !inventar.isFull()) {
            return "You added " + getItem().getName() + " to your inventory";
        } else if (inventar.isFull()) {
            return "Your inventory is full";
        }
        return "Item couldnt be added to your inventory";
    }

    public Item chooseItem() {
        System.out.println("Items in your location: " + lokace.getItems() + " please choose an item");
        String itemName = scanner.nextLine();
        if (lokace.containsItem(itemName) != null) {
            setItem(lokace.containsItem(itemName));
            return item;
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
