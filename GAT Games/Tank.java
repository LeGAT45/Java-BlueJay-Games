import java.awt.*;
import java.util.*;
public class Tank{
    public int x;
    public int y;
    public double a;
    public boolean up;
    public int d;
    public int u;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean dead;
    public boolean n;
    public boolean m;
    public int state;
    public int time;
    public boolean shoot;
    public int delay;
    public int speed;
    public ArrayList<Bullet> shots = new ArrayList<Bullet>();
    public int respawn;
    public int stock;
    public int score;
    public Tank(int x, int y, double a, int d, int u, boolean up, boolean down, boolean left, boolean right, boolean dead, boolean n, boolean m, int state, int time, boolean shoot,int delay, int speed, int respawn, int stock,int score){
        this.x = x;
        this.y = y;
        this.a = a;
        this.d = d;
        this.u = u;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.dead = dead;
        this.n = n;
        this.m = m;
        this.state = state;
        this.time = time;
        this.shoot = shoot;
        this.delay = delay;
        this.speed = speed;
        this.respawn = respawn;
        this.stock = stock;
        this.score = score;
    }
    public void drawTank(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        Polygon t = new Polygon();
        if(dead){
            g2.setColor(Color.gray);
            g.setColor(Color.gray);
        }
        if((up && left) || (down && right)){
            t.addPoint(x-35,y);
            t.addPoint(x,y-35);
            t.addPoint(x+35,y);
            t.addPoint(x,y+35);
            g2.fill(t);
            g.setColor(new Color(50,120,50));
            g.fillOval(x-15,y-15,30,30);
            if(!dead){
                g.setColor(Color.black);
            }
            g.drawLine(x-35,y,x,y+35);
            g.drawLine(x,y-35,x+35,y);
        }
        else if((down && left) || (up && right)){
            t.addPoint(x-35,y);
            t.addPoint(x,y-35);
            t.addPoint(x+35,y);
            t.addPoint(x,y+35);
            g2.fill(t);
            g.setColor(new Color(50,120,50));
            g.fillOval(x-15,y-15,30,30);
            if(!dead){
                g.setColor(Color.black);
            }
            g.drawLine(x-35,y,x,y-35);
            g.drawLine(x,y+35,x+35,y);
        }
        else if(left || right){
            g.fillRect(x-25,y-25,50,50);
            if(!dead){
                g.setColor(new Color(50,120,50));
            }
            g.fillOval(x-15,y-15,30,30);
            if(!dead){
                g.setColor(Color.black);
            }
            g.drawLine(x-25,y-25,x+25,y-25);
            g.drawLine(x-25,y+25,x+25,y+25);
        }
        else if(up || down){
            g.fillRect(x-25,y-25,50,50);
            if(!dead){
                g.setColor(new Color(50,120,50));
            }
            g.fillOval(x-15,y-15,30,30);
            if(!dead){
                g.setColor(Color.black);
            }
            g.drawLine(x-25,y-25,x-25,y+25);
            g.drawLine(x+25,y-25,x+25,y+25);
        }
        else{
            g.fillRect(x-25,y-25,50,50);
            if(!dead){
                g.setColor(new Color(50,120,50));
            }
            g.fillOval(x-15,y-15,30,30);
            if(!dead){
                g.setColor(Color.black);
            }
            g.drawLine(x-25,y-25,x-25,y+25);
            g.drawLine(x+25,y-25,x+25,y+25);
        }
        if(!dead){
            g.setColor(new Color(50,120,50));
        }
        g2.drawLine(x+(int)Math.round(30*Math.cos(Math.toRadians(a))) * d,y-(int)Math.round(30*Math.sin(Math.toRadians(a))) * u,x,y);
    }
}