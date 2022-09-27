import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
public class twenty48 extends JApplet{
    @Override
    public void init(){
        add(new twenty48_Engine());
    }
}
class twenty48_Engine extends JPanel implements MouseListener, KeyListener{
    // keyListener
    int ch;
    // mouseListener
    int mX;
    int mY;
    // ^^^^^^^^^^^^^
    ArrayList<numberBox> numbers;
    Random rand;
    int x;
    int y;
    int make;
    int inc;
    int sub;
    int row;
    int col;
    boolean create;
    public twenty48_Engine(){
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
        sub = 0;
        numbers = new ArrayList<numberBox>();
        create = false;
        for(int count = 0;count != 16;count++){
            numbers.add(count,new numberBox(0));
        }
        make = rand.nextInt(2)+1;
        if(make == 1){
            numbers.get(rand.nextInt(15)).value = 2;
        }
        else if(make == 2){
            numbers.get(rand.nextInt(15)).value = 4;
        }
        make = rand.nextInt(15);
        while(numbers.get(make).value != 0){
            make = rand.nextInt(15);
        }
        if(rand.nextInt(2)+1 == 2){
            numbers.get(make).value = 2;
        }
        else{
            numbers.get(make).value = 4;
        }
        x = 0;
        y = 0;
        inc = 0;
    }
    // keyListener class methods
    public void keyTyped(KeyEvent k){
    }
    public void keyReleased(KeyEvent k){
    }
    public void keyPressed(KeyEvent k){
        ch = k.getKeyCode();
        create = false;
        if(ch == KeyEvent.VK_UP || ch == KeyEvent.VK_W){
            for(int count = 0;count != 12;count++){
                sub = 0;
                while(true){
                    if(numbers.get(count-sub).value == 0 && numbers.get(count+4-sub).value != 0){
                        numbers.get(count-sub).value = numbers.get(count+4-sub).value;
                        numbers.get(count+4-sub).value = 0;
                        sub += 4;
                        create = true;
                        if(count-sub < 0){
                            break;
                        }
                    }
                    else if(numbers.get(count-sub).value == numbers.get(count+4-sub).value){
                        numbers.get(count-sub).value *= 2;
                        numbers.get(count+4-sub).value = 0;
                        sub += 4;
                        create = true;
                        if(count-sub < 0){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
        else if(ch == KeyEvent.VK_DOWN || ch == KeyEvent.VK_S){
            for(int count = 15;count != 3;count--){
                sub = 0;
                while(true){
                    if(numbers.get(count+sub).value == 0 && numbers.get(count-4+sub).value != 0){
                        numbers.get(count+sub).value = numbers.get(count-4+sub).value;
                        numbers.get(count-4+sub).value = 0;
                        sub += 4;
                        create = true;
                        if(count+sub > 15){
                            break;
                        }
                    }
                    else if(numbers.get(count+sub).value == numbers.get(count-4+sub).value){
                        numbers.get(count+sub).value *= 2;
                        numbers.get(count-4+sub).value = 0;
                        sub += 4;
                        create = true;
                        if(count+sub > 15){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
        else if(ch == KeyEvent.VK_RIGHT || ch == KeyEvent.VK_D){
            col = 3;
            row = 0;
            for(int count = 0;count != 12;count++){
                sub = 0;
                while(true){
                    if(numbers.get(col+sub+row).value == 0 && numbers.get(col-1+sub+row).value != 0){
                        numbers.get(col+sub+row).value = numbers.get(col-1+sub+row).value;
                        numbers.get(col-1+sub+row).value = 0;
                        sub++;
                        create = true;
                        if(col+sub>3){
                            break;
                        }
                    }
                    else if(numbers.get(col+sub+row).value == numbers.get(col-1+sub+row).value){
                        numbers.get(col+sub+row).value *= 2;
                        numbers.get(col-1+sub+row).value = 0;
                        sub++;
                        create = true;
                        if(col+sub>3){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                row+=4;
                if(row == 16){
                    col--;
                    row = 0;
                }
            }
        }
        else if(ch == KeyEvent.VK_LEFT || ch == KeyEvent.VK_A){
            col = 0;
            row = 0;
            for(int count = 0;count != 12;count++){
                sub = 0;
                while(true){
                    if(numbers.get(col-sub+row).value == 0 && numbers.get(col+1-sub+row).value != 0){
                        numbers.get(col-sub+row).value = numbers.get(col+1-sub+row).value;
                        numbers.get(col+1-sub+row).value = 0;
                        sub++;
                        create = true;
                        if(col-sub<0){
                            break;
                        }
                    }
                    else if(numbers.get(col-sub+row).value == numbers.get(col+1-sub+row).value){
                        numbers.get(col-sub+row).value *= 2;
                        numbers.get(col+1-sub+row).value = 0;
                        sub++;
                        create = true;
                        if(col-sub<0){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                row+=4;
                if(row == 16){
                    col++;
                    row = 0;
                }
            }
        }
        else if(ch == KeyEvent.VK_R){
            numbers.clear();
            numbers = new ArrayList<numberBox>();
            create = false;
            for(int count = 0;count != 16;count++){
                numbers.add(count,new numberBox(0));
            }
            make = rand.nextInt(2)+1;
            if(make == 1){
                numbers.get(rand.nextInt(15)).value = 2;
            }
            else if(make == 2){
                numbers.get(rand.nextInt(15)).value = 4;
            }
            make = rand.nextInt(15);
            while(numbers.get(make).value != 0){
                make = rand.nextInt(15);
            }
            if(rand.nextInt(2)+1 == 2){
                numbers.get(make).value = 2;
            }
            else{
                numbers.get(make).value = 4;
            }
        }
        if(create){
            make = rand.nextInt(2)+1;
            if(make == 2){
                while(true){
                    make = rand.nextInt(15); 
                    if(numbers.get(make).value == 0){
                        numbers.get(make).value = 2;
                        break;
                    }
                }
            }
            else if(make == 1){
                while(true){
                    make = rand.nextInt(15); 
                    if(numbers.get(make).value == 0){
                        numbers.get(make).value = 4;
                        break;
                    }
                }
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
        g.setFont(new Font("Arial",Font.BOLD,100));
        for(int count = 0;count != 16;count++){
            if(numbers.get(count).value == 0){
                g.setColor(Color.white);
            }
            else if(numbers.get(count).value == 2){
                g.setColor(new Color(216,221,15));
            }
            else if(numbers.get(count).value == 4){
                g.setColor(new Color(255,142,40));
            }
            else if(numbers.get(count).value == 8){
                g.setColor(new Color(49,213,131));
            }
            else if(numbers.get(count).value == 16){
                g.setColor(new Color(241,43,37));
            }
            else if(numbers.get(count).value == 16){
                g.setColor(new Color(102,245,33));
            }
            else if(numbers.get(count).value == 32){
                g.setColor(new Color(47,101,39));
            }
            else if(numbers.get(count).value == 64){
                g.setColor(new Color(62,243,253));
            }
            else if(numbers.get(count).value == 128){
                g.setColor(new Color(11,29,244));
            }
            else if(numbers.get(count).value == 256){
                g.setColor(new Color(234,21,191));
            }
            else if(numbers.get(count).value == 512){
                g.setColor(new Color(87,30,183));
            }
            else if(numbers.get(count).value == 1024){
                g.setColor(new Color(68,137,145));
            }
            else if(numbers.get(count).value == 2048){
                g.setColor(new Color(114,88,124));
            }
            else{
                g.setColor(Color.black);
            }
            g.fillRect(x+50,y+50,150,150);
            g.setColor(Color.black);
            g.drawRect(x+50,y+50,150,150);
            g.setColor(Color.white);
            if(numbers.get(count).value < 100){
                g.setFont(new Font("Arial",Font.BOLD,100));
            }
            else if(numbers.get(count).value < 1000){
                g.setFont(new Font("Arial",Font.BOLD,80));
            }
            else if(numbers.get(count).value < 10000){
                g.setFont(new Font("Arial",Font.BOLD,65));
            }
            if(numbers.get(count).value < 10){
                g.drawString(""+numbers.get(count).value,x+95,y+155);
            }
            else if(numbers.get(count).value < 100){
                g.drawString(""+numbers.get(count).value,x+65,y+155);
            }
            else if(numbers.get(count).value < 1000){
                g.drawString(""+numbers.get(count).value,x+55,y+155);
            }
            else if(numbers.get(count).value < 10000){
                g.drawString(""+numbers.get(count).value,x+50,y+155);
            }
            x+=150;
            if(x == 600){
                y += 150;
                x = 0;
            }
        }
        y = 0;
        x = 0;
        try{
            Thread.sleep(35);
        }catch(Exception e){}
        repaint();
    }
}