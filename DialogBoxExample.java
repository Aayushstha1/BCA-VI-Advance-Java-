package Unit1;

import javax.swing.*;
import java.awt.event.*;

public class DialogBoxExample {

    public static void main(String[] args) {
        JFRAME f = new JFRAME("Example");
        f.setSize(300 , 300);
        f.setDefaultCloseOperation(JFRAME.EXIT_ON_CLOSE);
        f.setLayout(null);

        JButton b1 = new JButton("CLICK!");
        b1.setBounds(50, 50, 40, 40);
        f.add(b1);

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JDialog d = new JDialog();
                d.setBounds(50, 50, 150, 250);
                                JLa bel l = new JLabel("This is your dialog box");
                                l.setBounds(10, 10, 120, 20);
                                d.add(l);
                d.setVisible(true);
            }
        }
            
        );
                f.setVisible(true);
  }
}