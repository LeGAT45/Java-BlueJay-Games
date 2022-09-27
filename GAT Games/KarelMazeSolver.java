import becker.robots.*;
import java.util.*;
import java.awt.*;
public class KarelMazeSolver
{
    public static void main(String args[])
    {
        int kColorR;
        int kColorB;
        // 210 red, 0 blue, 210 blue, 0 red
        int karelStreet;
        int karelAvenue;
        int avenueDiff;
        int streetDiff;
        MazeCity spr = new MazeCity(16,16,0.5,0.5);
        /*
        Random karelXInput = new Random();
        Random karelYInput = new Random();
        Random thingXInput = new Random();
        Random thingYInput = new Random();
        int karelX = karelXInput.nextInt(16) + 0;
        int karelY = karelXInput.nextInt(16) + 0;
        int thingX = karelXInput.nextInt(16) + 0;
        int thingY = karelXInput.nextInt(16) + 0;
        */
        RobotSE karel = new RobotSE(spr,0,0,Direction.EAST,100);
        Thing t1 = new Thing(spr,15,15);
        while (!karel.canPickThing())
        {
            karel.turnLeft();
            karelAvenue = karel.getAvenue();
            karelStreet = karel.getStreet();
            avenueDiff = karelAvenue - 15;
            streetDiff = karelStreet - 15;
            kColorR = Math.abs(((Math.abs(avenueDiff) + Math.abs(streetDiff)) * 8) - 210);
            kColorB = ((Math.abs(avenueDiff) + Math.abs(streetDiff)) * 8);
            if (kColorR <= 0)
            {
                kColorR = 0;
            }
            if (kColorB >= 210)
            {
                kColorB = 210;
            }
            if (kColorR >= 210)
            {
                kColorR = 210;
            }
            if (kColorB <= 0)
            {
                kColorB = 0;
            }
            try{
            karel.setColor(new Color(kColorR,0,kColorB));
            }
            catch (Exception e){}
            if(karel.frontIsClear())
            {
                karel.move();
            }
            else
            {
                while (!karel.frontIsClear())
                {
                karel.turnRight();
                }
                karel.move();
            }
        }
    }
}