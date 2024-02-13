package game;

import java.util.ArrayList;
import java.util.List;

public class SimpleTwoPlyGameTree {

    public int alpha;
    public int beta;
    private Integer value;
    private final boolean max;
    private ArrayList<SimpleTwoPlyGameTree> children;

    public SimpleTwoPlyGameTree(Integer value, boolean max) {
        this.value = value;
        this.max = max;
        children = new ArrayList<SimpleTwoPlyGameTree>();
    }

    public SimpleTwoPlyGameTree(Integer value, boolean max, List<SimpleTwoPlyGameTree> children) {
        this(value, max);
        this.children.addAll(children);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isMax() {
        return max;
    }

    public void addChild(SimpleTwoPlyGameTree child) {
        this.children.add(child);
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ArrayList<SimpleTwoPlyGameTree> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<SimpleTwoPlyGameTree> children) {
        this.children = children;
    }

    public String toString() {
        String s = "";
        s += "value = " + value + " | ";
        s += "child = " + children;
        return s;
    }

}
