import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class StartingScene extends JPanel{

   BufferedImage myImage;
   Graphics myBuffer;
   private Timer t;
   public boolean showInfoBook = false;
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
   ArrayList<Door> doors;
   public StartingScene(PlayerStats pStats, MasterGUI master){
      doors = new ArrayList<Door>();
      doors.add(new Door(147, 145));
      doors.add(new Door(800, 145));
      doors.add(new Door(1050, 300));
      doors.add(new Door(600, 15));
      doors.add(new Door(600, 300));
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
      for(int i = 0; i < doors.size(); i++){
         doors.get(i).draw(myBuffer, bckground.referenceX);
      }
      checkDoorText(player.rectX, player.rectY);
      stats.setDamage(stats.getWeaponDamage(stats.curWeapon()));
      if(showInfoBook){
         stats.drawInfoBook(myBuffer);
      }
      repaint();
   }
   
  public void checkDoorText(int playerX, int playerY){
      for(int i = 0; i < doors.size(); i++){
         if(doors.get(i).nextToADoor(playerX, playerY, bckground.referenceX)){
            myBuffer.setFont(new Font("Purisa", Font.BOLD, 15));
            myBuffer.setColor(Color.WHITE);
            myBuffer.drawString("Press 'E' to enter!", doors.get(i).getX()-5-bckground.referenceX, doors.get(i).getY()-5);
         }
      }
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
         else if(e.getKeyCode() == KeyEvent.VK_L){
            stats.saveStats();
         }
         else if(e.getKeyCode() == KeyEvent.VK_I){
            showInfoBook = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_E){
            
            if(playerVelocityX == 0 && playerVelocityY == 0){
               for(int i = 0; i < doors.size(); i++){
                  if(doors.get(i).nextToADoor(player.rectX, player.rectY, bckground.referenceX)){
                     if(i == 0){
                        f.changeStartToTutorial();
                     }
                     else if(i == 1){
                        f.changeStartToArena();
                     }
                     else if(i == 2){
                        f.changeStartToShop();
                     }
                     else if(i == 3){
                        f.changeStartToFarm();
                     }
                     else if(i == 4){
                        f.changeStartToBoss();
                     }
                     
                  }
               }
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
         else if(e.getKeyCode() == KeyEvent.VK_I){
            showInfoBook = false;
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