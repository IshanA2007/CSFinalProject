import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class MasterGUI extends JPanel{
   StartingScene g = new StartingScene();

   public MasterGUI(){
      setLayout(new BorderLayout());
      add(g);
   }
}
   
   
