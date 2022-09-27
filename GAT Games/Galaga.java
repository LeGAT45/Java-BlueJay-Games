import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Galaga extends JApplet{
    @Override
    public void init(){
        add(new Galaga_Engine());
    }
}
class Galaga_Engine extends JPanel implements MouseListener, KeyListener{
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
    int lives;
    int stage;
    int score;
    boolean left;
    boolean right;
    Ship ship;
    Shot s1;
    Shot s2;
    Shot s3;
    ArrayList<Alien> aliens;
    Random rand;
    int count;
    boolean go;
    int inv;
    public Galaga_Engine(){
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
        lives = 3;
        stage = 1;
        score = 0;
        left = false;
        right = false;
        ship = new Ship(300);
        s1 = new Shot(250,700,false);
        s2 = new Shot(250,700,false);
        s3 = new Shot(250,700,false);
        rand = new Random();
        count = 0;
        go = true;
        aliens = new ArrayList<Alien>();
        inv = 300;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
        kTyped = true;
    }
    public void keyReleased(KeyEvent k){
        kReleased = true;
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            left = false;
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            right = false;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        kPressed = true;
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            left = true;
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(ch == KeyEvent.VK_W || ch == KeyEvent.VK_UP){
            if(s1.exist == false){
                s1.x = ship.x;
                s1.y = 675;
                s1.exist = true;
            }
            else if(s2.exist == false){
                s2.x = ship.x;
                s2.y = 675;
                s2.exist = true;
            }
            else if(s3.exist == false){
                s3.x = ship.x;
                s3.y = 675;
                s3.exist = true;
            }
        }
        if(ch == KeyEvent.VK_R){
            lives = 3;
            ship.x = 300;
            s1.exist = false;
            s2.exist = false;
            s3.exist = false;
            stage = 1;
            inv = 300;
            score = 0;
            left = false;
            right = false;
            go = true;
            for(int count = aliens.size();count != -1;count--){
                 aliens.remove(0);
            }
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
        setBackground(Color.black);
        g.setColor(Color.black);
        // draw ship
        ship.drawShip(g,inv);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.setColor(Color.red);
        g.drawString("SCORE",250,25);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("LIVES:",10,790);
        g.setColor(Color.white);
        g.drawString(""+score,250,50);
        g.drawString(""+lives,80,790);
        // drawing aliens
        for(int count = 0;count < aliens.size();count++){
            aliens.get(count).drawAlien(g);
        }
        if(lives == 0){
            g.setFont(new Font("Arial",Font.BOLD,99));
            g.drawString("GAME OVER",0,400);
            g.setFont(new Font("Arial",Font.BOLD,50));
            g.drawString("R to Restart",160,450);
        }
        if(lives != 0){
        // moving ship
        if(left && !(ship.x < 50)){
            ship.x -= 5;
        }
        else{
            left = false;
        }
        if(right && !(ship.x > 550)){
            ship.x += 5;
        }
        else{
            right = false;
        }
        // move and draw shot
        if(s1.y < 0){
            s1.exist = false;
        }
        if(s2.y<0){
            s2.exist = false;
        }
        if(s3.y<0){
            s3.exist = false;
        }
        if(s1.exist){
            s1.drawShot(g);
            s1.y -= 15;
        }
        if(s2.exist){
            s2.drawShot(g);
            s2.y -= 15;
        }
        if(s3.exist){
            s3.drawShot(g);
            s3.y -= 15;
        }
        // making new alien
        if(go){
            go = false;
            if(rand.nextInt(25)+1 == 15){
                aliens.add(0,new Alien(rand.nextInt(400)+100,0,rand.nextInt(5)+1,2,1,true));
            }
            else{
                aliens.add(0,new Alien(rand.nextInt(400)+100,0,rand.nextInt(5)+1,rand.nextInt(2)+1,1,false));
            }
        }
        // increasing stage and score
        stage = 1+score/500;
        // increasing counter till new alien
        count += stage;
        if(count >= 200){
            go = true;
            count = 0;
        }
        // bouncing aliens off wall
        for(int count = 0;count < aliens.size();count++){
            if(aliens.get(count).size == 1){
                if(aliens.get(count).x<=25){
                    if(aliens.get(count).angle == 5){
                        aliens.get(count).angle = 1;
                    }
                    else if(aliens.get(count).angle == 4){
                        aliens.get(count).angle = 2;
                    }
                }
                else if(aliens.get(count).x>=575){
                    if(aliens.get(count).angle == 1){
                        aliens.get(count).angle = 5;
                    }
                    else if(aliens.get(count).angle == 2){
                        aliens.get(count).angle = 4;
                    }
                }
            }
            else{
                if(aliens.get(count).x<=15){
                    if(aliens.get(count).angle == 5){
                        aliens.get(count).angle = 1;
                    }
                    else if(aliens.get(count).angle == 4){
                        aliens.get(count).angle = 2;
                    }
                }
                else if(aliens.get(count).x>=585){
                    if(aliens.get(count).angle == 1){
                        aliens.get(count).angle = 5;
                    }
                    else if(aliens.get(count).angle == 2){
                        aliens.get(count).angle = 4;
                    }
                }
            }
        }
        // changing x and y based on angle
        for(int count = 0;count < aliens.size();count++){
            if(aliens.get(count).angle == 1){
                aliens.get(count).x += 1;
                aliens.get(count).y += 1*aliens.get(count).d;
            }
            else if(aliens.get(count).angle == 2){
                aliens.get(count).x += 1;
                aliens.get(count).y += 2*aliens.get(count).d;
            }
            else if(aliens.get(count).angle == 3){
                aliens.get(count).y += 2*aliens.get(count).d;
            }
            else if(aliens.get(count).angle == 4){
                aliens.get(count).x -= 1;
                aliens.get(count).y += 2*aliens.get(count).d;
            }
            else if(aliens.get(count).angle == 5){
                aliens.get(count).x -= 1;
                aliens.get(count).y += 1*aliens.get(count).d;
            }
        }
        // removing aliens if shot hits them and removing shot
        for(int count = 0;count < aliens.size();count++){
            try{
            if(aliens.get(count).size == 1){
                if(s1.x < aliens.get(count).x+25 && s1.x > aliens.get(count).x-25 && s1.y > aliens.get(count).y-25 && s1.y < aliens.get(count).y+25 && s1.exist){
                    aliens.add(0,new Alien(aliens.get(count).x,aliens.get(count).y,rand.nextInt(2)+1,2,aliens.get(count).d,false));
                    aliens.add(0,new Alien(aliens.get(0).x,aliens.get(0).y,rand.nextInt(2)+4,2,aliens.get(count).d,false));
                    aliens.remove(count+2);
                    s1.exist = false;
                    score += 5;
                }
            }
            else if(aliens.get(count).size == 2){
                if(s1.x < aliens.get(count).x+15 && s1.x > aliens.get(count).x-15 && s1.y > aliens.get(count).y-15 && s1.y < aliens.get(count).y+15 && s1.exist){
                    if(aliens.get(count).good){
                        lives++;
                    }
                    aliens.remove(count);
                    s1.exist = false;
                    score += 10;
                }
            }
            if(aliens.get(count).size == 1){
                if(s2.x < aliens.get(count).x+25 && s2.x > aliens.get(count).x-25 && s2.y > aliens.get(count).y-25 && s2.y < aliens.get(count).y && s2.exist){
                    aliens.add(0,new Alien(aliens.get(count).x,aliens.get(count).y,rand.nextInt(2)+1,2,aliens.get(count).d,false));
                    aliens.add(0,new Alien(aliens.get(0).x,aliens.get(0).y,rand.nextInt(2)+4,2,aliens.get(count).d,false));
                    aliens.remove(count+2);
                    s2.exist = false;
                    score += 5;
                }
            }
            else if(aliens.get(count).size == 2){
                if(s2.x < aliens.get(count).x+15 && s2.x > aliens.get(count).x-15 && s2.y > aliens.get(count).y-15 && s2.y < aliens.get(count).y+10 && s2.exist){
                    if(aliens.get(count).good){
                        lives++;
                    }
                    aliens.remove(count);
                    s2.exist = false;
                    score += 10;
                }
            }
            if(aliens.get(count).size == 1){
                if(s3.x < aliens.get(count).x+25 && s3.x > aliens.get(count).x-25 && s3.y > aliens.get(count).y-25 && s3.y < aliens.get(count).y && s3.exist){
                    aliens.add(0,new Alien(aliens.get(count).x,aliens.get(count).y,rand.nextInt(2)+1,2,aliens.get(count).d,false));
                    aliens.add(0,new Alien(aliens.get(0).x,aliens.get(0).y,rand.nextInt(2)+4,2,aliens.get(count).d,false));
                    aliens.remove(count+2);
                    s3.exist = false;
                    score += 5;
                }
            }
            else if(aliens.get(count).size == 2){
                if(s3.x < aliens.get(count).x+15 && s3.x > aliens.get(count).x-15 && s3.y > aliens.get(count).y-15 && s3.y < aliens.get(count).y+10 && s3.exist){
                    if(aliens.get(count).good){
                        lives++;
                    }
                    aliens.remove(count);
                    s3.exist = false;
                    score += 10;
                }
            }
            }catch(Exception e){}
        }
        // bouncing aliens back and forth
        for(int count = 0;count < aliens.size();count++){
            if(aliens.get(count).y >= 800){
                aliens.get(count).d *= -1;
            }
        }
        for(int count = 0;count < aliens.size();count++){
            if(aliens.get(count).y <= 0 && aliens.get(count).good){
                aliens.remove(count);
            }
            else if (aliens.get(count).y <= 0){
                aliens.get(count).d *= -1;
            }
        }
        // invicibility frames
        if(inv < 300){
            inv++;
        }
        // detecting if it hits ship
        for(int count = 0;count < aliens.size();count++){
            if(aliens.get(count).size == 1){
                if(aliens.get(count).y > 675 && aliens.get(count).y < 775 && aliens.get(count).x < ship.x + 50 && aliens.get(count).x > ship.x - 50 && inv >= 300 && !aliens.get(count).good){
                    inv = 0;
                    lives --;
                    aliens.remove(count);
                }
            }
            else if(aliens.get(count).size == 2){
                if(aliens.get(count).y > 685 && aliens.get(count).y < 765 && aliens.get(count).x < ship.x + 40 && aliens.get(count).x > ship.x - 40 && inv >= 300 && !aliens.get(count).good){
                    inv = 0;
                    lives --;
                    aliens.remove(count);
                }
            }
        }
        }
        try{
            if(10-(score/250) != 5){
                Thread.sleep(10-(score/250));
            }
            else{
                Thread.sleep(5);
            }
        }catch(Exception e){}
        repaint();
    }
}