package game.main;
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
        while (!hasWon(currentPlayer)) {
            // Set currentplayer depending on turn
            currentPlayer = turn % 2 == 0 ? p2 : p1;
            System.out.println("\n" + "Round: " + (turn + 1) / 2);
            System.out.print(currentPlayer.getName() + "'s turn, press ENTER to roll the dice");
            scanner.nextLine();
            
            switch (/*getFaceValue()*/1){
                case 1 : 
                    break;
                case 2 : 
                    currentPlayer.changeCoins(250);
                    break;
                case 3 : 
                    currentPlayer.changeCoins(-100);
                    break;
                case 4 : 
                    currentPlayer.changeCoins(100);
                    break;
                case 5 : 
                    currentPlayer.changeCoins(-20);
                    break;
                case 6 : 
                    currentPlayer.changeCoins(180);
                    break;
                case 7 : 
                    break;
                case 8 : 
                    currentPlayer.changeCoins(-70);
                    break;
                case 9 : 
                    currentPlayer.changeCoins(60);
                    break;
                case 10 : 
                    currentPlayer.changeCoins(-80);
                    turn--;
                    break;
                case 11 : 
                    currentPlayer.changeCoins(-50);
                    break;
                case 12 : 
                    currentPlayer.changeCoins(650);
                    break;
            }
            turn++;
        }
        System.out.println("\nCongratulations " + currentPlayer.getName() + ", you won the game!");
        scanner.nextLine();
        scanner.close();
    }

    // Checks whether the current player has won
    private static boolean hasWon(Player p){
        return p.getCoins() >= 3000;
    }
}
