import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextAreaExample {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JTextArea ta = new JTextArea();
        ta.setBounds(20, 200, 100, 300);
        f.add(ta);
        f.setVisible(true);
    }
    
}
