import java.util.*;
public class weaponsDictClass{
   private Hashtable<Integer, String> weapons;
   
   public weaponsDictClass(){
      weapons.put(1, "Sword");
      weapons.put(2, "Spear");
      weapons.put(3, "Spoon of Doom");
      
   }
   
   public Hashtable<Integer, String> getWeaponDict(){
      return weapons;
   }
}
      