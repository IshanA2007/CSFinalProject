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
   public boolean increaseVelocityLeft = true;
   public boolean attack = false;
   public boolean isOver = false;

   
   
   
   public ArenaScene(PlayerStats pstats){
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      stats = pstats;
      player = new Player();
      stage = pstats.combStage;
      bckg = new ArenaBackground(stage);
      player.style = "still";
      t = new Timer(5, new AnimationListener());
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
      if(bckg.levelCleared()){
         isOver = true;
      }
      
      bckg.draw(myBuffer);
      player.draw(myBuffer, player.style, stats.health, true, stats.weapons);
      player.move(playerVelocityX, playerVelocityY);
      //add a curWeapon function!!! so much effort :c (for getWEaponDamage) will also help with toolbar
      bckg.getAttacked(player.rectX, player.rectY, attack, stats.getWeaponDamage("Fist"));
      bckg.archerAttack(player.rectX, player.rectY, myBuffer);
      stats.health -= bckg.swordsmenAttack(player.rectX, player.rectY);
      stats.health -= bckg.archerAttackDamage(player.rectX, player.rectY);
      
      if(stats.health <= 0){
         isOver = true;
      }
      else{
         if(stats.health < 100){
         
            stats.health += 1;
         }
      }      
      repaint();
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
      
   
   
      
      