package Command;

import Characters.Hrac;
import Settings.Controller;
import World.Lokace;
import World.Svet;

public class Search implements Command {

    private Controller controller = new Controller();
    private Svet svet = controller.getSvet();
    private Lokace lokace;

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
