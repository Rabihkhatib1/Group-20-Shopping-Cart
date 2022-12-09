package cop4331.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rabih
 */
public class BundleTest {
    /**
     * Test of getID method, of class Bundle.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        int expResult = 10;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Bundle.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 50;
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        int expResult = 50;
        int result = instance.setID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Bundle.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        double expResult = 10.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of toString method, of class Bundle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        String expResult = "Bundle of Test";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Bundle.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        String expResult = "Bundle";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Bundle.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        String expResult = "Bundle";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStock method, of class Bundle.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        int expResult = 20;
        int result = instance.getStock();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStock method, of class Bundle.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 50;
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        instance.setStock(50);
        int expResult = 50;
        int result = instance.setStock(stock);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfo method, of class Bundle.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        String expResult = "Bundle of Test.\nPrice: $10.00\nQuantity: 20\n";
        String result = instance.getInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSellerInfo method, of class Bundle.
     */
    @Test
    public void testGetSellerInfo() {
        System.out.println("getSellerInfo");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        Bundle instance = new Bundle(10,20);
        instance.add(item);
        String expResult = "Bundle of Test.\nPrice: $10.00\nQuantity: 20\n";
        String result = instance.getSellerInfo();
        assertEquals(expResult, result);
    }   
}
