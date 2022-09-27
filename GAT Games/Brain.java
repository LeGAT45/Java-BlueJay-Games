import java.util.*;
public class Brain{
    public ArrayList<Integer>directions;
    public int step;
    int size;
    public Brain(int size){
        Random rand = new Random();
        step = 0;
        this.size = size;
        directions = new ArrayList<Integer>();
        for(int count = 0;count != size;count++){
            directions.add(rand.nextInt(360));
        }
    }
    public void mutate(){
        Random rand = new Random();
        for(int count = 0;count < size/2;count++){
            directions.set(rand.nextInt(size-1),rand.nextInt(360));
        }
    }
}