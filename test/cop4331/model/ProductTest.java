package cop4331.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rabih
 */
public class ProductTest {
    /**
     * Test of getID method, of class Product.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        double expResult = 10.00;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 50.0;
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        double expResult = 50.0;
        double result = instance.setPrice(price);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        String expResult = "Test";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        String expResult = "Test Item";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStock method, of class Product.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        int expResult = 10;
        int result = instance.getStock();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStock method, of class Product.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 40;
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        int expResult = 40;
        int result = instance.setStock(stock);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfo method, of class Product.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        String expResult = "Name: Test\nDescription: Test Item\nPrice: $10.00\nQuantity: 10\n";
        String result = instance.getInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSellerInfo method, of class Product.
     */
    @Test
    public void testGetSellerInfo() {
        System.out.println("getSellerInfo");
        Product instance = new Product(0,"Test","Test Item",10.00,10);
        String expResult = "ID: 0\nName: Test\nDescription: Test Item\nInvoice Price: $5.00\nSell Price: $10.00\nQuantity: 10\n";
        String result = instance.getSellerInfo();
        assertEquals(expResult, result);
    }
    
}
