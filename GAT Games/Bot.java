import java.awt.*;
import java.util.*;
public class Bot{
    int x;
    int y;
    public Brain brain;
    public boolean stop;
    int a;
    public Bot(int sx,int sy){
        x = sx;
        y = sy;
        stop = false;
        brain = new Brain(400);
        a = brain.directions.get(0);
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillOval(x-2,y-2,4,4);
    }
    public void move(){
        if(brain.step < brain.size){
            //a = (a+brain.directions.get(brain.step))/2;
            a = brain.directions.get(brain.step);
            if(a<180){
                y -= Math.round((double)5*Math.sin(Math.toRadians((double)a-a/90*90)));
            }
            else{
                y += Math.round((double)5*Math.sin(Math.toRadians((double)a-a/90*90)));
            }
            if(a<90 || a>270){
                x += Math.round((double)5*Math.cos(Math.toRadians((double)a-a/90*90)));
            }
            else{
                x -= Math.round((double)5*Math.cos(Math.toRadians((double)a-a/90*90)));
            }
            brain.step++;
        }
        else{
            stop = true;
        }
    }
    public boolean outOfBounds(int width,int height,ArrayList<Obstacle>obstacle){
        if(x>0 && x<width && y>0 && y<height){
            for(int count = 0;count != obstacle.size();count++){
                if(x>obstacle.get(count).x1&&x<obstacle.get(count).x1+obstacle.get(count).x2&&y>obstacle.get(count).y1&&y<obstacle.get(count).y1+obstacle.get(count).y2){
                    return true;
                }
            }
            return false;
        }
        else{
            return true;
        }
    }
    public void reset(int sx,int sy){
        x = sx;
        y = sy;
        stop = false;
        brain.step = 0;
    }
}