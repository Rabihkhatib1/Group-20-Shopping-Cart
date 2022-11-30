package Project;

/**
   A simple invoice formatter.
 * @param <LineItem>
*/
public class SimpleFormatter implements InvoiceFormatter<LineItem>
{
   @Override
   public String formatHeader()
   {
      total = 0;
      return "     I N V O I C E\n\n\n";
   }

   @Override
   public String formatLineItem(LineItem item)
   {
      total += item.getPrice();
      return (String.format(
            "%s: $%.2f\n",item,item.getPrice()));
   }
   
   @Override
   public String formatFooter()
   {
      return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
   }
   
   @Override
   public double getTotal() {return total;}

   private double total;
}
