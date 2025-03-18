package Belongings;

import Settings.SETTINGS;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Inventar {

    private ArrayList<Item> items;
    private Scanner scanner = new Scanner(System.in);


    public boolean addItem(Item item) {
        if (items.size() <= SETTINGS.INVENTORYSIZE && item != null) {
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

    public ArrayList<Item> getItems() {
        return items;
    }
}
