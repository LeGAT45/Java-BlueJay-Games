/*
 *           Controls:
 * R to retsart
 * P to pause
 * SPACE, UP, or W to jump
 * Y to go back to the start menu
 * 
 * In versus mode: (must go fullscreen)
 * Top screen uses W or SPACE
 * Bottom screen ues UP to jump
 * Rules are first to 100 win by ten for hard mode,
 * first to 2000 win by 100 for normal mode
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
import java.io.*;
public class DinoRun extends JApplet{
    @Override
    public void init(){
        add(new DinoRun_Engine());
    }
}
class DinoRun_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    tempGuy p;
    tempGuy p2;
    int counter;
    boolean jump;
    boolean jump2;
    int add;
    int add2;
    ArrayList<Objs>Obj;
    int speed;
    Random rand;
    int temp;
    int time;
    boolean dead;
    boolean dead2;
    int score;
    int maxTime;
    String print;
    int temp2;
    boolean pause;
    int clear;
    int p1Wins;
    boolean hard = true;
    boolean versus = false;
    int p2Wins;
    String semp;
    boolean title;
    ArrayList<Person>Leaderboard_Normal;
    ArrayList<Person>Leaderboard_Hard;
    //boolean input;
    public DinoRun_Engine(){
        Leaderboard_Normal = new ArrayList<Person>();
        Leaderboard_Hard = new ArrayList<Person>();
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Normal Leaderboards^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                                                                            /*1*/ Leaderboard_Normal.add(0,new Person("GAT",2010));
                                                                                       
                                                                            /*2*/ Leaderboard_Normal.add(1,new Person("Zeke",823));
                                                                                       
                                                                            /*3*/ Leaderboard_Normal.add(2,new Person("David Ye",790));
                                                                                       
                                                                            /*4*/ Leaderboard_Normal.add(3,new Person("Isaac",670));
                                                                                       
                                                                            /*5*/ Leaderboard_Normal.add(4,new Person("Katie",388));
                                                                                       
                                                                            /*6*/ Leaderboard_Normal.add(5,new Person("David Jiang",112));
                                                                                       
                                                                            /*7*/ Leaderboard_Normal.add(6,new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
                                                                                       
                                                                            /*8*/ Leaderboard_Normal.add(7,new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
                                                                                       
                                                                            /*9*/ Leaderboard_Normal.add(8,new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
                                                                                       
                                                                            /*10*/ Leaderboard_Normal.add(9,new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Normal Leaderboards^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        
        
        
        
                //                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Hard Leaderboards^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                                                                            /*1*/ Leaderboard_Hard.add(new Person("GAT",74));
                                                                                       
                                                                            /*2*/ Leaderboard_Hard.add(new Person("Isaac",48));
                                                                                       
                                                                            /*3*/ Leaderboard_Hard.add(new Person("David Ye",45));
                                                                                       
                                                                            /*4*/ Leaderboard_Hard.add(new Person("Zeke",34));
                                                                                       
                                                                            /*5*/ Leaderboard_Hard.add(new Person("David Jiang",9));
                                                                                       
                                                                            /*6*/ Leaderboard_Hard.add(new Person("Katie",7));
                                                                                       
                                                                            /*7*/ Leaderboard_Hard.add(new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
                                                                                       
                                                                            /*8*/ Leaderboard_Hard.add(new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
                                                                                       
                                                                            /*9*/ Leaderboard_Hard.add(new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
                                                                                       
                                                                            /*10*/ Leaderboard_Hard.add(new Person(/*Insert NAME here*/"",/*Insert SCORE here*/0));
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Hard Leaderboards^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // JApplet
        this.setFocusable(true);
        this.requestFocusInWindow();
        // keyListener
        addKeyListener(this);
        ch = 0;
        // mouseListener
        addMouseListener(this);
        mX = 0;
        mY = 0;
        // ^^^^^^^^^^^
        p = new tempGuy(200,300,0);
        p2 = new tempGuy(200,300,0);
        jump = false;
        jump2 = false;
        add = 0;
        add2 = 0;
        Obj = new ArrayList<Objs>();
        speed = 0;
        rand = new Random();
        temp = rand.nextInt(90);
        Obj.add(0,new Objs(1600,0,10+temp,0));
        temp2 = rand.nextInt(100);
        Obj.get(0).y = 250-temp2+temp/3;
        time = 66;
        dead = false;
        dead2 = false;
        clear = 0;
        p1Wins = 0;
        p2Wins = 0;
        semp = "";
        if(hard){
            score = 500;
        }
        else{
            score = 0;
        }
        maxTime = 50;
        print = "";
        counter = 3;
        title = true;
        if(versus){
            pause = true;
        }
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        if(((ch == KeyEvent.VK_UP || ch == KeyEvent.VK_W || ch == KeyEvent.VK_SPACE) && !pause && !dead)&&!versus){
            jump = false;
        }
        if(((ch == KeyEvent.VK_UP /*|| ch == KeyEvent.VK_SPACE*/) && !pause && !dead2 && !dead)&&versus){
            jump2 = false;
        }
        if(((ch == KeyEvent.VK_W || ch == KeyEvent.VK_SPACE) && !pause && !dead2 && !dead)&&versus){
            jump = false;
        }
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_Y){
            title = true;
        }
        if(!versus){
        if((ch == KeyEvent.VK_UP || ch == KeyEvent.VK_W || ch == KeyEvent.VK_SPACE) && p.y == 300 && !pause && !dead && !title){
            p.a = 25;
            p.y--;
            jump = true;
        }
        else if(ch == KeyEvent.VK_R && dead && !title){
            p.a = 0;
            jump = false;
            p.y = 300;
            time = 66;
            temp = rand.nextInt(90);
            Obj.clear();
            Obj.add(0,new Objs(1600,0,10+temp,0));
            temp2 = rand.nextInt(100);
            Obj.get(0).y = 250-temp2+temp/3;
            speed = 0;
            dead = false;
            clear = 0;
            if(hard){
                score = 500;
            }
            else{
                score = 0;
            }
            add = 0;
            maxTime = 25;
        }
        else if(ch == KeyEvent.VK_P && !title){
            pause = !pause;
        }
        }
        else{
        if((ch == KeyEvent.VK_W || ch == KeyEvent.VK_SPACE) && p.y == 300 && !pause && !dead && !dead2 && !title){
            p.a = 25;
            p.y--;
            jump = true;
        }
        if((ch == KeyEvent.VK_UP /*|| ch == KeyEvent.VK_SPACE*/) && p2.y == 300 && !pause && !dead && !dead2 && !title){
            p2.a = 25;
            p2.y--;
            jump2 = true;
        }
        if(ch == KeyEvent.VK_R && (dead || dead2) && !title){
            p.a = 0;
            p2.a = 0;
            jump = false;
            jump2 = false;
            p.y = 300;
            p2.y = 300;
            time = 66;
            temp = rand.nextInt(90);
            Obj.clear();
            Obj.add(0,new Objs(1600,0,10+temp,0));
            temp2 = rand.nextInt(100);
            Obj.get(0).y = 250-temp2+temp/3;
            speed = 0;
            dead = false;
            dead2 = false;
            clear = 0;
            if(hard){
                score = 500;
            }
            else{
                score = 0;
            }
            add = 0;
            add2 = 0;
            maxTime = 25;
        }
        else if(ch == KeyEvent.VK_P && !title){
            pause = !pause;
        }
        }
    }
    // mouseListener class methods
    public void mouseEntered(MouseEvent me){
    }
    public void mouseExited(MouseEvent me){
    }
    public void mouseClicked(MouseEvent me){
    }
    public void mouseReleased(MouseEvent me){
    }
    public void mousePressed(MouseEvent me){
        mX = me.getX();
        mY = me.getY();
        if(title){
        if(mX>742 && mX<862 && mY>475 && mY<525){
            title = false;
            p.y = 300;
            p.a = 0;
            add = 0;
            jump = false;
            Obj.clear();
            temp = rand.nextInt(90);
            Obj.add(0,new Objs(1600,0,10+temp,0));
            temp2 = rand.nextInt(100);
            Obj.get(0).y = 250-temp2+temp/3;
            time = 66;
            p2.y = 300;
            add2 = 0;
            jump2 = false;
            p2.a = 0;
            p2Wins = 0;
            p1Wins = 0;
            clear = 0;
            speed = 0;
            maxTime = 25;
            dead = false;
            dead2 = false;
            pause = false;
            if(hard){
                score = 500;
            }
            else{
                score = 0;
            }
        }
        else if(mX>618 && mX<753 && mY>208 && mY<266){
            hard = false;
        }
        else if(mX>853 && mX<948 && mY>208 && mY<266){
            hard = true;
        }
        else if(mX>663 && mX<753 && mY>340 && mY<398){
            versus = false;
        }
        else if(mX>853 && mX<993 && mY>340 && mY<398){
            versus = true;
        }
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);
        g.setColor(Color.white);
        if(title){
            //title
            //g.fillRect(0,525,1600,5);
            g.setFont(new Font("Arial",Font.BOLD,150));
            g.drawString("Dino Run",450,150);
            g.setFont(new Font("Arial",Font.BOLD,35));
            if(hard){
                g.setColor(Color.white);
                g.drawRect(618,208,135,58);
                g.setColor(Color.white);
                g.drawString("Normal",625,250);
            }
            else{
                g.setColor(Color.white);
                g.fillRect(618,208,135,58);
                g.setColor(Color.black);
                g.drawString("Normal",625,250);
            }
            if(hard){
                g.setColor(Color.white);
                g.fillRect(853,208,95,58);
                g.setColor(Color.black);
                g.drawString("Hard",860,250);
            }
            else{
                g.setColor(Color.white);
                g.drawRect(853,208,95,58);
                g.setColor(Color.white);
                g.drawString("Hard",860,250);
            }
            if(versus){
                g.setColor(Color.white);
                g.drawRect(663,340,90,58);
                g.setColor(Color.white);
                g.drawString("Solo",670,382);
            }
            else{
                g.setColor(Color.white);
                g.fillRect(663,340,90,58);
                g.setColor(Color.black);
                g.drawString("Solo",670,382);
            }
            if(versus){
                g.setColor(Color.white);
                g.fillRect(853,340,130,58);
                g.setColor(Color.black);
                g.drawString("Versus",860,382);
            }
            else{
                g.setColor(Color.white);
                g.drawRect(853,340,130,58);
                g.setColor(Color.white);
                g.drawString("Versus",860,382);
            }
            //leaderboard normal code
            g.setColor(Color.white);
            g.drawString("Normal",250,200);
            temp = 0;
            g.setFont(new Font("Arial",Font.BOLD,30));
            for(int count = 0;count != Leaderboard_Normal.size();count++){
                g.drawString((count+1)+". "+Leaderboard_Normal.get(count).name+" - "+Leaderboard_Normal.get(count).score,150,230+temp);
                temp += 30;
            }
            g.drawString("Hard",1350,200);
            temp = 0;
            for(int count = 0;count != Leaderboard_Hard.size();count++){
                g.drawString((count+1)+". "+Leaderboard_Hard.get(count).name+" - "+Leaderboard_Hard.get(count).score,1200,230+temp);
                temp += 30;
            }
            g.setColor(Color.white);
            g.fillRect(742,475,120,50);
            g.setColor(Color.black);
            g.drawString("Start",760,513);
            g.setColor(Color.white);
            //g.fillRect(800,0,5,800);
            g.fillRect(0,700,1600,300);
            g.fillOval(p.x-25,p.y+350,50,50);
            p.y -= p.a;
            if(p.y-p.a >= 300){
                p.a = 0;
                p.y = 300;
                add = 0;
            }
            else{
                p.a -= 3;
            }
            if(jump && add != 7){
                p.a+=3;
                add++;
            }
            else if(jump && add == 7){
                jump = false;
            }
            for(int count = Obj.size()-1;count > -1;count--){
                Obj.get(count).x -= 10;
                Obj.get(count).drawObj(g,375);
                if(Obj.get(count).x == 320){
                    p.a = 25;
                    p.y--;
                    jump = true;
                }
                if(Obj.get(count).x+Obj.get(count).xSize <= 0){
                    Obj.remove(count);
                }
            }
            if(time != 0){
                time--;
            }
            else{
                temp = rand.nextInt(90);
                Obj.add(0,new Objs(1600,0,10+temp,0));
                temp2 = rand.nextInt(100);
                Obj.get(0).y = 250-temp2+temp/3;
                time = 60;
            }
        }
        else{
        g.fillOval(p.x-25,p.y-25,50,50);
        g.fillRect(0,325,1600,50);
        g.fillRect(0,650,1600,300);
        if(versus){
            g.fillOval(p2.x-25,p2.y-25+325,50,50);
        }
        else{
            g.fillRect(0,325,1600,800);
        }
        g.setFont(new Font("Arial",Font.BOLD,25));
        print = "";
        if(hard){
            for(int count = 4-(""+clear).length();count != -1;count--){
                print += "0";
            }
        }
        else{
            for(int count = 4-(""+score).length();count != -1;count--){
                print += "0";
            }
        }
        if(pause){
            g.fillRect(785,150,10,50);
            g.fillRect(805,150,10,50);
        }
        if(dead && !versus){
            if(hard){
                g.drawString("Your score was: "+print+""+clear,675,200);
            }
            else{
                g.drawString("Your score was: "+print+""+score,675,200);
            }
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("You Died!",575,150);
            /*if(!input){
                try{
                    Scanner hs = new Scanner(new File("C:\\Users\\JAVA\\Desktop"));
                    PrintWriter hsWriter = new PrintWriter(new File("C:\\Users\\JAVA\\Desktop"));
                    while(hs.hasNext()){
                        if(hs.nextInt()<score){
                            temp = hs.nextInt();
                            hsWriter.print(score);
                        }
                    }
                }catch(Exception e){}}*/
        }
        else if(!versus){
            if(hard){
                g.drawString(print+""+clear,1520,25);
            }
            else{
                g.drawString(print+""+score,1520,25);
            }
        }
        else if(versus && (dead || dead2)){
            if(dead && dead2){
                g.setFont(new Font("Arial",Font.BOLD,100));
                g.drawString("It's a tie!",590,150);
            }
            else if(dead){
                g.setFont(new Font("Arial",Font.BOLD,100));
                g.drawString("Bottom wins!",500,150);
            }
            else{
                g.setFont(new Font("Arial",Font.BOLD,100));
                g.drawString("Top wins!",575,150);
            }
            g.setFont(new Font("Arial",Font.BOLD,25));
            if(hard){
                g.drawString("The score was: "+print+""+clear,675,200);
            }
            else{
                g.drawString("The score was: "+print+""+score,675,200);
            }
            if(p1Wins>p2Wins){
                print = "";
                semp=""+(p1Wins-p2Wins);
                for(int count = 2-semp.length();count != -1;count--){
                    print += "0";
                }
                g.drawString("Top is ahead by: "+print+(p1Wins-p2Wins),680,225);
            }
            else if(p2Wins>p1Wins){
                print = "";
                semp=""+(p2Wins-p1Wins);
                for(int count = 2-semp.length();count != -1;count--){
                    print += "0";
                }
                g.drawString("Bottom is ahead by: "+print+(p2Wins-p1Wins),670,225);
            }
            else{
                g.drawString("The score is tied",705,225);
            }
            g.setFont(new Font("Arial",Font.BOLD,15));
            print = "";
            for(int count = 4-(""+p1Wins).length();count != -1;count--){
                print += "0";
            }
            g.drawString("Top score: "+print+""+p1Wins,7,23);
            print = "";
            for(int count = 4-(""+p2Wins).length();count != -1;count--){
                print += "0";
            }
            g.drawString("Bottom score: "+print+""+p2Wins,7,398);
        }
        else if(versus){
            if(hard){
                g.drawString(print+""+clear,1520,25);
                g.drawString(print+""+clear,1520,400);
            }
            else{
                g.drawString(print+""+score,1520,25);
                g.drawString(print+""+score,1520,400);
            }
            g.setFont(new Font("Arial",Font.BOLD,15));
            print = "";
            if(hard){
                for(int count = 4-(""+p1Wins).length();count != -1;count--){
                    print += "0";
                }
            }
            else{
                for(int count = 4-(""+p1Wins).length();count != -1;count--){
                    print += "0";
                }
            }
            g.drawString("Top score: "+print+""+p1Wins,7,23);
            print = "";
            for(int count = 4-(""+p2Wins).length();count != -1;count--){
                print += "0";
            }
            g.drawString("Bottom score: "+print+""+p2Wins,7,398);
        }
        if(!versus){
            if(p.y-p.a >= 300 && !dead){
                p.a = 0;
                p.y = 300;
                add = 0;
            }
            else if(!pause && !dead){
                p.a -= 3;
            }
        }
        else{
            if(p.y-p.a >= 300 && !dead && !dead2){
                p.a = 0;
                p.y = 300;
                add = 0;
            }
            else if(!pause && !dead && !dead2){
                p.a -= 3;
            }
            if(p2.y-p2.a >= 300 && !dead2 && !dead){
                p2.a = 0;
                p2.y = 300;
                add2 = 0;
            }
            else if(!pause && !dead2 && !dead){
                p2.a -= 3;
            }
        }
        if(!dead && !pause && !versus){
            p.y -= p.a;
            if(counter == 0){
                score++;
                counter = 2;
            }
            else{
                counter--;
            }
        }
        else if(!dead && !pause && !dead2 && versus){
            p.y -= p.a;
            if(counter == 0){
                score++;
                counter = 3;
            }
            else{
                counter--;
            }
            p2.y -= p2.a;
        }
        if(!versus){
            if(jump && add != 7 && !pause){
                p.a+=3;
                add++;
            }
            if(hard && dead){
                g.setFont(new Font("Arial",Font.BOLD,20));
                for(int count = 0;count != Leaderboard_Hard.size();count++){
                    if(clear > Leaderboard_Hard.get(count).score){
                        g.setColor(Color.black);
                        g.fillRect(400,400,800,350);
                        g.setColor(Color.white);
                        g.drawString("You scored #"+(count+1)+" on the leaderboard!",800,475);
                        g.drawString("If you aren't on the leaderboard yet,",800,525);
                        g.drawString("or you got a higher score,",800,575);
                        g.drawString("go into the code and put in your score.",800,625);
                        temp = 0;
                        g.setFont(new Font("Arial",Font.BOLD,30));
                        for(int count2 = 0;count2 != Leaderboard_Hard.size();count2++){
                            g.drawString((count2+1)+". "+Leaderboard_Hard.get(count2).name+" - "+Leaderboard_Hard.get(count2).score,500,450+temp);
                            temp += 30;
                        }
                        count = Leaderboard_Hard.size()-1;
                    }
                }
            }
            if(!hard && dead){
                g.setFont(new Font("Arial",Font.BOLD,20));
                for(int count = 0;count != Leaderboard_Normal.size();count++){
                    if(score > Leaderboard_Normal.get(count).score){
                        g.setColor(Color.black);
                        g.fillRect(400,400,800,350);
                        g.setColor(Color.white);
                        g.drawString("You scored #"+(count+1)+" on the leaderboard!",800,475);
                        g.drawString("If you aren't on the leaderboard yet,",800,525);
                        g.drawString("or you got a higher score,",800,575);
                        g.drawString("go into the code and put in your score.",800,625);
                        break;
                    }
                }
                temp = 0;
                g.setFont(new Font("Arial",Font.BOLD,30));
                for(int count = 0;count != Leaderboard_Normal.size();count++){
                    g.drawString((count+1)+". "+Leaderboard_Normal.get(count).name+" - "+Leaderboard_Normal.get(count).score,500,450+temp);
                    temp += 30;
                }
            }
        }
        else if(versus){
            if(jump2 && add2 != 7 && !pause){
                p2.a+=3;
                add2++;
            }
            if(jump && add != 7 && !pause){
                p.a+=3;
                add++;
            }
        }
        speed = score/100*3;
        if(time == 0 && !dead && !pause && !dead2){
            temp = rand.nextInt(25);
            maxTime--;
            if(temp == 2 || maxTime <= 0){
                if(hard){
                    time = 20;
                }
                else{
                    time = 18;
                }
                temp = rand.nextInt(90);
                Obj.add(0,new Objs(1600,0,10+temp,0));
                if(325-(Obj.get(1).y-150)>300){
                    Obj.get(0).y = 300;
                }
                else if(Obj.size()>1){
                    if(rand.nextInt(2)+1==2){
                        Obj.get(0).y = 325-Math.abs(Obj.get(1).y-150)+(1*rand.nextInt(25));
                    }
                    else{
                        Obj.get(0).y = 325-Math.abs(Obj.get(1).y-150)+(-1*rand.nextInt(25));
                    }
                }
                else{
                    temp2 = rand.nextInt(100);
                    if(250-temp2+temp/3 > 310){
                        Obj.get(0).y = 15;
                    }
                    else{
                        Obj.get(0).y = 250-temp2+temp/3;
                    }
                }
                //Obj.get(0).y -= rand.nextInt(25);
                maxTime = 50;
            }
        }
        for(int count = Obj.size()-1;count > -1;count--){
            if(!dead && !pause && !dead2){
                Obj.get(count).x -= 20;
            }
            if(versus){
                Obj.get(count).drawObj(g,325);
            }
            if(versus && count == Obj.size()-1 && (dead || dead2)){
                Obj.get(count).drawObj(g,0);
            }
            else if(versus && !dead && !dead2){
                Obj.get(count).drawObj(g,0);
            }
            else if(!versus){
                Obj.get(count).drawObj(g,0);
            }
            if(!dead&&((p.x-25>Obj.get(count).x&&p.x-25<Obj.get(count).x+Obj.get(count).xSize&&p.y+25>Obj.get(count).y)||(p.x+25>Obj.get(count).x&&p.x+25<Obj.get(count).x+Obj.get(count).xSize&&p.y+25>Obj.get(count).y))){
                dead = true;
                if(clear == 0 && !dead2){
                    if(hard){
                        p2Wins++;
                    }
                    else{
                        p2Wins += 50;
                    }
                }
                else{
                    if(hard){
                        p2Wins += clear;
                    }
                    else{
                        p2Wins += score;
                    }
                }
            }
            if(!dead2&&versus&&((p2.x-25>Obj.get(count).x&&p2.x-25<Obj.get(count).x+Obj.get(count).xSize&&p2.y+25>Obj.get(count).y)||(p2.x+25>Obj.get(count).x&&p2.x+25<Obj.get(count).x+Obj.get(count).xSize&&p2.y+25>Obj.get(count).y))){
                dead2 = true;
                if(clear == 0 && !dead){
                    if(hard){
                        p1Wins++;
                    }
                    else{
                        p1Wins += 50;
                    }
                }
                else if(!dead){
                    if(hard){
                        p1Wins += clear;
                    }
                    else{
                        p1Wins += score;
                    }
                }
                else{
                    if(hard){
                        p2Wins -= clear;
                    }
                    else{
                        p2Wins -= score;
                    }
                }
                if(clear == 0 && dead2 && dead){
                    if(hard){
                        p2Wins--;
                    }
                }
            }
            if(Obj.get(count).x+Obj.get(count).xSize <= 0){
                Obj.remove(count);
                clear++;
                if(Obj.size()==0){
                    Obj.add(0,new Objs(1600,0,10+temp,0));
                    temp2 = rand.nextInt(100);
                    Obj.get(0).y = 250-temp2+temp/3;
                    if(66-speed*3<18){
                        time = 18;
                    }
                    else{
                        time = 66-speed*3;
                    }
                }
            }
        }
        if(time != 0 && !dead && !dead2 && !pause){
            time--;
        }
        }
        try{
            if(hard && !title){
               Thread.sleep(15); 
            }
            else{
                Thread.sleep(35);
            }
        }catch(Exception e){}
        repaint();
    }
}