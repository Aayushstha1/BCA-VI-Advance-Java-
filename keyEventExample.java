package unit1;
import javax.swing.JFrame;


public class keyEventExample {
    keyEventExample(){
        JFRAME f = new JFRAME("keyEvent Example");
        f.setLayout (null) ;
        f.setSize(300, 300);
        f.setDefaultCloseOperation( JFRAME.EXIT_ON_CLOSE);

        f.addKeyListener(new addKeyListener({
            @Override
            public void keyTyed(KeyEvent e ){
                System.out.println("key typed:" + e.getKeyChar());
            }
            @Override 
            public void keyPressed (Key )
        }))
    }
    
}
