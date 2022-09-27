import java.awt.*;
public class Goal{
    int x;
    int y;
    int d;
    public Goal(int x,int y,int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
    public boolean inside(Bot bot){
        if((int)Math.round(Math.sqrt((double)Math.pow(this.x-bot.x,2)+Math.pow(this.y-bot.y,2)))<=d/2){
            return true;
        }
        else{
            return false;
        }
    }
    public int fitness(Bot bot){
        if(1000/Math.round(Math.sqrt(Math.pow(x-bot.x,2)+Math.pow(y-bot.y,2)))<=2){
            return 2;
        }
        else{
            return (int)(1000/Math.round(Math.sqrt(Math.pow(x-bot.x,2)+Math.pow(y-bot.y,2))));
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x-d/2,y-d/2,d,d);
    }
}