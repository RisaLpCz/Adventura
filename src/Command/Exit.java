package Command;

public class Exit implements Command {

    public String execute() {
        System.exit(0);
        return "Hra byla ukoncena";
    }

    public boolean exit() {
        return false;
    }

}
