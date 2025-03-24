package Belongings;
import java.util.HashMap;
import java.util.Map;

public class ItemRegister {

    public static class ItemRegistry {
        private static final Map<String, Item> itemList = new HashMap<>();

        static {
            itemList.put("Water", new Item("Water", "drinkable water, adds hydration", 3, 0, -1, true));
            itemList.put("Food", new Item("Food", "eatable food, removes hunger", -1, 3, 0, true));
            itemList.put("Beer", new Item("Beer", "alcohol beverage, adds hydration and drunkenness", 2, 0, 2, true));
            //itemList.put("Money", new Money("adds some coins to your wallet", ));
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
