import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public interface Player {
    public void move(int changeX, int changeY);
    
    public void draw(Graphics g);
}
