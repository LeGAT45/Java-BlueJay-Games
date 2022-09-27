import java.awt.*;
public class Marker{
    public int x;
    public int y;
    public Color c;
    public boolean rev;
    public int size;
    public Marker(int x, int y,Color c,int size, boolean rev){
        this.x = x;
        this.y = y;
        this.c = c;
        this.size = size;
        this.rev = rev;
    }
}