import java.util.*;
import java.awt.*;
public class Board{
    public ArrayList<Piece>Pieces;
    public int turn;
    public int x;
    public int y;
    public boolean p1Win;
    public boolean p2Win;
    ArrayList<Integer>ar = new ArrayList<Integer>();
    public Board(int x, int y){
        this.Pieces = new ArrayList<Piece>();
        Random rand = new Random();
        this.turn = rand.nextInt(2)+1;
        this.x = x;
        this.y = y;
        p1Win = false;
        p2Win = false;
        // sets all pieces to 0
        for(int count = 0;count != 42;count++){
            Pieces.add(0,new Piece(0,false));
        }
    }
    //draws board based on x and y, where (x,y) is the top left corner
    // board is 6 x 7
    public void drawBoard(Graphics g){
        int xTemp = 25;
        int yTemp = 25;
        // draws backdrop for board
        g.setColor(Color.blue);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g.fillRect(x,y,(25*8)+(75*7),(25*7)+(75*6));
        //          rounds corners
        // top left
        g.setColor(Color.white);
        g.fillRect(x,y,50,50);
        g.setColor(Color.blue);
        g.fillOval(x,y,100,100);
        // top right
        g.setColor(Color.white);
        g.fillRect(x+(25*8)+(75*7)-50,y,50,50);
        g.setColor(Color.blue);
        g.fillOval(x+(25*8)+(75*7)-100,y,100,100);
        // bottom left
        g.setColor(Color.white);
        g.fillRect(x,y+(25*7)+(75*6)-50,50,50);
        g.setColor(Color.blue);
        g.fillOval(x,y+(25*7)+(75*6)-100,100,100);
        // bottom right
        g.setColor(Color.white);
        g.fillRect(x+(25*8)+(75*7)-50,y+(25*7)+(75*6)-50,50,50);
        g.setColor(Color.blue);
        g.fillOval(x+(25*8)+(75*7)-100,y+(25*7)+(75*6)-100,100,100);
        //draws all pieces
        for(int count = 0;count != Pieces.size();count++){
            // sets color based on player who owns piece
            if(Pieces.get(count).t == 1){
                g.setColor(Color.red);
            }
            else if(Pieces.get(count).t == 2){
                g.setColor(Color.yellow);
            }
            else{
                g.setColor(Color.white);
            }
            g.fillOval(x+xTemp,y+yTemp,75,75);
            g.setColor(Color.black);
            // numerbing if needed
            g.setFont(new Font("Arial",Font.BOLD,25));
            //g.drawString(""+count,x+xTemp+25,y+yTemp+50);
            // draws piece based on previous pieces and x,y
            if(Pieces.get(count).last){
                g2.setColor(Color.white);
                g2.drawOval(x+xTemp,y+yTemp,75,75);
            }
            // increments draw location along to space out pieces
            if(xTemp == 25+(100*6)){
                xTemp = 25;
                yTemp += 100;
            }
            else{
                xTemp += 100;
            }
        }
    }
    //used to place a piece
    public void move(int r){
        // checks if piece location is already taken up
        while(r+7<42 && Pieces.get(r+7).t == 0){
            r+=7;
        }
        // makes sure its not overriding a piece that already exists
        if(Pieces.get(r).t == 0){
            //changes piece color
            Pieces.get(r).t=turn;
            for(int count = 0;count != Pieces.size();count++){
                Pieces.get(count).last = false;
            }
            Pieces.get(r).last = true;
            //increments turn to next player once move is made
            if(turn == 2){
                turn = 1;
            }
            else{
                turn++;
            }
        }
    }
    //checks if someone has won and changes booleans to tell if they are
    public void win(){
        // detects win when going up and down
        for(int count3 = 1;count3 != 3;count3++){
            for(int count2 = 0;count2 != 7;count2++){
                for(int count = 0;count != 3;count++){
                    if(Pieces.get(count2+(count*7)).t == count3 && Pieces.get(count2+((count+1)*7)).t == count3 && Pieces.get(count2+((count+2)*7)).t == count3 && Pieces.get(count2+((count+3)*7)).t == count3){
                        if(count3 == 1){
                            p1Win = true;
                        }
                        else if(count3 == 2){
                            p2Win = true;
                        }
                        if(p1Win || p2Win){
                            //highlights the pieces which were used to win
                            Pieces.get(count2+((count+0)*7)).last = true;
                            Pieces.get(count2+((count+1)*7)).last = true;
                            Pieces.get(count2+((count+2)*7)).last = true;
                            Pieces.get(count2+((count+3)*7)).last = true;
                        }
                    }
                }
                
            }
        }
        // detects win when going left and right
        for(int count3 = 1;count3 != 3;count3++){
            for(int count2 = 0;count2 != 6;count2++){
                for(int count = 0;count != 4;count++){
                    if(Pieces.get(count+(count2*7)+0).t == count3 && Pieces.get(count+(count2*7)+1).t == count3 && Pieces.get(count+(count2*7)+2).t == count3 && Pieces.get(count+(count2*7)+3).t == count3){
                        if(count3 == 1){
                            p1Win = true;
                        }
                        else if(count3 == 2){
                            p2Win = true;
                        }
                        if(p1Win || p2Win){
                            Pieces.get(count+(count2*7)+0).last = true;
                            Pieces.get(count+(count2*7)+1).last = true;
                            Pieces.get(count+(count2*7)+2).last = true;
                            Pieces.get(count+(count2*7)+3).last = true;
                        }
                    }
                }
            }
        }
        // detects win when going diagonally top left to bottom right   
        for(int count3 = 1;count3 != 3;count3++){
            for(int count2 = 0;count2 != 3;count2++){
                for(int count = 0;count != 4;count++){
                    if(Pieces.get(count+(count2*7)+0).t == count3 && Pieces.get(count+(count2*7)+8).t == count3 && Pieces.get(count+(count2*7)+16).t == count3 && Pieces.get(count+(count2*7)+24).t == count3){
                        if(count3 == 1){
                            p1Win = true;
                        }
                        else if(count3 == 2){
                            p2Win = true;
                        }
                        if(p1Win || p2Win){
                            Pieces.get(count+(count2*7)+0).last = true;
                            Pieces.get(count+(count2*7)+8).last = true;
                            Pieces.get(count+(count2*7)+16).last = true;
                            Pieces.get(count+(count2*7)+24).last = true;
                        }
                    }
                }
            }
        }
        // detects win when going diagonally top right to bottom left   
        for(int count3 = 1;count3 != 3;count3++){
            for(int count2 = 0;count2 != 3;count2++){
                for(int count = 3;count != 7;count++){
                    if(Pieces.get(count+(count2*7)+0).t == count3 && Pieces.get(count+(count2*7)+6).t == count3 && Pieces.get(count+(count2*7)+12).t == count3 && Pieces.get(count+(count2*7)+18).t == count3){
                        if(count3 == 1){
                            p1Win = true;
                        }
                        else if(count3 == 2){
                            p2Win = true;
                        }
                        if(p1Win || p2Win){
                            Pieces.get(count+(count2*7)+0).last = true;
                            Pieces.get(count+(count2*7)+6).last = true;
                            Pieces.get(count+(count2*7)+12).last = true;
                            Pieces.get(count+(count2*7)+18).last = true;
                        }
                    }
                }
            }
        }
    }
    //sets all pieces of the board equal to 0
    public void reset(){
        // resets board
        Pieces.clear();
        for(int count = 0;count != 42;count++){
            Pieces.add(0,new Piece(0,false));
        }
        // whoever lost goes first next time
        if(p1Win){
            turn = 2;
        }
        else if(p2Win){
            turn = 1;
        }
        // sets win = false
        p1Win = false;
        p2Win = false;
    }
    // makes a move based on AI logic
    public void moveAI(){
        int r = 0;
        boolean moved = false;
        int reduce = 0;
        int increase = 0;
        int top = 0;
        int number = 0;
        Random rand = new Random();
        ArrayList<Piece>tPieces = new ArrayList<Piece>();
        ArrayList<Integer>invalid = new ArrayList<Integer>();
        //ArrayList<Integer>ar = new ArrayList<Integer>();
        ar.clear();
        for(int count = 0;count != 7;count++){
            ar.add(0,0);
        }
        ArrayList<Integer>bestMove = new ArrayList<Integer>();
        // checks if other player will win if a piece of their color is placed in a certian collumn
        for(int count3 = 1;count3 != 3;count3++){
            for(int count2 = 0;count2 != 7;count2++){
                tPieces.clear();
                for(int count = 0;count != 42;count++){
                    tPieces.add(0,new Piece(0,false));
                }
                for(int count = 0;count != Pieces.size();count++){
                    if(turn == 2){
                        if(Pieces.get(count).t == 1){
                            tPieces.get(count).t = 2;
                        }
                        else if(Pieces.get(count).t == 2){
                            tPieces.get(count).t = 1;
                        }
                    }
                    else{
                        tPieces.get(count).t = Pieces.get(count).t;
                    }
                }
                r = count2;
                while(r+7<42 && Pieces.get(r+7).t == 0){
                    r+=7;
                }
                if(Pieces.get(r).t == 0){
                    tPieces.get(r).t = count3;
                }
                else{
                    continue;
                }
                for(int count = 0;count != 3;count++){
                    if(tPieces.get(count2+(count*7)).t == count3 && tPieces.get(count2+((count+1)*7)).t == count3 && tPieces.get(count2+((count+2)*7)).t == count3 && tPieces.get(count2+((count+3)*7)).t == count3){
                        if(!moved){
                            move(count2);
                        }
                        moved = true;
                    }
                }
                if(count2<=3){
                    reduce = 3-count2;
                }
                else{
                    reduce = count2-3;
                }
                if(count2 >= 4){
                    increase = count2-3;
                }
                else{
                    increase = 0;
                }
                for(int count = 0;count != 4-reduce;count++){
                    if(tPieces.get((r/7*7)+0+increase+count).t == count3 && tPieces.get((r/7*7)+1+increase+count).t == count3 && tPieces.get((r/7*7)+2+increase+count).t == count3 && tPieces.get((r/7*7)+3+increase+count).t == count3){
                        if(!moved){
                            move(count2);
                        }
                        moved = true;
                    }
                }
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+24-count*8-(r+24-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+16-count*8-(r+16-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+8-count*8-(r+8-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*8)/7*7))<=3 && r+0-(count*8)>=0 && r+0-(count*8) <= 41 && r+8-(count*8)>=0 && r+8-(count*8) <= 41 && r+16-(count*8)>=0 && r+16-(count*8) <= 41 && r+24-(count*8)>=0 && r+24-(count*8) <= 41){
                        if(tPieces.get(r+0-(count*8)).t == count3 && tPieces.get(r+8-(count*8)).t == count3 && tPieces.get(r+16-(count*8)).t == count3 && tPieces.get(r+24-(count*8)).t == count3){
                            if(!moved){
                                move(count2);
                            }
                            moved = true;
                        }
                    }
                    if(Math.abs((r-r/7*7)-(r+18-count*6-(r+18-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+12-count*6-(r+12-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+6-count*6-(r+6-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*6)/7*7))<=3 && r+0-(count*6)>=0 && r+0-(count*6) <= 41 && r+6-(count*6)>=0 && r+6-(count*6) <= 41 && r+12-(count*6)>=0 && r+12-(count*6) <= 41 && r+18-(count*6)>=0 && r+18-(count*6) <= 41){
                        if(tPieces.get(r+0-(count*6)).t == count3 && tPieces.get(r+6-(count*6)).t == count3 && tPieces.get(r+12-(count*6)).t == count3 && tPieces.get(r+18-(count*6)).t == count3){
                            if(!moved){
                                move(count2);
                            }
                            moved = true;
                        }
                    }
                }
            }
        }
        // invalid
        for(int count3 = 2;count3 != 3;count3++){
            for(int count2 = 0;count2 != 7;count2++){
                tPieces.clear();
                for(int count = 0;count != 42;count++){
                    tPieces.add(0,new Piece(0,false));
                }
                for(int count = 0;count != Pieces.size();count++){
                    if(turn == 2){
                        if(Pieces.get(count).t == 1){
                            tPieces.get(count).t = 2;
                        }
                        else if(Pieces.get(count).t == 2){
                            tPieces.get(count).t = 1;
                        }
                    }
                    else{
                        tPieces.get(count).t = Pieces.get(count).t;
                    }
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 1;
                }
                else{
                    continue;
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 2;
                }
                else{
                    continue;
                }
                for(int count = 0;count != 3;count++){
                    if(tPieces.get(count2+(count*7)).t == count3 && tPieces.get(count2+((count+1)*7)).t == count3 && tPieces.get(count2+((count+2)*7)).t == count3 && tPieces.get(count2+((count+3)*7)).t == count3){
                        if(!invalid.contains(r+7)){
                            invalid.add(r+7);
                        }
                    }
                }
                if(count2<=3){
                    reduce = 3-count2;
                }
                else{
                    reduce = count2-3;
                }
                if(count2 >= 4){
                    increase = count2-3;
                }
                else{
                    increase = 0;
                }
                for(int count = 0;count != 4-reduce;count++){
                    if(tPieces.get((r/7*7)+0+increase+count).t == count3 && tPieces.get((r/7*7)+1+increase+count).t == count3 && tPieces.get((r/7*7)+2+increase+count).t == count3 && tPieces.get((r/7*7)+3+increase+count).t == count3){
                        if(!invalid.contains(r+7)){
                            invalid.add(r+7);
                        }
                    }
                }
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+24-count*8-(r+24-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+16-count*8-(r+16-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+8-count*8-(r+8-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*8)/7*7))<=3 && r+0-(count*8)>=0 && r+0-(count*8) <= 41 && r+8-(count*8)>=0 && r+8-(count*8) <= 41 && r+16-(count*8)>=0 && r+16-(count*8) <= 41 && r+24-(count*8)>=0 && r+24-(count*8) <= 41){
                        if(tPieces.get(r+0-(count*8)).t == count3 && tPieces.get(r+8-(count*8)).t == count3 && tPieces.get(r+16-(count*8)).t == count3 && tPieces.get(r+24-(count*8)).t == count3){
                            if(!invalid.contains(r+7)){
                                invalid.add(r+7);
                            }
                        }
                    }
                    if(Math.abs((r-r/7*7)-(r+18-count*6-(r+18-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+12-count*6-(r+12-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+6-count*6-(r+6-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*6)/7*7))<=3 && r+0-(count*6)>=0 && r+0-(count*6) <= 41 && r+6-(count*6)>=0 && r+6-(count*6) <= 41 && r+12-(count*6)>=0 && r+12-(count*6) <= 41 && r+18-(count*6)>=0 && r+18-(count*6) <= 41){
                        if(tPieces.get(r+0-(count*6)).t == count3 && tPieces.get(r+6-(count*6)).t == count3 && tPieces.get(r+12-(count*6)).t == count3 && tPieces.get(r+18-(count*6)).t == count3){
                            if(!invalid.contains(r+7)){
                                invalid.add(r+7);
                            }
                        }
                    }
                }
            }
        }
        //rates every move with an attack rating
            for(int count2 = 0;count2 != 7;count2++){
                tPieces.clear();
                for(int count = 0;count != 42;count++){
                    tPieces.add(0,new Piece(0,false));
                }
                for(int count = 0;count != Pieces.size();count++){
                    if(turn == 2){
                        if(Pieces.get(count).t == 1){
                            tPieces.get(count).t = 2;
                        }
                        else if(Pieces.get(count).t == 2){
                            tPieces.get(count).t = 1;
                        }
                    }
                    else{
                        tPieces.get(count).t = Pieces.get(count).t;
                    }
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 1;
                }
                else{
                    ar.set(count2,-1000);
                    continue;
                }
                // detetecs diagonals br to tl
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+24-count*8-(r+24-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+16-count*8-(r+16-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+8-count*8-(r+8-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*8)/7*7))<=3 && r+0-(count*8)>=0 && r+0-(count*8) <= 41 && r+8-(count*8)>=0 && r+8-(count*8) <= 41 && r+16-(count*8)>=0 && r+16-(count*8) <= 41 && r+24-(count*8)>=0 && r+24-(count*8) <= 41 && tPieces.get(r+0-(count*8)).t != 2 && tPieces.get(r+8-(count*8)).t != 2 && tPieces.get(r+16-(count*8)).t != 2 && tPieces.get(r+24-(count*8)).t != 2){
                        number = 0;
                        if(tPieces.get(r+0-(count*8)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+8-(count*8)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+16-(count*8)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+24-(count*8)).t == 1){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+15);
                        }
                        if(number == 1){
                            ar.set(count2,ar.get(count2)+1);
                        }
                    }
                }
                // detetecs diagonals bl to tr
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+18-count*6-(r+18-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+12-count*6-(r+12-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+6-count*6-(r+6-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*6)/7*7))<=3 && r+0-(count*6)>=0 && r+0-(count*6) <= 41 && r+6-(count*6)>=0 && r+6-(count*6) <= 41 && r+12-(count*6)>=0 && r+12-(count*6) <= 41 && r+18-(count*6)>=0 && r+18-(count*6) <= 41 && tPieces.get(r+0-(count*6)).t != 2 && tPieces.get(r+6-(count*6)).t != 2 && tPieces.get(r+12-(count*6)).t != 2 && tPieces.get(r+18-(count*6)).t != 2){
                        number = 0;
                        if(tPieces.get(r+0-(count*6)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+6-(count*6)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+12-(count*6)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+18-(count*6)).t == 1){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+15);
                        }
                        if(number == 1){
                            ar.set(count2,ar.get(count2)+1);
                        }
                    }
                }
                // detects horizontal
                for(int count = 0;count != 4;count++){
                    if(r-3+count>=(r/7*7)&&r+count<(r/7*7)+7&&r-3+count>=0 && r-3+count <= 41 && r-2+count>=0 && r-2+count <= 41 && r-1+count>=0 && r-1+count <= 41 && r+0+count>=0 && r+0+count <= 41 && tPieces.get(r-3+count).t != 2 && tPieces.get(r-2+count).t != 2 && tPieces.get(r-1+count).t != 2 && tPieces.get(r+count).t != 2){
                        number = 0;
                        if(tPieces.get(r-3+count).t == 1){
                            number++;
                        }
                        if(tPieces.get(r-2+count).t == 1){
                            number++;
                        }
                        if(tPieces.get(r-1+count).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+count).t == 1){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+15);
                        }
                        if(number == 1){
                            ar.set(count2,ar.get(count2)+1);
                        }
                    }
                }
                // detects vertical
                for(int count = 0;count != 4;count++){
                    if(r+21-(count*7)>=0 && r+21-(count*7) <= 41 && r+14-(count*7)>=0 && r+14-(count*7) <= 41 && r+7-(count*7)>=0 && r+7-(count*7) <= 41 && r+0-(count*7)>=0 && r+0-(count*7) <= 41 && tPieces.get(r+21-(count*7)).t != 2 && tPieces.get(r+14-(count*7)).t != 2 && tPieces.get(r+7-(count*7)).t != 2 && tPieces.get(r+0-(count*7)).t != 2){
                        number = 0;
                        if(tPieces.get(r+21-(count*7)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+14-(count*7)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+7-(count*7)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+0-(count*7)).t == 1){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+15);
                        }
                        if(number == 1){
                            ar.set(count2,ar.get(count2)+1);
                        }
                    }
                }
            }
            // detects blocking moves for AR
            for(int count2 = 0;count2 != 7;count2++){
                tPieces.clear();
                for(int count = 0;count != 42;count++){
                    tPieces.add(0,new Piece(0,false));
                }
                for(int count = 0;count != Pieces.size();count++){
                    if(turn == 2){
                        if(Pieces.get(count).t == 1){
                            tPieces.get(count).t = 2;
                        }
                        else if(Pieces.get(count).t == 2){
                            tPieces.get(count).t = 1;
                        }
                    }
                    else{
                        tPieces.get(count).t = Pieces.get(count).t;
                    }
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 2;
                }
                else{
                    ar.set(count2,-1000);
                    continue;
                }
                // detetecs diagonals br to tl
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+24-count*8-(r+24-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+16-count*8-(r+16-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+8-count*8-(r+8-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*8)/7*7))<=3 && r+0-(count*8)>=0 && r+0-(count*8) <= 41 && r+8-(count*8)>=0 && r+8-(count*8) <= 41 && r+16-(count*8)>=0 && r+16-(count*8) <= 41 && r+24-(count*8)>=0 && r+24-(count*8) <= 41 && tPieces.get(r+0-(count*8)).t != 1 && tPieces.get(r+8-(count*8)).t != 1 && tPieces.get(r+16-(count*8)).t != 1 && tPieces.get(r+24-(count*8)).t != 1){
                        number = 0;
                        if(tPieces.get(r+0-(count*8)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+8-(count*8)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+16-(count*8)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+24-(count*8)).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+50);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+5);
                        }
                    }
                }
                // detetecs diagonals bl to tr
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+18-count*6-(r+18-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+12-count*6-(r+12-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+6-count*6-(r+6-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*6)/7*7))<=3 && r+0-(count*6)>=0 && r+0-(count*6) <= 41 && r+6-(count*6)>=0 && r+6-(count*6) <= 41 && r+12-(count*6)>=0 && r+12-(count*6) <= 41 && r+18-(count*6)>=0 && r+18-(count*6) <= 41 && tPieces.get(r+0-(count*6)).t != 1 && tPieces.get(r+6-(count*6)).t != 1 && tPieces.get(r+12-(count*6)).t != 1 && tPieces.get(r+18-(count*6)).t != 1){
                        number = 0;
                        if(tPieces.get(r+0-(count*6)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+6-(count*6)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+12-(count*6)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+18-(count*6)).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+50);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+5);
                        }
                    }
                }
                // detects horizontal
                for(int count = 0;count != 4;count++){
                    if(r-3+count>=(r/7*7)&&r+count<(r/7*7)+7&&r-3+count>=0 && r-3+count <= 41 && r-2+count>=0 && r-2+count <= 41 && r-1+count>=0 && r-1+count <= 41 && r+0+count>=0 && r+0+count <= 41 && tPieces.get(r-3+count).t != 1 && tPieces.get(r-2+count).t != 1 && tPieces.get(r-1+count).t != 1 && tPieces.get(r+count).t != 1){
                        number = 0;
                        if(tPieces.get(r-3+count).t == 2){
                            number++;
                        }
                        if(tPieces.get(r-2+count).t == 2){
                            number++;
                        }
                        if(tPieces.get(r-1+count).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+count).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+50);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+5);
                        }
                    }
                }
                // detects vertical
                for(int count = 0;count != 4;count++){
                    if(r+21-(count*7)>=0 && r+21-(count*7) <= 41 && r+14-(count*7)>=0 && r+14-(count*7) <= 41 && r+7-(count*7)>=0 && r+7-(count*7) <= 41 && r+0-(count*7)>=0 && r+0-(count*7) <= 41 && tPieces.get(r+21-(count*7)).t != 1 && tPieces.get(r+14-(count*7)).t != 1 && tPieces.get(r+7-(count*7)).t != 1 && tPieces.get(r+0-(count*7)).t != 1){
                        number = 0;
                        if(tPieces.get(r+21-(count*7)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+14-(count*7)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+7-(count*7)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+0-(count*7)).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)+20);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)+2);
                        }
                    }
                }
            }
            // detects setting up moves for AR
            for(int count2 = 0;count2 != 7;count2++){
                tPieces.clear();
                for(int count = 0;count != 42;count++){
                    tPieces.add(0,new Piece(0,false));
                }
                for(int count = 0;count != Pieces.size();count++){
                    if(turn == 2){
                        if(Pieces.get(count).t == 1){
                            tPieces.get(count).t = 2;
                        }
                        else if(Pieces.get(count).t == 2){
                            tPieces.get(count).t = 1;
                        }
                    }
                    else{
                        tPieces.get(count).t = Pieces.get(count).t;
                    }
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 1;
                }
                else{
                    continue;
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 2;
                }
                else{
                    continue;
                }
                // detetecs diagonals br to tl
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+24-count*8-(r+24-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+16-count*8-(r+16-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+8-count*8-(r+8-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*8)/7*7))<=3 && r+0-(count*8)>=0 && r+0-(count*8) <= 41 && r+8-(count*8)>=0 && r+8-(count*8) <= 41 && r+16-(count*8)>=0 && r+16-(count*8) <= 41 && r+24-(count*8)>=0 && r+24-(count*8) <= 41 && tPieces.get(r+0-(count*8)).t != 1 && tPieces.get(r+8-(count*8)).t != 1 && tPieces.get(r+16-(count*8)).t != 1 && tPieces.get(r+24-(count*8)).t != 1){
                        number = 0;
                        if(tPieces.get(r+0-(count*8)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+8-(count*8)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+16-(count*8)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+24-(count*8)).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)-100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)-10);
                        }
                    }
                }
                // detetecs diagonals bl to tr
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+18-count*6-(r+18-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+12-count*6-(r+12-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+6-count*6-(r+6-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*6)/7*7))<=3 && r+0-(count*6)>=0 && r+0-(count*6) <= 41 && r+6-(count*6)>=0 && r+6-(count*6) <= 41 && r+12-(count*6)>=0 && r+12-(count*6) <= 41 && r+18-(count*6)>=0 && r+18-(count*6) <= 41 && tPieces.get(r+0-(count*6)).t != 1 && tPieces.get(r+6-(count*6)).t != 1 && tPieces.get(r+12-(count*6)).t != 1 && tPieces.get(r+18-(count*6)).t != 1){
                        number = 0;
                        if(tPieces.get(r+0-(count*6)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+6-(count*6)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+12-(count*6)).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+18-(count*6)).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)-100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)-10);
                        }
                    }
                }
                // detects horizontal
                for(int count = 0;count != 4;count++){
                    if(r-3+count>=(r/7*7)&&r+count<(r/7*7)+7&&r-3+count>=0 && r-3+count <= 41 && r-2+count>=0 && r-2+count <= 41 && r-1+count>=0 && r-1+count <= 41 && r+0+count>=0 && r+0+count <= 41 && tPieces.get(r-3+count).t != 1 && tPieces.get(r-2+count).t != 1 && tPieces.get(r-1+count).t != 1 && tPieces.get(r+count).t != 1){
                        number = 0;
                        if(tPieces.get(r-3+count).t == 2){
                            number++;
                        }
                        if(tPieces.get(r-2+count).t == 2){
                            number++;
                        }
                        if(tPieces.get(r-1+count).t == 2){
                            number++;
                        }
                        if(tPieces.get(r+count).t == 2){
                            number++;
                        }
                        if(number == 3){
                            ar.set(count2,ar.get(count2)-100);
                        }
                        if(number == 2){
                            ar.set(count2,ar.get(count2)-10);
                        }
                    }
                }
            }
            // anti cb
            for(int count2 = 0;count2 != 7;count2++){
                tPieces.clear();
                for(int count = 0;count != 42;count++){
                    tPieces.add(0,new Piece(0,false));
                }
                for(int count = 0;count != Pieces.size();count++){
                    if(turn == 2){
                        if(Pieces.get(count).t == 1){
                            tPieces.get(count).t = 2;
                        }
                        else if(Pieces.get(count).t == 2){
                            tPieces.get(count).t = 1;
                        }
                    }
                    else{
                        tPieces.get(count).t = Pieces.get(count).t;
                    }
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 1;
                }
                else{
                    continue;
                }
                r = count2;
                while(r+7<42 && tPieces.get(r+7).t == 0){
                    r+=7;
                }
                if(tPieces.get(r).t == 0){
                    tPieces.get(r).t = 1;
                }
                else{
                    continue;
                }
                // detetecs diagonals br to tl
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+24-count*8-(r+24-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+16-count*8-(r+16-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+8-count*8-(r+8-count*8)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*8)/7*7))<=3 && r+0-(count*8)>=0 && r+0-(count*8) <= 41 && r+8-(count*8)>=0 && r+8-(count*8) <= 41 && r+16-(count*8)>=0 && r+16-(count*8) <= 41 && r+24-(count*8)>=0 && r+24-(count*8) <= 41 && tPieces.get(r+0-(count*8)).t != 2 && tPieces.get(r+8-(count*8)).t != 2 && tPieces.get(r+16-(count*8)).t != 2 && tPieces.get(r+24-(count*8)).t != 2){
                        number = 0;
                        if(tPieces.get(r+0-(count*8)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+8-(count*8)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+16-(count*8)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+24-(count*8)).t == 1){
                            number++;
                        }
                        if(number == 4){
                            ar.set(count2,ar.get(count2)-500);
                        }
                    }
                }
                // detetecs diagonals bl to tr
                for(int count = 0;count != 4;count++){
                    if(Math.abs((r-r/7*7)-(r+18-count*6-(r+18-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+12-count*6-(r+12-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+6-count*6-(r+6-count*6)/7*7))<=3 && Math.abs((r-r/7*7)-(r+0-count*8-(r+0-count*6)/7*7))<=3 && r+0-(count*6)>=0 && r+0-(count*6) <= 41 && r+6-(count*6)>=0 && r+6-(count*6) <= 41 && r+12-(count*6)>=0 && r+12-(count*6) <= 41 && r+18-(count*6)>=0 && r+18-(count*6) <= 41 && tPieces.get(r+0-(count*6)).t != 2 && tPieces.get(r+6-(count*6)).t != 2 && tPieces.get(r+12-(count*6)).t != 2 && tPieces.get(r+18-(count*6)).t != 2){
                        number = 0;
                        if(tPieces.get(r+0-(count*6)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+6-(count*6)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+12-(count*6)).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+18-(count*6)).t == 1){
                            number++;
                        }
                        if(number == 4){
                            ar.set(count2,ar.get(count2)-500);
                        }
                    }
                }
                // detects horizontal
                for(int count = 0;count != 4;count++){
                    if(r-3+count>=(r/7*7)&&r+count<(r/7*7)+7&&r-3+count>=0 && r-3+count <= 41 && r-2+count>=0 && r-2+count <= 41 && r-1+count>=0 && r-1+count <= 41 && r+0+count>=0 && r+0+count <= 41 && tPieces.get(r-3+count).t != 2 && tPieces.get(r-2+count).t != 2 && tPieces.get(r-1+count).t != 2 && tPieces.get(r+count).t != 2){
                        number = 0;
                        if(tPieces.get(r-3+count).t == 1){
                            number++;
                        }
                        if(tPieces.get(r-2+count).t == 1){
                            number++;
                        }
                        if(tPieces.get(r-1+count).t == 1){
                            number++;
                        }
                        if(tPieces.get(r+count).t == 1){
                            number++;
                        }
                        if(number == 4){
                            ar.set(count2,ar.get(count2)-500);
                        }
                    }
                }
            }
        for(int count = 0;count != 7;count++){
            if(ar.get(count) == -1000){
                continue;
            }
            else if(bestMove.size()==0){
                bestMove.add(count);
            }
            else if(ar.get(count)>ar.get(bestMove.get(0))){
                bestMove.clear();
                bestMove.add(count);
            }
            else if(ar.get(count)==ar.get(bestMove.get(0))){
                bestMove.add(count);
            }
        }
        for(int count = 0;count != invalid.size();count++){
            for(int count2 = bestMove.size()-1;count2 != -1;count2--){
                if(invalid.get(count)-invalid.get(count)/7*7 == bestMove.get(count2)){
                    bestMove.remove(count2);
                }
            }
        }
        //randomly chooses piece if no invalid spots exist and only chooses best move
        while(!moved){
            r = rand.nextInt(7);
            if(bestMove.size()!=0){
                while(!bestMove.contains(r)){
                    r = rand.nextInt(7);
                }
            }
            while(r+7<42 && Pieces.get(r+7).t == 0){
                r+=7;
            }
            top = 0;
            for(int count = 0;count != 7;count++){
                if(Pieces.get(count).t != 0){
                    top++;
                }
            }
            /*for(int count = invalid.size()-1;count != -1;count--){
                if(Pieces.get(invalid.get(count)).t != 0){
                    invalid.remove(count);
                }
            }*/
            if(!invalid.contains(r)){
                move(r);
                moved = true;
            }
            else if(invalid.contains(r)&&invalid.size()>=7-top){
                r = rand.nextInt(7);
                while(r+7<42 && Pieces.get(r+7).t == 0){
                    r+=7;
                }
                move(r);
                moved = true;
            }
        }
    }
}