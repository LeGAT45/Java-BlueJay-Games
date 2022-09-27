import java.awt.*;
public class Car{
    public int x;
    public int y;
    public int a;
    public int speed;
    public boolean forward;
    public boolean left;
    public boolean right;
    public boolean uLeft;
    public boolean uRight;
    public boolean reverse;
    public boolean tempForward;
    public boolean tempReverse;
    public Car(int x,int y,int a,int speed, boolean forward, boolean left, boolean right,boolean reverse,boolean uLeft,boolean uRight,boolean tempForward,boolean tempReverse){
        this.x = x;
        this.y = y;
        this.a = a;
        this.speed = speed;
        this.forward = forward;
        this.left = left;
        this.right = right;
        this.uLeft = uLeft;
        this.uRight = uRight;
        this.tempForward = tempForward;
        this.tempReverse = tempReverse;
    }
    public void drawCar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Polygon c = new Polygon();
        //g.setColor(Color.red);
        //g.fillOval(x,y,2,2);
        //Left
        //g.setColor(Color.blue);
        //g.fillOval(x+(int)Math.round(10*Math.cos(Math.toRadians(a+90))),y-(int)Math.round(10*Math.sin(Math.toRadians(a+90))),2,2);
        c.addPoint(x+(int)Math.round(10*Math.cos(Math.toRadians(a+90))),y-(int)Math.round(10*Math.sin(Math.toRadians(a+90))));
        //right
        //g.setColor(Color.green);
        //g.fillOval(x+(int)Math.round(10*Math.cos(Math.toRadians(a-90))),y-(int)Math.round(10*Math.sin(Math.toRadians(a-90))),2,2);
        c.addPoint(x+(int)Math.round(10*Math.cos(Math.toRadians(a-90))),y-(int)Math.round(10*Math.sin(Math.toRadians(a-90))));
        //Nose
        //g.setColor(Color.yellow);
        //g.fillOval(x+(int)Math.round(45*Math.cos(Math.toRadians(a))),y-(int)Math.round(45*Math.sin(Math.toRadians(a))),2,2);
        c.addPoint(x+(int)Math.round(45*Math.cos(Math.toRadians(a))),y-(int)Math.round(45*Math.sin(Math.toRadians(a))));
        g2.setColor(Color.white);
        g2.fill(c);
    }
}