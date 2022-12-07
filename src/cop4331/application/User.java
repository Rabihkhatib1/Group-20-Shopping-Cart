package cop4331.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton class that handles user initialization and management.
 * @author Rabih
 */
public class User {
    private final ArrayList<String[]> users = new ArrayList<>();
    String[] out;
    String send;
    static private User instance = null;

    /**
     * Private constructor.
     */     
    private User() { }
    
    /**
     * Get the only instance of the object.
     * @return instance
     */
    public static User getInstance() {
    	if (instance == null) {
            instance = new User();
    	}
    	return instance;
    }    

    /**
     * Initializes User.txt with preliminary usernames and passwords
     * if the file does not exist.
     */ 
    public void userDataInit(){
        try {
            File f = new File("User.txt");
            if(!f.createNewFile()){} else {
                try (BufferedWriter fw = new BufferedWriter(new FileWriter("User.txt"))) {
                    //ID,name,desc,stock,price,discount
                    fw.write("Rabih,Khatib");
                    fw.newLine();
                    fw.write("Gerrell,Bones");
                    fw.newLine();
                    fw.write("Zachary,Bundarin");
                    fw.newLine();
                    fw.write("Solan,Degefa");
                    fw.newLine();                  
                } catch (IOException e) {
                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }            
    }  

    /**
     * Read user data from User.txt.
     */     
    public void readUserData() {
        users.clear();
        try {  
            String line;
            String splitBy = ",";
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));  
            while ((line = br.readLine()) != null) {   //returns a Boolean value   
                String[] string = line.split(splitBy);    // use comma as separator  
                users.add(string);
            }  
            br.close();
        } catch (IOException e) {  
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }           
    }

    /**
     * Updates changes to user data in User.txt.
     */        
    public void updateUserData() {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("User.txt"))) {
            for(int i = 0; i < users.size(); i++ )  {
                out = users.get(i);
                send = String.join(",",out);
                fw.write(send);
                fw.newLine();
            }
            fw.close();
        } catch (IOException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }
    } 

    /**
     * Adds new signup username and password to User.txt.
     * @param name username of new user.
     * @param pwd password of new user.
     */        
    public void addNewUser(String name, String pwd) {
        readUserData();
        out = new String [] {name,pwd};
        users.add(out);
        updateUserData();
    } 

    /**
     * Checks if new signup username already exists.
     * @param name username of new user.
     * @return false if username already exists, true otherwise.
     */       
    public boolean checkNewUser(String name) {
        readUserData();
        for(int i = 0; i < users.size(); i++ ) {
            if (name.equals(users.get(i)[0])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if logging user's username and password are correct.
     * @param name username of logging user.
     * @param pwd password of logging user.
     * @return true if user is valid, false otherwise.
     */       
    public boolean validateUserLogin(String name, String pwd) {
        readUserData();
        for(int i = 0; i < users.size(); i++ ) {
            if (name.equals(users.get(i)[0])) {
                if (pwd.equals(users.get(i)[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}
