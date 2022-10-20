package user_interface_basics;

import javax.swing.*;

public class C06JComponents {
    public static void main(String[] args) {
        // We can add title
        JFrame frame = new JFrame("Working with javax.swing package");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Creating all the components
        JButton btn1 = new JButton("Click Me");
        JButton btn2 = new JButton("Calculate Average");

        JButton btn3 = new JButton("Another Button");
        JButton btn4 = new JButton("One more Button");

        /*
         * Adding text fields
         * The Swing JTextField class creates a single-line text field components
         * for adding an editable textfield to enter a text
         * JTextField constructor can take:
         * - a number to represent how many columns
         * - a String argument specifying default text to be displayed.
         * 
         * Java will resize the text field to fit its content (the default text)
         * if not content, text filed will be very small!
         * Try it without argument
         */
        JTextField txt1 = new JTextField(5);

        JTextField txt2 = new JTextField("Enter your value");

        // Or both: text and columns
        JTextField txt3 = new JTextField("Enter your fullname", 15);

        /*
         * Adding multiple-line text field
         * Using JTextArea class
         * passing two values to its constructor: rows, columns
         */
        JTextArea txtArea = new JTextArea(5, 30);

        /*
         * Adding label
         * The Swing JLabel class creates a label component
         */
        JLabel lbl = new JLabel("Learning about Swing Components");

        /*
         * Adding Item Selectors:
         * The Swing JCheckbox class creates a checkbox components
         * new JCheckbox(arg1, arg2)
         * arg1 => the text to be displayed
         * arg2 => boolean value to make the checkbox selected by default
         * it it's set to true
         */
        JCheckBox chk1 = new JCheckBox("C#"); // if no added text => just a checkbox!
        JCheckBox chk2 = new JCheckBox("Java", true);
        JCheckBox chk3 = new JCheckBox("Python");
        JCheckBox chk4 = new JCheckBox("PHP");

        /*
         * Radio Buttons
         * The Swing JRadioButton class creates a radio button component
         */
        JRadioButton rdo1 = new JRadioButton("Blue", true);
        JRadioButton rdo2 = new JRadioButton("Red");
        JRadioButton rdo3 = new JRadioButton("Green");
        JRadioButton rdo4 = new JRadioButton("Yellow");
        /*
         * NOTE: When using Radio Buttons:
         * - User should be able to choose one item only
         * - At least one item should selected by default
         * 
         * We need to group the radio buttons options as we do with HTML5
         * ButtonGroup object logically groups a number of radio buttons
         * 
         * Let's try it with Operating Systems:
         * The three most common operating systems for personal computers are:
         * - Microsoft Windows
         * - macOS
         * - Linux
         */

        // Creating our radio buttons:
        JRadioButton wRdo = new JRadioButton("Windows", true);
        JRadioButton mRdo = new JRadioButton("macOS");
        JRadioButton lRdo = new JRadioButton("Linux");

        // Create ButtonGroup object:
        ButtonGroup osBtnGrp = new ButtonGroup();

        // Adding our individual buttons to the ButtonGroup object:
        osBtnGrp.add(wRdo);
        osBtnGrp.add(mRdo);
        osBtnGrp.add(lRdo);

        /*
         * A choice of items can be implemented by the JComboBox class
         * This creates a drop-down list from which the user can select any single item
         * new JComboBox(),
         * its constructor typically takes a String array as its argument
         * Each element in the array provides an item for selection in the drop-down
         * list
         * JComboBox is of type "Collections"
         * javax.swing.JComboBox.JComboBox<Object>()
         */

        // Put the theory into action :-)
        // Array of String data types
        String[] instruments = { "Guitar", "Keyboard", "Flute", "Bass", "Drums" };

        // Creating a JComboBox object:
        JComboBox box = new JComboBox<String>(instruments);

        /*
         * * The choice of "items" can be offered by the "JList" class.
         * 
         * JList class provides items for the drop-down list.
         * 
         * JList is of type "Collections"
         * javax.swing.JComboBox.JComboBox<Object>()
         */
        JList lst = new JList<String>(instruments);

        // 2. Creating the panel(s) and adding the components
        JPanel pnl1 = new JPanel();
        JPanel pnl2 = new JPanel();
        JPanel pnl3 = new JPanel();
        JPanel pnl4 = new JPanel();
        JPanel pnl5 = new JPanel(); // for the checkboxes and radio buttons examples
        JPanel pnl6 = new JPanel(); // for lists examples

        pnl1.add(btn1);
        pnl1.add(btn2);

        pnl2.add(btn3);
        pnl2.add(btn4);

        pnl3.add(txt1);
        pnl3.add(txt2);
        pnl3.add(txt3);
        pnl4.add(txtArea);
        pnl4.add(lbl);

        pnl5.add(chk1);
        pnl5.add(chk2);
        pnl5.add(chk3);
        pnl5.add(chk4);

        pnl5.add(rdo1);
        pnl5.add(rdo2);
        pnl5.add(rdo3);
        pnl5.add(rdo4);

        pnl5.add(wRdo);
        pnl5.add(mRdo);
        pnl5.add(lRdo);

        pnl6.add(box);
        pnl6.add(lst);

        // 3. Creating one main panel to contain all the other panels
        JPanel mainPanel = new JPanel();
        mainPanel.add(pnl1);
        mainPanel.add(pnl2);
        mainPanel.add(pnl3);
        mainPanel.add(pnl4);
        mainPanel.add(pnl5);
        mainPanel.add(pnl6);

        // 4. adding the mainPanel to the JFrame object
        frame.getContentPane().add(mainPanel);

        /*
         * How to layout all these components?
         * They are floating to the left by default
         * In the next class file... :-)
         */
    }
}
