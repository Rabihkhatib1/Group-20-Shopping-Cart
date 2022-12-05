package cop4331.model;

/**
 * A decorator for an item that applies a discount.
 */
public class DiscountedItem implements LineItem
{
    /**
     * Constructs a discounted item.
     * @param item the item to be discounted
     * @param discount the discount percentage
     *
     */
    public DiscountedItem(LineItem item, double discount)  { 
        this.item = item; 
        this.id = item.getID();
        this.discount = discount;
        this.stock = item.getStock();
    }

    @Override
    public int getID() { return item.getID(); }
    
    public int setID(int id) { return this.id = id; }
    
    @Override
    public double getPrice() {
        return item.getPrice() * (1 - discount / 100); 
    }

    @Override
    public String toString() {
        return item.toString() + " (Discount " + discount + "%)";
    }
   
    @Override
    public String getName() {
        return item.toString();
    } 

    @Override
    public String getDescription() {
        return item.getDescription();
    } 
   
    @Override
    public int getStock() { return stock; }
    
    @Override
    public int setStock(int stock) { return this.stock = stock; }
   
    @Override
    public String getInfo() { return (String.format(
            "Name: %s\nDescription: %s\nPrice: $%.2f\nQuantity: %d\nDiscount: %.2f%%\n",item.toString(), getDescription(), getPrice(), getStock(), discount)); }

    @Override
    public String getSellerInfo() { return (String.format(
            "ID: %d\nName: %s\nDescription: %s\nInvoice Price: $%.2f\nSell Price: $%.2f\nQuantity: %d\nDiscount: %.2f%%\n",id,item.toString(), getDescription(), item.getPrice()/2, getPrice(), getStock(), discount)); }
    
    private final LineItem item;
    private final double discount;
    private int id;
    private int stock;
}
