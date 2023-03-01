import Coin.Coin;
import Products.Cola;
import Products.Crisps;
import Products.Product;
import Products.Sweet;
import VendingMachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine vendingMachine;
    Coin validCoin1;
    Coin validCoin2;
    Coin validCoin3;
    Coin validCoin4;
    Coin validCoin5;
    Coin insertedCoin1;
    Coin insertedCoin2;
    Crisps crisps1;
    Cola cola1;
    Sweet sweet1;


    @Before
    public void before(){
        validCoin1 = new Coin(0.05);
        validCoin2 = new Coin(0.1);
        validCoin3 = new Coin(0.2);
        validCoin4 = new Coin(0.5);
        validCoin5 = new Coin(1.0);

        insertedCoin1 = new Coin(0.01);
        insertedCoin2 = new Coin(1.0);

        vendingMachine = new VendingMachine();
        vendingMachine.addValidCoin(validCoin1);
        vendingMachine.addValidCoin(validCoin2);
        vendingMachine.addValidCoin(validCoin3);
        vendingMachine.addValidCoin(validCoin4);
        vendingMachine.addValidCoin(validCoin5);

        crisps1 = new Crisps(0.5, "Walkers");
        cola1 = new Cola(1.0, "Coca Cola");
        sweet1 = new Sweet(0.65, "Sugar Mamma");

        vendingMachine.addToTill(validCoin2);
        vendingMachine.addToTill(validCoin1);
        vendingMachine.addToTill(validCoin1);
        vendingMachine.addToTill(validCoin3);
        vendingMachine.addToTill(validCoin2);
        vendingMachine.addToTill(validCoin3);
    }


    @Test
    public void coinIsInvalid(){
        assertEquals("Invalid coin", vendingMachine.insertCoin(insertedCoin1));
    }

    @Test
    public void coinIsValid(){
        assertEquals("Coin accepted", vendingMachine.insertCoin(insertedCoin2));
    }

    @Test
    public void coinIsInserted(){
        vendingMachine.insertCoin(insertedCoin2);
        assertEquals(1, vendingMachine.getCoinCount());
    }

    @Test
    public void canAddProductToMachine(){
        vendingMachine.addProducts(crisps1);
        assertEquals(1, vendingMachine.getProductCount());
    }

    @Test
    public void canGenerateCode(){
        assertEquals("A1", vendingMachine.generateCode());
    }

    @Test
    public void cantBuyWithoutCoins(){
        vendingMachine.addProducts(crisps1);
        vendingMachine.addProducts(cola1);
        vendingMachine.addProducts(sweet1);
        assertEquals("Please add 0.5", vendingMachine.buy("A1"));
    }

    @Test
    public void canBuy(){
        vendingMachine.addProducts(crisps1);
        vendingMachine.addProducts(cola1);
        vendingMachine.addProducts(sweet1);
        vendingMachine.insertCoin(insertedCoin2);
        assertEquals("Transaction complete", vendingMachine.buy("A1"));

    }

    @Test
    public void haventInputSufficientFunds(){
        vendingMachine.addProducts(crisps1);
        vendingMachine.addProducts(cola1);
        vendingMachine.addProducts(sweet1);
        vendingMachine.insertCoin(validCoin3);
        assertEquals("Please add 0.3", vendingMachine.buy("A1"));
    }
    @Test
    public void returnCoinReturn() {
        vendingMachine.addProducts(crisps1);
        vendingMachine.addProducts(cola1);
        vendingMachine.addProducts(sweet1);
        vendingMachine.insertCoin(validCoin3);
        vendingMachine.returnCoins();
        assertEquals(0, vendingMachine.getCoinCount());
    }

    @Test
    public void returnNoChange() {
        vendingMachine.addProducts(crisps1);
        vendingMachine.addProducts(cola1);
        vendingMachine.addProducts(sweet1);
        vendingMachine.insertCoin(validCoin3);

        assertEquals(0, vendingMachine.getCoinCount());
    }

    @Test
    public void returnCorrectChange() {
        vendingMachine.addProducts(crisps1);
        vendingMachine.addProducts(cola1);
        vendingMachine.addProducts(sweet1);
        vendingMachine.insertCoin(validCoin3);
        vendingMachine.insertCoin(validCoin4);
        vendingMachine.buy("A1");
        assertEquals(3, vendingMachine.getChangePotCoinAmount());
    }

}
