import javax.swing.*;
import java.awt.event.*;

public class FrameDialog {
    public static void main(String[] args) {
        JFrame f = new JFrame("Example");
        f.setSize(300 , 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JButton b = new JButton("CLICK");
        b.setBounds(100, 50, 80, 30);
        f.add(b);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JDialog d = new JDialog(f, "Add Two Numbers", true);
                d.setLayout(null);
                d.setSize(260, 200);

                JLabel l1 = new JLabel("Number 1:");
                l1.setBounds(10, 10, 80, 25);
                d.add(l1);
                JTextField t1 = new JTextField();
                t1.setBounds(90, 10, 120, 25);
                d.add(t1);

                JLabel l2 = new JLabel("Number 2:");
                l2.setBounds(10, 45, 80, 25);
                d.add(l2);
                JTextField t2 = new JTextField();
                t2.setBounds(90, 45, 120, 25);
                d.add(t2);

                JButton add = new JButton("Add");
                add.setBounds(40, 90, 70, 30);
                d.add(add);

                JLabel res = new JLabel("");
                res.setBounds(10, 130, 220, 25);
                d.add(res);

                add.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ev){
                        try{
                            double a = Double.parseDouble(t1.getText());
                            double b = Double.parseDouble(t2.getText());
                            double s = a + b;
                            res.setText("Sum: " + s);
                        }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(d, "Enter valid numbers");
                        }
                    }
                });
                d.setLocationRelativeTo(f);
                d.setVisible(true);
            }
        });
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
} 

