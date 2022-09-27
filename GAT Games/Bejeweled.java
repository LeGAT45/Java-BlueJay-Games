import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Bejeweled extends JApplet{
    @Override
    public void init(){
        add(new Bejeweled_Engine());
    }
}
class Bejeweled_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    int row;
    int col;
    int[][]jewels;
    int x;
    int y;
    Random rand;
    int row1;
    int col1;
    int row2;
    int col2;
    int lewel;
    int color2;
    public Bejeweled_Engine(){
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
        rand = new Random();
        row = 8;
        col = 8;
        row1 = -1;
        col1 = -1;
        row2 = -1;
        col2 = -1;
        lewel = -1;
        color2 = -1;
        jewels = new int[row][col];
        for(int count = 0;count != jewels.length;count++){
            for(int count2 = 0;count2 != jewels[count].length;count2++){
                jewels[count][count2] = rand.nextInt(7);
            }
        }
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
    }
    public void mousePressed(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
        x = 50;
        y = 50;
        for(int count = 0;count != jewels.length;count++){
            for(int count2 = 0;count2 != jewels[count].length;count2++){
                if(mX>x && mX < x+50 && mY> y && mY< y+50){
                    if(row1 == -1){
                        row1 = count;
                        col1 = count2;
                    }
                    else if(row2 == -1){
                        row2 = count;
                        col2 = count2;
                    }
                }
                x += 50;
            }
            y += 50;
            x = 50;
        }
        if(row1 != -1 && row2 != -1){
            //jewels[row1][col1] = jewels[row2
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,10));
        x = 50;
        y = 50;
        for(int count = 0;count != jewels.length;count++){
            for(int count2 = 0;count2 != jewels[count].length;count2++){
                if(jewels[count][count2] == 0){
                    g.setColor(Color.red);
                }
                else if(jewels[count][count2] == 1){
                    g.setColor(Color.orange);
                }
                else if(jewels[count][count2] == 2){
                    g.setColor(Color.yellow);
                }
                else if(jewels[count][count2] == 3){
                    g.setColor(Color.green);
                }
                else if(jewels[count][count2] == 4){
                    g.setColor(Color.blue);
                }
                else if(jewels[count][count2] == 5){
                    g.setColor(new Color(255,0,255));
                }
                else if(jewels[count][count2] == 6){
                    g.setColor(Color.white);
                }
                g.fillOval(x+10,y+10,30,30);
                x += 50;
            }
            y += 50;
            x = 50;
        }
        g.setColor(Color.white);
        x = 50;
        y = 50;
        for(int count = 0;count != jewels.length;count++){
            for(int count2 = 0;count2 != jewels[count].length;count2++){
                g.drawRect(x,y,50,50);
                x += 50;
            }
            y += 50;
            x = 50;
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}