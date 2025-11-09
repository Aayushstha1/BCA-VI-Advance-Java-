import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextFieldExample {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new java.awt.FlowLayout());
        JTextField t1 , t2 ;
        t1 = new JTextField("First Name");
        t1.setBounds(10, 60, 150, 30);
        t2 = new JTextField("Last Name");
        t2.setBounds(10, 60, 150, 30);

        f.add(t1);
        f.add(t2);
        f.setVisible(true);


       
    }
}
