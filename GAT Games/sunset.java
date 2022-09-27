import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class sunset extends JApplet{
    @Override
    public void init(){
        add(new sunset_Engine());
    }
}
class sunset_Engine extends JPanel implements MouseListener, KeyListener{
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
    Son s;
    int change;
    public sunset_Engine(){
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
        s = new Son(75,50,475,1,5);
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
        s.drawSun(g,50);
        s.x += s.s * s.d;
        s.y -= (int)Math.round((s.s)*Math.tan(Math.toRadians(s.a)));
        g.drawString(""+s.a,100,100);
        if(15-s.s > 2){
            s.a -= 15-s.s;
        }
        else{
            s.a -= 2;
        }
        if(s.y > 475){
            s.a = 75;
            s.y = 475;
        }
        if(s.x < 25){
            s.d *= -1;
            if(s.s != 15){
                s.s += 1;
            }
        }
        else if(s.x > 475){
            s.d *= -1;
            if(s.s != 15){
                s.s += 1;
            }
        }
        if(s.y < 25){
            s.a *=-1;
            s.y = 25;
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}