package Settings;

import Characters.Hrac;
import Characters.Postava;
import Dialog.DialogLoader;
import World.Svet;

import java.util.Scanner;

/**
 * Třída Controller je zodpovědná za inicializaci a správu hlavních herních objektů,
 * včetně hráče, nepřítele, světa a inventáře. Také umožňuje interakci mezi těmito objekty
 * a připravuje prostředí pro běh hry.
 */
public class Controller {

    Scanner scan = new Scanner(System.in);

    private Hrac hrac;
    private Svet svet;
    private Statistics stats;
    private DialogLoader dialogLoader;

    /**
     * Konstruktor třídy Controller.
     * Vytváří nové instance hráče, nepřítele a světa.
     */
    public Controller() {
    }

    /**
     * Inicializuje hru, vytváří objekty hráče, statistiky, dialogu, světa a nastavuje počáteční stav.
     */
    public void incialization() {
        stats = new Statistics();
        dialogLoader = new DialogLoader(stats);
        svet = new Svet();
        Postava.postava();
    }

    public Svet getSvet() {
        return svet;
    }

    public Statistics getStats() {
        return stats;
    }

    public DialogLoader getDialogLoader() {
        return this.dialogLoader;
    }
}
