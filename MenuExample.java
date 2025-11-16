import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuExample {
    public static void main(String[] args) {
          JFrame f = new JFrame("Example");
        f.setSize(300 , 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JMenuBar br = new JMenuBar();
        JMenu m = new JMenu("Home");
        JMenu s = new JMenu("Other");
        JMenuItem i1,i2,i3,i4,i5 ; 

        i1 = new JMenuItem("New");
        i2 = new JMenuItem("Save");
        i3 = new JMenuItem("Delete");
        i4 = new JMenuItem("copy");
        i5 = new JMenuItem("   Paste");

        m.add(i1);
        m.add(i2);
        m.add(i3);
        m.add(s);
        m.add(i4);
        m.add(i5);
        br.add(m);
        f.setJMenuBar(br);
        f.setVisible(true);
      

    }
}
