import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Arcs extends JApplet{
    @Override
    public void init(){
        add(new Arcs_Engine());
    }
}
class Arcs_Engine extends JPanel implements MouseListener, KeyListener{
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
    boolean w;
    public Arcs_Engine(){
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
        w = false;
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
        if(ch == KeyEvent.VK_W){
            w = !w;
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
        g.setColor(Color.red);
        g.fillRect(150,50,200,200);
        g.setColor(Color.yellow);
        if(!w){
            g.drawArc(175,100,75,225,0,180);
            g.drawArc(250,100,75,225,0,180);
        }
        else{
            g.drawArc(175,-25,75,225,180,180);
            g.drawArc(250,-25,75,225,180,180);
        }
        g.setColor(Color.black);
        g.fillRect(225,250,50,400);
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}