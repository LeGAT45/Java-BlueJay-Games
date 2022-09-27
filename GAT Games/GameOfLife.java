import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class GameOfLife extends JApplet{
    @Override
    public void init(){
        add(new GameOfLife_Engine());
    }
}
class GameOfLife_Engine extends JPanel implements MouseListener, Runnable {
    int speed1;
    int speed2;
    int speed3;
    int speed4;
    int speed5;
    int speedTest;
    boolean mRelease;
    int x;
    int y;
    int mCountX;
    int mCountY;
    int lord;
    int tempCount;
    boolean mouseScanner;
    Thread t;
    boolean mouseListenerTest;
    boolean mouseEntered, play;
    boolean start;
    boolean one;
    boolean two;
    boolean clear;
    boolean rando;
    boolean mClick;
    int mouseListenerX;
    int mouseListenerY;
    Random rand;
    int[][]colorArray;
    int[][]newColorArray;
    public GameOfLife_Engine(){
        this.setFocusable(true);
        this.requestFocusInWindow();
        t = new Thread(this);
        t.start();
        addMouseListener(this);
        mouseListenerTest = false;
        mouseEntered = true;
        play = true;
        mRelease = false;
        start = false;
        one = false;
        two = false;
        mClick = false;
        speed1 = 1000;
        speed2 = 750;
        speed3 = 500;
        speed4 = 250;
        speed5 = 100;
        speedTest = 3;
        mouseScanner = false;
        x = 0;
        y = 0;
        clear = false;
        rando = false;
        mouseListenerTest = false;
        mouseListenerX = 0;
        mouseListenerY = 0;
        rand = new Random();
        tempCount = 1;
        newColorArray = new int[10][10];
        colorArray = new int[10][10];
        for (int count = 0;count != 10;count++){
            for(int count2=0;count2!=colorArray[count].length;count2++){
                colorArray[count][count2] = rand.nextInt(2);
                newColorArray[count][count2] = rand.nextInt(2);
            }
        }
    }
    public void paint(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Speed:",570,15);
        g.setColor(Color.black);
        g.drawOval(525,30,20,20);
        g.drawOval(555,30,20,20);
        g.drawOval(585,30,20,20);
        g.drawOval(615,30,20,20);
        g.drawOval(645,30,20,20);
        g.setColor(Color.green);
        if (speedTest == 1){
            g.fillOval(525,30,20,20);
        }
        else if(speedTest == 2){
            g.fillOval(555,30,20,20);
        }
        else if(speedTest == 3){
            g.fillOval(585,30,20,20);
        }
        else if(speedTest == 4){
            g.fillOval(615,30,20,20);
        }
        else if(speedTest == 5){
            g.fillOval(645,30,20,20);
        }
        // start
        g.setColor(Color.gray);
        g.fillRect(550,75,100,50);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        if (one && !two){
            g.drawString("Stop",570,104);  
        }
        else{
            g.drawString("Start",570,104);  
        }
        // clear
        g.setColor(Color.blue);
        g.fillRect(550,175,100,50);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString("Clear",570,204);
        // random
        g.setColor(Color.red);
        g.fillRect(550,275,100,50);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString("Random",563,304);
        // 1 run
        g.setColor(Color.yellow);
        g.fillRect(550,375,100,50);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.setColor(Color.black);
        g.drawString("One instance",555,404);
        if(clear){
            for(int count = 0;count != 10;count++){
                for(int count2 = 0;count2 != 10;count2++){
                    colorArray[count][count2] = 0;
                    newColorArray[count][count2] = 0;
                }
            }
            clear = false;
        }
        if(rando){
            for(int count = 0;count != 10;count++){
                for(int count2 = 0;count2 != 10;count2++){
                    colorArray[count][count2] = rand.nextInt(2);
                    newColorArray[count][count2] = rand.nextInt(2);
                }
            }
            rando = false;
        }
        if(mouseScanner){
            mCountX = mouseListenerX / 50;
            mCountY = mouseListenerY / 50;
            mCountY *= 50;
            mCountX *= 50;
            x = 0;
            y = 0;
            for (int count = 0;count != 10;count++){
                for (int count2 = 0;count2 != 10;count2++){
                    if(x>=500){
                        x = 0;
                        y+=50;
                    }
                    if (y >= 500){
                        y = 0;
                    }
                    if(mCountX == x && mCountY == y){
                        if(colorArray[count][count2] == 1){
                            colorArray[count][count2] = 0;
                            newColorArray[count][count2] = 0;
                        }
                        else{
                            colorArray[count][count2] = 1;
                            newColorArray[count][count2] = 1;
                        }
                    }
                    x += 50;
                }
            }
            mouseScanner = false;
            x = 0;
            y = 0;
            /*
            pmCountX = mCountX;
            pmCountX = mCountX;
            pmCountX = mCountX;
            pmCountX = mCountX;
            */
        }
        for(int count = 0;count != 10;count++){
            for (int count2 = 0;count2 != 10;count2++){
                if(x >= 500){
                    x = 0;
                    y += 50;
                }
                if(y >= 500){
                    y = 0;
                }
                if(colorArray[count][count2] == 0){
                    g.setColor(Color.black);
                }
                else{
                    g.setColor(Color.green);
                }
                g.fillRect(x,y,50,50);
                x += 50;
            }
        }
        x = 0;
        y = 0;
        if (one){
        for(int count = 0;count != 10;count++){
            for(int count2 = 0;count2 != 10;count2++){
            // top left corner
            if(count2 == 0 && count == 0){
                lord = colorArray[count][count2+1] + colorArray[count+1][count2] + colorArray[count+1][count2+1];
            }
            // bottom right corner
            else if(count2 == 9 && count == 9){
                lord = colorArray[count][count2-1] + colorArray[count-1][count2-1] + colorArray[count-1][count2];
            }
            // top right corner
            else if(count == 0 && count2 == 9){
                lord = colorArray[count][count2-1] + colorArray[count+1][count2-1] + colorArray[count+1][count2];
            }
            // bottom left corner
            else if(count == 9 && count2 == 0){
                lord = colorArray[count-1][count2] + colorArray[count-1][count2+1] + colorArray[count][count2+1]; 
            }
            // top row
            else if (count == 0){
                lord = colorArray[count][count2-1] + colorArray[count+1][count2-1] + colorArray[count+1][count2] + colorArray[count+1][count2+1] + colorArray[count][count2+1];
            }
            // bottom
            else if (count == 9){
                lord = colorArray[count][count2-1] + colorArray[count-1][count2-1] + colorArray[count-1][count2] + colorArray[count-1][count2+1] + colorArray[count][count2+1]; 
            }
            // right side
            else if (count2 == 9){
                lord = colorArray[count-1][count2-1] + colorArray[count][count2-1] + colorArray[count+1][count2-1] + colorArray[count+1][count2] + colorArray[count-1][count2]; 
            }
            // left side
            else if (count2 == 0){
                lord = colorArray[count-1][count2] + colorArray[count-1][count2+1] + colorArray[count][count2+1] + colorArray[count+1][count2+1] + colorArray[count+1][count2];
            }
            // middle
            else{
                lord = colorArray[count-1][count2-1] + colorArray[count-1][count2] + colorArray[count-1][count2+1] + colorArray[count][count2+1] + colorArray[count+1][count2+1] + colorArray[count+1][count2] + colorArray[count+1][count2-1] + colorArray[count][count2-1]; 
            }
            if (newColorArray[count][count2] == 1){
                if(lord == 3 || lord == 2){
                    newColorArray[count][count2] = 1;
                }
                else{
                    newColorArray[count][count2] = 0;
                }
            }
            else{
                if(lord == 3){
                    newColorArray[count][count2] = 1;
                }
                else{
                    newColorArray[count][count2] = 0;
                }
            }
            }
        }
        for(int count = 0;count != 10;count++){
            for(int count2 = 0;count2 != 10;count2++){
                colorArray[count][count2] = newColorArray[count][count2];
            }
        }
        if (two){
            one = false;
            two = false;
        }
        }
    }
    public void mouseEntered(MouseEvent me)
    {
        mouseEntered = true;
    }
    public void mouseExited(MouseEvent me)
    {
        mouseEntered = false;
    }
    public void mousePressed(MouseEvent me)
    {
        mouseListenerX = me.getX();
        mouseListenerY = me.getY();
        //mouseListenerTest = true;
        // speed
        if(mouseListenerY>=30 && mouseListenerY<=50 &&  mouseListenerX>=525 && mouseListenerX<545){
            speedTest = 1;
        }
        if(mouseListenerX>=30 && mouseListenerY<=50 &&  mouseListenerX>=555 && mouseListenerX<575){
            speedTest = 2;
        }
        if(mouseListenerY>=30 && mouseListenerY<=50 &&  mouseListenerX>=585 && mouseListenerX<605){
            speedTest = 3;
        }
        if(mouseListenerY>=30 && mouseListenerY<=50 &&  mouseListenerX>=615 && mouseListenerX<635){
            speedTest = 4;
        }
        if(mouseListenerY>=30 && mouseListenerY<=50 &&  mouseListenerX>=645 && mouseListenerX<665){
            speedTest = 5;
        }
        /*
        g.drawOval(525,30,20,20);
        g.drawOval(555,30,20,20);
        g.drawOval(585,30,20,20);
        g.drawOval(615,30,20,20);
        g.drawOval(645,30,20,20);
         */
        //
        if(mouseListenerX>0 && mouseListenerX<=500 && mouseListenerY>0 && mouseListenerY<= 500){
            mouseScanner = true;
        }
        if(mouseListenerX>550 && mouseListenerX<650 && mouseListenerY>175 && mouseListenerY<225){
            start = false;
            clear = true;
        }
        if(mouseListenerX>550 && mouseListenerX<650 && mouseListenerY>275 && mouseListenerY<325){
            start = false;
            rando = true;
        }
        if(mouseListenerX>550 && mouseListenerX<650 && mouseListenerY>75 && mouseListenerY<125){
            start = !start;
            one = !one;
        }
        if(mouseListenerX>550 && mouseListenerX<650 && mouseListenerY>375 && mouseListenerY<425 && !start){
            one = true;
            two = true;
        }
        repaint();
    }
    public void mouseReleased(MouseEvent me)
    {
        mRelease = true;
    }
    public void mouseClicked(MouseEvent me)
    {
        mClick = true;
    }
    public void run()
    {
        while(play)
        {
            try
            {
                if (speedTest == 5){
                    Thread.sleep(speed5);
                }
                else if(speedTest == 4){
                    Thread.sleep(speed4);
                }
                else if(speedTest == 3){
                    Thread.sleep(speed3);
                }
                else if(speedTest == 2){
                    Thread.sleep(speed2);
                }
                else if(speedTest == 1){
                    Thread.sleep(speed1);
                }
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            repaint();
        }
    }
    public void start()
    {
    }
    public void stop()
    {
    }
}