package Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Rabih
 */
public class CardView {
    
    private final Invoice invoice;
    private final JFrame frame;
    
    private final InvoiceFormatter formatter;
    private final JTextArea checkoutCart;
    private final JTextField numberField;
    private final JLabel numberLabel;
    private final JTextField nameField;
    private final JLabel nameLabel;
    private final JFormattedTextField dateField;
    private final JLabel dateLabel;
    private final JTextField cvvField;
    private final JLabel cvvLabel;
    private final JLabel validLabel;
    private final JButton backButton;
    private final JButton payButton;

    public CardView(Invoice invoice) {
        this.invoice = invoice;
        // set up components
        formatter = new SimpleFormatter();
        checkoutCart = new JTextArea(10, 18);
        checkoutCart.setEditable(false);
        checkoutCart.setText(this.invoice.format(formatter));

        numberField = new JTextField(20);
        numberLabel = new JLabel("Card Number:");
        nameField = new JTextField(20);
        nameLabel = new JLabel("Card Name:");
        DateFormat dateformat = new SimpleDateFormat("MM/yy");
        dateField = new JFormattedTextField(dateformat);
        dateField.setName("12/22");
        dateField.setColumns(5);
        dateLabel = new JLabel("Date:");
        cvvField = new JTextField(5);
        cvvLabel = new JLabel("cvv:");

        validLabel = new JLabel("");
        backButton = new JButton("Back");
        payButton = new JButton("Pay");

        frame = new JFrame("Cart Checkout");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(210, 400));
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
    
    public InvoiceFormatter getFormatter() {
        return formatter;
    }
 
    public JFrame getFrame() {
        return frame;
    }
    
    public JButton getPayButton() {
        return payButton;
    }
    
    public JButton getBackButton() {
        return backButton;
    }
    
    public JTextField getNumberField() {
        return numberField;
    }

    public JTextField getNameField() {
        return nameField;
    }
    
    public JTextField getDateField() {
        return dateField;
    }
    
    public JTextField getCVVField() {
        return cvvField;
    }
    
    public JLabel getValidLabel() {
        return validLabel;
    }
}
