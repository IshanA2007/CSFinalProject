import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Boss4Background{
    private BufferedImage bckImg, EckImage;
    int w;
    int h;
    int w1, h1, ew, eh;
    int xPoints[], yPoints[];
    Eck eck;
    public ArrayList<Fireball> fireballs;
    public Boss4Background(){
      eck = new Eck();
      eck.health = 250;
      fireballs = new ArrayList<Fireball>();
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
   
   public void eckAttack(int playerX, int playerY, Boss4Scene boss){
     if(Math.abs((eck.getX()+(eck.ew/2)) - (playerX+boss.player.w/2)) <= 30 && Math.abs((eck.getY()+(eck.eh/2)) - (playerY+boss.player.h/2)) <= 30){
         boss.stats.health -= (int)(2*(1-(boss.stats.shield/100))); 
      }
     
      else{
         
         if(fireballs.size() >= 1){
            for(int i = 0; i < fireballs.size(); i++){
               fireballs.get(i).move();
               fireballs.get(i).draw(boss.myBuffer);
            }
            for(int i = 0; i < fireballs.size(); i++){
               if(Math.abs((fireballs.get(i).getX()+fireballs.get(i).w/2) - (playerX + boss.player.w/2)) <= 20 && Math.abs((fireballs.get(i).getY()+fireballs.get(i).h/2) - (playerY + boss.player.h/2)) <= 20){
                  boss.stats.health -= 5;
               }
            }
            if(fireballs.get(0).getX() <= 0){
               fireballs.clear();
               }
            }
            
            
         
         if(fireballs.size() == 0){
            fireballs.add(new Fireball(eck.getX(), 0));
            fireballs.add(new Fireball(eck.getX(), 50));
            fireballs.add(new Fireball(eck.getX(), 100));
            fireballs.add(new Fireball(eck.getX(), 150));
            fireballs.add(new Fireball(eck.getX(), 200));
            fireballs.add(new Fireball(eck.getX(), 250));
            fireballs.add(new Fireball(eck.getX(), 300));
            fireballs.add(new Fireball(eck.getX(), 350));
            fireballs.add(new Fireball(eck.getX(), 400));
            fireballs.add(new Fireball(eck.getX(), 450));
            fireballs.add(new Fireball(eck.getX(), 500));
            fireballs.add(new Fireball(eck.getX(), 550));
            fireballs.add(new Fireball(eck.getX(), 600));
            fireballs.add(new Fireball(eck.getX(), 650));
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
      g.drawString("You know what, I'm getting tired of you. It's time to finish you.", 60, 570);
      g.drawString("If you can get past my witherballs, I'll admit defeat.", 60, 590);
      g.drawString("It's over for you! Mwahahhahahahahahahahaah", 60, 610);

   }
   
   public void drawEck(Graphics g){
      eck.draw(g);
   }
   
   public int getEckHealth(){
      return eck.health;
   }
   
   public void moveEck(int playerX, int playerY, boolean charge, Boss4Scene urmom){
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
         urmom.stats.health -= eck.getDmg();
      }
   }
   
   public void getAttacked(int playerX, int playerY, int playerDmg, Boss4Scene boss){
      if(Math.abs((eck.getX()+(eck.ew/2)) - (playerX+boss.player.w/2)) <= 20 && Math.abs((eck.getY()+(eck.eh/2)) - (playerY+boss.player.h/2)) <= 20){
         eck.health -= playerDmg/2;
      }
   }
   
   
      
}