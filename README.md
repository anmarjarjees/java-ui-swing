## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Working with GUI Application in Java:
The Java Client consists of Java Deployment (Applets and Web Start) and Java UI (Swing, AWT and JavaFX) technologies.

We can develop GUI Applications in Java using:
- JavaFX 
- Abstract Window Toolkit (AWT)
- Swing

For VS Code user, you can check this article ["Working with GUI applications in VS Code"](https://code.visualstudio.com/docs/java/java-gui).

You can check this article about ["Java Client Roadmap Update"](https://www.oracle.com/technetwork/java/javase/javaclientroadmapupdate2018mar-4414431.pdf)


# User Interfaces with Swing
To create Swing Application, we can use and IDE that provides WYSIWYG (What You See Is What You Get) editor to make it easy and faster to arrange the components on the window/frame/panel, or writing or Swing code from scratch. 

Some IDEs comes with WYSIWYG like NetBeans. Without WYSIWYG, we need to use layout our component then adding all the even handling manually.

Most of the Swing GUI components are inherited from "JComponent" and the hierarchy for "JComponent" class:
"JComponent" class = extends => "Container" class = extends => "Component" class = extends => "Object" class

Class JComponent:
- java.lang.Object
    - java.awt.Component
        - java.awt.Container
            - javax.swing.JComponent

The base class for all Swing components except top-level containers. To use a component that inherits from JComponent, you must place the component in a containment hierarchy whose root is a top-level Swing container. Top-level Swing containers -- such as JFrame, JDialog, and JApplet -- are specialized components that provide a place for other Swing components to paint themselves.

You can read more about ["javax.swing - Class JComponent"](https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JComponent.html)

## Swing Containers
Swing has a list of top level container that are used to contain the GUI components including JFrame (the one that we will use), JWindow, JDialog, JApplet. All the above containers rely on the "JRootPane". JRootPane manges all Swing containers so it's acting as a container delegate for the top level Swing containers.

These Top-Level containers like our main one "JFrame" has a content pane, like "Panel". Panel is used to contain the visual components of GUI.

Example:
1- JFrame => the top-level container (Represent the GUI window)
2- To add item(s) to the GUI window, we need to add another frame "JPanel"
3- Adding JPanel to the JFrame
4- Adding JComponents (text fields, buttons, list,...) to the JPanel 

NOTES: 
- We can change the order in coding like adding JComponents to the JPanel, then adding JPanel to the JFrame. Or, adding JPanel to the JFrame then adding JComponents to the JFrame, is the same.
- We cannot add JComponents directly to JFrame as the last components will replace all the previous ones, you can see the issue in my code example "Main1.java". So the JComponents have to be added to the "JPanel". 

![JFrame-JPanel-JComponents](/images/JFrame-JPanel-JComponents.jpg)

## Frames and Panels
- After instantiating our frame, we can add one or more panels that contain(s) the GUI components
- Frame can be instantiated with or without a title. The JFrame has two instructors:
    - Empty Constructor
    - A constructor that accept a string to represent the Window/Frame title. Notice that title can be added later also using .setTitle() method for the JFrame object.
- Panel(s), JPanel can be added to the JFrame. Swing Application can have multiple JPanels objects inside the JFrame, but only one JFrame object/instance.
- All our graphical components are being added to the "JPanel"
- JPanel has a default layout called "FlowLayout", the components are being added from left to write and wrap to the next line when they run out room. Think about the "FlowLayout" is like floating all the HTML element to the left inside their container element.

## Jframe
Represents the window itself. all the components of the user interface will be inside this window

## Swing Components
- Swing library has a huge list of components
- All components inherit from the JComponent class
- JComponent class extends the Container class

Check this interesting page ["A Visual Guide to Swing Components"](https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html) from Massachusetts Institute of Technology.

## Layout Managers in Swing
 - Layout Managers are classes that control the size and location of each item of the components inside the container.
 - The default layout is called "FlowLayout" which adds elements from left to right (as discussed above)
 
 Swing provides many different layout managers
 - BorderLayout: Divides the window into five areas: North, South, East, West and Center (the content pane default)
 - BoxLayout: Places/Stacks components in a single row (besides each other) or column (top or each other)
 - CardLayout: Places and manages different/multiple components in a specified area or that share the same display area at different times
 - FlowLayout: Places left to right in a wrapping line/row (the jPanel default)
 - GridBagLayout: Displays components in a grid of cells or in rows and columns; allows components to span cells (rows/columns) and varying sizes
- GridLayout: Places components in a grid of rows and columns or in equally sized rows and columns
- GroupLayout: Places components in horizontal and vertical layout separately
- SpringLayout: Places by relative spacing which is a flexible layout tht emulates all other layouts

# Java AWT (Abstract Window Toolkit)
One of the oldest GUI frameworks in Java. AWT is an API for creating GUI applications in Java. first
[AWT in Wikipedia](https://en.wikipedia.org/wiki/Abstract_Window_Toolkit#:~:text=The%20Abstract%20Window%20Toolkit%20(AWT,GUI)%20for%20a%20Java%20program.)

HINT:
To move Classes between Packages:
- Open the Class File you want to move
- Press CTRL+SHIFT+R
- From the top panel select the package name

You can learn more about ["Moving in VS Code"](https://code.visualstudio.com/docs/java/java-refactoring)

# java-ui-swing
Using Swing and AWT for Creating GUI with Java

1. p1gui_basics (package):

2. p2events_basics (package):

3. p3user_interface_events (package):
We will have at least two source code files"
- The main program that has the main() method
- The class file that extends *JFrame class and contains the GUI components

JFrame is the basic window class for a Swing GUI. JFrame can be used in two different ways:
- Attaching GUI components directly to an object/instance of the class JFrame as we did in the previous package
- Extending the JFrame class to create your new custom subclass of JFrame that contain the specific component that are needed for our application

# Events
User can interact with the GUI by performing actions with a mouse, keyboard, or other input device. These actions cause "events" and the program can respond to these events and it's known as "Event-Handling".

To make our program (Java class) able to recognize these events, it needs one or more "EventListener" interface to be added (implemented) by importing the "java.awt.event" package.

> import java.awt.events.*;

Java documentation includes many "EventListener" Interfaces. The most common ones are listed below with brief description:
- ActionListener => Action listeners are probably the easiest — and most common — event handlers to implement. You implement an action listener to define what should be done when an user performs certain operation.
- ItemListener => 
- KeyListener =>
- MouseListener =>
- MouseMotionListener =>

Each "EventListener" interface has one ore more associated event-handler method(s) that has/have to be implemented when an event is recognized. For example, the "ActionListener" interface has one associated method named "actionPerformed()" and passes an "ActionEvent" object as its argument.
```
public void actionPerformed(ActionEvent e) {
    // your code...
}
```

You can check this article about ["Java Event Listeners and How They Work"](https://www.thoughtco.com/event-listener-2034089#:~:text=An%20event%20listener%20in%20Java%20is%20designed%20to%20process%20some,object%20that%20defines%20the%20event.).

## Action Listener
An action event occurs, whenever an action is performed by the user. Examples: When the user clicks a button, chooses a menu item, presses Enter in a text field. The result is that an actionPerformed message is sent to all action listeners that are registered on the relevant component.

For example, to have respond to a button click, the "ActionListener" interface can be implemented by our custom class and the button's "addActionListener()" method must be called the passing the argument "this". This makes the button generate an event when it gets clicked.

Code Example for creating a button that generates events:
```
JButton btn = new JButton("Click Me");
btn.addActionListener(this);
```

# References, Resources, and Credits:
- CORE JAVA Volume 1: Fundamentals By Cay S. Horstmann
- Java How to Program, 11/e By by Paul Deitel and Harvey Deitel
- Java Master the Major Features by Mike McGrath
- Programming with Java by Shaun Wassell
- [Java Tutorial Learning Path](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)
- [Oracle Docs](https://docs.oracle.com/javase/7/docs/api/overview-summary.html)
- [Java Platform, Standard Edition](https://docs.oracle.com/en/java/javase/17/core/index.html)
- [Package java.awt](https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/package-summary.html)
- [Package javax.swing](https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/package-summary.html)
- [Guru99 Java Tutorial](https://www.guru99.com/java-tutorial.html)
- [Oracle - Trail: Creating a GUI With Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html)


