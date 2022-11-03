package p2events_basics;

// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/* 
 * JOptionPane class is designed to create a standard dialog box centered on its parent window
 * 
 * And we need to import it:
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

public class C4InputDialog extends JFrame implements ActionListener {
    // Just declaring all the components to be used in the JFrame:
    // Create JPanel container object:
    JPanel pnl1 = new JPanel(); // for the first text field
    JPanel pnl2 = new JPanel(); // for the second text field
    JPanel pnl3 = new JPanel(); // for the two buttons
    JPanel mainPnl = new JPanel(); // the main panel to contain all the panels

    JTextField txtField1 = new JTextField(40);
    JTextField txtField2 = new JTextField(20);
    private JButton btn1 = new JButton("Requesting an action");
    private JButton btn2 = new JButton("Requesting a comment");

    // Class Constructor:
    public C4InputDialog() {
        super("Swing with Message Dialog");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPnl);

        pnl1.add(txtField1);
        pnl2.add(txtField2);
        pnl3.add(btn1);
        pnl3.add(btn2);

        mainPnl.add(pnl1);
        mainPnl.add(pnl2);
        mainPnl.add(pnl3);

        /*
         * Adding the Events:
         * *****************
         */
        /*
         * Event Step#1: Adding the the specific event(s) for ActionListener interface:
         * We only have one:
         * - addListener()
         * 
         * Adding "addActionListener()" to the component(s):
         * passing "this" as a parameter
         */
        txtField1.addActionListener(this);
        txtField2.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
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
        // Step1 Validate that there is an input:
        if (isValidInput(txtField1.getText())) {
            // instead of using if/else again:
            if (e.getSource() == btn1) {
            } else if (e.getSource() == btn2) {
            }
            // let's review the switch statement:
            /*
             * NOTE:
             * We cannot use switch with objects
             * Only convertible int values, strings or enum variables are permitted
             * 
             * So we need to use .toSrting() method
             */
            // testing:
            System.out.println("Boolean Value:" + e.getSource().equals(btn1));
            // Using Ternary Operator
            // Link: https://www.w3schools.com/java/java_conditions_shorthand.asp
            int btnOption = (e.getSource().equals(btn1)) ? 1 : 2;
            switch (btnOption) {
                // https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
                case 1:
                    /*
                     * Show an information panel with the options yes/no and message 'choose one':
                     * JOptionPane.showConfirmDialog
                     * optionType an int designating the options available on the dialog:
                     * > YES_NO_OPTION
                     * > YES_NO_CANCEL_OPTION
                     * > OK_CANCEL_OPTION
                     * 
                     * Examples:
                     * (null, MESSAGE, TITLE, JOptionPane.YES_NO_OPTION);
                     * (null, MESSAGE, TITLE, JOptionPane.YES_NO_CANCEL_OPTION);
                     * (null, MESSAGE, TITLE, JOptionPane.OK_CANCEL_OPTION);
                     * 
                     * Returns => an int indicating the option selected by the user
                     * Each option has its own number"
                     * Yes => 0
                     * No => 1
                     * Cancel => 2
                     * 
                     * In the example below: YES_NO_CANCEL_OPTION
                     * 0 => Yes
                     * 1 => No
                     * 2 => Cancel
                     */
                    int option = JOptionPane.showConfirmDialog(null,
                            "choose one", "choose one", JOptionPane.YES_NO_CANCEL_OPTION);
                    // testing:
                    System.out.println("showConfirmDialog() returned option value:" + option);
                    String response = switch (option) {
                        case 0 -> "Agreed";
                        case 1 -> "Disagreed";
                        // case 2 -> "Canceled";
                        default -> "Canceled";
                    }; // end switch => NOTE: We have to add ; for this type of Switch

                    txtField2.setText(response);
                    break;

                case 2:
                    /*
                     * showInputDialog(Component parentComponent, Object message, String title, int
                     * messageType)
                     * messageType: int value to determine the icon displayed in the dialog.
                     * Choose from one of the following numeric values or the JOptionPane CONSTANTS:
                     * PLAIN_MESSAGE (no icon)
                     * 0 OR JOptionPane.ERROR_MESSAGE => For ERROR_MESSAGE Icon
                     * 1 OR JOptionPane.INFORMATION_MESSAGE => For INFORMATION_MESSAGE Icon
                     * 2 OR JOptionPane.WARNING_MESSAGE => For WARNING_MESSAGE Icon
                     * 3 OR JOptionPane.QUESTION_MESSAGE => For QUESTION_MESSAGE Icon
                     * 
                     * Returns: user's input
                     */
                    String userInput = JOptionPane.showInputDialog(this, "Enter your opinion", "showInputDialog() box",
                            3);
                    txtField2.setText(userInput);
                    break;
            } // end main switch
        } else {
            JOptionPane.showMessageDialog(this,
                    "Text Field Cannot Be Empty!",
                    "showMessageDialog() static method", 0);
        } // end main else for valid text input

    } // end "Event Handler" method: actionPerformed()

    // Adding our custom method:
    public boolean isValidInput(String input) {
        // Check if there is any input or not:
        if (input.isBlank() || input.isEmpty()) {
            return false;
        }
        // No need for else block as return statement will terminate the method
        return true;
    } // end validateInput()

    // Adding the main() method as the entry point for our application:
    public static void main(String[] args) {
        new C4InputDialog();
    } // end main()

} // end class file
