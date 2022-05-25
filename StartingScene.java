import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class StartingScene extends JPanel{

   BufferedImage myImage;
   Graphics myBuffer;
   private Timer t;
   StartingBackground bckground;
   private boolean space;
   public int count = 0;
   public int playerVelocityX = 0;
   public int playerVelocityY = 0;
   Player player;
   PlayerStats stats;
   public boolean increaseVelocityUp = true;
   public boolean increaseVelocityDown = true;
   public boolean increaseVelocityRight = true;
   public boolean increaseVelocityLeft = true;
   public int doorNum = 0;
   public boolean isOver = false;
   MasterGUI f;
   //ArrayList<Door> doors;
   public StartingScene(PlayerStats pStats, MasterGUI master){
      //doors = new ArrayList<Door>();
      //doors.add(first door coords);
      //doors.add(second door coords);
      //doors.add(third door coords);
      //doors.add(fourth door coords);
      f = master;
      myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(Color.WHITE);   
      myBuffer.fillRect(0, 0, 700, 700);
      bckground = new StartingBackground(0);
      player = new Player();
      player.style = "still";
      stats = pStats;
      t = new Timer(5, new AnimationListener());
      
      addKeyListener(new Key());
      setFocusable(true);
      
      begin();
   }
   
   public void begin(){
      t.start();
   }
   
   public PlayerStats getStats(){
      return stats;
   }
   
   
   public void animate(){
      bckground.draw(myBuffer);
      bckground.moveBackground((int)(1.5*playerVelocityX));
      player.draw(myBuffer, player.style, 100, true, stats.curWeapon(), stats.money, stats.shield);
      player.move(playerVelocityX, playerVelocityY);
      //checkDoorText(playerVelocityX, playerVelocityY);
      stats.setDamage(stats.getWeaponDamage(stats.curWeapon()));
      
      repaint();
   }
   
  /*public void checkDoorText(int playerX, int playerY){
      for(int i = 0; i < doors.size(); i++){
         if(doors.get(i).nextToADoor(playerX, playerY)){
            myBuffer.setFont(new Font("Purisa", Font.BOLD, 15));
            myBuffer.setColor(Color.BLACK);
            myBuffer.drawString("Press 'E' to enter!", doors.get(i).getX()-5, doors.get(i).getY()-5);
         }
      }
   }
   */        
            
   
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
            
            if(playerVelocityX == 0 && playerVelocityY == 0){
               //for(int i = 0; i < doors.size(); i++){
                  //if(doors.get(i).nextToADoor(player.rectX, player.rectY)){
                     f.change();
                  //}
               //}
            }
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