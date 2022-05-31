import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class BossScene extends JPanel{

   BufferedImage myImage;
   Graphics myBuffer;
   private Timer t;
   BossBackground bckground;
   private boolean space;
   public int count = 0;
   public boolean fightPress = true;
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   Player player;
   PlayerStats stats;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   public int doorNum = 0;
   public boolean isOver = false;
   MasterGUI f;
   public boolean fight = false;
   public BossScene(PlayerStats pStats, MasterGUI master){
      f = master;
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(Color.WHITE);   
      myBuffer.fillRect(0, 0, 700, 700);
      bckground = new BossBackground(0);
      player = new Player();
      player.style = "still";
      stats = pStats;
      t = new Timer(5, new AnimationListener());
      stats.setDamage(stats.getWeaponDamage(stats.curWeapon()));
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   
   public PlayerStats getStats(){
      return stats;
   }
   
   public void animate(){
      bckground.draw(myBuffer);
      if(count <= 500){
         bckground.drawWelcome(myBuffer);
      }
      else if(count <= 1000){
         bckground.drawNoEscape(myBuffer);
      }
      else if(count <= 1500){
         bckground.drawFightMe(myBuffer);
      }
      else if(count > 2000){
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Purisa", Font.BOLD, 35));
         myBuffer.drawString("Press 'E' to fight!", 250, 350);
      }      
      
      count+= 1;
      
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
            player.style = "right";
            playerVelocityX += 3;
            increaseVelocityRight = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT && increaseVelocityLeft){
            player.style = "left";
            playerVelocityX -= 3;
            increaseVelocityLeft = false;
         }
         else if(count > 2000 && e.getKeyCode() == KeyEvent.VK_E){
            f.changeBoss1Boss2();
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
      }
   }
}