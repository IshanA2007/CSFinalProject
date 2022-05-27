   import java.util.ArrayList;
   import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;
import java.io.IOException;
public class PlayerStats{
   public int damage;
   public int shield;
   public int health;
   public ArrayList<String> weapons; 
   public int combStage;
   public int money;
   public int count = 0;
   
   
   public PlayerStats(int newDmg, int newShld, int newHlth){
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
      else if(weapon.equals("Spoon")){
         return 50;
      }
      return 0;
   }
   
   
}