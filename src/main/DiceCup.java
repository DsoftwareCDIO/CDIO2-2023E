package main;
import java.util.Random;


public abstract class DiceCup {
    private static String[] DiceVisuals = new String[] {
        "+-------+\n|       |\n|   o   |\n|       |\n+-------+",
        "+-------+\n| o     |\n|       |\n|     o |\n+-------+",
        "+-------+\n| o     |\n|   o   |\n|     o |\n+-------+",
        "+-------+\n| o   o |\n|       |\n| o   o |\n+-------+",
        "+-------+\n| o   o |\n|   o   |\n| o   o |\n+-------+",
        "+-------+\n| o   o |\n| o   o |\n| o   o |\n+-------+",
    };

    public static int rollDice(int diceSides){
        // Init random
        Random random = new Random();
        // Get random num between 0 (inclusive) and 6 (exclusive), adds 1 to get range
        // for n-sided die
        int d1 = random.nextInt(diceSides) + 1;
        int d2 = random.nextInt(diceSides) + 1;

        drawDice(new int[] {d1,d2});
        return(d1+d2);
    }

    private static void drawDice(int[] dice){
        for (int i = 0; i < DiceVisuals[0].split("\n").length; i++) {
            for (int die : dice) {
                System.out.print(DiceVisuals[die-1].split("\n")[i] + "    ");
            }
            System.out.print("\n");
        }
    }
}
