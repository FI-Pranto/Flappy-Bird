import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener,KeyListener{
    int bgwidth=360,bgheight=640;
    Image bg,Bird,top_pipe,btm_pipe;
    Timer gameloop;
    int top_pip1x=bgwidth;
    int top_pip2x=bgwidth+208;
    int top_pip1y=-200;
    int top_pip2y=-100;
    int btm_pip1x=bgwidth;
    int btm_pip2x=bgwidth+208;
    int btm_pip1y=412;
    int btm_pip2y=512;

    int point=0;
    boolean passpip1=false;
    boolean passpip2=false;
    
    int cal,dif,dis;

    int velocity=0;
    int gravity=1;
    int birdy=300;
    boolean gameover=false;
    JButton b1,b2;
     

    FlappyBird(){
     
        setPreferredSize(new Dimension(bgwidth,bgheight));
        
        setFocusable(true);
        addKeyListener(this);

        bg= new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        Bird= new ImageIcon(getClass().getResource("./Bird.png")).getImage();
        top_pipe= new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        btm_pipe= new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
        gameloop=new Timer(1000/60, this);
        gameloop.start();

    }
   public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        
        g.drawImage(bg, 0,0, bgwidth,bgheight,null);

        g.drawImage(Bird, 60,birdy,30, 20,null);
        
       toppip(g);
       botmpip(g);

       g.drawString("SCORE : "+point, 20, 20);


    }
    public void botmpip(Graphics g){
        if(btm_pip1x+64==0)
        {
             cal=512+top_pip1y+100;
            btm_pip1y =cal;
            btm_pip1x=bgwidth;
        }
      
        else if(btm_pip2x+64==0){
            cal=512+top_pip2y+100;
            btm_pip2y=cal;
            btm_pip2x=bgwidth;
        }
        g.drawImage(btm_pipe, btm_pip1x, btm_pip1y, 56, 512, null);
        g.drawImage(btm_pipe, btm_pip2x, btm_pip2y, 56, 512, null);
    }
    public void toppip(Graphics g){
        if(top_pip1x+64==0)
        {
            top_pip1y = (int)(Math.random()*(-450+200+1)-200); 
            top_pip1x=bgwidth;
        }
      
        else if(top_pip2x+64==0){
            top_pip2y = (int)(Math.random()*(-450+200+1)-200); 

            top_pip2x=bgwidth;
        }
        g.drawImage(top_pipe, top_pip1x, top_pip1y, 56, 512, null);
        g.drawImage(top_pipe, top_pip2x, top_pip2y, 56, 512, null);
    }
    public void move(){

      velocity=velocity+gravity;

      birdy=birdy+velocity;
      
      birdy=Math.max(birdy,0);
      top_pip1x=top_pip1x-4;
      top_pip2x=top_pip2x-4;
      btm_pip1x=btm_pip1x-4;
      btm_pip2x=btm_pip2x-4;

      if(60>top_pip1x+56 && !passpip1){
      point++;
      passpip1=true;
      passpip2=false;
      }
      else if(60>top_pip2x+56 && !passpip2){
        point++;
        passpip1=false;
        passpip2=true;
      }

    }
    public void over(){
        if(gameover){
            b1=new JButton("RESTART");
            b1.setBounds(128, 200, 100, 50);
            b1.setBackground(new Color(49,220,215));
            b1.setForeground(new Color(0,0,0));
            
            b1.addActionListener(e-> restart());
            b2=new JButton("EXIT");
            b2.setBounds(128, 300, 100, 50);
            b2.setBackground(new Color(49,220,215));
            b2.setForeground(new Color(0,0,0));
            
            b2.addActionListener(e-> System.exit(0));
            this.setLayout(null);
            this.add(b1);
            this.add(b2);
            b1.setFocusable(false);
            b2.setFocusable(false);
            
          }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        move();
       repaint();
       if(birdy>bgheight){
        gameloop.stop();
        gameover=true;
       }
       else if(isoverlapping1(top_pip1x,top_pip1y)){
        gameloop.stop();
        gameover=true;
       }
       else if(isoverlapping1(top_pip2x,top_pip2y)){
        gameloop.stop();
        gameover=true;
       }
       else if(isoverlapping1(btm_pip1x,btm_pip1y)){
        gameloop.stop();
        gameover=true;
       }
       else if(isoverlapping1(btm_pip2x,btm_pip2y)){
        gameloop.stop();
        gameover=true;
       }
       
      
       over();
     
       
    }
   boolean isoverlapping1(int topx,int topy){

        if(60 < topx + 56 &&   
        60 + 30 > topx &&  
        birdy < topy + 512 &&  
        birdy + 20> topy){
        return true;
        }
        return false;

    }
  
   
    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_SPACE){
        velocity=-9;
       }
     
    }
    public void restart() {
        
        
        this.remove(b1);
        this.remove(b2);
        this.setLayout(new FlowLayout());
        
         top_pip1x=bgwidth;
         top_pip2x=bgwidth+208;
         top_pip1y=-200;
         top_pip2y=-100;
         btm_pip1x=bgwidth;
         btm_pip2x=bgwidth+208;
         btm_pip1y=412;
         btm_pip2y=512;
    

          point=0;
         passpip1=false;
          passpip2=false;
        
    
         velocity=0;
         gravity=1;
         birdy=300;
         gameover=false;
        gameloop.start();
    }
    @Override
    public void keyReleased(KeyEvent e) {
      
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    }
}
