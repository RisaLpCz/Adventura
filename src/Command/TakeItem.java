package Command;

import Belongings.Inventar;
import Belongings.Item;
import Characters.Hrac;
import Settings.Controller;
import Settings.SETTINGS;
import World.Lokace;
import World.Svet;

import java.io.IOException;
import java.util.Scanner;

/**
 * Třída TakeItem implementuje příkaz pro sebrání předmětu z aktuální lokace.
 * Umožňuje hráči vybrat předmět z lokace a přidat jej do inventáře, pokud není plný.
 *
 * @implements Command
 */
public class TakeItem implements Command {

    private Controller controller;
    private Svet svet;
    private Lokace lokace;
    private Inventar inventar = Hrac.getInventar();
    private Item item;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor třídy TakeItem.
     * Inicializuje třídu TakeItem a získává instanci Controller pro přístup k hernímu světu.
     *
     * @param controller Instance třídy Controller pro získání herního světa.
     */
    public TakeItem(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    /**
     * Provádí sebrání předmětu z aktuální lokace a přidání do inventáře.
     * Pokud je inventář plný, vrátí zprávu o plném inventáři.
     * Pokud se předmět v lokaci nenachází, vrátí chybu.
     *
     * @return Zpráva o výsledku pokusu o sebrání předmětu.
     * @throws IOException Pokud předmět není nalezen na lokaci.
     */
    @Override
    public String execute() throws IOException {
        lokace = svet.getCurrentPosition();
        item = chooseItem();
        if (item != null && !inventar.isFull()) {
            lokace.removeItem(item);
            inventar.addItem(item);
            return "You added " + item.getName() + " to your inventory";
        } else if (inventar.isFull()) {
            return "Your inventory is full";
        }
        return "Item couldn't be added to your inventory";
    }

    /**
     * Umožňuje hráči vybrat předmět z aktuální lokace.
     * Zobrazí seznam předmětů v lokaci a čeká na výběr hráče.
     * Pokud je předmět v lokaci nalezen, vrátí tento předmět, jinak vyvolá výjimku.
     *
     * @return Vybraný předmět.
     * @throws IOException Pokud předmět v lokaci není nalezen.
     */
    public Item chooseItem() throws IOException {
        System.out.println("Items in your location: " + lokace.getItems() + " please choose an item :");
        String itemName = scanner.nextLine();
        if (lokace.containsItem(itemName) == null) {
            throw new IOException("Item " + itemName + " not found");
        }
        setItem(lokace.containsItem(itemName));
        return item;
    }

    @Override
    public boolean exit() {
        return false;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
