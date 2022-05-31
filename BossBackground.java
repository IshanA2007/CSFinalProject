import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class BossBackground{
    public int referenceX;
    private BufferedImage bckImg, EckImage;
    int w;
    int h;
    int w1, h1, ew, eh;
    int xPoints[], yPoints[];
    
    public BossBackground(int newRefX){
      
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

      referenceX = newRefX;
    }
   
   
      
    
   public void draw(Graphics g){
      g.drawImage(bckImg, 0-referenceX, 0, w1, 700, null);
   }
   
   public void drawWelcome(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(EckImage, 520, 500, 700, 700,ew, 0, 0, eh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("It seems the time has come. It is me.", 60, 570);
      g.drawString("I am THE ECK, the final boss of this game.", 60, 590);
      g.drawString("I am UNSTOPPABLE, you might as well give up now.", 60, 610);

   }
   
   public void drawNoEscape(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(EckImage, 520, 500, 700, 700,ew, 0, 0, eh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Too bad theres no escaping now...", 60, 570);
      g.drawString("The only way you are getting out of this is if you defeat me.", 60, 590);
      g.drawString("If you beat me, you can have these notes I stole from someone", 60, 610);

   }
   
   public void drawFightMe(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(EckImage, 520, 500, 700, 700,ew, 0, 0, eh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("But whatever, not like you could beat me anyways!", 60, 570);
      g.drawString("Prepare your puny weapons player, for you are", 60, 590);
      g.drawString("about to be DEMOLISHED! Press 'E' to fight me.", 60, 610);

   }
   
   
   public void moveBackground(int change){
       if(referenceX <= 0){
            referenceX += 5;
          }
       else if(referenceX <= 518){
          referenceX += change;
       }
       else if(referenceX > 518){
          referenceX -= 5;
       }    
    }
      
}