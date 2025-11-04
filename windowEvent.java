package unit1;
import java.awt.*;
import java.awt.event.WindowEvent;

public class windowEvent {
    windowEvent(){
        JFRAME f = new JFRAME("windowEvent Example");
        f.setLayout (null) ;
        f.setSize(300, 300);
        f.setDefaultCloseOperation( JFRAME.EXIT_ON_CLOSE);
        f.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened (WindowEvent e) {
                System.out.println("window opened");
            }
            @Override
            public void windowClosing(WindowEvent e ){
                System.out.println("window closing");
            }
            @Override
            public void windowClosed(WindowEvent e ){
                System.out.println("window closed");
            }
            @Override
            public void windowIconified(WindowEvent e ){
                System.out.println("window iconified");
            }
            @Override
            public void windowDeconified(WindowEvent e ){
                System.out.println("window deiconified");
            }
            
            @Override
            public void windowActivated(WindowEvent e ){
                System.out.println("window activated");
            }
            @Override
            public void windowDeactivated(WindowEvent e ){
                System.out.println("window deactivated");
            }

        });
        f.setVisible(true);
    }
    public static void main(String[] args){
        new windowEvent();
    }
    
}
