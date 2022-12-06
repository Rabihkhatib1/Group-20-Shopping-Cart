package cop4331.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Login UI view. 
 * @author Rabih
 */
public class LoginView{  
        private JFrame frame;
        private JRadioButton customer, seller;
	private JTextField userName;
        private JPasswordField pwd;
	private JPanel panel;
	private JLabel userNameLabel, pwdLabel, validLabel;
	private JButton signupButton,loginButton;
        private ButtonGroup bg;

    /**
     * Constructor.
     */              
    public LoginView() { }

    /**
     * Sets up all UI components.
     */      
    public void view() {
        // set up components
        panel = new JPanel();
        customer = new JRadioButton("customer");
        customer.setActionCommand("customer");
	seller = new JRadioButton("seller");  
        seller.setActionCommand("seller");
	bg = new ButtonGroup();  
        bg.add(customer);
        bg.add(seller);
        customer.setSelected(true);
        userName = new JTextField(17);
        pwd = new JPasswordField(17);
        userNameLabel = new JLabel("UserName");
        pwdLabel = new JLabel("Password");
        signupButton = new JButton("Create Account");
        loginButton = new JButton("Login");
        validLabel = new JLabel("");
        panel.add(customer);
        panel.add(seller);
        frame = new JFrame("Login");
        
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(230, 240));
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(panel);
        frame.add(userNameLabel);
        frame.add(userName);
        frame.add(pwdLabel);
        frame.add(pwd);
        frame.add(signupButton);
        frame.add(loginButton);
        frame.add(validLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public JFrame getFrame() { return frame; }    
    public ButtonGroup getButtonGroup() { return bg; }    
    public JButton getSignupButton() { return signupButton; }    
    public JButton getLoginButton() { return loginButton; }
    public JTextField getUserNameField() { return userName; }    
    public JTextField getPWDField() { return pwd; }   
    public JLabel getValidLabel() { return validLabel; }  
}