package user_interface_basics;

// Importing all the classes from "javax.swing" package:
import javax.swing.*;

public class C04JFrameJPanel2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Creating the button(s)
        JButton btn1 = new JButton("Click Me");
        JButton btn2 = new JButton("Calculate Average");

        // 2. Adding to them to the panel frame:
        JPanel pnl1 = new JPanel();

        // Adding our two components (buttons) to the panel:
        pnl1.add(btn1);
        pnl1.add(btn2);

        // Adding our JPanel object "pnl" to our frame
        frame.getContentPane().add(pnl1);

        JPanel pnl2 = new JPanel();
        JButton btn3 = new JButton("Another Button");
        JButton btn4 = new JButton("One more Button");

        pnl2.add(btn3);
        pnl2.add(btn4);
        frame.getContentPane().add(pnl2);
        /*
         * Issue:
         * We will only see the last two button for the last panel "panel2"
         * frame can contain one panel only!
         * but one panel can contain other child panels
         * In the next class file... :-)
         */
    }

}
