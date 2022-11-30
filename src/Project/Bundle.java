package Project;

import java.util.*;

/**
   A bundle of line items that is again a line item.
*/
public class Bundle implements LineItem
{
   /**
      Constructs a bundle with no items.
     * @param stock
   */
    public Bundle(int stock) {       
        items = new ArrayList<>(); 
        this.stock = stock;
    }

   /**
      Adds an item to the bundle.
      @param item the item to add
   */
    public void add(LineItem item) { items.add(item); }

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
      for (int i = 0; i < items.size(); i++)
      {
         if (i > 0) name += ", ";
         name += items.get(i).toString();
      }
      return name;
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
      for (int i = 0; i < items.size(); i++)
      {
         if (i > 0) info += ", ";
         info += items.get(i).toString();
      }
      info += ".\n";
      info += String.format("Price: $%.2f\nStock: %d\n",getPrice(),getStock());
      return info;        
    }  
    
   private final ArrayList<LineItem> items;
   private int stock;
}
