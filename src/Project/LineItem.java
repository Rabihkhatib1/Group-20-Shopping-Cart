package Project;

/**
   A line item in an invoice.
*/
public interface LineItem
{
   /**
      Gets the price of this line item.
      @return the price
   */
   double getPrice();
   /**
      Gets the name of this line item.
      @return the description
   */   
   String toString();
   /**
      Gets the description of this line item.
      @return the description
   */   
   String getDescription();  
   /**
      Gets the stock of this line item.
      @return the description
   */   
   int getStock();  

   /**
      Sets the stock of this line item.
      @param stock
      @return the description
   */      
   int setStock(int stock);
   
   /**
      Gets the full info of this line item.
      @return the description
   */         
   String getInfo();
}
