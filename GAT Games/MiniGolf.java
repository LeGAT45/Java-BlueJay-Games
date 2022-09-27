import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class MiniGolf extends JApplet{
    @Override
    public void init(){
        add(new MiniGolf_Engine());
    }
}
class MiniGolf_Engine extends JPanel implements MouseListener, KeyListener, MouseMotionListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<wall>walls;
    ArrayList<hole>holes;
    golf ball;
    int delay;
    int strokes;
    boolean won;
    int tx;
    int ty;
    int temp;
    boolean skip;
    int course;
    boolean two;
    int par;
    int total;
    boolean max;
    int x;
    int y;
    boolean AI;
    int theta;
    public MiniGolf_Engine(){
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
        walls = new ArrayList<wall>();
        holes = new ArrayList<hole>();
        skip = false;
        delay = 5;
        won = false;
        tx = 0;
        ty = 0;
        temp = 0;
        strokes = 0;
        course = 0;
        two = false;
        par = 3;
        total = 0;
        max = false;
        x = 0;
        y = 0;
        AI = !true;
        theta = 0;
        if(AI){
            
        }
        else{
            ball = new golf(100,400,90,0,1,1);
        }
        
        //top
        walls.add(new wall(0,0,350,250,0));
        walls.add(new wall(350,0,300,50,1));
        walls.add(new wall(650,0,300,250,0));
        walls.add(new wall(950,0,300,50,1));
        walls.add(new wall(1250,0,350,250,0));
        //bottom
        walls.add(new wall(0,550,350,250,0));
        walls.add(new wall(350,750,300,50,1));
        walls.add(new wall(650,550,300,250,0));
        walls.add(new wall(950,750,300,50,1));
        walls.add(new wall(1250,550,350,250,0));
        // sides
        walls.add(new wall(0,250,50,300,0));
        walls.add(new wall(1550,250,50,300,0));
        // middle blocks
        walls.add(new wall(450,250,100,300,0));
        walls.add(new wall(1050,250,100,300,0));
        holes.add(new hole(1500,400));
        //walls.add(new wall(200,300,100,100,2));
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_S){
            max = !true;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_R){
            if(course == 0){
                ball = new golf(100,400,90,0,1,1);
            }
            else if(course == 1){
                ball = new golf(200,400,0,0,1,1);                
            }
            else if(course == 2){
                ball = new golf(125,425,0,0,1,1);
            }
        }
        else if(ch == KeyEvent.VK_SPACE && won){
            course++;
            walls.clear();
            holes.clear();
            won = false;
            total+=strokes;
            strokes = 0;
            if(course == 1){
                par = 2;
                ball = new golf(200,400,0,0,1,1);
                holes.add(new hole(1400,400));
                //top
                walls.add(new wall(0,0,300,50,0));
                walls.add(new wall(300,0,250,50,1));
                walls.add(new wall(550,0,500,50,0));
                walls.add(new wall(1050,0,250,50,1));
                walls.add(new wall(1300,0,300,50,0));
                //bottom
                walls.add(new wall(0,750,300,50,0));
                walls.add(new wall(300,750,250,50,1));
                walls.add(new wall(550,750,500,50,0));
                walls.add(new wall(1050,750,250,50,1));
                walls.add(new wall(1300,750,300,50,0));
                // left
                walls.add(new wall(0,50,50,200,0));
                walls.add(new wall(0,250,50,300,1));
                walls.add(new wall(0,550,50,200,0));
                // right
                walls.add(new wall(1550,50,50,200,0));
                walls.add(new wall(1550,250,50,300,1));
                walls.add(new wall(1550,550,50,200,0));
                // mid left
                walls.add(new wall(300,250,200,50,0));
                walls.add(new wall(500,250,50,50,0));
                walls.add(new wall(300,300,200,200,0));
                walls.add(new wall(300,500,200,50,0));
                walls.add(new wall(500,500,50,50,0));
                walls.add(new wall(500,300,50,200,1));
                // mid right
                walls.add(new wall(1100,250,200,50,0));
                walls.add(new wall(1050,250,50,50,0));
                walls.add(new wall(1100,300,200,200,0));
                walls.add(new wall(1100,500,200,50,0));
                walls.add(new wall(1050,500,50,50,0));
                walls.add(new wall(1050,300,50,200,1));
                // mid
                walls.add(new wall(775,50,50,250,1));
                walls.add(new wall(775,500,50,250,1));
            }
            else if(course == 2){
                x = 100;
                y = 50;
                par = 2;
                for(int count = 0;count != 15;count++){
                    if(count%2 == 0){
                        y = 50;                        
                    }
                    else{
                        y = 100;
                    }
                    for(int count2 = 0;count2 != 7;count2++){
                        if(count%2 == 0){
                            walls.add(new wall(x,y,50,50,0));
                        }
                        else{
                            walls.add(new wall(x,y,50,50,1));
                        }
                        y+=100;
                    }
                    x+=100;
                }
                walls.add(new wall(0,0,1600,50,0));
                walls.add(new wall(0,750,1600,50,0));
                walls.add(new wall(0,50,50,700,0));
                walls.add(new wall(1550,50,50,700,0));
                ball = new golf(125,425,0,0,1,1);
                y = 75;
                for(int count = 0;count != 7;count++){
                    holes.add(new hole(1475,y));
                    y+=100;
                }
            }
        }
        else if(ch == KeyEvent.VK_S){
            max = true;
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
    public void mouseDragged(MouseEvent me){
    }
    public void mousePressed(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
        if(true){
            if(ball.s == 0){
                if(!max){
                    ball.s = (int)(Math.round(Math.sqrt(Math.pow(ball.x-mX,2)+Math.pow(ball.y-mY,2)))/15);
                }
                else{
                    ball.s = 30;
                }
                if(ball.s>30){
                    ball.s = 30;
                }
                if(mX<ball.x){
                    ball.d = -1;
                }
                else{
                    ball.d = 1;
                }
                if(mY<ball.y){
                    ball.u = 1;
                }
                else{
                    ball.u = -1;
                }
                ball.a = (int)Math.round(Math.toDegrees(Math.atan(Math.abs((double)(mY-ball.y)/(double)(mX-ball.x)))));
                strokes++;
            }
        }
    }
    public void mouseMoved(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(0,120,0));
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.setColor(Color.white);
        if(ball.s == 0){
            g.drawLine(ball.x,ball.y,mX,mY);
        }
        skip = false;
        for(int count = 0;count < walls.size();count++){
            walls.get(count).drawWall(g);
        }
        for(int count = 0;count < walls.size();count++){
            for(int count2 = 1;count2 <= ball.s;count2++){
                tx = ball.x + ball.d*(int)Math.round((double)count2*(Math.cos(Math.toRadians((double)ball.a))));
                ty = ball.y - ball.u*(int)Math.round((double)count2*(Math.sin(Math.toRadians((double)ball.a))));
                if(walls.get(count).type == 1 || walls.get(count).type == 0){
                    if(((tx>=walls.get(count).x1&&ball.x<walls.get(count).x1)||(tx<=walls.get(count).x2+walls.get(count).x1&&ball.x>walls.get(count).x2+walls.get(count).x1))&&ty>=walls.get(count).y1&&ty<=walls.get(count).y1+walls.get(count).y2){
                        ball.x = tx;
                        ball.y = ty;
                        ball.d *= -1;
                        ball.s-=2;
                        skip = true;
                        if(walls.get(count).type == 1){
                            if(ball.s+10>30){
                                ball.s = 30;
                            }
                            else{
                                ball.s+=10;
                            }
                        }
                        break;
                    }
                    else if(((ty>=walls.get(count).y1&&ball.y<walls.get(count).y1)||(ty<=walls.get(count).y2+walls.get(count).y1&&ball.y>walls.get(count).y2+walls.get(count).y1))&&tx>=walls.get(count).x1&&tx<=walls.get(count).x1+walls.get(count).x2){
                        ball.x = tx;
                        ball.y = ty;
                        ball.u *= -1;
                        skip = true;
                        ball.s-=2;
                        if(walls.get(count).type == 1){
                            if(ball.s+10>30){
                                ball.s = 30;
                            }
                            else{
                                ball.s+=10;
                            }
                        }
                        break;
                    }
                }
                else{
                    if(Math.round(Math.sqrt(Math.pow(tx-(walls.get(count).x1+walls.get(count).x2/2),2)+Math.pow(ty-(walls.get(count).y1+walls.get(count).y2/2),2)))<=walls.get(count).x2/2){
                            ball.x = tx;
                            ball.y = ty;
                            if(ball.d == 1 && ball.u == -1){
                                ball.a+=270;
                            }
                            else if(ball.d == -1 && ball.u == -1){
                                ball.a+=180;
                            }
                            else if(ball.d == -1 && ball.u == 1){
                                ball.a+=90;
                            }
                            theta = (int)Math.round(Math.toDegrees(Math.atan(Math.abs(ball.y-walls.get(count).y1+walls.get(count).y2/2)/Math.abs(ball.x-walls.get(count).x1+walls.get(count).x2/2))));
                            if(ball.x-walls.get(count).x1+walls.get(count).x2/2 >=0 && ball.y-walls.get(count).y1+walls.get(count).y2/2 <= 0){
                                ball.a=2*theta-ball.a+180;
                            }
                            else if(ball.x-walls.get(count).x1+walls.get(count).x2/2 <=0 && ball.y-walls.get(count).y1+walls.get(count).y2/2 <= 0){
                                if(ball.a-180>theta){
                                    ball.a = 180-2*theta;
                                }
                                else{
                                    ball.a = 540-ball.a-2*theta;
                                }
                            }
                            else if(ball.x-walls.get(count).x1+walls.get(count).x2/2 <=0 && ball.y-walls.get(count).y1+walls.get(count).y2/2 >= 0){
                                if(ball.a>theta){
                                    ball.a = ball.a+180;
                                }
                                else{
                                    ball.a = 2*theta-ball.a+180;
                                }
                            }
                            else if(ball.x-walls.get(count).x1+walls.get(count).x2/2 >=0 && ball.y-walls.get(count).y1+walls.get(count).y2/2 >= 0){
                                ball.a=540-2*theta-ball.a;
                            }
                            if(ball.a>=270){
                                ball.d = 1;
                                ball.u = -1;
                                ball.a-=270;
                            }
                            else if(ball.a<270 && ball.a>=180){
                                ball.d = -1;
                                ball.u = -1;
                                ball.a-=180;
                            }
                            else if(ball.a<180 && ball.a>=90){
                                ball.d = -1;
                                ball.u = 1;
                                ball.a-=90;
                            }
                            else{
                                ball.d = 1;
                                ball.u = 1;
                            }
                            ball.s-=2;
                            skip = true;
                            if(walls.get(count).type == 1 || walls.get(count).type == 3){
                                if(ball.s+10>30){
                                    ball.s = 30;
                                }
                                else{
                                    ball.s+=10;
                                }
                            }
                            break;
                    }
                }
            }
            if(skip){
                break;
            }
        }
        for(int count = 0;count < holes.size();count++){
            holes.get(count).drawHole(g);
            if(13>=Math.sqrt(Math.pow(ball.x-holes.get(count).x,2)+Math.pow(ball.y-holes.get(count).y,2))){
                won = true;
            }
        }
        if(won){
            g.setColor(Color.black);
            g.drawString("You passed this course",500,375);
            g.drawString("with "+strokes+" strokes!",600,425);
            g.drawString("Press SPACE to continue",500,475);
        }
        ball.drawBall(g);
        g.drawString(""+ball.a,100,100);
        g.setColor(Color.black);
        g.drawString("Strokes: "+strokes,1300,50);
        g.drawString("Par: "+par,1300,100);
        if(delay == 0 && ball.s != 0){
            ball.s--;
            delay = 3;
        }
        else if(ball.s != 0 && !skip && !won){
            delay--;
            ball.x += ball.d*Math.round((double)ball.s*(Math.cos(Math.toRadians((double)ball.a))));
            ball.y -= ball.u*Math.round((double)ball.s*(Math.sin(Math.toRadians((double)ball.a))));
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}