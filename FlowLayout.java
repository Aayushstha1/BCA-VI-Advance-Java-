
package unit1;

import javax.swing.*;

public class FlowLayout {
    public static void main(String[] args) {
        JFrame f = new JFrame("FlowLayout Example");
        // use fully-qualified java.awt.FlowLayout so it doesn't refer to this class
        f.setLayout(new java.awt.FlowLayout());
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 1; i <= 5; i++) {
            f.add(new JButton("Button " + i));
        }
        f.setVisible(true);
    }

}
