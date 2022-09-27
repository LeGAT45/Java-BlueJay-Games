import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
import java.util.concurrent.TimeUnit;
public class TicTacToe extends JApplet{
    @Override
    public void init(){
        add(new TicTacToe_Engine());
    }
}
class TicTacToe_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    boolean mEntered;
    boolean mClick;
    boolean mReleased;
    boolean mPressed;
    //^^^^^^^^^^^^^^
    int[]Squares;
    int turn;
    int incrementX;
    int incrementY;
    int L1x1;
    int L1x2;
    int L1y1;
    int L1y2;
    int L2x1;
    int L2x2;
    int L2y1;
    int L2y2;
    boolean xWin;
    boolean oWin;
    int tempX;
    int tempY;
    boolean tie;
    boolean AI;
    int round;
    boolean skip;
    Random rand;
    int randy;
    boolean keep;
    public TicTacToe_Engine(){
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        // mouseListener
        addMouseListener(this);
        mEntered = true;
        mClick = false;
        mReleased = false;
        mPressed = false;
        // ^^^^^^^^^^^
        Squares = new int[9];
        for(int count = 0;count != 9;count++){
            Squares[count] = 0;
        }
        incrementX = 0;
        incrementY = 0;
        L1x1 = 75;
        L1y1 = 75;
        L1x2 = 225;
        L1y2 = 225;
        L2x1 = 225;
        L2y1 = 75;
        L2x2 = 75;
        L2y2 = 225;
        xWin = false;
        oWin = false;
        tempX = 0;
        tempY = 0;
        AI = false;
        skip = false;
        round = 0;
        rand = new Random();
        randy = 0;
        keep = true;
        turn = rand.nextInt(2)+1;
    }
    // keyListener class methods
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_R){
            xWin = false;
            oWin = false;
            tie = false;
            for(int count  = 0;count != 9;count++){
                Squares[count] = 0;
            }
            //repaint();
            turn = rand.nextInt(2)+1;
            round = 0;
        }
        else if(ch == KeyEvent.VK_A){
            AI = !AI;
        }
    }
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
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
        if(!xWin && !oWin){
            if(!AI || turn != 1){
            for(int count = 0;count!=9;count++){
                if(mX > 50 + incrementX && mX < 250 + incrementX && mY > 50 + incrementY && mY < 250 + incrementY){
                    if(turn == 1){
                        if(Squares[count] == 0){
                            Squares[count] = 1;
                            turn = 2;
                        }
                    }
                    else{
                        if(Squares[count] == 0){
                            Squares[count] = 2;
                            turn = 1;
                        }
                    }
                }
                incrementX += 250;
                if(incrementX == 750){
                    incrementY += 250;
                    incrementX = 0;
                }
            }
            incrementX = 0;
            incrementY = 0;
            //repaint();
            }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        //drawing board
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,150));
        g.fillRect(250,50,25,700);
        g.fillRect(500,50,25,700);
        g.fillRect(50,250,700,25);
        g.fillRect(50,500,700,25);
        //drawing X's and O's in board
        for(int count = 0;count != 9;count++){
            if(Squares[count] == 1){
                g2.setColor(Color.red);
                g2.drawLine(L1x1 + incrementX,L1y1 + incrementY,L1x2 + incrementX,L1y2 + incrementY);
                g2.drawLine(L2x1 + incrementX,L2y1 + incrementY,L2x2 + incrementX,L2y2 + incrementY);
            }
            else if(Squares[count] == 2){
                g.setColor(Color.blue);
                g.drawOval(75+incrementX,75+incrementY,150,150);
            }
            incrementX += 250;
            if(incrementX == 750){
                incrementX = 0;
                incrementY += 250;
            }
        }
        incrementX = 0;
        incrementY = 0;
        // detecting in a player wins
        for(int count = 0;count != 3;count++){
            //vertical win condition
            if(Squares[count] == 1 && Squares[count+3] == 1 && Squares[count+6] == 1){
                xWin = true;
            }
            else if(Squares[count] == 2 && Squares[count+3] == 2 && Squares[count+6] == 2){
                oWin = true;
            }
            //horozontal win condition
            else if(Squares[count*3] == 1 && Squares[count*3+1] == 1 && Squares[count*3+2] == 1){
                xWin = true;
            }
            else if(Squares[count*3] == 2 && Squares[count*3+1] == 2 && Squares[count*3+2] == 2){
                oWin = true;
            }
            //top left to bottom right diagonal win condition
            else if(Squares[0] == 1 && Squares[4] == 1 && Squares[8] == 1){
                xWin = true;
            }
            else if(Squares[0] == 2 && Squares[4] == 2 && Squares[8] == 2){
                oWin = true;
            }
            //bottom left to top right diagonal win condition
            else if(Squares[6] == 1 && Squares[4] == 1 && Squares[2] == 1){
                xWin = true;
            }
            else if(Squares[6] == 2 && Squares[4] == 2 && Squares[2] == 2){
                oWin = true;
            }
        }
        if(xWin){
            g.setColor(Color.red);
            g.drawString("X wins!",150,400);
        }
        else if(oWin){
            g.setColor(Color.blue);
            g.drawString("O wins!",150,400);
        }
        else{
            tie = true;
            for(int count = 0;count != 9;count++){
                if(Squares[count] == 0){
                    tie = false;
                }
            }
            if(tie){
                g.setColor(Color.green);
                g.drawString("Tie!",220,420);
            }
        }
        if(xWin || oWin || tie){
            g.setFont(new Font("Arial",Font.BOLD,50));
            g.drawString("Press R to restart",200,500);
        }
        // AI
        if(AI && turn == 1 && !xWin && !oWin){
            // blocking / winning
            for(int count = 0;count != 3;count++){
                //vertical win condition
                if(Squares[count] + Squares[count+3] + Squares[count+6] == 2 && Squares[count] != 2 && Squares[count+3] != 2  && Squares[count+6] != 2){
                    if(Squares[count] == 0){
                        Squares[count] = 1;
                    }
                    else if(Squares[count+3] == 0){
                        Squares[count+3] = 1;
                    }
                    else if(Squares[count+6] == 0){
                        Squares[count+6] = 1;
                    }
                    skip = true;
                    break;
                }
                else if(Squares[count*3] + Squares[count*3+1] + Squares[count*3+2] == 2 && Squares[count*3] != 2 && Squares[count*3+1] != 2  && Squares[count*3+2] != 2){
                    if(Squares[count*3] == 0){
                        Squares[count*3] = 1;
                    }
                    else if(Squares[count*3+1] == 0){
                        Squares[count*3+1] = 1;
                    }
                    else if(Squares[count*3+2] == 0){
                        Squares[count*3+2] = 1;
                    }
                    skip = true;
                    break;
                }
                else if(Squares[0] + Squares[4] + Squares[8] == 2 && Squares[0] != 2 && Squares[4] != 2  && Squares[8] != 2){
                    if(Squares[0] == 0){
                        Squares[0] = 1;
                    }
                    else if(Squares[4] == 0){
                        Squares[4] = 1;
                    }
                    else if(Squares[8] == 0){
                        Squares[8] = 1;
                    }
                    skip = true;
                    break;
                }
                else if(Squares[6] + Squares[4] + Squares[2] == 2 && Squares[6] != 2 && Squares[4] != 2  && Squares[2] != 2){
                    if(Squares[6] == 0){
                        Squares[6] = 1;
                    }
                    else if(Squares[4] == 0){
                        Squares[4] = 1;
                    }
                    else if(Squares[2] == 0){
                        Squares[2] = 1;
                    }
                    skip = true;
                    break;
                }
            }
            if(!skip){
            for(int count = 0;count != 3;count++){
                if(Squares[count] + Squares[count+3] + Squares[count+6] == 4 && Squares[count] != 1 && Squares[count+3] != 1  && Squares[count+6] != 1){
                    if(Squares[count] == 0){
                        Squares[count] = 1;
                    }
                    else if(Squares[count+3] == 0){
                        Squares[count+3] = 1;
                    }
                    else if(Squares[count+6] == 0){
                        Squares[count+6] = 1;
                    }
                    skip = true;
                    break;
                }
                //horozontal win condition
                else if(Squares[count*3] + Squares[count*3+1] + Squares[count*3+2] == 4 && Squares[count*3] != 1 && Squares[count*3+1] != 1  && Squares[count*3+2] != 1){
                    if(Squares[count*3] == 0){
                        Squares[count*3] = 1;
                    }
                    else if(Squares[count*3+1] == 0){
                        Squares[count*3+1] = 1;
                    }
                    else if(Squares[count*3+2] == 0){
                        Squares[count*3+2] = 1;
                    }
                    skip = true;
                    break;
                }
                //top left to bottom right diagonal win condition
                else if(Squares[0] + Squares[4] + Squares[8] == 4 && Squares[0] != 1 && Squares[4] != 1  && Squares[8] != 1){
                    if(Squares[0] == 0){
                        Squares[0] = 1;
                    }
                    else if(Squares[4] == 0){
                        Squares[4] = 1;
                    }
                    else if(Squares[8] == 0){
                        Squares[8] = 1;
                    }
                    skip = true;
                    break;
                }
                //bottom left to top right diagonal win condition
                else if(Squares[6] + Squares[4] + Squares[2] == 4 && Squares[6] != 1 && Squares[4] != 1  && Squares[2] != 1){
                    if(Squares[6] == 0){
                        Squares[6] = 1;
                    }
                    else if(Squares[4] == 0){
                        Squares[4] = 1;
                    }
                    else if(Squares[2] == 0){
                        Squares[2] = 1;
                    }
                    skip = true;
                    break;
                }
            }
        }
        if(!skip){
                if(round == 0){
                    if(Squares[0] == 2 || Squares[2] == 2 || Squares[8] == 2 || Squares[6] == 2){
                        Squares[4] = 1;
                    }
                    else if(Squares[0] == 0){
                        Squares[0] = 1;
                    }
                }
                else if(round == 1){
                    if(Squares[4] == 0 && Squares[1] == 0 && Squares[2] == 0){
                        Squares[2] = 1;
                    }
                    else if(Squares[4] == 0 && Squares[6] == 0 && Squares[3] == 0){
                        Squares[6] = 1;
                    }
                    else if(Squares[8] == 0){
                        Squares[8] = 1;
                    }
                    else{
                        Squares[2] = 1;
                    }
                }
                else if(round == 2){
                    if(Squares[4] == 0 && Squares[8] == 0 && Squares[6] != 2 && Squares[2] != 2){
                        Squares[4] = 1;
                    }
                    else if(Squares[2] == 1 && Squares[4] == 0){
                        if(Squares[6] == 2){
                            Squares[8] = 1;
                        }
                        else{
                            Squares[6] = 1;
                        }
                    }
                    else if(Squares[6] == 1 && Squares[4] == 0){
                        if(Squares[2] == 2){
                            Squares[8] = 1;
                        }
                        else{
                            Squares[2] = 1;
                        }
                    }
                    else if(Squares[2] == 2){
                        Squares[6] = 1;
                    }
                    else if(Squares[6] == 2){
                        Squares[2] = 1;
                    }
                }
                else{
                    for(int count = 0;count != 9;count++){
                        if(Squares[count] == 0){
                            Squares[count] = 1;
                            break;
                        }
                    }
                }
            }
            if(skip)
                skip = false;
            turn = 2;
            round++;
            //repaint();
        }
        try{
            Thread.sleep(100);
        }catch(Exception e){}
        repaint();
    }
}