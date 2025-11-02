import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

class MyComponent extends JComponent{
  @Override
  protected void paintComponent(Graphics g ){
    Graphics2D g2d = (Graphics2D) g ;
    Front serifFont = new Font("Serif" , Font.PLAIN , 24);
    g2d.setColor(Color.BLACK);
    g2d.setFont(serifFont);
    g2d.drawString("My Front", 10 , 40 );
    try {
        Font CustomFont = Font.createFont(Font.TRUETYPE_FONT, null)

    }
    catch(FrontFormatException | )

    public class MyPaint2 {
    
}
