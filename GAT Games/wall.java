import java.awt.*;
public class wall{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int type;
    public wall(int x1,int y1,int x2,int y2,int type){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.type = type;
    }
    public void drawWall(Graphics g){
        if(type == 0 || type == 2){
            g.setColor(Color.white);
        }
        else if(type == 1){
            g.setColor(Color.yellow);
        }
        if(type == 1 || type == 0){
            g.fillRect(x1,y1,x2,y2);
            g.setColor(Color.black);
            g.drawRect(x1,y1,x2,y2);
        }
        else if(type == 2){
            g.fillOval(x1,y1,x2,y2);
            g.setColor(Color.black);
            g.drawOval(x1,y1,x2,y2);
        }
    }
}