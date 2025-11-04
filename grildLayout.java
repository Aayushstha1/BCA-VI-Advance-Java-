import javax.swing.JFrame;

public class grildLayout {
     JFrame f = new JFrame("Layout Example");
        // use fully-qualified java.awt.FlowLayout so it doesn't refer to this class
        f.setLayout(new java.awt.FlowLayout());
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
