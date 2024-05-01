import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class App implements ActionListener{
    static int bgwidth=360,bgheight=640;
    static JFrame myframe,buttonFrame,creditFrame;
    static JButton button,button2,button3;
    
    public static void main(String[] args){
       // int bgwidth=360,bgheight=640;
       // JFrame myframe= new JFrame();
      

       /*  myframe.setSize(bgwidth,bgheight);
        myframe.setTitle("Flappy Bird");
        myframe.setResizable(false);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("E:\\Flappy\\src\\Icon.png");
        myframe.setIconImage(icon.getImage());

        FlappyBird flappyBird=new FlappyBird();
        myframe.add(flappyBird);
        myframe.pack();
        flappyBird.requestFocus();
        myframe.setVisible(true);*/ 
        menu();

        
        

    
    }
    static void menu(){
        ImageIcon bgicon = new ImageIcon("E:\\Flappy\\src\\bg.png");
        JLabel myLabel=new JLabel(bgicon);
        myLabel.setSize(bgwidth,bgheight);
         button=new JButton("PLAY");
        button.setBounds(120, 100, 100, 50);
        button.setBackground(new Color(49,220,215));
        button.setForeground(new Color(0,0,0));
        button.addActionListener(e-> game());    
        button.addActionListener(e-> buttonFrame.setVisible(false));
 
        button2=new JButton("CREDITS");
        button2.setBounds(120, 200, 100, 50);
        button2.setBackground(new Color(49,220,215));
        button2.setForeground(new Color(0,0,0));
        button2.addActionListener(e-> Credit()); 
        button2.addActionListener(e->buttonFrame.setVisible(false));   
        
 
        
 
        button3=new JButton("EXIT");
        button3.setBounds(120, 300, 100, 50);
        button3.setBackground(new Color(49,220,215));
        button3.setForeground(new Color(0,0,0));
        button3.addActionListener(e-> System.exit(0));
        
        buttonFrame=new JFrame();
        buttonFrame.setLayout(null);
        buttonFrame.setSize(bgwidth ,bgheight);
        buttonFrame.setTitle("Flappy Bird");
        buttonFrame.setResizable(false);
        
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("E:\\Flappy\\src\\Icon.png");
        buttonFrame.setIconImage(icon.getImage());
 
        
        myLabel.add(button);
        myLabel.add(button2);
        myLabel.add(button3);
        buttonFrame.add(myLabel);

        
        buttonFrame.setVisible(true);
         
    }
    
     static void Credit() {
        JButton b=new JButton("BACK");
        
        b.setBounds(128, 200, 100, 50);
        b.setBackground(new Color(49,220,215));
        b.setForeground(new Color(0,0,0));
        
        b.addActionListener(e-> menu());    
        b.addActionListener(e-> creditFrame.setVisible(false));


        creditFrame=new JFrame();
        
        creditFrame.setSize(bgwidth ,bgheight);
        creditFrame.setTitle("Flappy Bird");
        creditFrame.setResizable(false);
        
        creditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("E:\\Flappy\\src\\Icon.png");
        creditFrame.setIconImage(icon.getImage());
        Credits info=new Credits();
        info.setLayout(null);// for changing button b position
        info.add(b);
        creditFrame.add(info);
        
      
        
        creditFrame.setVisible(true);
    }

    static void game(){
        myframe=new JFrame();
        myframe.setSize(bgwidth,bgheight);
        myframe.setTitle("Flappy Bird");
        myframe.setResizable(false);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("E:\\Flappy\\src\\Icon.png");
        myframe.setIconImage(icon.getImage());

        FlappyBird flappyBird=new FlappyBird();
        myframe.add(flappyBird);
        myframe.pack();
        flappyBird.requestFocus();
        myframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }
 

   
}
