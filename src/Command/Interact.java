package Command;

import Belongings.Inventar;
import Characters.Hrac;
import Belongings.Item;

public class Interact implements Command {

    private Inventar inventar;
    private Item item;

    @Override
    public String execute() {
        System.out.println("Item " + item.getName() + " is " + item.discription());
        //item getDiscripiton
        //case what do you want to do with it
        //case item.isUsable usetIt?... isEatable... EatIt?
        return "You used your item";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
