import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Player{
   public int headX;
   public int headY;
   public int rectX;
   public int rectY;
   BufferedImage image;
   BufferedImage upImage;
   int w, h;
   String style;
   public boolean inBounds;
   
   public Player(){
      try{
         File stillImg = new File("face.png");
         image = ImageIO.read(stillImg);
         File upImg = new File("back.png");
         upImage = ImageIO.read(upImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
      }
      catch (IOException e){
         System.exit(1);
      }
      rectX = 50;
      rectY = 350;
   }

   
   public void draw(Graphics g, String style){
      if(style.equals("still")||style.equals("down")){
         g.drawImage(image, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
      }
      else if(style.equals("up")){
         g.drawImage(upImage, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
      }
      else if(style.equals("right") || style.equals("left")){   
         g.drawImage(image, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
      }
      
      
      
   }
   public boolean inBetween(int var, int bot, int top){
      if(var >= bot && var <= top){
         return true;
      }
      return false;
   }
   
   public void move(int changeX, int changeY){
      if(rectX > 600){
         rectX -= 5;
      }
      else if(rectX < 0){
         rectX += 5;
      }
      
            
      else{
         rectX += changeX;
         rectY += changeY;
      }      
 
   }
}
      

