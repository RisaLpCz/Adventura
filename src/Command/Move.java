package Command;

import Characters.Postava;
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

    /**
     * Konstruktor třídy Move.
     * Inicializuje třídu Controller a získává instanci světa pro manipulaci s lokacemi.
     *
     * @param controller Instance třídy Controller pro získání herního světa.
     */
    public Move(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    /**
     * Provádí pohyb postavy na novou lokaci.
     * Změní lokaci postavy a vrátí textovou zprávu o nové lokaci.
     * Pokud postava dosáhne finální lokace, může být připraven dialog.
     *
     * @return Zpráva o aktuální lokaci hráče.
     */
    @Override
    public String execute() {
        svet = controller.getSvet();
        svet.zmenLokaci();

        if (svet.getCurrentPosition().getID() == 6) {
            // Připravit finální dialog (až budou dialogy dokončeny)
            // Možná přidat k lokaci boolean open, aby byla označena jako otevřená.
        }

        return "Your current location is " + svet.getCurrentPosition();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
