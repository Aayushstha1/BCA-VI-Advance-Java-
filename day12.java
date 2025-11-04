package unit1;
import javax.swing.*;

public class day12 {
    day12(){
        JFrame f = new JFrame("EventHandling");
        f.setSize(300, 300);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Click Me");
        b.setBounds(100, 100, 100, 50);
        f.add (b);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e ) {
                system.out.println("Button pressed !") ;
            }
        }

        
        
        );
        f.setVisible(true);


    }
    
}
