package cop4331.gui;

import cop4331.model.Invoice;

import cop4331.formatter.InvoiceFormatter;
import cop4331.formatter.SimpleFormatter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Credit Card UI view. 
 * @author Solan
 */
public class CardView {
    
    private final Invoice invoice;
    private JFrame frame;   
    private InvoiceFormatter formatter;
    private JTextArea checkoutCart;
    private JTextField numberField;
    private JLabel numberLabel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField dateField;
    private JLabel dateLabel;
    private JTextField cvvField;
    private JLabel cvvLabel;
    private JLabel validLabel;
    private JButton backButton;
    private JButton payButton;

    /**
     * Constructor.
     * @param invoice
     */     
    public CardView(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Sets up all UI components.
     */       
    public void view() {
        // set up components
        formatter = new SimpleFormatter();
        checkoutCart = new JTextArea(10, 16);
        checkoutCart.setEditable(false);
        checkoutCart.setText(this.invoice.format(formatter));

        numberField = new JTextField(17);
        numberLabel = new JLabel("Card Number:");
        nameField = new JTextField(17);
        nameLabel = new JLabel("Card Name:");
        dateField = new JTextField(5);
        dateLabel = new JLabel("Date:");
        cvvField = new JTextField(5);
        cvvLabel = new JLabel("cvv:");

        validLabel = new JLabel("");
        backButton = new JButton("Back");
        payButton = new JButton("Pay");

        frame = new JFrame("Cart Checkout");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(new Dimension(210, 420));
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(checkoutCart),BorderLayout.CENTER);
        frame.add(numberLabel);
        frame.add(numberField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(cvvLabel);
        frame.add(cvvField);
        frame.add(backButton);
        frame.add(payButton);
        frame.add(validLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public InvoiceFormatter getFormatter() { return formatter; } 
    public JFrame getFrame() { return frame; }    
    public JButton getPayButton() { return payButton; }    
    public JButton getBackButton() { return backButton; }    
    public JTextField getNumberField() { return numberField; }
    public JTextField getNameField() { return nameField; }    
    public JTextField getDateField() { return dateField; }    
    public JTextField getCVVField() { return cvvField; }    
    public JLabel getValidLabel() { return validLabel; }
}
