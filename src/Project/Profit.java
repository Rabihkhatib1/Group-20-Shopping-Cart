package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rabih
 */
public class Profit {
    private double revenue;
    private double costs;

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
        } catch (IOException e) {  
            e.printStackTrace();  
        }           
    }
    
    public void addRevenue(CardView cardview) {
        extractRevenueCost();
        this.revenue += cardview.getFormatter().getTotal();
        updateProfitData();
        
    }
    
    public void updateProfitData() {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("Profit.txt"))) {
            fw.write(String.format("%f,%f,%f",this.revenue, this.costs, this.revenue - this.costs));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String format(ProfitFormatter formatter) {
        String r = formatter.formatHeader();
        r += formatter.formatLineItem(new Profit());
        return r + formatter.formatFooter();
    }
    
    public double getRevenue() {extractRevenueCost(); return revenue;}
    public double getCosts() {extractRevenueCost(); return costs;}
    public double getProfit() {extractRevenueCost(); return this.revenue - this.costs;}  
}
