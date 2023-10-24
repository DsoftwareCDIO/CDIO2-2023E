package main;
//I'm rich, therfore im happy
public class Account {
    private int coins = 1000;

    //Method to get coins
    public int getCoins(){      
        if (this.coins < 0){
            this.coins = 0;
        }
        return coins;
    }

    //Method to change coins in Account
    public void changeCoins(int coins){     
        this.coins += coins;
        if (this.coins < 0) {
            this.coins = 0;
        }
    }
}
