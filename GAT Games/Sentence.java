import java.util.*;
public class Sentence{
    private String s;
    public Sentence(String s){
        this.s = s;//
    }
    public ArrayList<Integer> getBlankPositions(){
        ArrayList<Integer>re = new ArrayList<Integer>();
        for(int count = 0;count != s.length();count++){
            if(s.substring(count,count+1).equals(" ")){
                re.add(count);
            }
        }
        return re;
    }
    public ArrayList<String> separate(ArrayList<Integer> blank){
        ArrayList<String> re = new ArrayList<String>();
        for(int count = 0;count != blank.size();count++){
            if(count == 0){
                re.add(s.substring(0,blank.get(count)));
            }
            else{
                re.add(s.substring(1+blank.get(count-1),blank.get(count)));
            }
            if(count == blank.size()-1){
                re.add(s.substring(1+blank.get(count),s.length()));
            }
        }
        return re;
    }
}