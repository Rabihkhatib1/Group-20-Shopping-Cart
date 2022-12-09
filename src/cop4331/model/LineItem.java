package cop4331.model;

/**
 * A line item in an invoice.
 * @author modified by Rabih
 */
public interface LineItem
{
    /**
     * Gets the id of this line item.
     * @return the price
     */
    int getID();
    
    /**
     * Gets the price of this line item.
     * @return the price
     */
    double getPrice();
    
    /**
     * Gets the name of this line item.
     * @return the description
     */   
    @Override
    String toString();
    
    /**
     * Gets the name of this line item without any additions.
     * @return the description
     */   
   String getName();
   
    /**
     * Gets the description of this line item.
     * @return the description
     */   
   String getDescription();  
   
    /**
     * Gets the stock of this line item.
     * @return the description
     */   
    int getStock();  

    /**
     * Sets the stock of this line item.
     * @param stock
     * @return the description
     */      
    int setStock(int stock);
   
    /**
     * Gets the full info of this line item.
     * @return the description
     */         
    String getInfo();
    
    /**
     * Gets the full seller info of this line item.
     * @return the description
     */         
    String getSellerInfo();    
}
