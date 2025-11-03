package unit1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class MyComponent extends JComponent {
  private BufferedImage img;

  public MyComponent() {
    // load image once in the constructor
    try {
      img = ImageIO.read(new File("C:/Users/Aayush/Desktop/Advance java programming/word-free-colorful-free-typography-isETwb4y_t.webp"));
    } catch (IOException e) {
      System.err.println("Could not load image: " + e.getMessage());
      img = null;
    }
    setPreferredSize(new Dimension(400, 400));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    if (img != null) {
      g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    } else {
      g2d.setColor(Color.LIGHT_GRAY);
      g2d.fillRect(0, 0, getWidth(), getHeight());
      g2d.setColor(Color.BLACK);
      g2d.drawString("Image not available", 10, 20);
    }
  }
}

public class day10 extends JFrame {
  public day10() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new MyComponent());
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> new day10());
  }
}
