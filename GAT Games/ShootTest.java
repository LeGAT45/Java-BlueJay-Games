import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class ShootTest extends JApplet{
    @Override
    public void init(){
        add(new ShootTest_Engine());
    }
}
class ShootTest_Engine extends JPanel implements MouseMotionListener, MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    Basketball s;
    boolean move;
    public ShootTest_Engine(){
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        // mouseListener
        addMouseListener(this);
        //mouseMotionLister
        addMouseMotionListener(this);
        mX = 0;
        mY = 0;
        // ^^^^^^^^^^^
        s = new Basketball(0,800,400,1,5,1);
        move = false;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_R){
            move = false;
            s.x = 800;
            s.y = 400;
            s.u = 1;
            s.d = 1;
            s.s = 5;
        }
    }
    //mouseMotionListener
    public void mouseDragged(MouseEvent me){
    }
    public void mouseMoved(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
    }
    // mouseListener class methods
    public void mouseEntered(MouseEvent me){
    }
    public void mouseExited(MouseEvent me){
    }
    public void mouseClicked(MouseEvent me){
    }
    public void mouseReleased(MouseEvent me){
    }
    public void mousePressed(MouseEvent me){
        move = true;
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(117,174,217));
        s.a = Math.toDegrees(Math.atan(Math.abs(((double)s.y-mY)/(mX-s.x))));
        if(mX < s.x && s.d == 1){
            s.d *= -1;
        }
        else if(mX > s.x && s.d == -1){
            s.d *= -1;
        }
        if(mY > s.y && s.u == 1){
            s.u *= -1;
        }
        else if(mY < s.y && s.u == -1){
            s.u *= -1;
        }
        if(move){
            s.y -= Math.round(50*Math.sin(Math.toRadians(s.a))) * s.u;
            s.x += Math.round(50*Math.cos(Math.toRadians(s.a))) * s.d;
        }
        s.drawBall(g,50);
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}