package cop4331.model;

/**
 * A product with a price, quantity and description.
 */
public class Product implements LineItem {
    /**
     * Constructs a product.
     * @param id the id of the item
     * @param name the name
     * @param description the description
     * @param price the price
     * @param stock the stock
     */
    public Product(int id, String  name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
 
    @Override
    public int getID() { return id; }
    
    @Override
    public double getPrice() { return price; }
    
    public double setPrice(double price) { return this.price = price;  }
    
    @Override
    public String toString() { return name; }
    
   @Override
   public String getName() { return name; } 
   
    @Override
    public String getDescription() { return description; }
   
    @Override
    public int getStock() { return stock; }
    
    @Override
    public int setStock(int stock) { return this.stock = stock; }

    @Override
    public String getInfo() { return (String.format(
            "Name: %s\nDescription: %s\nPrice: $%.2f\nQuantity: %d\n",name, description, price, stock)); }

    @Override
    public String getSellerInfo() { return (String.format(
            "ID: %d\nName: %s\nDescription: %s\nInvoice Price: $%.2f\nSell Price: $%.2f\nQuantity: %d\n",id,name, description, price/2, price, stock)); }
   
    private final int id;
    private final String name;
    private final String description;
    private double price;
    public int stock;
}
