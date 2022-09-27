import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class UnblockMe extends JApplet{
    @Override
    public void init(){
        add(new UnblockMe_Engine());
    }
}
class UnblockMe_Engine extends JPanel implements MouseListener, KeyListener, MouseMotionListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<B>blocks;
    boolean once;
    int cur;
    int m;
    boolean in;
    boolean dont;
    int cX;
    int cY;
    boolean win;
    int side;
    public UnblockMe_Engine(){
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        ch = 0;
        // mouseListener
        addMouseListener(this);
        addMouseMotionListener(this);
        mX = 0;
        mY = 0;
        // ^^^^^^^^^^^
        once = false;
        cur = -1;
        m = 0;
        in = false;
        dont = false;
        cX = 0;
        cY = 0;
        side = 2;
        win = false;
        blocks = new ArrayList<B>();
        blocks.add(new B(50+(100*1),150+(100*2),200,100,2));
        blocks.add(new B(50+(100*0),150+(100*0),200,100,0));
        blocks.add(new B(50+(100*0),150+(100*1),100,200,1));
        blocks.add(new B(50+(100*0),150+(100*4),200,100,0));
        blocks.add(new B(50+(100*0),150+(100*5),300,100,0));
        blocks.add(new B(50+(100*2),150+(100*3),100,200,1));
        blocks.add(new B(50+(100*3),150+(100*0),100,300,1));
        blocks.add(new B(50+(100*4),150+(100*0),100,200,1));
        blocks.add(new B(50+(100*5),150+(100*0),100,200,1));
        blocks.add(new B(50+(100*3),150+(100*3),300,100,0));
        blocks.add(new B(50+(100*4),150+(100*4),100,200,1));
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
    }
    // mouseListener class methods
    public void mouseEntered(MouseEvent me){
    }
    public void mouseExited(MouseEvent me){
    }
    public void mouseClicked(MouseEvent me){
    }
    public void mouseReleased(MouseEvent me){
        once = false;
        dont = false;
        /*if(blocks.get(cur).x1%100>=50 && (blocks.get(cur).type == 0 || blocks.get(cur).type == 2)){
            blocks.get(cur).x1 = (blocks.get(cur).x1-50)/100*100+100;
        }
        else if(blocks.get(cur).x1%100<50 && (blocks.get(cur).type == 0 || blocks.get(cur).type == 2)){
            blocks.get(cur).x1 = blocks.get(cur).x1/100*100+50;
        }
        else if(blocks.get(cur).y1%100>=50 && (blocks.get(cur).type == 1 || blocks.get(cur).type == 3)){
            blocks.get(cur).y1 = blocks.get(cur).y1/100*100+100+50;
        }
        else if(blocks.get(cur).y1%100<50 && (blocks.get(cur).type == 1 || blocks.get(cur).type == 3)){
            blocks.get(cur).y1 = blocks.get(cur).y1/100*100+50;
        }*/
    }
    public void mouseMoved(MouseEvent me){
    }
    public void mousePressed(MouseEvent me){
        if(!once){
            mX = me.getX();
            mY = me.getY();
            cX = mX;
            cY = mY;
            for(int count = 0;count != blocks.size();count++){
                if(mX>blocks.get(count).x1 && mX<blocks.get(count).x1 + blocks.get(count).x2 && mY>blocks.get(count).y1 && mY< blocks.get(count).y1+blocks.get(count).y2){
                    cur = count;
                    break;
                }
            }
        }
        once = true;
    }
    public void mouseDragged(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
        if(blocks.get(cur).type == 0 || blocks.get(cur).type == 2){
            m = mX-cX;
            cX+=m;
        }
        else if(blocks.get(cur).type == 1 || blocks.get(cur).type == 3){
            m = mY-cY;
            cY+=m;
        }
        for(int count = 0;count != blocks.size();count++){
            if(count == cur){
                continue;
            }
            if((blocks.get(cur).type == 0 || blocks.get(cur).type == 2) && ((blocks.get(cur).x1+m < blocks.get(count).x1 + blocks.get(count).x2 && blocks.get(cur).x1+m > blocks.get(count).x1) || (blocks.get(cur).x1+blocks.get(cur).x2+m < blocks.get(count).x1 + blocks.get(count).x2 && blocks.get(cur).x1+blocks.get(cur).x2+m > blocks.get(count).x1)) && ((blocks.get(cur).y1 < blocks.get(count).y1+blocks.get(count).y2 && blocks.get(cur).y1 > blocks.get(count).y1) || (blocks.get(cur).y1+blocks.get(cur).y2 < blocks.get(count).y1+blocks.get(count).y2 && blocks.get(cur).y1+blocks.get(cur).y2 > blocks.get(count).y1))){
                if(blocks.get(cur).x1+m < blocks.get(count).x1 + blocks.get(count).x2 && blocks.get(cur).x1+m > blocks.get(count).x1){
                    if(!dont){
                        blocks.get(cur).x1 = blocks.get(count).x1+blocks.get(count).x2;
                    }
                }
                else if(blocks.get(cur).x1+blocks.get(cur).x2+m < blocks.get(count).x1 + blocks.get(count).x2 && blocks.get(cur).x1+blocks.get(cur).x2+m > blocks.get(count).x1){
                    if(!dont){
                        blocks.get(cur).x1 = blocks.get(count).x1-blocks.get(cur).x2;
                    }
                }
                dont = true;
            }
            else if((blocks.get(cur).type == 1 || blocks.get(cur).type == 3) && ((blocks.get(cur).y1+m < blocks.get(count).y1 + blocks.get(count).y2 && blocks.get(cur).y1+m > blocks.get(count).y1) || (blocks.get(cur).y1+blocks.get(cur).y2+m < blocks.get(count).y1 + blocks.get(count).y2 && blocks.get(cur).y1+blocks.get(cur).y2+m > blocks.get(count).y1)) && ((blocks.get(cur).x1 < blocks.get(count).x1+blocks.get(count).x2 && blocks.get(cur).x1 > blocks.get(count).x1) || (blocks.get(cur).x1+blocks.get(cur).x2 < blocks.get(count).x1+blocks.get(count).x2 && blocks.get(cur).x1+blocks.get(cur).x2 > blocks.get(count).x1))){
                if(blocks.get(cur).y1+m < blocks.get(count).y1 + blocks.get(count).y2 && blocks.get(cur).y1+m > blocks.get(count).y1){
                    if(!dont){
                        blocks.get(cur).y1 = blocks.get(count).y1+blocks.get(count).y2;
                    }
                }
                else if(blocks.get(cur).y1+blocks.get(cur).y2+m < blocks.get(count).y1 + blocks.get(count).y2 && blocks.get(cur).y1+blocks.get(cur).y2+m > blocks.get(count).y1){
                    if(!dont){
                        blocks.get(cur).y1 = blocks.get(count).y1-blocks.get(cur).y2;
                    }
                }
                dont = true;
            }
        }
        if((blocks.get(cur).type == 0 || blocks.get(cur).type == 2) && !(blocks.get(cur).x1+m<50 || blocks.get(cur).x1+blocks.get(cur).x2+m>650)){
            if(!dont){
                blocks.get(cur).x1+=m;
            }
        }
        else if((blocks.get(cur).type == 1 || blocks.get(cur).type == 3) && !(blocks.get(cur).y1+m<150 || blocks.get(cur).y1+blocks.get(cur).y2+m>750)){
            if(!dont){
                blocks.get(cur).y1+=m;
            }
        }
        else if((blocks.get(cur).type == 0 || blocks.get(cur).type == 2)){
            if(blocks.get(cur).x1+m<50){
                if(!dont){
                    blocks.get(cur).x1 = 50;
                }
            }
            else if(blocks.get(cur).x1+blocks.get(cur).x2+m>650){
                if(!dont){
                    blocks.get(cur).x1 = 650-blocks.get(cur).x2;
                }
            }
        }
        else if((blocks.get(cur).type == 1 || blocks.get(cur).type == 3)){
            if(blocks.get(cur).y1+m<150){
                if(!dont){
                    blocks.get(cur).y1 = 150;
                }
            }
            else if(blocks.get(cur).x1+blocks.get(cur).y2+m>750){
                if(!dont){
                    blocks.get(cur).y1 = 750-blocks.get(cur).y2;
                }
            }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(150,100,50));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.setColor(Color.black);
        // black border
        g.drawRect(50-5,150-5,600+10,600+10);
        // exit hole
        g.setColor(new Color(150,100,50));
        g.fillRect(650,350,10,100);
        // win detection
        for(int count = 0;count != blocks.size();count++){
            if(blocks.get(count).type == 2 || blocks.get(count).type == 3){
                if(side == 1 && blocks.get(count).type == 3 && blocks.get(count).y1 <= 150){
                    win = true;
                }
                else if(side == 2 && blocks.get(count).type == 2 && blocks.get(count).x1+blocks.get(count).x2 >= 650){
                    win = true;
                }
                else if(side == 3 && blocks.get(count).type == 3 && blocks.get(count).y1+blocks.get(count).y2>=750){
                    win = true;
                }
                else if(side == 4 && blocks.get(count).type == 2 && blocks.get(count).x1 <= 50){
                    win = true;
                }
            }
        }
        for(int count = 0;count != blocks.size();count++){
            blocks.get(count).drawBlock(g);
        }
        if(win){
            g.setColor(Color.red);
            g.drawString("Puzzle Complete",300,300);     
        }
        try{
            Thread.sleep(0);
        }catch(Exception e){}
        repaint();
    }
}