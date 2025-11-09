import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
 

public class JLable {
    public static void main(String[] args) {
        JFrame f = new JFrame("JLabel Example");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JPanel p = new JPanel();
        p.setBounds(50, 50, 200, 30);
        p.setBackground(Color.YELLOW);
        p.setOpaque(true);

        JLabel l = new JLabel("MY JLabel Example");
        p.add(l);
        f.add(p);

        f.setVisible(true);
    }
}


// import javax.swing.*;
// import java.awt.*;

// public class JLable {
//     public static void main(String[] args) {
//         EventQueue.invokeLater(() -> {
//             JFrame f = new JFrame("JLabel Example");
//             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             f.setLayout(null);  

//             JPanel p = new JPanel();
//             p.setBounds(50, 50, 200, 30);
//             p.setBackground(Color.YELLOW);
//             p.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));

//             JLabel l = new JLabel("My JLabel Example");
//             l.setForeground(Color.BLUE);  // Make text blue for visibility on yellow
//             p.add(l);
            
//             f.add(p);
//             f.setSize(400, 400);
//             f.setLocationRelativeTo(null);
//             f.setVisible(true);
//         });
//     }
// }
