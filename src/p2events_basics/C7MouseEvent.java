package p2events_basics;

// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* 
 * Mouse Events:
 * > Mouse Action => can be recognized by "MouseListener" interface
 * > Mouse Movement => can be recognized by "MouseMotionListener" interface
 * so we need to implement these 2 interfaces: "MouseListener" and "MouseMotionListener"
 * 
 * - "MouseListener" interface has 5 Event-handler methods:
 * > mousePressed(MouseEvent)
 * > mouseReleased(MouseEvent)
 * > mouseClicked(MouseEvent)
 * > mouseEntered(MouseEvent)
 * > mouseExited(MouseEvent)
 * 
 * - "MouseMotionListener" interface has 2 Event-handler methods:
 * > mouseMoved(MouseEvent)
 * > mouseDragged(MouseEvent)
 * 
 *  we need to implement the 2 interfaces
*/
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/* 
 * For the two interfaces,
 * we need to import "MouseEvent" class 
 * to be the data type of the event object
 * to be passed to the Event-handler methods
 */
import java.awt.event.MouseEvent;

// Using the VS code Quick Fix or any tools based on your IDE to implement all the methods
/* 
 * We must declare all the associated Event-handler methods for both interfaces,
 * even if not all are actually used
 */
public class C7MouseEvent extends JFrame implements MouseListener, MouseMotionListener {
    // Just declaring all the components to be used in the JFrame:
    // Create JPanel container object:
    JPanel pnl = new JPanel();

    JTextField txtFieldMove = new JTextField(30);
    JTextField txtFieldDrag = new JTextField(30);
    JTextArea txtArea = new JTextArea(10, 35);

    // the coordinates:
    int x, y;

    // Class Constructor:
    public C7MouseEvent() {
        super("Swing with Mouse Events");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(txtFieldMove);
        pnl.add(txtFieldDrag);
        pnl.add(txtArea);

        /*
         * Adding the Events:
         * *****************
         */
        /*
         * Events Step#1: Adding the 2 specific events:
         * - addMouseMotionListener()
         * - addMouseListener()
         * Adding "addKeyListener" to the component(s): txtField
         * passing "this" as a parameter
         */
        txtArea.addMouseMotionListener(this);
        txtArea.addMouseListener(this);
    } // end constructor

    // Events Step#2:
    // Adding the specific "Event Handler" method(s):
    /*
     * The "MouseMotionListener" Interface has 2 Event-handler methods:
     * All the method accept the object of type "MouseEvent"
     * > mouseMoved(MouseEvent) => Mouse is moved
     * > mouseDragged(MouseEvent) => Mouse is dragged
     * 
     * The "MouseListener" Interface has 5 Event-handler methods:
     * > mousePressed(MouseEvent) => Button is pressed
     * > mouseReleased(MouseEvent) => Button is released
     * > mouseClicked(MouseEvent) => Button has been released
     * > mouseEntered(MouseEvent) => Mouse moves on
     * > mouseExited(MouseEvent) => Mouse moves off
     * 
     * Even if we don't use all of them as keyTyped and keyPressed almost have the
     * same response time
     * But we have to implement them all
     */

    // Starting with "MouseMotionListener" methods:
    @Override
    public void mouseMoved(MouseEvent e) {
        // Don't try it! :-) => txtArea.append("\nMouse Moved");
        x = e.getX();
        y = e.getY();
        txtFieldMove.setText("X-Coordinate: " + x + " | Y-Coordinate: " + y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Don't try it! :-) => txtArea.append("\nMouse Dragged");
        x = e.getX();
        y = e.getY();
        txtFieldDrag.setText("X-Coordinate: " + x + " | Y-Coordinate: " + y);
    }

    // then "MouseListener" methods
    @Override
    public void mouseEntered(MouseEvent e) {
        txtArea.setText("\nMouse Entered");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        txtArea.append("\nMouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        txtArea.append("\nMouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        txtArea.append("\nMouse Released");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        txtArea.append("\nMouse Exited");
    }

    // Adding the main() method as the entry point for our application:
    public static void main(String[] args) {
        new C7MouseEvent();
    } // end main()

} // end class file
