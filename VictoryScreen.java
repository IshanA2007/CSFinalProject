import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.io.File;
import javax.imageio.*;
import java.io.IOException;

import javax.swing.plaf.metal.*;


public class VictoryScreen extends JPanel{
  public double curY = 50;
  public String playerName = "";
  PlayerStats stats;
  ArenaBackground bckg; 
  BufferedImage myImage;
  Graphics myBuffer;
  Player player;
  MasterGUI f;
  public int w, h, tw, th, ew, eh, pw, ph, ttw, tth;
  BufferedImage TitleImage, TextImage, EckImage, image, TrophyImage;
  JButton startGame, saveGame, exit;
  JTextField nameField;
  public boolean moveUp;
  Timer t;
  
public VictoryScreen(PlayerStats pstats, MasterGUI master){
   try{
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      MetalLookAndFeel.setCurrentTheme(new OceanTheme());
      UIManager.setLookAndFeel(new MetalLookAndFeel());
      File textImg = new File("victory.png");
      TextImage = ImageIO.read(textImg);
      tw = TextImage.getWidth(null);
      th = TextImage.getHeight(null);
      File titleImg = new File("title.jpg");
      TitleImage = ImageIO.read(titleImg);
      w = TitleImage.getWidth(null);
      h = TitleImage.getHeight(null);
      File eckImg = new File("Eck.png");
      EckImage = ImageIO.read(eckImg);
      ew = EckImage.getWidth(null);
      eh = EckImage.getWidth(null);
      File stillImg = new File("face.png");
      image = ImageIO.read(stillImg);
      pw = image.getWidth(null);
      ph = image.getHeight(null);
      File trophyImg = new File("trophy.png");
      TrophyImage = ImageIO.read(trophyImg);
      ttw = TrophyImage.getWidth(null);
      tth = TrophyImage.getHeight(null);
      
   }
   catch(IOException e){
      System.exit(1);
   }
   catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   );
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel on this platform.");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (Exception e) {
                System.err.println("Couldn't get specified look and feel for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
   f = master;
   stats = pstats;
   player = new Player();
   player.style = "still";
   myImage = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
   myBuffer = myImage.getGraphics();
   
   startGame = new JButton("Start Game");
   saveGame = new JButton("Load Stats");
   exit = new JButton("Quit");
   nameField = new JTextField("Enter name here");
   t = new Timer(15, new AnimationListener());
   setFocusable(true);
   setLayout(null);
   myBuffer.drawImage(TitleImage, 0, 0, 900, 700, 0, 0, w, h, null);
   startGame.setBounds(275, 500, 150, 50);
   saveGame.setBounds(275, 555, 150, 50);
   exit.setBounds(275, 610, 150, 50);
   nameField.setBounds(200, 300, 300, 75);
   startGame.addActionListener(new StartListener());
   exit.addActionListener(new ExitListener());
   saveGame.addActionListener(new LoadListener());
   begin();
   
}  
   public void begin(){
      t.start();
   }

   public PlayerStats getStats(){
      return stats;
   }
   public void animate(){
      removeAll();
      myBuffer.setColor(Color.BLACK);
      myBuffer.setFont(new Font("Purisa", Font.BOLD, 15));
     
      myBuffer.drawImage(TitleImage, 0, 0, 900, 700, 0, 0, w, h, null);
      myBuffer.drawString("Thanks for playing!", 255, 200);
      myBuffer.setFont(new Font("Purisa", Font.BOLD, 11));
      myBuffer.drawString("Made by: Ishan A., Ryeen A.", 235, 250);
      myBuffer.drawString("Credits: Kolos and Alex!", 240, 260);
      myBuffer.drawString("Starring: Dr. Ebrahim and Mr. Eckel", 235, 270);
      drawTitle();
      myBuffer.drawImage(TrophyImage, 110, 300, 110+ttw-20, 200+tth-50, 0, 0, ttw, tth, null);
      repaint();
   }
      
   public void drawTitle(){
      if(curY > 80){
         moveUp = true;
      }
      if(curY < 60){
         moveUp = false;
      }
      if(moveUp){
         curY -= 0.5;
      }
      else{
         curY += 0.5;
      }
      myBuffer.drawImage(TextImage, 150, (int)curY, 550,(int)(curY)+100, 0, 0, tw, th, null);
      myBuffer.drawImage(EckImage, 545, (int)(curY/2)+500, 545+ew, (int)(curY/2)+500+eh, 0, 0, ew, eh, null);
      myBuffer.drawImage(image, 50, (int)(curY/2)+500, 50+pw, (int)(curY/2)+500+ph, 0, 0, pw, ph, null);
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
   
   private class StartListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         f.changeLoadToStart();
      }
   }
   private class ExitListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         System.out.println("You quit! (bozo)");
         System.exit(1);
      }
   }
   private class LoadListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         stats.loadStats();
         System.out.println("Stats loaded from stats.txt");
      }
   }
}
