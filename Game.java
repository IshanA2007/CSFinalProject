import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Game extends JPanel{

   BufferedImage myImage;
   Graphics myBuffer;
   private Timer t;
   StartingBackground bckground;
   private boolean space;
   public int count = 0;
   
   public Game(){
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(Color.WHITE);   
      myBuffer.fillRect(0, 0, 700, 700);
      bckground = new StartingBackground(0);
      
      t = new Timer(5, new AnimationListener());
      
      
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   
   public void animate(){
      bckground.draw(myBuffer);
      if(count < 400){
         
         bckground.moveBackground(5);
         count++;
      }
      else{
         
         bckground.moveBackground(-5);
      }
      repaint();
   }
   
   public void paintComponent(Graphics g)  //The same method as before!
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
   
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }
      
}
