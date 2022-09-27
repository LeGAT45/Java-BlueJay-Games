import java.awt.*;
import java.util.*;
public class dice{
    public int n;
    public boolean lock;
    public dice(int n, boolean lock){
        this.n = n;
        this.lock = lock;
    }
    public void drawDice(Graphics g,int x,int y){
        if(lock){
            g.setColor(Color.yellow);
            g.fillRect(x-10,y-10,120,120);
        }
        g.setColor(Color.white);
        g.fillRect(x,y,100,100);
        g.setColor(Color.black);
        if(n == 1){
            g.fillOval(x+40,y+40,20,20);
        }
        else if(n == 2){
            g.fillOval(x+10,y+10,20,20);
            g.fillOval(x+70,y+70,20,20);
        }
        else if(n == 3){
            g.fillOval(x+10,y+10,20,20);
            g.fillOval(x+70,y+70,20,20);
            g.fillOval(x+40,y+40,20,20);
        }
        else if(n == 4){
            g.fillOval(x+10,y+10,20,20);
            g.fillOval(x+70,y+10,20,20);
            g.fillOval(x+70,y+70,20,20);
            g.fillOval(x+10,y+70,20,20);
        }
        else if(n == 5){
            g.fillOval(x+10,y+10,20,20);
            g.fillOval(x+70,y+10,20,20);
            g.fillOval(x+70,y+70,20,20);
            g.fillOval(x+10,y+70,20,20);
            g.fillOval(x+40,y+40,20,20);
        }
        else if(n == 6){
            g.fillOval(x+15,y+40,20,20);
            g.fillOval(x+65,y+40,20,20);
            g.fillOval(x+15,y+70,20,20);
            g.fillOval(x+66,y+70,20,20);
            g.fillOval(x+15,y+10,20,20);
            g.fillOval(x+65,y+10,20,20);
        }
    }
    public void roll(){
        if(!lock){
            Random rand = new Random();
            n = rand.nextInt(6)+1;
        }
    }
}