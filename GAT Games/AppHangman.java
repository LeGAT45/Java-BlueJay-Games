/*
 * INTRUCTIONS:
 * 
 * Enter name for first player,
 * then enter name for second player
 * then first player enters their word
 * then when you press a key it guesses that letter, or you can click on the right side on the letters
 * R to restart
 * 
 * INSTRUCTIONS:
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class AppHangman extends JApplet{
    @Override
    public void init(){
        add(new AppHangman_Engine());
    }
}
class AppHangman_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    int lives;
    String[] alphabet;
    int y;
    int x;
    ArrayList<String>guessedLetters;
    ArrayList<String>lines;
    ArrayList<String>word;
    boolean same;
    int p1Score;
    int p2Score;
    String p1Name;
    String p2Name;
    boolean p1NamePhase;
    boolean p2NamePhase;
    boolean wordPhase;
    boolean flash;
    int flashTimer;
    String letter;
    String tempLine;
    int spacing;
    boolean won;
    int turn;
    public AppHangman_Engine(){
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
        lives = 6;
        alphabet = new String[26];
        guessedLetters = new ArrayList<String>();
        word = new ArrayList<String>();
        lines = new ArrayList<String>();
        alphabet[0] = "A";
        alphabet[1] = "B";
        alphabet[2] = "C";
        alphabet[3] = "D";
        alphabet[4] = "E";
        alphabet[5] = "F";
        alphabet[6] = "G";
        alphabet[7] = "H";
        alphabet[8] = "I";
        alphabet[9] = "J";
        alphabet[10] = "K";
        alphabet[11] = "L";
        alphabet[12] = "M";
        alphabet[13] = "N";
        alphabet[14] = "O";
        alphabet[15] = "P";
        alphabet[16] = "Q";
        alphabet[17] = "R";
        alphabet[18] = "S";
        alphabet[19] = "T";
        alphabet[20] = "U";
        alphabet[21] = "V";
        alphabet[22] = "W";
        alphabet[23] = "X";
        alphabet[24] = "Y";
        alphabet[25] = "Z";
        y = 0;
        x = 0;
        same = false;
        p1Score = 0;
        p2Score = 0;
        p1Name = "";
        p2Name = "";
        p1NamePhase = true;
        p2NamePhase = false;
        wordPhase = false;
        flash = true;
        flashTimer = 0;
        letter = "";
        tempLine = "";
        spacing = 0;
        won = false;
        turn = 0;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_A){
            letter = "A";
        }
        else if(ch == KeyEvent.VK_B){
            letter = "B";
        }
        else if(ch == KeyEvent.VK_C){
            letter = "C";
        }
        else if(ch == KeyEvent.VK_D){
            letter = "D";
        }
        else if(ch == KeyEvent.VK_E){
            letter = "E";
        }
        else if(ch == KeyEvent.VK_F){
            letter = "F";
        }
        else if(ch == KeyEvent.VK_G){
            letter = "G";
        }
        else if(ch == KeyEvent.VK_H){
            letter = "H";
        }
        else if(ch == KeyEvent.VK_I){
            letter = "I";
        }
        else if(ch == KeyEvent.VK_J){
            letter = "J";
        }
        else if(ch == KeyEvent.VK_K){
            letter = "K";
        }
        else if(ch == KeyEvent.VK_L){
            letter = "L";
        }
        else if(ch == KeyEvent.VK_M){
            letter = "M";
        }
        else if(ch == KeyEvent.VK_N){
            letter = "N";
        }
        else if(ch == KeyEvent.VK_O){
            letter = "O";
        }
        else if(ch == KeyEvent.VK_P){
            letter = "P";
        }
        else if(ch == KeyEvent.VK_Q){
            letter = "Q";
        }
        else if(ch == KeyEvent.VK_R){
            if(won){
                won = false;
                wordPhase = true;
                lives = 6;
                tempLine = "";
                letter = "";
                if(turn == 1){
                    turn = 0;
                }
                else{
                    turn = 1;
                }
                word.clear();
                guessedLetters.clear();
                lines.clear();
            }
            else{
                letter = "R";
            }
        }
        else if(ch == KeyEvent.VK_S){
            letter = "S";
        }
        else if(ch == KeyEvent.VK_T){
            letter = "T";
        }
        else if(ch == KeyEvent.VK_U){
            letter = "U";
        }
        else if(ch == KeyEvent.VK_V){
            letter = "V";
        }
        else if(ch == KeyEvent.VK_W){
            letter = "W";
        }
        else if(ch == KeyEvent.VK_X){
            letter = "X";
        }
        else if(ch == KeyEvent.VK_Y){
            letter = "Y";
        }
        else if(ch == KeyEvent.VK_Z){
            letter = "Z";
        }
        else if(ch == KeyEvent.VK_ENTER){
            if(wordPhase){
                if(word.size()>0){
                    wordPhase = false;
                    for(int count = 0;count != word.size();count++){
                        lines.add(count,"_");
                    }
                }
            }
            else if(p1NamePhase){
                if(p1Name.length()>0){
                    p1NamePhase = false;
                    p2NamePhase = true;
                }
            }
            else if(p2NamePhase){
                if(p2Name.length()>0){
                    p2NamePhase = false;
                    wordPhase = true;
                }
            }
        }
        else if(ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE){
            if(wordPhase){
                word.remove(word.size()-1);
            }
            else if(p1NamePhase){
                p1Name = p1Name.substring(0,p1Name.length()-1);
            }
            else if(p2NamePhase){
                p2Name = p2Name.substring(0,p2Name.length()-1);
            }
        }
        if(wordPhase && !letter.equals("")){
            if(word.size()<10){
                word.add(word.size(),letter);
            }
        }
        else if(p1NamePhase){
            if(p1Name.length()<10){
                p1Name += letter;
            }
        }
        else if(p2NamePhase){
            if(p2Name.length()<10){
                p2Name += letter;
            }
        }
        else if(!letter.equals("") && !won && !wordPhase){
            for(int count = 0;count != guessedLetters.size();count++){
                if(guessedLetters.get(count).equals(letter)){
                    same = true;
                }
            }
            if(!same){
                guessedLetters.add(0,letter);
                for(int count = 0;count != word.size();count++){
                    if(letter.equals(word.get(count))){
                        lines.set(count,word.get(count));
                        same = true;
                    }
                }
                if(!same){
                    lives--;
                }
                else if(same){
                    same = false;
                }
            }
            else if(same){
                same = false;
            }
        }
        letter = "";
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
        if(!wordPhase && !p1NamePhase && !p2NamePhase){
        for(int count = 0;count != 26;count++){
            if(mX > x+450 && mX < x+480 && mY > 55+y && mY < 85+y){
                for(int count2 = 0;count2 != guessedLetters.size();count2++){
                    if(guessedLetters.get(count2) == alphabet[count] && !won){
                        same = true;
                    }
                }
                if(!same && !won){
                    guessedLetters.add(0,alphabet[count]);
                    for(int count3 = 0;count3 != word.size();count3++){
                        if(alphabet[count].equals(word.get(count3)) && !won){
                            lines.set(count3,word.get(count3));
                            same = true;
                        }
                    }
                    if(!same && !won){
                        lives--;
                    }
                    else if(same){
                        same = false;
                    }
                }
                else if(same){
                    same = false;
                }
            }
            y += 55;
            if(count == 12){
                x = 75;
                y = 0;
            }
        }
        x = 0;
        y = 0;
        }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(50,120,0));
        g.setColor(Color.black);
        // making hangman stand
        g.fillRect(25,600,175,10);
        g.fillRect(110,200,10,400);
        g.fillRect(120,200,150,10);
        g.fillRect(270,200,10,50);
        // making guy
        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        if(lives == 5){
            g.drawOval(250,250,50,50);
        }
        else if(lives == 4){
            g.drawOval(250,250,50,50);
            g.drawLine(275,300,275,375);
        }
        else if(lives == 3){
            g.drawOval(250,250,50,50);
            g.drawLine(275,300,275,375);
            g.drawLine(275,300,250,350);
        }
        else if(lives == 2){
            g.drawOval(250,250,50,50);
            g.drawLine(275,300,275,375);
            g.drawLine(275,300,250,350);
            g.drawLine(275,300,300,350);
        }
        else if(lives == 1){
            g.drawOval(250,250,50,50);
            g.drawLine(275,300,275,375);
            g.drawLine(275,300,250,350);
            g.drawLine(275,300,300,350);
            g.drawLine(275,375,250,425);
        }
        else if(lives == 0 || lives == -1){
            g.drawOval(250,250,50,50);
            g.drawLine(275,300,275,375);
            g.drawLine(275,300,250,350);
            g.drawLine(275,300,300,350);
            g.drawLine(275,375,250,425);
            g.drawLine(275,375,300,425);
        }
        // making buttons
        g.setFont(new Font("Arial",Font.BOLD,30));
        for(int count = 0;count != 26;count++){
            g.setColor(Color.black);
            g.fillRect(x+450,55+y,30,30);
            g.setColor(Color.white);
            g.drawString(alphabet[count],x+453,81+y);
            for(int count2 = 0;count2 != guessedLetters.size();count2++){
                if(guessedLetters.get(count2).equals(alphabet[count])){
                    g.setColor(Color.red);
                    g.drawLine(450+x,55+y,480+x,85+y);
                    g.drawLine(450+x,85+y,480+x,55+y);
                }
            }
            y+=55;
            if(count == 12){
                x = 75;
                y = 0;
            }
        }
        g.setColor(Color.white);
        y = 0;
        x = 0;
        // losing or winning
        if(!wordPhase && !p1NamePhase && !p2NamePhase){
            for(int count = 0;count != word.size();count++){
                if(!lines.get(count).equals(word.get(count))){
                    same = true;
                }
            }
            if(same){
                same = false;
            }
            else if(!won){
                won = true;
                if(turn == 0){
                    p2Score++;
                }
                else{
                    p1Score++;
                }
            }
        }
        if(lives == 0 && !won){
            if(turn == 0){
                p1Score++;
            }
            else{
                p2Score++;
            }
            won = true;
        }
        if(won){
            if(turn == 0 && lives == 0){
                g.drawString(p1Name+"'s word was",150,650);
                g.drawString("  "+p1Name+" won!",150,750);
                g.setFont(new Font("Arial",Font.BOLD,15));
                g.drawString("(Press R to play",175,770);
                g.drawString("  another round)",175,785);
            }
            else if(turn == 1 && lives == 0){
                g.drawString(p2Name+"'s word was",150,650);
                g.drawString("  "+p2Name+" won!",150,750);
                g.setFont(new Font("Arial",Font.BOLD,15));
                g.drawString("(Press R to play",175,770);
                g.drawString("  another round)",175,785);
            }
            else if(turn == 0){
                g.drawString(p2Name+" guessed ",125,650);
                g.drawString(p1Name+"'s word right",100,750);
                g.setFont(new Font("Arial",Font.BOLD,15));
                g.drawString("(Press R to play",175,770);
                g.drawString("  another round)",175,785);
            }
            else if(turn == 1){
                g.drawString(p1Name+" guessed",125,650);
                g.drawString(p2Name+"'s word right",100,750);
                g.setFont(new Font("Arial",Font.BOLD,15));
                g.drawString("(Press R to play",175,770);
                g.drawString("  another round)",175,785);
            }
        }
        // timer for flashing
        if(p1NamePhase || p2NamePhase || wordPhase){
            flashTimer++;
            if(flashTimer == 34){
                flash = !flash;
                flashTimer = 0;
            }
        }
        // making lines
        tempLine = "";
        if(!won){
            for(int count = 0;count != lines.size();count++){
                tempLine += lines.get(count);
                tempLine += " ";
                if(!lines.get(count).equals("_")){
                    spacing += 2;
                }
            }
        }
        else if(won && !wordPhase){
            for(int count = 0;count != lines.size();count++){
                tempLine += word.get(count);
                tempLine += " ";
                spacing += 2;
            }
        }
        if(!p1NamePhase && !p2NamePhase && !wordPhase){
            g.setFont(new Font("Arial",Font.BOLD,40));
            g.drawString(tempLine,225-(lines.size()*15+spacing),700);
        }
        spacing = 0;
        // making names and score
        g.setFont(new Font("Arial",Font.BOLD,30));
        if(p1NamePhase){
            g.drawString("Player one, please",100,700);
            g.drawString(" enter your name",100,750);
        }
        else if(p2NamePhase){
            g.drawString("Player two, please",100,700);
            g.drawString(" enter your name",100,750);
        }
        if(p1NamePhase){
            if(flash){
                g.drawString(p1Name+"|",100,75);
            }
            else{
                g.drawString(p1Name,100,75);
            }
        }
        else{
            g.drawString(p1Name+" - "+p1Score,100,75);
        }
        if(p2NamePhase){
            if(flash){
                g.drawString(p2Name+"|",100,150);
            }
            else{
                g.drawString(p2Name,100,150);
            }
        }
        else if(!p1NamePhase){
            g.drawString(p2Name+" - "+p2Score,100,150);
        }
        // entering word
        if(wordPhase){
            tempLine = "";
            for(int count = 0;count != word.size();count++){
                tempLine += word.get(count);
            }
            if(turn == 0){
                g.drawString(p1Name+" please,",100,650);
                g.drawString("enter your word",100,700);
                if(flash){
                    g.drawString(tempLine+"|",100,750);
                }
                else{
                    g.drawString(""+tempLine,100,750);
                }
            }
            else{
                g.drawString(p2Name+" please,",100,650);
                g.drawString("enter your word",100,700);
                if(flash){
                    g.drawString(tempLine+"|",100,750);
                }
                else{
                    g.drawString(""+tempLine,100,750);
                }
            }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}