import java.util.*;
public class swap{
    public static void main(String args[]){
        int util [][] = {{1,2,3},{4,5,6},{7,8,9}};
        int swap [][] = new int[util.length][util[0].length];
        int down;
        // prints out un reversed arraylist
        for(int count = 0;count != util.length;count++){
            for(int count2 = 0;count2 != util[count].length;count2++){
                System.out.print(util[count][count2] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        // reverses the arraylist
        for(int count = 0;count != util.length;count++){
            down = util[count].length-1;
            for(int count2 = 0;count2 != util[count].length;count2++){
                swap[count][count2] = util[count][down];
                down--;
            }
        }
        // prints reversed arraylist
        for(int count = 0;count != swap.length;count++){
            for(int count2 = 0;count2 != swap[count].length;count2++){
                System.out.print(swap[count][count2] + " ");
            }
            System.out.print("\n");
        }
    }
}