package Belongings;
import Settings.SETTINGS;

import java.util.HashMap;
import java.util.Map;

/**
 * Registr předmětů obsahující předdefinované instance předmětů.
 * Umožňuje získávat konkrétní předměty podle názvu.
 */
public class ItemRegister {

    /**
     * Statická třída pro registraci a správu herních předmětů.
     */
    public static class ItemRegistry {
        private static final Map<String, Item> itemList = new HashMap<>();

        // Inicializace předdefinovaných předmětů
        static {
            itemList.put("Water", new Item("Water", "drinkable water, adds hydration", SETTINGS.WATER_AMOUNT, 0, SETTINGS.WATER_DRUNKENNESS, true));
            itemList.put("Food", new Item("Food", "eatable food, removes hunger", -1, SETTINGS.FOOD_AMOUNT, SETTINGS.FOOD_DRUNKENNESS, true));
            itemList.put("Beer", new Item("Beer", "alcohol beverage, adds hydration and drunkenness", SETTINGS.BEER_AMOUNT, 0, SETTINGS.BEER_DRUNKENNESS, true));
            itemList.put("Map", new Item("Old Map", "part of key to the final room", false));
            itemList.put("Note in a bottle", new Item("Note in a bottle", "a useful message for the mission", false));
            itemList.put("Celtic symbols", new Item("Symbols", "the last clue for cave opening", false));
            itemList.put("Bison hoof", new Item("Bison hoof", "The final object to finish the mission", false));
        }

        /**
         * Vrátí předmět podle jeho názvu.
         *
         * @param name Název hledaného předmětu.
         * @return Instance předmětu.
         */
        public static Item getItem(String name) {
            return itemList.get(name);
        }

        /**
         * Vytvoří nový předmět reprezentující peníze s daným množstvím.
         *
         * @param amount Počet jednotek peněz.
         * @return Instance předmětu představující peníze.
         */
        public static Item getMoney(int amount) {
            return new Item(amount);
        }
    }
}