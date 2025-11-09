import javax.swing.*;

public class RadioButtonExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Radio Button Example");
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        JRadioButton r1, r2;
        r1 = new JRadioButton("Male");
        r1.setBounds(100, 50, 100, 30);
        r2 = new JRadioButton("Female");
        r2.setBounds(100, 100, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        f.add(r1);
        f.add(r2);

        f.setVisible(true);
        
    }
    
}
