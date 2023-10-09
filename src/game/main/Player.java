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

    public int getCoins() {
        return account.getCoins();
    }

    public String getName() {
        return name;
    }

    public void changeCoins(int coins) {
        account.changeCoins(coins);
    }

}