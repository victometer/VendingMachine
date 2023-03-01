package VendingMachine;

import Coin.Coin;
import Interfaces.IBuyable;
import Products.Crisps;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private ArrayList<Coin> insertedCoins;
    private HashMap<String, IBuyable> productsInVendingMachine;
    private double currentCostOfProduct;
    private ArrayList<Coin> validCoin;
    private ArrayList<Coin> till;
    private ArrayList<Coin> changePot;

    public VendingMachine() {
        this.currentCostOfProduct = 0;
        this.insertedCoins = new ArrayList<Coin>();
        this.validCoin = new ArrayList<Coin>();
        this.productsInVendingMachine = new HashMap<>();
        this.till = new ArrayList<Coin>();
        this.changePot = new ArrayList<Coin>();
    }

    public void addToTill(Coin coin){
        till.add(coin);
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

    public String generateCode(){
        String letter = "A";
        return letter + (productsInVendingMachine.size() +1);
    }
    public void addProducts(IBuyable item) {
        productsInVendingMachine.put(generateCode(), item);
    }

    public int getProductCount() {
        return productsInVendingMachine.size();
    }

    public IBuyable getProductByCode(String code){
       return productsInVendingMachine.get(code);
    }

    public IBuyable giveProductToCustomer(String code){
        return productsInVendingMachine.remove(code);
    }
    //assuming the customer has put in the coins
    public String buy(String code) {
        IBuyable product = getProductByCode(code);
        currentCostOfProduct = product.getPrice();
        double valueOfCoinsInserted = 0;

        for (Coin coin : insertedCoins){
            valueOfCoinsInserted += coin.getValue();
        }
        if(valueOfCoinsInserted >= currentCostOfProduct){
            giveProductToCustomer(code);
            if(valueOfCoinsInserted > currentCostOfProduct){
                giveChangeToCustomer((valueOfCoinsInserted - currentCostOfProduct));
            }
            return "Transaction complete" ;
        } else if (hasEnoughMoney(valueOfCoinsInserted, currentCostOfProduct) < 0) {
             return "Please add " + (currentCostOfProduct - valueOfCoinsInserted);
        }
        return "Please add money";
        }

    private void giveChangeToCustomer(double changeAmountNeeded) {
        for(Coin coin : till){
            if(coin.getValue() == changeAmountNeeded){
                changePot.add(till.remove(till.indexOf(coin)));
            }
            else{
                
            }
        }
    }


    public int hasEnoughMoney(double valueOfCoinsInserted, double productPrice){
        return Double.compare(valueOfCoinsInserted, productPrice);

    }

    public void returnCoins() {
        insertedCoins.clear();
    }
}
