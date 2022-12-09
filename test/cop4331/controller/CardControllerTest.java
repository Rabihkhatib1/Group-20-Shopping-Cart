package cop4331.controller;

import cop4331.gui.CardView;
import cop4331.model.Invoice;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Solan
 */
public class CardControllerTest {
    /**
     * Test of isValidCreditCardNumber method, of class CardController.
     */
    @Test
    public void testIsValidCreditCardNumber() {
        System.out.println("isValidCreditCardNumber");
        String number = "4312123412341234";
        CardController instance = new CardController(new CardView(new Invoice()),new Invoice());
        boolean expResult = true;
        boolean result = instance.isValidCreditCardNumber(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidCreditCardName method, of class CardController.
     */
    @Test
    public void testIsValidCreditCardName() {
        System.out.println("isValidCreditCardName");
        String name = "";
        CardController instance = new CardController(new CardView(new Invoice()),new Invoice());
        boolean expResult = true;
        boolean result = instance.isValidCreditCardName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidCreditCardDate method, of class CardController.
     */
    @Test
    public void testIsValidCreditCardDate() {
        System.out.println("isValidCreditCardDate");
        String date = "11/24";
        CardController instance = new CardController(new CardView(new Invoice()),new Invoice());
        boolean expResult = true;
        boolean result = instance.isValidCreditCardDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidCreditCardCVV method, of class CardController.
     */
    @Test
    public void testIsValidCreditCardCVV() {
        System.out.println("isValidCreditCardCVV");
        String cvv = "123";
        CardController instance = new CardController(new CardView(new Invoice()),new Invoice());
        boolean expResult = true;
        boolean result = instance.isValidCreditCardCVV(cvv);
        assertEquals(expResult, result);
    }
    
}
