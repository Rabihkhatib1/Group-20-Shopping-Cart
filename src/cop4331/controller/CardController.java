package cop4331.controller;

import cop4331.gui.CardView;

import cop4331.model.Invoice;

import cop4331.application.Profit;
import cop4331.application.Inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Credit Card payment page controller.
 * @author Rabih
 */
public class CardController {
    private Inventory data;
    private final CardView cardview;
    private final Invoice invoice;

    /**
     * Constructor.
     * @param cv
     * @param invoice
     */    
    public CardController(CardView cv, Invoice invoice) {
        this.cardview = cv;
        this.invoice = invoice;
        initCardController();
    }

    /**
     * Initializes CardView and add action listeners for buttons.
     */     
    private void initCardController() {
        cardview.view();
        cardview.getPayButton().addActionListener(new VerifyListener());        
        cardview.getBackButton().addActionListener(e -> cardview.getFrame().hide());
    }

    /**
     * Validates Credit Card number using regular expressions.
     * @param number
     * @return true if Credit Card number is in the correct format, 
     * false otherwise.
     */       
    public boolean isValidCreditCardNumber(String number) {
        return number.matches("(^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|))$");
    }

    /**
     * Checks if Credit Card name is empty.
     * @param name
     * @return true if Credit Card name is empty, false otherwise.
     */       
    public boolean isValidCreditCardName(String name) {
        return name.isEmpty();
    }

    /**
     * Validates Credit Card date using regular expressions.
     * @param date
     * @return true if Credit Card date is in the correct format, 
     * false otherwise.
     */      
    public boolean isValidCreditCardDate(String date) {
        return date.matches("(^(0[1-9]|1[0-2])\\/?([0-9]{2})$)");
    }

    /**
     * Validates Credit Card cvv number using regular expressions.
     * @param cvv
     * @return true if Credit Card cvv number is in the correct format, 
     * false otherwise.
     */      
    public boolean isValidCreditCardCVV(String cvv) {
        return cvv.matches("^[0-9]{3}$");
    }
    
    /**
     * Listener object that implements action listener and sets the label's
     * text to show whether the credit card data is valid or not.
     */   
    public class VerifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String number = cardview.getNumberField().getText();
            String name = cardview.getNameField().getText();
            String date = cardview.getDateField().getText();
            String cvv = cardview.getCVVField().getText();
            
            if (!isValidCreditCardNumber(number)) {
                cardview.getValidLabel().setText("<html>Invalid number. Must start<br>with 4 and is 16 digits long.</html>");
            } 
            else if (isValidCreditCardName(name)) {
                cardview.getValidLabel().setText("Empty name field.");
            }
            else if (!isValidCreditCardDate(date)) {
                cardview.getValidLabel().setText("<html>Date must be in<br>the form mm/yy.</html>");
            }
            else if (!isValidCreditCardCVV(cvv)) {
                cardview.getValidLabel().setText("<html>Invalid cvv.<br>must be 3 digits long.</html>");
            }
            else {
                cardview.getFrame().dispose();
                data = new Inventory();
                data.dataUpdateStock(invoice);
                Profit.getInstance().addRevenue(cardview);
                
                JOptionPane.showMessageDialog(null, "Thank You For Purchasing!", "Purchase Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } 
}
