package Command;

import Belongings.Inventar;
import Characters.Hrac;

/**
 * Třída ShowInventory implementuje příkaz pro zobrazení inventáře hráče.
 * Umožňuje hráči vidět, jaké předměty má v inventáři.
 *
 * @implements Command
 */
public class ShowInventory implements Command {

    private Inventar inventar = Hrac.getInventar();  // Získání inventáře hráče

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
            return "You have " + inventar.getFormattedItems() + " in your inventory";
        }
        return "Your inventory is empty";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
