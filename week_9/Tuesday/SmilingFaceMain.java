import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SmilingFace extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 200, 200);

        // draw Eyes
        g.setColor(Color.BLACK);
        g.fillOval(55, 65, 30, 30);
        g.fillOval(135, 65, 30, 30);

        // draw Mouth
        g.fillOval(50, 110, 120, 60);

        // adding smile
        g.setColor(Color.YELLOW);
        g.fillRect(50, 110, 120, 30);
        g.fillOval(50, 120, 120, 40);
    }
}

public class SmilingFaceMain{
    public static void main(String[] args) {
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        app.add(new SmilingFace());
        app.setSize(300, 300);
        app.setVisible(true);
    }
}