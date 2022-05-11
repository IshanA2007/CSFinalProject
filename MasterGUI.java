import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class MasterGUI extends JPanel{
   StartingScene g;
   TutorialScene n;
   PlayerStats stats = new PlayerStats(0, 0, 0);
   public final boolean owo = true;
   public int doorNum = 0; 
   public int curScene = 1;
   public int count = 0;
   public boolean gInProgress = true;
   public boolean oneInProgress = false;
   public boolean twoInProgress = false;
   public boolean threeInProgress = false;
   public boolean fourInProgress = false;
  

   public MasterGUI(){
      setLayout(new BorderLayout());
      n = new TutorialScene(stats);
      g = new StartingScene(stats);
      add(n);
      
      
   }
   
   /*public void gameLoop(){
      if(gInProgress){
         if(g.isOver){
            stats = g.getStats();
            gInProgress = false;
            remove(g);
            if(g.doorNum == 1){
               1InProgress = true;
               tutorial = new TutorialScene(stats);
               add(tutorial);
            }
            else if(g.doorNum == 2){
               2InProgress = true;
               farm = new FarmScene(stats);
               add(farm);
            }
            else if(g.doorNum == 3){
               3InProgress = true;
               arena = new ArenaScene(stats);
               add(arena);
            }
            else if(g.doorNum == 4){
               4InProgress = true;
               shop = new ShopScene(stats);
               add(shop);
            }
            validate();
         }
      }
      
      else if(1InProgress){
         if(tutorial.isOver){
            stats = tutorial.getStats();
            1InProgress = false;
            remove(tutorial);
            gInProgress = true;
            g = new StartingBackground(stats);
            add(g);
            validate();      
         }
      }
      
      else if(2InProgress){
         if(farm.isOver){
            stats = farm.getStats();
            2InProgress = false;
            remove(farm);
            gInProgress = true;
            g = new StartingBackground(stats);
            add(g);
            validate();
         }
      }
         
         
   }
}
*/

         
            
   
   
         
         
      
      
  }

   
   
