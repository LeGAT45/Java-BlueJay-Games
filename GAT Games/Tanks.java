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
 * WASD to move left tank
 * Arrow keys to move right tank
 * use mouse to aim right tank
 * use N and M to rotate cannon of the tank left and right
 * press Y while in the game to go back to the start screen
 * press space to shoot with blue tank
 * press left click to shoot with red tank
 * 
 * powerups: (move faster with all powerups) (with all powerups except pinks first shot, the bullets do not bounce)
 * red - flamethrower - only shoots a short distance but shoots a continuous stream of bullets if you hold down the shoot button
 * green - exploding shot - shoot one shot that bounces forever until you press the fire button again, 
 * when you press the fire button again it shoots bullets in all directions
 * purple - sniper - shoots one extremely fast shot, slow reload time between shots
 * yellow - shotgun - shoots 5 shots out at once, slow reload time between shots
 * 
 * 
 * 
 * 
 * Made by: GAT
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
public class Tanks extends JApplet{
    @Override
    public void init(){
        add(new Tanks_Engine());
    }
}
class Tanks_Engine extends JPanel implements MouseMotionListener, MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<Tank> tanks;
    ArrayList<Object> obj;
    boolean not;
    boolean won;
    boolean tie;
    boolean pause;
    int map;
    int power;
    Powerup p;
    Random rand;
    int pTimer;
    int gamemode;
    int tempx;
    int tempy;
    int time;
    int stock;
    int minutes;
    boolean play;
    boolean tutorial;
    int page;
    boolean fair;
    Polygon t;
    public Tanks_Engine(){
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        ch = 0;
        // mouseMotionListener
        addMouseMotionListener(this);
        // mouseListener
        addMouseListener(this);
        mX = 0;
        mY = 0;
        rand = new Random();
        // ^^^^^^^^^^^
        tanks = new ArrayList<Tank>();
        obj = new ArrayList<Object>();
        map = 1;
        gamemode = 0;
        minutes = 5;
        stock = 3;
        power = 0;
        time = minutes*1800;
        tempx = 125;
        tempy = 87;
        tanks.add(0,new Tank(1485,400,180,1,1,true,false,false,false,false,false,false,0,0,false,0,5,0,stock,0));
        tanks.add(1,new Tank(100,400,0,1,1,false,true,false,false,false,true,false,0,0,false,0,5,0,stock,0));
        not = false;
        won = false;
        tie = false;
        pause = false;
        pTimer = 0;
        play = false;
        tutorial = false;
        page = 0;
        fair = false;
        t = new Polygon();
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(play){
        if(ch == KeyEvent.VK_UP){
            tanks.get(0).up = !true;
        }
        if(ch == KeyEvent.VK_DOWN){
            tanks.get(0).down = !true;
        }
        if(ch == KeyEvent.VK_LEFT){
            tanks.get(0).left = !true;
        }
        if(ch == KeyEvent.VK_RIGHT){
            tanks.get(0).right = !true;
        }
        if(ch == KeyEvent.VK_W){
            tanks.get(1).up = !true;
        }
        if(ch == KeyEvent.VK_S){
            tanks.get(1).down = !true;
        }
        if(ch == KeyEvent.VK_A){
            tanks.get(1).left = !true;
        }
        if(ch == KeyEvent.VK_D){
            tanks.get(1).right = !true;
        }
        if(ch == KeyEvent.VK_N){
            tanks.get(1).n = false;
        }
        if(ch == KeyEvent.VK_M){
            tanks.get(1).m = false;
        }
        if(ch == KeyEvent.VK_SPACE){
            tanks.get(1).shoot = false;
        }
        if(fair){
            if(ch == KeyEvent.VK_NUMPAD8){
                tanks.get(0).n = false;
            }
            if(ch == KeyEvent.VK_NUMPAD9){
                tanks.get(0).m = false;
            }
            if(ch == KeyEvent.VK_NUMPAD0){
                tanks.get(0).shoot = false;
            }
        }
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(play){
        if(ch == KeyEvent.VK_P){
            pause = !pause;
        }
        if(!won && !tie && !pause){
            if(!tanks.get(0).dead){
                if(ch == KeyEvent.VK_UP){
                    tanks.get(0).up = true;
                }
                if(ch == KeyEvent.VK_DOWN){
                    tanks.get(0).down = true;
                }
                if(ch == KeyEvent.VK_LEFT){
                    tanks.get(0).left = true;
                }
                if(ch == KeyEvent.VK_RIGHT){
                    tanks.get(0).right = true;
                }
            }
            else{
                tanks.get(0).up = false;
                tanks.get(0).down = false;
                tanks.get(0).left = false;
                tanks.get(0).right = false;
            }
            if(!tanks.get(1).dead){
                if(ch == KeyEvent.VK_W){
                    tanks.get(1).up = true;
                }
                if(ch == KeyEvent.VK_S){
                    tanks.get(1).down = true;
                }
                if(ch == KeyEvent.VK_A){
                    tanks.get(1).left = true;
                }
                if(ch == KeyEvent.VK_D){
                    tanks.get(1).right = true;
                }
                if(ch == KeyEvent.VK_N){
                    tanks.get(1).n = true;
                }
                else if(ch == KeyEvent.VK_M){
                    tanks.get(1).m = true;
                }
                if(ch == KeyEvent.VK_SPACE){
                    if(tanks.get(1).state == 1){
                        tanks.get(1).shoot = true;
                    }
                    else if(tanks.get(1).delay == 0 && tanks.get(1).state == 2){
                        tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        tanks.get(1).delay = 25;
                    }
                    else if(tanks.get(1).delay == 0 && tanks.get(1).state == 3){
                        tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a+10,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a+5,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a-5,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a-10,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        tanks.get(1).delay = 25;
                    }
                    else if(tanks.get(1).state == 4 && tanks.get(1).delay == 0){
                        if(tanks.get(1).shots.size()==0){
                            tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        }
                        else if(tanks.get(1).shots.size()== 1){
                            for(int count = 0;count != 12;count++){
                                tanks.get(1).shots.add(1,new Bullet(tanks.get(1).shots.get(0).x,tanks.get(1).shots.get(0).y,count*30,1,1,0,0,0,0));
                            }
                            tanks.get(1).shots.remove(0);
                        }
                    }
                    else if(!tanks.get(1).shoot && tanks.get(1).state == 0){
                        if(tanks.get(1).shots.size() < 3){
                            tanks.get(1).shots.add(0,new Bullet(tanks.get(1).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(1).d,tanks.get(1).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(1).a))) * tanks.get(1).u,tanks.get(1).a,tanks.get(1).d,tanks.get(1).u,0,0,0,0));
                        }
                    }
                }
            }
            else{
                tanks.get(1).up = false;
                tanks.get(1).down = false;
                tanks.get(1).left = false;
                tanks.get(1).right = false;
                tanks.get(1).n = false;
                tanks.get(1).m = false;
            }
            if(fair){
                if(!tanks.get(0).dead){
                    if(ch == KeyEvent.VK_NUMPAD8){
                    tanks.get(0).n = true;
                }
                else if(ch == KeyEvent.VK_NUMPAD9){
                    tanks.get(0).m = true;
                }
                if(ch == KeyEvent.VK_NUMPAD0){
                    if(tanks.get(0).state == 1){
                        tanks.get(0).shoot = true;
                    }
                    else if(tanks.get(0).delay == 0 && tanks.get(0).state == 2){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        tanks.get(0).delay = 25;
                    }
                    else if(tanks.get(0).delay == 0 && tanks.get(0).state == 3){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a+10,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a+5,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a-5,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a-10,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        tanks.get(0).delay = 25;
                    }
                    else if(tanks.get(0).state == 4 && tanks.get(0).delay == 0){
                        if(tanks.get(0).shots.size()==0){
                            tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        }
                        else if(tanks.get(0).shots.size()== 1){
                            for(int count = 0;count != 12;count++){
                                tanks.get(0).shots.add(1,new Bullet(tanks.get(0).shots.get(0).x,tanks.get(0).shots.get(0).y,count*30,1,1,0,0,0,0));
                            }
                            tanks.get(0).shots.remove(0);
                        }
                    }
                    else if(!tanks.get(0).shoot && tanks.get(0).state == 0){
                        if(tanks.get(0).shots.size() < 3){
                            tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,tanks.get(0).a,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                        }
                    }
            }
        }
            else{
                tanks.get(0).up = false;
                tanks.get(0).down = false;
                tanks.get(0).left = false;
                tanks.get(0).right = false;
                tanks.get(0).n = false;
                tanks.get(0).m = false;
            }
            }
        }
        else{
            if(ch == KeyEvent.VK_R){
                tanks.clear();
                tanks.add(0,new Tank(1485,400,180,1,1,false,false,false,false,false,false,false,0,0,false,0,5,0,stock,0));
                tanks.add(1,new Tank(100,400,0,1,1,false,false,false,false,false,false,false,0,0,false,0,5,0,stock,0));
                not = false;
                won = false;
                tie = false;
                pTimer = 0;
                time = minutes*1800;
                if(power == 0){
                    p.state = rand.nextInt(4)+1;
                }
                else if(power == 2){
                    for(int count = 0;count != tanks.size();count++){
                        tanks.get(count).state = 0;
                    }
                }
            }
        }
        if(ch == KeyEvent.VK_Y){
                    play = false;
                    tanks.clear();
                    tanks.add(0,new Tank(1485,400,180,1,1,true,false,false,false,false,false,false,0,0,false,0,5,0,stock,0));
                    tanks.add(1,new Tank(100,400,0,1,1,false,true,false,false,false,true,false,0,0,false,0,5,0,stock,0));
                    obj.clear();
                    time = minutes*1800;
                    tempx = 125;
                    tempy = 87;
                    not = false;
                    won = false;
                    tie = false;
                    pause = false;
                    pTimer = 0;
                }
        }
    }
    //mouseMotionListener
    public void mouseDragged(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
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
        if(play){
            if(!fair){
                tanks.get(0).shoot = false;
            }
        }
    }
    public void mousePressed(MouseEvent me){
        if(!play){
            mX = me.getX();
            mY = me.getY();
            if(mX>745 && mX<845 && mY>725 && mY<775){
                            tanks.clear();
            tanks.add(0,new Tank(1485,400,180,1,1,false,false,false,false,false,false,false,0,0,false,0,5,0,stock,0));
            tanks.add(1,new Tank(100,400,0,1,1,false,false,false,false,false,false,false,0,0,false,0,5,0,stock,0));
                play = true;
            if(map == 0){
            obj.add(0,new Object(200,200,300,600));
            obj.add(0,new Object(1300,200,1400,600));
            obj.add(0,new Object(600,350,1000,450));
            obj.add(0,new Object(400,100,500,200));
            obj.add(0,new Object(400,600,500,700));
            obj.add(0,new Object(1100,100,1200,200));
            obj.add(0,new Object(1100,600,1200,700));
            obj.add(0,new Object(750,0,850,200));
            obj.add(0,new Object(750,600,850,800));
            try{
                if(power == 0){
                    p = new Powerup(800,500,rand.nextInt(4)+1);
                }
            }
            catch(Exception e){
                p.x = 800;
                p.y = 500;
                p.state = rand.nextInt(4)+1;
            }
            }
        // Cagy Crosshair
        else if(map == 1){
            obj.add(0,new Object(575,250,750,325));
            obj.add(0,new Object(575,475,750,550));
            obj.add(0,new Object(850,250,1025,325));
            obj.add(0,new Object(850,475,1025,550));
            obj.add(0,new Object(575,325,650,475));
            obj.add(0,new Object(950,325,1025,475));
            //top left
            obj.add(0,new Object(75,200,275,275));
            obj.add(0,new Object(200,75,275,200));
            // bottom left
            obj.add(0,new Object(75,525,200,600));
            obj.add(0,new Object(200,525,275,725));
            //top right
            obj.add(0,new Object(1305,200,1505,275));
            obj.add(0,new Object(1305,75,1380,200));
            // bottom right
            obj.add(0,new Object(1305,525,1505,600));
            obj.add(0,new Object(1305,600,1380,725));
            //top
            obj.add(0,new Object(400,100,1180,150));
            //bottom
            obj.add(0,new Object(400,650,1180,700));
            //left
            obj.add(0,new Object(150,350,200,450));
            // right
            obj.add(0,new Object(1380,350,1430,450));
            try{
                if(power == 0){
                    p = new Powerup(800,400,rand.nextInt(4)+1);
                }
            }
            catch(Exception e){
                p.x = 800;
                p.y = 400;
                p.state = rand.nextInt(4)+1;
            }
        }
        // Risky railway
        else if(map == 2){
            obj.add(0,new Object(300,285,1300,350));
            obj.add(0,new Object(300,450,1300,515));
            
            obj.add(0,new Object(130,285,190,515));
            obj.add(0,new Object(1410,285,1470,515));
            
            obj.add(0,new Object(130,0,190,200));
            obj.add(0,new Object(290,0,350,125));
            obj.add(0,new Object(450,0,510,200));
            obj.add(0,new Object(610,0,670,125));
            obj.add(0,new Object(770,0,830,200));
            obj.add(0,new Object(930,0,990,125));
            obj.add(0,new Object(1090,0,1150,200));
            obj.add(0,new Object(1250,0,1310,125));
            obj.add(0,new Object(1410,0,1470,200));
            
            obj.add(0,new Object(130,600,190,800));
            obj.add(0,new Object(290,675,350,800));
            obj.add(0,new Object(450,600,510,800));
            obj.add(0,new Object(610,675,670,800));
            obj.add(0,new Object(770,600,830,800));
            obj.add(0,new Object(930,675,990,800));
            obj.add(0,new Object(1090,600,1150,800));
            obj.add(0,new Object(1250,675,1310,800));
            obj.add(0,new Object(1410,600,1470,800));
            try{
                if(power == 0){
                    p = new Powerup(800,400,rand.nextInt(4)+1);
                }
            }
            catch(Exception e){
                p.x = 790;
                p.y = 400;
                p.state = rand.nextInt(4)+1;
            }
        }
            }
            else if(mX>625 && mX<675 && mY>165 && mY<215){
                gamemode = 0;
            }
            else if(mX>850 && mX<900 && mY>165 && mY<215){
                gamemode = 1;
            }
            else if(mX>525 && mX<575 && mY>365 && mY<415){
                map = 0;
            }
            else if(mX>800 && mX<850 && mY>365 && mY<415){
                map = 1;
            }
            else if(mX>1075 && mX<1125 && mY>365 && mY<415){
                map = 2;
            }
            else if(mX>625 && mX<675 && mY>565 && mY<615){
                power = 0;
            }
            else if(mX>820 && mX<870 && mY>565 && mY<615){
                power = 1;
            }
            else if(mX>1015 && mX<1065 && mY>565 && mY<615){
                power = 2;
            }
        }
        else if(play){
            if(!fair){
        if(!tanks.get(0).shoot){
            mX = me.getX();
            mY = me.getY();
        }
        if(!won && !tie && !pause){
            if(!tanks.get(0).dead){
                if(mX < tanks.get(0).x && tanks.get(0).d == 1){
                    tanks.get(0).d *= -1;
                }
                else if(mX > tanks.get(0).x && tanks.get(0).d == -1){
                    tanks.get(0).d *= -1;
                }
                if(mY > tanks.get(0).y && tanks.get(0).u == 1){
                    tanks.get(0).u *= -1;
                }
                else if(mY < tanks.get(0).y && tanks.get(0).u == -1){
                    tanks.get(0).u *= -1;
                }
                tanks.get(0).a = Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))));
                if(tanks.get(0).state == 1){
                    tanks.get(0).shoot = true;
                }
                else if(tanks.get(0).delay == 0 && tanks.get(0).state == 2){
                    tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x)))),tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    tanks.get(0).delay = 25;
                }
                else if(tanks.get(0).delay == 0 && tanks.get(0).state == 3){
                    tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))+10,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))+5,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x)))),tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))-5,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))-10,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    tanks.get(0).delay = 25;
                }
                else if(tanks.get(0).state == 4 && tanks.get(0).delay == 0){
                    if(tanks.get(0).shots.size()==0){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x)))),tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                    else if(tanks.get(0).shots.size()== 1){
                        for(int count = 0;count != 12;count++){
                            tanks.get(0).shots.add(1,new Bullet(tanks.get(0).shots.get(0).x,tanks.get(0).shots.get(0).y,count*30,1,1,0,0,0,0));
                        }
                        tanks.get(0).shots.remove(0);
                    }
                }
                else if(!tanks.get(0).shoot && tanks.get(0).state == 0){
                    if(tanks.get(0).shots.size() < 3){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x)))),tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                }
            }
        }
        }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(200,180,100));
        Graphics2D g2 = (Graphics2D) g;
        if(!play){
            for(int count = 0;count != tanks.size();count++){
                if(tanks.get(count).n){
                    tanks.get(count).a -= 2;
                }
                else{
                    tanks.get(count).a += 2;
                }
                if(count == 1){
                    if(tanks.get(count).a > 45){
                        tanks.get(count).n = !tanks.get(count).n;
                    }
                    else if(tanks.get(count).a < -45){
                        tanks.get(count).n = !tanks.get(count).n;
                    }
                }
                else if(count == 0){
                    if(tanks.get(count).a > 225){
                        tanks.get(count).n = !tanks.get(count).n;
                    }
                    else if(tanks.get(count).a < 155){
                        tanks.get(count).n = !tanks.get(count).n;
                    }
                }
                if(tanks.get(count).y > 700){
                    tanks.get(count).up = true;
                    tanks.get(count).down = false;
                }
                else if(tanks.get(count).y < 100){
                    tanks.get(count).up = !true;
                    tanks.get(count).down = !false;
                }
                if(tanks.get(count).up){
                    tanks.get(count).y -= 5;
                }
                else if(tanks.get(count).down){
                    tanks.get(count).y += 5;
                }
                if(tanks.get(count).delay == 0){
                    tanks.get(count).delay = 50;
                    tanks.get(count).shots.add(0,new Bullet(tanks.get(count).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(1).a))) * tanks.get(count).d,tanks.get(count).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(count).a))) * tanks.get(count).u,tanks.get(count).a,tanks.get(count).d,tanks.get(count).u,0,0,0,0));
                }
                else{
                    tanks.get(count).delay--;
                }
                for(int count2 = 0;count2 != tanks.get(count).shots.size();count2++){
                    tanks.get(count).shots.get(count2).y -= Math.round(10*Math.sin(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).u;
                    tanks.get(count).shots.get(count2).x += Math.round(10*Math.cos(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).d;
                    if(tanks.get(count).shots.get(count2).x < 0 || tanks.get(count).shots.get(count2).x > 1580){
                        tanks.get(count).shots.get(count2).d *= -1;
                        tanks.get(count).shots.get(count2).bounce++;
                    }
                    else if(tanks.get(count).shots.get(count2).y < 0 || tanks.get(count).shots.get(count2).y > 800){
                        tanks.get(count).shots.get(count2).u *= -1;
                        tanks.get(count).shots.get(count2).bounce++;
                    }
                    if(count == 0){
                        g.setColor(Color.blue);
                    }
                    else if(count == 1){
                        g.setColor(Color.red);
                    }
                    tanks.get(count).shots.get(count2).drawBullet(g);
                }
                for(int count2 = tanks.get(count).shots.size()-1;count2 != -1;count2--){
                    if(tanks.get(count).shots.get(count2).bounce > 0){
                        tanks.get(count).shots.remove(count2);
                    }
                }
                if(count == 0){
                    g.setColor(Color.blue);
                }
                else if(count == 1){
                    g.setColor(Color.red);
                }
                tanks.get(count).drawTank(g);
            }
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.setColor(Color.green);
            g.drawString("TANKS",600,100);
            g2.setStroke(new BasicStroke(15));
            g2.setColor(new Color(100,70,0));
            g2.drawRect(0,0,1580,800);
            g2.setStroke(new BasicStroke(5));
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.setColor(Color.green);
            g.fillRect(745,725,100,50);
            g.setColor(new Color(100,70,0));
            g.drawString("START",752,757);
            g.setColor(new Color(100,70,0));
            g.drawString("GAMEMODES:",400,200);
            g.setColor(Color.green);
            if(gamemode == 0){
                g.fillRect(625,165,50,50);
            }
            else{
                g.drawRect(625,165,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("-  Stock",690,200);
            g.setColor(Color.green);
            if(gamemode == 1){
                g.fillRect(850,165,50,50);
            }
            else{
                g.drawRect(850,165,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("-  Time",920,200);
            g.setColor(new Color(100,70,0));
            g.drawString("MAPS:",400,400);
            g.setColor(Color.green);
            if(map == 0){
                g.fillRect(525,365,50,50);
            }
            else{
                g.drawRect(525,365,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("    Painful",595,385);
            g.drawString("-",595,400);
            g.drawString("    Paintball",595,415);
            g.setColor(Color.green);
            if(map == 1){
                g.fillRect(800,365,50,50);
            }
            else{
                g.drawRect(800,365,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("    Cagey",870,385);
            g.drawString("-",870,400);
            g.drawString("    Crosshair",870,415);
            g.setColor(Color.green);
            if(map == 2){
                g.fillRect(1075,365,50,50);
            }
            else{
                g.drawRect(1075,365,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("    Risky",1145,385);
            g.drawString("-",1145,400);
            g.drawString("    Railway",1145,415);
            g.setColor(new Color(100,70,0));
            g.drawString("POWERUPS:",400,600);
            g.setColor(Color.green);
            if(power == 0){
                g.fillRect(625,565,50,50);
            }
            else{
                g.drawRect(625,565,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("-  On",690,600);
            g.setColor(Color.green);
            if(power == 1){
                g.fillRect(820,565,50,50);
            }
            else{
                g.drawRect(820,565,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("-  Off",890,600);
            g.setColor(Color.green);
            if(power == 2){
                g.fillRect(1015,565,50,50);
            }
            else{
                g.drawRect(1015,565,50,50);
            }
            g.setColor(new Color(100,70,0));
            g.drawString("-  Chaos mode",1085,600);
        }
        else if(play){
        g2.setStroke(new BasicStroke(15));
        g2.setColor(new Color(100,70,0));
        g2.drawRect(0,0,1580,800);
        for(int count = 0;count != obj.size();count++){
            obj.get(count).drawObject(g);
        }
        if(pause){
            g.setColor(Color.green);
            g.fillRect(770,360,20,80);
            g.fillRect(810,360,20,80);
        }
        if(!won && !tie && !pause){
            if(!tanks.get(1).dead){
                if(tanks.get(1).n){
                    tanks.get(1).a += 5;
                }
                else if(tanks.get(1).m){
                    tanks.get(1).a -= 5;
                }
            }
            if(fair){
                if(!tanks.get(0).dead){
                    if(tanks.get(0).n){
                        tanks.get(0).a += 5;
                    }
                    else if(tanks.get(0).m){
                        tanks.get(0).a -= 5;
                    }
                }
            }
        }
        if(power == 0){
            if(p.state == 0){
                pTimer++;
            }
            if(pTimer == 1000){
                p.state = rand.nextInt(1)+1;
                pTimer = 0;
            }
        }
        if(gamemode == 1){
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.setColor(Color.green);
            g.drawString(""+(time/1800)+":"+(time/30)%60,750,30);
            if(!won && !tie){
                time--;
            }
        }
        for(int count = 0;count != tanks.size();count++){
            if(!won && !tie && gamemode == 1){
                if(tanks.get(count).dead && tanks.get(count).respawn == 0){
                    tanks.get(count).respawn = 140;
                }
                else if(tanks.get(count).dead && tanks.get(count).respawn == 1){
                    tanks.get(count).respawn = 0;
                    tanks.get(count).dead = false;
                    tanks.get(count).y = 400;
                    if(count == 0){
                        if(tanks.get(1).x < 800){
                            tanks.get(0).x = 1485;
                        }
                        else{
                            tanks.get(0).x = 100;
                        }
                    }
                    else{
                        if(tanks.get(0).x < 800){
                            tanks.get(1).x = 1485;
                        }
                        else{
                            tanks.get(1).x = 100;
                        }
                    }
                }
            }
            else if(!won && !tie && gamemode == 0){
                if(tanks.get(count).dead && tanks.get(count).respawn == 0){
                    tanks.get(count).respawn = 140;
                }
                else if(tanks.get(count).dead && tanks.get(count).respawn == 1){
                    tanks.get(count).respawn = 0;
                    tanks.get(count).dead = false;
                    tanks.get(count).y = 400;
                    if(count == 0){
                        if(tanks.get(1).x < 800){
                            tanks.get(0).x = 1485;
                        }
                        else{
                            tanks.get(0).x = 100;
                        }
                    }
                    else{
                        if(tanks.get(0).x < 800){
                            tanks.get(1).x = 1485;
                        }
                        else{
                            tanks.get(1).x = 100;
                        }
                    }
                }
                if(tanks.get(0).stock == 0 && tanks.get(1).stock == 0){
                    tie = true;
                }
                else if(tanks.get(count).stock == 0){
                    won = true;
                }
            }
            if(tanks.get(count).dead){
                tanks.get(count).shoot = false;
            }
            if(power == 2){
                tanks.get(count).time++;
                if(tanks.get(count).time == 1){
                    tanks.get(count).state = rand.nextInt(4)+1;
                }
                if(tanks.get(count).time == 250){
                    tanks.get(count).time = 0;
                    tanks.get(count).state = 0;
                }
            }
            if(tanks.get(count).dead && tanks.get(count).respawn > 0){
                tanks.get(count).respawn--;
            }
            if(tanks.get(count).state != 0){
                if(power != 2){
                    tanks.get(count).time++;
                    if(tanks.get(count).time == 250){
                        tanks.get(count).state = 0;
                        tanks.get(count).time = 0;
                    }
                }
                if(tanks.get(count).state == 4 && tanks.get(count).shots.size() > 1){
                    tanks.get(count).delay++;
                }
                if(tanks.get(count).state == 4 && tanks.get(count).delay == 8 && tanks.get(count).shots.size() > 1){
                    tanks.get(count).delay = 0;
                    tanks.get(count).shots.clear();
                }
                if(!fair){
                if(tanks.get(count).state == 1 && tanks.get(count).shoot && count != 0){
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(count).shots.add(0,new Bullet(tanks.get(count).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(count).a))) * tanks.get(count).d,tanks.get(count).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(count).a))) * tanks.get(count).u,tanks.get(count).a-10,tanks.get(count).d,tanks.get(count).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(count).shots.add(0,new Bullet(tanks.get(count).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(count).a))) * tanks.get(count).d,tanks.get(count).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(count).a))) * tanks.get(count).u,tanks.get(count).a+10,tanks.get(count).d,tanks.get(count).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(count).shots.add(0,new Bullet(tanks.get(count).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(count).a))) * tanks.get(count).d,tanks.get(count).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(count).a))) * tanks.get(count).u,tanks.get(count).a-5,tanks.get(count).d,tanks.get(count).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(count).shots.add(0,new Bullet(tanks.get(count).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(count).a))) * tanks.get(count).d,tanks.get(count).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(count).a))) * tanks.get(count).u,tanks.get(count).a+5,tanks.get(count).d,tanks.get(count).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(count).shots.add(0,new Bullet(tanks.get(count).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(count).a))) * tanks.get(count).d,tanks.get(count).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(count).a))) * tanks.get(count).u,tanks.get(count).a,tanks.get(count).d,tanks.get(count).u,0,0,0,0));
                    }
                }
                else if(tanks.get(count).state == 1 && tanks.get(count).shoot && count == 0){
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))-10,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))+10,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))+5,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x))))-5,tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                    if(rand.nextInt(3)+1 == 1){
                        tanks.get(0).shots.add(0,new Bullet(tanks.get(0).x+(int)Math.round(35*Math.cos(Math.toRadians(tanks.get(0).a))) * tanks.get(0).d,tanks.get(0).y-(int)Math.round(35*Math.sin(Math.toRadians(tanks.get(0).a))) * tanks.get(0).u,Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(0).y-mY)/(mX-tanks.get(0).x)))),tanks.get(0).d,tanks.get(0).u,0,0,0,0));
                    }
                }
                }
            }
            if(tanks.get(count).state == 2 || tanks.get(count).state == 3){
                if(tanks.get(count).delay != 0){
                    tanks.get(count).delay--;
                }
            }
            if(power == 0){
                if(p.x>tanks.get(count).x-25 && p.x<tanks.get(count).x+25 && p.y>tanks.get(count).y-25 && p.y<tanks.get(count).y+25 && p.state != 0){
                    tanks.get(count).state = p.state;
                    p.state = 0;
                }
            }
            if(tanks.get(count).state == 0){
                tanks.get(count).speed = 5;
                tanks.get(count).delay = 0;
            }
            else{
                tanks.get(count).speed = 7;
            }
            if(!won && !tie && !pause){
                for(int count2 = 0;count2 != tanks.size();count2++){
                    for(int count3 = tanks.get(count).shots.size()-1;count3 != -1;count3--){
                        if(tanks.get(count).shots.get(count3).x > tanks.get(count2).x-25 && tanks.get(count).shots.get(count3).x < tanks.get(count2).x+25 && tanks.get(count).shots.get(count3).y > tanks.get(count2).y-25 && tanks.get(count).shots.get(count3).y < tanks.get(count2).y+25){
                            if(gamemode == 1 && !tanks.get(count2).dead){
                                tanks.get(count2).score++;
                            }
                            else if(gamemode == 0 && !tanks.get(count2).dead){
                                tanks.get(tanks.size()-(count2+1)).stock--;
                            }
                            tanks.get(count2).dead = true;
                            tanks.get(count).shots.remove(count3);
                        }
                    }
                }
                for(int count2 = tanks.get(count).shots.size()-1;count2 != -1;count2--){
                    if(tanks.get(count).state == 1 || tanks.get(count).state == 2 || tanks.get(count).state == 3){
                        if(tanks.get(count).shots.get(count2).bounce > 0 || tanks.get(count).shots.get(count2).timer > 10){
                            tanks.get(count).shots.remove(count2);
                        }
                    }
                    else if(tanks.get(count).state == 4){
                        if(tanks.get(count).shots.size()>1){
                            if(tanks.get(count).shots.get(count2).bounce > 0){
                                tanks.get(count).shots.remove(count2);
                            }
                        }
                    }
                    else{
                        if(tanks.get(count).shots.get(count2).bounce > 2 || tanks.get(count).shots.get(count2).timer > 0){
                            tanks.get(count).shots.remove(count2);
                        }
                        if(tanks.get(count).shots.size()>3){
                            tanks.get(count).shots.clear();
                            break;
                        }
                    }
                }
            }
            else if(tanks.get(count).dead){
                tanks.get(count).respawn++;
            }
            for(int count2 = 0;count2 != tanks.get(count).shots.size();count2++){
                if(!won && !tie && !pause){
                    tanks.get(count).shots.get(count2).pY = tanks.get(count).shots.get(count2).y;
                    tanks.get(count).shots.get(count2).pX = tanks.get(count).shots.get(count2).x;
                    if(tanks.get(count).state == 1 || (tanks.get(count).state == 4 && tanks.get(count).shots.size()>1)){
                        tanks.get(count).shots.get(count2).y -= Math.round(20*Math.sin(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).u;
                        tanks.get(count).shots.get(count2).x += Math.round(20*Math.cos(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).d;
                        tanks.get(count).shots.get(count2).timer++;
                    }
                    else if(tanks.get(count).state == 2){
                        tanks.get(count).shots.get(count2).y -= Math.round(40*Math.sin(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).u;
                        tanks.get(count).shots.get(count2).x += Math.round(40*Math.cos(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).d;
                    }
                    else if((tanks.get(count).state == 4 && tanks.get(count).shots.size() == 1) || tanks.get(count).state == 3){
                        tanks.get(count).shots.get(count2).y -= Math.round(12*Math.sin(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).u;
                        tanks.get(count).shots.get(count2).x += Math.round(12*Math.cos(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).d;
                    }
                    else{
                        tanks.get(count).shots.get(count2).y -= Math.round(10*Math.sin(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).u;
                        tanks.get(count).shots.get(count2).x += Math.round(10*Math.cos(Math.toRadians(tanks.get(count).shots.get(count2).a))) * tanks.get(count).shots.get(count2).d;
                    }
                    for(int count3 = 0;count3 != obj.size();count3++){
                        if(tanks.get(count).shots.get(count2).y > obj.get(count3).y1 && tanks.get(count).shots.get(count2).y < obj.get(count3).y2 && tanks.get(count).shots.get(count2).x > obj.get(count3).x1 && tanks.get(count).shots.get(count2).x < obj.get(count3).x2 && !(tanks.get(count).shots.get(count2).pY > obj.get(count3).y1 && tanks.get(count).shots.get(count2).pY < obj.get(count3).y2)){
                            tanks.get(count).shots.get(count2).u *= -1;
                            tanks.get(count).shots.get(count2).bounce++;
                        }
                        else if(tanks.get(count).shots.get(count2).y > obj.get(count3).y1 && tanks.get(count).shots.get(count2).y < obj.get(count3).y2 && tanks.get(count).shots.get(count2).x > obj.get(count3).x1 && tanks.get(count).shots.get(count2).x < obj.get(count3).x2){
                            tanks.get(count).shots.get(count2).d *= -1;
                            tanks.get(count).shots.get(count2).bounce++;
                        }
                    }
                    if(tanks.get(count).shots.get(count2).x < 0 || tanks.get(count).shots.get(count2).x > 1580){
                        tanks.get(count).shots.get(count2).d *= -1;
                        tanks.get(count).shots.get(count2).bounce++;
                    }
                    else if(tanks.get(count).shots.get(count2).y < 0 || tanks.get(count).shots.get(count2).y > 800){
                        tanks.get(count).shots.get(count2).u *= -1;
                        tanks.get(count).shots.get(count2).bounce++;
                    }
                }
                if(tanks.get(count).state == 1){
                    g.setColor(new Color(100,0,0));
                }
                else if(tanks.get(count).state == 2){
                    g.setColor(new Color(120,0,255));
                }
                else if(tanks.get(count).state == 3){
                    g.setColor(Color.yellow);
                }
                else if(tanks.get(count).state == 4){
                    g.setColor(Color.green);
                }
                else if(count == 1){
                    g.setColor(Color.blue);
                }
                else if(count == 0){
                    g.setColor(Color.red);
                }
                tanks.get(count).shots.get(count2).drawBullet(g);
            }
            if(!won && !tie && !pause && !tanks.get(count).dead){
                if(tanks.get(count).up){
                    for(int count2 = 0;count2 != tanks.size();count2++){
                        if(((tanks.get(count).x-25 >= tanks.get(count2).x-25 && tanks.get(count).x-25 <= tanks.get(count2).x+25) || (tanks.get(count).x+25 >= tanks.get(count2).x-25 && tanks.get(count).x+25 <= tanks.get(count2).x+25)) && (tanks.get(count).y-30 >= tanks.get(count2).y-25 && tanks.get(count).y-30 <= tanks.get(count2).y+25)){
                            not = true;
                        }
                    }
                    for(int count3 = 0;count3 != obj.size();count3++){
                        if(((tanks.get(count).x-25 >= obj.get(count3).x1 && tanks.get(count).x-25 <= obj.get(count3).x2 && tanks.get(count).y-(25+tanks.get(count).speed) >= obj.get(count3).y1 && tanks.get(count).y-(25+tanks.get(count).speed) <= obj.get(count3).y2) || (tanks.get(count).x+25 >= obj.get(count3).x1 && tanks.get(count).x+25 <= obj.get(count3).x2 && tanks.get(count).y-(25+tanks.get(count).speed) >= obj.get(count3).y1 && tanks.get(count).y-(25+tanks.get(count).speed) <= obj.get(count3).y2)) || tanks.get(count).y-(25+tanks.get(count).speed)<=5){
                            not = true;
                        }
                    }
                    if(!not && tanks.get(count).state == 0){
                        tanks.get(count).y -= tanks.get(count).speed;
                    }
                    else if(!not){
                        tanks.get(count).y -= tanks.get(count).speed;
                    }
                    not = false;
                }
                if(tanks.get(count).down){
                    for(int count2 = 0;count2 != tanks.size();count2++){
                        if(((tanks.get(count).x-25 >= tanks.get(count2).x-25 && tanks.get(count).x-25 <= tanks.get(count2).x+25) || (tanks.get(count).x+25 >= tanks.get(count2).x-25 && tanks.get(count).x+25 <= tanks.get(count2).x+25)) && (tanks.get(count).y+(25+tanks.get(count).speed) >= tanks.get(count2).y-25 && tanks.get(count).y+(25+tanks.get(count).speed) <= tanks.get(count2).y+25)){
                            not = true;
                        }
                    }
                    for(int count3 = 0;count3 != obj.size();count3++){
                        if(((tanks.get(count).x-25 >= obj.get(count3).x1 && tanks.get(count).x-25 <= obj.get(count3).x2 && tanks.get(count).y+((25+tanks.get(count).speed)) >= obj.get(count3).y1 && tanks.get(count).y+(25+tanks.get(count).speed) <= obj.get(count3).y2) || (tanks.get(count).x+25 >= obj.get(count3).x1 && tanks.get(count).x+25 <= obj.get(count3).x2 && tanks.get(count).y+(25+tanks.get(count).speed) >= obj.get(count3).y1 && tanks.get(count).y+(25+tanks.get(count).speed) <= obj.get(count3).y2)) || tanks.get(count).y+(25+tanks.get(count).speed)>=795){
                            not = true;
                        }
                    }
                    if(!not && tanks.get(count).state == 0){
                        tanks.get(count).y += tanks.get(count).speed;
                    }
                    else if(!not){
                        tanks.get(count).y += tanks.get(count).speed;
                    }
                    not = false;
                }
                if(tanks.get(count).left){
                    for(int count2 = 0;count2 != tanks.size();count2++){
                        if(((tanks.get(count).y-25 >= tanks.get(count2).y-25 && tanks.get(count).y-25 <= tanks.get(count2).y+25) || (tanks.get(count).y+25 >= tanks.get(count2).y-25 && tanks.get(count).y+25 <= tanks.get(count2).y+25)) && (tanks.get(count).x-(25+tanks.get(count).speed) >= tanks.get(count2).x-25 && tanks.get(count).x-(25+tanks.get(count).speed) <= tanks.get(count2).x+25)){
                            not = true;
                        }
                    }
                    for(int count3 = 0;count3 != obj.size();count3++){
                        if(((tanks.get(count).x-(25+tanks.get(count).speed) >= obj.get(count3).x1 && tanks.get(count).x-(25+tanks.get(count).speed) <= obj.get(count3).x2 && tanks.get(count).y-25 >= obj.get(count3).y1 && tanks.get(count).y-25 <= obj.get(count3).y2) || (tanks.get(count).x-(25+tanks.get(count).speed) >= obj.get(count3).x1 && tanks.get(count).x-(25+tanks.get(count).speed) <= obj.get(count3).x2 && tanks.get(count).y+25 >= obj.get(count3).y1 && tanks.get(count).y+25 <= obj.get(count3).y2)) || tanks.get(count).x-(25+tanks.get(count).speed)<=5){
                            not = true;
                        }
                    }
                    if(!not && tanks.get(count).state == 0){
                        tanks.get(count).x -= tanks.get(count).speed;
                    }
                    else if(!not){
                        tanks.get(count).x -= tanks.get(count).speed;
                    }
                    not = false;
                }
                if(tanks.get(count).right){
                    for(int count2 = 0;count2 != tanks.size();count2++){
                        if(((tanks.get(count).y-25 >= tanks.get(count2).y-25 && tanks.get(count).y-25 <= tanks.get(count2).y+25) || (tanks.get(count).y+25 >= tanks.get(count2).y-25 && tanks.get(count).y+25 <= tanks.get(count2).y+25)) && (tanks.get(count).x+30 >= tanks.get(count2).x-25 && tanks.get(count).x+30 <= tanks.get(count2).x+25)){
                            not = true;
                        }
                    }
                    for(int count3 = 0;count3 != obj.size();count3++){
                        if(((tanks.get(count).x+(25+tanks.get(count).speed) >= obj.get(count3).x1 && tanks.get(count).x+(25+tanks.get(count).speed) <= obj.get(count3).x2 && tanks.get(count).y-25 >= obj.get(count3).y1 && tanks.get(count).y-25 <= obj.get(count3).y2) || (tanks.get(count).x+(25+tanks.get(count).speed) >= obj.get(count3).x1 && tanks.get(count).x+(25+tanks.get(count).speed) <= obj.get(count3).x2 && tanks.get(count).y+25 >= obj.get(count3).y1 && tanks.get(count).y+25 <= obj.get(count3).y2)) || tanks.get(count).x+(25+tanks.get(count).speed)>=1575){
                            not = true;
                        }
                    }
                    if(!not && tanks.get(count).state == 0){
                        tanks.get(count).x += tanks.get(count).speed;
                    }
                    else if(!not){
                        tanks.get(count).x += tanks.get(count).speed;
                    }
                    not = false;
                }
                if(!fair){
                if(!tanks.get(0).dead && count == 0){
                    if(mX < tanks.get(count).x && tanks.get(count).d == 1){
                        tanks.get(count).d *= -1;
                    }
                    else if(mX > tanks.get(count).x && tanks.get(count).d == -1){
                        tanks.get(count).d *= -1;
                    }
                    if(mY > tanks.get(count).y && tanks.get(count).u == 1){
                        tanks.get(count).u *= -1;
                    }
                    else if(mY < tanks.get(count).y && tanks.get(count).u == -1){
                        tanks.get(count).u *= -1;
                    }
                    tanks.get(count).a = Math.toDegrees(Math.atan(Math.abs(((double)tanks.get(count).y-mY)/(mX-tanks.get(count).x))));
                }
                }
            }
            if(tanks.get(count).state == 1){
                g.setColor(new Color(100,0,0));
            }
            else if(tanks.get(count).state == 2){
                g.setColor(new Color(120,0,255));
            }
            else if(tanks.get(count).state == 3){
                g.setColor(Color.yellow);
            }
            else if(tanks.get(count).state == 4){
                g.setColor(Color.green);
            }
            else if(count == 1){
                g.setColor(Color.blue);
                g2.setColor(Color.blue);
            }
            else if(count == 0){
                g.setColor(Color.red);
                g2.setColor(Color.red);
            }
            tanks.get(count).drawTank(g);
        }
        if(time == 0){
            if(tanks.get(0).score == tanks.get(1).score){
                tie = true;
            }
            else{
                won = true;
            }
        }
        if(power == 0){
            p.drawPowerup(g);
        }
        if(gamemode == 0){
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.setColor(Color.blue);
            g.drawString("Tank One - "+tanks.get(0).stock,10,30);
            g.setColor(Color.red);
            g.drawString("Tank Two - "+tanks.get(1).stock,1400,30);
            if(won && !tie){
                g.setFont(new Font("Arial",Font.BOLD,50));
                if(tanks.get(1).stock == 0){
                    g.setColor(Color.blue);
                    g.drawString("Tank one won!",650,400);
                }
                else if(tanks.get(0).stock == 0){
                    g.setColor(Color.red);
                    g.drawString("Tank two won!",650,400);
                }
            }
            else if(tie){
                g.setColor(Color.green);
                g.setFont(new Font("Arial",Font.BOLD,50));
                g.drawString("It's a tie!",650,400);
            }
        }
        else if(gamemode == 1){
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.setColor(Color.blue);
            g.drawString("Tank One - "+tanks.get(0).score,10,30);
            g.setColor(Color.red);
            g.drawString("Tank Two - "+tanks.get(1).score,1400,30);
            if(won && !tie){
                g.setFont(new Font("Arial",Font.BOLD,50));
                if(tanks.get(0).score > tanks.get(1).score){
                    g.setColor(Color.blue);
                    g.drawString("Tank one won!",650,400);
                }
                else if(tanks.get(1).score > tanks.get(0).score){
                    g.setColor(Color.red);
                    g.drawString("Tank two won!",650,400);
                }
            }
            else if(tie){
                g.setColor(Color.green);
                g.setFont(new Font("Arial",Font.BOLD,50));
                g.drawString("It's a tie!",650,400);
            }
        }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}