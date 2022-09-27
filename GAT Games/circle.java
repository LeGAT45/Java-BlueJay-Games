import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class circle extends JApplet{
    @Override
    public void init(){
        add(new circle_Engine());
    }
}
class circle_Engine extends JPanel implements MouseListener, KeyListener{
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
    Sun s;
    int change;
    boolean eight;
    int increment;
    ArrayList<Marker> marks;
    boolean stop;
    Random rand;
    public circle_Engine(){
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
        s = new Sun(0,250,250,1,5,2);
        eight = false;
        increment = 0;
        marks = new ArrayList<Marker>();
        stop = false;
        rand = new Random();
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
        //s.drawSun(g,50);
        //g.setColor(Color.red);
        //g.fillOval(250,250,10,10);
        //g.setColor(Color.black);
        for(int count = 0;count != marks.size();count++){
            g.setColor(marks.get(count).c);
            //g.setColor(Color.black);
            if(marks.get(count).size == 55){
                marks.get(count).rev = true;
            }
            else if(marks.get(count).size == 0){
                marks.get(count).rev = false;
            }
            //marks.get(count).size = rand.nextInt(50)+1;
            g.fillOval(marks.get(count).x-((int)marks.get(count).size/2),marks.get(count).y-((int)marks.get(count).size/2),marks.get(count).size,marks.get(count).size);
            if(marks.get(count).rev){
                marks.get(count).size -= 5;
            }
            else if(!marks.get(count).rev){
                marks.get(count).size += 5;
            }
            //marks.get(count).c = new Color(rand.nextInt(250),rand.nextInt(250),rand.nextInt(250));
            //g.drawOval(marks.get(count).x-25,marks.get(count).y-25,50,50);
        }
        if(!stop){
        s.y -= Math.round(10*(Math.sin(Math.toRadians(s.a))));
        s.x += Math.round(10*(Math.cos(Math.toRadians(s.a))));
        /*if(eight){
            s.a -= 10;
        }
        else{
            s.a -= 5;
        }*/
        s.a += 5;
        marks.add(new Marker(s.x,s.y,new Color(rand.nextInt(250),rand.nextInt(250),rand.nextInt(250)),25,false));
        if(s.x == 250 && s.y == 250){
            increment += 50;
            if(increment >= 350){
                increment = 0;
                eight = true;
                if(eight == true){
                    stop = true;
                }
            }
            s.a = increment;
        }
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        repaint();
    }
}