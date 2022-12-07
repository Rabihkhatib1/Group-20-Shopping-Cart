package cop4331.application;

import cop4331.model.Bundle;
import cop4331.model.DiscountedItem;
import cop4331.model.Invoice;
import cop4331.model.LineItem;
import cop4331.model.Product;
import cop4331.model.SellerBundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

/**
 * Class that handles inventory initialization and management. 
 * @author Rabih
 */
public class Inventory {
    Bundle bundle = new Bundle(0,0);
    DefaultListModel dlm = new DefaultListModel();
    private final ArrayList<String[]> pItems = new ArrayList<>();
    String line;  
    String splitBy = ","; 
    String current;
    String send;
    String[] out;
    Product product;
    DiscountedItem discount;
    private double p,d, costs;
    Integer id,s, index,currentID;
    
    public Inventory() {}
    
    public void init() {
        dataInventoryInit();
        dataIDInit();
    }
    
    /**
     * Initializes Inventory.txt.
     * Initializes with preliminary item data if the file does not exist.
     * Updates the current ID and calls dataUpdatefromFile().
     */
    public void dataInventoryInit(){
        try {
            File f = new File("Inventory.txt");
            if(!f.createNewFile()){} else {
                try (BufferedWriter fw = new BufferedWriter(new FileWriter("Inventory.txt"))) {
                    //ID,name,desc,stock,price,discount
                    fw.write("0,Strawberry Ice Cream,Delicious strawberry flavored ice cream.,5,1.99,0");
                    fw.newLine();
                    fw.write("1,Hammer,Hammer to smash things.,5,19.95,0");
                    fw.newLine();
                    fw.write("2,Television,30 inch widescreen TV.,5,159.95,0");
                    fw.newLine();
                    fw.write("3,Assorted Nails,20 Assorted Nails ideal for construction.,10,9.95,0");
                    fw.newLine();
                    fw.write("4,Milk,3.78L far free milk.,10,5.99,0");
                    fw.newLine();
                    fw.write("5,Water Bottle,reusable water bottle for children.,5,19.95,20");
                    fw.newLine();
                    //ID,name,discount,stock,names...
                    fw.write("6,Bundle,10,17,Hammer,Assorted Nails,Water Bottle");
                    fw.close();
                } catch (IOException e) {
                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
                }
                currentID = 7;
            }
        } catch (IOException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }            
        
        dataUpdatefromFile();
    }
    
    /**
     * Initializes ID.txt.
     */
    public void dataIDInit(){
        try {
            File f = new File("ID.txt");
            if(!f.createNewFile()){} else {
                try (BufferedWriter fw = new BufferedWriter(new FileWriter("ID.txt"))) {
                    fw.write(String.format("%d",currentID));
                    fw.close();
                } catch (IOException e) {
                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }   
    }  
    
    /**
     * Reads items from Inventory.txt into ArrayList.
     */
    public void dataReadItems(){
        try {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("Inventory.txt"));  
            while ((line = br.readLine()) != null) {   //returns a Boolean value   
                String[] string = line.split(splitBy);    // use comma as separator  
                pItems.add(string);
                
            }  
            br.close();
        } catch (IOException e) {  
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);  
        }   
    }
    
    /**
     * Reads ID from ID.txt.
     */    
    public void dataReadID(){ 
        //parsing a CSV file into BufferedReader class constructor   
        Scanner sc;
        try {
            sc = new Scanner(new File("ID.txt"));
            String stringID = sc.next();
            currentID = Integer.parseInt(stringID);
            sc.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }    
    }

