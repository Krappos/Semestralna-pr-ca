
public enum Smer {
    HORE(0,-1),
    DOLE(0,1),
    VLAVO(-1,0),
    VPRAVO(1,0);

    private int x;
    private int y;

    Smer(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return this.x;   
    }

    public int getY()  {
        return this.y;
    }
}
