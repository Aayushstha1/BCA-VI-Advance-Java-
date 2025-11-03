package unit1;

import java.awt.*;
import javax.swing.*;

public class day11 extends JFrame {
    public day11() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Try to load the image; use forward slashes or escaped backslashes on Windows
        ImageIcon icon = new ImageIcon("C:/Users/Aayush/Desktop/Advance java programming/1.jpg");

        JLabel label;
        if (icon.getIconWidth() <= 0) {
            label = new JLabel("Image not available");
            label.setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            label = new JLabel(icon);
        }

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        pack();
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new day11());
    }
}
