import java.awt.*;
public class Object{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public Object(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.y2 = y2;
        this.x2 = x2;
    }
    public void drawObject(Graphics g){
        g.setColor(new Color(100,85,0));
        g.fillRect(x1,y1,x2-x1,y2-y1);
    }
}