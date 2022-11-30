package Project;

/**
   A decorator for an item that applies a discount.
*/
public class DiscountedItem implements LineItem
{
   /**
      Constructs a discounted item.
      @param item the item to be discounted
      @param discount the discount percentage
     
   */
   public DiscountedItem(LineItem item, double discount) 
   { 
      this.item = item; 
      this.discount = discount;
      this.stock = item.getStock();
   }

   @Override
   public double getPrice() 
   {
      return item.getPrice() * (1 - discount / 100); 
   }

   @Override
   public String toString()
   {
      return item.toString() + " (Discount " + discount
         + "%)";
   } 

   @Override
   public String getDescription()
   {
      return item.getDescription();
   } 
   
    @Override
    public int getStock() { return stock; }
    
    @Override
    public int setStock(int stock) { return this.stock = stock; }
   
    @Override
    public String getInfo() { return (String.format(
            "Name: %s\nDescription: %s\nPrice: $%.2f\nStock: %d\nDiscount: %.2f%%\n",item.toString(), getDescription(), getPrice(), getStock(), discount)); }
   
   private final LineItem item;
   private final double discount;
   private int stock;
}
