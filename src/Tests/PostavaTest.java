package Tests;

import Characters.Postava;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostavaTest {

    @Test
    public void testSetDrunkenness() {
        Postava.setDrunkenness(2.5);
        assertEquals(2.5, Postava.getDrunkenness(), 0.01);
    }

    @Test
    public void testPlayerStete() {
        Postava.setMoney(100);
        Postava.setFood(5);
        Postava.setDrink(7);
        Postava.setDrunkenness(1.5);
        String status = Postava.playerStete();
        assertTrue(status.contains("100"));
        assertTrue(status.contains("5/10"));
        assertTrue(status.contains("7/10"));
        assertTrue(status.contains("1.5"));
    }

}