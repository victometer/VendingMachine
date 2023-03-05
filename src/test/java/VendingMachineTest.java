import Coin.Coin;
import Coin.CoinType;
import Products.Cola;
import Products.Crisps;
import Products.Product;
import Products.Sweet;
import VendingMachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine vendingMachine;

    Coin onePence;
    Coin fivePence;
    Coin tenPence;
    Coin twentyPence;
    Coin fiftyPence;
    Coin twoPence;
    Coin onePound;

    Crisps crisps1;
    Cola cola1;
    Sweet sweet1;
    ArrayList<Product> products;


    @Before
    public void before(){
        fivePence = new Coin(CoinType.FIVEPENCE);
        tenPence = new Coin(CoinType.TENPENCE);
        twentyPence = new Coin(CoinType.TWENTYPENCE);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        onePound = new Coin(CoinType.ONEPOUND);

        onePence = new Coin(CoinType.ONEPENNY);
        onePound = new Coin(CoinType.ONEPOUND);

        vendingMachine = new VendingMachine();

        vendingMachine.addCoin(fiftyPence);
        vendingMachine.addCoin(tenPence);

        crisps1 = new Crisps(50, "Walkers", 100);
        cola1 = new Cola(100, "Coca Cola", 101);
        sweet1 = new Sweet(65, "Sugar Mamma", 102);

        //customer product dropBox
        products = new ArrayList<>();

    }


    @Test
    public void canAddCoin(){
        vendingMachine.addCoin(twentyPence);
        assertEquals(3, vendingMachine.getCoinCount());
    }
    @Test
    public void coinIsInvalid(){
        assertEquals("Invalid coin", vendingMachine.coinSorting(onePence));
    }

    @Test
    public void coinIsValid(){
        assertEquals("Coin accepted", vendingMachine.coinSorting(fiftyPence));
    }



    @Test
    public void canAddProductToMachine(){
        vendingMachine.addProducts(crisps1);
        assertEquals(1, vendingMachine.getProductCount());
    }
    @Test
    public void canGetTheInvalidCoinBack(){
        vendingMachine.addCoin(onePence);
        vendingMachine.addCoin(fivePence);
        assertEquals(4, vendingMachine.getCoinCount());
        assertEquals(1, vendingMachine.returnCoins(onePence));
    }

    @Test
    public void canAddProductToDropBox(){
        vendingMachine.addForCustomer(crisps1);
        assertEquals(1, vendingMachine.addProductToDropBox());
    }
    @Test
    public void chosenProductDropsInBox(){
        vendingMachine.addCoin(onePound);
        assertEquals(102, vendingMachine.getProductByCode(sweet1.getCode()));

    }
    @Test
    public void notSufficientFunds(){
        vendingMachine.addForCustomer(cola1);
        vendingMachine.addCoin(fivePence);
        assertEquals("Please add 35", vendingMachine.cantBuy(cola1));
    }

    @Test
    public void canBuy(){
        vendingMachine.addForCustomer(cola1);
        vendingMachine.addCoin(onePound);
        assertEquals("Please take your change", vendingMachine.buy(cola1));
    }


    @Test
    public void returnCorrectChange() {
        vendingMachine.addForCustomer(sweet1);
        vendingMachine.addCoin(twentyPence);
        assertEquals("[TENPENCE, FIVEPENCE]", vendingMachine.giveChange(sweet1));
    }

}
