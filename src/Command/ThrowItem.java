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
    private Controller controller = new Controller();
    private Inventar inventar = Hrac.getInventar();
    private Svet svet = controller.getSvet();
    private Item item;
    private Lokace lokace;


    @Override
    public String execute() {
        lokace = svet.getCurrentPosition();
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
