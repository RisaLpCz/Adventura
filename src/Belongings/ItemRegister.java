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

        static {
            itemList.put("Water", new Item("Water", "Pitná voda, zažene žízeň", SETTINGS.WATER_AMOUNT, 0, SETTINGS.WATER_DRUNKENNESS, true));
            itemList.put("Food", new Item("Food", "jídlo, hodí se když máte hlad", -1, SETTINGS.FOOD_AMOUNT, SETTINGS.FOOD_DRUNKENNESS, true));
            itemList.put("Beer", new Item("Beer", "pivo, zahání žízeň, ale nepřeháňet ať se pak nemotáte", SETTINGS.BEER_AMOUNT, 0, SETTINGS.BEER_DRUNKENNESS, true));
            itemList.put("Map", new Item("Old Map", "mapa a indicie k otevření jeskyně", false));
            itemList.put("Note in a bottle", new Item("Note in a bottle", "zpráva potřebna pro otevření jeskyně", false));
            itemList.put("Celtic symbols", new Item("Symbols", "důležité artefakty které se hodí k otevření jeskyně", false));
            itemList.put("Bison hoof", new Item("Bison hoof", "hlavní předmět pro splnění celého úkolu", false));
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