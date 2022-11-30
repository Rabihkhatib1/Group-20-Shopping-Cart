package Project;

/**
   A simple invoice formatter.
*/
public class ProfitFormatter implements InvoiceFormatter<Profit>
{
    @Override
    public String formatHeader()
    {
      return "\t\t\tJAVA Shopping App\n\n\n";
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
