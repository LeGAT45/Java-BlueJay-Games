import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Bots extends JApplet{
    @Override
    public void init(){
        add(new Bots_Engine());
    }
}
class Bots_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<Bot>bot;
    ArrayList<Bot>tempBot;
    Goal goal;
    boolean allDead;
    int startX;
    int startY;
    int fitSum;
    Random rand;
    int fitTemp;
    int next;
    int temp;
    int gen;
    Sorter sorter;
    ArrayList<Obstacle>obstacle = new ArrayList<Obstacle>();
    public Bots_Engine(){
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
        startX = 250;
        temp = 0;
        startY = 450;
        fitSum = 0;
        fitTemp = 0;
        next = 0;
        rand = new Random();
        gen = 0;
        goal = new Goal(250,50,25);
        bot = new ArrayList<Bot>();
        tempBot = new ArrayList<Bot>();
        sorter = new Sorter();
        for(int count = 0;count < 100;count++){
            bot.add(new Bot(startX,startY));
        }
        obstacle.add(new Obstacle(0,160,250,10));
        obstacle.add(new Obstacle(250,320,250,10));
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
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
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,50));
        
        // DRAWING---------------------------------------------------------------
        /*if(temp%2 == 0){
            g.drawString("Mo",100,100);
            temp = 1;
        }
        else{
            g.drawString("Nooooo",100,100);
            temp = 2;
        }*/
        for(int count = 0;count != obstacle.size();count++){
            obstacle.get(count).draw(g);
        }
        allDead = true;
        for(int count = 0;count < bot.size();count++){
            //bot stops moving if its dead or has reached the goal
            if(!(goal.inside(bot.get(count)) || bot.get(count).stop || bot.get(count).outOfBounds(500,500,obstacle))){
                bot.get(count).move();
                allDead = false;
            }
            bot.get(count).draw(g);
        }
        goal.draw(g);
        //g.drawString(""+temp,200,100);
        //g.drawString(""+bot.size(),100,100);
        g.drawString(""+gen,425,50);
        // NEW GENERATION-----------------------------------------------------------------
        if(allDead){
            gen++;
            // calculates total fitness of the bots
            fitSum = 0;
            for(int count = 0;count < bot.size();count++){
                fitSum+=goal.fitness(bot.get(count));
            }
            // generates new list of bots randomly with a higher chance of surviving if a bot has high fitness
            tempBot.clear();
            while(tempBot.size()<bot.size()/2){
                next = rand.nextInt(fitSum);
                fitTemp = 0;
                for(int count = 0;count != bot.size();count++){
                    if(next > fitTemp && next < fitTemp+goal.fitness(bot.get(count))){
                        if(tempBot.size()==0){
                            tempBot.add(0,new Bot(startX,startY));
                            tempBot.get(0).brain.directions = bot.get(count).brain.directions;
                        }
                        else if(!tempBot.contains(bot.get(count))){
                            tempBot.add(0,new Bot(startX,startY));
                            tempBot.get(0).brain.directions = bot.get(count).brain.directions;
                        }
                        break;
                    }
                    fitTemp+=goal.fitness(bot.get(count));
                }
            }
            //takes top half of bots to move on
            /*tempBot.clear();
            bot = sorter.sort(bot,goal);
            for(int count = 0;count < bot.size()/2;count++){
                tempBot.add(0,new Bot(startX,startY));
                tempBot.get(0).brain.directions = bot.get(count).brain.directions;
            }*/
            // copies bots from temp list to real list
            bot.clear();
            for(int count = 0;count != tempBot.size();count++){
                bot.add(0,new Bot(startX,startY));
                bot.get(0).brain.directions = tempBot.get(count).brain.directions;
            }
            // sorts bots based on fitness level
            //tempBot = sorter.sort(tempBot,goal);
            // breeds bots
            // averages two parents directions
            /*for(int count = 0;count != tempBot.size();count++){
                bot.add(0,new Bot(startX,startY));
                for(int count2 = 0;count2 != bot.get(bot.size()-1).brain.directions.size();count2++){
                    if(count == tempBot.size()-1){
                        bot.get(0).brain.directions.set(count2,(int)(tempBot.get(count).brain.directions.get(count2)+tempBot.get(0).brain.directions.get(count2))/2);
                    }
                    else{
                        bot.get(0).brain.directions.set(count2,(int)(tempBot.get(count).brain.directions.get(count2)+tempBot.get(count+1).brain.directions.get(count2))/2);
                    }
                }
            }*/
            // randomly chooses one of two "parents" genes/direction for the new "child"
            for(int count = 0;count != tempBot.size();count++){
                bot.add(0,new Bot(startX,startY));
                for(int count2 = 0;count2 != bot.get(bot.size()-1).brain.directions.size();count2++){
                    if(count == tempBot.size()-1){
                        if(rand.nextInt(10)%2==1){
                            bot.get(0).brain.directions.set(count2,tempBot.get(0).brain.directions.get(count2));
                        }
                        else{
                            bot.get(0).brain.directions.set(count2,tempBot.get(count).brain.directions.get(count2));
                        }
                    }
                    else{
                        if(rand.nextInt(10)%2==1){
                            bot.get(0).brain.directions.set(count2,tempBot.get(count+1).brain.directions.get(count2));
                        }
                        else{
                            bot.get(0).brain.directions.set(count2,tempBot.get(count).brain.directions.get(count2));
                        }
                    }
                }
            }
            // higher chance to mutate if the bot has low fitness
            /*for(int count = bot.size()/2;count != bot.size();count++){
                if(rand.nextInt(((4*(bot.size()/2))/5)-(count-bot.size()/2))==1){
                    bot.get(count).brain.mutate();
                }
            }*/
            //returns all bots to the starting location
            for(int count = 0;count < bot.size();count++){
                bot.get(count).reset(startX,startY);
            }
            // randomly mutates some bots
            for(int count = 0;count != bot.size();count++){
                if(rand.nextInt(20)==1){
                    bot.get(count).brain.mutate();
                }
            }
            allDead = false;
        }
        
        // REPAINT-----------------------------------------------------------------
        
        try{
            Thread.sleep(0);
        }catch(Exception e){}
        repaint();
    }
}