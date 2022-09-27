/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Press W to move player one's flag up
 * Press UP arrow key to move player two's flag up
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class flagRace extends JApplet{
    @Override
    public void init(){
        add(new flagRace_Engine());
    }
}
class flagRace_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    Flag p1;
    Flag p2;
    int p1Score;
    int p2Score;
    boolean p1Win;
    boolean p2Win;
    boolean go;
    int count;
    int timer;
    boolean countdown;
    public flagRace_Engine(){
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        ch = 0;
        // mouseListener
        addMouseListener(this);
        mX = 0;
        mY = 0;
        // ^^^^^^^^^^^
        p1 = new Flag(150,650,false);
        p2 = new Flag(600,650,false);
        p1Score = 0;
        p2Score = 0;
        p1Win = false;
        p2Win = false;
        go = false;
        countdown = false;
        count = 3;
        timer = 0;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W && go){
            p1.press = false;
        }
        if(ch == KeyEvent.VK_UP && go){
            p2.press = false;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W && !p1.press && !(p1Win || p2Win) && go){
            p1.y-=5;
            p1.press = true;
        }
        if(ch == KeyEvent.VK_UP && !p2.press && !(p1Win || p2Win) && go){
            p2.y-=5;
            p2.press = true;
        }
        if(ch == KeyEvent.VK_R && (p1Win || p2Win)){
            p1Win = false;
            p2Win = false;
            p1.y = 650;
            p2.y = 650;
            p1.press = false;
            p2.press = false;
            timer = 0;
            countdown = false;
            go = false;
            count = 3;
        }
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
        if(!go && !countdown){
            timer = 0;
            count = 3;
            countdown = true;
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,50));
        p1.drawFlag(g,Color.red);
        g.drawString("Player one - "+p1Score,90,50);
        p2.drawFlag(g,Color.blue);
        g.drawString("Player two - "+p2Score,565,50);
        g.setColor(Color.black);
        g.fillOval(115,115,45,45);
        g.fillRect(125,150,25,650);
        g.fillOval(565,115,45,45);
        g.fillRect(575,150,25,650);
        g.setColor(Color.green);
        if(count == 0){
            go = true;
            countdown = false;
        }
        if(countdown){
            timer++;
            g.drawString(""+count,450,300);
        }
        else if(go && !p1Win && !p2Win){
            g.drawString("Go!",450,300);
        }
        else if(!(p1Win || p2Win)){
            g.drawString("Click anywhere",300,300);
            g.drawString("  to start",350,350);
        }
        if(timer == 100){
            count--;
            timer = 0;
        }
        if(p1.y <= 160 && !p1Win){
            p1Win = true;
            p1Score++;
        }
        if(p2.y <= 160 && !p2Win){
            p2Win = true;
            p2Score++;
        }
        if(p1Win){
            g.drawString("Player 1 wins!",300,100);
            g.drawString("Press R to restart",250,150);
        }
        else if(p2Win){
            g.drawString("Player 2 wins!",300,100);
            g.drawString("Press R to restart",250,150);
        }
        try{
            Thread.sleep(5);
        }catch(Exception e){}
        repaint();
    }
}