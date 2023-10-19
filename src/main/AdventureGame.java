package main;
import java.util.Scanner;
public class AdventureGame {
    private static Player p1;
    private static Player p2;
    public static void main(String[] args) throws Exception {
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
        Scanner scanner = new Scanner(System.in);
        
        Player currentPlayer = p1;
        int turn = 1;
        
        // The game starts
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Hello! and welcome to you, Player 1 and Player 2. Are you ready for an adventure?\n");
        System.out.println("Rules are as followed:");
        System.out.println("You start with 1000 coins");
        System.out.println("You obtian or lose coins depending on your dice throw");
        System.out.println("First player to get to 3000 or more coins wins!");
        System.out.println("Have fun and let the game begin");
        System.out.println("-------------------------------------------------------------------------------");

        // Game loop that runs, until a player has won
        while (!hasWon(currentPlayer)) {
            // Set currentplayer depending on turn
            currentPlayer = turn % 2 == 0 ? p2 : p1;
            System.out.println("\n" + "Round: " + (turn + 1) / 2);
            System.out.print(currentPlayer.getName() + "'s turn, press ENTER to roll the dice");
            scanner.nextLine();
            
            // Actions happens based on the players dicethrow
            switch (DiceCup.rollDice(6)){
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
                    turn--;
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
            System.out.print("You now have " + currentPlayer.getCoins() + " coins");
            System.out.print(" | Press ENTER to continue");
            scanner.nextLine();
            turn++;
        }

        // Game loop is stopped and winner is announced
        System.out.println("\nCongratulations " + currentPlayer.getName() + ", you won the game!");
        scanner.nextLine();
        scanner.close();
    }

    // Checks whether the current player has won
    private static boolean hasWon(Player p){
        return p.getCoins() >= 3000;
    }
}
