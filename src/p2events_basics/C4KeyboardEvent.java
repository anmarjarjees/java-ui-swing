package p2events_basics;

// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* 
 * Key actions/strokes can be recognized by "KeyListener" interface
 * so we need to implement this interface "KeyListener"
 * that has 3 event-handlers methods after importing it:
*/
import java.awt.event.KeyListener;

/* 
 * For every "KeyListener" interface,
 * we need to import "KeyEvent" class 
 * to be the data type of the event object
 */
import java.awt.event.KeyEvent;

public class C4KeyboardEvent extends JFrame implements KeyListener {
    // Just declaring all the components to be used in the JFrame:
    // Create JPanel container object:
    JPanel pnl = new JPanel();

    JTextField txtField = new JTextField(30);
    JTextArea txtArea = new JTextArea(5, 30);

    public C4KeyboardEvent() {
        super("GUI Swing Window");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(txtField);
        pnl.add(txtArea);

        /*
         * Adding the Events:
         * *****************
         */
        // Events Step#1: Adding the specific event => addKeyListener()
        // Adding "addKeyListener" to the component(s): txtField
        // passing "this" as a parameter
        txtField.addKeyListener(this);

    } // end constructor

    // Events Step#2:
    // Adding the specific "Event Handler" method(s):
    /*
     * The "KeyListener" Interface has 3 Event-handler methods:
     * All the method accept the object of type "KeyEvent"
     * keyTyped(KeyEvent e) => called after a key is pressed
     * keyPressed(KeyEvent e) => called when a key is pressed
     * keyReleased(KeyEvent e) => called when a key is released
     * 
     * Even if we don't use all of them as keyTyped and keyPressed almost have the
     * same response time
     * But we have to implement them all
     */

    // Let's start with the beginning when we first press a key:
    // when a key gets pressed:
    @Override
    public void keyPressed(KeyEvent e) {

        // testing:
        // To return the object on which the Event initially occurred:
        System.out.println("Source: " + e.getSource());

        // To return the character for the pressed/typed/released key:
        System.out.println("e.getKeyChar(): " + e.getKeyChar());

        // To return the integer Unicode value that represents that key:
        System.out.println("e.getKeyCode(): " + e.getKeyCode());

        // To return a description of any key:
        // The key code value has to be passed as an argument
        /*
         * Notice that .getKeyText() method is a static method (class method)
         * it cannot be accessed by the class object/instance
         * Example (Error) => e.getKeyText(50);
         * Example (Correct) => KeyEvent.getKeyText(50);
         */
        System.out.println("keyPressed => KeyEvent.getKeyText(x): " + KeyEvent.getKeyText(e.getKeyCode()));

        // To return the location of that key:
        // 1 if the only one key or 2 and 3 for the two SHIFT keys
        System.out.println("e.getKeyLocation(): " + e.getKeyLocation());

        txtArea.setText("Key Pressed");
        txtArea.append("\nPressed Character (keyPressed): " + e.getKeyChar());
    }

    // What happens after pressing a key:
    // after the key has been pressed
    @Override
    public void keyTyped(KeyEvent e) {
        /*
         * using the "KeyEvent" object method named "getKeyCode()"
         * .getKeyCode() => returns the key code if called withing
         */
        // appending the text to the text area instead of reset it:
        txtArea.append("\nTyped Character (keyTyped): " + e.getKeyChar());

        /*
         * NOTE:
         * We will not be able to get the description of the key inside this method?
         * Because we are getting the key code by using .getKeyCode() method
         * of the KeyEvent object
         * But .getKeyCode() doesn't work or doesn't return anything
         * with keyTyped() Event-handler
         */
        // testing again the static method KeyEvent.getKeyText(x):
        System.out.println("keyTyped => KeyEvent.getKeyText(x): " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // appending the text to the text area instead of reset it:
        txtArea.append("\nReleased Character (keyReleased): " + e.getKeyChar());

        // testing again the static method KeyEvent.getKeyText(x):
        System.out.println("keyReleased => KeyEvent.getKeyText(x): " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    // Adding the main() method as the entry point for our application:
    public static void main(String[] args) {
        new C4KeyboardEvent();
    } // end main()

} // end class file
