package cop4331.application;

import cop4331.formatter.ProfitFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rabih
 */
public class ProfitTest {
    /**
     * Test of format method, of class Profit.
     */
    @Test
    public void testFormat() {
        System.out.println("format");
        ProfitFormatter formatter = new ProfitFormatter();
        String expResult = String.format("          JAVA Shopping App\n\n\nRevenue: $%.2f\nCosts: $%.2f\n\n\nProfit: $%.2f\n",Profit.getInstance().getRevenue(),Profit.getInstance().getCosts(),Profit.getInstance().getProfit());
        String result = Profit.getInstance().format(formatter);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRevenue method, of class Profit.
     */
    @Test
    public void testGetRevenue() {
        System.out.println("getRevenue");
        double expResult = 0.0;
        double result = Profit.getInstance().getRevenue();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getCosts method, of class Profit.
     */
    @Test
    public void testGetCosts() {
        System.out.println("getCosts");
        double expResult = Profit.getInstance().getCosts();
        double result = Profit.getInstance().getCosts();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getProfit method, of class Profit.
     */
    @Test
    public void testGetProfit() {
        System.out.println("getProfit");
        double expResult = Profit.getInstance().getRevenue() - Profit.getInstance().getCosts();
        double result = Profit.getInstance().getProfit();
        assertEquals(expResult, result, 0);
    }
    
}
