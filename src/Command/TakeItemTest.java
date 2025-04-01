package Command;

import Belongings.Item;
import Settings.Controller;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TakeItemTest {

    @Test
    public void testChooseItem() throws IOException {
        Controller controller = new Controller();
        TakeItem takeItemCommand = new TakeItem(controller);
        Item item = takeItemCommand.chooseItem();
        assertNotNull(item);
    }

}