import java.awt.*;
public class hole{
    public int x;
    public int y;
    public hole(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void drawHole(Graphics g){
        g.setColor(Color.black);
        g.fillOval(x-15,y-15,30,30);
    }
}