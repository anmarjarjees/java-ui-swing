package p1gui_basics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// We need to import the GridLayout class from java.awt package
import java.awt.GridLayout;
import java.awt.Container; // For changing the layout on the runtime

/* 
 * Arranging The Components:
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
 * Package java.awt Class Summary:
 * BorderLayout:	
 * - A border layout lays out a container, 
 * - arranging and resizing its components to fit in five   
 * - regions: north, south, east, west, and center.
 */
public class C10GridLayout2 {
        public static void main(String[] args) {
                /*
                 * The top level JFrame object has "Content Pane"
                 * for placing components using the "BorderLayout" layout
                 * 
                 * - FloatLayout class
                 * - BorderLayout class: place up to 5 JPanel
                 * - CardLayout class
                 * - BoxLayout class
                 */

                JFrame frame = new JFrame("Working with GirdLayout");
                frame.setSize(800, 200);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 1. Creating all the components
                JButton btn1Top = new JButton("Button1 Top Panel");
                JButton btn2Top = new JButton("Button2 Top Panel");
                JButton btn3Top = new JButton("Button3 Top Panel");

                // using Mid for Middle
                JButton btn1Mid = new JButton("Button1 Middle Panel");
                JButton btn2Mid = new JButton("Button2 Middle Panel");
                JButton btn3Mid = new JButton("Button3 Middle Panel");

                // using btm for Bottom
                JButton btn1Btm = new JButton("Button1 Bottom Panel");
                JButton btn2Btm = new JButton("Button2 Bottom Panel");
                JButton btn3Btm = new JButton("Button3 Bottom Panel");

                // 2. Creating the panel(s) and adding the components
                // For better demonstration, lest create three panels
                JPanel mainPanel = new JPanel();
                /*
                 * JPanel panelTop = new JPanel();
                 * JPanel panelMiddle = new JPanel();
                 * JPanel panelBottom = new JPanel();
                 */
                mainPanel.add(btn1Top);
                mainPanel.add(btn2Top);
                mainPanel.add(btn3Top);

                mainPanel.add(btn1Mid);
                mainPanel.add(btn2Mid);
                mainPanel.add(btn3Mid);

                mainPanel.add(btn1Btm);
                mainPanel.add(btn2Btm);
                mainPanel.add(btn3Btm);

                /*
                 * mainPanel.add(panelTop);
                 * mainPanel.add(panelMiddle);
                 * mainPanel.add(panelBottom);
                 */

                // 4. Adding the JPanel object to the JFrame object

                /*
                 * Layout the content
                 * GridLayout
                 * Link:
                 * https://docs.oracle.com/javase/7/docs/api/java/awt/GridLayout.html#:~:text=
                 * The%20GridLayout%20class%20is%20a,is%20placed%20in%20each%20rectangle.
                 * 
                 * GridLayout() constructor:
                 * Constructs a new grid layout with 3 X 3 and no gaps between components
                 */
                GridLayout layout = new GridLayout(3, 3); // 3 X 3

                mainPanel.setLayout(layout);
                // 4. adding the mainPanel to the JFrame object
                frame.add(mainPanel);

                // Check:
                /*
                 * JOptionPane.showMessageDialog(null, "Modify Layout", "Layout Dialog Box", 1);
                 */

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

                /*
                 * void setColumns(int cols)
                 * Sets the number of columns in this layout to the specified value.
                 * 
                 * void setHgap(int hgap)
                 * Sets the horizontal gap between components to the specified value.
                 * 
                 * void setRows(int rows)
                 * Sets the number of rows in this layout to the specified value.
                 * 
                 * void setVgap(int vgap)
                 * Sets the vertical gap between components to the specified value.
                 */

                // We have 6 buttons 2 columns x 3 rows
                layout.setHgap(10);
                layout.setVgap(15);
                // Realign the placed GUI components
                layout.layoutContainer(container);
        }
}
