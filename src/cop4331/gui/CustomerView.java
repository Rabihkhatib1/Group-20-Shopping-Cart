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
 * Customer UI view. 
 * @author Rabih
 */
public class CustomerView {
    
    private final DefaultListModel plist;
    private InvoiceFormatter formatter;
    private JTextArea textArea;
    private JPanel panel, panelBtn;
    private JList list;
    private JScrollPane listScrollPane;
    private JFrame frame;
    private JButton addButton;
    private JButton removeButton;
    private JButton infoButton;
    private JButton checkoutButton;
    private JButton logout;

    /**
     * Constructor.
     * @param plist
     */      
    public CustomerView(DefaultListModel plist) {
        this.plist = plist;
    }

    /**
     * Sets up all UI components.
     */      
    public void view() {
        formatter = new SimpleFormatter();
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        list = new JList(plist);
        listScrollPane = new JScrollPane(list); 
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        infoButton = new JButton("Info");
        checkoutButton = new JButton("Pay");
        logout = new JButton("Log Out");
        
//      Put the combo box and the add button into a panel
        panel = new JPanel();
        panelBtn = new JPanel();

//      Create the list and put it in a scroll pane.
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);
        
        listScrollPane.setPreferredSize(new Dimension(360, 240));
        panel.add(listScrollPane, BorderLayout.CENTER);

        panelBtn.add(addButton);
        panelBtn.add(removeButton);
        panelBtn.add(infoButton);
        panelBtn.add(checkoutButton);
        panelBtn.add(logout);
      
        // Add the text area and panel to the frame
        frame = new JFrame("JAVA Shopping App");
        frame.add(new JScrollPane(textArea),BorderLayout.NORTH);
        frame.add(new JScrollPane(panel),BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panelBtn, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }

    public InvoiceFormatter getFormatter() { return formatter; }              
    public JTextArea getTextArea() { return textArea; }             
    public JPanel getPanel() { return panel; }           
    public JList getList() { return list; }    
    public JFrame getFrame() { return frame; }       
    public JButton getAdd() { return addButton; }     
    public JButton getRemove() { return removeButton; }        
    public JButton getInfo() { return infoButton; }    
    public JButton getCheckout() { return checkoutButton; }        
    public JButton getLogOut() { return logout; }
}
