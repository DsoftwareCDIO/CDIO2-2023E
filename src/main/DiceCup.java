package main;
import java.util.Random;

public abstract class DiceCup {
    // Init random
    static Random random = new Random();
    private static int diceSides = 6;
    
    private static String[] diceVisuals = new String[] {
        //templates for the dice
        "+-------+\n|       |\n|   o   |\n|       |\n+-------+",
        "+-------+\n| o     |\n|       |\n|     o |\n+-------+",
        "+-------+\n| o     |\n|   o   |\n|     o |\n+-------+",
        "+-------+\n| o   o |\n|       |\n| o   o |\n+-------+",
        "+-------+\n| o   o |\n|   o   |\n| o   o |\n+-------+",
        "+-------+\n| o   o |\n| o   o |\n| o   o |\n+-------+",
    };

    public static int rollDice(){
        // Get random num between 0 (inclusive) and 6 (exclusive), adds 1 to get range
        // for n-sided die
        int d1 = random.nextInt(diceSides) + 1;
        int d2 = random.nextInt(diceSides) + 1;

        //draws the thown dice
        drawDice(new int[] {d1,d2});
        return(d1+d2);
    }

    private static void drawDice(int[] dice){
        //writes up a visualization of the dice using a for loop
        for (int i = 0; i < diceVisuals[0].split("\n").length; i++) {
            for (int die : dice) {
                System.out.print(diceVisuals[die-1].split("\n")[i] + "    ");
            }
            System.out.print("\n");
        }
    }
}
