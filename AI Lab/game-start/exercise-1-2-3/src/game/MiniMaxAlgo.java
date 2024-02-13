package game;


import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MiniMaxAlgo {

    public int count  = 0;
    public Integer maxmin(SimpleTwoPlyGameTree node) {
        count++;
        if (node.isLeaf())
            return node.getValue();
        else {
            ArrayList<SimpleTwoPlyGameTree> next = node.getChildren();
            int v = Integer.MIN_VALUE;
            for (SimpleTwoPlyGameTree c : next)
                v = max(v, minmax(c));
            return v;

        }
    }

    public Integer minmax(SimpleTwoPlyGameTree node) {
        count++;
        if (node.isLeaf())
            return node.getValue();
        else {
            ArrayList<SimpleTwoPlyGameTree> next = node.getChildren();
            int v = Integer.MAX_VALUE;
            for (SimpleTwoPlyGameTree c : next)
                v = min(v, maxmin(c));
            return v;
        }
    }
}
