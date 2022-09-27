import java.awt.*;
import java.util.*;
public class Dot{
    public int x;
    public int y;
    public int type;
    public int speed;
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    public int u;
    public int d;
    public int startDirection;
    public boolean got;
    public ArrayList<turnDot> turns = new ArrayList<turnDot>();
    public Dot(int x, int y, int type, int speed, int x1, int y1, int x2, int y2, int u, int d, boolean got){
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed = speed;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.startDirection = startDirection;
        this.u = u;
        this.d = d;
        this.got = got;
    }
    public void drawDot(Graphics g){
        if(type != 2){
            g.setColor(Color.blue);
        }
        else{
            g.setColor(Color.yellow);
        }
        g.fillOval(x-10,y-10,20,20);
    }
}