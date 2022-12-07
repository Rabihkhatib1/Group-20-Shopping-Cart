package cop4331.controller;

import cop4331.gui.CardView;
import cop4331.gui.CustomerView;

import cop4331.model.Invoice;
import cop4331.model.LineItem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;


/**
 * Customer view page controller.
 * @author Gerrell
 */
public class CustomerController {
    private final CustomerView customer;
    private final Invoice invoice; 
    private CardView cardview;
    
    /**
     * Constructor.
     * @param dlm
     */  
    public CustomerController(DefaultListModel dlm){        
        this.invoice = new Invoice(); 
        this.customer = new CustomerView(dlm);      
    }

    /**
     * Initializes CustomerView and adds listeners for buttons, text area,
     * and other UI elements.
     */      
    public void initController() {
        customer.view();
        
        // Changelistener to update textarea with invoice data.
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
        
        cardview = new CardView(invoice);
        
        customer.getCheckout().addActionListener(e -> {
        new CardController(cardview,invoice);
            cardview.getFrame().addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosed(WindowEvent e) {
                invoice.reset();
                customer.getTextArea().setText(invoice.clearFormat());
                invoice.addChangeListener(listener);
            }
            });         
        });  
        
        customer.getLogOut().addActionListener(e -> {
            customer.getFrame().dispose();
            new UserController().initLogin();
        });        
        
    }    
}
