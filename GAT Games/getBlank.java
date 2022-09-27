import java.util.*;
public class getBlank{
    public static void main(String args[]){
        String test = "I like to eat apples";
        Sentence s1 = new Sentence(test);
        System.out.println("The blank positions are at: "+s1.getBlankPositions());
        System.out.println("Number of words: "+s1.separate(s1.getBlankPositions()).size());
        System.out.println("The words in the string are: "+s1.separate(s1.getBlankPositions()));
    }
}