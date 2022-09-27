import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Forza_Horizon_5 extends JApplet{
    @Override
    public void init(){
        add(new Forza_Horizon_5_Engine());
    }
}
class Forza_Horizon_5_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    Car c1;
    Car c2;
    ArrayList<object2>Obj;
    ArrayList<Car>Cars;
    public Forza_Horizon_5_Engine(){
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
        Obj = new ArrayList<object2>();
        Cars = new ArrayList<Car>();
        Obj.add(new object2(500,500,100,100));
        c1 = new Car(200,200,0,10,false,false,false,false,false,false,false,false);
        c2 = new Car(200,200,0,10,false,false,false,false,false,false,false,false);
        Cars.add(c1);
        Cars.add(c2);
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W){
            c1.forward = false;
            c1.tempForward = false;
        }
        if(ch == KeyEvent.VK_S){
            c1.reverse = false;
            c1.tempReverse = false;
        }
        if(ch == KeyEvent.VK_A){
            c1.left = false;
        }
        if(ch == KeyEvent.VK_D){
            c1.right =false;
        }
        if(ch == KeyEvent.VK_UP){
            c2.forward = false;
            c2.tempForward = false;
        }
        if(ch == KeyEvent.VK_DOWN){
            c2.reverse = false;
            c2.tempReverse = false;
        }
        if(ch == KeyEvent.VK_LEFT){
            c2.left = false;
        }
        if(ch == KeyEvent.VK_RIGHT){
            c2.right =false;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W){
            c1.forward = true;
            c1.tempForward = true;
        }
        if(ch == KeyEvent.VK_S){
            c1.reverse = true;
            c1.tempReverse = true;
        }
        if(ch == KeyEvent.VK_A){
            c1.left = true;
        }
        if(ch == KeyEvent.VK_D){
            c1.right = true;
        }
        if(ch == KeyEvent.VK_UP){
            c2.forward = !false;
            c2.tempForward = !false;
        }
        if(ch == KeyEvent.VK_DOWN){
            c2.reverse = !false;
            c2.tempReverse = !false;
        }
        if(ch == KeyEvent.VK_LEFT){
            c2.left = !false;
        }
        if(ch == KeyEvent.VK_RIGHT){
            c2.right = !false;
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
        setBackground(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,10));
        g.setColor(Color.white);
        for(int count2 = 0;count2 != Cars.size();count2++){
            // temp track
            if(Cars.get(count2).left){
                Cars.get(count2).a += 10;
            }
            if(Cars.get(count2).right){
                Cars.get(count2).a -= 10;
            }
            if(Cars.get(count2).tempForward){
                Cars.get(count2).forward = true;
            }
            if(Cars.get(count2).tempReverse){
                Cars.get(count2).reverse = true;
            }
            //if(
            for(int count = 0;count != Obj.size();count++){
                g.fillRect(Obj.get(count).x,Obj.get(count).y,Obj.get(count).width,Obj.get(count).height);
                //Left point
                if(Cars.get(count2).forward&&(Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a+90)))+Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a+90)))+Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a+90)))-Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a+90)))-Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                    Cars.get(count2).forward = false;
                }
                if(Cars.get(count2).reverse&&(Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a+90)))-Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a+90)))-Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a+90)))+Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a+90)))+Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                    Cars.get(count2).reverse = false;
                }
                if(!Cars.get(count2).reverse && !Cars.get(count2).forward && (Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a+90)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a+90)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a+90)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a+90)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                }
                //right point
                if(Cars.get(count2).forward&&(Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a-90)))+Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a-90)))+Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a-90)))-Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a-90)))-Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                    Cars.get(count2).forward = false;
                }
                if(Cars.get(count2).reverse&&(Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a-90)))-Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a-90)))-Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a-90)))+Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a-90)))+Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                    Cars.get(count2).reverse = false;
                }
                if(!Cars.get(count2).reverse && !Cars.get(count2).forward && (Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a-90)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(10*Math.cos(Math.toRadians(Cars.get(count2).a-90)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a-90)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(10*Math.sin(Math.toRadians(Cars.get(count2).a-90)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                }
                //Nose 
                if(Cars.get(count2).forward&&(Cars.get(count2).x+(int)Math.round(45*Math.cos(Math.toRadians(Cars.get(count2).a)))+Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(45*Math.cos(Math.toRadians(Cars.get(count2).a)))+Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(45*Math.sin(Math.toRadians(Cars.get(count2).a)))-Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(45*Math.sin(Math.toRadians(Cars.get(count2).a)))-Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                    Cars.get(count2).forward = false;
                }
                if(Cars.get(count2).reverse&&(Cars.get(count2).x+(int)Math.round(45*Math.cos(Math.toRadians(Cars.get(count2).a)))-Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(45*Math.cos(Math.toRadians(Cars.get(count2).a)))-Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(45*Math.sin(Math.toRadians(Cars.get(count2).a)))+Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(45*Math.sin(Math.toRadians(Cars.get(count2).a)))+Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                    Cars.get(count2).reverse = false;
                }
                if(!Cars.get(count2).reverse && !Cars.get(count2).forward && (Cars.get(count2).x+(int)Math.round(45*Math.cos(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).x && Cars.get(count2).x+(int)Math.round(45*Math.cos(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).x+Obj.get(count).width && Cars.get(count2).y-(int)Math.round(45*Math.sin(Math.toRadians(Cars.get(count2).a)))>Obj.get(count).y && Cars.get(count2).y-(int)Math.round(45*Math.sin(Math.toRadians(Cars.get(count2).a)))<Obj.get(count).y+Obj.get(count).height)){
                    if(Cars.get(count2).left){
                        Cars.get(count2).uLeft = true;
                    }
                    if(Cars.get(count2).right){
                        Cars.get(count2).uRight = true;
                    }
                }
            }
            if(Cars.get(count2).uLeft){
                Cars.get(count2).a-=10;
                Cars.get(count2).uLeft = false;
            }
            if(Cars.get(count2).uRight){
                Cars.get(count2).a+=10;
                Cars.get(count2).uRight = false;
            }
            if(Cars.get(count2).forward){
                Cars.get(count2).y -= Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)));
                Cars.get(count2).x += Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)));
            }
            if(Cars.get(count2).reverse){
                Cars.get(count2).y += Math.round(Cars.get(count2).speed*Math.sin(Math.toRadians(Cars.get(count2).a)));
                Cars.get(count2).x -= Math.round(Cars.get(count2).speed*Math.cos(Math.toRadians(Cars.get(count2).a)));
            }
            Cars.get(count2).drawCar(g);
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}