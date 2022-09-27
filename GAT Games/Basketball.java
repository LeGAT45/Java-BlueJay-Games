import java.awt.*;
public class Basketball{
    public double a;
    public int x;
    public int y;
    public int s;
    public int d;
    public int u;
    public Basketball (int a, int x, int y, int d, int s, int u){
        this.a = a;
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
        this.u = u;
    }
    public void drawBall(Graphics g, int big){
        g.setColor(Color.orange);
        g.fillOval(x-(int)(big/2),y-(int)(big/2),big,big);
    }
}