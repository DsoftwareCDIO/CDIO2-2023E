package game.main;
    // I think, therefore i am
public class Player {

    private String name;
    private Account account;


    //Constructor, makes a player with (name)
    public Player(String name) {
        this.name = name;
        account = new Account();
    }

    public int getCoins() {         //Method to get coins assigned to account
        return account.getCoins();
    }

    public String getName() {       //Method to get name of player
        return name;
    }

    public void changeCoins(int coins) {        // Method to change the amount of coins in the account
        account.changeCoins(coins);
    }

}