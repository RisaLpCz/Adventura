package Command;

public class Exit implements Command {

    public String execute() {
        return "Hra byla ukoncena";
    }

    public boolean exit() {
        System.exit(0);
        return true;
    }

}
