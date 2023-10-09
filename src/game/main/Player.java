package game.main;
    // I think, therefore i am
public class Player {

    private String name;
   // private Account account;


    //Constructor, makes a player with (name)
    public Player(String name) {
        this.name = name;
    }

    public int getCoins() {
        // return account.getCoins()
        return 0;
    }

    public String getName() {
        return name;
    }

    public void changeCoins(int c) {
      //  account.changeCoins()
    }

}