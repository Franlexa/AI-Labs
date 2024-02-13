package game;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AlphaBetaAlgo {
    public int count = 0;

    public Integer alphaBeta(SimpleTwoPlyGameTree node, int a, int b) {
        count++;
        if (node.isLeaf())
            return node.getValue();
        else {
            node.alpha = Integer.MIN_VALUE;
            node.beta = Integer.MAX_VALUE;
            ArrayList<SimpleTwoPlyGameTree> next = node.getChildren();
            if (node.isMax()) {
                int v = Integer.MIN_VALUE;
                for (SimpleTwoPlyGameTree c : next) {
                    v = alphaBeta(c, max(a, node.alpha), b);
                    node.alpha = max(node.alpha, v);
                    if (node.alpha >= b)
                        return node.alpha;

                } return node.alpha;

            } else {
                    int v = Integer.MAX_VALUE;
                for (SimpleTwoPlyGameTree c : next) {
                    v = alphaBeta(c, a, min(b, node.beta));
                    node.beta = min(node.beta, v);
                    if (node.beta <= a) {
                        return node.beta;
                    }

                }
                return node.beta;
            }
        }
    }
}
