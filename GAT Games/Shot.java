import java.awt.*;
import java.applet.*;
public class Shot{
    public int x;
    public int y;
    public boolean exist;
    public Shot (int x, int y,boolean exist){
        this.x = x;
        this.y = y;
        this.exist = exist;
    }
    public void drawShot(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x-2,y+10,7,20);
    }
}