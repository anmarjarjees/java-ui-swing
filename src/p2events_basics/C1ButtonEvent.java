package p2events_basics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// We need to import the GridLayout class from java.awt package
import java.awt.GridLayout;

// import "Color" class from java.awt package for adding colors
import java.awt.Color;

// import "Font" class from java.awt package for customizing the fonts
import java.awt.Font;
/* 
 * NOTE: in order for our class to implement the ActionListener for any keyboard/mouse event
 * our class needs to implement the interface "ActionListener"
 * Link: https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
 * 
 * And we need to import it:
 */
import java.awt.event.ActionListener;

/* 
 * For every "ActionListener" interface,
 * we need to import "ActionEvent" class 
 * to be the data type of the event object
 */
import java.awt.event.ActionEvent;
/* 
 * Another way of invoking the "JFrame" class
 * is to make our custom class inherits all the members and features from the JFrame class
 * 
 * Then adding the implementation statement at the end when start coding the actions
 * After adding the implements syntax:
 * Java Compiler will say:
 * The type C1ButtonEvent must implement 
 * the inherited abstract method ActionListener.actionPerformed(ActionEvent)
 * 
 * We can use "Quick Fix" to let VS code implementing the required method(s)
 */

public class C1ButtonEvent extends JFrame implements ActionListener {
    /*
     * Creating/Declaring all the instance variables here
     */
    int initValue;

    // 1. Creating all the components
    private JButton btn1 = new JButton("Increase Number");
    private JButton btn2 = new JButton("Decrease Number");
    private JTextField txt1 = new JTextField(5);

    // 2. Creating the panel(s) for adding all the components
    private JPanel pnl = new JPanel();

    /*
     * Adding Appearance:
     * 
     * Each Component has a setBackground() method and setForeground() method
     * both methods take a "Color" object as their argument to color the component
     * 
     * create Color, Font, and layout objects
     * 
     * "Color" class:
     * - has constants for representing a few basic colors.
     * Example => Color.RED
     * 
     * - its constructor can take three integer arguments (0 to 255)
     * to represent Red, Green, Blue (RGB) values for the custom colors
     * 
     * Link: https://www.w3schools.com/colors/colors_picker.asp
     */
    Color greenDark = new Color(0, 128, 0);
    Color blueDark = new Color(0, 64, 128);

    Color greenLight = new Color(193, 240, 193);
    Color blueLight = new Color(204, 230, 255);

    /*
     * "Font" class:
     * - to modify the font (typeface) of any text
     * - its constructor can take three arguments:
     * > name => Should be either "Serif", "SansSerif", or "Monospaced"
     * > style => Should be either Font.PLAIN, Font.BOLD, or Font.ITALIC
     * > size => Should be an integer value to specify the size
     * 
     * Each component has a setFont() method that takes the a Font object
     * as its argument
     */
    Font myFont = new Font("Serif", Font.BOLD, 32);
    // lbl.setHorizontalTextPosition(1);

    Font btnFont = new Font("SansSerif", Font.ITALIC, 22);

    GridLayout layout = new GridLayout(2, 1); // 2 X 2

    // Since we only have one panel so no need for
    // (No Need) 3. Creating one main panel to contain all the other panels
    /*
     * JPanel mainPanel = new JPanel();
     * mainPanel.add(pnl);
     */

    // Class Constructor:
    public C1ButtonEvent() {
        super("Swing GUI with Event Quick Demo1");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt1.setText("Current Value: " + initValue);

        // Setting the values by calling all the "painting" classes from the super():
        btn1.setForeground(greenDark);
        btn1.setBackground(greenLight);

        btn2.setForeground(blueDark);
        btn2.setBackground(blueLight);

        btn1.setFont(btnFont);
        btn2.setFont(btnFont);

        // we can set a border for the JPanel object:
        // Link: https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
        // Link:
        // https://docs.oracle.com/javase/8/docs/api/javax/swing/BorderFactory.html
        /*
         * createBevelBorder(int type, Color highlight, Color shadow)
         * Creates a beveled border of the specified type,
         * using the specified highlighting and shadowing.
         */
        pnl.setBorder(BorderFactory.createBevelBorder(0, Color.RED, Color.BLUE));

        pnl.setLayout(layout);

        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(txt1);

        // 4. adding the mainPanel or the only panel we have to the JFrame object
        // getContentPane().add(pnl);
        // Or using:
        add(pnl); // instead of frame.add(pnl) => as we don't have JFrame frame = new JFrame();

        /*
         * Adding the Events:
         * *****************
         */

        // Adding "Action Listener" to each button:
        // passing "this" as a parameter
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    } // end constructor

    /*
     * This is the method that were added with quick fix
     * is used with the events
     * it's called the "Event Handler" method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Testing:
        System.out.println("Event Action Class: " + e.getClass());
        System.out.println("Event Action Command: " + e.getActionCommand());
        System.out.println("Event Action Modifiers: " + e.getModifiers());
        System.out.println("Event Action Source: " + e.getSource());

        /*
         * > Event Action Class: class java.awt.event.ActionEvent
         * The class of the event (e) object from the package "java.awt.event"
         * 
         * > Event Action Command: Increase Number OR Decrease Number
         * the value "Increase Number" is from the JButton constructor:
         * new JButton("Increase Number") when instantiated our JButton object
         * 
         * Event Action Modifiers:16
         */

        /*
         * Since we have two buttons, we need to check:
         */
        if (e.getSource() == btn1) {
            initValue++;
            // testing:
            System.out.println("btn1: " + initValue);
        } else {
            initValue--;
            // testing:
            System.out.println("btn2: " + initValue);
        }
        txt1.setText("Current Value: " + initValue);
    } // end "Event Handler" method: actionPerformed()

    public static void main(String[] args) {
        new C1ButtonEvent();
    } // end main()
} // end file class
