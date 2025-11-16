public import java.awt.*;
import javax.swing.*;

public class frameDialog2 {
    public static void main(String[] args) {

f       // Create panel
      JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        // Create text panes
        JTextPane t1 = new JTextPane();
        JTextPane t2 = new JTextPane();

        // Add labels and text panes
        panel.add(new JLabel("Enter First Number:"));
        panel.add(t1);

        panel.add(new JLabel("Enter Second Number:"));
        panel.add(t2);

        // Show dialog
        int option = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Sum Calculator",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            try {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int sum = a + b;

                JOptionPane.showMessageDialog(null, "Sum = " + sum);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
            }
        }
    }
}
 {
    
}
