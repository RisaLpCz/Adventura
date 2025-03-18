package World;

import Belongings.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lokace {
    private String name;
    private int ID;
    private int[] locations;
    private List<Item> lokaceItems;

    public Lokace(String name, int ID, String[] locations, String[] items) {
        this.name = name;
        this.ID = ID;

        if (locations != null && locations.length > 0) {
            this.locations = new int[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.locations[i] = Integer.parseInt(locations[i].trim());
            }
        } else {
            this.locations = new int[0];
        }

        this.lokaceItems = new ArrayList<>();
        if (items != null && items.length > 0) {
            for (String itemName : items) {
                this.lokaceItems.add(new Item(itemName.trim()));
            }
        }
    }

    public Lokace() {
    }

    public Item containsItem(String itemName) {
        for (Item item : lokaceItems) {
            if (itemName.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    public int[] getLocations() {
        return locations;
    }

    public List<Item> getItems() {
        return lokaceItems;
    }

    public void addItem(Item item) {
        lokaceItems.add(item);
    }

    @Override
    public String toString() {
        return "World.Lokace{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", locations=" + Arrays.toString(locations) +
                ", items=" + lokaceItems +
                '}';
    }
}
