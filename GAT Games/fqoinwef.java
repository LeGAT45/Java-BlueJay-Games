public class fqoinwef{
    public static void main(String args[]){
        int[][]m = {{1,2,3},{4,5,6},{7,8,9}};
        for(int count = 0;count != m.length;count++){
            for(int count2 = 0;count2 != m[count].length;count2++){
                if(m[count][count2]%2 == 1){
                    m[count][count2] -= 1;
                }
                System.out.print(m[count][count2]);
            }
            System.out.print("\n");
        }
    }
}