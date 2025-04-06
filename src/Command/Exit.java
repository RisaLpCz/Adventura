package Command;

import Settings.Controller;
import Settings.Statistics;
import World.Svet;

/**
 * Příkaz pro ukončení hry.
 * Vypsání statistik.
 */
public class Exit implements Command {

    private Controller controller;
    private Statistics stat;

    /**
     * Konstruktor třídy Exit.
     * Inicializuje třídu Controller a získává instanci statictik.
     *
     * @param controller Instance třídy Controller pro získání statistik.
     */
    public Exit(Controller controller) {
        this.controller = controller;
        this.stat = controller.getStats();
    }

    /**
     * Ukončí aplikaci.
     * Uloží konečný čas a vypíše statistiky.
     * @return Řetězec informující o ukončení hry.
     */
    public String execute() {
        stat.setEndTime(System.currentTimeMillis());
        System.out.println(stat);
        System.exit(0);
        return "Hra byla ukoncena";
    }

    public boolean exit() {
        return true;
    }
}