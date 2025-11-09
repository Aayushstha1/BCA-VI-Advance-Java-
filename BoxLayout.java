import javax.swing.*;
import java.awt.*;

public class BoxLayout {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame("BoxLayout Example");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Create a panel with BoxLayout
            JPanel panel = new JPanel();
            panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
            
            // Add some space between components
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            // Add buttons with alignment and spacing
            for (int i = 1; i <= 5; i++) {
                JButton button = new JButton("Button " + i);
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(button);
                if (i < 5) {
                    panel.add(Box.createRigidArea(new Dimension(0, 5)));
                }
            }
            
            f.add(panel);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
