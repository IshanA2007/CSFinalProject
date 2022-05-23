import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class ShopBackground extends JPanel{
   BufferedImage BackgroundImage;
   public int w, h, sw, sh, hw, hh, sww, swh, cpw, cph, shw, shh, bw, bh, spiw, spih, siw, sih, hiw, hih, ciw, cih, shiw, shih;
   BufferedImage HammerImage, SwordImage, SpearImage, HammerItemImage, SwordItemImage, SpearItemImage, ChestplateItemImage, ShieldItemImage;
   BufferedImage ShieldImage;
   BufferedImage BookImage;
   BufferedImage ChestplateImage;
   public boolean buyItem = true;
   public int pX, pY;
   PlayerStats stats;
   Timer t;
   public ShopBackground(PlayerStats pstats){
      try{ 
         stats = pstats;
         File chestplateItemImg = new File("chestplateitem.png");
         File shieldItemImg = new File("shielditem.png");
         File swordItemImg = new File("sworditem.png");
         File spearItemImg = new File("spearitem.png");
         File hammerItemImg = new File("hammeritem.png");
         SwordItemImage = ImageIO.read(swordItemImg);
         SpearItemImage = ImageIO.read(spearItemImg);
         HammerItemImage = ImageIO.read(hammerItemImg);
         ChestplateItemImage = ImageIO.read(chestplateItemImg);
         ShieldItemImage = ImageIO.read(shieldItemImg);
         ciw = ChestplateItemImage.getWidth(null);
         cih = ChestplateItemImage.getHeight(null);
         shiw = ShieldItemImage.getWidth(null);
         shih = ShieldItemImage.getHeight(null);
         siw = SwordItemImage.getWidth(null);
         sih = SwordItemImage.getHeight(null);
         spiw = SpearItemImage.getWidth(null);
         spih = SpearItemImage.getHeight(null);
         hiw = HammerItemImage.getWidth(null);
         hih = HammerItemImage.getHeight(null);
         File bckImg = new File("tutorial.png");
         BackgroundImage = ImageIO.read(bckImg);
         w = BackgroundImage.getWidth(null);
         h = BackgroundImage.getHeight(null);
         File swordImg = new File("sword.png");
         File spearImg = new File("spear.png");
         File hammerImg = new File("hammer.png");
         File shieldImg = new File("shield.png");
         File cpImg = new File("chestplate.png");
         File bookImg = new File("book.png");
         BookImage = ImageIO.read(bookImg);
         bw = BookImage.getWidth(null);
         bh = BookImage.getHeight(null);
         ShieldImage = ImageIO.read(shieldImg);
         ChestplateImage = ImageIO.read(cpImg);         
         SwordImage = ImageIO.read(swordImg);
         SpearImage = ImageIO.read(spearImg);
         HammerImage = ImageIO.read(hammerImg);
         
         sw = SpearImage.getWidth(null);
         sh = SpearImage.getHeight(null);
         
         hw = HammerImage.getWidth(null);
         hh = HammerImage.getHeight(null);
         
         sww = SwordImage.getWidth(null);
         swh = SwordImage.getHeight(null);
         
         cpw = ChestplateImage.getWidth(null);
         cph = ChestplateImage.getHeight(null);
         
         shw = ShieldImage.getWidth(null);
         shh = ShieldImage.getHeight(null);
         
         
         
   


      }
      catch(IOException e){
         System.exit(1);
      }
   }
   
   
   
   public void draw(Graphics g, int playerX, int playerY){
      
      g.setColor(Color.RED);
      g.drawImage(BackgroundImage, 0, 0, 700, 700, 0, 0, w, h, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.setColor(Color.BLACK);
      g.drawImage(SpearImage, 200, 300, 200 + sw, 300+sh, 0, 0, sw, sh, null);
      g.drawImage(SwordImage, 350, 300, 350+sww, 300+swh, 0, 0, sww, swh, null);
      g.drawImage(HammerImage, 500, 300, 500+hw, 300+hh, 0, 0, hw, hh, null);
      g.drawImage(ShieldImage, 250, 450, 250+shw, 450+shh, 0, 0, shw, shh, null);
      g.drawImage(ChestplateImage, 450, 450, 450+cpw, 450+cph, 0, 0, cpw, cph, null);
      if(playerX > 150 && playerX < 250 && playerY > 250 && playerY<350){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         drawSpearBook(g);
      }
      
      
      if(playerX > 300 && playerX < 400 && playerY > 250 && playerY<350){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         drawSwordBook(g);
      }
            if(playerX > 450 && playerX < 550 && playerY > 250 && playerY < 350){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         drawHammerBook(g);
      }
            if(playerX > 200 && playerX < 300 && playerY > 400 && playerY < 500){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         drawShieldBook(g);
      }
     
      if(playerX > 400 && playerX < 500 && playerY > 400 && playerY < 500){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         drawChestplateBook(g);
      }
   }
   
   public void drawSpearBook(Graphics g){
      g.drawImage(BookImage, 15, 100, 15+bw, 50+bh+250, 0, 0, bw, bh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.drawString("Spear", 175, 180);
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Item Type: Weapon", 85, 200);
      g.drawString("Rarity: Epic", 85, 220);
      g.drawString("A weapon of destruction,", 85, 400);
      g.drawString("the blade was crafted carefully by", 85, 420);
      g.drawString("Xeneas, the best weaponsmith in", 85, 440);
      g.drawString("the land. Wield this weapon and", 85, 460);
      g.drawString("you can pierce anything. This is", 85, 480);
      g.drawString("a staff of chaos.", 85, 500);
      g.drawString("Price: 500 coins", 400, 200);
      g.drawString("Damage: 10", 400, 240);
      g.drawString("Speed Multiplier: 1", 400, 280);
      g.drawString("Press 'b' to buy", 400, 550);
      g.drawImage(SpearItemImage, 125, 220, 105+spiw+100, 220+spih+100, 0, 0, spiw, spih, null);
      
     
   }
   public void drawHammerBook(Graphics g){
      g.drawImage(BookImage, 15, 100, 15+bw, 50+bh+250, 0, 0, bw, bh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.drawString("Hammer of Doom", 150, 180);
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Item Type: Weapon", 85, 200);
      g.drawString("Rarity: Legendary", 85, 220);
      g.drawString("This weapon is a hammer made by", 85, 400);
      g.drawString("the goblins of Xartica;", 85, 420);
      g.drawString("it has the power to crush a tank", 85, 440);
      g.drawString("and summon the might of the sky", 85, 460);
      g.drawString("He who is bestowed this weapon", 85, 480);
      g.drawString("will rule.", 85, 500);
      g.drawString("Price: 1000 coins", 400, 200);
      g.drawString("Damage: 20", 400, 240);
      g.drawString("Speed Multiplier: 1", 400, 280);  
      g.drawString("Press 'b' to buy", 400, 550); 
      g.drawImage(HammerItemImage, 125, 220, 105+hiw+100, 220+hih+100, 0, 0, hiw, hih, null);
   }
   public void drawSwordBook(Graphics g){
      g.drawImage(BookImage, 15, 100, 15+bw, 50+bh+250, 0, 0, bw, bh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.drawString("Sword", 175, 180);
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Item Type: Weapon", 85, 200);
      g.drawString("Rarity: Rare", 85, 220);
      g.drawString("This weapon is a blade forged in", 85, 400);
      g.drawString("the mystic lands of Glycia;", 85, 420);
      g.drawString("it's blade is stronger than", 85, 440);
      g.drawString("any other sword. This sword will allow", 85, 460);
      g.drawString("you to shred through any mortal", 85, 480);
      g.drawString("you encounter", 85, 500);
      g.drawString("Price: 200 coins", 400, 200);
      g.drawString("Damage: 5", 400, 240);
      g.drawString("Speed Multiplier: 1", 400, 280);
      g.drawString("Press 'b' to buy", 400, 550);
      g.drawImage(SwordItemImage, 125, 220, 105+siw+100, 220+sih+100, 0, 0, siw, sih, null);
   }
   public void drawChestplateBook(Graphics g){
      g.drawImage(BookImage, 15, 100, 15+bw, 50+bh+250, 0, 0, bw, bh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.drawString("Chestplate", 175, 180);
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Item Type: Armor", 85, 200);
      g.drawString("Rarity: Rare", 85, 220);
      g.drawString("An unstoppable wall of defense:", 85, 400);
      g.drawString("Goldor's Chestplate can withstand", 85, 420);
      g.drawString("any force. 2 tons of steel and", 85, 440);
      g.drawString("reinforced titanium combined to make", 85, 460);
      g.drawString("an inpenetrable armor piece.", 85, 480);
      g.drawString("Wear this and damage taken", 85, 500);
      g.drawString("will be significantly reduced", 85, 520);
      g.drawString("Price: 400 coins", 400, 200);
      g.drawString("Damage reduction: 40%", 400, 240);
      g.drawString("Speed Multiplier: 1", 400, 280);
      g.drawString("Press 'b' to buy", 400, 550);
      g.drawImage(ChestplateItemImage, 125, 220, 105+ciw+100, 220+cih+100, 0, 0, ciw, cih, null);
   }
   public void drawShieldBook(Graphics g){
      g.drawImage(BookImage, 15, 100, 15+bw, 50+bh+250, 0, 0, bw, bh, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.drawString("Shield of Valor", 175, 180);
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Item Type: Armor", 85, 200);
      g.drawString("Rarity: Legendary", 85, 220);
      g.drawString("This legedendary shield is impossible:", 85, 400);
      g.drawString("to beat. Using the most advanced", 85, 420);
      g.drawString("alloys and highest tech refining", 85, 440);
      g.drawString("technology, it can withstand the firepower", 85, 460);
      g.drawString("of a tank. Wear this and damage taken", 85, 480);
      g.drawString("will be nearly nonexistant", 85, 500);
      g.drawString("Price: 2000 coins", 400, 200);
      g.drawString("Damage reduction: 90%", 400, 240);
      g.drawString("Speed Multiplier: 1", 400, 280);
      g.drawString("Press 'b' to buy", 400, 550);
      g.drawImage(ShieldItemImage, 125, 220, 105+shiw+100, 220+shih+100, 0, 0, shiw, shih, null);
      }

   
}