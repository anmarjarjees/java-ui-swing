package p2events_basics;

// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/* 
 * JOptionPane class is designed to create a standard dialog box centered on its parent window
 * 
 * NOTE: in order for our class to implement the ActionListener for any keyboard/mouse event
 * our class needs to implement the interface "ActionListener"
 * Link: https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
 * 
 * And we need to import it:
 * 
 * - "ActionListener" interface has 1 Event-handler method:
 * > actionPerformed(MouseEvent e)
 * 
 *  we need to implement the interface "ActionListener"
*/
import java.awt.event.ActionListener;
/* 
 * For every "ActionListener" interface,
 * we need to import "ActionEvent" class 
 * to be the data type of the event object
 * to be passed to the Event-handler method
 */
import java.awt.event.ActionEvent;

// Using the VS code Quick Fix or any tools based on your IDE to implement all the methods
/* 
 * We must declare all the associated Event-handler methods for both interfaces,
 * even if not all are actually used
 * But with ActionListener, we only have one method actionPerformed()
 */
public class C1MessageDialog extends JFrame implements ActionListener {
    // Just declaring all the components to be used in the JFrame:
    // Create JPanel container object:
    JPanel pnl = new JPanel();

    // Creating 4 buttons for each Message type:
    /*
     * > btnE for ERROR MESSAGE
     * > btnI for INFORMATION MESSAGE
     * > btnW for For WARNING MESSAGE
     * > btnQ for QUESTION MESSAGE
     */
    private JButton btnE = new JButton("ERROR MESSAGE");
    private JButton btnI = new JButton("INFORMATION MESSAGE");
    private JButton btnW = new JButton("WARNING MESSAGE");
    private JButton btnQ = new JButton("QUESTION MESSAGE");

    // Class Constructor:
    public C1MessageDialog() {
        super("Swing with Message Dialog");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(btnE);
        pnl.add(btnI);
        pnl.add(btnQ);
        pnl.add(btnW);

        /*
         * Adding the Events:
         * *****************
         */
        /*
         * Events Step#1: Adding the the specific event(s) for ActionListener interface:
         * We only have one:
         * - addListener()
         * 
         * Adding "addActionListener()" to the component(s):
         * passing "this" as a parameter
         */
        btnE.addActionListener(this);
        btnI.addActionListener(this);
        btnQ.addActionListener(this);
        btnW.addActionListener(this);
    } // end constructor

    /*
     * Event Step#2: Is already implemented through using The Quick Fix
     * Adding the event-handler method(s) for the "ActionListener" interface
     * 
     * The "ActionListener" Interface has only one Event-handler method:
     * the method is: actionPerformed()
     * 
     * If the interface has multiple we have to implement them all
     * even if we don't use them all
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * HINT: Refer to my class file p1gui_basics.C01Basic.java
         * 
         * 4. messageType: int value to determine the icon displayed in the dialog.
         * Choose from one of the following numeric values or the JOptionPane CONSTANTS:
         * PLAIN_MESSAGE (no icon)
         * 0 OR JOptionPane.ERROR_MESSAGE => For ERROR_MESSAGE Icon
         * 1 OR JOptionPane.INFORMATION_MESSAGE => For INFORMATION_MESSAGE Icon
         * 2 OR JOptionPane.WARNING_MESSAGE => For WARNING_MESSAGE Icon
         * 3 OR JOptionPane.QUESTION_MESSAGE => For QUESTION_MESSAGE Icon
         */
        if (e.getSource() == btnE) {
            // JOptionPane.showMessageDialog(null or this,Message, Title, CONSTANT);
            /*
             * null => will display the dialog box in the center/middle
             * based your screen (monitor)
             * 
             * this => will display the dialog box in the center/middle
             * based the JFrame window (more commonly used)
             * 
             * We tried both options below :-)
             */
            JOptionPane.showMessageDialog(this, "ERROR Dialog Box Message", "ERROR Dialog Box",
                    JOptionPane.ERROR_MESSAGE);
        } else if (e.getSource() == btnI) {
            JOptionPane.showMessageDialog(null, "INFO Dialog Box Message", "INFO Dialog Box",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnQ) {
            JOptionPane.showMessageDialog(this, "QUESTION Dialog Box Message", "QUESTION Dialog Box",
                    JOptionPane.QUESTION_MESSAGE);
        } else if (e.getSource() == btnW) {
            JOptionPane.showMessageDialog(null, "WARNING Dialog Box Message", "WARNING Dialog Box",
                    JOptionPane.WARNING_MESSAGE);
        }
    } // end "Event Handler" method: actionPerformed()

    // Adding the main() method as the entry point for our application:
    public static void main(String[] args) {
        new C1MessageDialog();
    } // end main()

} // end class file
