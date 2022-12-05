package cop4331.formatter;

import cop4331.application.Profit;

/**
 * A profit formatter that implements InvoiceFormatter.
 * @author Rabih
 */
public class ProfitFormatter implements InvoiceFormatter<Profit>
{
    @Override
    public String formatHeader()
    {
      return "          JAVA Shopping App\n\n\n";
    }

    @Override
    public String formatLineItem(Profit profit)
    {
        profitValue = profit.getProfit();
        return (String.format(
            "Revenue: $%.2f\nCosts: $%.2f\n",profit.getRevenue(),profit.getCosts()));
        
    }
   
    @Override
    public String formatFooter()
    {
        return (String.format("\n\nProfit: $%.2f\n", profitValue));
    }
   
    @Override
    public double getTotal() {return profitValue;}
    
    private double profitValue = 0;
}
