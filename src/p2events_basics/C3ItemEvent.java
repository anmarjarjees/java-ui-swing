package p2events_basics;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
// for the radio buttons
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
// for grouping the radio buttons
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

/* 
 * JRadioButton, JCheckBox, and JComboBox components
 * maintain states can be recognized by "ItemListener" interface
 * so we need to implement this interface "ItemListener"
 * after importing it:
 */
import java.awt.event.ItemListener;

/* 
 * For every "ItemListener" interface,
 * we need to import "ItemEvent" class 
 * to be the data type of the event object
 */
import java.awt.event.ItemEvent;

public class C3ItemEvent extends JFrame implements ItemListener {
    // Just declaring all the components to be used in the JFrame
    JPanel pnl = new JPanel();

    // Creating the instance varaibles (can be initialed with values also):
    String[] oopConcepts = { "Abstraction", "Polymorphism", "Interface", "Encapsulation" };
    JComboBox<String> box = new JComboBox<>(oopConcepts);
    JRadioButton rdo1 = new JRadioButton("Green Theme", true);
    JRadioButton rdo2 = new JRadioButton("Blue Theme");
    // ButtonGroup class for grouping the related radio buttons
    // (rdo1 and rdo2) together:
    ButtonGroup colors = new ButtonGroup();

    JCheckBox chk = new JCheckBox("Subscribe to our e-newsletter");
    /*
     * Method Overloading (Dynamic Type of Polymorphism):
     * Different forms to run this method including:
     * > JTextArea()
     * > JTextArea(String text)
     * > JTextArea(int rows, int columns)
     * > JTextArea(String text, int rows, int columns)
     */
    JTextArea txtArea = new JTextArea("Green Radio is selected", 5, 30);

    public C3ItemEvent() {
        super("Swing GUI with Event Quick Demo3");
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);

        // No need to assign/set any value to the JComponents
        // Just group the two related JRadioButton components:
        colors.add(rdo1);
        colors.add(rdo2);

        // Adding the components to the panel:
        pnl.add(box);
        pnl.add(rdo1);
        pnl.add(rdo2);
        pnl.add(chk);
        pnl.add(txtArea);
        /*
         * Adding the Events:
         * *****************
         */

        // Events Step#1: Adding the specific event => addItemListener()
        // Adding "Item Listener" to each item:
        // passing "this" as a parameter
        rdo1.addItemListener(this);
        rdo2.addItemListener(this);
        chk.addItemListener(this);
        box.addItemListener(this);
    } // end Constructor

    /*
     * This is the method that were added with quick fix
     * is used with the events
     * it's called the "Event Handler" method
     */
    // Events Step#2:
    // Adding the specific "Event Handler" method => itemStateChanged()
    @Override
    public void itemStateChanged(ItemEvent e) {
        // testing:
        // To return the object on which the Event initially occurred:
        System.out.println("Source: " + e.getSource());

        // To return the item affected by the event (Similar ):
        System.out.println("Item: " + e.getItem());

        // To return the item affected by the event.:
        System.out.println(".getStateChange():" + e.getStateChange());

        // To return the item affected by the event.:
        System.out.println(".getItemSelectable():" + e.getItemSelectable());

        /*
         * ItemEven object has these two methods:
         * > .getItemSelectable() => to identify the originated component
         * > .getStateChange() => to return its status
         * to check if it's selected or not by comparing it
         * to "ItemEvent.SELECTED" constant
         * 
         * Both options will reset the text area and place one of the following message
         */
        // Part#1: Radio Buttons
        if (e.getItemSelectable() == rdo1) {
            txtArea.setText("Green Radio is Selected\n");
        } else if (e.getItemSelectable() == rdo2) {
            txtArea.setText("Blue Radio is Selected\n");
        }

        // Part#2: Checkboxes => indicating the status of the checkbox
        /*
         * Unlike radio button, with checkbox we need to add another condition
         * to validate that the checkbox has checked by using .getStateChange()
         * otherwise, if we only use .getItemSelectable()
         * its if block will always be executed whenever we click the checkbox
         * even if we deselect it!
         */
        if ((e.getItemSelectable() == chk) && (e.getStateChange() == ItemEvent.SELECTED)) {
            /*
             * In add/append more text to previous ones in the same text area,
             * use .append() method for JTextArea object:
             */
            txtArea.append("\nThank you for subscribing\n");
        }

        // Part#3: JComboBox Component
        /*
         * Like Checkboxes, with JComboBox we also need to add another condition
         * by using .getStateChange().
         * JComboBox fires two ItemEvents when an item gets selected:
         * - for selecting the item
         * - for deselecting the previously selected item
         * otherwise, if we only use .getItemSelectable()
         * you will the current selected item plus the pervious one
         */
        if ((e.getItemSelectable() == box) && (e.getStateChange() == ItemEvent.SELECTED)) {
            txtArea.append(e.getItem() + " option is selected\n");
            // we can use: e.getItem().toString(),
            // but no need as it works without .toString()
        }
    } // end "Event Handler" method: itemStateChanged()

    public static void main(String[] args) {
        new C3ItemEvent();
    }
}
