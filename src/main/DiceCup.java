package main;
import java.util.Random;


abstract class DiceCup {

    public static int rollDice(int diceSides){
        // Init random
        Random random = new Random();
        // Get random num between 0 (inclusive) and 6 (exclusive), adds 1 to get range
        // for n-sided die
        int d1 = random.nextInt(diceSides) + 1;
        int d2 = random.nextInt(diceSides) + 1;

        return(d1+d2);
    }
}
