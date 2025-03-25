package Command;

import Characters.Hrac;
import Settings.Controller;
import World.Lokace;
import World.Svet;

public class Search implements Command {

    private Controller controller;
    private Svet svet;
    private Lokace lokace;

    public Search(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    @Override
    public String execute() {
        lokace = svet.getCurrentPosition();
        lokace.addLocationItems();
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
