package Belongings;

import Characters.Postava;
import Settings.SETTINGS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída představuje inventář postavy ve hře.
 * Umožňuje přidávat, odebírat a kontrolovat předměty.
 */
public class Inventar {

    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Přidá položku do inventáře nebo přidá peníze, pokud jde o peněžní předmět.
     *
     * @param item Přidávaný předmět.
     * @return pokud byl předmět úspěšně přidán.
     */
    public boolean addItem(Item item) {
        if (item.isMoney()) {
            Postava.setMoney(Postava.getMoney() + item.getAmount());
            System.out.println("You received " + item.getAmount() + " coins!");
        } else if (items.size() <= SETTINGS.INVENTORYSIZE && item != null) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Odebere položku z inventáře podle názvu.
     *
     * @param itemName Název předmětu k odstranění.
     * @return pokud byl předmět nalezen a odstraněn.
     */
    public boolean removeItem(String itemName) {
        Item item = containsItem(itemName);
        if (item != null) {
            items.remove(item);
            return true;
        }
        return false;
    }

    /**
     * Odebere konkrétní instanci předmětu z inventáře.
     *
     * @param item Předmět k odstranění.
     * @return pokud byl předmět odstraněn.
     */
    public boolean removeItem(Item item) {
        if (item != null) {
            items.remove(item);
            return true;
        }
        return false;
    }

    /**
     * Zkontroluje, zda se v inventáři nachází předmět se zadaným názvem.
     *
     * @param itemName Název hledaného předmětu.
     * @return Nalezený předmět.
     */
    public Item containsItem(String itemName) {
        for (Item item : items) {
            if (itemName.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    /**
     * Ověří, zda hráč nasbíral všechny důležité předměty.
     *
     * @return pokud jsou všechny klíčové předměty v inventáři, jinak.
     */
    public boolean allItemsCollected() {
        return containsItem("Old Map") != null &&
                containsItem("Note in a bottle") != null &&
                containsItem("Symbols") != null &&
                containsItem("Bison hoof") != null;
    }

    /**
     * Ověří, zda je inventář prázdný.
     *
     * @return pokud je inventář prázdný, jinak.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Ověří, zda je inventář plný.
     *
     * @return pokud je počet předmětů roven maximální kapacitě inventáře.
     */
    public boolean isFull() {
        return items.size() == SETTINGS.INVENTORYSIZE;
    }

    /**
     * Vrátí seznam předmětů v inventáři ve formátovaném textu.
     *
     * @return Řetězec s přehledem předmětů v inventáři.
     */
    public String getFormattedItems() {
        if (items.isEmpty()) {
            return "Inventory is empty";
        }

        HashMap<String, Integer> itemCounts = new HashMap<>();
        for (Item item : items) {
            itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
        }

        ArrayList<String> formattedItems = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            if (entry.getValue() > 1) {
                formattedItems.add(entry.getValue() + "x " + entry.getKey());
            } else {
                formattedItems.add(entry.getKey());
            }
        }

        return String.join(", ", formattedItems);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}