import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Door{
   public int doorX;
   public int doorY;
   BufferedImage image;
   BufferedImage openImage;
   int w, h;
   
   public Door(){
      try{
         File stillImg = new File("door.png");
         image = ImageIO.read(stillImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
      }
      catch (IOException e){
         System.exit(1);
      }
      doorX = 50;
      doorY = 350;
   }

   
   public void draw(Graphics g){
      g.drawImage(image, doorX, doorY, w+doorX+20, h+doorY+20, 0, 0, w, h, null);    
   }
   
   public void open(Player p){
      if(p.rectY > doorY && p.rectY < (doorY + h) && p.rectX > doorX && p.rectX < (doorX + w)){
      }
      else if(p.rectY > doorY && p.rectY < (doorY + h) && p.rectX > doorX && p.rectX < (doorX + w)){
      }
   }
}
