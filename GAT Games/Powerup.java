import java.awt.*;
public class Powerup{
    public int x;
    public int y;
    public int state;
    public Powerup(int x, int y, int state){
        this.x = x;
        this.y = y;
        this.state = state;
    }
    public void drawPowerup(Graphics g){
        if(state != 0){
            g.setFont(new Font("Arial",Font.BOLD,60));
            if(state == 1){
                g.setColor(new Color(100,0,0));
            }
            else if(state == 2){
                g.setColor(new Color(120,0,255));
            }
            else if(state == 3){
                g.setColor(Color.yellow);
            }
            else if(state == 4){
                g.setColor(Color.green);
            }
            g.drawString("P",x-20,y+20);
        }
    }
}