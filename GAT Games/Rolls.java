import java.util.*;
public class Rolls{
    public int threeOfaKind;
    public int fourOfaKind;
    public int fullHouse;
    public int smStraight;
    public int lgStraight;
    public int yahtzee;
    public int chance;
    public int one;
    public int two;
    public int three;
    public int four;
    public int five;
    public int six;
    public Rolls(int threeOfaKind,int fourOfaKind,int fullHouse,int smStraight,int lgStraight,int yahtzee, int chance, int one, int two, int three, int four, int five, int six){
        this.threeOfaKind = threeOfaKind;
        this.fourOfaKind = fourOfaKind;
        this.fullHouse = fullHouse;
        this.smStraight = smStraight;
        this.lgStraight = lgStraight;
        this.yahtzee = yahtzee;
        this.chance = chance;
        this.one =  one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }
    public int score(){
        return threeOfaKind+fourOfaKind+fullHouse+smStraight+lgStraight+yahtzee+chance+one+two+three+four+five+six;
    }
    public void one(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 1){
                one++;
            }
        }
        if(one == 0){
            one = -1;
        }
    }
    public void two(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 2){
                two+=2;
            }
        }
        if(two == 0){
            two = -1;
        }
    }
    public void three(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 3){
                three += 3;
            }
        }
        if(three == 0){
            three = -1;
        }
    }
    public void four(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 4){
                four += 4;
            }
        }
        if(four == 0){
            four = -1;
        }
    }
    public void five(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 5){
                five += 5;
            }
        }
        if(five == 0){
            five = -1;
        }
    }
    public void six(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 6){
                six += 6;
            }
        }
        if(six == 0){
            six = -1;
        }
    }
    public void threeOfaKind(ArrayList<dice>dice){
        int one_ = 0;
        int two_ = 0;
        int three_ = 0;
        int four_ = 0;
        int five_ = 0;
        int six_ = 0;
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 1){
                one_++;
            }
            else if(dice.get(count).n == 2){
                two_++;
            }
            else if(dice.get(count).n == 3){
                three_++;
            }
            else if(dice.get(count).n == 4){
                four_++;
            }
            else if(dice.get(count).n == 5){
                five_++;
            }
            else if(dice.get(count).n == 6){
                six_++;
            }
        }
        if(one_ >= 3){
            threeOfaKind = 20;
        }
        else if(two_ >= 3){
            threeOfaKind = 20;
        }
        else if(three_ >= 3){
            threeOfaKind = 20;
        }
        else if(four_ >= 3){
            threeOfaKind = 20;
        }
        else if(five_ >= 3){
            threeOfaKind = 20;
        }
        else if(six_ >= 3){
            threeOfaKind = 20;
        }
        else{
            threeOfaKind = -1;
        }
    }
    public void fourOfaKind(ArrayList<dice>dice){
        int one_ = 0;
        int two_ = 0;
        int three_ = 0;
        int four_ = 0;
        int five_ = 0;
        int six_ = 0;
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 1){
                one_++;
            }
            else if(dice.get(count).n == 2){
                two_++;
            }
            else if(dice.get(count).n == 3){
                three_++;
            }
            else if(dice.get(count).n == 4){
                four_++;
            }
            else if(dice.get(count).n == 5){
                five_++;
            }
            else if(dice.get(count).n == 6){
                six_++;
            }
        }
        if(one_ >= 4){
            fourOfaKind = 35;
        }
        else if(two_ >= 4){
            fourOfaKind = 35;
        }
        else if(three_ >= 4){
            fourOfaKind = 35;
        }
        else if(four_ >= 4){
            fourOfaKind = 35;
        }
        else if(five_ >= 4){
            fourOfaKind = 35;
        }
        else if(six_ >= 4){
            fourOfaKind = 35;
        }
        else{
            fourOfaKind = -1;
        }
    }
    public void fullHouse(ArrayList<dice>dice){
        int one_ = 0;
        int two_ = 0;
        int three_ = 0;
        int four_ = 0;
        int five_ = 0;
        int six_ = 0;
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 1){
                one_++;
            }
            else if(dice.get(count).n == 2){
                two_++;
            }
            else if(dice.get(count).n == 3){
                three_++;
            }
            else if(dice.get(count).n == 4){
                four_++;
            }
            else if(dice.get(count).n == 5){
                five_++;
            }
            else if(dice.get(count).n == 6){
                six_++;
            }
        }
        if(one_ == 3){
            one_ = 3;
        }
        else if(one_ == 2){
            one_ = 2;
        }
        else if(two_ == 3){
            two_ = 3;
        }
        else if(two_ == 2){
            two_ = 2;
        }
        else if(three_ == 3){
            three_ = 3;
        }
        else if(three_ == 2){
            three_ = 2;
        }
        else if(four_ == 3){
            four_ = 3;
        }
        else if(four_ == 2){
            four_ = 2;
        }
        else if(five_ == 3){
            five_ = 3;
        }
        else if(five_ == 2){
            five_ = 2;
        }
        else if(six_ == 3){
            six_ = 3;
        }
        else if(six_ == 2){
            six_ = 2;
        }
        if(one_+two_+three_+four_+five_+six_ == 5){
            fullHouse = 25;
        }
        else{
            fullHouse = -1;
        }
    }
    public void chance(ArrayList<dice>dice){
        for(int count = 0;count != dice.size();count++){
            chance += dice.get(count).n;
        }
    }
    public void yahtzee(ArrayList<dice>dice){
        int one_ = 0;
        int two_ = 0;
        int three_ = 0;
        int four_ = 0;
        int five_ = 0;
        int six_ = 0;
        for(int count = 0;count != dice.size();count++){
            if(dice.get(count).n == 1){
                one_++;
            }
            else if(dice.get(count).n == 2){
                two_++;
            }
            else if(dice.get(count).n == 3){
                three_++;
            }
            else if(dice.get(count).n == 4){
                four_++;
            }
            else if(dice.get(count).n == 5){
                five_++;
            }
            else if(dice.get(count).n == 6){
                six_++;
            }
        }
        if(one_ >= 5){
            yahtzee = 50;
        }
        else if(two_ >= 5){
            yahtzee = 50;
        }
        else if(three_ >= 5){
            yahtzee = 50;
        }
        else if(four_ >= 5){
            yahtzee = 50;
        }
        else if(five_ >= 5){
            yahtzee = 50;
        }
        else if(six_ >= 5){
            yahtzee = 50;
        }
        else{
            yahtzee = -1;
        }
    }
    public void smStraight(ArrayList<dice>dice){
        int one_ = 0;
        int two_ = 0;
        int three_ = 0;
        int four_ = 0;
        int five_ = 0;
        int six_ = 0;
        int inc = 0;
        boolean nope = false;
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
        for(int count = 0;count != 5;count++){
            if(order.get(count) == 1){
                one_++;
            }
            else if(order.get(count) == 2){
                two_++;
            }
            else if(order.get(count) == 3){
                three_++;
            }
            else if(order.get(count) == 4){
                four_++;
            }
            else if(order.get(count) == 5){
                five_++;
            }
            else if(order.get(count) == 6){
                six_++;
            }
        }
        for(int count = 0;count != 5;count++){
            if(order.size() == 5){
            if(one_ == 2 && order.get(count) == 1){
                order.remove(count);
            }
            else if(two_ == 2 && order.get(count) == 2){
                order.remove(count);
            }
            else if(three_ == 2 && order.get(count) == 3){
                order.remove(count);
            }
            else if(four_ == 2 && order.get(count) == 4){
                order.remove(count);
            }
            else if(five_ == 2 && order.get(count) == 5){
                order.remove(count);
            }
            else if(six_ == 2 && order.get(count) == 6){
                order.remove(count);
            }
            }
        }
        if(order.get(0) == 1 || order.get(0) == 2 || order.get(0) == 3){
            for(int count = order.get(0);count != order.get(0)+4;count++){
                if(order.get(inc) != count){
                    nope = true;
                }
                inc++;
            }
        }
        else{
            nope = true;
        }
        if(!nope){
            smStraight = 30;
        }
        else{
            smStraight = -1;
        }
    }
    public void lgStraight(ArrayList<dice>dice){
        int inc = 0;
        boolean nope = false;
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
        if(order.get(0) == 1 || order.get(0) == 2){
            for(int count = order.get(0);count != order.get(0)+5;count++){
                if(order.get(inc) != count){
                    nope = true;
                }
                inc++;
            }
        }
        else{
            nope = true;
        }
        if(!nope){
            lgStraight = 40;
        }
        else{
            lgStraight = -1;
        }
    }
}