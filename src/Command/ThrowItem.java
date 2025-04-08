package Command;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;
import Settings.Controller;
import World.Lokace;
import World.Svet;

import java.util.Scanner;

/**
 * Třída ThrowItem implementuje příkaz pro vyhození předmětu z inventáře do aktuální lokace.
 * Umožňuje hráči zvolit předmět, který chce vyhodit, a přidat ho zpět do lokace.
 *
 * @implements Command
 */
public class ThrowItem implements Command {

    private Scanner sc = new Scanner(System.in);
    private Controller controller;
    private Inventar inventar = Hrac.getInventar();
    private Svet svet;
    private Item item;
    private Lokace lokace;

    /**
     * Konstruktor třídy ThrowItem.
     * Inicializuje třídu ThrowItem a získává instanci Controller pro přístup k hernímu světu.
     *
     * @param controller Instance třídy Controller pro získání herního světa.
     */
    public ThrowItem(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    /**
     * Provádí vyhození předmětu z inventáře a přidání ho do aktuální lokace.
     * Pokud předmět není v inventáři, vrátí informaci o chybě.
     *
     * @return Zpráva o výsledku pokusu o vyhození předmětu.
     */
    @Override
    public String execute() {
        lokace = svet.getCurrentPosition();
        System.out.println("Vyberte si předmět z vašeho inventáře: " + inventar.getFormattedItems() + " který z nich chete zahodnit?");
        String itemName = sc.nextLine();
        if (inventar.removeItem(itemName)) {
            this.item = inventar.containsItem(itemName);
            lokace.addItem(item);
            return "Zahodil jste " + item.getName();
        }
        return itemName + " není ve vašem inventáři";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
