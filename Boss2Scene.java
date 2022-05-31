import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Boss2Scene extends JPanel{

   BufferedImage myImage;
   Graphics myBuffer;
   private Timer t;
   Boss2Background bckground;
   private boolean space;
   public int count = 0;
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
   public boolean attack = false;
   public Boss2Scene(PlayerStats pStats, MasterGUI master){
      f = master;
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(Color.WHITE);   
      myBuffer.fillRect(0, 0, 700, 700);
      bckground = new Boss2Background();
      player = new Player();
      player.style = "still";
      stats = pStats;
      t = new Timer(5, new AnimationListener());
      stats.setDamage(stats.getWeaponDamage(stats.curWeapon())/2);
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   
   
   public void animate(){
      
      bckground.draw(myBuffer);
      player.draw(myBuffer, player.style, stats.health, true, stats.curWeapon(), stats.health, stats.shield);
      player.move(playerVelocityX, playerVelocityY);
      if(count <= 500){
         bckground.drawWelcome(myBuffer);
         count += 1;
      }
      else if(bckground.getEckHealth() >= 500){
         //true is the charge (for first part)
         bckground.drawEck(myBuffer);
         //moveEck also does dmg when close enuf
         bckground.moveEck(player.rectX, player.rectY, true, this);
         if(attack){
            bckground.getAttacked(player.rectX, player.rectY, stats.getWeaponDamage(stats.curWeapon()));
         }
         
      }
      
      //else{
         //f.changeBoss2Boss3();
      //}  
      count+= 1;
      repaint();  
      
   }
   
   public void paintComponent(Graphics g)  //The same method as before!
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
   
   public PlayerStats getStats(){
      return stats;
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
         else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            attack = true;
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
         else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            attack = false;
         }
      }
   }
}