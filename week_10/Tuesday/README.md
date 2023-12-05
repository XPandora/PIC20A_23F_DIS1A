# Events

**Events** are used to capture and respond to different types of user interactions with GUI components. An **event listener** is an interface that contains methods to be implemented for handling specific types of events. When an event occurs (like a button click, mouse movement, or key press), the corresponding listener's methods are invoked to execute predefined actions.

### Commonly Used Event Listeners in Swing:

1.  **ActionListener**: Responds to button clicks or menu selections.
2.  **MouseListener**: Handles mouse events like clicks, presses, releases, enters, and exits.
3.  **KeyListener**: Responds to keypress events on a component.

When a Component has the method

```Java
public void addXListener(XListener l)
```

you can tell that it can trigger a XEvent under certain conditions.

## ActionEvent & ActionListener

Buttons and clickable components can fire `java.awt.event.ActionEvents`
A `java.awt.event.ActionListener` listens to an ActionEvent.

The interface ActionListener has one method

```Java
public void actionPerformed(ActionEvent e)
```

which is called when the ActionEvent the ActionListener is listening to is fired.

A JButton (and any AbstractButton) can fire an ActionEvent. Use

```Java
addActionListener(ActionListener l)
```

to attach an ActionListener to the JButton’s ActionEvent.

Below is a basic example of adding an `ActionListener` to a `JButton`:

```Java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Define the ActionListener as an independent class
class ButtonClickActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
}

public class ButtonClickListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Click Me");

        // Create an instance of the listener and add it to the button
        ButtonClickActionListener listener = new ButtonClickActionListener();
        button.addActionListener(listener);

        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
```

## MouseEvent & MouseListener

To implement MouseListener, we need to override these 5 functions:

```Java
public void mouseClicked(MouseEvent e); 
public void mouseEntered(MouseEvent e);
public void mouseExisted(MouseEvent e); 
public void mousePressed(MouseEvent e);
public void mouseReleased(MouseEvent e);
```

Even if you don’t use all 5 MouseEvents, you must provide an implementation of the (implicitly abstract) methods. But for those you are not going to use, you can simply leave a blank implementation.

```Java
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Define the MouseListener as an independent class
class PanelMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked at X: " + e.getX() + " Y: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Implement if needed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Implement if needed
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Implement if needed
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Implement if needed
    }
}

public class MouseEventListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseListener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();

        // Create an instance of the listener and add it to the panel
        PanelMouseListener listener = new PanelMouseListener();
        panel.addMouseListener(listener);

        frame.add(panel);
        frame.setVisible(true);
    }
}
```

## repaint method

repaint() is an inherited instance method for all JPanel objects. Calling a JPanelObject.repaint() calls the paintComponent() method. Every time you wish to change the appearance of your JPanel, you must call repaint().

Below is a code example of repainting JPanel with random colors:

```Java
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

class CustomColorPanel extends JPanel {
    private Color bgColor = Color.LIGHT_GRAY;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(bgColor); // Use the current background color
    }

    // Change color method
    public void changeColor() {
        bgColor = new Color(new Random().nextInt(0xFFFFFF));
        repaint(); // Request to repaint this panel
    }
}

class ColorChangeMouseAdapter extends MouseAdapter {
    private final CustomColorPanel panel;

    public ColorChangeMouseAdapter(CustomColorPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panel.changeColor();
    }
}

public class RepaintExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Repaint Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        CustomColorPanel colorPanel = new CustomColorPanel();
        colorPanel.addMouseListener(new ColorChangeMouseAdapter(colorPanel));

        frame.add(colorPanel);
        frame.setVisible(true);
    }
}
```

## Dialogs

A Diaglog window is an independent sub window to carry temporary notice apart from the main Sing Application Window. Most Dialogs presents an error message, or warning to users, can also presents images, or anything compatible with the main Swing Application.

To create a simple, standard dialog, we can use JOptionPane class. Every dialog depends on a Frame component. When that Frame is destroyed, so are its dependent Dialogs.

A Dialog created by JOptionPane is modal. When a modal Dialog is visible, it blocks user input to all other windows in the program. 

```Java
JOptionPane.showMessageDialog(frame, 
    "A message",
    "Warning type", 
    JOptionPane.WARNING_MESSAGE);
```