package cop4331.gui;

import cop4331.model.LineItem;

import cop4331.formatter.SellerBundleFormatter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Seller new bundle UI view. 
 * @author Rabih
 */
public class SellerBundleView {

    private JFrame frame;
    private SellerBundleFormatter formatter;
    private JComboBox combo;
    private JTextArea bundleArea;
    private JScrollPane bundlePane;
    private JLabel bundleLabel;
    private JTextField quantityField;
    private JLabel quantityLabel;
    private JTextField discountField;
    private JLabel discountLabel;
    private JLabel validLabel;
    private JButton backButton;
    private JButton addButton;
    private JButton bundleButton;
    Border border = BorderFactory.createLineBorder(Color.GRAY);

    /**
     * Constructor.
     */        
    public SellerBundleView() {}

    /**
     * Sets up all UI components.
     * @param plist
     */     
    public void view(DefaultListModel plist) {
        // set up components
        formatter = new SellerBundleFormatter();
        combo = new JComboBox();
        LineItem item;
        for(int i = 0; i< plist.getSize();i++){
            item = (LineItem) plist.getElementAt(i);
            if (!"Bundle".equals(item.getDescription())) {
                combo.addItem(item);
            }
        }
        
        combo.setPreferredSize(new Dimension(180, 20));
        bundleArea = new JTextArea(7, 20);
        bundleArea.setLineWrap(true);
        bundleArea.setWrapStyleWord(true);
        bundleArea.setEditable(false);
        bundleArea.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        bundlePane = new JScrollPane(bundleArea);  
        bundleLabel = new JLabel("Items to Bundle:");
        quantityField = new JTextField(20);
        quantityLabel = new JLabel("Item Quantity:");  
        discountField = new JTextField(20);
        discountLabel = new JLabel("Discount:");  
        validLabel = new JLabel("");
        backButton = new JButton("Back");
        addButton = new JButton("Add");
        bundleButton = new JButton("Bundle");

        frame = new JFrame("Add New Bundle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(210, 400));
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(bundleLabel);
        frame.add(combo);
        frame.add(bundlePane);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(discountLabel);
        frame.add(discountField);
        frame.add(backButton);
        frame.add(addButton);
        frame.add(bundleButton);
        frame.add(validLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }   
 
    public JFrame getFrame() { return frame; }
    public SellerBundleFormatter getFormatter() { return formatter; }    
    public JComboBox getComboBox() { return combo; }        
    public JButton getAddButton() { return addButton; }    
    public JButton getBundleButton() { return bundleButton; }    
    public JButton getBackButton() { return backButton; }    
    public JTextArea getBundleArea() { return bundleArea; }       
    public JTextField getQuantityField() { return quantityField; }
    public JTextField getDiscountField() { return discountField; }   
    public JLabel getValidLabel() { return validLabel; }
}
