import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Boss3Background{
    private BufferedImage bckImg, EckImage;
    int w;
    int h;
    int w1, h1, ew, eh;
    int xPoints[], yPoints[];
    Eck eck;
    public ArrayList<Minion> minions;
    public Boss3Background(){
      eck = new Eck();
      minions = new ArrayList<Minion>();
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
   
   public void eckAttack(int playerX, int playerY, Boss3Scene boss){
      if(Math.abs(eck.getX() - playerX) <= 10 && Math.abs(eck.getY() - playerY) <= 10){
         if(minions.size() == 1){
            minions.remove(0);
         }
         boss.stats.health -= 2;
         
      }
     
      else{
         if(minions.size() == 1){
            minions.get(0).draw(boss.myBuffer);
            minions.get(0).move(playerX, playerY);
            if(Math.abs(minions.get(0).getX() - playerX) <= 10 && Math.abs(minions.get(0).getY() - playerY) <= 10){
               boss.stats.health -= 1;
            }
            if(minions.get(0).getHealth() <= 0){
               minions.remove(0);
            }
         }
         if(minions.size() == 0){
            minions.add(new Minion(eck.getX()-20, eck.getY()));
         }
      }
   }
   
   public void drawWelcome(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(EckImage, 520, 500, 700, 700,ew, 0, 0, eh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Wow, I'm somewhat impressed.", 60, 570);
      g.drawString("Why defeat you myself when I can summon my MINIONS", 60, 590);
      g.drawString("Try fighting the ecksters! Mwahahahahaha", 60, 610);

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
      if(Math.abs(eck.getX() - playerX) <= 10 && Math.abs(eck.getY() - playerY) <= 10){
         urmom.stats.health -= eck.getDmg();
      }
   }
   
   public void getAttacked(int playerX, int playerY, int playerDmg){
      if(Math.abs(eck.getX() - playerX) <= 7 && Math.abs(eck.getY() - playerY) <= 7){
         eck.health -= playerDmg/2;
      }
      else if(minions.size() == 1 && Math.abs(minions.get(0).getX() - playerX) <= 10 && Math.abs(minions.get(0).getY() - playerY) <= 10){
         minions.get(0).health -= playerDmg;
      }
   }
   
   
      
}