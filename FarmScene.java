import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
public class FarmScene extends JPanel{
   PlayerStats stats;
   BufferedImage myImage;
   Graphics myBuffer;
   Player player;
   ArrayList<Vegetable> veggies;
   FarmBackground bckg;
   public int count = 0;
   public boolean isOver = false;
   public boolean showInfo = false;
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   private Timer t;
   
   
   
   public FarmScene(PlayerStats pstats){
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      t = new Timer(5, new AnimationListener());
      player = new Player();
      stats = pstats;
      veggies = new ArrayList<Vegetable>();
      player.style = "still";
      bckg = new FarmBackground(0);
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();

      
   }
   
   public void begin(){
      t.start();
   }
   
   /*public void generateVeggies(){
      count += 1;
      if(count%15 == 0){
         veggies.add(new Potato());
      }
      if(count%30==0){
         veggies.add(new Carrot());
      }
   }*/
   
   /*public void collectVeggies(){
      for(int i = 0; i < veggies.size(); i++){
         val = veggies.get(i).getVal();
         stats.money += val;
         veggies.remove(i);
      }
         
   }
   */
   
   public void animate(){
      bckg.draw(myBuffer, player.rectX, player.rectY);
      bckg.moveBackground((int)(1.5*playerVelocityX));
      player.draw(myBuffer, player.style, 100, true, stats.curWeapon());
      player.move(playerVelocityX, playerVelocityY);
      
      repaint();
   }
   
   public void paintComponent(Graphics g)  //The same method as before!
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
   
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }
   
   
   private class Key extends KeyAdapter{
      public void keyPressed(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_RIGHT && increaseVelocityRight){
            player.style = "right";
            playerVelocityX += 3;
            increaseVelocityRight = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT && increaseVelocityLeft){
            player.style = "left";
            playerVelocityX -= 3;
            increaseVelocityLeft = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP && increaseVelocityUp){
            player.style = "up";
            playerVelocityY -= 4;
            increaseVelocityUp = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN && increaseVelocityDown){
            player.style = "down";
            playerVelocityY += 4;
            increaseVelocityDown = false;
         }
         else if(e.getKeyCode() == KeyEvent.VK_J){
            isOver = true;
         }
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerVelocityX -= 3;
            increaseVelocityRight = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playerVelocityX += 3;
            increaseVelocityLeft = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP){
            playerVelocityY += 4;
            increaseVelocityUp = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            playerVelocityY -= 4;
            increaseVelocityDown = true;
         }
      }
   }
   
}
