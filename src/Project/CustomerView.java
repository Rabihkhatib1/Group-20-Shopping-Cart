/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

//import static Project.ShopController.list;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Rabih
 */
public class CustomerView {
    
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
    
    public CustomerView(DefaultListModel plist) {
        formatter = new SimpleFormatter();
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        list = new JList(plist);
        listScrollPane = new JScrollPane(list); 
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        infoButton = new JButton("Info");
        checkoutButton = new JButton("Pay");
//      Put the combo box and the add button into a panel
        panel = new JPanel();
        panelBtn = new JPanel();

//      Create the list and put it in a scroll pane.
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);
        

//        panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));

        panel.add(listScrollPane, BorderLayout.CENTER);
//        panelBtn.setLayout(new BoxLayout(panelBtn,BoxLayout.LINE_AXIS));
        panelBtn.add(addButton);
        panelBtn.add(removeButton);
        panelBtn.add(infoButton);
        panelBtn.add(checkoutButton);
      
        // Add the text area and panel to the frame
        frame = new JFrame("JAVA Shopping App");
//        frame.setSize(new Dimension(610, 800));
//        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(textArea),BorderLayout.NORTH);
//        frame.add(new JScrollPane(panel),BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panelBtn, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public InvoiceFormatter getFormatter() {
        return formatter;
    }
    public void setFormatter(InvoiceFormatter formatter) {
        this.formatter = formatter;
    }          
    
    public JTextArea getTextArea() {
        return textArea;
    }
    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }       
    
    public JPanel getPanel() {
        return panel;
    }
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }    
    
    public JList getList() {
        return list;
    }
    public void setList(JList list) {
        this.list = list;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JButton getAdd() {
        return addButton;
    }
    public void setAdd(JButton add) {
        this.addButton = add;
    }
    
    public JButton getRemove() {
        return removeButton;
    }
    public void setRemove(JButton remove) {
        this.removeButton = remove;
    }
    
    public JButton getInfo() {
        return infoButton;
    }
    public void setInfo(JButton info) {
        this.infoButton = info;
    }
    
    public JButton getCheckout() {
        return checkoutButton;
    }
    public void setCheckout(JButton checkout) {
        this.checkoutButton = checkout;
    }
}
