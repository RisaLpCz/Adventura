package World;

import Settings.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SvetTest {

    @Test
    public void testZmenLokaci() {
        Controller controller = new Controller();
        Svet svet = controller.getSvet();
        int currentPositionBeforeMove = svet.getCurrentPosition().getID();
        svet.zmenLokaci();
        assertNotEquals(currentPositionBeforeMove, svet.getCurrentPosition().getID());
    }

}