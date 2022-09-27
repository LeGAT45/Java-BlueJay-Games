import java.awt.*;
public class twod{
    public static void main(String agrs[]){
        int twod[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int twor[][] = new int[3][3];
        // printing out array list in correct order
        for(int count = 0;count != twod.length;count++){
            for(int count2 = 0;count2 != twod[count].length;count2++){
                System.out.print(twod[count][count2]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        // reversing arraylist
        for(int count = twod.length-1;count != -1;count--){
            for(int count2 = twod[count].length-1;count2 != -1;count2--){
                twor[count][count2] = twod[count2][count];
            }
        }
        // printing reversed arraylist
        for(int count = 0;count != twod.length;count++){
            for(int count2 = 0;count2 != twod[count].length;count2++){
                System.out.print(twor[count][count2]+" ");
            }
            System.out.print("\n");
        }
    }
}