import java.awt.*;
public class Obj{
    public int x;
    public int y;
    public int xSize;
    public int ySize;
    public int type;
    public Obj(int x, int y, int xSize, int ySize, int type){
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.type = type;
    }
    public void drawObj(Graphics g){
        if(type == 0){
            g.setColor(Color.black);
        }
        else if(type == 1){
            g.setColor(Color.green);
        }
        else if(type == 3 || type == 2){
            g.setColor(Color.white);
        }
        g.fillRect(x,y,xSize,ySize);
    }
}