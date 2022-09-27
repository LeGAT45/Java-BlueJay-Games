import java.util.*;
public class shape{
    public int type;
    public ArrayList<Integer>pos;
    public int rotate;
    public shape(int type){
        this.type = type;
        rotate = 1;
        pos = new ArrayList<Integer>();
        if(type == 1){
            pos.add(4);
            pos.add(5);
            pos.add(14);
            pos.add(15);
        }
        else if(type == 2){
            pos.add(3);
            pos.add(4);
            pos.add(5);
            pos.add(6);
        }
        else if(type == 3){
            pos.add(4);
            pos.add(14);
            pos.add(15);
            pos.add(25);
        }
        else if(type == 4){
            pos.add(13);
            pos.add(3);
            pos.add(4);
            pos.add(5);
        }
        else if(type == 5){
            pos.add(15);
            pos.add(5);
            pos.add(4);
            pos.add(3);
        }
        else if(type == 6){
            pos.add(4);
            pos.add(13);
            pos.add(14);
            pos.add(15);
        }
        else if(type == 7){
            pos.add(5);
            pos.add(15);
            pos.add(14);
            pos.add(24);
        }
    }
}