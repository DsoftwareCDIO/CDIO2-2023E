package test;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import main.DiceCup;
import main.Player;

public class TestGameProgress {
    @Test
    public void testAverageIncome(){
        for (int i = 0; i < 100; i++) {
            Player currentPlayer = new Player("Test");
            rollHundredTimes(currentPlayer);
            assertTrue(currentPlayer.getCoins() > 0);
        }
    }

    private void rollHundredTimes(Player currentPlayer){
        for (int i = 0; i < 100; i++) {
            switch (DiceCup.rollDice()){
                case 1 : 
                    break;
                case 2 : 
                    System.out.println("You discovered an ancient leaning tower, that seemed vaguely familiar, you recieve 250 coins for your historic find.");
                    currentPlayer.changeCoins(250);
                    break;
                case 3 : 
                    System.out.println("You lost 100 coins falling into a random crater.");
                    currentPlayer.changeCoins(-100);
                    break;
                case 4 : 
                    System.out.println("You are the 100th person today to cross the palace gates, you recieve 100 coins!");
                    currentPlayer.changeCoins(100);
                    break;
                case 5 : 
                    System.out.println("You spent 20 coins on a warm jacket to keep you from freezing in the cold desert.");
                    currentPlayer.changeCoins(-20);
                    break;
                case 6 : 
                    System.out.println("You discovered a walled city. Outside the walls there were beggars. You stole 180 coins from the beggars tins.");
                    currentPlayer.changeCoins(180);
                    break;
                case 7 : 
                    System.out.println("You discovered a monastery. You are an atheist, so you walked away and nothing happened.");
                    break;
                case 8 : 
                    System.out.println("You entered a black cave and can't see anything. You trip and drop exactly 70 coins.");
                    currentPlayer.changeCoins(-70);
                    break;
                case 9 : 
                    System.out.println("You found a mountain-mama and did her chores. She rewarded you with 60 coins! You dirty thing!");
                    currentPlayer.changeCoins(60);
                    break;
                case 10 : 
                    System.out.println("You walked into a wall full of colossus titans and lost 80 coins but you used your vertical maneuvering gear to get away from it so fast, that you got an extra turn.");
                    currentPlayer.changeCoins(-80);
                    break;
                case 11 : 
                System.out.println("You fell into my trap(card) You are forced to pay(lose) 50 coins(lifepoints)");
                    currentPlayer.changeCoins(-50);
                    break;
                case 12 : 
                    System.out.println("You found a sugar-mama and asked for 650 coins. Of course you got them!");
                    currentPlayer.changeCoins(650);
                    break;
                default:
                    break;
            }
        }
    }
}
