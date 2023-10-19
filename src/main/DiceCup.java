package main;
import java.util.Random;


abstract class DiceCup {

    public static int rollDice(int diceSides){
        // Init random
        Random random = new Random();
        // Get random num between 0 (inclusive) and 6 (exclusive), adds 1 to get range
        // for n-sided die
        return(random.nextInt(diceSides) + 1);
    }
}
