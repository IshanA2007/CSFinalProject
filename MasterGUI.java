import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class MasterGUI extends JPanel{
   StartingScene g;
   TutorialScene tutorial;
   ArenaScene a;
   FarmScene f;
   PlayerStats stats = new PlayerStats(0, 0, 100);
   public final boolean owo = true;
   public int doorNum = 0; 
   public int curScene = 1;
   public int count = 1;
   public boolean gInProgress = true;
   public boolean oneInProgress = false;
   public boolean twoInProgress = false;
   public boolean threeInProgress = false;
   public boolean fourInProgress = false;
   ShopScene s;

   public MasterGUI(){
      setLayout(new BorderLayout());
      g = new StartingScene(stats);
      f = new FarmScene(stats);
      a = new ArenaScene(stats);
      s = new ShopScene(stats);
      add(s);
   }
   
   
   
   public void gameLoop(){
      while(count == 1){
      if(gInProgress){
         if(g.isOver){
            stats = g.getStats();
            gInProgress = false;
            remove(g);
            //if(g.doorNum == 1){
            oneInProgress = true;
               tutorial = new TutorialScene(stats);
               add(tutorial);
            //}
            //else if(g.doorNum == 2){
               //2InProgress = true;
               //farm = new FarmScene(stats);
               //add(farm);
            //}
            //else if(g.doorNum == 3){
               //3InProgress = true;
               //arena = new ArenaScene(stats);
               //add(arena);
            //}
            /*else if(g.doorNum == 4){
               4InProgress = true;
               shop = new ShopScene(stats);
               add(shop);
            }
            */
            validate();
         }
      
      
      else if(oneInProgress){
         if(tutorial.isOver){
            stats = tutorial.getStats();
            oneInProgress = false;
            remove(tutorial);
            gInProgress = true;
            g = new StartingScene(stats);
            add(g);
            validate();      
         }
      }
      /*
      
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
      */
         
         
   }
   }
}

            
      
   

         
            
   
   
         
         
      
      
  }


   
   
