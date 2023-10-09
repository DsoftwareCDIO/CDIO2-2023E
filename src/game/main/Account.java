package game.main;

public class Account {
    private int coins = 0;

    public Account(){};

    public int getCoins(){
        return coins;
    }

    public void changeCoins(int coins){
        this.coins += coins;
    }
}
