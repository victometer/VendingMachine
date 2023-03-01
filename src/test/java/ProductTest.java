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
        crisps1 = new Crisps(0.5, "Walkers");
        cola1 = new Cola(1.0, "Coca Cola");
        sweet1 = new Sweet(0.65, "Sugar Mamma");
    }

    @Test
    public void getProductPrice(){
        assertEquals(0.5, crisps1.getPrice(), 0.0);
    }

    @Test
    public void getProductBrand(){
        assertEquals("Sugar Mamma", sweet1.getBrand());
    }
}
