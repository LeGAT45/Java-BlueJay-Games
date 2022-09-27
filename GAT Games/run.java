import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class run extends JApplet{
    @Override
    public void init(){
        add(new run_Engine());
    }
}
class run_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    //high score 58 Jaylen
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
    Guy p = new Guy(400,15);
    boolean left;
    boolean right;
    ArrayList<Pipe> obj;
    int time;
    Random rand;
    boolean dead;
    int score;
    int diff;
    boolean pause;
    String scorestring;
    int f;
    int d;
    boolean cheat;
    boolean speed;
    int counter;
    boolean n;
    public run_Engine(){
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
        right = false;
        left = false;
        obj = new ArrayList<Pipe>();
        time = 0;
        rand = new Random();
        obj.add(new Pipe(400,0));
        dead = false;
        diff = 0;
        score = 0;
        pause = false;
        scorestring = "";
        f = 0;
        d = 0;
        cheat = false;
        speed = false;
        counter = 0;
        n = false;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
        kTyped = true;
    }
    public void keyReleased(KeyEvent k){
        kReleased = true;
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            left = false;
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            right = false;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        kPressed = true;
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            left = true;
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            right = true;
        }
        else if(ch == KeyEvent.VK_R){
            p.x = 400;
            dead = false;
            pause = false;
            for(int count = obj.size()-1;count !=-1;count--){
                 obj.remove(count);
            }
            obj.add(new Pipe(400,0));
            score = 0;
            diff = 0;
            time = 0;
        }
        else if(ch == KeyEvent.VK_P){
            pause = !pause;
        }
        else if(ch == KeyEvent.VK_J){
            cheat = !cheat;
        }
        else if(ch == KeyEvent.VK_K){
            speed = !speed;
        }
        else if(ch == KeyEvent.VK_N){
            n = !n;
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
        setBackground(Color.black);
        p.drawGuy(g,f,d,n);
        // drawing objects
        g.setColor(Color.white);
        for(int count = 0;count != obj.size();count++){
            g.fillRect(0,obj.get(count).y-50,obj.get(count).x -(100-diff),50);
            g.fillRect(obj.get(count).x +(100-diff),obj.get(count).y-50,800 - obj.get(count).x +(100-diff),50);
        }
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.setColor(Color.blue);
        scorestring = score + "";
        g.drawString(scorestring,795 -(scorestring.length()*30),50);
        if(dead){
            g.drawString("You died!",250,400);
        }
        if(pause){
            g.fillRect(380,350,10,50);
            g.fillRect(410,350,10,50);
        }
        if(!dead && !pause){
        //moving guy
        if(!cheat){
            if(left && !(p.x < 40)){
                p.x -= p.s;
                d = 0;
                if(f != 4 && counter == 0){
                    f++;
                    counter = 2;
                }
                else if(counter == 0){
                    f = 1;
                    counter = 2;
                }
            }
            else if(right && !(p.x > 760)){
                p.x += p.s;
                d = 1;
                if(f != 4 && counter == 0){
                    f++;
                    counter = 2;
                }
                else if(counter == 0){
                    f = 1;
                    counter = 2;
                }
            }
            else{
                f = 0;
                counter = 0;
            }
        }
        // changing speed
        p.s = 15 + diff/5;
        // AI movement
        if(cheat){
            if(obj.get(obj.size()-1).x-(100-diff) > p.x-10){
                p.x += p.s;
                d = 1;
                if(f != 4 && counter == 0){
                    f++;
                    counter = 2;
                }
                else if(counter == 0){
                    f = 1;
                    counter = 2;
                }
            }
            else if(obj.get(obj.size()-1).x+(100-diff) < p.x+19){
                p.x -= p.s;
                d = 0;
                if(f != 4 && counter == 0){
                    f++;
                    counter = 2;
                }
                else if(counter == 0){
                    f = 1;
                    counter = 2;
                }
            }
            else{
                f = 0;
                counter = 0;
            }
        }
        // creating new objects
        if(time >= 80-diff && diff < 40){
            time = 0;
            obj.add(0,new Pipe(rand.nextInt(700)+100,0));
        }
        else if(time >= 80-40 && diff >= 40){
            time = 0;
            obj.add(0,new Pipe(rand.nextInt(700)+100,0));
        }
        time++;
        if(counter > 0){
            counter--;
        }
        // detecting if you hit an object
        if((p.x-5<obj.get(obj.size()-1).x - (100-diff) && obj.get(obj.size()-1).y > 670) || (p.x+5>obj.get(obj.size()-1).x + (100-diff) && obj.get(obj.size()-1).y > 670)){
            dead = true;
        }
        // removing objects
        if(obj.get(obj.size()-1).y >= 800){
            obj.remove(obj.size()-1);
            score++;
            if(diff != 50){
                diff++;
            }
        }
        // moving objects
        for(int count = 0;count != obj.size();count++){
            obj.get(count).y += 10;
        }
        }
        try{
            if(!speed){
                Thread.sleep(30);
            }
        }catch(Exception e){}
        repaint();
    }
}