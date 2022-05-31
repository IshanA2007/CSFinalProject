   import java.util.ArrayList;
   import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class PlayerStats{
   public int damage;
   public int shield;
   public int health;
   public ArrayList<String> weapons; 
   public int combStage;
   public int money;
   public int count = 0;
   BufferedImage BookImage;
   public int bw, bh;
   
   public PlayerStats(int newDmg, int newShld, int newHlth){
      try{
         File bookImg = new File("book.png");
         BookImage = ImageIO.read(bookImg);
         bw = BookImage.getWidth(null);
         bh = BookImage.getHeight(null);
      }
      catch(IOException e){
         System.exit(1);
      }
      damage = newDmg;
      shield = newShld;
      health = newHlth;
      weapons = new ArrayList<String>();
      weapons.add("Fist");
      combStage = 1;
      money = 0;
   }
   
   public void addDamage(int incDmg){
      damage += incDmg;
   }
   
   public void setDamage(int newDmg){
      damage = newDmg;
   }
   
   public void addShield(int incShield){
      shield += incShield;
   }
   
   
   public void drawInfoBook(Graphics g){
      g.drawImage(BookImage, 15, 100, 15+bw, 50+bh+250, 0, 0, bw, bh, null);
      g.drawString("Keybinds", 175, 200);
      g.drawString("WASD  -  Move around", 85, 230);
      g.drawString("Space  -  Attack enemies in arena", 85, 260);
      g.drawString("I  -  Open/Close info book", 85, 290);
      g.drawString("E  -  Enter/Exit a room", 85, 320);
      g.drawString("J  -  Exit tutorial room", 85, 350);
      g.drawString("K  -  Save game stats", 85, 380);
      g.drawString("B  -  Buy items in shop", 85, 410);
      g.drawString("Destinations", 400, 200);
      g.drawString("Main Map: ", 350, 220);
      g.drawString("Go to different destinations", 370, 250);
      g.drawString("through doors", 370, 260);
      g.drawString("Tutorial: ", 350, 290);
      g.drawString("Learn the basics of the game", 370, 320);
      g.drawString("Farm: ", 350, 340);
      g.drawString("Earn money while harvesting", 370, 370);
      g.drawString("crops", 370, 380);
      g.drawString("Arena: ", 350, 410);
      g.drawString("Battle strong mobs for", 370, 440); 
      g.drawString("lots of money", 370, 450);
      g.drawString("Shop: ", 350, 480);
      g.drawString("Buy powerful weapons", 370, 510); 
      g.drawString("and armor", 370, 520);
      g.drawString("Boss Room: ", 350, 550);
      g.drawString("Fight The Eck", 370, 580);
   }
   
   public void loadStats(){
      int count = 0;
      try {
      File myObj = new File("stats.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(count == 0){
         shield = Integer.parseInt(data);
        }
        else if(count == 1){
         damage = Integer.parseInt(data);
        }
        else if(count == 2){
         money = Integer.parseInt(data);
        }
        else if(count == 3){
         combStage = Integer.parseInt(data);
        }
        else if(count >= 4){
         weapons.add(data);
        }
        count += 1;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   }
   
   public void saveStats(){
      try {
      FileWriter myWriter = new FileWriter("stats.txt");
      myWriter.write(Integer.toString(shield));
      myWriter.write(System.getProperty( "line.separator" ));
      myWriter.write(Integer.toString(damage));
      myWriter.write(System.getProperty( "line.separator" ));
      myWriter.write(Integer.toString(money));
      myWriter.write(System.getProperty( "line.separator" ));
      myWriter.write(Integer.toString(combStage));
      myWriter.write(System.getProperty( "line.separator" ));
      for(int i = 0; i < weapons.size(); i++){
         myWriter.write(weapons.get(i));
         myWriter.write(System.getProperty( "line.separator" ));
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
 }
   
   public void setShield(int newShield){
      shield = newShield;
   }
   
   public void addHealth(int incHealth){
      shield += incHealth;
   }
   
   public String curWeapon(){
      String a = "";
      for(int i = 0; i < weapons.size(); i++){
         if(weapons.get(i).equals("Sword")){
            count = 1;
         }
      }
      for(int i = 0; i < weapons.size(); i++){
         if(weapons.get(i).equals("Spear")){
            count = 2;
         }
      }
      for(int i = 0; i < weapons.size(); i++){
         if(weapons.get(i).equals("Hammer")){
            count = 3;
         }
      }
         
      if(count == 1){
         a = "Sword";
      }
      else if(count == 2){
         a = "Spear";
      }
      else if(count == 3){
         a = "Hammer";
      }
      else{
         a = "Fist";
      }   
      
      return a;
   }
   
      
   
   public void setHealth(int newHealth){
      health = newHealth;
   }
   
   public void addStage(){
      combStage += 1;
   }
   
   public int getWeaponDamage(String weapon){
      if(weapon.equals("Fist")){
         return 2;
      }
      else if(weapon.equals("Sword")){
         return 5;
      }
      else if(weapon.equals("Spear")){
         return 50;
      }
      else if(weapon.equals("Hammer")){
         return 200;
      }
      return 0;
   }
   
   
}