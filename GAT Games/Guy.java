import java.awt.*;
public class Guy{
    public int x;
    public int y;
    public int s;
    public int f;
    public Guy (int x, int s){
        this.x = x;
        this.y = y;
        this.s = s;
        f = 0;
    }
    public void drawGuy (Graphics g, int f, int d, boolean n){
        g.setColor(Color.white);
        // standing still
        if(f == 0){
            //head
            g.drawOval(x-15,670,30,30);
            //body
            g.drawLine(x,700,x,750);
            // left leg
            g.drawLine(x,750,x-10,800);
            // right leg
            g.drawLine(x,750,x+10,800);
            
            //left arm
            g.drawLine(x,700,x-10,740);
            // right arm
            g.drawLine(x,700,x+10,740);
            
        }
        // facing left
        else if(f == 1 && d == 0){
            // left leg
            g.drawLine(x,750,x-12,765);
            // left knee
            g.drawLine(x-12,765,x-13,785);
            // right leg
            g.drawLine(x,750,x+10,800);
            // right knee
            if(!n){
                //head
                g.drawOval(x-20,670,30,30);
                //body
                g.drawLine(x-5,700,x,750);
                //left arm
                g.drawLine(x-5,700,x-15,725);
                // left elbow
                g.drawLine(x-15,725,x-25,720);
                // right arm
                g.drawLine(x-5,700,x+5,720);
                // right elbow
                g.drawLine(x+5,720,x+3,735);
            }
            else{
                //head
                g.drawOval(x-55,705,30,30);
                //body
                g.drawLine(x-30,730,x,750);
                //left arm
                g.drawLine(x-30,730,x+5,710);
                // right arm
                g.drawLine(x-30,730,x+5,720);
            }
        }
        else if(f == 2 && d == 0){
            // left leg
            g.drawLine(x,750,x-12,765);
            // left knee
            g.drawLine(x-12,765,x-13,785);
            // right leg
            g.drawLine(x,750,x+2,765);
            // right knee
            g.drawLine(x+2,765,x+15,780);
            if(!n){
                //head
                g.drawOval(x-20,670,30,30);
                //body
                g.drawLine(x-5,700,x,750);
                //left arm
                g.drawLine(x-5,700,x-20,720);
                // left elbow
                g.drawLine(x-20,720,x-30,705);
                // right arm
                g.drawLine(x-5,700,x+15,720);
                // right elbow
                g.drawLine(x+15,720,x+5,735);
            }
            else{
                //head
                g.drawOval(x-55,705,30,30);
                //body
                g.drawLine(x-30,730,x,750);
                //left arm
                g.drawLine(x-30,730,x+5,710);
                // right arm
                g.drawLine(x-30,730,x+5,720);
            }
        }
        else if(f == 3 && d == 0){
            // left leg
            g.drawLine(x,750,x-10,800);
            // left knee
            //g.drawLine(x-12,765,x-13,785);
            // right leg
            g.drawLine(x,750,x+2,765);
            // right knee
            g.drawLine(x+2,765,x+15,780);
            if(!n){
                //head
                g.drawOval(x-20,670,30,30);
                //body
                g.drawLine(x-5,700,x,750);
                //left arm
                g.drawLine(x-5,700,x-15,725);
                // left elbow
                g.drawLine(x-15,725,x-25,720);
                // right arm
                g.drawLine(x-5,700,x+5,720);
                // right elbow
                g.drawLine(x+5,720,x+3,735);
            }
            else{
                //head
                g.drawOval(x-55,705,30,30);
                //body
                g.drawLine(x-30,730,x,750);
                //left arm
                g.drawLine(x-30,730,x+5,710);
                // right arm
                g.drawLine(x-30,730,x+5,720);
            }
        }
        else if(f == 4 && d == 0){
            // left leg
            g.drawLine(x,750,x-5,800);
            // left knee
            //g.drawLine(x-12,765,x-13,785);
            // right leg
            g.drawLine(x,750,x-8,770);
            // right knee
            g.drawLine(x-8,770,x+10,785);
            if(!n){
                //head
                g.drawOval(x-20,670,30,30);
                //body
                g.drawLine(x-5,700,x,750);
                //left arm
                g.drawLine(x-5,700,x-8,725);
                // left elbow
                g.drawLine(x-8,725,x-20,730);
                // right arm
                g.drawLine(x-5,700,x+5,725);
                // right elbow
                g.drawLine(x+5,725,x-7,730);
            }
            else{
                //head
                g.drawOval(x-55,705,30,30);
                //body
                g.drawLine(x-30,730,x,750);
                //left arm
                g.drawLine(x-30,730,x+5,710);
                // right arm
                g.drawLine(x-30,730,x+5,720);
            }
        }
        // facing right
        else if(f == 1 && d == 1){
            // left leg
            g.drawLine(x,750,x+12,765);
            // left knee
            g.drawLine(x+12,765,x+13,785);
            // right leg
            g.drawLine(x,750,x-10,800);
            // right knee
            if(!n){
                //head
                g.drawOval(x-10,670,30,30);
                //body
                g.drawLine(x+5,700,x,750);
                //left arm
                g.drawLine(x+5,700,x+15,725);
                // left elbow
                g.drawLine(x+15,725,x+25,720);
                // right arm
                g.drawLine(x+5,700,x-5,720);
                // right elbow
                g.drawLine(x-5,720,x-3,735);
            }
            else{
                //head
                g.drawOval(x+28,705,30,30);
                //body
                g.drawLine(x+30,730,x,750);
                //left arm
                g.drawLine(x+30,730,x-5,710);
                // right arm
                g.drawLine(x+30,730,x-5,720);
            }
        }
        else if(f == 2 && d == 1){
            // left leg
            g.drawLine(x,750,x+12,765);
            // left knee
            g.drawLine(x+12,765,x+13,785);
            // right leg
            g.drawLine(x,750,x-2,765);
            // right knee
            g.drawLine(x-2,765,x-15,780);
            if(!n){
                //head
                g.drawOval(x-10,670,30,30);
                //body
                g.drawLine(x+5,700,x,750);
                //left arm
                g.drawLine(x+5,700,x+20,720);
                // left elbow
                g.drawLine(x+20,720,x+30,705);
                // right arm
                g.drawLine(x+5,700,x-15,720);
                // right elbow
                g.drawLine(x-15,720,x-5,735);
            }
            else{
                //head
                g.drawOval(x+28,705,30,30);
                //body
                g.drawLine(x+30,730,x,750);
                //left arm
                g.drawLine(x+30,730,x-5,710);
                // right arm
                g.drawLine(x+30,730,x-5,720);
            }
        }
        else if(f == 3 && d == 1){
            // left leg
            g.drawLine(x,750,x+10,800);
            // left knee
            //g.drawLine(x-12,765,x-13,785);
            // right leg
            g.drawLine(x,750,x-2,765);
            // right knee
            g.drawLine(x-2,765,x-15,780);
            if(!n){
                //head
                g.drawOval(x-10,670,30,30);
                //body
                g.drawLine(x+5,700,x,750);
                //left arm
                g.drawLine(x+5,700,x+15,725);
                // left elbow
                g.drawLine(x+15,725,x+25,720);
                // right arm
                g.drawLine(x+5,700,x-5,720);
                // right elbow
                g.drawLine(x-5,720,x-3,735);
            }
            else{
                //head
                g.drawOval(x+28,705,30,30);
                //body
                g.drawLine(x+30,730,x,750);
                //left arm
                g.drawLine(x+30,730,x-5,710);
                // right arm
                g.drawLine(x+30,730,x-5,720);
            }
        }
        else if(f == 4 && d == 1){
            // left leg
            g.drawLine(x,750,x+5,800);
            // left knee
            //g.drawLine(x-12,765,x-13,785);
            // right leg
            g.drawLine(x,750,x+8,770);
            // right knee
            g.drawLine(x+8,770,x-10,785);
            if(!n){
                //head
                g.drawOval(x-10,670,30,30);
                //body
                g.drawLine(x+5,700,x,750);
                //left arm
                g.drawLine(x+5,700,x+8,725);
                // left elbow
                g.drawLine(x+8,725,x+20,730);
                // right arm
                g.drawLine(x+5,700,x-5,725);
                // right elbow
                g.drawLine(x-5,725,x+7,730);
            }
            else{
                //head
                g.drawOval(x+28,705,30,30);
                //body
                g.drawLine(x+30,730,x,750);
                //left arm
                g.drawLine(x+30,730,x-5,710);
                // right arm
                g.drawLine(x+30,730,x-5,720);
            }
        }
    }
}