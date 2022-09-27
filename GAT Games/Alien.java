import java.awt.*;
import java.applet.*;
import java.util.*;
public class Alien{
    public int x;
    public int y;
    public int angle;
    public int size;
    public int d;
    public boolean good;
    public Alien(int x,int y,int angle,int size,int d,boolean good){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.size = size;
        this.d = d;
        this.good = good;
    }
    public void drawAlien(Graphics g){
        if(size == 2 && good){
            g.setColor(Color.green);
            g.fillOval(x-15,y-15,30,30);
        }
        else if(size == 1){
            g.setColor(Color.white);
            g.drawOval(x-25,y-25,50,50);
        }
        else{
            g.setColor(Color.white);
            g.drawOval(x-15,y-15,30,30);
        }
    }
}