package Project;

/**
   This interface describes the tasks that an invoice
   formatter needs to carry out.
 * @param <T>
*/
public interface InvoiceFormatter<T>
{
   /**
      Formats the header of the invoice.
      @return the invoice header
   */
   String formatHeader();

   /**
      Formats a line item of the invoice.
      @param item
      @return the formatted line item
   */
   String formatLineItem(T item);
   
   /**
      Formats the footer of the invoice.
      @return the invoice footer
   */
   String formatFooter();
   
    /**
      Get the total revenue
      @return the invoice footer
    */
    double getTotal();
}
