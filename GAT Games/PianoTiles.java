import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class PianoTiles extends JApplet{
    @Override
    public void init(){
        add(new PianoTiles_Engine());
    }
}
class PianoTiles_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<Tile>tiles;
    int col;
    Random rand;
    boolean lost;
    int dTiles;
    boolean out;
    int rows;
    int clickX;
    int clickY;
    PianoTiles_Engine pt;
    boolean max;
    boolean flick;
    public PianoTiles_Engine(){
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
        max = !false;
        flick = false;
        if(max){
            dTiles = 100;
        }
        else{
            dTiles = 0;
        }
        clickX = 0;
        clickY = 0;
        out = false;
        rand = new Random();
        rows = 3;
        if(flick){
            col = 0;
        }
        else{
            col = rand.nextInt(rows);
        }
        lost = false;
        tiles = new ArrayList<Tile>();
        tiles.add(new Tile(50+col*100,-175,100,175,false));
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_R && lost){
            if(max){
                dTiles = 100;
            }
            else{
                dTiles = 0;
            }
            clickX = 0;
            clickY = 0;
            out = false;
            rand = new Random();
            if(flick){
                col = 0;
            }
            else{
                col = rand.nextInt(rows);
            }
            lost = false;
            tiles = new ArrayList<Tile>();
            tiles.add(new Tile(50+col*100,-175,100,175,false));
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
        if(lost && clickX == 0){
            clickX = mX;
            clickY = mY;
        }
        if(!lost){
        out = false;
        for(int count = 0;count < tiles.size();count++){
            if(mX>tiles.get(count).x1-10&&mX<tiles.get(count).x1+tiles.get(count).x2+10&&mY>tiles.get(count).y1-10&&mY<tiles.get(count).y1+tiles.get(count).y2+10){
                if(!tiles.get(count).click){
                    dTiles++;
                }
                tiles.get(count).click = true;
                out = true;
            }
        }
        if(!out){
            lost = true;
            if(clickX == 0){
                clickX = mX;
                clickY = mY;
            }
        }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.black);
        g.drawString(""+dTiles,460,50);
        for(int count = 0;count < tiles.size();count++){
            if(!lost){
                if(dTiles/20+8 >= 15){
                    tiles.get(count).y1 += 15;
                }
                else{
                    tiles.get(count).y1 += 8+dTiles/20;
                }
            }
            if(!tiles.get(count).click){
                g.setColor(Color.black);
            }
            else{
                g.setColor(Color.gray);
            }
            g.fillRect(tiles.get(count).x1,tiles.get(count).y1,tiles.get(count).x2,tiles.get(count).y2);
        }
        if(tiles.get(0).y1 > 0){
            if(!flick){
                col = rand.nextInt(rows);
            }
            else if(flick){
                if(col == 0){
                    col = 3;                    
                }
                else if(col ==3){
                    col = 0;               
                }
            }
            tiles.add(0,new Tile(50+col*100,-175,100,175,false));
        }
        if(tiles.get(tiles.size()-1).y1 >= 700 && tiles.get(tiles.size()-1).click){
            tiles.remove(tiles.size()-1);
        }
        else if(tiles.get(tiles.size()-1).y1 >= 700){
            lost = true;
        }
        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.BOLD,100));
        if(lost){
            g.drawString("You lost!",30,200);
        }
        g.setColor(Color.blue);
        if(lost){
            g.fillOval(clickX-2,clickY-2,5,5);
        }
        try{
            if(30-dTiles/5 <= 2){
                Thread.sleep(2);
            }
            else{
                Thread.sleep(30-dTiles/5);
            }
        }catch(Exception e){}
        repaint();
    }
}