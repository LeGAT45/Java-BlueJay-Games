public class Box{
    private int x;
    private int y;
    private int d;
    private int count;
    public Box(int x, int y,int d){
        this.d = d;
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getD()
    {
        return d;
    }
    //
    public void changeX(int x)
    {
        this.x = x;
    }
    public void changeY(int y)
    {
        this.y = y;
    }
    public void changeD(int d)
    {
        this.d = d;
    }
}