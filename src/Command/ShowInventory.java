package Command;

import Belongings.Inventar;
import Characters.Hrac;
import Characters.Postava;

/**
 * Třída ShowInventory implementuje příkaz pro zobrazení inventáře hráče.
 * Umožňuje hráči vidět, jaké předměty má v inventáři.
 *
 * @implements Command
 */
public class ShowInventory implements Command {

    private Inventar inventar = Hrac.getInventar();

    /**
     * Provádí zobrazení aktuálního inventáře hráče.
     * Pokud hráč má nějaké předměty, zobrazí jejich seznam.
     * Pokud je inventář prázdný, vrátí zprávu o prázdném inventáři.
     *
     * @return Zpráva o obsahu inventáře hráče.
     */
    @Override
    public String execute() {
        if (!inventar.getFormattedItems().isEmpty()) {
            return "Máte v inventáři " + inventar.getFormattedItems() + " a váš stav je " + Postava.playerStete();
        }
        return "Váš inventář je prázdný";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
