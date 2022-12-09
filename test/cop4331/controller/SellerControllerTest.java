package cop4331.controller;

import javax.swing.DefaultListModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rabih
 */
public class SellerControllerTest {
    
    public SellerControllerTest() {
    }

    /**
     * Test of isBundle method, of class SellerController.
     */
    @Test
    public void testIsBundle() {
        System.out.println("isBundle");
        String n = "Bundle";
        SellerController instance = new SellerController(new DefaultListModel());
        boolean expResult = true;
        boolean result = instance.isBundle(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDouble method, of class SellerController.
     */
    @Test
    public void testIsValidDouble() {
        System.out.println("isValidDouble");
        String n = "12.42";
        SellerController instance = new SellerController(new DefaultListModel());
        boolean expResult = false;
        boolean result = instance.isValidDouble(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidInteger method, of class SellerController.
     */
    @Test
    public void testIsValidInteger() {
        System.out.println("isValidInteger");
        String n = "15.";
        SellerController instance = new SellerController(new DefaultListModel());
        boolean expResult = true;
        boolean result = instance.isValidInteger(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDiscountNumber method, of class SellerController.
     */
    @Test
    public void testIsValidDiscountNumber() {
        System.out.println("isValidDiscountNumber");
        String n = "100";
        SellerController instance = new SellerController(new DefaultListModel());
        boolean expResult = true;
        boolean result = instance.isValidDiscountNumber(n);
        assertEquals(expResult, result);
    }
    
}
