// CONTROLS
/*
 * 
 * 
 * 
 * R to restart
 * 
 * 
 * 
 * 
 * CONTROLS
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Connect4 extends JApplet{
    @Override
    public void init(){
        add(new Connect4_Engine());
    }
}
class Connect4_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    Board board;
    boolean RedAI;
    boolean YellowAI;
    int delay;
    boolean tie;
    public Connect4_Engine(){
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
        board = new Board(435,100);
        RedAI = !true;
        YellowAI = !true;
        delay = 0;
        tie = false;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        // resets board when r is pressed and someone has won
        if(ch == KeyEvent.VK_R && (board.p1Win || board.p2Win || tie)){
            board.reset();
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
        // detects which collumn a player has clicked in and places a piece there
        if(!board.p1Win && !board.p2Win && !(RedAI && board.turn == 1)&& !(YellowAI && board.turn == 2)){
            for(int count = 0;count != 7;count++){
                if(mX>board.x+(count*100)&&mX<board.x+12+((count+1)*100)){
                    board.move(count);
                    board.win();
                    break;
                }
            }
        }
        if(mX>100 && mX<265 && mY>475 && mY<525 &&(tie || board.p1Win || board.p2Win)){
            board.reset();
        }
        if(mX>100 && mX<250 && mY>275 && mY<325){
            RedAI = !RedAI;
        }
        else if(mX>100 && mX<300 && mY>375 && mY<425){
            YellowAI = !YellowAI;
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.setColor(Color.white);
        // draws buttons
        g.setColor(Color.red);
        g.fillRect(100,275,150,50);
        g.setColor(Color.yellow);
        g.fillRect(100,375,200,50);
        g.setColor(Color.blue);
        g.fillRect(100,475,165,50);
        g.setColor(Color.black);
        if(RedAI){
            g.drawString("Red AI: On",110,308);
        }
        else{
            g.drawString("Red AI: Off",110,308);
        }
        if(YellowAI){
            g.drawString("Yellow AI: On",110,408);
        }
        else{
            g.drawString("Yellow AI: Off",110,408);
        }
        g.drawString("Reset Board",110,508);
        // draws board
        board.drawBoard(g);
        // tells who has won
        tie = true;
        for(int count = 0;count != 42;count++){
            if(board.Pieces.get(count).t == 0){
                tie = false;
            }
        }
        g.setFont(new Font("Arial",Font.BOLD,100));
        if(board.p1Win){
            g.setColor(Color.red);
            g.drawString("Red wins!",565,85);
        }
        else if(board.p2Win){
            g.setColor(Color.yellow);
            g.drawString("Yellow wins!",510,85);
        }
        else if(tie){
            g.setColor(Color.green);
            g.drawString("It's a Tie",510,85);
        }
        // runs AI if the delay timer is done and AI is turned on
        if(board.turn == 1 && RedAI && delay == 0 && !board.p1Win && !board.p2Win){
            // activates logic
            board.moveAI();
            board.win();
            delay = 0;
        }
        else if(board.turn == 1 && RedAI && !board.p1Win && !board.p2Win){
            // ticks the timer down if AI is enabled
            delay--;
        }
        if(board.turn == 2 && YellowAI && delay == 0 && !board.p1Win && !board.p2Win){
            // activates logic
            board.moveAI();
            board.win();
            delay = 0;
        }
        else if(board.turn == 2 && YellowAI && !board.p1Win && !board.p2Win){
            // ticks the timer down if AI is enabled
            delay--;
        }
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.setColor(Color.black);
        g.drawString(""+board.ar,100,100);
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}