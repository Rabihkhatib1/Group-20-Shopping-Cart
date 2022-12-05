package cop4331.model;

import cop4331.formatter.SellerBundleFormatter;

import java.util.*;

import javax.swing.event.*;

/**
 * An item bundle consisting of line items.
 */
public class SellerBundle {
    /**
     * Constructs a blank item bundle.
     */
    public SellerBundle() {
        items = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    /**
     *  Adds a new item to the bundle.
     *  @param item the item to add
     */
    public void addItem(LineItem item) {
        items.add(item);

        // Notify all observers of the change to the invoice
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);        
    }

    /**
     * Adds a change listener to the item bundle.
     * @param listener the change listener to add
     */
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Gets an iterator that iterates through the items.
     * @return an iterator for the items
     */
    public Iterator<LineItem> getItems() {
        return new
         Iterator<LineItem>() {
            @Override
            public boolean hasNext() {
               return current < items.size();
            }

            @Override
            public LineItem next() {
               return items.get(current++);
            }

            @Override
            public void remove() {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
        };
    }

    /**
     * Formats item bundle string.
     * @param formatter
     * @return formatted item bundle string 
     */       
    public String format(SellerBundleFormatter formatter)
    {
        String r = formatter.formatHeader();
        Iterator<LineItem>iter = getItems();
        while (iter.hasNext())
            r += formatter.formatLineItem(iter.next());
        return r + formatter.formatFooter();
    }

   private final ArrayList<LineItem> items;
   private final ArrayList<ChangeListener> listeners;
}
