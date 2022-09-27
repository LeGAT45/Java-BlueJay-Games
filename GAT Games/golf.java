import java.awt.*;
public class golf{
    public int x;
    public int y;
    public int a;
    public int s;
    public int d;
    public int u;
    public golf(int x,int y,int a,int s,int d,int u){
        this.x = x;
        this.y = y;
        this.a = a;
        this.s = s;
        this.d = d;
        this.u = u;
    }
    public void drawBall(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x-5,y-5,10,10);
    }
}