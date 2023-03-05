import Products.Cola;
import Products.Crisps;
import Products.Sweet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Crisps crisps1;
    Cola cola1;
    Sweet sweet1;

    @Before
    public void before(){
        crisps1 = new Crisps(50, "Walkers", 100);
        cola1 = new Cola(100, "Coca Cola", 101);
        sweet1 = new Sweet(65, "Sugar Mamma", 102);
    }

    @Test
    public void getProductPrice(){
        assertEquals(50, crisps1.getPrice());
    }

    @Test
    public void getProductBrand(){
        assertEquals("Sugar Mamma", sweet1.getBrand());
    }
}
