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
        do {
            // Set currentplayer depending on turn
            currentPlayer = turn % 2 == 0 ? p2 : p1;
            System.out.println("\n" + "Round: " + (turn + 1) / 2);
            System.out.print(currentPlayer.getName() + "'s turn, press ENTER to roll the dice");
            scanner.nextLine();

            //d1.roll();
            //d2.roll();
            
            turn++;
        } while (/*!winCheck(currentPlayer, d1, d2)*/true);
        System.out.println("\nCongratulations " + currentPlayer.getName() + ", you won the game!");
        scanner.nextLine();
        scanner.close();
    }
}
