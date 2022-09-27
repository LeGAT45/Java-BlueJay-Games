import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class FlappyBird extends JApplet{
    @Override
    public void init(){
        add(new FlappyBird_Engine());
    }
}
class FlappyBird_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    boolean kTyped;
    boolean kReleased;
    boolean kPressed;
    // mouseListener
    int mX;
    int mY;
    boolean mEntered;
    boolean mClick;
    boolean mReleased;
    boolean mPressed;
    // ^^^^^^^^^^^^^
    Bird b;
    boolean start;
    ArrayList<Pipe> obj;
    Random rand;
    boolean dead;
    int score;
    boolean pause;
    boolean one;
    public FlappyBird_Engine(){
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        ch = 0;
        kTyped = false;
        kReleased = false;
        kPressed = false;
        // mouseListener
        addMouseListener(this);
        mX = 0;
        mY = 0;
        mEntered = true;
        mClick = false;
        mReleased = false;
        mPressed = false;
        // ^^^^^^^^^^^
        b = new Bird(375,15);
        start = true;
        obj = new ArrayList<Pipe>();
        rand = new Random();
        obj.add(0,new Pipe(700,rand.nextInt(530)+70));
        obj.add(0,new Pipe(1050,rand.nextInt(530)+70));
        dead = false;
        score = 0;
        pause = false;
        one = true;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
        kTyped = true;
    }
    public void keyReleased(KeyEvent k){
        kReleased = true;
        //to detect if a key is held:
        //put ch = k.getKeyCode(); here and then check if kReleased = true 
        //AND that the key that was released is the same key that was pressed originally
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        kPressed = true;
        if(ch == KeyEvent.VK_SPACE){
            if(start){
                start = false;
            }
            if(!pause){
                b.a = 20;
            }
            else{
                pause = false;
            }
        }
        else if(ch == KeyEvent.VK_R){
            start = true;
            b.y = 375;
            b.a = 15;
            obj.get(0).x = 700;
            obj.get(0).y = rand.nextInt(530)+70;
            obj.get(1).x = 1050;
            obj.get(1).y = rand.nextInt(530)+70;
            score = 0;
            dead = false;
        }
        else if(ch == KeyEvent.VK_P){
            pause = !pause;
        }
    }
    // mouseListener class methods
    public void mouseEntered(MouseEvent me){
        mEntered = true;
    }
    public void mouseExited(MouseEvent me){
        mEntered = false;
    }
    public void mouseClicked(MouseEvent me){
        mClick = true;
    }
    public void mouseReleased(MouseEvent me){
        mReleased = true;
    }
    public void mousePressed(MouseEvent me){
        mPressed = true;
        mX = me.getX();
        mY = me.getY();
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(117,174,217));
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.setColor(Color.yellow);
        g.fillOval(250,b.y,50,50);
        g.setColor(Color.green);
        for(int count = 0;count != obj.size();count++){
            g.fillRect(obj.get(count).x-50,0,100,obj.get(count).y-100);
            g.fillRect(obj.get(count).x-50,obj.get(count).y+100,100,800);
        }
        g.setColor(Color.white);
        g.drawString(""+score,500,50);
        if(dead){
            g.drawString("You died!",200,300);
        }
        if(start || pause){
            g.drawString("Press space",150,250);
            g.drawString("to begin",180,300);
        }
        if(!start && !dead && !pause){
            if(b.y < 0){
                if(one){
                    b.a = 0;
                    one = false;
                }
                if(!(b.y - b.a < b.y)){
                    b.y -= b.a;
                }
            }
            else{
                b.y -= b.a;
                one = true;
            }
            b.a -=2;
            if(b.y > 750){
                dead = true;
            }
            for(int count = 0;count < obj.size();count++){
                obj.get(count).x -= 5;
                if(obj.get(count).x < -50){
                     obj.get(count).x = 650;
                     obj.get(count).y = rand.nextInt(530)+70;
                }
                if(obj.get(count).x == 300){
                    score++;
                }
                if(((275 < obj.get(count).x + 50 || 225 < obj.get(count).x + 25) && (275 > obj.get(count).x - 75 || 225 > obj.get(count).x - 50) && b.y < obj.get(count).y - 100) || ((275 < obj.get(count).x + 50 || 225 < obj.get(count).x + 25) && (275 > obj.get(count).x - 75 || 225 > obj.get(count).x - 50) && b.y > obj.get(count).y + 50)){
                    dead = true;
                }
            }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}