    /**
     * Writes current ID to ID.txt.
     */        
    public void dataUpdateID(){ 
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("ID.txt"))) {
            fw.write(String.format("%d",currentID));
            fw.close();
        } catch (IOException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Updates DefaultListModel with data from Inventory.txt.
     */      
    public void dataUpdatefromFile(){
        pItems.clear();
        dlm.removeAllElements();
        dataReadItems();
        
        for(int i = 0; i < pItems.size(); i++ ) {
            // Searching for and updating bundles
            if ("Bundle".equals(pItems.get(i)[1])) {   
                bundle = new Bundle(0,0);
                for (int j = 4; j <= (pItems.get(i).length) - 1; j++) {
                    current = pItems.get(i)[j];
                    for(int k = 0; k < pItems.size(); k++ ) {
                        if (pItems.get(k)[1].equals(current)) {
                            index = k;
                            break;
                        }                          
                    }
                    id = Integer.parseInt(pItems.get(index)[0]);
                    p = Double.parseDouble(pItems.get(index)[4]);
                    s = Integer.parseInt(pItems.get(index)[3]);
                    product = new Product(id,pItems.get(index)[1],pItems.get(index)[2],p,s);
                    bundle.add(product);
                }
                id = Integer.parseInt(pItems.get(i)[0]);
                s = Integer.parseInt(pItems.get(i)[3]);
                bundle.setID(id);
                bundle.setStock(s);
                d = Double.parseDouble(pItems.get(i)[2]);
                discount = new DiscountedItem(bundle,d);
                discount.setID(id);
                dlm.addElement(discount);
                
                costs += (bundle.getPrice()/2) * bundle.getStock();                
            }     
            
            else {
                id = Integer.parseInt(pItems.get(i)[0]);
                p = Double.parseDouble(pItems.get(i)[4]);
                s = Integer.parseInt(pItems.get(i)[3]);
                product = new Product(id,pItems.get(i)[1],pItems.get(i)[2],p,s);
                costs += (product.getPrice()/2) * product.getStock();

                if ("0".equals(pItems.get(i)[5])) {
                    dlm.addElement(product);
                }
                else {
                    d = Double.parseDouble(pItems.get(i)[5]);
                    dlm.addElement(new DiscountedItem(product,d));
                }                
            }         
        }       
        Profit.getInstance().dataProfitInit(costs);
    }  

    /**
     * Updates item quantity after consumer makes payment.
     * @param invoice invoice of purchased items by consumer.
     */      
    public void dataUpdateStock(Invoice invoice){
        pItems.clear();
        dataReadItems();
        
        Iterator<LineItem> iterator = invoice.getItems();
        LineItem currentItem;
        while(iterator.hasNext()) {
            currentItem = iterator.next();
            if ("Bundle".equals(pItems.get(currentItem.getID())[1])) {
                s = Integer.parseInt(pItems.get(currentItem.getID())[3]);
                pItems.get(currentItem.getID())[3] = Integer.toString(s - 1);
            }
            
            else if (currentItem instanceof Product) {
                s = Integer.parseInt(pItems.get(currentItem.getID())[3]);
                pItems.get(currentItem.getID())[3] = Integer.toString(s - 1);               
            }
            else if (currentItem instanceof DiscountedItem) {
                s = Integer.parseInt(pItems.get(currentItem.getID())[3]);
                pItems.get(currentItem.getID())[3] = Integer.toString(s - 1);                
            }            
        }
        dataInventoryUpdate();
    }  

    /**
     * Adds new item to Inventory.txt.
     * @param name name of new item.
     * @param description description of new item.
     * @param quantity quantity of new item.
     * @param price price of new item.
     * @param discount discount percentage of new item.
     */      
    public void dataSellerNewItem(String name,String description,String quantity,String price,String discount) {
        pItems.clear();
        dataReadItems();
        dataReadID();
        
        double addCosts;
        Integer oldQuantity, found = 0;
        
        for(int i = 0; i < pItems.size(); i++ ) {
            if(name.equals(pItems.get(i)[1])) {
                found = 1;
                oldQuantity = Integer.parseInt(pItems.get(i)[3]);
                pItems.get(i)[2] = description;
                pItems.get(i)[3] = quantity;
                pItems.get(i)[4] = price;
                pItems.get(i)[5] = discount;
                if (oldQuantity < Integer.parseInt(quantity)) {
                    addCosts = Double.parseDouble(price)/2 * (Integer.parseInt(quantity)-oldQuantity);
                    Profit.getInstance().addCosts(addCosts);
                }
                break;
            }
        }
        
        if (found != 1) {
            String newID = currentID.toString();
            currentID += 1;
            String[] newItem = new String [] {newID,name,description,quantity,price,discount};  
            addCosts = Double.parseDouble(price)/2 * Integer.parseInt(quantity);
            Profit.getInstance().addCosts(addCosts);
            pItems.add(newItem);
            dataUpdateID();     
            }
        dataInventoryUpdate();
    }  

    /**
     * Adds new item to Inventory.txt.
     * @param sb items included in bundle.
     * @param quantity quantity of new bundle.
     * @param discount discount percentage of new bundle.
     */       
    public void dataSellerBundleItem(SellerBundle sb,String quantity, String discount) {
        pItems.clear();
        dataReadItems();
        dataReadID();
        
        Iterator<LineItem> iterator = sb.getItems();
        String bundleID = currentID.toString();
        currentID += 1;
        String currentName;
        double addCosts = 0;
        ArrayList<String> list = new ArrayList<>();
        
        list.add(bundleID);
        list.add("Bundle");
        list.add(discount);
        list.add(quantity);
        while(iterator.hasNext()) {
            currentName = iterator.next().getName();
            list.add(currentName);
            for(int i = 0; i < pItems.size(); i++ ) {
                if(currentName.equals(pItems.get(i)[1])) {
                    addCosts += Double.parseDouble(pItems.get(i)[4]);
                    break;
                }
            }
        } 
        String[] newBundle = new String[list.size()];
        for(int i = 0; i < list.size(); i++ ) {
            newBundle[i] = list.get(i); 
        }
        pItems.add(newBundle);
        
        addCosts = addCosts/2 * Integer.parseInt(quantity);
        Profit.getInstance().addCosts(addCosts);
        dataUpdateID(); 
        dataInventoryUpdate();
    }

    /**
     * Removes item from Inventory.txt.
     * @param item item to be removed
     */       
    public void dataSellerRemoveItem(LineItem item){
        pItems.clear();
        dataReadItems();

        for(int i = 0; i < pItems.size(); i++ )  {
            if (item.getID() == Integer.parseInt(pItems.get(i)[0])) {
                pItems.remove(pItems.get(i));
                break;
            }      
        }
        removeAdditionalBundles(item);
        dataInventoryUpdate();
    }  

    /**
     * Recursively removes bundles featuring a removed item from Inventory.txt.
     * @param item item to be removed
     */       
    public void removeAdditionalBundles(LineItem item) {
        for(int i = 0; i < pItems.size(); i++ )  {
            if ("Bundle".equals(pItems.get(i)[1]) && !"Bundle".equals(item.toString())) {
                for (int j = 4; j <= (pItems.get(i).length) - 1; j++) {
                    current = pItems.get(i)[j];
                    if (current.equals(item.getName())) {
                        pItems.remove(pItems.get(i));
                        removeAdditionalBundles(item);
                        break;
                    }
                }                
            }
        }
    }  
    
    /**
     * Updates Inventory.txt with data from ArrayList.
     */        
    public void dataInventoryUpdate(){
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("Inventory.txt"))) {
            for(int i = 0; i < pItems.size(); i++ )  {
                out = pItems.get(i);
                send = String.join(",",out);
                fw.write(send);
                if (i < pItems.size() - 1) { fw.newLine(); }
            }
            fw.close();
        } catch (IOException e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        }
    }  
    
    public DefaultListModel getDefaultListModel(){
        dataUpdatefromFile();
        return dlm;
    }
}
