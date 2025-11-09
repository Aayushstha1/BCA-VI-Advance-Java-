import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jpanel {
    public static void main(String[] args) {
        JFRAME f = new JFRAME("Example");
        f.setSize (200 , 300);
        f.setDefaultCloseOperation(JFRAME.EXIT_ON_CLOSE);
        f.setLayout(null);

        Jpanel p = new Jpanel();
        p.setBounds(0,0,400,200);
        p.setBackground(Color.CYAN);
        JButton b = new JButton("Click");
        b.setBackground(Color.blue);
        p.add(b)
        f.add(p);
        f.setVisible(true);




    }
}
