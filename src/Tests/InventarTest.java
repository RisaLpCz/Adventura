package Tests;

import Belongings.Inventar;
import Belongings.Item;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class InventarTest {

    @Test
    public void testAddItem() {
        Inventar inventar = new Inventar();
        Item item = new Item(1);  // Příklad položky
        inventar.addItem(item);
        assertTrue(inventar.getFormattedItems().contains("item name"));
    }



    @Test
    public void testRemoveItem() {
        Inventar inventar = new Inventar();
        Item item = new Item(1);
        inventar.addItem(item);
        inventar.removeItem(item.getName());
        assertFalse(inventar.getFormattedItems().contains("item name"));
    }


}