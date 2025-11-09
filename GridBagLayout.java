import javax.swing.*;
import java.awt.*;

public class GridBagLayout {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame("GridBagLayout Example");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new java.awt.GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(4, 4, 4, 4); // Add some padding

            // Button 1 - Takes 2 columns
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.weightx = 1.0;
            f.add(new JButton("Button 1 (2 cols)"), gbc);

            // Button 2
            gbc.gridx = 2;
            gbc.gridwidth = 1;
            f.add(new JButton("Button 2"), gbc);

            // Button 3 - Takes 2 rows
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridheight = 2;
            gbc.weighty = 1.0;
            f.add(new JButton("Button 3 (2 rows)"), gbc);

            // Button 4
            gbc.gridx = 1;
            gbc.gridheight = 1;
            gbc.weighty = 0.5;
            f.add(new JButton("Button 4"), gbc);

            // Button 5
            gbc.gridx = 2;
            f.add(new JButton("Button 5"), gbc);

            // Button 6
            gbc.gridx = 1;
            gbc.gridy = 2;
            f.add(new JButton("Button 6"), gbc);

            // Button 7
            gbc.gridx = 2;
            f.add(new JButton("Button 7"), gbc);

            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
