package Command;

import Belongings.Inventar;
import Characters.Hrac;

public class ShowInventory implements Command {

    private Inventar inventar = Hrac.getInventar();

    @Override
    public String execute() {
        if (!inventar.getItems().isEmpty()) {
            return "You have " + inventar.getItems() + " in your inventory";
        }
        return "Your inventory is empty";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
