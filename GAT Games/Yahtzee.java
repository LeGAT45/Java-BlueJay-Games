import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
// top scores
// GAT - 279
public class Yahtzee extends JApplet{
    @Override
    public void init(){
        add(new Yahtzee_Engine());
    }
}
class Yahtzee_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    Random rand;
    String word;
    Rolls r1;
    Rolls r2;
    int x;
    int y;
    ArrayList<dice>dice;
    int left;
    int turn;
    boolean reset;
    int wait;
    int ani;
    public Yahtzee_Engine(){
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
        word = "";
        dice = new ArrayList<dice>();
        for(int count = 0;count != 5;count++){
            dice.add(0,new dice(0,false));
        }
        r1 = new Rolls(0,0,0,0,0,0,0,0,0,0,0,0,0);
        r2 = new Rolls(0,0,0,0,0,0,0,0,0,0,0,0,0);
        x = 0;
        y = 0;
        left = 3;
        turn = 1;
        reset = false;
        wait = 0;
        ani = 0;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(r2.one!= 0&&r2.two!= 0&&r2.three!= 0&&r2.four!= 0&&r2.five!= 0&&r2.six!= 0&&r2.threeOfaKind!= 0&&r2.fourOfaKind!= 0&&r2.fullHouse!= 0&&r2.smStraight!= 0&&r2.lgStraight!= 0&&r2.yahtzee!= 0&&r2.chance!= 0){
            if(ch == KeyEvent.VK_R){
                r1 = new Rolls(0,0,0,0,0,0,0,0,0,0,0,0,0);
                r2 = new Rolls(0,0,0,0,0,0,0,0,0,0,0,0,0);
                left = 3;
                turn = 1;
                reset = false;
                x = 0;
                y = 0;
                for(int count = 0;count != 5;count++){
                    dice.get(count).n = 0;
                    dice.get(count).lock = false;
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
        if(mX>545&&mX<650&&mY>565&&mY<605 && left != 0){
            ani = 6;
            for(int count = 0;count != dice.size();count++){
                dice.get(count).roll();
            }
            left--;
        }
        x = 247;
        y = 650;
        for(int count = 0;count != dice.size();count++){
            if(mX>x&&mX<x+100&&mY>y&&mY<y+100){
                if(dice.get(count).n != 0){
                    dice.get(count).lock = !dice.get(count).lock;
                }
            }
            x += 150;
        }
        if(turn == 1){
            x = 0;
        }
        else{
            x = 600;
        }
        y = 0;
        for(int count = 0;count != 13;count++){
            reset = false;
            if(mX>x+50 && mX<x+250 && mY>y+175 && mY<y+210){
                if(turn == 1 && dice.get(0).n != 0){
                    if(count == 0){
                        if(r1.one == 0){
                            reset = true;
                            r1.one(dice);
                        }
                    }
                    else if(count == 1){
                        if(r1.two == 0){
                            reset = true;
                            r1.two(dice);
                        }
                    }
                    else if(count == 2){
                        if(r1.three == 0){
                            r1.three(dice);reset = true;
                        }
                    }
                    else if(count == 3){
                        if(r1.four == 0){
                            r1.four(dice);reset = true;
                        }
                    }
                    else if(count == 4){
                        if(r1.five == 0){
                            r1.five(dice);reset = true;
                        }
                    }
                    else if(count == 5){
                        if(r1.six == 0){
                            r1.six(dice);reset = true;
                        }
                    }
                    else if(count == 6){
                        if(r1.threeOfaKind == 0){
                            r1.threeOfaKind(dice);reset = true;
                        }
                    }
                    else if(count == 7){
                        if(r1.fourOfaKind == 0){
                            r1.fourOfaKind(dice);reset = true;
                        }
                    }
                    else if(count == 8){
                        if(r1.fullHouse == 0){
                            r1.fullHouse(dice);reset = true;
                        }
                    }
                    else if(count == 9){
                        if(r1.smStraight == 0){
                            r1.smStraight(dice);reset = true;
                        }
                    }
                    else if(count == 10){
                        if(r1.lgStraight == 0){
                            r1.lgStraight(dice);reset = true;
                        }
                    }
                    else if(count == 11){
                        if(r1.yahtzee == 0){
                            r1.yahtzee(dice);reset = true;
                        }
                    }
                    else if(count == 12){
                        if(r1.chance == 0){
                            r1.chance(dice);reset = true;
                        }
                    }
                    if(reset){
                        left = 3;
                        for(int count2 = 0;count2 != dice.size();count2++){
                            dice.get(count2).n = 0;
                            dice.get(count2).lock = false;
                        }
                        turn++;
                    }
                }
                else if(turn == 2 && dice.get(0).n != 0){
                    if(count == 0){
                        if(r2.one == 0){
                            r2.one(dice);reset = true;
                        }
                    }
                    else if(count == 1){
                        if(r2.two == 0){
                            r2.two(dice);reset = true;
                        }
                    }
                    else if(count == 2){
                        if(r2.three == 0){
                            r2.three(dice);reset = true;
                        }
                    }
                    else if(count == 3){
                        if(r2.four == 0){
                            r2.four(dice);reset = true;
                        }
                    }
                    else if(count == 4){
                        if(r2.five == 0){
                            r2.five(dice);reset = true;
                        }
                    }
                    else if(count == 5){
                        if(r2.six == 0){
                            r2.six(dice);reset = true;
                        }
                    }
                    else if(count == 6){
                        if(r2.threeOfaKind == 0){
                            r2.threeOfaKind(dice);reset = true;
                        }
                    }
                    else if(count == 7){
                        if(r2.fourOfaKind == 0){
                            r2.fourOfaKind(dice);reset = true;
                        }
                    }
                    else if(count == 8){
                        if(r2.fullHouse == 0){
                            r2.fullHouse(dice);reset = true;
                        }
                    }
                    else if(count == 9){
                        if(r2.smStraight == 0){
                            r2.smStraight(dice);reset = true;
                        }
                    }
                    else if(count == 10){
                        if(r2.lgStraight == 0){
                            r2.lgStraight(dice);reset = true;
                        }
                    }
                    else if(count == 11){
                        if(r2.yahtzee == 0){
                            r2.yahtzee(dice);reset = true;
                        }
                    }
                    else if(count == 12){
                        if(r2.chance == 0){
                            r2.chance(dice);reset = true;
                        }
                    }
                    if(reset){
                        left = 3;
                        for(int count2 = 0;count2 != dice.size();count2++){
                            dice.get(count2).n = 0;
                            dice.get(count2).lock = false;
                        }
                        turn = 1;
                    }
                }
            }
            if(y == 300){
                y = 0;
                x += 300;
            }
            else{
                y += 50;
            }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(125,100,200));
        g.setFont(new Font("Arial",Font.BOLD,100));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g.setColor(Color.white);
        g2.setColor(Color.white);
        g.drawString("Yahtzee",400,135);
        g2.drawLine(50,150,1150,150);
        g2.drawLine(600,150,600,600);
        g.setFont(new Font("Arial",Font.BOLD,50));
        if(ani>0 && wait == 0){
            ani--;
            for(int count = 0;count != dice.size();count++){
                dice.get(count).roll();
            }
            wait = 1;
        }
        else if(ani>0&&wait>0){
            wait--;
        }
        if(turn == 1){
            g.setColor(Color.yellow);
        }
        else{
            g.setColor(Color.white);
        }
        g.drawString("Player One",75,135);
        if(turn == 2){
            g.setColor(Color.yellow);
        }
        else{
            g.setColor(Color.white);
        }
        g.drawString("Player Two",850,135);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,25));
        x = 0;
        y = 0;
        for(int count = 0;count != 14;count++){
            if(count == 0){
                word = "One: "+r1.one;
            }
            else if(count == 1){
                word = "Two: "+r1.two;
            }
            else if(count == 2){
                word = "Three: "+r1.three;
            }
            else if(count == 3){
                word = "Four: "+r1.four;
            }
            else if(count == 4){
                word = "Five: "+r1.five;
            }
            else if(count == 5){
                word = "Six: "+r1.six;
            }
            else if(count == 6){
                word = "Three Of A Kind: "+r1.threeOfaKind;
            }
            else if(count == 7){
                word = "Four Of A Kind: "+r1.fourOfaKind;
            }
            else if(count == 8){
                word = "Full House: "+r1.fullHouse;
            }
            else if(count == 9){
                word = "Small Straight: "+r1.smStraight;
            }
            else if(count == 10){
                word = "Large Straight: "+r1.lgStraight;
            }
            else if(count == 11){
                word = "Yahtzee: "+r1.yahtzee;
            }
            else if(count == 12){
                word = "Chance: "+r1.chance;
            }
            else{
                word = "Total: "+r1.score();
            }
            g.drawString(word,50+x,200+y);
            if(y == 300){
                y = 0;
                x = 300;
            }
            else{
                y += 50;
            }
        }
        x = 600;
        y = 0;
        for(int count = 0;count != 14;count++){
            if(count == 0){
                word = "One: "+r2.one;
            }
            else if(count == 1){
                word = "Two: "+r2.two;
            }
            else if(count == 2){
                word = "Three: "+r2.three;
            }
            else if(count == 3){
                word = "Four: "+r2.four;
            }
            else if(count == 4){
                word = "Five: "+r2.five;
            }
            else if(count == 5){
                word = "Six: "+r2.six;
            }
            else if(count == 6){
                word = "Three Of A Kind: "+r2.threeOfaKind;
            }
            else if(count == 7){
                word = "Four Of A Kind: "+r2.fourOfaKind;
            }
            else if(count == 8){
                word = "Full House: "+r2.fullHouse;
            }
            else if(count == 9){
                word = "Small Straight: "+r2.smStraight;
            }
            else if(count == 10){
                word = "Large Straight: "+r2.lgStraight;
            }
            else if(count == 11){
                word = "Yahtzee: "+r2.yahtzee;
            }
            else if(count == 12){
                word = "Chance: "+r2.chance;
            }
            else{
                word = "Total: "+r2.score();
            }
            g.drawString(word,50+x,200+y);
            if(y == 300){
                y = 0;
                x += 300;
            }
            else{
                y += 50;
            }
        }
        // dice
        x = 247;
        y = 650;
        for(int count = 0;count != dice.size();count++){
            dice.get(count).drawDice(g,x,y);
            x += 150;
        }
        // roll button
        g.setColor(Color.white);
        g.fillRect(545,565,105,40);
        g.setColor(new Color(125,100,200));
        g.setFont(new Font("Arial",Font.BOLD,35));
        g.drawString("ROLL",550,600);
        g.setColor(Color.white);
        g.drawString("Rolls left: "+left,510,640);
        if(r2.one!= 0&&r2.two!= 0&&r2.three!= 0&&r2.four!= 0&&r2.five!= 0&&r2.six!= 0&&r2.threeOfaKind!= 0&&r2.fourOfaKind!= 0&&r2.fullHouse!= 0&&r2.smStraight!= 0&&r2.lgStraight!= 0&&r2.yahtzee!= 0&&r2.chance!= 0){
            g.setFont(new Font("Arial",Font.BOLD,50));
            if(r2.score() > r1.score()){
                g.setColor(Color.green);
                g.drawString("Player Two Wins!",550,300);
            }
            else if(r2.score() < r1.score()){
                g.setColor(Color.green);
                g.drawString("Player One Wins!",550,300);
            }
            else{
                g.setColor(Color.green);
                g.drawString("It's A Tie!",550,300);
            }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}