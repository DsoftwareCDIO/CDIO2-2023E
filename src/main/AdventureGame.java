package main;
import java.util.Scanner;
import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class AdventureGame {
    public static void main(String[] args) {
        // Code taken from https://stackoverflow.com/questions/52767585/how-can-you-use-vt100-escape-codes-in-java-on-windows to add colors in cmd
        // Specific answer/revision https://stackoverflow.com/revisions/52767586/3
        if(System.getProperty("os.name").startsWith("Windows"))
        {
            // Set output mode to handle virtual terminal sequences
            Function GetStdHandleFunc = Function.getFunction("kernel32", "GetStdHandle");
            DWORD STD_OUTPUT_HANDLE = new DWORD(-11);
            HANDLE hOut = (HANDLE)GetStdHandleFunc.invoke(HANDLE.class, new Object[]{STD_OUTPUT_HANDLE});

            DWORDByReference p_dwMode = new DWORDByReference(new DWORD(0));
            Function GetConsoleModeFunc = Function.getFunction("kernel32", "GetConsoleMode");
            GetConsoleModeFunc.invoke(BOOL.class, new Object[]{hOut, p_dwMode});

            int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
            DWORD dwMode = p_dwMode.getValue();
            dwMode.setValue(dwMode.intValue() | ENABLE_VIRTUAL_TERMINAL_PROCESSING);
            Function SetConsoleModeFunc = Function.getFunction("kernel32", "SetConsoleMode");
            SetConsoleModeFunc.invoke(BOOL.class, new Object[]{hOut, dwMode});
        }

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Scanner scanner = new Scanner(System.in);
        
        Player currentPlayer = p1;
        String playerColor = "\u001b[0m";
        int turn = 1;
        
        // The game starts
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Hello! and welcome to you, \u001b[31mPlayer 1\u001b[0m and \u001b[36mPlayer 2\u001b[0m. Are you ready for an adventure?\n");
        System.out.println("Rules are as followed:");
        System.out.println("\u001b[32mYou start with 1000 coins");
        System.out.println("You obtain or lose coins depending on your dice throw");
        System.out.println("First player to get to 3000 or more coins wins!");
        System.out.println("Have fun and let the game begin\u001b[0m");
        System.out.println("---------------------------------------------------------------------------------");

        // Game loop that runs, until a player has won
        while (!hasWon(currentPlayer)) {
            // Set currentplayer depending on turn
            currentPlayer = turn % 2 == 0 ? p2 : p1;
            // Sets color in cmd of the current player
            playerColor = turn % 2 == 0 ? "\u001b[36m" : "\u001b[31m";
            System.out.println("\n" + "Round: " + (turn + 1) / 2);
            System.out.print(playerColor + currentPlayer.getName() + "'s\u001b[0m turn, press ENTER to roll the dice");
            scanner.nextLine();
            
            // Actions happens based on the players dicethrow
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
                    System.out.println("You walked into a wall full of colossus titans and lost 80 coins but you used your vertical maneuvering gear to get away from it so fast, that \u001b[32myou got an extra turn.\u001b[0m");
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
        System.out.println("\n\u001b[32mCongratulations " + playerColor + currentPlayer.getName() + "\u001b[32m, you won the game!");
        scanner.nextLine();
        scanner.close();
    }

    // Checks whether the current player has won
    private static boolean hasWon(Player p){
        return p.getCoins() >= 3000;
    }
}
