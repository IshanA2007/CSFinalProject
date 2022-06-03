import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
public class FarmScene extends JPanel{
   PlayerStats stats;
   BufferedImage myImage;
   Graphics myBuffer;
   Player player;
   ArrayList<Vegetable> veggies;
   FarmBackground bckg;
   public boolean harvestCrops;
   public int count = 0;
   public boolean isOver = false;
   public boolean showInfo = false;
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   private Timer t;
   MasterGUI f;
   
   
   
   public FarmScene(PlayerStats pstats, MasterGUI master){
      f = master;
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      t = new Timer(5, new AnimationListener());
      player = new Player();
      stats = pstats;
      veggies = new ArrayList<Vegetable>();
      player.style = "still";
      bckg = new FarmBackground(0);
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();

      
   }
   
   public void begin(){
      t.start();
   }
   
   public void generateVeggies(){
      count += 1;
      if(count%30  == 0){
         veggies.add(new Carrot());
      }
      if(count%60==0){
         veggies.add(new Potato());
      }
      
   }
   
   public void collectVeggies(){
      for(int i = 0; i < veggies.size(); i++){
         int val = veggies.get(i).getVal();
         stats.money += val;
         veggies.remove(i);
      }
         
   }
   public int getNumCarrots(){
      int count = 0;
      for(int i = 0; i < veggies.size(); i++){
         if(veggies.get(i).getVal() == 2){
            count++;
         }
      }
      return count;
   }
   public int getNumPotatoes(){
      int count = 0;
      for(int i = 0; i < veggies.size(); i++){
         if(veggies.get(i).getVal() == 5){
            count++;
         }
      }
      return count;
   }
   
   public void animate(){
      bckg.draw(myBuffer, player.rectX, player.rectY, getNumCarrots(), getNumPotatoes());
      bckg.moveBackground((int)(1.5*playerVelocityX));
      generateVeggies();
      if(harvestCrops){
         collectVeggies();
      }
      player.draw(myBuffer, player.style, 100, true, stats.curWeapon(), stats.money, stats.shield);
      player.move(playerVelocityX, playerVelocityY);
      
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
         else if(e.getKeyCode() == KeyEvent.VK_R){
            harvestCrops = true;
         }
         
         else if(e.getKeyCode() == KeyEvent.VK_E){
            if(playerVelocityX == 0 && playerVelocityY == 0){
               f.changeFarmToStart();
            }
         }
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerVelocityX -= 3;
            increaseVelocityRight = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_R){
            harvestCrops = false;
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
