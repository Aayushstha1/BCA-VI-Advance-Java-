// how can we draw on a JFrame using JComponent — simple example
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;

class MyComponent extends JComponent {
  public MyComponent(){
    // give a preferred size so pack() will size the frame
    setPreferredSize(new Dimension(240, 180));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.RED);
    g2d.fillOval(10, 10, 100, 100);
  }
}

public class MyPaint extends JFrame {
  public MyPaint(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MyComponent mComponent = new MyComponent();
    add(mComponent);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args){
    EventQueue.invokeLater(() -> new MyPaint());
  }
}