import java.util.*;
public class seating_chart{
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        System.out.println('\u000c' + "How many are in your row?");
        int option = kb.nextInt();
        String seat[] = new String[option];
        System.out.println('\u000c' + "Would you like to name them?\n1 = yes\n2 = no");
        int yes = kb.nextInt();
        if(yes == 1){
            for(int count = 0;count != option;count++){
                System.out.println('\u000c' + "Please enter the name of the person who sits in seat "+(1+count)+":");
                seat[count] = kb.next();
            }
            System.out.println('\u000c' + "Your seating chart:\n");
            for(int count = 0;count != option;count++){
                System.out.println("Seat "+(1+count)+": "+seat[count]+"\n");
            }
        }
    }
}