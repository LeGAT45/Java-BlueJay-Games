/*
 * CONTROLS:
 * 
 * WASD or Arrow Keys to move
 * 
 * CONTROLS:
 */
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Snake extends JApplet{
    @Override
    public void init(){
        add(new Snake_Engine());
    }
}
class Snake_Engine extends JPanel implements KeyListener, MouseListener{
    int scor;
    String score;
    boolean grid;
    boolean dead ;
    boolean redT;
    boolean Start;
    int size;
    int speed;
    int ch;
    boolean start1;
    boolean start;
    boolean right;
    boolean left;
    boolean up;
    boolean down;
    boolean red1;
    boolean remove;
    boolean mEntered;
    boolean mRelease;
    boolean mPressed;
    boolean mClick;
    int mX;
    int mY;
    int tx;
    Random rand;
    Box red;
    Box head;
    ArrayList<Box> turn;
    ArrayList<Box> body;
    public Snake_Engine(){
        scor = 0;
        score = "";
        size = 1;
        speed = 1;
        addMouseListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        start1 = false;
        start = true;
        Start = false;
        addKeyListener(this);
        mPressed = false;
        grid = true;
        dead = false;
        remove = true;
        red1 = false;
        right = false;
        up = false;
        down = false;
        left = false;
        redT = true;
        //red = new Box(25,20,1);
        head = new Box(7,5,1);
        turn = new ArrayList<Box>();
        body = new ArrayList<Box>();
        turn.add(0,new Box(7,5,2));
        turn.add(1,new Box(35,5,3));
        turn.add(2,new Box(35,15,4));
        turn.add(3,new Box(7,15,1));
        body.add(0,new Box(7,6,1));
        body.add(0,new Box(7,7,1));
        body.add(0,new Box(7,8,1));
        body.add(0,new Box(7,9,1));
        rand = new Random();
    }
    public void keyReleased(KeyEvent k){}
    public void keyTyped(KeyEvent k){}
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(dead){
            if(ch == KeyEvent.VK_R){
                dead = false;
                try{
            for(int count = 0;count != turn.size()+1;count++){
                turn.remove(0);
            }
            }catch(Exception e){}
            try{
            for(int count = 0;count != body.size()+1;count++){
                body.remove(0);
            }
            }catch(Exception e){}
            if(size == 0){
                red.changeX(25);
                red.changeY(20);
                body.add(0,new Box(25,26,1));
                body.add(1,new Box(25,25,1));
                head.changeX(25);
                head.changeY(24);
            }
            else if(size == 1){
                red.changeX(15);
                red.changeY(5);
                body.add(0,new Box(15,16,1));
                body.add(1,new Box(15,15,1));
                head.changeX(15);
                head.changeY(14);
            }
            else{
                red.changeX(7);
                red.changeY(3);
                body.add(0,new Box(7,8,1));
                body.add(1,new Box(7,7,1));
                head.changeX(7);
                head.changeY(6);
            }
            head.changeD(1);
            }
        }
        if(!start){
            if(ch == KeyEvent.VK_W ||ch == KeyEvent.VK_UP){
                up = true;
            }
            else if(ch == KeyEvent.VK_A||ch == KeyEvent.VK_LEFT){
                left = true;
            }
            else if(ch == KeyEvent.VK_S||ch == KeyEvent.VK_DOWN){
                down = true;
            }
            else if(ch == KeyEvent.VK_D||ch == KeyEvent.VK_RIGHT){
                right = true;
            }
            else if(ch == KeyEvent.VK_P){
                start1 = !start1;
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(start){
            g.setColor(new Color(238,223,37));
            g.fillRect(0,0,750,750);
            g.setColor(new Color(12,101,14));
            g.setFont(new Font("Comic_Sans",Font.BOLD,85));
            g.drawString("Snake",200,200);
            g.setFont(new Font("Comic_Sans",Font.BOLD,20));
            g.drawString("Speed:",200,400);
            g.drawString("Grid On or Off:",200,500);
            g.drawString("Size:",200,600);
            g.setColor(Color.green);
            g.fillRect(315,675,100,40);
            g.setColor(new Color(12,101,14));
            g.drawString("Start",340,700);
            g.setColor(Color.gray);
            //speed
            g.drawOval(300,382,25,25);
            g.drawOval(350,382,25,25);
            g.drawOval(400,382,25,25);
            g.setColor(Color.green);
            if(speed == 0){
                g.fillOval(300,382,25,25);
            }
            else if(speed == 1){
                g.fillOval(350,382,25,25);
            }
            else if(speed == 2){
                g.fillOval(400,382,25,25);
            }
            //grid
            g.setColor(Color.gray);
            g.drawOval(380,482,25,25);
            g.drawOval(430,482,25,25);
            g.setColor(Color.green);
            if(grid){
                g.fillOval(380,482,25,25);
            }
            else if(!grid){
                g.fillOval(430,482,25,25);
            }
            //size
            // 50, 30, 15, 50 - 15, 30 - 25, 15 - 50
            g.setColor(Color.gray);
            g.drawOval(280,582,25,25);
            g.drawOval(330,582,25,25);
            g.drawOval(380,582,25,25);
            g.setColor(Color.green);
            if(size == 0){
                g.fillOval(280,582,25,25);
            }
            else if(size == 1){
                g.fillOval(330,582,25,25);
            }
            else if(size == 2){
                g.fillOval(380,582,25,25);
            }
            /*if(){
                start = false;
            }*/
            g.setColor(new Color(34,241,0));
            // drawing head and eyes
            g.fillRect((head.getX()*15+1),(head.getY()*15+1),14,14);
            g.setColor(Color.black);
            if(head.getD() == 1){
                g.fillOval(head.getX()*15 + 2,head.getY()*15 + 2,5,5);
                g.fillOval(head.getX()*15 + 9,head.getY()*15 + 2,5,5);
            }
            else if(head.getD() == 2){
                g.fillOval(head.getX()*15 + 9,head.getY()*15 +2,5,5);
                g.fillOval(head.getX()*15 + 9,head.getY()*15 +9,5,5);
            }
            else if(head.getD() == 3){
                g.fillOval(head.getX()*15 + 2,head.getY()*15 +9,5,5);
                g.fillOval(head.getX()*15 + 9,head.getY()*15 +9,5,5);
            }
            else{
                g.fillOval(head.getX()*15 + 2,head.getY()*15 +2,5,5);
                g.fillOval(head.getX()*15 + 2,head.getY()*15 +9,5,5);
            }
            g.setColor(new Color(34,241,0));
            //painting body pieces
            for(int count = 0;count != body.size();count++){
                g.fillRect((body.get(count).getX()*15+1),(body.get(count).getY()*15+1),14,14);
            }
            //turning body pieces
            try{
                for(int count = 0;count != turn.size();count++){
                    for(int count2 = 0;count2 != body.size();count2++){
                        if(body.get(count2).getX() == turn.get(count).getX() && body.get(count2).getY() == turn.get(count).getY()){
                            body.get(count2).changeD(turn.get(count).getD());
                        }
                    }
                }
            }
            catch(Exception e){}
            //turning head piece
            try{
                for(int count = 0;count != turn.size();count++){
                    if(head.getX() == turn.get(count).getX() && head.getY() == turn.get(count).getY()){
                        head.changeD(turn.get(count).getD());
                    }
                }
            }
            catch(Exception e){}
            // preparing head for next repaint
            if(head.getD() == 1){
                head.changeY(head.getY() - 1);
            }
            else if(head.getD() == 2){
                head.changeX(head.getX() + 1);
            }
            else if(head.getD() == 3){
                head.changeY(head.getY() + 1);
            }
            else if(head.getD() == 4){
                head.changeX(head.getX() - 1);
            }
            // preparing all body pieces for next repaint
            for(int count = 0;count != body.size();count++){
                    if(body.get(count).getD() == 1){
                        body.get(count).changeY(body.get(count).getY() - 1);
                    }
                    else if(body.get(count).getD() == 2){
                        body.get(count).changeX(body.get(count).getX() + 1);
                    }
                    else if(body.get(count).getD() == 3){
                        body.get(count).changeY(body.get(count).getY() + 1);
                    }
                    else if(body.get(count).getD() == 4){
                        body.get(count).changeX(body.get(count).getX() - 1);
                    }
            }
            try{
                Thread.sleep(100);
                repaint();
            }
            catch(Exception e){}
        }
        if(!start && Start){
            try{
            for(int count = 0;count != turn.size()+1;count++){
                turn.remove(0);
            }
            }catch(Exception e){}
            try{
            for(int count = 0;count != body.size()+1;count++){
                body.remove(0);
            }
            }catch(Exception e){}
            if(size == 0){
                red = new Box(25,20,1);
                body.add(0,new Box(25,26,1));
                body.add(1,new Box(25,25,1));
                head.changeX(25);
                head.changeY(24);
            }
            else if(size == 1){
                red = new Box(15,5,1);
                body.add(0,new Box(15,16,1));
                body.add(1,new Box(15,15,1));
                head.changeX(15);
                head.changeY(14);
            }
            else{
                red = new Box(7,3,1);
                body.add(0,new Box(7,8,1));
                body.add(1,new Box(7,7,1));
                head.changeX(7);
                head.changeY(6);
            }
            head.changeD(1);
            Start = false;
            start = false;
            start1 = true;
            mPressed = false;
        }
        if(!dead && !start){
        //background color
        g.setColor(new Color(20,50,192));
        g.fillRect(0,0,750,750);
        //line color
        if(grid){
        g.setColor(Color.white);
        if(size == 0){
            tx = 15;
        }
        else if(size == 1){
            tx = 25;
        }
        else{
            tx = 50;
        }
        if(size == 0){
        for(int x = 0;x!= 49;x++){
            g.fillRect(0,tx,750,1);
            tx+=15;
        }
        }
        else if(size == 1){
            for(int x = 0;x!= 29;x++){
            g.fillRect(0,tx,750,1);
            tx+=25;
        }
        }
        else{
            for(int x = 0;x!= 14;x++){
            g.fillRect(0,tx,750,1);
            tx+=50;
        }
        }
        if(size == 0){
            tx = 15;
            for(int x = 0;x!= 49;x++){
            g.fillRect(tx,0,1,750);
            tx += 15;
            }
        }
        else if(size == 1){
            tx = 25;
            for(int x = 0;x!= 29;x++){
            g.fillRect(tx,0,1,750);
            tx += 25;
            }
        }
        else{
            tx = 50;
            for(int x = 0;x!= 14;x++){
            g.fillRect(tx,0,1,750);
            tx += 50;
            }
        }
        }
        g.setColor(Color.yellow);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString(score,690,50);
        g.setColor(new Color(34,241,0));
        // drawing head and eyes
        if(size == 0){
        g.fillRect((head.getX()*15+1),(head.getY()*15+1),14,14);
        g.setColor(Color.black);
        if(head.getD() == 1){
            g.fillOval(head.getX()*15 + 2,head.getY()*15 + 2,5,5);
            g.fillOval(head.getX()*15 + 9,head.getY()*15 + 2,5,5);
        }
        else if(head.getD() == 2){
            g.fillOval(head.getX()*15 + 9,head.getY()*15 +2,5,5);
            g.fillOval(head.getX()*15 + 9,head.getY()*15 +9,5,5);
        }
        else if(head.getD() == 3){
            g.fillOval(head.getX()*15 + 2,head.getY()*15 +9,5,5);
            g.fillOval(head.getX()*15 + 9,head.getY()*15 +9,5,5);
        }
        else{
            g.fillOval(head.getX()*15 + 2,head.getY()*15 +2,5,5);
            g.fillOval(head.getX()*15 + 2,head.getY()*15 +9,5,5);
        }
        }
        else if(size == 1){
        g.fillRect((head.getX()*25+1),(head.getY()*25+1),24,24);
        g.setColor(Color.black);
        if(head.getD() == 1){
            g.fillOval(head.getX()*25 + 4,head.getY()*25 + 4,9,9);
            g.fillOval(head.getX()*25 + 16,head.getY()*25 + 4,9,9);
        }
        else if(head.getD() == 2){
            g.fillOval(head.getX()*25 + 16,head.getY()*25 +4,9,9);
            g.fillOval(head.getX()*25 + 16,head.getY()*25 +16,9,9);
        }
        else if(head.getD() == 3){
            g.fillOval(head.getX()*25 + 4,head.getY()*25 +16,9,9);
            g.fillOval(head.getX()*25 + 16,head.getY()*25 +16,9,9);
        }
        else{
            g.fillOval(head.getX()*25 + 4,head.getY()*25 +4,9,9);
            g.fillOval(head.getX()*25 + 4,head.getY()*25 +16,9,9);
        }
        }
        else{
        g.fillRect((head.getX()*50+1),(head.getY()*50+1),49,49);
        g.setColor(Color.black);
        if(head.getD() == 1){
            g.fillOval(head.getX()*50 + 8,head.getY()*50 + 8,15,15);
            g.fillOval(head.getX()*50 + 30,head.getY()*50 + 8,15,15);
        }
        else if(head.getD() == 2){
            g.fillOval(head.getX()*50 + 30,head.getY()*50 +8,15,15);
            g.fillOval(head.getX()*50 + 30,head.getY()*50 +30,15,15);
        }
        else if(head.getD() == 3){
            g.fillOval(head.getX()*50 + 8,head.getY()*50 +30,15,15);
            g.fillOval(head.getX()*50 + 30,head.getY()*50 +30,15,15);
        }
        else{
            g.fillOval(head.getX()*50 + 8,head.getY()*50 +8,15,15);
            g.fillOval(head.getX()*50 + 8,head.getY()*50 +30,15,15);
        }
        }
        //painting red
        g.setColor(Color.red);
        if(size == 0){
            g.fillRect((red.getX()*15+1),(red.getY()*15+1),14,14);
        }
        else if(size == 1){
            g.fillRect((red.getX()*25+1),(red.getY()*25+1),24,24);
        }
        else{
            g.fillRect((red.getX()*50+1),(red.getY()*50+1),49,49);
        }
        g.setColor(new Color(34,241,0));
        //painting body pieces
        for(int count = 0;count != body.size();count++){
            if(size==0){
                g.fillRect((body.get(count).getX()*15+1),(body.get(count).getY()*15+1),14,14);
            }
            else if(size==1){
                g.fillRect((body.get(count).getX()*25+1),(body.get(count).getY()*25+1),24,24);
            }
            else{
                g.fillRect((body.get(count).getX()*50+1),(body.get(count).getY()*50+1),49,49);
            }
        }
        if(start1){
            g.setColor(Color.yellow);
            g.setFont(new Font("Comic_Sans",Font.BOLD,85));
            g.drawString("Click anywhere",100,300);
            g.drawString("to start",220,450);
            if(mPressed){
                start1 = false;
                mPressed = false;
            }
        }
        if(!start1){
        //detecting direction keys and making turn box in that direction and changing head direction
        if(right && head.getD()!= 4){
            if(turn.size() == 0){
                turn.add(0,new Box(head.getX(),head.getY(),2));
            }
            else{
                turn.add(turn.size(),new Box(head.getX(),head.getY(),2));
            }
            head.changeD(2);
            right = false;
        }
        else if(up && head.getD()!= 3){
            if(turn.size() == 0){
                turn.add(0,new Box(head.getX(),head.getY(),1));
            }
            else{
                turn.add(turn.size(),new Box(head.getX(),head.getY(),1));
            }
            head.changeD(1);
            up = false;
        }
        else if(left && head.getD()!= 2){
            if(turn.size() == 0){
                turn.add(0,new Box(head.getX(),head.getY(),4));
            }
            else{
                turn.add(turn.size(),new Box(head.getX(),head.getY(),4));
            }
            head.changeD(4);
            left = false;
        }
        else if(down && head.getD()!= 1){
            if(turn.size() == 0){
                turn.add(0,new Box(head.getX(),head.getY(),3));
            }
            else{
                turn.add(turn.size(),new Box(head.getX(),head.getY(),3));
            }
            head.changeD(3);
            down = false;
        }
        //turning body pieces
        try{
        for(int count = 0;count != turn.size();count++){
            for(int count2 = 0;count2 != body.size();count2++){
                if(body.get(count2).getX() == turn.get(count).getX() && body.get(count2).getY() == turn.get(count).getY()){
                    body.get(count2).changeD(turn.get(count).getD());
                }
            }
        }
        }
        catch(Exception e){}
        //turning head piece
        try{
        for(int count = 0;count != turn.size();count++){
        if(head.getX() == turn.get(count).getX() && head.getY() == turn.get(count).getY()){
              head.changeD(turn.get(count).getD());
        }
        }
        }
        catch(Exception e){}
        //removing turn boxs
        try{
        for(int count2 = 0;count2 != body.size();count2++){
            if((turn.get(0).getX() == body.get(count2).getX() && turn.get(0).getY() == body.get(count2).getY()) || head.getX() == turn.get(0).getX() && head.getY() == turn.get(0).getY()){
                 remove = false;
            }
        }
        if(remove){
            turn.remove(0);
        }
        remove = true;
        }
        catch(Exception e){}
        // preparing head for next repaint
        if(head.getD() == 1){
            head.changeY(head.getY() - 1);
        }
        else if(head.getD() == 2){
            head.changeX(head.getX() + 1);
        }
        else if(head.getD() == 3){
            head.changeY(head.getY() + 1);
        }
        else if(head.getD() == 4){
            head.changeX(head.getX() - 1);
        }
        // preparing all body pieces for next repaint
        for(int count = 0;count != body.size();count++){
            if(!(count == 0 && (red1 == true))){
            if(body.get(count).getD() == 1){
                body.get(count).changeY(body.get(count).getY() - 1);
            }
            else if(body.get(count).getD() == 2){
                body.get(count).changeX(body.get(count).getX() + 1);
            }
            else if(body.get(count).getD() == 3){
                body.get(count).changeY(body.get(count).getY() + 1);
            }
            else if(body.get(count).getD() == 4){
                body.get(count).changeX(body.get(count).getX() - 1);
            }
            red1 = false;
            }
        }
        // detecting if head or body is onto red and if so make new red and detect if those X and Y cords are already ontop of a existing piece
        if(head.getX() == red.getX() && head.getY() == red.getY()){
        scor++;
        score = "" + scor;
        body.add(0,new Box(body.get(0).getX(),body.get(0).getY(),body.get(0).getD()));
        red1 = true;
        if(size==0){
            red.changeX(rand.nextInt(50));
            red.changeY(rand.nextInt(50));
        }
        else if(size==1){
            red.changeX(rand.nextInt(30));
            red.changeY(rand.nextInt(30));
        }
        else{
            red.changeX(rand.nextInt(15));
            red.changeY(rand.nextInt(15));
        }
        while(redT){
               redT = false;
               //g.drawString(red.getX(),350,350);
               for(int count = 0;count != body.size();count++){
                   if((head.getX() == red.getX() && head.getY() == red.getY()) || (body.get(count).getX() == red.getX() && body.get(count).getY() == red.getY())){
                       redT = true;
                   }
               }
               if(redT){
                     if(size==0){
                         red.changeX(rand.nextInt(50));
                         red.changeY(rand.nextInt(50));
                     }
                     else if(size==1){
                         red.changeX(rand.nextInt(30));
                         red.changeY(rand.nextInt(30));
                     }
                     else{
                         red.changeX(rand.nextInt(15));
                         red.changeY(rand.nextInt(15));
                     }
               }
               else{
                   redT = false;
               }
        }
        redT = true;
        }

        //detecting if you lose or not
        for(int count = 0;count != body.size();count++){
            if(size == 0){
                if(head.getX() == body.get(count).getX() && head.getY() == body.get(count).getY() || head.getX() < 0 || head.getY() < 0 || head.getX() >= 50 || head.getY() >= 50){
                    dead = true;
                }
            }
            else if(size == 1){
                if(head.getX() == body.get(count).getX() && head.getY() == body.get(count).getY() || head.getX() < 0 || head.getY() < 0 || head.getX() >= 30 || head.getY() >= 30){
                    dead = true;
                }
            }
            else{
                if(head.getX() == body.get(count).getX() && head.getY() == body.get(count).getY() || head.getX() < 0 || head.getY() < 0 || head.getX() >= 15 || head.getY() >= 15){
                    dead = true;
                }
            }
        }
        }
        if(dead){
        g.setColor(Color.yellow);
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.drawString("You Died!",100,300);
        }
        if(!dead){
        //repaint
        try{
            if(speed == 0){
                if(200-body.size() <=50){
                    Thread.sleep(50);
                }
                else{
                    Thread.sleep(200-body.size());
                }
            }
            else if(speed == 1){
                if(150-body.size() <=50){
                    Thread.sleep(50);
                }
                else{
                    Thread.sleep(150-body.size());
                }
            }
            else if(speed == 2){
                if(100-body.size() <=50){
                    Thread.sleep(50);
                }
                else{
                    Thread.sleep(100-body.size());
                }
            }
        }
        catch(Exception e){
        }
        repaint();
        }
        }
    }
    public void mouseEntered(MouseEvent me)
    {
        mEntered = true;
    }
    public void mouseExited(MouseEvent me)
    {
        mEntered = false;
    }
    public void mousePressed(MouseEvent me)
    {
        mPressed = true;
        mX = me.getX();
        mY = me.getY();
        //(315,675,100,40);
        if(start && !start1 && !Start && mX>315 && mX<415 && mY>675 && mY<715){
            start = false;
            Start = true;
        }
        if(start){
            //speed
            if(mX >=300 && mX <= 325 && mY >= 382 && mY <= 407){
                speed = 0;
            }
            else if(mX >=350 && mX <= 375 && mY >= 382 && mY <= 407){
                speed = 1;
            }
            else if(mX >=400 && mX <= 425 && mY >= 382 && mY <= 407){
                speed = 2;
            }
            //grid
            else if(mX >=380 && mX <= 405 && mY >= 482 && mY <= 507){
                grid = true;
            }
            else if(mX >=430 && mX <= 455 && mY >= 482 && mY <= 507){
                grid = false;
            }
            // size
            else if(mX >280 && mX <= 305 && mY >= 582 && mY <= 607){
                size = 0;
            }
            else if(mX >=330 && mX <= 355 && mY >= 582 && mY <= 607){
                size = 1;
            }
            else if(mX >=380 && mX <= 405 && mY >= 582 && mY <= 607){
                size = 2;
            }
        }
    }
    public void mouseReleased(MouseEvent me)
    {
        mRelease = true;
    }
    public void mouseClicked(MouseEvent me)
    {
        mClick = true;
    }
    public void run()
    {
    }
    public void start()
    {
    }
    public void stop()
    {
    }
}