package Project;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice
{
   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<LineItem>();
      listeners = new ArrayList<ChangeListener>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item)
   {
        if (item.getStock() > 0) {
            items.add(item);
            item.setStock(item.getStock() - 1);
        }
        else {
            JOptionPane.showMessageDialog(null, item + " is out of stock.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        // Notify all observers of the change to the invoice
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);
        
   }
   
  /**
      Removes an item to the invoice.
      @param item the item to add
   */
   public void removeItem(LineItem item)
   {
        if(items.remove(item)) {
            item.setStock(item.getStock() + 1);
        }
//         Notify all observers of the change to the invoice
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener)
   {
      listeners.add(listener);
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext()
            {
               return current < items.size();
            }

            public LineItem next()
            {
               return items.get(current++);
            }

            public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
      String r = formatter.formatHeader();
      Iterator<LineItem>iter = getItems();
      while (iter.hasNext())
         r += formatter.formatLineItem(iter.next());
      return r + formatter.formatFooter();
   }

   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;
}
