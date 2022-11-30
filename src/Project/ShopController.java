package Project;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;


/**
   A program that tests the invoice classes.
*/
public class ShopController
{
    private final CustomerView customer;
    private final Invoice invoice; 
    
    public ShopController(DefaultListModel dlm){        
        this.invoice = new Invoice(); 
        this.customer = new CustomerView(dlm);      
    }
    
    public void initController() {
        ChangeListener listener = e -> customer.getTextArea().setText(invoice.format(customer.getFormatter()));
        
        invoice.addChangeListener(listener);
        
        customer.getAdd().addActionListener(e -> {
            LineItem item = (LineItem) customer.getList().getSelectedValue();
            invoice.addItem(item);
        });
        
        customer.getRemove().addActionListener(e -> {
            LineItem item = (LineItem) customer.getList().getSelectedValue();
            invoice.removeItem(item);
        });

        customer.getInfo().addActionListener(e -> {
            LineItem item = (LineItem) customer.getList().getSelectedValue();
            JOptionPane.showMessageDialog(null, item.getInfo(), "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        
        customer.getCheckout().addActionListener(e -> new CardController(new CardView(invoice)));
    }    
}
