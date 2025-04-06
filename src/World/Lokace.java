package World;

import Belongings.Item;
import Belongings.ItemRegister;
import java.util.ArrayList;
import java.util.List;

/**
 * Třída Lokace představuje jednu lokaci ve hře. Každá lokace má název, jedinečné ID, seznam možných sousedních lokací
 * a seznam položek, které lze v dané lokaci najít.
 */
public class Lokace {
    private String name;
    private int ID;
    private ArrayList<Integer> locations;
    private ArrayList<Item> lokaceItems;
    private boolean searched;

    /**
     * Konstruktor třídy Lokace.
     *
     * @param name Název lokace.
     * @param ID Jedinečné ID lokace.
     * @param locationsStr Seznam sousedních lokací (určeno jejich ID).
     * @param items Seznam názvů položek, které jsou k dispozici v této lokaci.
     */
    public Lokace(String name, int ID, String[] locationsStr, String[] items) {
        this.name = name;
        this.ID = ID;
        this.searched = false;
        this.locations = new ArrayList<>();

        if (locationsStr != null && locationsStr.length > 0) {
            for (String loc : locationsStr) {
                this.locations.add(Integer.parseInt(loc.trim()));
            }
        }

        this.lokaceItems = new ArrayList<>();
    }

    public Lokace() {
    }

    /**
     * Hledá položku podle jejího názvu v aktuální lokaci.
     *
     * @param itemName Název položky, kterou hledáte.
     * @return Položku, pokud je nalezena, jinak null.
     */
    public Item containsItem(String itemName) {
        for (Item item : lokaceItems) {
            if (itemName.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    /**
     * Přidává položky do lokace na základě jejího ID.
     *
     * @param lokace Lokace, do které přidáváme položky.
     */
    public void addLocationItems(Lokace lokace) {
        switch (lokace.getID()) {
            case 1:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Beer"));
                lokace.addItem(new Item(50));
                break;
            case 2:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Food"));
                lokace.addItem(new Item(50));
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Map"));
                break;
            case 3:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Water"));
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Celtic symbols"));
                break;
            case 4:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Food"));
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Note in a bottle"));
                break;
            case 5:
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Water"));
                lokace.addItem(new Item(50));
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Food"));
                lokace.addItem(ItemRegister.ItemRegistry.getItem("Bison hoof"));
                break;
        }
    }

    public void addLocation(int id) {
        if (!locations.contains(id)) {
            locations.add(id);
        }
    }

    public boolean containsLocations(int id) {
        return locations.contains(id);
    }

    public int[] getLocations() {
        return locations.stream().mapToInt(Integer::intValue).toArray();
    }

    public ArrayList<Item> getItems() {
        return lokaceItems;
    }

    /**
     * Přidá položku do aktuální lokace.
     *
     * @param item Položka, kterou chceme přidat do lokace.
     */
    public void addItem(Item item) {
        lokaceItems.add(item);
    }

    /**
     * Odstraní položku z aktuální lokace.
     *
     * @param item Položka, kterou chceme odstranit z lokace.
     */
    public void removeItem(Item item) {
        lokaceItems.remove(item);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
    }

    @Override
    public String toString() {
        return name;
    }
}
