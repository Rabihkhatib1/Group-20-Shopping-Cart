package cop4331.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rabih
 */
public class DiscountedItemTest {
    
    public DiscountedItemTest() {
    }

    /**
     * Test of getID method, of class DiscountedItem.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class DiscountedItem.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 10;
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        int expResult = 10;
        int result = instance.setID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class DiscountedItem.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        double expResult = 10.00 * (1.0 - (30.0 / 100.0));
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of toString method, of class DiscountedItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        String expResult = "Test (Discount 30.0%)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class DiscountedItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class DiscountedItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        String expResult = "Test Item";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStock method, of class DiscountedItem.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        int expResult = 10;
        int result = instance.getStock();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStock method, of class DiscountedItem.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 50;
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        int expResult = 50;
        int result = instance.setStock(stock);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfo method, of class DiscountedItem.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        String expResult = "Name: Test\nDescription: Test Item\nPrice: $7.00\nQuantity: 10\nDiscount: 30.00%\n";
        String result = instance.getInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSellerInfo method, of class DiscountedItem.
     */
    @Test
    public void testGetSellerInfo() {
        System.out.println("getSellerInfo");
        LineItem item = new Product(0,"Test","Test Item",10.00,10);
        DiscountedItem instance = new DiscountedItem(item,30);
        String expResult = "ID: 0\nName: Test\nDescription: Test Item\nInvoice Price: $5.00\nSell Price: $7.00\nQuantity: 10\nDiscount: 30.00%\n";
        String result = instance.getSellerInfo();
        assertEquals(expResult, result);
    }
    
}
