   import java.util.ArrayList;

public class PlayerStats{
   public int damage;
   public int shield;
   public int health;
   public ArrayList<String> weapons; 
   public int combStage;
   public int money;
   
   
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
   
   public void setShield(int newShield){
      shield = newShield;
   }
   
   public void addHealth(int incHealth){
      shield += incHealth;
   }
   
   public String curWeapon(){
      String a = "";
      for(int i = 0; i < weapons.size(); i++){
         if(weapons.get(i).equals("Spear")){
            a = "Spear";
         }
          else if(weapons.get(i).equals("Hammer")){
            a = "Hammer";
         }
         
         else if(weapons.get(i).equals("Sword")){
            a = "Sword";
         }
         else{
            a = "Fist";
         }
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