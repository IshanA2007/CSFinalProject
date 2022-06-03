import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class main{
   public static void main(String[] args) throws Exception{
      JFrame frame = new JFrame("Eckventures");
      frame.setSize(700, 700);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MasterGUI());
      frame.setVisible(true);
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(new File("Free Game Loop.wav")));
      clip.start();
      clip.loop(Clip.LOOP_CONTINUOUSLY);

   }
}    
