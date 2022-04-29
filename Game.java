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
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   Player player;
   
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   
   public Game(){
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(Color.WHITE);   
      myBuffer.fillRect(0, 0, 700, 700);
      bckground = new StartingBackground(0);
      player = new PlayerStandingStill();
      
      
      t = new Timer(5, new AnimationListener());
      
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   
   public void animate(){
      bckground.draw(myBuffer);
      bckground.moveBackground(2*playerVelocityX);
      /*
      if(playerVelocityX > 0){
         player = new PlayerMovingRight();
      }
      else if(playerVelocityX < 0){
         player = new PlayerMovingLeft();
      }
      */
      player.draw(myBuffer);
      player.move(playerVelocityX, playerVelocityY);
      
      
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
      
   private class Key extends KeyAdapter{
      public void keyPressed(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_RIGHT && increaseVelocityRight){
            playerVelocityX += 8;
            increaseVelocityRight = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT && increaseVelocityLeft){
            playerVelocityX -= 8;
            increaseVelocityLeft = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP && increaseVelocityUp){
            playerVelocityY -= 8;
            increaseVelocityUp = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN && increaseVelocityDown){
            playerVelocityY += 8;
            increaseVelocityDown = false;
         }
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerVelocityX -= 8;
            increaseVelocityRight = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playerVelocityX += 8;
            increaseVelocityLeft = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP){
            playerVelocityY += 8;
            increaseVelocityUp = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            playerVelocityY -= 8;
            increaseVelocityDown = true;
         }
      }
   }
}
