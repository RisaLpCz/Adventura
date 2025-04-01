package Command;

/**
 * Příkaz pro ukončení hry.
 */
public class Exit implements Command {

    /**
     * Ukončí aplikaci.
     *
     * @return Řetězec informující o ukončení hry.
     */
    public String execute() {
        System.exit(0);
        return "Hra byla ukoncena";
    }

    public boolean exit() {
        return true;
    }
}