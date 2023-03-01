package VendingMachine;

import Coin.Coin;
import Interfaces.IBuyable;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private ArrayList<Coin> insertedCoins;
    private HashMap<String, IBuyable> productsInVendingMachine;
    private double currentCostOfProduct;
    private ArrayList<Coin> validCoin;

    public VendingMachine(){
        this.currentCostOfProduct = 0;
        this.insertedCoins = new ArrayList<Coin>();
        this.validCoin = new ArrayList<Coin>();
        this.productsInVendingMachine = new HashMap<>();
    }

    public String insertCoin(Coin insertedCoin){
        for (Coin coin : validCoin) {
            if (insertedCoin.getValue() == coin.getValue()) {
                insertedCoins.add(coin);
                return "Coin accepted";
            }
        }
        return "Invalid coin";
    }


    public void addValidCoin(Coin coin){
        validCoin.add(coin);
    }


    public int getCoinCount() {
        return insertedCoins.size();
    }
}
