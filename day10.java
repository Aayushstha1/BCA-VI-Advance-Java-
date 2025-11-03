package unit1;
import javax.awt.*;
import javax.swing.*;
class MyComponent extends JComponent {
  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    image img = ImageIO.read(new File("path/to/image.jpg"));
    g2d.drawImage(img, 0, 0, this);
  }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);

  }
}

public class day10 extends JFrame {
  public day10() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MyComponent mComponent = new MyComponent();
    add(mComponent);
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> new day10());
  }
    
}
