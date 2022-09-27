import java.awt.*;
public class B{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int type;
    public B (int x1,int y1,int x2,int y2,int type){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.type = type;
    }
    public void drawBlock(Graphics g){
        // drawing block
        if(type == 0 || type == 1){
            g.setColor(new Color(200,150,50));
        }
        else if(type == 2 || type == 3){
            g.setColor(Color.red);
        }
        g.fillRect(x1+5,y1+5,x2-10,y2-10);
        // drawing border of block
        //g.setColor(new Color(100,70,30));
        //g.drawRect(x1,y1,x2,y2);
    }
}