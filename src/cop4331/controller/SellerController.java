package cop4331.controller;

import cop4331.model.LineItem;
import cop4331.model.SellerBundle;

import cop4331.gui.ProfitView;
import cop4331.gui.SellerBundleView;
import cop4331.gui.SellerNewView;
import cop4331.gui.SellerView;

import cop4331.application.Profit;
import cop4331.application.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.event.ChangeListener;

/**
 * Seller view pages controller.
 * @author Rabih
 */
public class SellerController
{
    private final SellerView sellerView;
    private final SellerNewView sellerNew;
    private final SellerBundleView sellerBundle;

    private final Data data;
    private final DefaultListModel dlm;
    private final SellerBundle sb;

    /**
     * Constructor.
     * @param dlm
     */    
    public SellerController(DefaultListModel dlm){        
        this.sellerView = new SellerView(dlm);
        this.sellerNew = new SellerNewView();
        this.sellerBundle = new SellerBundleView();
        this.data = new Data();
        this.dlm = dlm;
        this.sb = new SellerBundle();
    }

    /**
     * Initializes SellerView and adds listeners for buttons, text area,
     * and other UI elements.
     */          
    public void initController() {
        sellerView.view();
        
        ChangeListener listener = e -> sellerBundle.getBundleArea().setText(sb.format(sellerBundle.getFormatter()));
        
        sb.addChangeListener(listener);
        
        // MouseListener for highlighted element in JList. 
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    if (sellerView.getList().getSelectedValue() == null) {
                        sellerView.getList();
                    }
                    LineItem item = (LineItem) sellerView.getList().getSelectedValue();
                    sellerView.getTextArea().setText(item.getSellerInfo());
                    

                }
            }
        };
        sellerView.getList().addMouseListener(mouseListener);
        
        sellerView.getNew().addActionListener(e -> {
            sellerView.getTextArea().setText(" ");
            sellerView.getTextArea().setText("");
            sellerNew.view();
            sellerNew.getNewButton().addActionListener(new VerifyListenerNew());        
            sellerNew.getBackButton().addActionListener(a -> sellerNew.getFrame().dispose());
        });
        
        sellerView.getRemove().addActionListener(e -> {
            sellerView.getTextArea().setText(" ");
            sellerView.getTextArea().setText("");
            LineItem item = (LineItem) sellerView.getList().getSelectedValue();
            sellerView.getFrame().dispose();
            data.dataSellerRemoveItem(item);
            data.init();
            SellerController shop = new SellerController(data.getDefaultListModel());
            shop.initController();
        });
        
        // Initialize profit view.
        sellerView.getProfit().addActionListener(e -> {           
            new ProfitView(Profit.getInstance());
        });
        
        sellerView.getBundle().addActionListener(e -> {
            
            sellerView.getTextArea().setText(" ");
            sellerView.getTextArea().setText("");
            sellerBundle.view(dlm);
            sellerBundle.getBundleButton().addActionListener(new VerifyListenerBundle()); 
            sellerBundle.getBackButton().addActionListener(a -> sellerBundle.getFrame().dispose());
            sellerBundle.getAddButton().addActionListener(a -> {
                LineItem item = (LineItem) sellerBundle.getComboBox().getSelectedItem();
                sb.addItem(item);
            });     
        });
        
        sellerView.getLogOut().addActionListener(e -> {
            sellerView.getFrame().dispose();
            new UserController().initLogin();
        });  
    }

    /**
     * Checks if new item name is "Bundle".
     * @param n
     * @return true if n is "Bundle", false otherwise.
     */      
    public boolean isBundle(String n) {
        return "Bundle".equals(n);
    }    

    /**
     * Validates if String is a double.
     * @param n
     * @return false if n has a double format, true otherwise.
     */        
    public boolean isValidDouble(String n) {
        return !n.matches("(\\d+\\.?\\d+)");
    }

    /**
     * Validates if String is a integer.
     * @param n
     * @return false if n has an integer format, true otherwise.
     */          
    public boolean isValidInteger(String n) {
        return !n.matches("(0|[1-9]\\d*)");
    }

    /**
     * Validates if String is a percentage.
     * @param n
     * @return false if n has a double format and is between
     * 0 and 100 (excluding 100), true otherwise.
     */         
    public boolean isValidDiscountNumber(String n) {
        return !n.matches("^(([0-9][0-9]?(\\.[0-9]+)?))$");
    }    

    /**
     * Listener object that implements action listener and sets the label's
     * text to show whether the new item data is valid.
     */       
    public class VerifyListenerNew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {            
            String name = sellerNew.getNameField().getText();
            String description = sellerNew.getDescriptionArea().getText();
            String price = sellerNew.getPriceField().getText();
            String quantity = sellerNew.getQuantityField().getText();
            String discount = sellerNew.getDiscountField().getText();
            
            if (name.isEmpty()) {
                sellerNew.getValidLabel().setText("Empty name field.");
            } 
            else if (isBundle(name)) {
                sellerNew.getValidLabel().setText("Click Bundle to add new Bundle.");
            } 
            else if (description.isEmpty()) {
                sellerNew.getValidLabel().setText("Empty description field.");
            } 
            else if (isBundle(description)) {
                sellerNew.getValidLabel().setText("Click Bundle to add new Bundle.");
            } 
            else if (isValidDouble(price)) {
                sellerNew.getValidLabel().setText("Price must be a number.");
            }
            else if (isValidInteger(quantity)) {
                sellerNew.getValidLabel().setText("Quantity must be a integer.");
            }
            else if (isValidDiscountNumber(discount)) {
                sellerNew.getValidLabel().setText("Discount must be 0-99.");
            }
            else {
                sellerView.getFrame().dispose();
                sellerNew.getFrame().dispose();
                
                data.dataSellerNewItem(name, description, quantity, price, discount);
                data.init();
                SellerController shop = new SellerController(data.getDefaultListModel());
                shop.initController();
            }
        }
    }         

    /**
     * Listener object that implements action listener and sets the label's
     * text to show whether new Bundle data is valid.
     */    
    public class VerifyListenerBundle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {            
            String bundle = sellerBundle.getBundleArea().getText();
            String quantity = sellerBundle.getQuantityField().getText();
            String discount = sellerBundle.getDiscountField().getText();
            
            if (bundle.isEmpty()) {
                sellerBundle.getValidLabel().setText("Add items to bundle.");
            } 
            else if (isValidInteger(quantity)) {
                sellerBundle.getValidLabel().setText("Quantity must be a integer.");
            }
            else if (isValidDiscountNumber(discount)) {
                sellerBundle.getValidLabel().setText("Discount must be 0-99.");
            }
            else {
                sellerView.getFrame().dispose();
                sellerBundle.getFrame().dispose();
                
                data.dataSellerBundleItem(sb,quantity, discount);
                data.init();
                SellerController shop = new SellerController(data.getDefaultListModel());
                shop.initController();
            }
        }
    }     
}

