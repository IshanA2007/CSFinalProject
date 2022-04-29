import javax.swing.*;
import java.awt.*;
public class StartingBackground{
    public int referenceX;
    
    public StartingBackground(int newRefX){
      referenceX = newRefX;
    }
    
   public void draw(Graphics g){
      g.setColor(Color.GREEN);
      g.fillRect(0, 0, 700, 700);
      g.setColor(Color.RED);
      g.fillRect(0, 300, 700, 100);
      g.fillRect(400-referenceX, 0, 100, 700);
     
      g.fillRect(1100 - referenceX, 0, 100, 700);
      g.fillRect(1300-referenceX, 0, 100, 700);
      
   }
   
   public void moveBackground(int change){
      
      referenceX += change;
      
      
   }
   
   
      
}
