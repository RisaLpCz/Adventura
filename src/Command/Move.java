package Command;

import Characters.Postava;
import Settings.Controller;
import World.Svet;

public class Move implements Command{

    Controller controller;
    private Svet svet;

    public Move(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    @Override
    public String execute() {
        svet = controller.getSvet();
        svet.zmenLokaci();
        if (svet.getCurrentPosition().getID() == 6) {
            //lokace final dialog az budou dialogy dodelany
        }
        return "Your current location is " + svet.getCurrentPosition();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
