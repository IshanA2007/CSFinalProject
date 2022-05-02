import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class PlayerStandingStill implements Player{
   public int headX;
   public int headY;
   public int rectX;
   public int rectY;
   BufferedImage image;
   int w, h;
   
   public PlayerStandingStill(){
      try{
         File stillImg = new File("face.png");
         image = ImageIO.read(stillImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
      }
      catch (IOException e){
         System.exit(1);
      }
      headX = 50;
      headY = 325;
      rectX = 50;
      rectY = 350;
   }
   
   public void draw(Graphics g){
      g.drawImage(image, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
   }
   
   public void move(int changeX, int changeY){
      headX += changeX;
      headY += changeY;
      rectX += changeX;
      rectY += changeY;
   }
}
      

