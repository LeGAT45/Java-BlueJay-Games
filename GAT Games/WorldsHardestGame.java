/*
 * CONTROLS:
 * 
 *  - WASD to move
 *  
 *  CONTROLS:
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class WorldsHardestGame extends JApplet{
    @Override
    public void init(){
        add(new WorldsHardestGame_Engine());
    }
}
class WorldsHardestGame_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<Obj> Obj;
    Pox p;
    ArrayList<Dot> Dots;
    boolean restart;
    int level;
    int temp;
    boolean tempB;
    boolean win;
    boolean dont;
    Random rand;
    int r;
    int pr;
    public WorldsHardestGame_Engine(){
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
        Obj = new ArrayList<Obj>();
        p = new Pox(150,400,false,false,false,false);
        Dots = new ArrayList<Dot>();
        restart = false;
        level = 1;
        temp = 0;
        tempB = true;
        win = false;
        dont = true;
        rand = new Random();
        r = 0;
        pr = 0;
        if(level == 1){
            Obj.add(new Obj(900,300,100,200,1));
            Dots.add(0,new Dot(525,400,2,10,300,110,300,690,1,1,false));
            Obj.add(0,new Obj(0,0,1600,300,0));
            Obj.add(0,new Obj(0,500,1600,300,0));
            Obj.add(0,new Obj(1000,300,600,200,0));
            for(int count = 0;count != 11;count++){
                if(tempB){
                    Dots.add(0,new Dot(280+temp,400,1,10,280+temp,320,280+temp,490,1,0,false));
                }
                else{
                    Dots.add(0,new Dot(280+temp,400,1,10,280+temp,320,280+temp,490,-1,0,false));
                }
                temp += 55;
                tempB = !tempB;
            }
        }
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W || ch == KeyEvent.VK_UP){
            p.up = false;
        }
        if(ch == KeyEvent.VK_S || ch == KeyEvent.VK_DOWN){
            p.down = false;
        }
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            p.left = false;
        }
        if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            p.right = false;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W || ch == KeyEvent.VK_UP){
            p.up = !false;
        }
        if(ch == KeyEvent.VK_S || ch == KeyEvent.VK_DOWN){
            p.down = !false;
        }
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            p.left = !false;
        }
        if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            p.right = !false;
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
        g.setFont(new Font("Arial",Font.BOLD,10));
        g.setColor(Color.black);
        g.fillRect(0,0,100,800);
        g.fillRect(100,0,1500,100);
        g.fillRect(100,700,1500,100);
        g.fillRect(1500,100,100,600);
        p.drawPox(g);
        for(int count = 0;count != Obj.size();count++){
            Obj.get(count).drawObj(g);
            if(Obj.get(count).type == 0){
                if((((p.x-15 > Obj.get(count).x && p.x-15 < Obj.get(count).x+Obj.get(count).xSize && p.y-15-5 > Obj.get(count).y && p.y-15-5 < Obj.get(count).y+Obj.get(count).ySize) || (p.x+15 > Obj.get(count).x && p.x+15 < Obj.get(count).x+Obj.get(count).xSize && p.y-15-5 > Obj.get(count).y && p.y-15-5 < Obj.get(count).y+Obj.get(count).ySize)) || p.y-15-5<100)){
                    p.up = false;
                }
                if((((p.x-15 > Obj.get(count).x && p.x-15 < Obj.get(count).x+Obj.get(count).xSize && p.y+15+5 > Obj.get(count).y && p.y+15+5 < Obj.get(count).y+Obj.get(count).ySize) || (p.x+15 > Obj.get(count).x && p.x+15 < Obj.get(count).x+Obj.get(count).xSize && p.y+15+5 > Obj.get(count).y && p.y+15+5 < Obj.get(count).y+Obj.get(count).ySize)) || p.y+15+5>700)){
                    p.down = false;
                }
                if((((p.y-15 > Obj.get(count).y && p.y-15 < Obj.get(count).y+Obj.get(count).ySize && p.x-15-5 > Obj.get(count).x && p.x-15-5 < Obj.get(count).x+Obj.get(count).xSize) || (p.y+15 > Obj.get(count).y && p.y+15 < Obj.get(count).y+Obj.get(count).ySize && p.x-15-5 > Obj.get(count).x && p.x-15-5 < Obj.get(count).x+Obj.get(count).xSize)) || p.x-15-5< 100)){
                    p.left = false;
                }
                if((((p.y-15 > Obj.get(count).y && p.y-15 < Obj.get(count).y+Obj.get(count).ySize && p.x+15+5 > Obj.get(count).x && p.x+15+5 < Obj.get(count).x+Obj.get(count).xSize) || (p.y+15 > Obj.get(count).y && p.y+15 < Obj.get(count).y+Obj.get(count).ySize && p.x+15+5 > Obj.get(count).x && p.x+15+5 < Obj.get(count).x+Obj.get(count).xSize)) || p.x+15+5>1500)){
                    p.right = false;
                }
            }
            else if(Obj.get(count).type == 1){
                dont = false;
                for(int count2 = 0;count2 != Dots.size();count2++){
                    if(Dots.get(count2).type == 2){
                        if(!Dots.get(count2).got){
                            dont = true;
                        }
                    }
                }
                if(((p.x-15-5 > Obj.get(count).x && p.x-15-5 < Obj.get(count).x+Obj.get(count).xSize && p.y-15-5 > Obj.get(count).y && p.y-15-5 < Obj.get(count).y+Obj.get(count).ySize) || (p.x-15-5 > Obj.get(count).x && p.x-15-5 < Obj.get(count).x+Obj.get(count).xSize && p.y-15-5 > Obj.get(count).y && p.y-15-5 < Obj.get(count).y+Obj.get(count).ySize) || (p.x+15+5 > Obj.get(count).x && p.x+15+5 < Obj.get(count).x+Obj.get(count).xSize && p.y+15+5 > Obj.get(count).y && p.y+15+5 < Obj.get(count).y+Obj.get(count).ySize) || (p.x+15+5 > Obj.get(count).x && p.x+15+5 < Obj.get(count).x+Obj.get(count).xSize && p.y-15-5 > Obj.get(count).y && p.y-15-5 < Obj.get(count).y+Obj.get(count).ySize))&&Obj.get(count).type == 1){
                    if(!dont){
                        win = true;
                    }
                }
            }
        }
        if(p.up && !(p.y-15-5<100)){
            p.y -= 5;
        }
        if(p.down && !(p.y+15+5>700)){
            p.y += 5;
        }
        if(p.left && !(p.x-15-5<100)){
            p.x -= 5;
        }
        if(p.right && !(p.x+15+5>1500)){
            p.x += 5;
        }
        for(int count = 0;count != Dots.size();count++){
            if(Dots.get(count).type == 2 && !Dots.get(count).got){
                Dots.get(count).drawDot(g);
            }
            if(Dots.get(count).type == 1){
                Dots.get(count).drawDot(g);
                if((Dots.get(count).x == Dots.get(count).x1 && Dots.get(count).y == Dots.get(count).y1) || (Dots.get(count).x == Dots.get(count).x2 && Dots.get(count).y == Dots.get(count).y2)){
                    Dots.get(count).u *= -1;
                    Dots.get(count).d *= -1;
                }
                Dots.get(count).x += Dots.get(count).speed*Dots.get(count).d;
                Dots.get(count).y += Dots.get(count).speed*Dots.get(count).u;
                /*g.fillOval(Dots.get(count).x1,Dots.get(count).y1,5,5);
                g.fillOval(Dots.get(count).x2,Dots.get(count).y2,5,5);*/
            }
            else if(Dots.get(count).type == 3){
                Dots.get(count).drawDot(g);
                for(int count2 = 0;count2 != Dots.get(count).turns.size();count2++){
                    if(Dots.get(count).x == Dots.get(count).turns.get(count2).x && Dots.get(count).y == Dots.get(count).turns.get(count2).y){
                        Dots.get(count).u = Dots.get(count).turns.get(count2).u;
                        Dots.get(count).d = Dots.get(count).turns.get(count2).d;
                    }
                }
                Dots.get(count).x += Dots.get(count).speed*Dots.get(count).d;
                Dots.get(count).y += Dots.get(count).speed*Dots.get(count).u;
            }
            if((Dots.get(count).x-10 > p.x-15 && Dots.get(count).x-10 < p.x+15 && Dots.get(count).y-10 > p.y-15 && Dots.get(count).y-10 < p.y+15)||(Dots.get(count).x+10 > p.x-15 && Dots.get(count).x+10 < p.x+15 && Dots.get(count).y-10 > p.y-15 && Dots.get(count).y-10 < p.y+15)||(Dots.get(count).x+10 > p.x-15 && Dots.get(count).x+10 < p.x+15 && Dots.get(count).y+10 > p.y-15 && Dots.get(count).y+10 < p.y+15)||(Dots.get(count).x-10 > p.x-15 && Dots.get(count).x-10 < p.x+15 && Dots.get(count).y+10 > p.y-15 && Dots.get(count).y+10 < p.y+15)){
                if(Dots.get(count).type != 2){
                    restart = true;
                }
                else{
                    Dots.get(count).got = true;
                }
            }
        }
        if(restart){
            restart = false;
            for(int count = 0;count != Dots.size();count++){
                if(Dots.get(count).type == 2){
                    Dots.get(count).got = false;
                }
            }
            if(level == 1){
                p.x = 150;
                p.y = 400;
            }
            else if(level == 2){
                p.x = 580;
                p.y = 620;
            }
            else if(level == 3){
                p.x = 580;
                p.y = 620;
            }
            else if(level == 4){
                p.x = 150;
                p.y = 440;
                temp = 0;
                Dots.clear();
                Dots.add(0,new Dot(525,450,2,10,300,110,300,690,1,1,false));
                for(int count = 0;count != 15;count++){
                    r = rand.nextInt(6)+1;
                    while(r == pr){
                        r = rand.nextInt(6)+1;
                    }
                    pr = r;
                    if(tempB){
                        if(r == 1 || r == 2 || count == 6 || count == 5){
                            Dots.add(0,new Dot(300+temp,450,1,5,300+temp,300,300+temp,600,1,0,false));
                        }
                        else if(r == 3 || r == 4){
                            Dots.add(0,new Dot(300+temp,450,1,10,300+temp,300,300+temp,600,1,0,false));
                        }
                        else if(r == 5 || r == 6){
                            Dots.add(0,new Dot(300+temp,450,1,15,300+temp,300,300+temp,600,1,0,false));
                        }
                    }
                    else{
                        if(r == 1 || r == 2 || count == 6 || count == 5){
                            Dots.add(0,new Dot(300+temp,450,1,5,300+temp,300,300+temp,600,-1,0,false));
                        }
                        else if(r == 4 || r == 3){
                            Dots.add(0,new Dot(300+temp,450,1,10,300+temp,300,300+temp,600,-1,0,false));
                        }
                        else if(r == 5 || r == 6){
                            Dots.add(0,new Dot(300+temp,450,1,15,300+temp,300,300+temp,600,-1,0,false));
                        }
                    }
                    temp += 41;
                    tempB = !tempB;
                }
            }
        }
        if(win){
            level++;
            win = false;
            if(level == 2){
                p.x = 580;
                p.y = 620;
                Dots.clear();
                Obj.clear();
                temp = 0;
                for(int count = 0;count != 6;count++){
                     temp += 70;
                     if(count == 0){
                         Dots.add(0,new Dot(490+temp,120+temp,1,10,560,120+temp,910,120+temp,0,-1,false));
                         Dots.add(0,new Dot(490+temp,610-temp,1,10,490+temp,190,490+temp,540,1,0,false));
                     }
                     else{
                         Dots.add(0,new Dot(490+temp,120+temp,1,10,560,120+temp,910,120+temp,0,1,false));
                         Dots.add(0,new Dot(490+temp,610-temp,1,10,490+temp,190,490+temp,540,-1,0,false));
                     }
                }
                Dots.add(0,new Dot(735,365,2,0,0,0,0,0,0,0,false));
                Obj.add(0,new Obj(0,0,530,800,0));
                Obj.add(0,new Obj(0,0,1600,160,0));
                Obj.add(0,new Obj(940,260,700,800,0));
                Obj.add(0,new Obj(630,570,1600,300,0));
                Obj.add(0,new Obj(1090,0,700,800,0));
                Obj.add(0,new Obj(990,160,100,100,1));
            }
            else if(level == 3){
                p.x = 580;
                p.y = 620;
                Dots.clear();
                Obj.clear();
                temp = 0;
                for(int count = 0;count != 5;count++){
                     temp += 35;
                     Dots.add(0,new Dot(525+temp,365,3,5,0,0,0,0,-1,0,false));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365-temp,0,1));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365-temp,1,0));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365+temp,0,-1));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365+temp,-1,0));
                }
                temp = 0;
                for(int count = 0;count != 5;count++){
                     temp += 35;
                     Dots.add(0,new Dot(945-temp,365,3,5,0,0,0,0,1,0,false));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365-temp,0,1));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365-temp,1,0));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365+temp,0,-1));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365+temp,-1,0));
                }
                temp = 0;
                for(int count = 0;count != 5;count++){
                     temp += 35;
                     Dots.add(0,new Dot(735,365-temp,3,5,0,0,0,0,0,1,false));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365-temp,0,1));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365-temp,1,0));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365+temp,0,-1));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365+temp,-1,0));
                }
                temp = 0;
                for(int count = 0;count != 5;count++){
                     temp += 35;
                     Dots.add(0,new Dot(735,365+temp,3,5,0,0,0,0,0,-1,false));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365-temp,0,1));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365-temp,1,0));
                     Dots.get(0).turns.add(0,new turnDot(945-temp,365+temp,0,-1));
                     Dots.get(0).turns.add(0,new turnDot(525+temp,365+temp,-1,0));
                }
                Dots.add(0,new Dot(735,365,2,0,0,0,0,0,0,0,false));
                Obj.add(0,new Obj(0,0,530,800,0));
                Obj.add(0,new Obj(0,0,1600,160,0));
                Obj.add(0,new Obj(940,260,700,800,0));
                Obj.add(0,new Obj(630,570,1600,300,0));
                Obj.add(0,new Obj(1090,0,700,800,0));
                Obj.add(0,new Obj(990,160,100,100,1));
            }
            
            else if(level == 4){
                p.x = 150;
                p.y = 440;
                Obj.clear();
                Dots.clear();
                Obj.add(new Obj(900,290,100,320,1));
                Dots.add(0,new Dot(525,450,2,10,300,110,300,690,1,1,false));
                Obj.add(0,new Obj(0,0,1600,290,0));
                Obj.add(0,new Obj(0,610,1600,300,0));
                Obj.add(0,new Obj(1000,290,600,320,0));
                temp = 0;
                for(int count = 0;count != 15;count++){
                    r = rand.nextInt(6)+1;
                    while(r == pr){
                        r = rand.nextInt(6)+1;
                    }
                    pr = r;
                    if(tempB){
                        if(r == 1 || r == 2 || count == 6 || count == 5){
                            Dots.add(0,new Dot(300+temp,450,1,5,300+temp,300,300+temp,600,1,0,false));
                        }
                        else if(r == 3 || r == 4){
                            Dots.add(0,new Dot(300+temp,450,1,10,300+temp,300,300+temp,600,1,0,false));
                        }
                        else if(r == 5 || r == 6){
                            Dots.add(0,new Dot(300+temp,450,1,15,300+temp,300,300+temp,600,1,0,false));
                        }
                    }
                    else{
                        if(r == 1 || r == 2 || count == 6 || count == 5){
                            Dots.add(0,new Dot(300+temp,450,1,5,300+temp,300,300+temp,600,-1,0,false));
                        }
                        else if(r == 3 || r == 4){
                            Dots.add(0,new Dot(300+temp,450,1,10,300+temp,300,300+temp,600,-1,0,false));
                        }
                        else if(r == 5 || r == 6){
                            Dots.add(0,new Dot(300+temp,450,1,15,300+temp,300,300+temp,600,-1,0,false));
                        }
                    }
                    temp += 41;
                    tempB = !tempB;
                }
            }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}