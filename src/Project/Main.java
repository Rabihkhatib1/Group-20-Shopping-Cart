package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Rabih
 */
public class Main {
//    Bundle bundle = new Bundle(0);
//    DefaultListModel dlm = new DefaultListModel();
//    private ArrayList<String[]> pItems = new ArrayList<>();
//    ArrayList<String> pNames = new ArrayList(); 
//    String line;  
//    String splitBy = ","; 
//    String current;
//    Product product;
//    DiscountedItem discount;
//    double p,d;
//    Integer s, index;
//    
//    
//    public void dataInventoryInit(){
//        try {
//            File f = new File("Inventory.csv");
//            if(!f.createNewFile()){} else {
//                try (BufferedWriter fw = new BufferedWriter(new FileWriter("Inventory.csv"))) {
//                    fw.write("Strawberry Ice Cream,Delicious strawberry flavored ice cream.,1.99,5,0");
//                    fw.newLine();
//                    fw.write("Hammer,Hammer to smash things.,19.95,5,0");
//                    fw.newLine();
//                    fw.write("Television,30 inch widescreen TV.,159.95,5,0");
//                    fw.newLine();
//                    fw.write("Assorted Nails,20 Assorted Nails ideal for construction.,9.95,10,0");
//                    fw.newLine();
//                    fw.write("Milk,3.78L far free milk.,5.99,10,0");
//                    fw.newLine();
//                    fw.write("Water Bottle,reusable water bottle for children.,19.95,5,20");
//                    fw.newLine();
//                    fw.write("Bundle,5,10,Hammer,Assorted Nails,Water Bottle");
//                    fw.close();
//                } catch (IOException e) {
//                e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }            
//        
//        dataUpdatefromFile();
//    }
//    
//    public void dataReadItems(){
//        try {  
//            //parsing a CSV file into BufferedReader class constructor  
//            BufferedReader br = new BufferedReader(new FileReader("Inventory.csv"));  
//            while ((line = br.readLine()) != null) {   //returns a Boolean value   
//                String[] string = line.split(splitBy);    // use comma as separator  
//                pItems.add(string);
//                pNames.add(string[0]);
//            }  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }           
//    }
//    
//    public void dataUpdatefromFile(){
//        dataReadItems();
// 
//        for(int i = 0; i < pItems.size(); i++ ) {
//            // Searching for and updating bundles
//            if ("Bundle".equals(pNames.get(i))) {
//                d = Double.parseDouble(pItems.get(i)[2]);    
//                for (int j = 3; j <= (pItems.get(i).length) - 1; j++) {
//                    current = pItems.get(i)[j];
//                    index = pNames.indexOf(current);
//                    p = Double.parseDouble(pItems.get(index)[2]);
//                    s = Integer.parseInt(pItems.get(index)[3]);
//                    product = new Product(pItems.get(index)[0],pItems.get(index)[1],p,s);
//                    bundle.add(product);
//                }
//                s = Integer.parseInt(pItems.get(i)[1]);
//                bundle.setStock(s);
//
//                d = Double.parseDouble(pItems.get(i)[2]);
//                dlm.addElement(new DiscountedItem(bundle,d));
//                
//            }     
//            
//            else {
//                p = Double.parseDouble(pItems.get(i)[2]);
//                s = Integer.parseInt(pItems.get(i)[3]);
//                product = new Product(pItems.get(i)[0],pItems.get(i)[1],p,s);
//                if ("0".equals(pItems.get(i)[4])) {
//                    dlm.addElement(product);
//                }
//                else {
//                    d = Double.parseDouble(pItems.get(i)[4]);
//                    dlm.addElement(new DiscountedItem(product,d));
//                }                
//            }         
//        }
//    }
    
    public static void main(String[] args) {
//        Main main = new Main();
        Data data = new Data();
        data.dataInventoryInit();
        data.dataProfitInit();
        ShopController shop = new ShopController(data.dlm);
        shop.initController();
   }
}
