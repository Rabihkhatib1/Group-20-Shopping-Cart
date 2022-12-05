package cop4331.application;

import cop4331.gui.CardView;

import cop4331.formatter.ProfitFormatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton class that handles profit initialization and management.
 * @author Rabih
 */
public class Profit {
    private double revenue;
    private double costs;
    static private Profit instance = null;

    /**
     * Private constructor.
     */    
    private Profit() { }
    
    /**
     * Get the only instance of the object.
     * @return instance
     */
    public static Profit getInstance() {
    	if (instance == null) {
            instance = new Profit();
    	}
    	return instance;
    }

    /**
     * Initializes Profit.txt with preliminary revenue, cost, 
     * and profit data if the file does not exist.
     * @param initCosts
     */  
    public void dataProfitInit(double initCosts){
        try {
            File f = new File("Profit.txt");
            this.costs = initCosts;
            if(!f.createNewFile()){} else {
                try (BufferedWriter fw = new BufferedWriter(new FileWriter("Profit.txt"))) {
                    fw.write(String.format("0,%f,%f",costs, 0 - costs));
                    fw.close();
                } catch (IOException e) {
                Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, e);
        }   
    }   

    /**
     * Reads revenue and cost data from Profit.txt.
     */ 
    public void extractRevenueCost() {
        try {  
            String line;
            String splitBy = ",";
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("Profit.txt"));  
            while ((line = br.readLine()) != null) {   //returns a Boolean value   
                String[] string = line.split(splitBy);    // use comma as separator  
                this.revenue = Double.parseDouble(string[0]);
                this.costs = Double.parseDouble(string[1]);
            }  
            br.close();
        } catch (IOException e) {  
            Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, e);
        }           
    }

    /**
     * Adds revenue to Profit.txt after customer makes a purchase.
     * @param cardview customer's card data
     */     
    public void addRevenue(CardView cardview) {
        extractRevenueCost();
        this.revenue += cardview.getFormatter().getTotal();
        updateProfitData();
        
    }

    /**
     * Adds costs to Profit.txt after seller adds new items or bundles.
     * @param addCosts costs of new item or bundle.
     */     
    public void addCosts(double addCosts) {
        extractRevenueCost();
        this.costs += addCosts;
        updateProfitData();
        
    }

    /**
     * Updates Profit.txt with any changes made.
     */      
    public void updateProfitData() {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("Profit.txt"))) {
            fw.write(String.format("%f,%f,%f",this.revenue, this.costs, this.revenue - this.costs));
            fw.close();
        } catch (IOException e) {
            Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, e);
        }
    }    

    
    public String format(ProfitFormatter formatter) {
        String r = formatter.formatHeader();
        r += formatter.formatLineItem(new Profit());
        return r + formatter.formatFooter();
    }
    
    public double getRevenue() {extractRevenueCost(); return revenue;}
    public double getCosts() {extractRevenueCost(); return costs;}
    public double setCosts() {extractRevenueCost(); return costs;}
    public double getProfit() {extractRevenueCost(); return this.revenue - this.costs;}  
}
