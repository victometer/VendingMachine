import Coin.Coin;
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
}
