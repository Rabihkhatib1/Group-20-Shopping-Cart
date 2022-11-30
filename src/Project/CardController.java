package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rabih
 */
public class CardController {
    private final CardView cardview;
    
    public CardController(CardView cv) {
        this.cardview = cv;
        initCardController();
    }
    
    private void initCardController() {
        cardview.getPayButton().addActionListener(new VerifyListener());        
        cardview.getBackButton().addActionListener(e -> cardview.getFrame().dispose());
    }
    
    public boolean isValidCreditCardNumber(String number) {
        return number.length() == 16;
    }
 
    public boolean isValidCreditCardName(String name) {
        return !name.isEmpty();
    }
    
    public boolean isValidCreditCardDate(String date) {
        return date.length() == 5;
    }
    
    public boolean isValidCreditCardCVV(String cvv) {
        return cvv.length() == 3;
    }
           
    // Sets the label's text to show whether the credit card data is valid.
    public class VerifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String number = cardview.getNumberField().getText();
            String name = cardview.getNameField().getText();
            String date = cardview.getDateField().getText();
            String cvv = cardview.getCVVField().getText();
            
            if (isValidCreditCardNumber(number)) {
                cardview.getValidLabel().setText("Invalid number.");
            } 
            else if (isValidCreditCardName(name)) {
                cardview.getValidLabel().setText("Empty name.");
            }
            else if (isValidCreditCardDate(date)) {
                cardview.getValidLabel().setText("Invalid date.");
            }
            else if (isValidCreditCardCVV(cvv)) {
                cardview.getValidLabel().setText("Invalid cvv.");
            }
            else {
                Profit profit = new Profit();
                profit.addRevenue(cardview);
                cardview.getPayButton().addActionListener(e -> new ProfitView(profit));
            }
        }
    }   
}
