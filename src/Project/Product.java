package Project;

/**
   A product with a price and description.
*/
public class Product implements LineItem {
   /**
      Constructs a product.
      @param name the name
      @param description the description
      @param price the price
      @param stock the stock
   */
   public Product(String  name, String description, double price, int stock) {
      this.name = name;
      this.description = description;
      this.price = price;
      this.stock = stock;
    }
    @Override
    public double getPrice() { return price; }
    
    public double setPrice(double price) { return this.price = price;  }
    
    @Override
    public String toString() { return name; }
   
    @Override
    public String getDescription() { return description; }
   
    @Override
    public int getStock() { return stock; }
    
    @Override
    public int setStock(int stock) { return this.stock = stock; }

    @Override
    public String getInfo() { return (String.format(
            "Name: %s\nDescription: %s\nPrice: $%.2f\nStock: %d\n",name, description, price, stock)); }
   
    private final String name;
    private final String description;
    private double price;
    public int stock;
}
