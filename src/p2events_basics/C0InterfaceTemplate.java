package p2events_basics;

/* 
 * The hierarchy of all the GUI components:
 * > java.lang.Object
 * >> java.awt.Component
 * >>> java.awt.Container
 * >>>> javax.swing.JComponent
 */
// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* 
 * Quick Review and GUI Template
 * to be used in this folder
 * 
 * This class "C0InterfaceTemplate" as an example,
 * will be used to represent the GUI and its components
 * 
 * We declare it as a subclass from the superclass "JFrame"
 */
public class C0InterfaceTemplate extends JFrame {
    /*
     * Adding the class instances:
     */
    // Just declaring all the components to be used in the JFrame:
    // Create JPanel container object:
    JPanel pnl = new JPanel();

    /*
     * Creating the Constructor method to specify the Swing Window Requirements
     * and adding JPanel object to the JFrame
     * The constructor should include statements
     * to set these minimum requirements:
     */
    public C0InterfaceTemplate() {
        // we used => new JFrame("the window title")
        // we don't use this syntax: JFrame frame = new JFrame("Title");
        // since we extended the JFrame Class
        // instead, we use super() method:
        /*
         * Passing the String title
         * to the inherited super() method
         * of the the "JFrame" class
         */
        super("GUI Swing Window");
        // instead of using the object "frame" => frame.setSize(500, 200);
        setSize(500, 200);
        // instead frame.setVisible(true);
        setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the JPanel object to the JFrame:
        add(pnl);
    } // end constructor

    // Adding the main() method as the entry point for our application:
    public static void main(String[] args) {
        /*
         * Create an instance of the Window class
         */
        // C0InterfaceTemplate comEvents = new C0InterfaceTemplate();
        // To avoid the Java Compiler Warning:
        // "The value of the local variable comEvents is not used":
        // Just use:
        new C0InterfaceTemplate();
    }

} // end class file
