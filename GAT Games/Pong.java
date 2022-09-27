/*
 * CONTROLS:
 * 
 * W and S for UP and DOWN for left paddle
 * Up Arrow Key and Down Arrow Key for UP and DOWN for right paddle
 * 
 * CONTROLS:
 */
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Pong extends JApplet{
    @Override
    public void init(){
        add(new Pong_Engine());
    }
}
class Pong_Engine extends JPanel implements MouseListener, KeyListener{
    boolean tutorial;
    boolean stop;
    int cut;
    boolean start;
    boolean wait;
    boolean kPressed;
    boolean pause;
    boolean kReleased;
    boolean PvsC;
    boolean PvsP;
    boolean win;
    int p1Score;
    int p2Score;
    int ch;
    int mX;
    int mY;
    boolean mEntered;
    boolean mPressed;
    boolean mReleased;
    boolean mClick;
    boolean p1Up;
    boolean p1Down;
    boolean p2Up;
    boolean p2Down;
    Paddle p1;
    Paddle p2;
    Ball b;
    public Pong_Engine(){
        stop = false;
        tutorial = false;
        PvsC = true;
        PvsP = false;
        start = true;
        wait = true;
        cut = 0;
        this.setFocusable(true);
        this.requestFocusInWindow();
        win = false;
        pause = false;
        addKeyListener(this);
        p1Score = 0;
        p2Score = 0;
        addMouseListener(this);
        kReleased = false;
        kPressed = false;
        mEntered = false;
        mClick = false;
        p1Up = false;
        p1Down = false;
        p2Up = false;
        p2Down = false;
        mY = 0;
        mX = 0;
        mPressed = false;
        mReleased = false;
        p1 = new Paddle(200);
        p2 = new Paddle(200);
        b = new Ball(350,250,1,180);
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_W){
            p1Up = false;
        }
        else if(ch == KeyEvent.VK_S){
            p1Down = false;
        }
        if(ch == KeyEvent.VK_UP){
            p2Up = false;
        }
        else if(ch == KeyEvent.VK_DOWN){
            p2Down = false;
        }
        kReleased = true;
   }
    public void keyTyped(KeyEvent k){}
    public void keyPressed(KeyEvent k){
        kPressed = true;
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_R && !start && !tutorial){
            win = false;
            wait = true;
            p1.pY = 200;
            p2.pY = 200;
            p1Score = 0;
            p2Score = 0;
            b.bX = 375;
            b.bY = 250;
            b.bA = -180;
            b.bD = 0;
        }
        else if(ch == KeyEvent.VK_Y && !start && !tutorial){
            win = false;
            PvsP = false;
            PvsC = true;
            start = true;
            wait = true;
            p1.pY = 200;
            p2.pY = 200;
            p1Score = 0;
            p2Score = 0;
            b.bX = 375;
            b.bY = 250;
            b.bA = -180;
            b.bD = 0;
        }
        else if(ch == KeyEvent.VK_P && !win && !start && !tutorial){
            pause = !pause;
        }
        else if(ch == KeyEvent.VK_W && !pause && !win){
            p1Up = true;
        }
        else if(ch == KeyEvent.VK_S && !pause && !win){
            p1Down = true;
        }
        if(ch == KeyEvent.VK_UP && !pause && !win){
            p2Up = true;
        }
        else if(ch == KeyEvent.VK_DOWN && !pause && !win){
            p2Down = true;
        }
    }
    public void mouseEntered(MouseEvent me)
    {
        mEntered = true;
    }
    public void mouseExited(MouseEvent me)
    {
        mEntered = false;
    }
    public void mousePressed(MouseEvent me)
    {
        mPressed = true;
        mX = me.getX();
        mY = me.getY();
        if(tutorial && !start && mX > 330 && mX < 430 && mY > 373 && mY < 418){
            tutorial = false;
            start = true;
            p1.pY = 200;
            p2.pY = 200;
            b.bX = 375;
            b.bY = 250;
            b.bA = -180;
            b.bD = 0;
            stop = true;
            wait = true;
        }
        if(mX > 330 && mX < 430 && mY > 373 && mY < 418 && start && !stop){
            PvsC = true;
            wait = true;
            win = false;
            p1.pY = 200;
            p2.pY = 200;
            p1Score = 0;
            p2Score = 0;
            b.bX = 375;
            b.bY = 250;
            b.bA = -180;
            b.bD = 0;
            start = false;
            if(tutorial){
                b.bX = 200;
                b.bY = 50;
            }
        }
        stop = false;
        if(mX > 390 && mX < 415 && mY > 323 && mY < 348 && start){
            tutorial = true;
            PvsC = false;
            PvsP = false;
        }
        else if(mX > 390 && mX < 415 && mY > 223 && mY < 248 && start){
            PvsP = true;
            PvsC = false;
            tutorial = false;
        }
        else if(mX > 390 && mX < 415 && mY > 273 && mY < 298 && start){
           PvsC = true;
           PvsP = false;
           tutorial = false;
        }
    }
    public void mouseReleased(MouseEvent me)
    {
        mReleased = true;
    }
    public void mouseClicked(MouseEvent me)
    {
        mClick = true;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);
        if(start){
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.BOLD,150));
            g.drawString("P O N G",90,150);
            for(int count = 10;count != 510;count+= 50){
                g.drawRect(360,count,10,25);
            }
            g.fillRect(25,p1.pY,25,100);
            g.fillRect(700,p2.pY,25,100);
            g.fillOval(b.bX,b.bY,25,25);
            if(b.bY+6>p1.pY && b.bY-6<p1.pY && b.bD == 0){
            }
            else if(b.bY < p1.pY && b.bD == 0){
                p1.pY -= 6;
            }
            else if(b.bY > p1.pY && b.bD == 0){
                p1.pY += 6;
            }
            if(b.bY+6>p2.pY && b.bY-6<p2.pY && b.bD == 1){
            }
            else if(b.bY < p2.pY && b.bD == 1){
                p2.pY -= 6;
            }
            else if(b.bY > p2.pY && b.bD == 1){
                p2.pY += 6;
            }
        if(b.bA == 75 && b.bD == 1){
                b.bX += 7;
                b.bY -= 7;
        }
        else if(b.bA == -75 && b.bD == 1){
                b.bX += 7;
                b.bY += 7;
        }
        else if(b.bA == 75 && b.bD == 0){
                b.bX -= 7;
                b.bY -= 7;
        }
        else if(b.bA == -75 && b.bD == 0){
                b.bX -= 7;
                b.bY += 7;
        }
        else if(b.bA == 45 && b.bD == 1){
                b.bX += 6;
                b.bY -= 3;
        }
        else if(b.bA == -45 && b.bD == 1){
                b.bX += 6;
                b.bY += 3;
        }
        else if(b.bA == 45 && b.bD == 0){
                b.bX -= 6;
                b.bY -= 4;
        }
        else if(b.bA == -45 && b.bD == 0){
                b.bX -= 6;
                b.bY += 3;
        }
        else if(b.bA == 180){
                b.bX += 6;
        }
        else if(b.bA == -180){
                b.bX -= 6;
        }
        //detects if its hitting a paddle or not
        if(50 > b.bX && (p1.pY -25) < b.bY && b.bY < (p1.pY + 100)){
            if((b.bY - p1.pY) <= 20){
                b.bA = 75;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 20 && (b.bY - p1.pY) <= 40){
                b.bA = 45;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 40 && (b.bY - p1.pY) <= 60){
                b.bA = 180;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 60 && (b.bY - p1.pY) <= 80){
                b.bA = -45;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 80 && (b.bY - p1.pY) <= 100){
                b.bA = -75;
                b.bD = 1;
            }
        }
        else if(675 < b.bX && (p2.pY-25) < b.bY && b.bY < (p2.pY + 100)){
            if((b.bY - p2.pY) <= 20){
                b.bA = 75;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 20 && (b.bY - p2.pY) <= 40){
                b.bA = 45;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 40 && (b.bY - p2.pY) <= 60){
                b.bA = -180;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 60 && (b.bY - p2.pY) <= 80){
                b.bA = -45;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 80 && (b.bY - p2.pY) <= 100){
                b.bA = -75;
                b.bD = 0;
            }
        }
        //detects if its hitting a wall
        if(b.bY < 0){
             if(b.bA == 75){
                 b.bA = -75;
             }
             else if(b.bA == 45){
                 b.bA = -45;
             }
        }
        else if(b.bY > 475){
             if(b.bA == -75){
                 b.bA = 75;
             }
             else if(b.bA == -45){
                 b.bA = 45;
             }
        }
        g.setFont(new Font("Arial",Font.BOLD,15));
        g.drawString("PLAYER VS. PLAYER",200,240);
        if(PvsP){
            g.fillOval(390,223,25,25);
        }
        else{
            g.drawOval(390,223,25,25);
        }
        // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
        g.drawString("PLAYER VS. COMPUTER",170,290);
        if(PvsC){
            g.fillOval(390,273,25,25);
        }
        else{
            g.drawOval(390,273,25,25);
        }
        // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
        g.drawString("TUTORIAL",270,340);
        g.drawOval(390,323,25,25);
        if(tutorial){
            g.fillOval(390,323,25,25);
        }
        else{
            g.drawOval(390,323,25,25);
        }
        // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
        g.setColor(Color.white);
        g.fillRect(330,373,100,45);
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("START",340,405);
        }
        if(tutorial && !start){
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.BOLD,15));
            g.drawString("W and S move the left paddle up and down,",200,200);
            g.drawString("and arrow up and arrow down move the right paddle.",200,220);
            g.drawString("Press R to restart,",200,240);
            g.drawString("and P to pause/unpause",200,260);
            g.drawString("First player to reach a score of 10 wins",200,280);
            g.drawString("To score get the ball past your oponents paddle",200,300);
            g.drawString("Press Y to go back to the main menu",200,320);
            g.setFont(new Font("Arial",Font.BOLD,20));
            //
            g.drawString("Player One's",60,240);
            g.drawString("Paddle",60,260);
            //
            g.drawString("Player Two's",575,240);
            g.drawString("Paddle",630,260);
            //
            g.drawString("Ball",235,70);
            g.fillRect(330,373,100,45);
            g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("BACK",340,405);
            g.setColor(Color.white);
            for(int count = 10;count != 510;count+= 50){
                if(count == 160){
                    count = 360;
                }
                g.drawRect(360,count,10,25);
            }
            g.fillRect(25,p1.pY,25,100);
            g.fillRect(700,p2.pY,25,100);
            g.fillOval(b.bX,b.bY,25,25);
            if(p1Down && !(p1.pY > 400)){
                p1.pY += 6;
            }
            else{
                kReleased = false;
                p1Down = false;
            }
            if(p1Up && !(p1.pY < 0)){
                p1.pY -= 6;
            }
            else{
                kReleased = false;
                p1Up = false;
            }
            if(p2Up && !(p2.pY < 0)){
                p2.pY -=6;
            }
            else{
                kReleased = false;
                p2Up = false;
            }
            if(p2Down && !(p2.pY > 400)){
                p2.pY += 6;
            }
            else{
                kReleased = false;
                p2Down = false;
            }
        }
        if(!start && !tutorial){
        g.setColor(Color.white);
        g.fillRect(25,p1.pY,25,100);
        g.fillRect(700,p2.pY,25,100);
        g.setColor(Color.white);
        // DRAW SCORE AT TOP
        g.setFont(new Font("Arial",Font.BOLD,50));
        if(b.bX <25){
            p2Score++;
            wait = true;
            p1.pY = 200;
            p2.pY = 200;
            b.bX = 350;
            b.bY = 250;
            b.bA = -180;
        }
        else if(b.bX > 725){
            p1Score++;
            wait = true;
            p1.pY = 200;
            p2.pY = 200;
            b.bX = 350;
            b.bY = 250;
            b.bA = 180;
        }
        g.drawString(p1Score+"",300,50);
        g.drawString(p2Score+"",400,50);
        for(int count = 10;count != 510;count+= 50){
            g.drawRect(360,count,10,25);
        }
        g.setColor(Color.white);
        g.fillOval(b.bX,b.bY,25,25);
        if(p1Score == 10){
            g.drawString("Player 1 wins!",200,125);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("Press R to restart",255,180);
            g.drawString("Press Y to go back",250,235);
            g.drawString("to the main menu",260,290);
            win = true;
        }
        else if (p2Score == 10){
            g.drawString("Player 2 wins!",200,125);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("Press R to restart",255,180);
            g.drawString("Press Y to go back",250,235);
            g.drawString("to the main menu",260,290);
            win = true;
        }
        if(cut == 100){
            wait = false;
            cut = 0;
        }
        if(pause){
            g.fillRect(350,225,13,60);
            g.fillRect(370,225,13,60);
        }
        if(!win && !pause){
        if(p1Up && !(p1.pY < 0)){
            p1.pY -= 6;
        }
        else{
            kReleased = false;
            p1Up = false;
        }
        if(PvsP){
        if(p2Up && !(p2.pY < 0)){
            p2.pY -=6;
        }
        else{
            kReleased = false;
            p2Up = false;
        }
        if(p2Down && !(p2.pY > 400)){
            p2.pY += 6;
        }
        else{
            kReleased = false;
            p2Down = false;
        }
        }
        else{
            if(b.bY+6>p2.pY && b.bY-6<p2.pY){
            }
            else if(b.bY < p2.pY){
                p2.pY -= 6;
            }
            else if(b.bY > p2.pY){
                p2.pY += 6;
            }
        }
        if(p1Down && !(p1.pY > 400)){
            p1.pY += 6;
        }
        else{
            kReleased = false;
            p1Down = false;
        }
        // changes x and y based on speed and angle
        if(!wait){
        if(b.bA == 75 && b.bD == 1){
                b.bX += 7;
                b.bY -= 7;
        }
        else if(b.bA == -75 && b.bD == 1){
                b.bX += 7;
                b.bY += 7;
        }
        else if(b.bA == 75 && b.bD == 0){
                b.bX -= 7;
                b.bY -= 7;
        }
        else if(b.bA == -75 && b.bD == 0){
                b.bX -= 7;
                b.bY += 7;
        }
        else if(b.bA == 45 && b.bD == 1){
                b.bX += 6;
                b.bY -= 3;
        }
        else if(b.bA == -45 && b.bD == 1){
                b.bX += 6;
                b.bY += 3;
        }
        else if(b.bA == 45 && b.bD == 0){
                b.bX -= 6;
                b.bY -= 4;
        }
        else if(b.bA == -45 && b.bD == 0){
                b.bX -= 6;
                b.bY += 3;
        }
        else if(b.bA == 180){
                b.bX += 6;
        }
        else if(b.bA == -180){
                b.bX -= 6;
        }
        }
        //detects if its hitting a paddle or not
        if(50 > b.bX && (p1.pY -25) < b.bY && b.bY < (p1.pY + 100)){
            if((b.bY - p1.pY) <= 20){
                b.bA = 75;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 20 && (b.bY - p1.pY) <= 40){
                b.bA = 45;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 40 && (b.bY - p1.pY) <= 60){
                b.bA = 180;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 60 && (b.bY - p1.pY) <= 80){
                b.bA = -45;
                b.bD = 1;
            }
            else if((b.bY - p1.pY) > 80 && (b.bY - p1.pY) <= 100){
                b.bA = -75;
                b.bD = 1;
            }
        }
        else if(675 < b.bX && (p2.pY-25) < b.bY && b.bY < (p2.pY + 100)){
            if((b.bY - p2.pY) <= 20){
                b.bA = 75;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 20 && (b.bY - p2.pY) <= 40){
                b.bA = 45;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 40 && (b.bY - p2.pY) <= 60){
                b.bA = -180;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 60 && (b.bY - p2.pY) <= 80){
                b.bA = -45;
                b.bD = 0;
            }
            else if((b.bY - p2.pY) > 80 && (b.bY - p2.pY) <= 100){
                b.bA = -75;
                b.bD = 0;
            }
        }
        //detects if its hitting a wall
        if(b.bY < 0){
             if(b.bA == 75){
                 b.bA = -75;
             }
             else if(b.bA == 45){
                 b.bA = -45;
             }
        }
        else if(b.bY > 475){
             if(b.bA == -75){
                 b.bA = 75;
             }
             else if(b.bA == -45){
                 b.bA = 45;
             }
        }
    }
    if(wait){
        cut++;
    }
    }
        try{
            Thread.sleep(10);
        }
        catch(Exception e){}
        repaint();
}
}