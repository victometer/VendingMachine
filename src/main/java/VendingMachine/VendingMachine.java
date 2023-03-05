package VendingMachine;
import Coin.CoinType;
import Coin.Coin;
import Products.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class VendingMachine {

    private ArrayList<Coin> insertedCoins;
    private ArrayList<Product> productsInVendingMachine;
    private int currentCostOfProduct;
    private ArrayList<Coin> till;
    private ArrayList<Coin> changePot;
    int startCode;
    ArrayList<Coin> coinsToGiveAsChange; //an intermediary pot the machine has before adding to changePot
    ArrayList<Product> dropBox;

    public VendingMachine() {
        this.productsInVendingMachine = new ArrayList<Product>();
        this.currentCostOfProduct = 0;
        this.insertedCoins = new ArrayList<Coin>();
        this.dropBox = new ArrayList<Product>();

        this.changePot = new ArrayList<Coin>();

    }
    //how to make it so any coin that doesn't match the coinType returns to the customer? Atm the functions are only taking a parameter type Coin

    public void addCoin(Coin coin){
        insertedCoins.add(coin);
    }
    public String coinSorting(Coin insertedCoin) {
        if (insertedCoin.getCoinValue() != 1 && insertedCoin.getCoinValue() != 2 && insertedCoin.getCoinType() == insertedCoin.getCoinType()) {
            returnCoins(insertedCoin);
            return "Coin accepted";
    }
        return "Invalid coin";
    }

    public int returnCoins(Coin invalidCoin) {
        for (Coin coin : insertedCoins){
            if (coin.getCoinValue() == 1 || coin.getCoinValue() == 2)
            {
                insertedCoins.remove(invalidCoin);
                changePot.add(invalidCoin);
            }
        }
        return changePot.size();
    }

    public int getCoinCount() {
        return insertedCoins.size();
    }


    public void addProducts(Product item) {
        productsInVendingMachine.add(item);
    }

    public void addForCustomer(Product item){
        dropBox.add(item);
    }

    public int addProductToDropBox(){
        return dropBox.size();
    }

    public int getProductCount() {
        return productsInVendingMachine.size();
    }


    public int getProductByCode( int code){
        for(Product product : productsInVendingMachine){
            if(product.getCode() == code){
                productsInVendingMachine.remove(product);
                dropBox.add(product); //maybe add a canAfford condition
            }
        }
        return code;
    }

    public int insertedCoinValue() {
        int totalValue = 0;
        for (Coin coin : insertedCoins) {
            totalValue += coin.getCoinValue();
        }
        return totalValue;
    }

    public String cantBuy(Product product){
            if(insertedCoinValue() < product.getPrice()){
                return "Please add " + (product.getPrice() - insertedCoinValue());
        }
        return "Transaction failed";
    }

    public String buy(Product product){
        getProductByCode(product.getCode());
        currentCostOfProduct = product.getPrice();
        if(insertedCoinValue() == product.getPrice()){
            dropBox.add(product);
            currentCostOfProduct = 0;
            return "Enjoy";
        } else if (insertedCoinValue() > product.getPrice()){
            giveChange(product);
            currentCostOfProduct = 0;
            return "Please take your change";

        }
    return "Transaction failed";
    }

    public String giveChange(Product product) {
        changePot = new ArrayList<>();
            if (insertedCoinValue() > product.getPrice()){
                int change = insertedCoinValue() - product.getPrice();
                while (change > 0){
                    if (change >= CoinType.ONEPOUND.getValue()){
                        changePot.add(new Coin(CoinType.ONEPOUND));
                        change -= CoinType.ONEPOUND.getValue();
                    }
                    else if(change >= CoinType.FIFTYPENCE.getValue()){
                        changePot.add(new Coin(CoinType.FIFTYPENCE));
                        change -= CoinType.FIFTYPENCE.getValue();
                    }
                    else if(change >= CoinType.TWENTYPENCE.getValue()){
                        changePot.add(new Coin(CoinType.TWENTYPENCE));
                        change -= CoinType.TWENTYPENCE.getValue();
                    }
                    else if(change >= CoinType.TENPENCE.getValue()){
                        changePot.add(new Coin(CoinType.TENPENCE));
                        change -= CoinType.TENPENCE.getValue();
                    }
                    else if(change >= CoinType.FIVEPENCE.getValue()){
                        changePot.add(new Coin(CoinType.FIVEPENCE));
                        change -= CoinType.FIVEPENCE.getValue();
                    }
                }
            }


    return changePot.toString();

    }

    public void giveCorrectChange(){

    }
//
//    public String buy(int code) {
//        Product product = getProductByCode(code);
//        currentCostOfProduct = product.getPrice();
//        int valueOfCoinsInserted = 0;
//
//        for (Coin coin : insertedCoins){
//            valueOfCoinsInserted += coin.getValue();
//        }
//        if(valueOfCoinsInserted >= currentCostOfProduct){
//            giveProductToCustomer(code);
//            if(valueOfCoinsInserted > currentCostOfProduct){
//                giveChangeToCustomer((valueOfCoinsInserted - currentCostOfProduct));
//            }
//            return "Transaction complete" ;
//        } else if ((valueOfCoinsInserted - currentCostOfProduct) < 0) {
//             return "Please add " + (currentCostOfProduct - valueOfCoinsInserted);
//        }
////        returnInvalidCoin(coin);
//        return "Please add money";
//        }

//    public void giveChange(){
//        for (Coin coin : coinsToGiveAsChange){
//            changePot.add(coinsToGiveAsChange.remove(coinsToGiveAsChange.indexOf(coin)));
//        }
//    }
//
//    public int getChangePotCoinAmount(){
//        return changePot.size();
//    }
//
//
//    private void giveChangeToCustomer(int changeAmountNeeded) {
//
//        boolean changeToGive = false;
//        int changeLeft = changeAmountNeeded;
//
//        // works out what change can be given
//            while(changeToGive){
//                for (Coin coin : till){
//                    changeLeft -= coin.getValue();
//                    coinsToGiveAsChange.add(till.remove(till.indexOf(coin)));
//                    if (changeLeft == 0){
//                        changeToGive = true;
//                        giveChange();
//
//                    } else if (changeLeft < 0){ //will give too much change
//                        changeLeft += coin.getValue();
//                        till.add(coinsToGiveAsChange.remove(coinsToGiveAsChange.indexOf(coin))) ;
//                    }
//            }
//        }
//
//    }



}
