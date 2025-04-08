package Command;

import Characters.Postava;
import Dialog.DialogLoader;
import Settings.Controller;
import World.Svet;

/**
 * Třída Move implementuje příkaz pro pohyb postavy v herním světě.
 * Umožňuje změnit lokaci hráče v herním světě a vrátit informaci o nové lokaci.
 *
 * @implements Command
 */
public class Move implements Command {

    private Controller controller;
    private Svet svet;
    private DialogLoader dialogLoader;

    /**
     * Konstruktor třídy Move.
     * Inicializuje třídu Controller a získává instanci světa pro manipulaci s lokacemi.
     *
     * @param controller Instance třídy Controller pro získání herního světa.
     */
    public Move(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
        this.dialogLoader = controller.getDialogLoader();
    }

    /**
     * Provádí pohyb postavy na novou lokaci.
     * Změní lokaci postavy a vrátí textovou zprávu o nové lokaci.
     * Pokud postava dosáhne finální lokace, spustí finalní metodu.
     *
     * @return Zpráva o aktuální lokaci hráče.
     */
    @Override
    public String execute() {
        svet = controller.getSvet();
        svet.zmenLokaci();
        System.out.println(dialogLoader.vypisDialog(svet.getCurrentPosition().getID()));
        svet.encounterWithCreditor();


        if (svet.getCurrentPosition().getID() == 6) {
            svet.finalLocation();
        }

        return "Nacházíte se v " + svet.getCurrentPosition();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
