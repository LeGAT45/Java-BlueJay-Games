public class efojifeqwnuf{
    public static void main(String args[]){
        String s = "sdoih[ewfgoijhnnoijdfoinjasdf";
        String[] strang = new String[s.length()];
        for(int count = 0;count != s.length();count++){
            strang[count] = s.substring(count,count+1);
        }
        for(int count = 0;count != strang.length;count++){
            System.out.println(strang[count]);
        }
    }
}