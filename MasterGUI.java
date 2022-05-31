import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class MasterGUI extends JPanel{
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
   StartingScene s;
   ShopScene shop;
   ArenaScene arena;
   TutorialScene tutorial;
   FarmScene farm;
   LoadingScreen loading;
   BossScene boss1;
   Boss2Scene boss2;
   Boss3Scene boss3;
   
   JPanel cards; 
   
   public MasterGUI(){
      
      /*final String Shop = "SHOP";
      final String Start = "START";
      final String Arena = "ARENA";
      final String Tutorial = "TUTORIAL";
      final String Farm = "FARM";
      ShopScene shop = new ShopScene(stats);
      StartingScene start = new StartingScene(stats);
      ArenaScene arena = new ArenaScene(stats);
      TutorialScene tutorial = new TutorialScene(stats);
      FarmScene farm = new FarmScene(stats);
      
      cards = new JPanel(new CardLayout());*/
      setLayout(new BorderLayout());
      boss3 = new Boss3Scene(stats, this);
      add(boss3);
      /*add(cards);
      cards.add(shop, "SHOP");
      cards.add(start, "START");
      cards.add(arena, "ARENA");
      cards.add(tutorial, "TUTORIAL");
      cards.add(farm, "FARM");
      
      CardLayout cl = (CardLayout)(cards.getLayout());
      cl.show(cards, "FARM");
      
      addKeyListener(new Key());
      setFocusable(true);*/
      
      //setLayout(new BorderLayout());
      //s = new ShopScene(stats);
      //add(s);
 
   }
   
   public void changeStartToShop(){
      stats = s.getStats();
      removeAll();
      shop = new ShopScene(stats, this);
      add(shop);
      shop.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeStartToTutorial(){
      stats = s.getStats();
      removeAll();
      tutorial = new TutorialScene(stats, this);
      add(tutorial);
      tutorial.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeStartToArena(){
      stats = s.getStats();
      removeAll();
      arena = new ArenaScene(stats, this);
      add(arena);
      arena.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeStartToFarm(){
      stats = s.getStats();
      removeAll();
      farm = new FarmScene(stats, this);
      add(farm);
      farm.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeShopToStart(){
      removeAll();
      stats = shop.getStats();
      s = new StartingScene(stats, this);
      add(s);
      s.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeArenaToStart(){
      removeAll();
      stats = arena.getStats();
      s = new StartingScene(stats, this);
      add(s);
      s.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeFarmToStart(){
      removeAll();
      stats = farm.getStats();
      s = new StartingScene(stats, this);
      add(s);
      s.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeTutorialToStart(){
      removeAll();
      stats = tutorial.getStats();
      s = new StartingScene(stats, this);
      add(s);
      s.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeLoadToStart(){
      removeAll();
      stats = loading.getStats();
      s = new StartingScene(stats, this);
      add(s);
      s.requestFocus();
      revalidate();
      repaint();
   }
   
   public void changeBoss1Boss2(){
      removeAll();
      stats = boss1.getStats();
      boss2 = new Boss2Scene(stats, this);
      add(boss2);
      boss2.requestFocus();
      revalidate();
      repaint();
   }
   
   

   
   
   
   
   
   
   
   
}


            
      
   

         
            
   
   
         
         
      
      
  


   
   
