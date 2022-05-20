import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class TutorialScene extends JPanel{
   BufferedImage myImage;  
   Graphics myBuffer;
   TutorialBackground bck = new TutorialBackground();
   Player player;
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   Timer t;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   public boolean increaseStage = true;
   public boolean increaseSpeakStage = true;
   public boolean dialogue1IsComplete = false;
   public boolean dialogue2IsComplete = false;
   public boolean displayText = false;
   public boolean isOver = false;
   PlayerStats stats;
   public TutorialScene(PlayerStats pStats){
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      player = new Player();
      player.style = "still";
      t = new Timer(5, new AnimationListener());
      stats = pStats;
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   public void animate(){
      if(bck.stage >= 0){
         bck.drawMoves(myBuffer, displayText, player.rectX, player.rectY);
      }
      if(bck.stage >= 1 && dialogue1IsComplete){
         bck.drawWeapons(myBuffer, displayText, player.rectX, player.rectY);
      }
      if(bck.stage >= 2 && dialogue2IsComplete){
         bck.drawObjective(myBuffer, displayText, player.rectX, player.rectY);
      }
      player.draw(myBuffer, player.style, stats.health, false, stats.curWeapon());
      player.move(playerVelocityX, playerVelocityY);
      if(bck.speakStage == 0){
         bck.drawMoveSpeech(myBuffer);
      }
      else if(bck.speakStage == 1 && bck.stage == 1){
        bck.drawWeaponSpeech(myBuffer);
      }
      else if(bck.speakStage == 2 && bck.stage == 2){
         bck.drawObjectiveSpeech(myBuffer);
      }
      else if(bck.stage == 3){
         isOver = true;
      }
      
      
      
      repaint();
   }
   
   public PlayerStats getStats(){
      return stats;
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
            player.style = "right";
            playerVelocityX += 3;
            increaseVelocityRight = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT && increaseVelocityLeft){
            player.style = "left";
            playerVelocityX -= 3;
            increaseVelocityLeft = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP && increaseVelocityUp){
            player.style = "up";
            playerVelocityY -= 4;
            increaseVelocityUp = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN && increaseVelocityDown){
            player.style = "down";
            playerVelocityY += 4;
            increaseVelocityDown = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_R && increaseStage){
            bck.stage += 1;
            increaseStage = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_E && increaseSpeakStage){
            bck.speakStage += 1;
            displayText = true;
            increaseSpeakStage = false;
            if(bck.speakStage == 1){
               dialogue1IsComplete = true;
            }
            if(bck.speakStage == 2){
               dialogue2IsComplete = true;
            }
         }
            
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerVelocityX -= 3;
            increaseVelocityRight = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playerVelocityX += 3;
            increaseVelocityLeft = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP){
            playerVelocityY += 4;
            increaseVelocityUp = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            playerVelocityY -= 4;
            increaseVelocityDown = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_R){
            increaseStage = true;
            displayText = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_E){
            increaseSpeakStage = true;
         }
         
      }
   }

  
      
      
      
      
}
