import javax.swing.JButton;

public class BorderLayout {
    public static void main (String[] args)
    JFRAME f = new JFRAME("Border Layout  Example");
        f.setLayout (new BorderLayout()) ;
        f.setSize(300, 300);
        f.setDefaultCloseOperation( JFRAME.EXIT_ON_CLOSE);
        f.add(new JButton("North"), BorderLayout.NORTH);
        f.add(new JButton("South"), BorderLayout.SOUTH);
        f.add(new JButton("East"), BorderLayout.EAST);
        f.add(new JButton("West"), BorderLayout.WEST);
        f.add(new JButton("Center"), BorderLayout.CENTER);
        
            f.setVisible(true);

}
