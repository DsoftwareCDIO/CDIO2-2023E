package game.main;
//I'm rich, therfore im happy
public class Account {
    private int coins = 0;

    public Account(){};     //Creates the account object

    public int getCoins(){      //Method to get coins
        if (this.coins < 0){
            this.coins = 0;
        }
        return coins;
    }

    public void changeCoins(int coins){     //Method to change coins in Account
        this.coins += coins;
        if (this.coins < 0) {
            this.coins = 0;
        }
    }
}
