import javax.swing.*;
import java.awt.*;

public class main{
   public static void main(String[] args){
      JFrame frame = new JFrame("ur mom");
      frame.setSize(700, 700);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MasterGUI());
      frame.setVisible(true);
   }
}    