import java.awt.*;
import java.applet.*;
public class Ship{
    public int x;
    public Ship(int x){
        this.x = x;
    }
    public void drawShip(Graphics g,int inv){
        g.setColor(Color.red);
        if(inv == 300){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 25){
            g.drawRect(x-25,700,50,50);
        }
        else if(inv < 50){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 75){
            g.drawRect(x-25,700,50,50);
        }
        else if(inv < 100){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 125){
            g.drawRect(x-25,700,50,50);
        }
        else if(inv < 150){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 175){
            g.drawRect(x-25,700,50,50);
        }
        else if(inv < 200){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 225){
            g.drawRect(x-25,700,50,50);
        }
        else if(inv < 250){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 265){
            g.drawRect(x-25,700,50,50);
        }
        else if(inv < 280){
            g.fillRect(x-25,700,50,50);
        }
        else if(inv < 290){
            g.drawRect(x-25,700,50,50);
        }
    }
}