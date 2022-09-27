import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Spirogram extends JApplet{
    @Override
    public void init(){
        add(new Spirogram_Engine());
    }
}
class Spirogram_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    c c1;
    c c2;
    int x;
    int y;
    ArrayList<Point>point;
    boolean pause;
    int re;
    boolean color;
    ArrayList<co>colors;
    Random rand;
    int large;
    boolean l;
    public Spirogram_Engine(){
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
        pause = false;
        // ^^^^^^^^^^^
        // small circle
        c2 = new c(0,0,0,/*radius*/100);
        // big circle
        c1 = new c(/*center x*/800,/*center y*/400,0,/*radius*/300);
        point = new ArrayList<Point>();
        colors = new ArrayList<co>();
        re = 35;
        rand = new Random();
        color = !true;
        large = 5;
        l = true;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_P){
            pause = !pause;
        }
        else if(ch == KeyEvent.VK_S){
            if(re == 35){
                re = 0;
            }
            else{
                re = 35;
            }
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
        mX = me.getX();
        mY = me.getY();
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        if(color){
            g2.setStroke(new BasicStroke(large));
            if(large == 15 || large == 3){
                l = !l;
            }
            if(l){
                large++;
            }
            else{
                large--;
            }
        }
        else{
            g2.setStroke(new BasicStroke(5));
        }
        g.setFont(new Font("Arial",Font.BOLD,10));
        g.setColor(Color.white);
        
        c2.x = c1.x+(int)Math.round((c1.r-c2.r)*(Math.cos(Math.toRadians(c1.a))));
        c2.y = c1.y-(int)Math.round((c1.r-c2.r)*(Math.sin(Math.toRadians(c1.a))));
        x = c2.x+(int)Math.round(c2.r*(Math.cos(Math.toRadians(c2.a))));
        y = c2.y-(int)Math.round(c2.r*(Math.sin(Math.toRadians(c2.a))));
        
        if(!pause){
            //c1.a -= 10;
            //c2.a -= 21;
            //
            //c1.a -= 7;
            //c2.a -= 15;
            //
            //c1.a += 175;
            //c2.a += 1442;
            //
            //c1.a += 123;
            //c2.a += 196;
            // olympic rings
            //c1.a += 60;
            //c2.a += 200789798;
            //
            //c1.a += 576;
            //c2.a += 43;
            // donut
            //c1.a += 5676467;
            //c2.a += 20078998;
            // square
            //c1.a += 90;
            //c2.a += 17;
            // spikey donut
            c1.a += 1;
            c2.a += 20076;
            // 
            //c1.a += 199;
            //c2.a += 200;
        }
        point.add(new Point(x,y));
        if(color){
            colors.add(new co(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
        }
        /*
        g.setColor(Color.red);
        // showing big circle angle
        g.drawLine(c1.x,c1.y,c1.x+(int)Math.round(c1.r*(Math.cos(Math.toRadians(c1.a)))),c1.y-(int)Math.round(c1.r*(Math.sin(Math.toRadians(c1.a)))));
        //
        g.drawOval(c1.x-c1.r,c1.y-c1.r,c1.r*2,c1.r*2);
        g.setColor(Color.blue);
        //showing small circle angle
        g.drawLine(c2.x,c2.y,c2.x+(int)Math.round(c2.r*(Math.cos(Math.toRadians(c2.a)))),c2.y-(int)Math.round(c2.r*(Math.sin(Math.toRadians(c2.a)))));
        //
        g.drawOval(c2.x-c2.r,c2.y-c2.r,c2.r*2,c2.r*2);
        g.fillOval(x,y,5,5);
        */
        g.setColor(Color.black);
        for(int count = 0;count != point.size();count++){
            /*if(count == point.size()-1){
                g.setColor(Color.green);
                g.fillOval(point.get(count).x-5,point.get(count).y-5,10,10);
            }
            else{
                g.setColor(Color.black);
                g.fillOval(point.get(count).x-4,point.get(count).y-4,8,8);
            }*/
            if(color){
                g.setColor(new Color(colors.get(count).red,colors.get(count).blue,colors.get(count).green));
            }
            if(count != point.size()-1){
                g.drawLine(point.get(count).x,point.get(count).y,point.get(count+1).x,point.get(count+1).y);
            }
        }
        try{
            Thread.sleep(re);
        }catch(Exception e){}
        repaint();
    }
}