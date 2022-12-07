import cop4331.controller.CardController;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardControllerTest {

    @Test
    public void isValidCreditCardNumber() {
        assertTrue(CardController.isValidCreditCardNumber("4124564564564564"));
    }

    @Test
    public void isValidCreditCardName() {
        assertTrue(CardController.isValidCreditCardNumber("Test Name"));
    }

    @Test
    public void isValidCreditCardDate() {
        assertTrue(CardController.isValidCreditCardDate("12/25"));
    }

    @Test
    public void isValidCreditCardCVV() {
        assertTrue(CardController.isValidCreditCardCVV("123"));
    }
}