package fr.emse.ai.search.Bottle;

public class Bottles {
    int x ;
    int y;

    public Bottles(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getHValue() {
        return Math.abs((x+y-2));
    }
}
