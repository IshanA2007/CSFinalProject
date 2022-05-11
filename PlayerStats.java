   import java.util.ArrayList;

public class PlayerStats{
   public int damage;
   public int shield;
   public int health;
   public ArrayList<String> weapons; 
   
   
   public PlayerStats(int newDmg, int newShld, int newHlth){
      damage = newDmg;
      shield = newShld;
      health = newHlth;
      weapons = new ArrayList<String>();
      weapons.add("Fist");
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
   
   public void setHealth(int newHealth){
      health = newHealth;
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