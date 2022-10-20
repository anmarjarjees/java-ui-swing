package user_interface_basics;

// Too many import statements!
/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
*/

// Keep it simple with all *
import javax.swing.*;

public class C03JFrameJPanel1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Review the logical steps:
         * - Creating a Frame: JFrame
         * - Creating Panel (which is a portion of the JFrame window)
         * - Adding components (contents) inside this panel
         * - Finally adding the panel(s) to the frame (the window)
         * - Using Panels. Panel is a subsection of a window to layout our content
         * in a more organized way
         * Adding components to panels ==> Adding panels to frames
         */

        // 1. Creating the button(s)
        JButton btn1 = new JButton("Click Me");
        JButton btn2 = new JButton("Calculate Average");

        // 2. Adding to them to the panel frame:
        JPanel pnl = new JPanel();

        // Adding our two components (buttons) to the panel:
        pnl.add(btn1);
        pnl.add(btn2);

        // Adding our JPanel object "pnl" to our frame
        frame.getContentPane().add(pnl);

        /*
         * How to add multiple panels for different components?
         * In the next class file... :-)
         */
    }
}
