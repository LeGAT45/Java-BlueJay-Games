import java.util.*;
import java.awt.*;
public class Piece{
    // determines which player owns the piece
    public int t;
    public boolean last;
    public Piece(int t, boolean last){
        this.t = t;
        this.last = last;
    }
}