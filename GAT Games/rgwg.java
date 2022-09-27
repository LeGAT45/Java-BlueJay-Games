import java.util.*;
public class rgwg{
    public static void main(String args[]){
        ArrayList<dice>dice = new ArrayList<dice>();
        dice.add(new dice(3,false));
        dice.add(new dice(6,false));
        dice.add(new dice(5,false));
        dice.add(new dice(4,false));
        dice.add(new dice(4,false));
        ArrayList<Integer>order = new ArrayList<Integer>();
        for(int count = 0;count != 5;count++){
            order.add(0);
        }
        ArrayList<Integer>used = new ArrayList<Integer>();
        for(int count2 = 0;count2 != 5;count2++){
            for(int count = 0;count != 5;count++){
                if(used.size() != 0 && used.contains(count)){
                    continue;
                }
                if(order.get(count2) == 0){
                    order.set(count2,dice.get(count).n);
                    used.add(count);
                }
                else if(order.get(count2)>dice.get(count).n){
                    order.set(count2,dice.get(count).n);
                    used.remove(used.size()-1);
                    used.add(count);
                }
            }
        }
        System.out.println(305%10);
    }
}