import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MouseAdapter {
    public static void main (String[] args){
        JFRAME f = new JFRAME( "MouseAdapter Example "); 
        f.setLayout (null) ;
        f.setSize(300, 300);
        f.setDefaultCloseOperation( JFRAME.EXIT_ON_CLOSE);
        JLabel l = new JLabel("Click anywhere ");
        l.setBounds(100 , 100 , 20);
        f.addMouseListener(new MouseAdapter(){

            
        })
    }
    
}
