import java.awt.*;
public class Sun{
    public int a;
    public int x;
    public int y;
    public int size;
    public int speed;
    public int d;
    public Sun (int a, int x, int y, int d, int speed, int size){
        this.a = a;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.d = d;
    }
    public void drawSun(Graphics g, int big){
        g.setColor(Color.yellow);
        g.fillOval(x-(int)(big/2),y-(int)(big/2),big,big);
    }
}