/*
 * CONTROLS:
 * 
 * WASD or Arrow Keys to move
 * P to pause
 * R to restart
 * 
 * CONTROLS:
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Snake2 extends JApplet{
    @Override
    public void init(){
        add(new Snake2_Engine());
    }
}
class Snake2_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<body>snake;
    int redX;
    int redY;
    Random rand;
    int x;
    int y;
    int red;
    int blue;
    int green;
    int score;
    ArrayList<tBox>turn;
    int delay;
    boolean dead;
    boolean pause;
    int sColor;
    public Snake2_Engine(){
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
        /*
         * Change this variable to change color
         */
                      sColor = 5;
                      /*
                       * Color code:
                       * blue = 0;
                       * purple = 1;
                       * orange = 2;
                       * black = 3;
                       * Green = 4;
                       * light blue = 5;
                       */
        rand = new Random();
        snake = new ArrayList<body>();
        snake.add(new body(290,530,0));
        snake.add(new body(290,570,0));
        snake.add(new body(290,610,0));
        x = 50;
        y = 50;
        redX = -1;
        score = 0;
        delay = 0;
        dead = false;
        pause = false;
        while(redX == -1){
            redX = 50+rand.nextInt(14)*40;
            redY = 50+rand.nextInt(14)*40;
            for(int count = 0;count != snake.size();count++){
                if(snake.get(count).x == redX && snake.get(count).y == redY){
                    redX = -1;
                }
            }
        }
        turn = new ArrayList<tBox>();
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        x = 0;
        y = 0;
        if(ch == KeyEvent.VK_W || ch == KeyEvent.VK_UP){
            if(snake.get(0).d == 1){
                x = (snake.get(0).x-50)/40*40+50+40;
                y = snake.get(0).y;
            }
            else if(snake.get(0).d == 3){
                x = (snake.get(0).x-50)/40*40+50;
                y = snake.get(0).y;
            }
            /*
            else if(turn.get(0).d == 1){
                x = (snake.get(0).x-50)/40*40+50+40;
                y = turn.get(0).y;
            }
            else if(turn.get(0).d == 3){
                x = (snake.get(0).x-50)/40*40+50-40;
                y = turn.get(0).y;
            }
            if(x != 0){
                turn.add(0,new tBox(x,y,0));
            }*/
            if(turn.size() == 0 || (x != 0 && !(turn.get(0).x == x && turn.get(0).y == y))){
                turn.add(0,new tBox(x,y,0));
            }
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            if(snake.get(0).d == 0){
                x = snake.get(0).x;
                y = (snake.get(0).y-50)/40*40+50;
            }
            else if(snake.get(0).d == 2){
                x = snake.get(0).x;
                y = (snake.get(0).y-50)/40*40+90;
            }
            /*else if(turn.get(0).d == 0){
                x = turn.get(0).x;
                y = (snake.get(0).y-50)/40*40+50-40;
            }
            else if(turn.get(0).d == 2){
                x = turn.get(0).x;
                y = (snake.get(0).y-50)/40*40+50+40;
            }*/
            if(turn.size() == 0 || (x != 0 && !(turn.get(0).x == x && turn.get(0).y == y))){
                turn.add(0,new tBox(x,y,1));
            }
        }
        else if(ch == KeyEvent.VK_S || ch == KeyEvent.VK_DOWN){ 
            if(snake.get(0).d == 1){
                x = (snake.get(0).x-50)/40*40+90;
                y = snake.get(0).y;
            }
            else if(snake.get(0).d == 3){
                x = (snake.get(0).x-50)/40*40+50;
                y = snake.get(0).y;
            }
            /*
            else if(turn.get(0).d == 1){
                x = (snake.get(0).x-50)/40*40+50+40;
                y = turn.get(0).y;
            }
            else if(turn.get(0).d == 3){
                x = (snake.get(0).x-50)/40*40+50-40;
                y = turn.get(0).y;
            }*/
            if(turn.size() == 0 || (x != 0 && !(turn.get(0).x == x && turn.get(0).y == y))){
                turn.add(0,new tBox(x,y,2));
            }
        }
        else if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            if(snake.get(0).d == 0){
                x = snake.get(0).x;
                y = (snake.get(0).y-50)/40*40+50;
            }
            else if(snake.get(0).d == 2){
                x = snake.get(0).x;
                y = (snake.get(0).y-50)/40*40+90;
            }
            /*else if(turn.get(0).d == 0){
                x = turn.get(0).x;
                y = (snake.get(0).y-50)/40*40+50-40;
            }
            else if(turn.get(0).d == 2){
                x = turn.get(0).x;
                y = (snake.get(0).y-50)/40*40+50+40;
            }*/
            if(turn.size() == 0 || (x != 0 && !(turn.get(0).x == x && turn.get(0).y == y))){
                turn.add(0,new tBox(x,y,3));
            }
        }
        else if(ch == KeyEvent.VK_R && dead){
            snake = new ArrayList<body>();
            snake.add(new body(290,530,0));
            snake.add(new body(290,570,0));
            snake.add(new body(290,610,0));
            x = 50;
            y = 50;
            redX = -1;
            score = 0;
            delay = 0;
            dead = false;
            while(redX == -1){
                redX = 50+rand.nextInt(14)*40;
                redY = 50+rand.nextInt(14)*40;
                for(int count = 0;count != snake.size();count++){
                    if(snake.get(count).x == redX && snake.get(count).y == redY){
                        redX = -1;
                    }
                }
            }
            turn = new ArrayList<tBox>();
        }
        else if(ch == KeyEvent.VK_P && !dead){
            pause = !pause;
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
        x = 275;
        for(int count = 0;count != 6;count++){
            if(mX>x && mX<x+30 && mY>10 && mY<40){
                sColor = count;
            }
            x+=50;
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,10));
        g.setColor(Color.white);
        x = 50;
        y = 50;
        for(int count = 0;count != 225;count++){
            if(count%2 == 0){
                g.setColor(new Color(50,200,30));
            }
            else{
                g.setColor(new Color(50,250,30));
            }
            g.fillRect(x,y,40,40);
            if(x == redX && y == redY){
                g.setColor(Color.red);
                g.fillOval(x+6,y+8,28,28);
                g.setColor(new Color(10,100,10));
                g.fillArc(x+20,y+3,10,8,0,180);
                g.setColor(new Color(150,100,70));
                g.fillRect(x+18,y+3,3,6);
                g.setColor(new Color(255,100,100));
                g.fillArc(x+10,y+12,10,8,60,210);
            }
            if(x == 50+40*14){
                x = 50;
                y+=40;
            }else{
                x+=40;
            }
        }
        for(int count = 0;count != snake.size();count++){
            for(int count2 = 0;count2 < turn.size();count2++){
                if(turn.get(count2).x == snake.get(count).x && turn.get(count2).y == snake.get(count).y){
                    snake.get(count).d = turn.get(count2).d;
                    if(count == snake.size()-1){
                        turn.remove(count2);
                    }
                }
            }
            if(!dead && !pause){
                if(!(count == snake.size()-1 && delay != 0)){
                    if(snake.get(count).d == 0){
                        snake.get(count).y-=5;
                    }
                    else if(snake.get(count).d == 1){
                        snake.get(count).x+=5;
                    }
                    else if(snake.get(count).d == 2){
                        snake.get(count).y+=5;
                    }
                    else if(snake.get(count).d == 3){
                        snake.get(count).x-=5;
                    }
                }
                else{
                    delay--;
                }
            }
            if(count != 0 && snake.get(count).x == snake.get(0).x && snake.get(count).y == snake.get(0).y){
                dead = true;
            }
            if(sColor == 0){
                if(10+(int)((double)(snake.size()-1-count)*1) > 255){
                    red = 255;
                }else{
                    red = 10+(int)((double)(snake.size()-1-count)*1);
                }
                if(30+(int)((double)(snake.size()-1-count)*2) > 255){
                    green = 255;
                }
                else{
                    green = 30+(int)((double)(snake.size()-1-count)*2);
                }
                if(130+(snake.size()-1-count)*6 > 255){
                    blue = 255;
                }
                else{
                    blue = 130+(snake.size()-1-count)*6;
                }
            }
            else if(sColor == 5){
                red = 0;
                if(90+(int)((double)(snake.size()-1-count)*5) > 255){
                    green = 255;
                }
                else{
                    green = 90+(int)((double)(snake.size()-1-count)*5);
                }
                if(90+(snake.size()-1-count)*5 > 255){
                    blue = 255;
                }
                else{
                    blue = 90+(snake.size()-1-count)*5;
                }
            }
            else if(sColor == 2){
                if(190+(int)((double)(snake.size()-1-count)*10) > 255){
                    red = 255;
                }else{
                    red = 190+(int)((double)(snake.size()-1-count)*10);
                }
                if(90+(int)((double)(snake.size()-1-count)*5) > 255){
                    green = 255;
                }
                else{
                    green = 90+(int)((double)(snake.size()-1-count)*5);
                }
                blue = 0;
            }
            else if(sColor == 3){
                if(0+(int)((double)(snake.size()-1-count)*5) > 255){
                    red = 255;
                }else{
                    red = 0+(int)((double)(snake.size()-1-count)*5);
                }
                if(0+(int)((double)(snake.size()-1-count)*5) > 255){
                    green = 255;
                }
                else{
                    green = 0+(int)((double)(snake.size()-1-count)*5);
                }
                if(0+(snake.size()-1-count)*5 > 255){
                    blue = 255;
                }
                else{
                    blue = 0+(snake.size()-1-count)*5;
                }
            }
            else if(sColor == 4){
                if(20+(int)((double)(snake.size()-1-count)*2) > 255){
                    red = 255;
                }else{
                    red = 20+(int)((double)(snake.size()-1-count)*2);
                }
                if(100+(int)((double)(snake.size()-1-count)*5) > 255){
                    green = 255;
                }
                else{
                    green = 100+(int)((double)(snake.size()-1-count)*5);
                }
                if(20+(snake.size()-1-count)*1 > 255){
                    blue = 255;
                }
                else{
                    blue = 20+(snake.size()-1-count)*1;
                }
            }
            else if(sColor == 1){
                if(100+(int)((double)(snake.size()-1-count)*5) > 255){
                    red = 255;
                }else{
                    red = 100+(int)((double)(snake.size()-1-count)*5);
                }
                if(75+(int)((double)(snake.size()-1-count)*2) > 255){
                    green = 255;
                }
                else{
                    green = 75+(int)((double)(snake.size()-1-count)*2);
                }
                if(100+(snake.size()-1-count)*5 > 255){
                    blue = 255;
                }
                else{
                    blue = 100+(snake.size()-1-count)*5;
                }
            }
            g.setColor(new Color(red,green,blue));
            if((snake.get(count).d == 0 || snake.get(count).d == 2) && count != 0){
                if(count>13){
                    g.fillRect(snake.get(count).x+13,snake.get(count).y,40-13*2,40);
                }
                else{
                    g.fillRect(snake.get(count).x+count,snake.get(count).y,40-count*2,40);
                }
            }
            else if((snake.get(count).d == 1 || snake.get(count).d == 3) && count != 0){
                if(count>13){
                    g.fillRect(snake.get(count).x,snake.get(count).y+13,40,40-13*2);
                }
                else{
                    g.fillRect(snake.get(count).x,snake.get(count).y+count,40,40-count*2);
                }
            }
        }
        if(sColor == 0){
            if(10+(int)((double)(snake.size()-1)*1) > 255){
                red = 255;
            }else{
                red = 10+(int)((double)(snake.size()-1)*1);
            }
            if(30+(int)((double)(snake.size()-1)*2) > 255){
                green = 255;
            }
            else{
                green = 30+(int)((double)(snake.size()-1)*2);
            }
            if(130+(snake.size()-1)*6 > 255){
                blue = 255;
                }
            else{
                blue = 130+(snake.size()-1)*6;
            }
        }
        else if(sColor == 5){
            red = 0;
            if(90+(int)((double)(snake.size()-1)*5) > 255){
                green = 255;
            }
            else{
                green = 90+(int)((double)(snake.size()-1)*5);
            }
            if(90+(snake.size()-1)*5 > 255){
                blue = 255;
                }
            else{
                blue = 90+(snake.size()-1)*5;
            }
        }
        else if(sColor == 2){
            if(190+(int)((double)(snake.size()-1)*10) > 255){
                red = 255;
            }else{
                red = 190+(int)((double)(snake.size()-1)*10);
            }
            if(90+(int)((double)(snake.size()-1)*5) > 255){
                green = 255;
            }
            else{
                green = 90+(int)((double)(snake.size()-1)*5);
            }
            blue = 0;
        }
        else if(sColor == 3){
            if(0+(int)((double)(snake.size()-1)*5) > 255){
                red = 255;
            }else{
                red = 0+(int)((double)(snake.size()-1)*5);
            }
            if(0+(int)((double)(snake.size()-1)*5) > 255){
                green = 255;
            }
            else{
                green = 0+(int)((double)(snake.size()-1)*5);
            }
            if(0+(snake.size()-1)*5 > 255){
                blue = 255;
            }
            else{
                blue = 0+(snake.size()-1)*5;
            }
        }
        else if(sColor == 4){
            if(20+(int)((double)(snake.size()-1)*2) > 255){
                red = 255;
            }else{
                red = 20+(int)((double)(snake.size()-1)*2);
            }
            if(100+(int)((double)(snake.size()-1)*5) > 255){
                green = 255;
            }
            else{
                green = 100+(int)((double)(snake.size()-1)*5);
            }
            if(20+(snake.size()-1)*1 > 255){
                blue = 255;
            }
            else{
                blue = 20+(snake.size()-1)*1;
            }
        }
        else if(sColor == 1){
            if(100+(int)((double)(snake.size()-1)*5) > 255){
                red = 255;
            }else{
                red = 100+(int)((double)(snake.size()-1)*5);
            }
            if(75+(int)((double)(snake.size()-1)*2) > 255){
                green = 255;
            }
            else{
                green = 75+(int)((double)(snake.size()-1)*2);
            }
            if(100+(snake.size()-1)*5 > 255){
                blue = 255;
            }
            else{
                blue = 100+(snake.size()-1)*5;
            }
        }
        g.setColor(new Color(red,green,blue));
        g.fillOval(snake.get(0).x,snake.get(0).y,40,40);
        if(snake.get(0).d == 0){
            g.fillRect(snake.get(0).x,snake.get(0).y+20,40,20);
            // Eyes
            g.fillOval(snake.get(0).x-10,snake.get(0).y+20,20,20);
            g.fillOval(snake.get(0).x+30,snake.get(0).y+20,20,20);
            g.setColor(Color.white);
            g.fillOval(snake.get(0).x-7,snake.get(0).y+24,12,12);
            g.fillOval(snake.get(0).x+34,snake.get(0).y+24,12,12);
            g.setColor(new Color(34,44,130));
            g.fillOval(snake.get(0).x-3,snake.get(0).y+26,6,6);
            g.fillOval(snake.get(0).x+36,snake.get(0).y+26,6,6);
        }
        else if(snake.get(0).d == 1){
            g.fillRect(snake.get(0).x,snake.get(0).y,20,40);
            // Eyes
            g.fillOval(snake.get(0).x,snake.get(0).y-10,20,20);
            g.fillOval(snake.get(0).x,snake.get(0).y+30,20,20);
            g.setColor(Color.white);
            g.fillOval(snake.get(0).x+4,snake.get(0).y-7,12,12);
            g.fillOval(snake.get(0).x+4,snake.get(0).y+34,12,12);
            g.setColor(new Color(34,44,130));
            g.fillOval(snake.get(0).x+6,snake.get(0).y-3,6,6);
            g.fillOval(snake.get(0).x+6,snake.get(0).y+36,6,6);
        }
        else if(snake.get(0).d == 2){
            g.fillRect(snake.get(0).x,snake.get(0).y,40,20);
            // Eyes
            g.fillOval(snake.get(0).x-10,snake.get(0).y,20,20);
            g.fillOval(snake.get(0).x+30,snake.get(0).y,20,20);
            g.setColor(Color.white);
            g.fillOval(snake.get(0).x-7,snake.get(0).y+4,12,12);
            g.fillOval(snake.get(0).x+34,snake.get(0).y+4,12,12);
            g.setColor(new Color(34,44,130));
            g.fillOval(snake.get(0).x-3,snake.get(0).y+6,6,6);
            g.fillOval(snake.get(0).x+36,snake.get(0).y+6,6,6);
        }
        else if(snake.get(0).d == 3){
            g.fillRect(snake.get(0).x+20,snake.get(0).y,20,40);
            // Eyes
            g.fillOval(snake.get(0).x+20,snake.get(0).y-10,20,20);
            g.fillOval(snake.get(0).x+20,snake.get(0).y+30,20,20);
            g.setColor(Color.white);
            g.fillOval(snake.get(0).x+24,snake.get(0).y-7,12,12);
            g.fillOval(snake.get(0).x+24,snake.get(0).y+34,12,12);
            g.setColor(new Color(34,44,130));
            g.fillOval(snake.get(0).x+26,snake.get(0).y-3,6,6);
            g.fillOval(snake.get(0).x+26,snake.get(0).y+36,6,6);
        }
        if(snake.get(0).x == redX && snake.get(0).y == redY){
            snake.add(new body(snake.get(snake.size()-1).x,snake.get(snake.size()-1).y,snake.get(snake.size()-1).d));
            redX = -1;
            delay = 8;
            score++;
            while(redX == -1){
                redX = 50+rand.nextInt(14)*40;
                redY = 50+rand.nextInt(14)*40;
                for(int count = 0;count != snake.size();count++){
                    if(snake.get(count).x == redX && snake.get(count).y == redY){
                        redX = -1;
                    }
                }
            }
        }
        if(snake.get(0).x<50 || snake.get(0).x>610 || snake.get(0).y<50||snake.get(0).y>610){
            dead = true;
        }
        /*for(int count = 0;count != turn.size();count++){
            g.setColor(Color.white);
            g.drawRect(turn.get(count).x,turn.get(count).y,40,40);
        }
        g.drawString(""+snake.get(0).d,10,10);*/
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.setColor(Color.white);
        if(dead){
            g.drawString("You died",140,300);
        }
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.setColor(Color.red);
        g.fillOval(10+6,6+8,28,28);
        g.setColor(new Color(10,100,10));
        g.fillArc(10+20,6+3,10,8,0,180);
        g.setColor(new Color(150,100,70));
        g.fillRect(10+18,6+3,3,6);
        g.setColor(new Color(255,100,100));
        g.fillArc(10+10,6+12,10,8,60,210);
        g.setColor(Color.white);
        g.drawString(score+"",50,40);
        g.drawString("Color:",150,40);
        // color 0
        g.setColor(new Color(10,30,130));
        g.fillOval(275,10,30,30);
        if(sColor == 0){
            g.setColor(Color.white);
            g.drawOval(275,10,30,30);
        }
        // color 1
        g.setColor(new Color(80,30,80));
        g.fillOval(325,10,30,30);
        if(sColor == 1){
            g.setColor(Color.white);
            g.drawOval(325,10,30,30);
        }
        // color 2
        g.setColor(new Color(190,90,0));
        g.fillOval(375,10,30,30);
        if(sColor == 2){
            g.setColor(Color.white);
            g.drawOval(375,10,30,30);
        }
        // color 3
        g.setColor(new Color(100,100,100));
        g.fillOval(425,10,30,30);
        if(sColor == 3){
            g.setColor(Color.white);
            g.drawOval(425,10,30,30);
        }
        // color 4
        g.setColor(new Color(20,100,20));
        g.fillOval(475,10,30,30);
        if(sColor == 4){
            g.setColor(Color.white);
            g.drawOval(475,10,30,30);
        }
        // color 5
        g.setColor(new Color(0,90,90));
        g.fillOval(525,10,30,30);
        if(sColor == 5){
            g.setColor(Color.white);
            g.drawOval(525,10,30,30);
        }
        //
        if(pause){
            g.fillRect(350-12-20,300,20,100);
            g.fillRect(350+12,300,20,100);
        }
        try{
            if(15-(score/5) > 8){
                Thread.sleep(15-(score/5));
            }
            else{
                Thread.sleep(8);
            }
        }catch(Exception e){}
        repaint();
    }
}