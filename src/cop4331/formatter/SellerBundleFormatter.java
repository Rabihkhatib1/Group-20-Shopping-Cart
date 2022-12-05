package cop4331.formatter;

import cop4331.model.LineItem;

/**
 * A Seller bundle formatter that implements InvoiceFormatter.
 * @author Rabih
 */
public class SellerBundleFormatter implements InvoiceFormatter<LineItem>
{
    @Override
    public String formatHeader()
    {
       total = 0;
        return String.format("\n");
    }

    @Override
    public String formatLineItem(LineItem item)
    {
        total += item.getPrice();
        return (String.format("%s\n",item));
    }
   
    @Override
    public String formatFooter()
    {
        return "";
    }
   
    @Override
    public double getTotal() {return total;}

    private double total;
}
