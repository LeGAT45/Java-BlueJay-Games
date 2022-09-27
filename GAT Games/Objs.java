import java.awt.*;
public class Objs{
    public int x;
    public int y;
    public int t;
    public int xSize;
    public Objs(int x,int y,int xSize, int t){
        this.x = x;
        this.y = y;
        this.t = t;
        this.xSize = xSize;
    }
    public void drawObj(Graphics g, int down){
        g.fillRect(x,y+down,xSize,325-y);
    }
}