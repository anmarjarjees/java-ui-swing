package user_interface_basics;

/* 
 * Using Swing Graphical User Interface (GUI) API "javax.swing"
 * to generate: predefined dialog box capabilities  
 * 
 * Demonstrate the basic of input/output dialog box
 * By using "JOptionPane" class
 * This class is used to provide standard dialog boxes
 * JOptionPane is a component from Java Swing and it deals with dialog boxes especially
 *
 * 
 * Link: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 */

// "JOptionPane" class is from "javax.swing" package
// so we need to import it:
import javax.swing.JOptionPane;

// javax => the letter x is for Java eXtra, or Java eXtensions

public class C01Basic {
        /*
         * With GUI applications
         * The main() method is to get the main window on the screen
         * to allow the user performing the tasks
         * when the main() method terminates,
         * The program stays up and running as long as there is a window
         * from the app on the screen.
         * This because there is a separate thread of execution,
         * that's dedicated to receiving user interactions
         * and invoking "Event Handling" methods for performing tasks in the program
         * 
         * With this simple program, we are just using dialogs in main()
         * The program is going to terminate as soon as
         * it reaches the closing curly brace of main() method
         */
        public static void main(String[] args) {
                /*
                 * - JOptionPane class has a large number of "static" methods
                 * - they all fit in the format of showXxxDialog:
                 * > showMessageDialog() => To show a dialog box with a message
                 * > showInputDialog() => To prompt the user to input a value
                 * > showConfirmDialog() => to ask the user to confirm his choice:
                 * yes/no/cancel.
                 * > showOptionDialog() => The combination of the above three.
                 */

                /*
                 * 4 Parameters:
                 * *************
                 * 1. parentComponent => could be the main window frame (to be covered later...)
                 * In this example, there no parent window => "null" by default
                 * 
                 * 2. message => the text/message to be displayed (null by default) within the
                 * box (in the body of the dialog box)
                 * 
                 * 3. title => the title bar of the dialog window (null by default)
                 * 
                 * 4. messageType: int value to determine the icon displayed in the dialog.
                 * Choose from one of the following numeric values or the JOptionPane CONSTANTS:
                 * PLAIN_MESSAGE (no icon)
                 * 0 OR JOptionPane.ERROR_MESSAGE => For ERROR_MESSAGE Icon
                 * 1 OR JOptionPane.INFORMATION_MESSAGE => For INFORMATION_MESSAGE Icon
                 * 2 OR JOptionPane.WARNING_MESSAGE => For WARNING_MESSAGE Icon
                 * 3 OR JOptionPane.QUESTION_MESSAGE => For QUESTION_MESSAGE Icon
                 * 
                 * NOTE:
                 * if you put negative value => no icon will appear
                 * if you put invalid value => Runtime Error
                 */
                JOptionPane.showMessageDialog(null, "Welcome to the Standard Dialog Boxes Example!",
                                "showMessageDialog() static method", 1);

                // Yes, we should wrap this program with try{} and catch{}
                // Obtaining the user input for the first numeric value
                // NOTE: JOptionPane.showInputDialog(args) = returns => String data type
                String numStr = JOptionPane.showInputDialog("Enter your first exam value");
                double exam1 = Double.parseDouble(numStr);

                // Or we can do it in one line but it might look more complicated:
                double exam2 = Double.parseDouble(JOptionPane.showInputDialog("Enter your second exam value"));

                // find the average for the two exams
                double average = (exam1 + exam2) / 2;

                if (average < 60) {
                        JOptionPane.showMessageDialog(null,
                                        "Sorry, you need to retake the exams again, your average is " + average
                                                        + " which is less than 60",
                                        "showMessageDialog() static method", 0);
                } else if (average <= 70) {
                        JOptionPane.showMessageDialog(null, "You were able to make it, your average is " + average,
                                        "showMessageDialog() static method", 2);
                } else if (average <= 100) {
                        JOptionPane.showMessageDialog(null, "Good Job! Your average is " + average,
                                        "showMessageDialog() static method", 1);
                }

                /*
                 * Important Note to Remember:
                 * These dialog boxes are called "Modal" Dialogs
                 * The user must interact with that dialogue
                 * before the program will continue to the next statement
                 */
        }
}