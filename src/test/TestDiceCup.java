package test;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.DiceCup;

public class TestDiceCup {
    @Test
    public void thousandDiceRolls(){
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += DiceCup.rollDice();
        }
        double median = sum / 1000.0;
        assertTrue(median < 7.2 && median > 6.8);
    }
}
