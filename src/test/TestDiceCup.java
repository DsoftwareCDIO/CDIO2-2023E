package test;
import static org.junit.Assert.fail;

import org.junit.Test;

import main.DiceCup;

public class TestDiceCup {

    @Test
    public void thousandDiceRolls(){
        int diceSides = 6;
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += DiceCup.rollDice(diceSides);
        }
        double median = sum / 1000.0;
        if (median < 6.8 || median > 7.2) {
            fail();
        }
    }
}
