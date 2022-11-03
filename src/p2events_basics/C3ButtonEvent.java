package p2events_basics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;

/* 
 * Don't forget that VS Code cannot resolve (quick fix) the java.awt.* package classes
 * we have to do it:
 * like below importing the two classes from "java.awt.event" package:
 */
import java.awt.event.ActionListener;

/* 
 * For every "ActionListener" interface,
 * we need to import "ActionEvent" class 
 * to be the data type of the event object
 */
import java.awt.event.ActionEvent;

// for colors:
import java.awt.Color;

public class C3ButtonEvent extends JFrame implements ActionListener {

    // Just declaring all the components to be used in the JFrame
    JPanel pnl = new JPanel();

    private JButton btn1 = new JButton("Green Theme");
    private JButton btn2 = new JButton("Blue Theme");
    private JTextArea txtArea = new JTextArea(2, 30);

    // The appearance:
    Color greenDark = new Color(0, 128, 0);
    Color blueDark = new Color(0, 64, 128);

    Color greenLight = new Color(193, 240, 193);
    Color blueLight = new Color(204, 230, 255);

    // Class Constructor:
    public C3ButtonEvent() {
        super("Swing with Button Events Demo#2");
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(txtArea);

        /*
         * Setting the initial state for textArea
         * Notice that btn1 and btn2 are enabled by default,
         * you can set their initial value(s) for both or one of them
         * to be disabled, but why? no reason!
         */
        txtArea.setText("Click any button to change the theme color");

        /*
         * Event Step#1:
         * Adding the required event "ActionListener" to each button
         */
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    } // end Constructor

    /*
     * Event Step#2: Is already implemented through using The Quick Fix
     * Adding the event-handler method for the "ActionListener" interface
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * .getActionCommand() will return the label (text) of the current clicked
         * button
         * concatenating our text to it:
         */
        txtArea.setText(e.getActionCommand() + " is applied and its button is disabled");
        /*
         * Adding if-statement to check which button was clicked
         */
        if (e.getSource() == btn1) {
            btn2.setEnabled(true);
            btn1.setEnabled(false);
            changeTheme(1);
        }
        if (e.getSource() == btn2) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            changeTheme(2);
        }
    } // end "Event Handler" method: actionPerformed()

    /*
     * Create a method to change the color theme:
     * - Green Theme
     * - Red Theme
     */
    public void changeTheme(int colorNumber) {
        // 1 for green and 2 for blue
        if (colorNumber == 1) {
            pnl.setBackground(greenDark);

            btn1.setBackground(greenLight);
            btn2.setBackground(greenLight);

            btn1.setForeground(greenDark);
            btn2.setForeground(greenDark);
        } else if (colorNumber == 2) {
            pnl.setBackground(blueDark);

            btn1.setBackground(blueLight);
            btn2.setBackground(blueLight);

            btn1.setForeground(blueDark);
            btn2.setForeground(blueDark);
        } else {
            System.out.println("Invalid Number");
        }
    } // end our customs method

    public static void main(String[] args) {
        new C3ButtonEvent();
    } // end main()

} // end file class
