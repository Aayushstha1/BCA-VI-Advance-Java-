  // how cn we draw on jframe using jcomponent, demonstrate using example
  package unit1;
  import java.awt.*;
import java.awt.Component;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.jcomponent;
class MyComponent extends JComponent{
  @Override
  protected void paintComponent(Graphics g ){
    Graphics2D g2d = (Graphics2D) g ;

    g2d.setColor(Color.RED);
    g2d.fillOval(10 , 10, 100, 100);
  }


}

   public class MyPaint extends JFRAME {
    public MyPaint(){
      setDefaultCloseOperation(JFRAME.EXIT_ON_CLOSE );
      MyComponent mComponent= new MyComponent()
      add(mComponent);
      pack();
      setVisible(true);


    }
     public static void main(String args[]){
      EventQueue. invokeLater (()-> {
        new MyPaint();

      }) ;
     }
   
    
   }