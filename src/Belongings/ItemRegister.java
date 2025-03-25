package Belongings;
import Settings.SETTINGS;

import java.util.HashMap;
import java.util.Map;

public class ItemRegister {

    public static class ItemRegistry {
        private static final Map<String, Item> itemList = new HashMap<>();

        static {
            itemList.put("Water", new Item("Water", "drinkable water, adds hydration", SETTINGS.WATER_AMOUNT, 0, SETTINGS.WATER_DRUNKENNESS, true));
            itemList.put("Food", new Item("Food", "eatable food, removes hunger", -1, SETTINGS.FOOD_AMOUNT, SETTINGS.FOOD_DRUNKENNESS, true));
            itemList.put("Beer", new Item("Beer", "alcohol beverage, adds hydration and drunkenness", SETTINGS.BEER_AMOUNT, 0, SETTINGS.BEER_DRUNKENNESS, true));
            itemList.put("Map", new Item("Old Map", "part of key to the final room", false));
            itemList.put("Note in a bottle", new Item("Note in a bottle", "a useful message for the mission", false));
            itemList.put("Celtic symbols", new Item("Symbols", "the last clue for cave opening", false));
            itemList.put("Bison hoof", new Item("Bison hoof", "The final object to finish the mission", false));
        }

        public static Item getItem(String name) {
            return itemList.get(name);
        }

        public static Item getMoney(int amount) {
            return new Item(amount);
        }
    }

}
