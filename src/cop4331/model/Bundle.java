package cop4331.model;

import java.util.*;

/**
 * A bundle of line items that is again a line item.
 */
public class Bundle implements LineItem {
   /**
    * Constructs a bundle with no items.
    * @param id
    * @param stock
    */
    public Bundle(int id, int stock) {       
        this.items = new ArrayList<>(); 
        this.id = id;
        this.stock = stock;
        
    }

   /**
    * Adds an item to the bundle.
    * @param item the item to add
    */
    public void add(LineItem item) { items.add(item); }
    
    @Override
    public int getID() { return id; }
    
    public int setID(int id) { return this.id = id; }
    
    @Override
    public double getPrice()
    {
        double price = 0;

        for (LineItem item : items)
            price += item.getPrice();
        return price;
    }

   @Override
   public String toString()
   {
        String name = "Bundle of ";
        for (int i = 0; i < items.size(); i++) {
            if (i > 0) name += ", ";
            name += items.get(i).toString();
        }
        return name;
   }
   
   @Override
   public String getName() {
        return "Bundle";
   } 

    @Override
    public String getDescription() {
        String description = "Bundle";
        return description;        
    }
    
    @Override
    public int getStock() {
        return stock;
    }
    
    @Override
    public int setStock(int stock) { return this.stock = stock; }
   
    @Override
    public String getInfo() {
        String info = "Bundle of ";
        for (int i = 0; i < items.size(); i++) {
            if (i > 0) info += ", ";
            info += items.get(i).toString();
        }
        info += ".\n";
        info += String.format("Price: $%.2f\nQuantity: %d\n",getPrice(),getStock());
        return info;        
    }  
    
    @Override
    public String getSellerInfo() {
        String info = "Bundle of ";
        for (int i = 0; i < items.size(); i++)
        {
            if (i > 0) info += ", ";
            info += items.get(i).toString();
        }
        info += ".\n";
        info += String.format("Price: $%.2f\nQuantity: %d\n",getPrice(),getStock());
        return info;        
    }  
    
    private final ArrayList<LineItem> items;
    private int id;
    private int stock;
}
