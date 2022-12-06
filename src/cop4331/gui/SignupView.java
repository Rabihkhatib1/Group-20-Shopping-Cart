package cop4331.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Sign up UI view. 
 * @author Rabih
 */
public class SignupView{  
        private JFrame frame;
	private JTextField userName;
        private JPasswordField pwd, pwdConfirm;
	private JLabel userNameLabel, pwdLabel, pwdConfirmLabel, validLabel;
	private JButton backButton,newAccountButton;

    /**
     * Constructor.
     */           
    public SignupView() { }

    /**
     * Sets up all UI components.
     */      
    public void view() {
        // set up components
        userName = new JTextField(25);
        pwd = new JPasswordField(25);
        pwdConfirm = new JPasswordField(25);
        userNameLabel = new JLabel("Choose UserName");
        pwdLabel = new JLabel("Choose Password");
        pwdConfirmLabel = new JLabel("Confirm Password");
        backButton = new JButton("Back to Login");
        newAccountButton = new JButton("Create Account");
        validLabel = new JLabel("");
        frame = new JFrame("Signup");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(300, 250));
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(userNameLabel);
        frame.add(userName);
        frame.add(pwdLabel);
        frame.add(pwd);
        frame.add(pwdConfirmLabel);
        frame.add(pwdConfirm);
        frame.add(backButton);
        frame.add(newAccountButton);
        frame.add(validLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }
    
    public JFrame getFrame() { return frame; }    
    public JButton getNewAccountButton() { return newAccountButton; }    
    public JButton getBackButton() { return backButton; }
    public JTextField getUserNameField() { return userName; }    
    public JTextField getPWDField() { return pwd; }       
    public JTextField getPWDConfirmField() { return pwdConfirm; }
    public JLabel getValidLabel() { return validLabel; }    
}