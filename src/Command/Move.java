package Command;

import Characters.Postava;
import World.Svet;

public class Move implements Command{

    private Svet svet;

    @Override
    public String execute() {
        svet.zmenLokaci();
        return "Your current location is " + svet.getCurrentPosition();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
