package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.Player;

public class TestAccount {
    @Test
    public void testChangeCoins(){
        Player p1 = new Player("Test person 1");
        p1.changeCoins(-100);
        assertEquals(p1.getCoins(), 900);
        p1.changeCoins(650);
        assertEquals(p1.getCoins(), 1550);
        p1.changeCoins(250);
        assertEquals(p1.getCoins(), 1800);
        
        Player p2 = new Player("Test person 1");
        p2.changeCoins(-1000);
        assertEquals(p2.getCoins(), 0);
        p2.changeCoins(100);
        assertEquals(p2.getCoins(), 100);
        p2.changeCoins(-300);
        assertEquals(p2.getCoins(), 0);
        p2.changeCoins(-500);
        assertEquals(p2.getCoins(), 0);
    }
}
