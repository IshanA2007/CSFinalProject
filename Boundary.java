public class Boundary{
   public int corner1X;
   public int corner1Y;
   public int corner2X;
   public int corner2Y;
   public boolean checkUp;
   public boolean checkDown;
   public boolean checkLeft;
   public boolean checkRight;
   
   public Boundary(int ncorner1X, int ncorner1Y, int ncorner2X, int ncorner2Y){
      corner1X = ncorner1X;
      corner1Y = ncorner1Y;
      corner2X = ncorner2X;
      corner2Y = ncorner2Y;
      checkUp = true;
      checkDown = true;
      checkLeft = true;
      checkRight = true;
   }
   
   public void checkBound(Player p){
      if(Math.abs(p.rectY - corner1Y) == 0){
         checkUp = false;
      }
      if(Math.abs(p.rectY - corner2Y) == p.h){
         checkDown = false;
      }
      if(Math.abs(p.rectX - corner1X) == 0){
         checkRight = false;
      }
      if(Math.abs(p.rectX - corner2X) == p.w){
         checkLeft = false;
      }
      else{
         checkUp = true;
         checkDown = true;
         checkRight = true;
         checkLeft = true;
      }
   }
}
      
