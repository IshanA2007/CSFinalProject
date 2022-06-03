import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Boss2Background{
    private BufferedImage bckImg, EckImage;
    int w;
    int h;
    int w1, h1, ew, eh;
    int xPoints[], yPoints[];
    Eck eck;
    
    public Boss2Background(){
      eck = new Eck();
      try{
         File bckgrndImg = new File("boss.jpg");
         bckImg = ImageIO.read(bckgrndImg);
         w1 = bckImg.getWidth(null);
         h1 = bckImg.getHeight(null);
         
         File eckImg = new File("Eck.png");
         EckImage = ImageIO.read(eckImg);
         ew = EckImage.getWidth(null);
         eh = EckImage.getHeight(null);
         
         
      }
      catch (IOException e){
         System.exit(1);
      }
      xPoints = new int[3];
      yPoints = new int[3];
      
      xPoints[0] = 490;
      xPoints[1] = 490;
      xPoints[2] = 630;
      yPoints[0] = 560;
      yPoints[1] = 580;
      yPoints[2] = 600;

     
    }
   
   
      
    
   public void draw(Graphics g){
      
      g.drawImage(bckImg, 0, 0, w1, 700, null);
      g.setFont(new Font("Purisa", Font.BOLD, 35));
      g.drawString("Boss Health: " + eck.health, 250, 50);
   }
   
   public void drawWelcome(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(EckImage, 520, 500, 700, 700,ew, 0, 0, eh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Let's start off easy shall we?", 60, 570);
      g.drawString("Try to survive my deadly charge barrage.", 60, 590);
      g.drawString("Get ready mortal, here I come!", 60, 610);

   }
   
   public void drawEck(Graphics g){
      eck.draw(g);
   }
   
   public int getEckHealth(){
      return eck.health;
   }
   
   public void moveEck(int playerX, int playerY, boolean charge, Boss2Scene urmom){
      int moveX = 0;
      int moveY = 0;
      if(charge){
         if(eck.getX() - playerX > 10){
            moveX = -1;
         }
         else if(eck.getX() - playerX < -10){
            moveX = 1;
         }
         if(eck.getY() - playerY > 10){
            moveY = -1;
         }
         else if(eck.getY() - playerY < -10){
            moveY = 1;
         }
            
         eck.move(moveX, moveY);
      }
      if(Math.abs(eck.getX() - playerX) <= 15 && Math.abs(eck.getY() - playerY) <= 15){
         urmom.stats.health -= (int)(2*(1-(urmom.stats.shield/100)));
      }
   }
   
   public void getAttacked(int playerX, int playerY, int playerDmg, Boss2Scene boss){
      if(Math.abs((eck.getX()+(eck.ew/2)) - (playerX+boss.player.w/2)) <= 30 && Math.abs((eck.getY()+(eck.eh/2)) - (playerY+boss.player.h/2)) <= 30){
         eck.health -= playerDmg/2;
      }
   }
   
   
      
}