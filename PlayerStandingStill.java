import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PlayerStandingStill implements Player{
   public int headX;
   public int headY;
   public int rectX;
   public int rectY;
   
   public PlayerStandingStill(){
      headX = 50;
      headY = 325;
      rectX = 50;
      rectY = 350;
   }
   
   public void draw(Graphics g){
      g.setColor(Color.BLACK);
      g.fillOval(headX, headY, 25, 25);
      g.fillRect(rectX, rectY, 25, 50);
      g.fillRect(rectX, rectY+50, 10, 20);
      g.fillRect(rectX+15, rectY+50, 10, 20);
      
   }
   
   public void move(int changeX, int changeY){
      headX += changeX;
      headY += changeY;
      rectX += changeX;
      rectY += changeY;
   }
}
      

