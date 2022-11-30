package Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author Rabih
 */
public class ProfitView {
    private final JFrame frame;
    private final JTextArea profitText;
    private final ProfitFormatter formatter;

    public ProfitView(Profit profit) {
        // set up components
        formatter = new ProfitFormatter();
        profitText = new JTextArea(10, 18);
        profitText.setText(profit.format(formatter));
        profitText.setEditable(false);

        frame = new JFrame("Profit Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(210, 400));
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(profitText),BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
 
    public JFrame getFrame() {
        return frame;
    }
}

