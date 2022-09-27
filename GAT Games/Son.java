import java.awt.*;
public class Son{
    public int a;
    public int x;
    public int y;
    public int s;
    public int d;
    public Son (int a, int x, int y, int d, int s){
        this.a = a;
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
    }
    public void drawSun(Graphics g, int big){
        g.setColor(Color.yellow);
        g.fillOval(x-(int)(big/2),y-(int)(big/2),big,big);
    }
}