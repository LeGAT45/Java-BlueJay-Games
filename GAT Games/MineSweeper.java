import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class MineSweeper extends JApplet{
    @Override
    public void init(){
        add(new MineSweeper_Engine());
    }
}
class MineSweeper_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<space>spaces;
    int row;
    int col;
    int bomb;
    int r;
    int x;
    int y;
    Random rand;
    boolean dead;
    boolean flag;
    ArrayList<Integer>used;
    ArrayList<Integer>chain;
    ArrayList<Integer>chain2;
    boolean won;
    int time;
    int bombPer;
    boolean auto;
    boolean start;
    Polygon p;
    int sRow;
    int sCol;
    boolean AI;
    boolean startint;
    boolean gameint;
    public MineSweeper_Engine(){
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
        auto = true;
        bombPer = 20;
        row = 15;
        col = 30;
        sCol = 12;
        sRow = 9;
        AI = true;
        startint = false;
        if(auto){
            bomb = (int)(row*col*((double)bombPer)/100);
        }
        else{
            bomb = 90;
        }
        flag = false;
        spaces = new ArrayList<space>();
        dead = false;
        start = true;
        time = 0;
        rand = new Random();
        used = new ArrayList<Integer>();
        chain = new ArrayList<Integer>();
        won = false;
        gameint = true;
        chain2 = new ArrayList<Integer>();
        for(int count = 0;count != row*col;count++){
            spaces.add(new space(0,false,false));
        }
        /*
        for(int count = 0;count != bomb;count++){
            while(true){
                r = rand.nextInt(row*col-1);
                if(spaces.get(r).v != -1){
                    break;
                }
            }
            spaces.get(r).v = -1;
        }
        for(int count = 0;count != row*col;count++){
            if(spaces.get(count).v == -1){
                continue;
            }
            // top left
            if(!(count-(col+1)<0 || count%col == 0) && spaces.get(count-(col+1)).v == -1){
                spaces.get(count).v++;
            }
            // top
            if(!(count-col<0) && spaces.get(count-col).v == -1){
                spaces.get(count).v++;
            }
            // top right
            if(!(count-(col-1)<0 || (count+1)%col == 0) && spaces.get(count-(col-1)).v == -1){
                spaces.get(count).v++;
            }
            // right
            if(!((count+1)%col == 0) && spaces.get(count+1).v == -1){
                spaces.get(count).v++;
            }
            // bottom right
            if(!(count+(col+1)>=row*col || (count+(col+1))%col == 0) && spaces.get(count+(col+1)).v == -1){
                spaces.get(count).v++;
            }
            // bottom
            if(!(count+col>=row*col) && spaces.get(count+col).v == -1){
                spaces.get(count).v++;
            }
            // bottom left
            if(!(count+(col-1)>=row*col || count%col == 0) && spaces.get(count+(col-1)).v == -1){
                spaces.get(count).v++;
            }
            // left
            if(count%col != 0 && spaces.get(count-1).v == -1){
                spaces.get(count).v++;
            }
        }*/
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(!start){
            if(ch == KeyEvent.VK_F || ch == KeyEvent.VK_SPACE){
                flag = false;
            }
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(!start){
            if(ch == KeyEvent.VK_F || ch == KeyEvent.VK_SPACE){
                flag = true;
            }
            else if(ch == KeyEvent.VK_R){
                spaces = new ArrayList<space>();
                dead = false;
                won = false;
                used = new ArrayList<Integer>();
                chain = new ArrayList<Integer>();
                chain2 = new ArrayList<Integer>();
                time = 0;
                for(int count = 0;count != row*col;count++){
                    spaces.add(new space(0,false,false));
                }
                for(int count = 0;count != bomb;count++){
                    while(true){
                        r = rand.nextInt(row*col-1);
                        if(spaces.get(r).v != -1){
                            break;
                        }
                    }
                    spaces.get(r).v = -1;
                }
                for(int count = 0;count != row*col;count++){
                    if(spaces.get(count).v == -1){
                        continue;
                    }
                    // top left
                    if(!(count-(col+1)<0 || count%col == 0) && spaces.get(count-(col+1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // top
                    if(!(count-col<0) && spaces.get(count-col).v == -1){
                        spaces.get(count).v++;
                    }
                    // top right
                    if(!(count-(col-1)<0 || (count+1)%col == 0) && spaces.get(count-(col-1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // right
                    if(!((count+1)%col == 0) && spaces.get(count+1).v == -1){
                        spaces.get(count).v++;
                    }
                    // bottom right
                    if(!(count+(col+1)>=row*col || (count+(col+1))%col == 0) && spaces.get(count+(col+1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // bottom
                    if(!(count+col>=row*col) && spaces.get(count+col).v == -1){
                        spaces.get(count).v++;
                    }
                    // bottom left
                    if(!(count+(col-1)>=row*col || count%col == 0) && spaces.get(count+(col-1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // left
                    if(count%col != 0 && spaces.get(count-1).v == -1){
                        spaces.get(count).v++;
                    }
                }
            }
            else if(ch == KeyEvent.VK_Y){
                if(!start){
                    startint = false;
                    start = true;
                }
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
        if(start){
            if(mX>290 && mX<370 && mY>150 && mY<190){
                if(row-1>2){
                    row--;
                }
            }
            else if(mX>410 && mX<450 && mY>150 && mY<190){
                if(row+1<100){
                    row++;
                }
            }
            else if(mX>290 && mX<370 && mY>230 && mY<270){
                if(col-1>2){
                    col--;
                }
            }
            else if(mX>410 && mX<450 && mY>230 && mY<270){
                if(col+1<100){
                    col++;
                }
            }
            else if(mX>290 && mX<370 && mY>310 && mY<350){
                if(bombPer-5>5){
                    bombPer -= 5;
                }
            }
            else if(mX>410 && mX<450 && mY>310 && mY<350){
                if(bombPer+5<95){
                    bombPer += 5;
                }
            }
            else if(mX>210 && mX<290 && mY>430 && mY<470){
                start = false;
                gameint = true;
                if(auto){
                    bomb = (int)(row*col*((double)bombPer)/100);
                }
                else{
                    bomb = 90;
                }
            }
        }
        else{
            x = 20;
            y = 50;
            for(int count = 0;count != spaces.size();count++){
                if(mX>x&&mX<x+35&&mY>y&&mY<y+35){
                    if(flag && !spaces.get(count).click && !dead){
                        spaces.get(count).flag = !spaces.get(count).flag;
                    }
                    if(!spaces.get(count).flag && !dead && !flag){
                        spaces.get(count).click = true;
                    }
                    if(spaces.get(count).v == -1 && !spaces.get(count).flag && !flag){
                        dead = true;
                        for(int count2 = 0;count2 != spaces.size();count2++){
                            if(spaces.get(count2).v == -1){
                                spaces.get(count2).click = true;
                            }
                        }
                    }
                    if(spaces.get(count).v == 0 && !flag && !spaces.get(count).flag && !dead){
                        chain.clear();
                        chain.add(count);
                        chain2.clear();
                        used.clear();
                        used.add(count);
                        while(true){
                            for(int count2 = 0;count2 != chain.size();count2++){
                                // top left
                                if(!(chain.get(count2)-(col+1)<0 || chain.get(count2)%col == 0)){
                                    if(!spaces.get(chain.get(count2)-(col+1)).flag && spaces.get(chain.get(count2)-(col+1)).v != -1){
                                        spaces.get(chain.get(count2)-(col+1)).click = true;
                                        if(spaces.get(chain.get(count2)-(col+1)).v == 0 && !used.contains(chain.get(count2)-(col+1))){
                                            chain2.add(chain.get(count2)-(col+1));
                                            used.add(chain.get(count2)-(col+1));
                                        }
                                    }
                                }
                                // top
                                if(!(chain.get(count2)-col<0)){
                                    if(!spaces.get(chain.get(count2)-col).flag && spaces.get(chain.get(count2)-col).v != -1){
                                        spaces.get(chain.get(count2)-col).click = true;
                                        if(spaces.get(chain.get(count2)-col).v == 0 && !used.contains(chain.get(count2)-col)){
                                            chain2.add(chain.get(count2)-col);
                                            used.add(chain.get(count2)-col);
                                        }
                                    }
                                }
                                // top right
                                if(!(chain.get(count2)-(col-1)<0 || (chain.get(count2)+1)%col == 0)){
                                    if(!spaces.get(chain.get(count2)-(col-1)).flag && spaces.get(chain.get(count2)-(col-1)).v != -1){
                                        spaces.get(chain.get(count2)-(col-1)).click = true;
                                        if(spaces.get(chain.get(count2)-(col-1)).v == 0 && !used.contains(chain.get(count2)-(col-1))){
                                            chain2.add(chain.get(count2)-(col-1));
                                            used.add(chain.get(count2)-(col-1));
                                        }
                                    }
                                }
                                // right
                                if(!((chain.get(count2)+1)%col == 0)){
                                    if(!spaces.get(chain.get(count2)+1).flag && spaces.get(chain.get(count2)+1).v != -1){
                                        spaces.get(chain.get(count2)+1).click = true;
                                        if(spaces.get(chain.get(count2)+1).v == 0 && !used.contains(chain.get(count2)+1)){
                                            chain2.add(chain.get(count2)+1);
                                            used.add(chain.get(count2)+1);
                                        }
                                    }
                                }
                                // bottom right
                                if(!(chain.get(count2)+(col+1)>=row*col || (chain.get(count2)+(col+1))%col == 0)){
                                    if(!spaces.get(chain.get(count2)+(col+1)).flag && spaces.get(chain.get(count2)+(col+1)).v != -1){
                                        spaces.get(chain.get(count2)+(col+1)).click = true;
                                        if(spaces.get(chain.get(count2)+(col+1)).v == 0 && !used.contains(chain.get(count2)+(col+1))){
                                            chain2.add(chain.get(count2)+(col+1));
                                            used.add(chain.get(count2)+(col+1));
                                        }
                                    }
                                }
                                // bottom
                                if(!(chain.get(count2)+col>=row*col)){
                                    if(!spaces.get(chain.get(count2)+col).flag && spaces.get(chain.get(count2)+col).v != -1){
                                        spaces.get(chain.get(count2)+col).click = true;
                                        if(spaces.get(chain.get(count2)+col).v == 0 && !used.contains(chain.get(count2)+col)){
                                            chain2.add(chain.get(count2)+col);
                                            used.add(chain.get(count2)+col);
                                        }
                                    }
                                }
                                // bottom left
                                if(!(chain.get(count2)+(col-1)>=row*col || chain.get(count2)%col == 0)){
                                    if(!spaces.get(chain.get(count2)+(col-1)).flag && spaces.get(chain.get(count2)+(col-1)).v != -1){
                                        spaces.get(chain.get(count2)+(col-1)).click = true;
                                        if(spaces.get(chain.get(count2)+(col-1)).v == 0 && !used.contains(chain.get(count2)+(col-1))){
                                            chain2.add(chain.get(count2)+(col-1));
                                            used.add(chain.get(count2)+(col-1));
                                        }
                                    }
                                }
                                // left
                                if(chain.get(count2)%col != 0){
                                    if(!spaces.get(chain.get(count2)-1).flag && spaces.get(chain.get(count2)-1).v != -1){
                                        spaces.get(chain.get(count2)-1).click = true;
                                        if(spaces.get(chain.get(count2)-1).v == 0 && !used.contains(chain.get(count2)-1)){
                                            chain2.add(chain.get(count2)-1);
                                            used.add(chain.get(count2)-1);
                                        }
                                    }
                                }
                            }
                            chain.clear();
                            for(int count2 = 0;count2 != chain2.size();count2++){
                                chain.add(chain2.get(count2));
                            }
                            chain2.clear();
                            if(chain.size()==0){
                                break;
                            }
                        }
                    }
                }
                if((count+1)%col == 0){
                     x = 20;
                     y += 40;
                }
                else{
                     x += 40;
                }
            }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(200,200,200));
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        // drawing squares
        if(start){
            if(!startint){
                spaces = new ArrayList<space>();
                for(int count = 0;count != sRow*sCol;count++){
                    spaces.add(new space(0,false,false));
                }
                spaces.get(14).click = true;
                spaces.get(15).click = true;
                spaces.get(16).click = true;
                spaces.get(13).click = true;
                spaces.get(19).click = true;
                spaces.get(20).click = true;
                spaces.get(21).click = true;
                spaces.get(22).click = true;
                //
                spaces.get(38).click = true;
                spaces.get(39).click = true;
                spaces.get(40).click = true;
                spaces.get(37).click = true;
                spaces.get(43).click = true;
                spaces.get(44).click = true;
                spaces.get(45).click = true;
                spaces.get(46).click = true;
                //
                spaces.get(62).click = true;
                spaces.get(63).click = true;
                spaces.get(64).click = true;
                spaces.get(65).click = true;
                spaces.get(61).click = true;
                spaces.get(67).click = true;
                spaces.get(68).click = true;
                spaces.get(69).click = true;
                spaces.get(70).click = true;
                //
                spaces.get(102).click = true;
                spaces.get(101).click = true;
                startint = true;
            }
            g.setFont(new Font("Arial",Font.BOLD,75));
            g.setColor(Color.red);
            g.drawString("Minesweeper",10,80);
            x = 10;
            y = 110;
            for(int count = 0;count != spaces.size();count++){
                g.setColor(new Color(250,250,250));
                g.drawRect(x-2,y-2,40,40);
                // gray square
                if(spaces.get(count).click){
                    g.setColor(new Color(225,225,225));
                }
                else{
                    g.setColor(new Color(180,180,180));
                }
                g.fillRect(x,y,35,35);
                // flagging spaces
                if(spaces.get(count).flag){
                    g.setColor(Color.red);
                    g.drawLine(x+5,y+5,x+30,y+30);
                    g.drawLine(x+30,y+5,x+5,y+30);
                }
                if((count+1)%sCol == 0){
                    x = 10;
                    y += 40;
                }
                else{
                    x += 40;
                }
            }
            //rows
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.setColor(Color.red);
            g.drawString("R  O  W  S",55,178);
            p = new Polygon();
            p.addPoint(295,167);
            p.addPoint(315,182);
            p.addPoint(315,153);
            g2.fill(p);
            p = new Polygon();
            p.addPoint(440,167);
            p.addPoint(420,182);
            p.addPoint(420,153);
            g2.fill(p);
            if((""+row).length() >= 2){
                g.drawString((""+row).substring(0,1)+"   "+(""+row).substring(1,2),340,178);
            }
            else{
                g.drawString("0   "+(""+row).substring(0,1),340,178);
            }
            //cols
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.setColor(Color.red);
            g.drawString("C  O   L   S",55,258);
            p = new Polygon();
            p.addPoint(295,247);
            p.addPoint(315,262);
            p.addPoint(315,233);
            g2.fill(p);
            p = new Polygon();
            p.addPoint(440,247);
            p.addPoint(420,262);
            p.addPoint(420,233);
            g2.fill(p);
            if((""+col).length() >= 2){
                g.drawString((""+col).substring(0,1)+"   "+(""+col).substring(1,2),340,258);
            }
            else{
                g.drawString("0   "+(""+col).substring(0,1),340,258);
            }
            //bomb %
            g.setFont(new Font("Arial",Font.BOLD,30));
            g.setColor(Color.red);
            g.drawString("B  O  M  B   %",55,338);
            p = new Polygon();
            p.addPoint(295,327);
            p.addPoint(315,342);
            p.addPoint(315,313);
            g2.fill(p);
            p = new Polygon();
            p.addPoint(440,327);
            p.addPoint(420,342);
            p.addPoint(420,313);
            g2.fill(p);
            if((""+bombPer).length() >= 2){
                g.drawString((""+bombPer).substring(0,1)+"   "+(""+bombPer).substring(1,2),340,338);
            }
            else{
                g.drawString("0   "+(""+bombPer).substring(0,1),340,338);
            }
            // go
            g.drawString("G  O",215,458);
        }
        else{
            if(gameint){
                spaces.clear();
                dead = false;
                won = false;
                used = new ArrayList<Integer>();
                chain = new ArrayList<Integer>();
                chain2 = new ArrayList<Integer>();
                time = 0;
                for(int count = 0;count != row*col;count++){
                    spaces.add(new space(0,false,false));
                }
                for(int count = 0;count != bomb;count++){
                    while(true){
                        r = rand.nextInt(row*col-1);
                        if(spaces.get(r).v != -1){
                            break;
                        }
                    }
                    spaces.get(r).v = -1;
                }
                for(int count = 0;count != row*col;count++){
                    if(spaces.get(count).v == -1){
                        continue;
                    }
                    // top left
                    if(!(count-(col+1)<0 || count%col == 0) && spaces.get(count-(col+1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // top
                    if(!(count-col<0) && spaces.get(count-col).v == -1){
                        spaces.get(count).v++;
                    }
                    // top right
                    if(!(count-(col-1)<0 || (count+1)%col == 0) && spaces.get(count-(col-1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // right
                    if(!((count+1)%col == 0) && spaces.get(count+1).v == -1){
                        spaces.get(count).v++;
                    }
                    // bottom right
                    if(!(count+(col+1)>=row*col || (count+(col+1))%col == 0) && spaces.get(count+(col+1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // bottom
                    if(!(count+col>=row*col) && spaces.get(count+col).v == -1){
                        spaces.get(count).v++;
                    }
                    // bottom left
                    if(!(count+(col-1)>=row*col || count%col == 0) && spaces.get(count+(col-1)).v == -1){
                        spaces.get(count).v++;
                    }
                    // left
                    if(count%col != 0 && spaces.get(count-1).v == -1){
                        spaces.get(count).v++;
                    }
                }
                gameint = false;
            }
            x = 20;
            y = 50;
            for(int count = 0;count != spaces.size();count++){
                g.setColor(new Color(250,250,250));
                g.drawRect(x-2,y-2,40,40);
                // gray square
                if(spaces.get(count).click){
                    g.setColor(new Color(225,225,225));
                }
                else{
                    g.setColor(new Color(180,180,180));
                }
                g.fillRect(x,y,35,35);
                // flagging spaces
                if(spaces.get(count).flag){
                    g.setColor(Color.red);
                    g.drawLine(x+5,y+5,x+30,y+30);
                    g.drawLine(x+30,y+5,x+5,y+30);
                }
                if(spaces.get(count).v == 1){
                    g.setColor(new Color(60,100,255));                
                }
                else if(spaces.get(count).v == 2){
                    g.setColor(Color.green);                
                }
                else if(spaces.get(count).v == 3){
                    g.setColor(Color.red);                
                }
                else if(spaces.get(count).v == 4){
                    g.setColor(new Color(0,0,150));                
                }
                else if(spaces.get(count).v == 5){
                    g.setColor(new Color(125,0,0));                
                }
                else if(spaces.get(count).v == 6){
                    g.setColor(Color.cyan);                
                }
                else if(spaces.get(count).v == 7){
                    g.setColor(Color.black);                
                }
                else if(spaces.get(count).v == 8){
                    g.setColor(new Color(120,50,120));
                }
                else if(spaces.get(count).v == -1 && dead){
                    g.setColor(Color.black);
                    g.fillOval(x+8,y+8,20,20);
                }
                if(spaces.get(count).click && spaces.get(count).v != 0 && spaces.get(count).v != -1){
                    g.drawString(""+spaces.get(count).v,x+10,y+29);
                }
                if((count+1)%col == 0){
                    x = 20;
                    y += 40;
                }
                else{
                    x += 40;
                }
            }
            // win detection
            for(int count = 0;count != spaces.size();count++){
                if((!spaces.get(count).click && spaces.get(count).v != -1) || (spaces.get(count).v != -1 && spaces.get(count).flag) || (spaces.get(count).v == -1 && !spaces.get(count).flag)){
                    break;
                }
                else if(count == spaces.size()-1 && !dead){
                    won = true;
                }
            }
            // showing the win
            g.setColor(Color.red);
            if(!dead && !won){
                time++;
            }
            g.drawString(""+time/30,200,35);
            g.setFont(new Font("Arial",Font.BOLD,80));
            if(won){
                g.drawString("You won!",32,225);
            }
            else if(dead){
                g.drawString("BOOM",72,225);
            }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}