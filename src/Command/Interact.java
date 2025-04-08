package Command;

import Belongings.Inventar;
import Characters.Hrac;
import Belongings.Item;
import Characters.Postava;

import java.util.Scanner;

/**
 * Třída Interact implementuje příkaz pro použití předmětu z inventáře hráče.
 * Umožňuje hráči vybrat předmět, který chce použít, a poté aktualizuje jeho stav.
 *
 * @implements Command
 */
public class Interact implements Command {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Provádí použití vybraného předmětu z inventáře.
     * Po použití předmětu aktualizuje stav hráče a vrátí zprávu o stavu po použití.
     *
     * @return Zpráva o použití předmětu a aktuálním stavu hráče.
     */
    @Override
    public String execute() {
        Inventar inventar = Hrac.getInventar();
        System.out.println("Vyberte předmět, který chete použít: " + inventar.getFormattedItems());
        Item item = inventar.containsItem(scanner.nextLine());

        if (item != null && item.isUseable()) {
            item.useItem(item);
            return "Použil jste " + item.getName() + " váš stav je: " + Postava.playerStete();
        }
        return "předmět nenalezen";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
