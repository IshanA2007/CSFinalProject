import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;



public class ShopScene extends JPanel{   
   BufferedImage myImage;
   Graphics myBuffer;
   static PlayerStats stats;
   Player player;
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   private Timer t;
   ShopBackground bckg;
   public boolean buyItem = true;   
   MasterGUI f;
   Door door;

   public ShopScene(PlayerStats pstats, MasterGUI master)
   {
      door = new Door(340, 100);
      f = master;
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      t = new Timer(5, new AnimationListener());
      player = new Player();
      stats = pstats;
      player.style = "still";
      bckg = new ShopBackground(stats);
      addKeyListener(new Key());
      setFocusable(true);
      
      requestFocus();
      
     
      begin();
   }
   
   public void begin(){
      t.start();
   }
   public void checkDoorText(int playerX, int playerY){
      if(door.nextToADoor(playerX, playerY, 0)){
            myBuffer.setFont(new Font("Purisa", Font.BOLD, 15));
            myBuffer.setColor(Color.WHITE);
            myBuffer.drawString("Press 'J' to exit!", door.getX()-5, door.getY()-5);
         }
      }
   

   public void animate(){
      
      bckg.draw(myBuffer, player.rectX, player.rectY);
      player.draw(myBuffer, player.style, 100, true, stats.curWeapon(), stats.money, stats.shield);
      player.move(playerVelocityX, playerVelocityY);
      door.draw(myBuffer, 0);
      checkDoorText(player.rectX, player.rectY);
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
         else if(e.getKeyCode() == KeyEvent.VK_B && buyItem){
            if(player.rectX > 150 && player.rectX < 250 && player.rectY > 100 && player.rectY<500){
               if(stats.money >= 500){
                  stats.money -= 500;
                  stats.weapons.add("Spear");
               }
               
            }
            if(player.rectX > 300 && player.rectX < 400 && player.rectY > 250 && player.rectY<350){
               if(stats.money >= 200){
               stats.money -= 200;
               stats.weapons.add("Sword");
               }
            }
            if(player.rectX > 450 && player.rectX < 550 && player.rectY > 250 && player.rectY < 350){
               if(stats.money >= 1000){
               stats.weapons.add("Hammer");
               stats.money -= 1000;
               }
            }
            if(player.rectX > 200 && player.rectX < 300 && player.rectY > 400 && player.rectY < 500){
               if(stats.money >= 2000){
               stats.setShield(90);
               stats.money -= 2000;
               }
            }
           
            if(player.rectX > 400 && player.rectX < 500 && player.rectY > 400 && player.rectY < 500){
               if(stats.money >= 500){
               stats.setShield(40);
               stats.money -= 500;
               }
            }
   
            buyItem = false;
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
         else if(e.getKeyCode() == KeyEvent.VK_L){
            stats.saveStats();
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN && increaseVelocityDown){
            player.style = "down";
            playerVelocityY += 4;
            increaseVelocityDown = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_J){
            if(playerVelocityX == 0 && playerVelocityY == 0){
               if(door.nextToADoor(player.rectX, player.rectY, 0)){
                  f.changeShopToStart();
               }
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
         else if(e.getKeyCode() == KeyEvent.VK_B){
            buyItem = true;
         }
      }
   }




}