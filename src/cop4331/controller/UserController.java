package cop4331.controller;

import cop4331.gui.LoginView;
import cop4331.gui.SignupView;

import cop4331.application.User;
import cop4331.application.Inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User view pages controller.
 * @author Rabih
 */
public class UserController {
    private final Inventory data;
    private final SignupView signup;
    private final LoginView login;
    
    /**
     * Constructor.
     */      
    public UserController() {
        this.login = new LoginView();
        this.signup = new SignupView();
        this.data = new Inventory();
    }

    /**
     * Initializes LoginView and adds listeners for buttons.
     */      
    public void initLogin() {  
        login.view();
        
        login.getSignupButton().addActionListener(e -> {      
            login.getFrame().dispose();
            initSignup();        
        });
        login.getLoginButton().addActionListener(new VerifyListenerLogin());
    }

    /**
     * Initializes SignupView and adds listeners for buttons.
     */          
    public void initSignup() {
        signup.view();
        
        signup.getBackButton().addActionListener(a -> {      
            signup.getFrame().dispose();
            initLogin();
        });       
        signup.getNewAccountButton().addActionListener(new VerifyListenerSignup());
    }

    /**
     * Listener object that implements action listener and sets the label's
     * text to show whether the login data is valid.
     */     
    public class VerifyListenerLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {            
            String name = login.getUserNameField().getText();
            String pwd = login.getPWDField().getText();
            
            if (name.isEmpty()) {
                login.getValidLabel().setText("Empty username field.");
            } 
            else if (pwd.isEmpty()) {
                login.getValidLabel().setText("Empty password field.");
            } 
            else if (!User.getInstance().validateUserLogin(name,pwd)){
                login.getValidLabel().setText("<html>Incorrect username<br>or password</html>");
            }
            else {
                login.getFrame().dispose();
                if("customer".equals(login.getButtonGroup().getSelection().getActionCommand())) {
                    data.dataInventoryInit();
                    data.dataIDInit();
                    CustomerController shop = new CustomerController(data.getDefaultListModel());
                    shop.initController();
                }
                else if("seller".equals(login.getButtonGroup().getSelection().getActionCommand())) {
                    data.dataInventoryInit();
                    data.dataIDInit();   
                    SellerController shop = new SellerController(data.getDefaultListModel());
                    shop.initController();
                }
            }
        }
    } 
    
    /**
     * Listener object that implements action listener and sets the label's
     * text to show whether the signup data is valid.
     */  
    public class VerifyListenerSignup implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {            
            String name = signup.getUserNameField().getText();
            String pwd = signup.getPWDField().getText();
            String pwdConfirm = signup.getPWDConfirmField().getText();
            
            if (name.isEmpty()) {
                signup.getValidLabel().setText("Empty username field.");
            }
            else if (!User.getInstance().checkNewUser(name)) {
                signup.getValidLabel().setText("This name is already in Use.");
            }
            else if (pwd.isEmpty()) {
                signup.getValidLabel().setText("Empty password field.");
            } 
            else if (!pwdConfirm.equals(pwd)){
                signup.getValidLabel().setText("Passwords don't match.");
            }
            else {                
                User.getInstance().addNewUser(name,pwd);
                User.getInstance().updateUserData();
                signup.getFrame().dispose();
                initLogin();
            }
        }
    }          
}
