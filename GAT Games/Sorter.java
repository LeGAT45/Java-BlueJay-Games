import java.util.*;
public class Sorter{
    public ArrayList<Bot> sort(ArrayList<Bot>bot,Goal goal){
        ArrayList<Bot>tempBot = new ArrayList<Bot>();
        ArrayList<Bot>used = new ArrayList<Bot>();
        Bot min = new Bot(1000000,100000000);
        for(int count = 0;count != bot.size();count++){
            if((goal.fitness(min)<goal.fitness(bot.get(count)) && !used.contains(bot.get(count)))){
                min = bot.get(count);
            }
        }
        for(int count = 0;count != bot.size();count++){
            if(goal.fitness(min)==goal.fitness(bot.get(count))){
                used.add(bot.get(count));
                tempBot.add(0,bot.get(count));
            }
        }
        return tempBot;
    }
}