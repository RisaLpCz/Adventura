package World;

import Belongings.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LokaceTest {

    @Test
    public void testContainsItem() {
        Lokace lokace = new Lokace();
        Item item = new Item(1);
        lokace.addItem(item);
        assertNotNull(lokace.containsItem("item name"));
        assertNull(lokace.containsItem("nonexistent item"));
    }

}