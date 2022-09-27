import java.awt.*;
import java.applet.*;
public class Bullet{
    public int x;
    public int y;
    public int pY;
    public double a;
    public int d;
    public int u;
    public int bounce;
    public int timer;
    public int pX;
    public Bullet(int x, int y, double a, int d, int u, int bounce, int pY, int time, int pX){
        this.x = x;
        this.y = y;
        this.pY = pY;
        this.a = a;
        this.d = d;
        this.u = u;
        this.bounce = bounce;
        this.timer = timer;
        this.pX = pX;
    }
    public void drawBullet(Graphics g){
        g.fillOval(x-5,y-5,10,10);
    }
}