package user_interface_basics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// We need to import the FlowLayout class and Container class from java.awt package
import java.awt.FlowLayout;
import java.awt.Container; // For changing the layout on the runtime

/* 
 * Arranging The Components
 * - java.awt package (Abstract Window Toolkit) contains a number of layout manager classes
 * - These classes can be used to place components in a container if different ways
 * Link: https://docs.oracle.com/javase/7/docs/api/java/awt/package-summary.html
 * 
 * java.awt package:
 * - Contains all of the classes for creating user interfaces and for painting graphics and images. 
 * - A user interface object such as a button or a scrollbar is called, in AWT terminology, a component. 
 * - The Component class is the root of all AWT components. See Component for a detailed description of properties that all AWT components share.
 * Link: https://docs.oracle.com/javase/7/docs/api/java/awt/package-summary.html#package_description
 * 
 * 
 * Package java.awt Class Summary:
 * BorderLayout:	
 * - A border layout lays out a container, 
 * - arranging and resizing its components to fit in five   
 * - regions: north, south, east, west, and center.
 * 
 * CardLayout:	
 * A CardLayout object is a layout manager for a container.
 */
public class C08FloatLayout2 {
        public static void main(String[] args) {
                /*
                 * The top level JFrame object has "Content Pane"
                 * for placing components using the "BorderLayout" layout
                 * 
                 * - FloatLayout
                 * - BorderLayout class: place up to 5 JPanel
                 * - CardLayout class
                 * - BoxLayout class
                 */

                /*
                 * FloatLayout: can be left, center, or right
                 * Center alignment is the default
                 */

                JFrame frame = new JFrame("Working with javax.swing package");
                frame.setSize(800, 200);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 1. Creating all the components
                JButton btn1 = new JButton("Click Me");
                JButton btn2 = new JButton("Calculate Average");

                JButton btn3 = new JButton("Another Button");
                JButton btn4 = new JButton("One more Button");

                // 2. Creating the panel(s) and adding the components
                JPanel panel = new JPanel();

                panel.add(btn1);
                panel.add(btn2);
                panel.add(btn3);
                panel.add(btn4);

                // This point "3" is N/A in this file as we only have one panel
                // 3. Creating one main panel to contain all the other panels

                /*
                 * Layout the content
                 * Flow layouts are typically used to arrange buttons in a panel.
                 * It arranges buttons horizontally until no more buttons fit on the same line.
                 * The line alignment is determined by the align property.
                 * The possible values are:
                 * LEFT
                 * RIGHT
                 * CENTER
                 * LEADING
                 * TRAILING
                 * 
                 * The value of the alignment argument must be one of:
                 * FlowLayout.LEFT => int LEFT = 0
                 * FlowLayout.CENTER => int CENTER = 1
                 * FlowLayout.RIGHT => int RIGHT = 2
                 * FlowLayout.LEADING => int LEADING = 3
                 * FlowLayout.TRAILING => int TRAILING = 4
                 * 
                 * Link:
                 * https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/
                 * FlowLayout.html
                 */
                FlowLayout layout = new FlowLayout(FlowLayout.LEFT);

                // We don't need this line for setting the alignment,
                // as it was set by the constructor
                // layout.setAlignment(FlowLayout.LEFT);

                panel.setLayout(layout);

                // 4. Adding the JPanel object to the JFrame object
                frame.add(panel);
                /*
                 * Working with Container Object method called "getContentPane()"
                 */
                // Link:
                // https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JFrame.html#getContentPane()

                /*
                 * Assign to the Container instance/object the result
                 * of calling the JFrame method called ".getContentPane"
                 * 
                 * The Content Pane is where the GUI components are attached to the window
                 * this method is basically tells the content page to re-layout itself
                 * anytime the layout changes
                 * 
                 * So the object "container" refers to the
                 * content pane of the JFrame
                 * 
                 */
                Container container = frame.getContentPane();

                JOptionPane.showMessageDialog(null, "Layout => Change to Right",
                                "Layout Dialog Box", 1);

                /*
                 * The code below:
                 * when we change the layout
                 * by using "layout" object by .setAlignment()
                 * we need to tell the "layout" object
                 * to reposition the components based
                 * on the new layout and the layout container
                 */
                layout.setAlignment(FlowLayout.RIGHT);
                // Realign the placed GUI components
                layout.layoutContainer(container);

                JOptionPane.showMessageDialog(null, "Layout => Change to CENTER",
                                "Layout Dialog Box", 1);
                layout.setAlignment(FlowLayout.CENTER);
                layout.layoutContainer(container);

                JOptionPane.showMessageDialog(null, "Layout => Change to LEFT",
                                "Layout Dialog Box", 1);
                layout.setAlignment(FlowLayout.LEFT);
                layout.layoutContainer(container);
        }
}
