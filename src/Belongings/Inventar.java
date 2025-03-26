package Belongings;

import Characters.Postava;
import Settings.SETTINGS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventar {

    private ArrayList<Item> items = new ArrayList<>();

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

    public boolean removeItem(String itemName) {
        Item item = containsItem(itemName);

        if (item != null) {
            items.remove(item);
            return true;
        }
        return false;
    }

    public Item containsItem(String itemName) {
        for (Item item : items) {
            if (itemName.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    public boolean allItemsCollected() {
        return containsItem("Map") != null &&
                containsItem("Note in a bottle") != null &&
                containsItem("Celtic symbols") != null &&
                containsItem("Bison hoof") != null;
    }

    public boolean isEmpty() {
        if (items.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (items.size() == SETTINGS.INVENTORYSIZE) {
            return true;
        }
        return false;
    }

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
