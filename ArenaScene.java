import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ArenaScene extends JPanel{
   PlayerStats stats;
   ArenaBackground bckg; 
   BufferedImage myImage;
   Graphics myBuffer;
   Player player;
   Timer t;
   public int stage;
   public int playerVelocityX;
   public int playerVelocityY;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public int count = 0;
   public boolean increaseVelocityLeft = true;
   public boolean attack = false;
   public boolean isOver = false;
   MasterGUI f;

   
   
   
   public ArenaScene(PlayerStats pstats, MasterGUI master){
      f = master;
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      stats = pstats;
      player = new Player();
      stage = pstats.combStage;
      bckg = new ArenaBackground(stage, this);
      player.style = "still";
      t = new Timer(5, new AnimationListener());
      //debug
      

      addKeyListener(new Key());
      setFocusable(true);
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   
   


    public void paintComponent(Graphics g)  //The same method as before!
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
   
   public void animate(){
      //debug  
      bckg.draw(myBuffer);
      player.draw(myBuffer, player.style, stats.health, true, stats.curWeapon(), stats.money, stats.shield);
      player.move(playerVelocityX, playerVelocityY);
      //add a curWeapon function!!! so much effort :c (for getWEaponDamage) will also help with toolbar
      if(attack){
         bckg.getAttacked(player.rectX, player.rectY, attack, stats.getWeaponDamage(stats.curWeapon()));
      }
      bckg.archerAttack(player.rectX, player.rectY, myBuffer);
      stats.health -= bckg.swordsmenAttack(player.rectX, player.rectY);
      stats.health -= bckg.archerAttackDamage(player.rectX, player.rectY);
      
      if(stats.health <= 0){
         myBuffer.setColor(Color.BLACK);
         myBuffer.fillRect(0, 0, 700, 700);
         isOver = true;
      }
      else if(bckg.levelCleared()){
         myBuffer.setColor(Color.BLACK);
         myBuffer.fillRect(0, 0, 700, 700);
         myBuffer.setColor(Color.WHITE);
         myBuffer.setFont(new Font("Purisa", Font.BOLD, 30));
         myBuffer.drawString("Level Cleared!", 250, 250);
         myBuffer.setFont(new Font("Purisa", Font.BOLD, 15));
         myBuffer.drawString("Press 'E' to exit", 250, 500);
      }
      else{
         if(stats.health < 100){
            count+= 1;
            if(count%5 == 0){
               stats.health += 1;
            }
         }
      }      
      repaint();
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
         else if(e.getKeyCode() == KeyEvent.VK_L){
            stats.saveStats();
         }
         else if(e.getKeyCode()== KeyEvent.VK_SPACE){
            attack = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_E){
            if(playerVelocityX == 0 && playerVelocityY == 0 && bckg.levelCleared()){
               stats.combStage += 1;
               f.changeArenaToStart();
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
         else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            attack = false;
         }
         
         
         
         
         
      }
   }
}
      
   
   
      
      