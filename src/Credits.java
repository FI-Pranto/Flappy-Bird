import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Credits extends JPanel {
    Image nbg;
    Credits(){
    setPreferredSize(new Dimension(360,640));
    nbg=new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      
        g.drawImage(nbg, 0,0, 360,640,null);
        g.drawString("This Game Creator is ", 120, 100);
        g.drawString("FI PRANTO", 145, 150);
    }
    


}
