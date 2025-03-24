package World;

import Belongings.Item;
import Belongings.ItemRegister;
import Settings.Controller;

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
                // this.lokaceItems.add(new Item(itemName.trim()));
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

    public void addLocationItems() {
        Controller controller = new Controller();
        Svet svet = controller.getSvet();
        Lokace lokace = svet.getCurrentPosition();
        switch (lokace.getID()) {
            case 1:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Beer"));
                lokace.addItem(new Item(50));
                break;
            case 2:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Food"));
                lokace.addItem(new Item(50));
                break;
            case 3:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Water"));
                break;
            case 4:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Food"));
                break;
            case 5:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Water"));
                lokace.addItem(new Item(50));
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Food"));
                break;
        }
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

    public void removeItem(Item item) {
        lokaceItems.remove(item);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
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
