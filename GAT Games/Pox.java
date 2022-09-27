import java.awt.*;
public class Pox{
    public int x;
    public int y;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public Pox(int x, int y, boolean up, boolean down, boolean left, boolean right){
        this.x = x;
        this.y = y;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    public void drawPox(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x-15,y-15,30,30);
    }
}