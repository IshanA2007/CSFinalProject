import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class TutorialBackground{
   public int stage;
   public int speakStage;
   BufferedImage image;
   int w, h;
   int[] xPoints;
   int[] yPoints;
   
   public TutorialBackground(){
      stage = 0;
       try{
         File stillImg = new File("face.png");
         image = ImageIO.read(stillImg);
         
         w = image.getWidth(null);
         h = image.getHeight(null);
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
   
   public void drawMoves(Graphics g, boolean display){
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, 700, 700);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      if(display){
         g.drawString("Bckgrnd 1", 250, 250);
      }
      
      
   }
   
   public void drawWeapons(Graphics g, boolean display){
      g.setColor(Color.RED);
      g.fillRect(0, 0, 700, 700);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      if(display){
         g.drawString("Bckgrnd 2", 250, 250);
      }
      
   }
   
   public void drawObjective(Graphics g, boolean display){
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 700, 700);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      if(display){
         g.drawString("Bckgrnd 3", 250, 250);
      }
      
   }
   public void drawMoveSpeech(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(image, 560, 500, 700, 700,0, 0, w, h, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Press 'w' to move forward, 's' to move back", 60, 570);
      g.drawString("and 'a' and 'd' to move sideways!", 60, 590);
      g.drawString("Try moving around a bit till you're comfortable, then press E to close!", 60, 610);
   }
   
   public void drawWeaponSpeech(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(image, 560, 500, 700, 700,0, 0, w, h, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("You can buy weapons to increase your damage against enemies!", 60, 570);
      g.drawString("You can also get armor/shields to reduce damage you receive!", 60, 590);
      g.drawString("These items can be purchased at the shop house, check it out!", 60, 610);
      g.drawString("Press E to close", 60, 630);
      
   }
   
   public void drawObjectiveSpeech(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(image, 560, 500, 700, 700,0, 0, w, h, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Your goal in this game is to defeat the boss", 60, 570);
      g.drawString("The boss is very powerful; it will take a lot to defeat him.", 60, 590);
      g.drawString("...His name..is the Eck. Good luck young adventurer!", 60, 610);
      g.drawString("Press E to close", 60, 630);
   }
   
   
}
   
   