import java.awt.*;
public class Flag{
    public int x;
    public int y;
    public boolean press;
    public Flag(int x, int y, boolean press){
        this.x = x;
        this.y = y;
        this.press = press;
    }
    public void drawFlag(Graphics g,Color c){
        g.setColor(c);
        g.fillRect(x,y,200,100);
    }
}