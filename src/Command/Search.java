package Command;

import Characters.Hrac;
import World.Lokace;

public class Search implements Command {

    private Lokace lokace;

    @Override
    public String execute() {
        if (!lokace.getItems().isEmpty()) {
            return "You have found these items " + lokace.getItems();
        }
        return "No items found";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
