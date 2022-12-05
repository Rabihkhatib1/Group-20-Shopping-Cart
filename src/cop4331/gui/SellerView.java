package cop4331.gui;

import cop4331.formatter.InvoiceFormatter;
import cop4331.formatter.SimpleFormatter;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

/**
 * Seller UI view. 
 * @author Rabih
 */
public class SellerView {
    private DefaultListModel plist;
    private InvoiceFormatter formatter;
    private JTextArea textArea;
    private JPanel panel, panelBtn;
    private JList list;
    private JScrollPane listScrollPane;
    private JFrame frame;
    private JButton newButton;
    private JButton removeButton;
    private JButton profitButton;
    private JButton bundleButton;
    private JButton logout;

    /**
     * Constructor.
     * @param plist
     */     
    public SellerView(DefaultListModel plist) {
        this.plist = plist;  
    }

    /**
     * Sets up all UI components.
     */     
    public void view() {
        formatter = new SimpleFormatter();
        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        list = new JList(plist);
        listScrollPane = new JScrollPane(list); 
        newButton = new JButton("New");
        removeButton = new JButton("Remove");
        bundleButton = new JButton("Bundle");
        profitButton = new JButton("profit");
        logout = new JButton("log out");
        
        // Put the combo box and the add button into a panel
        panel = new JPanel();        
        panelBtn = new JPanel();

        // Create the list and put it in a scroll pane.
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);        
        listScrollPane.setPreferredSize(new Dimension(360, 240));
        
        panel.add(listScrollPane, BorderLayout.CENTER);
        panelBtn.add(newButton); 
        panelBtn.add(bundleButton);
        panelBtn.add(removeButton);
        panelBtn.add(profitButton);
        panelBtn.add(logout);

        // Add the text area and panel to the frame
        frame = new JFrame("JAVA Shopping App");
        frame.add(new JScrollPane(textArea),BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panelBtn, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void updatePanel(DefaultListModel dlm) {
        this.plist = dlm;
        list = new JList(plist);
        listScrollPane = new JScrollPane(list);
        frame.dispose();
        view();
        panel.revalidate();
        panel.repaint();
        
    }
    public InvoiceFormatter getFormatter() { return formatter; }             
    public JTextArea getTextArea() { return textArea; }        
    public JPanel getPanel() { return panel; }      
    public JList getList() { return list; }  
    public JFrame getFrame() { return frame; }    
    public JButton getNew() { return newButton; }
    public JButton getRemove() { return removeButton; }    
    public JButton getProfit() { return profitButton; }   
    public JButton getBundle() { return bundleButton; }   
    public JButton getLogOut() { return logout; }
}