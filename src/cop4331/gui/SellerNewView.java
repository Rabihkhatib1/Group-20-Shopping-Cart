package cop4331.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Seller new item UI view. 
 * @author Rabih
 */
public class SellerNewView {

    private JFrame frame;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextArea descriptionArea;
    private JScrollPane descriptionPane;
    private JLabel descriptionLabel;
    private JTextField priceField;
    private JLabel priceLabel;
    private JTextField quantityField;
    private JLabel quantityLabel;
    private JTextField discountField;
    private JLabel discountLabel;
    private JLabel validLabel;
    private JButton backButton;
    private JButton newButton;
    Border border = BorderFactory.createLineBorder(Color.GRAY);

    /**
     * Constructor.
     */ 
    public SellerNewView() {}

    /**
     * Sets up all UI components.
     */         
    public void view() {
        // set up components
        nameField = new JTextField(17);
        nameLabel = new JLabel("Item Name:");
        descriptionArea = new JTextArea(5, 17);
        descriptionArea.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionPane = new JScrollPane(descriptionArea);        
        descriptionLabel = new JLabel("Item Description:");
        priceField = new JTextField(17);
        priceLabel = new JLabel("Item Price:");   
        quantityField = new JTextField(17);
        quantityLabel = new JLabel("Item Quantity:");  
        discountField = new JTextField(17);
        discountLabel = new JLabel("Discount:");  

        validLabel = new JLabel("");
        backButton = new JButton("Back");
        newButton = new JButton("New");

        frame = new JFrame("Add New Item");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(210, 400));
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(descriptionLabel);
        frame.add(descriptionPane);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(discountLabel);
        frame.add(discountField);
        frame.add(backButton);
        frame.add(newButton);
        frame.add(validLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }   
 
    public JFrame getFrame() { return frame; }    
    public JButton getNewButton() { return newButton; }    
    public JButton getBackButton() { return backButton; }
    public JTextField getNameField() { return nameField; }    
    public JTextArea getDescriptionArea() { return descriptionArea; }       
    public JTextField getPriceField() { return priceField; }    
    public JTextField getQuantityField() { return quantityField; }
    public JTextField getDiscountField() { return discountField; }    
    public JLabel getValidLabel() { return validLabel; }
}
