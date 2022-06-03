import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class FarmBackground{
    public int referenceX;
    private BufferedImage bckImg, CowImage, FarmerImage;
    int w;
    int h;
    int w1, h1, cw, ch, fw, fh;
    int[] xPoints;
    int[] yPoints;
    
    public FarmBackground(int newRefX){
      
      try{
         
         File bckgrndImg = new File("farm.jpg");
         bckImg = ImageIO.read(bckgrndImg);
         w1 = bckImg.getWidth(null);
         h1 = bckImg.getHeight(null);
         File cowImg = new File("urmom3.png");
         CowImage = ImageIO.read(cowImg);
         cw = CowImage.getWidth(null);
         ch = CowImage.getHeight(null);
         File farmerImg = new File("farmer.png");
         FarmerImage = ImageIO.read(farmerImg);
         fw = FarmerImage.getWidth(null);
         fh = FarmerImage.getHeight(null);         
      }
      catch (IOException e){
         System.exit(1);
      }
      referenceX = newRefX;
      xPoints = new int[3];
      yPoints = new int[3];
      
      xPoints[0] = 490;
      xPoints[1] = 490;
      xPoints[2] = 630;
      yPoints[0] = 560;
      yPoints[1] = 580;
      yPoints[2] = 600;
    }
   
   
      
    
   public void draw(Graphics g, int playerX, int playerY, int numCarrots, int numPotatoes){
      //grass
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.setColor(Color.BLACK);
      
      g.drawImage(bckImg, 0-referenceX, 0, 1218-referenceX, 752, 0, 0, w1, h1, null);
      g.drawImage(CowImage, 600-referenceX, 200, (int)(600+cw-referenceX-450), (int)((200+ch)-320), 0, 0, cw, ch, null);
      g.drawImage(FarmerImage, 525-referenceX, 200, 525+fw-referenceX, 200+fh, 0, 0, fw, fh, null);
      g.drawString("Number of Carrots: " + numCarrots, 20, 150);
      g.drawString("Number of Potatoes: " + numPotatoes, 20, 170);

      if(Math.abs(playerX - (525-referenceX)) < 40 && Math.abs(playerY - 200) < 40){
         g.setColor(Color.WHITE);
         g.fillRect(50, 550, 500, 100);
         g.fillPolygon(xPoints, yPoints, 3);
         g.drawImage(FarmerImage, 550, 500, 730, 700,0 , 0, fw, fh, null);
         g.setFont(new Font("Purisa", Font.BOLD, 13));
         g.setColor(Color.BLACK);
         g.drawString("Go visit your farm and press 'R' to harvest and 'E' to leave!", 60, 630);
         g.drawString("Your crops will automatically generate as time goes on!", 60, 610);
         g.drawString("They call me Alex the Cow Farmer because I know many cows", 60, 590);
         g.drawString("Hello I am a farmer, I know all about farming", 60, 570);
      }
      else if(Math.abs(playerX - (600-referenceX)) < 40 && Math.abs(playerY - 200) < 40){
         g.setColor(Color.WHITE);
         g.fillRect(50, 550, 500, 100);
         g.fillPolygon(xPoints, yPoints, 3);
         g.drawImage(CowImage, 550, 500, 730, 700,0 , 0, cw, ch, null);
         g.setFont(new Font("Purisa", Font.BOLD, 13));
         g.setColor(Color.BLACK);
         g.drawString("MOOwo", 60, 630);
         g.drawString("MOOOOOOOOO", 60, 610);
         g.drawString("MOOOOOOOOOO", 60, 590);
         g.drawString("MOOOO", 60, 570);
      }

      
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
