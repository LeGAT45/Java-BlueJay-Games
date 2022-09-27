/*
 * CONTROLS:
 * 
 * A or LEFT to move the piece left
 * D or RIGHT to move the piece right
 * S or DOWN to move the piece down fast
 * W or UP to rotate the piece
 * 
 * R to restart once you've lost
 * P to pause and unpause
 * 
 * Made by GAT
 * 
 * Scoring system:
 *  40 * level = points for 1 row cleard at a time
 *  100 * level =  points for 2 rows cleard at a time
 *  300 * level = points for 3 rows cleard at a time
 *  1200 * level = points for 4 rows cleard at a time
 *  
 *  Every ten rows you clear equals one level,
 *  every level the game gets a little faster
 *  
 * CONTROLS:
 * 
 * LEADERBOARD:
 *
 * 
 * 2. Kegan - 45,740
 * 3. Isaac - 22,740
 * 4. KMM - 12,700
 * 5. Zeke - 4,820
 * 
 * LEADERBOARD:
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class Tetris extends JApplet{
    @Override
    public void init(){
        add(new Tetris_Engine());
    }
}
class Tetris_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    int x;
    int y;
    ArrayList<block>board;
    shape s;
    Random rand;
    int mDown;
    boolean max;
    boolean spawn;
    boolean left;
    boolean right;
    int nLeft;
    int nRight;
    int nextPiece;
    boolean pause;
    int score;
    String space;
    int row;
    int rowC;
    int level;
    boolean lost;
    boolean down;
    int r;
    boolean set;
    ArrayList<Integer>used;
    int move;
    boolean broke;
    public Tetris_Engine(){
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
        rand = new Random();
        x = 0;
        y = -120;
        used = new ArrayList<Integer>();
        r = rand.nextInt(7)+1;
        s = new shape(r);
        used.add(0,r);
        mDown = 10;
        max = false;
        down = false;
        right = false;
        left = false;
        spawn = false;
        nLeft = 0;
        nRight = 0;
        pause = false;
        space = "";
        score = 0;
        rowC = 0;
        row = 0;
        level = 1;
        lost = false;
        set = true;
        move = 0;
        broke = false;
        while(true){
            r = rand.nextInt(7)+1;
            if(used.size()!=0&&!(used.contains(r))){
                if(used.size()==4){
                    used.remove(3);
                }
                used.add(0,r);
                break;
            }
        }
        nextPiece = r;
        board = new ArrayList<block>();
        for(int count = 0;count != 230;count++){
            board.add(new block(0));
        }
        /*for(int count = board.size()-1;count != 199;count--){
            if(set){
                board.get(count).color = rand.nextInt(7)+1;
            }
            if((count)%10 != 0){
                set = !set;
            }
        }*/
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
        ch = k.getKeyCode();
        //if(!pause){
        if(ch == KeyEvent.VK_S || ch == KeyEvent.VK_DOWN){
            spawn = false;
            down = false;
        }
        else if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            left = false;
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            right = false;
        }
        //}
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        if(ch == KeyEvent.VK_P){
            pause = !pause;
        }
        if(!pause){
            if(ch == KeyEvent.VK_R && lost){
                x = 0;
                y = -120;
                r = rand.nextInt(7)+1;
                s = new shape(r);
                used = new ArrayList<Integer>();
                used.add(0,r);
                mDown = 10;
                max = false;
                right = false;
                left = false;
                spawn = false;
                nLeft = 0;
                nRight = 0;
                pause = false;
                space = "";
                score = 0;
                rowC = 0;
                row = 0;
                level = 1;
                lost = !true;
                while(true){
                    r = rand.nextInt(7)+1;
                    if(!(used.contains(r))){
                        break;
                    }
                }
                nextPiece = r;
                used.add(0,r);
                board = new ArrayList<block>();
                for(int count = 0;count != 230;count++){
                    board.add(new block(0));
                }
            }
        max = false;
        if(ch == KeyEvent.VK_A || ch == KeyEvent.VK_LEFT){
            left = true;
        }
        else if(ch == KeyEvent.VK_D || ch == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(ch == KeyEvent.VK_S || ch == KeyEvent.VK_DOWN){
            if(!spawn){
                mDown = 0;
            }
            down = true;
        }
        else if(ch == KeyEvent.VK_W || ch == KeyEvent.VK_UP){
            //
            max = false;
            if(s.type == 2 && s.rotate == 1){
                if(s.pos.get(0)+22 >= 230 || s.pos.get(0)+22 < 0 || s.pos.get(1)+11 >= 230 || s.pos.get(1)+11 < 0 || s.pos.get(3)-11 >= 230 || s.pos.get(3)-11 < 0 || board.get(s.pos.get(0)+22).color != 0 || board.get(s.pos.get(1)+11).color != 0 || board.get(s.pos.get(3)-11).color != 0){
                    max = true;
                }
            }
            if(s.type == 2 && s.rotate == 2){
                if(s.pos.get(0)-22 >= 230 || s.pos.get(0)-22 < 0 || s.pos.get(1)-11 >= 230 || s.pos.get(1)-11 < 0 || s.pos.get(3)+11 >= 230 || s.pos.get(3)+11 < 0 || board.get(s.pos.get(0)-22).color != 0 || board.get(s.pos.get(1)-11).color != 0 || board.get(s.pos.get(3)+11).color != 0 || (s.pos.get(3)+1)%10==0 || s.pos.get(0)%10 == 0 || (s.pos.get(0)-1)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 2 && !max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                }
                if(s.rotate == 1){
                    s.pos.set(0,s.pos.get(0)+22);
                    s.pos.set(1,s.pos.get(1)+11);
                    s.pos.set(3,s.pos.get(3)-11);
                }
                else{
                    s.pos.set(0,s.pos.get(0)-22);
                    s.pos.set(1,s.pos.get(1)-11);
                    s.pos.set(3,s.pos.get(3)+11);
                }
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = s.type;
                }
                if(s.rotate == 2 && s.type == 2){
                    s.rotate = 1;
                }
                else if(s.type == 2){
                    s.rotate++;
                }
            }
            //
            max = false;
            if(s.type == 7 && s.rotate == 1){
                if(s.pos.get(0)+11 >= 230 || s.pos.get(0)+11 < 0 || s.pos.get(2)-9 >= 230 || s.pos.get(2)-9 < 0 || s.pos.get(3)-20 >= 230 || s.pos.get(3)-20 < 0 || (board.get(s.pos.get(0)+11).color != 0 && !(s.pos.contains(s.pos.get(0)+11))) || (board.get(s.pos.get(2)+9).color != 0 && !(s.pos.contains(s.pos.get(2)+9))) || (board.get(s.pos.get(3)-20).color != 0 && !(s.pos.contains(s.pos.get(3)-20))) || (s.pos.get(0)+1)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 7 && s.rotate == 2){
                if(s.pos.get(0)-11 >= 230 || s.pos.get(0)-11 < 0 || s.pos.get(2)+9 >= 230 || s.pos.get(2)+9 < 0 || s.pos.get(3)+20 >= 230 || s.pos.get(3)+20 < 0 || (board.get(s.pos.get(0)-11).color != 0 && !(s.pos.contains(s.pos.get(0)-11))) || (board.get(s.pos.get(2)-9).color != 0 && !(s.pos.contains(s.pos.get(2)-9))) || (board.get(s.pos.get(3)+20).color != 0 && !(s.pos.contains(s.pos.get(3)+20)))){
                    max = true;
                }
            }
            if(s.type == 7 && !max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                }
                if(s.rotate == 1){
                    s.pos.set(0,s.pos.get(0)+11);
                    s.pos.set(2,s.pos.get(2)-9); 
                    s.pos.set(3,s.pos.get(3)-20);
                }
                else{
                    s.pos.set(0,s.pos.get(0)-11);
                    s.pos.set(2,s.pos.get(2)+9);
                    s.pos.set(3,s.pos.get(3)+20);
                }
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = s.type;
                }
                if(s.rotate == 2){
                    s.rotate = 1;
                }
                else{
                    s.rotate++;
                }
            }
            //
            max = false;
            if(s.type == 3 && s.rotate == 1){
                if(s.pos.get(0)+2 >= 230 || s.pos.get(0)+2 < 0 || s.pos.get(1)+9 >= 230 || s.pos.get(1)+9 < 0 || s.pos.get(3)-11 >= 230 || s.pos.get(3)-11 < 0 || (board.get(s.pos.get(0)+2).color != 0 && !(s.pos.contains(s.pos.get(0)+2))) || (board.get(s.pos.get(1)-9).color != 0 && !(s.pos.contains(s.pos.get(1)-9))) || (board.get(s.pos.get(3)+11).color != 0 && !(s.pos.contains(s.pos.get(3)+11))) || (s.pos.get(0)+2)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 3 && s.rotate == 2){
                if(s.pos.get(0)-2 >= 230 || s.pos.get(0)-2 < 0 || s.pos.get(1)-9 >= 230 || s.pos.get(1)-9 < 0 || s.pos.get(3)+11 >= 230 || s.pos.get(3)+11 < 0 || (board.get(s.pos.get(0)-2).color != 0 && !(s.pos.contains(s.pos.get(0)-2))) || (board.get(s.pos.get(1)+9).color != 0 && !(s.pos.contains(s.pos.get(1)+9))) || (board.get(s.pos.get(3)-11).color != 0 && !(s.pos.contains(s.pos.get(3)-11)))){
                    max = true;
                }
            }
            if(s.type == 3 && !max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                }
                if(s.rotate == 1){
                    s.pos.set(0,s.pos.get(0)+2);
                    s.pos.set(1,s.pos.get(1)-9);
                    s.pos.set(3,s.pos.get(3)-11);
                }
                else{
                    s.pos.set(0,s.pos.get(0)-2);
                    s.pos.set(1,s.pos.get(1)+9);
                    s.pos.set(3,s.pos.get(3)+11);
                }
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = s.type;
                }
                if(s.rotate == 2){
                    s.rotate = 1;
                }
                else{
                    s.rotate++;
                }
            }
            //
            max = false;
            if(s.type == 4 && s.rotate == 1){
                if(s.pos.get(0)-11 >= 230 || s.pos.get(0)-11 < 0 || s.pos.get(2)+9 >= 230 || s.pos.get(2)+9 < 0 || s.pos.get(3)+18 >= 230 || s.pos.get(3)+18 < 0 || (board.get(s.pos.get(0)-11).color != 0 && !(s.pos.contains(s.pos.get(0)-11))) || (board.get(s.pos.get(2)+9).color != 0 && !(s.pos.contains(s.pos.get(2)+9))) || (board.get(s.pos.get(3)+18).color != 0 && !(s.pos.contains(s.pos.get(3)+18))) || s.pos.get(0)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 4 && s.rotate == 2){
                if(s.pos.get(0)-9 >= 230 || s.pos.get(0)-9 < 0 || s.pos.get(2)-11 >= 230 || s.pos.get(2)-11 < 0 || s.pos.get(3)-22 >= 230 || s.pos.get(3)-22 < 0 || (board.get(s.pos.get(0)-9).color != 0 && !(s.pos.contains(s.pos.get(0)-9))) || (board.get(s.pos.get(2)-11).color != 0 && !(s.pos.contains(s.pos.get(2)-11))) || (board.get(s.pos.get(3)-22).color != 0 && !(s.pos.contains(s.pos.get(3)-22))) || (s.pos.get(3)-1)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 4 && s.rotate == 3){
                if(s.pos.get(0)+11 >= 230 || s.pos.get(0)+11 < 0 || s.pos.get(2)-9 >= 230 || s.pos.get(2)-9 < 0 || s.pos.get(3)-18 >= 230 || s.pos.get(3)-18 < 0 || (board.get(s.pos.get(0)+11).color != 0 && !(s.pos.contains(s.pos.get(0)+11))) || (board.get(s.pos.get(2)-9).color != 0 && !(s.pos.contains(s.pos.get(2)-9))) || (board.get(s.pos.get(3)-18).color != 0 && !(s.pos.contains(s.pos.get(3)-18))) || (s.pos.get(0)+1)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 4 && s.rotate == 4){
                if(s.pos.get(0)+9 >= 230 || s.pos.get(0)+9 < 0 || s.pos.get(2)+11 >= 230 || s.pos.get(2)+11 < 0 || s.pos.get(3)+22 >= 230 || s.pos.get(3)+22 < 0 || (board.get(s.pos.get(0)+9).color != 0 && !(s.pos.contains(s.pos.get(0)+9))) || (board.get(s.pos.get(2)+11).color != 0 && !(s.pos.contains(s.pos.get(2)+11))) || (board.get(s.pos.get(3)+22).color != 0 && !(s.pos.contains(s.pos.get(3)+22))) || (s.pos.get(3)+2)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 4 && !max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                }
                if(s.rotate == 1){
                    s.pos.set(0,s.pos.get(0)-11);
                    s.pos.set(2,s.pos.get(2)+9);
                    s.pos.set(3,s.pos.get(3)+18);
                }
                else if(s.rotate == 2){
                    s.pos.set(0,s.pos.get(0)-9);
                    s.pos.set(2,s.pos.get(2)-11);
                    s.pos.set(3,s.pos.get(3)-22);
                }
                else if(s.rotate == 3){
                    s.pos.set(0,s.pos.get(0)+11);
                    s.pos.set(2,s.pos.get(2)-9);
                    s.pos.set(3,s.pos.get(3)-18);
                }
                else if(s.rotate == 4){
                    s.pos.set(0,s.pos.get(0)+9);
                    s.pos.set(2,s.pos.get(2)+11);
                    s.pos.set(3,s.pos.get(3)+22);
                }
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = s.type;
                }
                if(s.rotate == 4){
                    s.rotate = 1;
                }
                else{
                    s.rotate++;
                }
            }
            //
            max = false;
            if(s.type == 5 && s.rotate == 1){
                if(s.pos.get(0)-11 >= 230 || s.pos.get(0)-11 < 0 || s.pos.get(2)-9 >= 230 || s.pos.get(2)-9 < 0 || s.pos.get(3)-18 >= 230 || s.pos.get(3)-18 < 0 || (board.get(s.pos.get(0)-11).color != 0 && !(s.pos.contains(s.pos.get(0)-11))) || (board.get(s.pos.get(2)-9).color != 0 && !(s.pos.contains(s.pos.get(2)-9))) || (board.get(s.pos.get(3)-18).color != 0 && !(s.pos.contains(s.pos.get(3)-18)))){
                    max = true;
                }
            }
            if(s.type == 5 && s.rotate == 2){
                if(s.pos.get(0)-9 >= 230 || s.pos.get(0)-9 < 0 || s.pos.get(2)+11 >= 230 || s.pos.get(2)+11 < 0 || s.pos.get(3)+22 >= 230 || s.pos.get(3)+22 < 0 || (board.get(s.pos.get(0)-9).color != 0 && !(s.pos.contains(s.pos.get(0)-9))) || (board.get(s.pos.get(2)+11).color != 0 && !(s.pos.contains(s.pos.get(2)+11))) || (board.get(s.pos.get(3)+22).color != 0 && !(s.pos.contains(s.pos.get(3)+22))) || (s.pos.get(3)+1)%10 == 0 || (s.pos.get(3)+2)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 5 && s.rotate == 3){
                if(s.pos.get(0)+11 >= 230 || s.pos.get(0)+11 < 0 || s.pos.get(2)+9 >= 230 || s.pos.get(2)+9 < 0 || s.pos.get(3)+18 >= 230 || s.pos.get(3)+18 < 0 || (board.get(s.pos.get(0)+11).color != 0 && !(s.pos.contains(s.pos.get(0)+11))) || (board.get(s.pos.get(2)+9).color != 0 && !(s.pos.contains(s.pos.get(2)+9))) || (board.get(s.pos.get(3)+18).color != 0 && !(s.pos.contains(s.pos.get(3)+18)))){
                    max = true;
                }
            }
            if(s.type == 5 && s.rotate == 4){
                if(s.pos.get(0)+9 >= 230 || s.pos.get(0)+9 < 0 || s.pos.get(2)-11 >= 230 || s.pos.get(2)-11 < 0 || s.pos.get(3)-22 >= 230 || s.pos.get(3)-22 < 0 || (board.get(s.pos.get(0)+9).color != 0 && !(s.pos.contains(s.pos.get(0)+9))) || (board.get(s.pos.get(2)-11).color != 0 && !(s.pos.contains(s.pos.get(2)-11))) || (board.get(s.pos.get(3)-22).color != 0 && !(s.pos.contains(s.pos.get(3)-22))) || s.pos.get(3)%10 == 0 || (s.pos.get(3)-1)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 5 && !max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                }
                if(s.rotate == 1){
                    s.pos.set(0,s.pos.get(0)-11);
                    s.pos.set(2,s.pos.get(2)-9);
                    s.pos.set(3,s.pos.get(3)-18);
                }
                else if(s.rotate == 2){
                    s.pos.set(0,s.pos.get(0)-9);
                    s.pos.set(2,s.pos.get(2)+11);
                    s.pos.set(3,s.pos.get(3)+22);
                }
                else if(s.rotate == 3){
                    s.pos.set(0,s.pos.get(0)+11);
                    s.pos.set(2,s.pos.get(2)+9);
                    s.pos.set(3,s.pos.get(3)+18);
                }
                else if(s.rotate == 4){
                    s.pos.set(0,s.pos.get(0)+9);
                    s.pos.set(2,s.pos.get(2)-11);
                    s.pos.set(3,s.pos.get(3)-22);
                }
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = s.type;
                }
                if(s.rotate == 4){
                    s.rotate = 1;
                }
                else{
                    s.rotate++;
                }
            }
            //
            max = false;
            if(s.type == 6 && s.rotate == 1){
                if(s.pos.get(0)+11 >= 230 || s.pos.get(0)+11 < 0 || s.pos.get(1)-9 >= 230 || s.pos.get(1)-9 < 0 || s.pos.get(3)+9 >= 230 || s.pos.get(3)+9 < 0 || (board.get(s.pos.get(0)+11).color != 0 && !(s.pos.contains(s.pos.get(0)+11))) || (board.get(s.pos.get(1)-9).color != 0 && !(s.pos.contains(s.pos.get(1)-9))) || (board.get(s.pos.get(3)+9).color != 0 && !(s.pos.contains(s.pos.get(3)+9)))){
                    max = true;
                }
            }
            if(s.type == 6 && s.rotate == 2){
                if(s.pos.get(0)+9 >= 230 || s.pos.get(0)+9 < 0 || s.pos.get(1)+11 >= 230 || s.pos.get(1)+11 < 0 || s.pos.get(3)-11 >= 230 || s.pos.get(3)-11 < 0 || (board.get(s.pos.get(0)+9).color != 0 && !(s.pos.contains(s.pos.get(0)+9))) || (board.get(s.pos.get(1)+11).color != 0 && !(s.pos.contains(s.pos.get(1)+11))) || (board.get(s.pos.get(3)-11).color != 0 && !(s.pos.contains(s.pos.get(3)-11))) || s.pos.get(3)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 6 && s.rotate == 3){
                if(s.pos.get(0)-11 >= 230 || s.pos.get(0)-11 < 0 || s.pos.get(1)+9 >= 230 || s.pos.get(1)+9 < 0 || s.pos.get(3)-9 >= 230 || s.pos.get(3)-9 < 0 || (board.get(s.pos.get(0)-11).color != 0 && !(s.pos.contains(s.pos.get(0)-11))) || (board.get(s.pos.get(1)+9).color != 0 && !(s.pos.contains(s.pos.get(1)+9))) || (board.get(s.pos.get(3)-9).color != 0 && !(s.pos.contains(s.pos.get(3)-9)))){
                    max = true;
                }
            }
            if(s.type == 6 && s.rotate == 4){
                if(s.pos.get(0)-9 >= 230 || s.pos.get(0)-9 < 0 || s.pos.get(1)-11 >= 230 || s.pos.get(1)-11 < 0 || s.pos.get(3)+11 >= 230 || s.pos.get(3)+11 < 0 || (board.get(s.pos.get(0)-9).color != 0 && !(s.pos.contains(s.pos.get(0)-9))) || (board.get(s.pos.get(1)-11).color != 0 && !(s.pos.contains(s.pos.get(1)-11))) || (board.get(s.pos.get(3)+11).color != 0 && !(s.pos.contains(s.pos.get(3)+11))) || (s.pos.get(2)+1)%10 == 0){
                    max = true;
                }
            }
            if(s.type == 6 && !max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                }
                if(s.rotate == 1){
                    s.pos.set(0,s.pos.get(0)+11);
                    s.pos.set(1,s.pos.get(1)-9);
                    s.pos.set(3,s.pos.get(3)+9);
                }
                else if(s.rotate == 2){
                    s.pos.set(0,s.pos.get(0)+9);
                    s.pos.set(1,s.pos.get(1)+11);
                    s.pos.set(3,s.pos.get(3)-11);
                }
                else if(s.rotate == 3){
                    s.pos.set(0,s.pos.get(0)-11);
                    s.pos.set(1,s.pos.get(1)+9);
                    s.pos.set(3,s.pos.get(3)-9);
                }
                else if(s.rotate == 4){
                    s.pos.set(0,s.pos.get(0)-9);
                    s.pos.set(1,s.pos.get(1)-11);
                    s.pos.set(3,s.pos.get(3)+11);
                }
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = s.type;
                }
                if(s.rotate == 4){
                    s.rotate = 1;
                }
                else{
                    s.rotate++;
                }
            }
            //
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
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.setColor(Color.white);
        if(pause){
            //g.drawString("Press P to un-pause",65,300);
            g.fillRect(255,350,20,100);
            g.fillRect(325,350,20,100);
        }
        else{
        x = 0;
        y = -120;
        max = false;
        if(right && nRight == 0){
            nRight = 2;
            for(int count = 0;count != s.pos.size();count++){
                if(s.pos.get(count)+1>s.pos.get(count)/10*10+9){
                    max = true;
                }
            }
            for(int count = 0;count != s.pos.size();count++){
                if(board.get(s.pos.get(count)+1).color != 0 && !(s.pos.contains(s.pos.get(count)+1))){
                    max = true;
                }
            }
            if(!max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                    s.pos.set(count,s.pos.get(count)+1);
                }
            }
        }
        else if(left && nLeft == 0){
            nLeft = 2;
            for(int count = 0;count != s.pos.size();count++){
                if(s.pos.get(count)-1<s.pos.get(count)/10*10){
                    max = true;
                }
            }
            for(int count = 0;count != s.pos.size();count++){
                if(board.get(s.pos.get(count)-1).color != 0 && !(s.pos.contains(s.pos.get(count)-1))){
                    max = true;
                }
            }
            if(!max){
                for(int count = 0;count != s.pos.size();count++){
                    board.get(s.pos.get(count)).color = 0;
                    s.pos.set(count,s.pos.get(count)-1);
                }
            }
        }
        else if(right){
            nRight--;
        }
        else if(left){
            nLeft--;
        }
        else{
            nRight = 0;
            nLeft = 0;
        }
        max = false;
        for(int count = 0;count != s.pos.size();count++){
            board.get(s.pos.get(count)).color = s.type;
        }
        for(int count = 0;count != board.size();count++){
            if(board.get(count).color == 0){
                g.setColor(Color.black);
            }
            else if(board.get(count).color == 1){
                g.setColor(Color.blue);
            }
            else if(board.get(count).color == 2){
                g.setColor(Color.red);
            }
            else if(board.get(count).color == 3){
                g.setColor(Color.yellow);
            }
            else if(board.get(count).color == 4){
                g.setColor(Color.green);
            }
            else if(board.get(count).color == 5){
                g.setColor(Color.orange);
            }
            else if(board.get(count).color == 6){
                g.setColor(new Color(128,0,255));
            }
            else if(board.get(count).color == 7){
                g.setColor(new Color(130,210,230));
            }
            g.fillRect(x,y,40,40);
            if(x/40 == 9){
                x = 0; y+=40;
            }
            else{
                x+=40;
            }
        }
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("Level: "+level,450,300);
        g.drawString("Next Piece:",440,50);
        space = ""+score;
        g.setFont(new Font("Arial",Font.BOLD,20));
        for(int count = 8-space.length();count != -1;count--){
            if(count == 8-space.length()){
                space = "";
            }
            space+="0";
        }
        g.drawString("Score: "+space+score,415,250);
            if(nextPiece == 1){
                g.setColor(Color.blue);
                g.fillRect(460,75,80,80);
                g.setColor(Color.white);
                g.drawRect(460,75,40,40);
                g.drawRect(500,75,40,40);
                g.drawRect(460,115,40,40);
                g.drawRect(500,115,40,40);
            }
            else if(nextPiece == 2){
                g.setColor(Color.red);
                g.fillRect(420,75,160,40);
                g.setColor(Color.white);
                g.drawRect(420,75,40,40);
                g.drawRect(460,75,40,40);
                g.drawRect(500,75,40,40);
                g.drawRect(540,75,40,40);
            }
            else if(nextPiece == 3){
                g.setColor(Color.yellow);
                g.fillRect(460,75,40,80);
                g.fillRect(500,115,40,80);
                g.setColor(Color.white);
                g.drawRect(460,75,40,40);
                g.drawRect(460,115,40,40);
                g.drawRect(500,115,40,40);
                g.drawRect(500,155,40,40);
            }
            else if(nextPiece == 4){
                g.setColor(Color.green);
                g.fillRect(460,75,40,120);
                g.fillRect(500,155,40,40);
                g.setColor(Color.white);
                g.drawRect(460,75,40,40);
                g.drawRect(500,155,40,40);
                g.drawRect(460,115,40,40);
                g.drawRect(460,155,40,40);
            }
            else if(nextPiece == 5){
                g.setColor(Color.orange);
                g.fillRect(500,75,40,120);
                g.fillRect(460,155,40,40);
                g.setColor(Color.white);
                g.drawRect(500,75,40,40);
                g.drawRect(460,155,40,40);
                g.drawRect(500,115,40,40);
                g.drawRect(500,155,40,40);
            }
            else if(nextPiece == 6){
                g.setColor(new Color(128,0,255));
                g.fillRect(500,75,40,120);
                g.fillRect(460,115,40,40);
                g.setColor(Color.white);
                g.drawRect(500,75,40,40);
                g.drawRect(460,115,40,40);
                g.drawRect(500,115,40,40);
                g.drawRect(500,155,40,40);
            }
            else if(nextPiece == 7){
                g.setColor(new Color(130,210,230));
                g.fillRect(500,75,40,80);
                g.fillRect(460,115,40,80);
                g.setColor(Color.white);
                g.drawRect(500,75,40,40);
                g.drawRect(500,115,40,40);
                g.drawRect(460,115,40,40);
                g.drawRect(460,155,40,40);
            }
        //
        if(lost){
            g.setFont(new Font("Arial",Font.BOLD,50));
            g.setColor(Color.red);
            g.drawString("You",445,400);
            g.drawString("Lose",435,450);
        }
        if(mDown <= 0 && !lost){
            row = 0;
            if(down && !spawn){
                mDown = 0;
            }
            else{
                mDown = 12-level;
            }
            for(int count = 0;count < s.pos.size();count++){
                if(s.pos.get(count)+10>=230 || (board.get(s.pos.get(count)+10).color != 0 && !s.pos.contains(s.pos.get(count)+10))){
                    if(down){
                        spawn = true;
                    }
                    for(int count2 = 0;count2 < s.pos.size();count2++){
                        board.get(s.pos.get(count2)).color = s.type;
                    }
                    for(int count3 = 0;count3 < board.size();count3++){
                        if(board.get(count3).color == 0){
                            count3 = count3/10*10+9;
                        }
                        else if(count3%(9+count3/10*10) == 0){
                            row++;
                            for(int count4 = count3-9;count4 < count3+1;count4++){
                                board.get(count4).color = 0;
                            }
                            for(int count4 = count3-10;count4 > -1;count4--){
                                board.get(count4+10).color = board.get(count4).color;
                            }
                        }
                    }
                    s = new shape(nextPiece);
                    while(true){
                        r = rand.nextInt(7)+1;
                        if(used.size()!=0&&!(used.contains(r))){
                            if(used.size()==4){
                                used.remove(used.size()-1);
                            }
                            used.add(0,r);
                            break;
                        }
                    }
                    nextPiece = r;
                    for(int count2 = 30;count2 != 40;count2++){
                        if(board.get(count2).color != 0 && !(s.pos.contains(count2))){
                            lost = true;
                        }
                    }
                    break;
                }
            }
            if(row == 1){
                score += 40*level;
            }
            else if(row == 2){
                score += 100*level;
            }
            else if(row == 3){
                score += 300*level;
            }
            else if(row == 4){
                score += 800*level;
            }
            rowC+=row;
            if(rowC/10 == level && level < 10){
                level++;
            }
            for(int count = 0;count != s.pos.size();count++){
                board.get(s.pos.get(count)).color = 0;
            }
            for(int count = 0;count != s.pos.size();count++){
                s.pos.set(count,s.pos.get(count)+10);
            }
        }
        else{
            mDown--;
        }
        x = 0;
        y = -120;
        g.setColor(Color.white);
        for(int count = 0;count != 230;count++){
            g.drawRect(x,y,40,40);
            if(x/40 == 9){
                x = 0; y+=40;
            }
            else{
                x+=40;
            }
        }
        // drawing where piece would go
        move = 0;
        broke = false;
        x = 0;
        y = -120;
        while(true){
            for(int count = 0;count != s.pos.size();count++){
                if(s.pos.get(count)+move+10 >= 230 || (board.get(s.pos.get(count)+move+10).color != 0 && !s.pos.contains(s.pos.get(count)+move+10))){
                    broke = true;
                }
            }
            if(broke){
                break;
            }
            move+=10;
        }
        g.setColor(Color.orange);
        for(int count = 0;count != 230;count++){
            if(s.pos.contains(count-move)){
                g.drawRect(x,y,40,40);
            }
            if(x/40 == 9){
                    x = 0; y+=40;
                }
                else{
                    x+=40;
                }
        }
        }
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}