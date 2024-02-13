package game;

import java.util.ArrayList;

public class TestGameBis {

    public static void main(String[] args) {

        // level 4
        ArrayList<SimpleTwoPlyGameTree> sublist41 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist41.add(new SimpleTwoPlyGameTree(20, true));
        sublist41.add(new SimpleTwoPlyGameTree(22, true));

        ArrayList<SimpleTwoPlyGameTree> sublist42 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist42.add(new SimpleTwoPlyGameTree(25, true));
        sublist42.add(new SimpleTwoPlyGameTree(30, true));

        ArrayList<SimpleTwoPlyGameTree> sublist43 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist43.add(new SimpleTwoPlyGameTree(17, true));
        sublist43.add(new SimpleTwoPlyGameTree(0, true));
        sublist43.add(new SimpleTwoPlyGameTree(30, true));
        sublist43.add(new SimpleTwoPlyGameTree(15, true));

        ArrayList<SimpleTwoPlyGameTree> sublist44 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist44.add(new SimpleTwoPlyGameTree(50, true));
        sublist44.add(new SimpleTwoPlyGameTree(53, true));

        ArrayList<SimpleTwoPlyGameTree> sublist45 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist45.add(new SimpleTwoPlyGameTree(65, true));
        sublist45.add(new SimpleTwoPlyGameTree(20, true));

        ArrayList<SimpleTwoPlyGameTree> sublist46 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist46.add(new SimpleTwoPlyGameTree(10, true));
        sublist46.add(new SimpleTwoPlyGameTree(8, true));

        ArrayList<SimpleTwoPlyGameTree> sublist47 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist47.add(new SimpleTwoPlyGameTree(5, true));
        sublist47.add(new SimpleTwoPlyGameTree(2, true));

        ArrayList<SimpleTwoPlyGameTree> sublist48 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist48.add(new SimpleTwoPlyGameTree(92, true));
        sublist48.add(new SimpleTwoPlyGameTree(1, true));

        ArrayList<SimpleTwoPlyGameTree> sublist49 = new ArrayList<SimpleTwoPlyGameTree>();
        sublist49.add(new SimpleTwoPlyGameTree(25, true));
        sublist49.add(new SimpleTwoPlyGameTree(30, true));

        // level 3
        SimpleTwoPlyGameTree subTree31 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist41);
        SimpleTwoPlyGameTree subTree32 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist42);
        SimpleTwoPlyGameTree subTree33 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist43);
        SimpleTwoPlyGameTree subTree34 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist44);
        SimpleTwoPlyGameTree subTree35 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist45);
        SimpleTwoPlyGameTree subTree36 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist46);
        SimpleTwoPlyGameTree subTree37 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist47);
        SimpleTwoPlyGameTree subTree38 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist48);
        SimpleTwoPlyGameTree subTree39 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false,
                sublist49);

        // level 2
        SimpleTwoPlyGameTree subTree21 = new SimpleTwoPlyGameTree(Integer.MAX_VALUE, true);
        subTree21.addChild(subTree31);
        subTree21.addChild(subTree32);
        subTree21.addChild(subTree33);
        SimpleTwoPlyGameTree subTree22 = new SimpleTwoPlyGameTree(Integer.MAX_VALUE, true);
        subTree22.addChild(subTree34);
        subTree22.addChild(subTree35);

        SimpleTwoPlyGameTree subTree23 = new SimpleTwoPlyGameTree(Integer.MAX_VALUE, true);
        subTree23.addChild(subTree36);
        subTree23.addChild(subTree37);

        SimpleTwoPlyGameTree subTree24 = new SimpleTwoPlyGameTree(Integer.MAX_VALUE, true);
        subTree24.addChild(subTree38);
        subTree24.addChild(subTree39);


        // level 1
        SimpleTwoPlyGameTree subTree11 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false);
        subTree11.addChild(subTree21);
        subTree11.addChild(subTree22);

        SimpleTwoPlyGameTree subTree12 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, false);
        subTree12.addChild(subTree23);
        subTree12.addChild(subTree24);

        // level 0
        SimpleTwoPlyGameTree tree = new SimpleTwoPlyGameTree(Integer.MAX_VALUE, true);
        tree.addChild(subTree11);
        tree.addChild(subTree12);

        // Exercise 1

        // run minimax algorithm
        MiniMaxAlgo miniMaxAlgo = new MiniMaxAlgo();
        // call the right method and print the result
        Integer solution = miniMaxAlgo.maxmin(tree);
        System.out.println("MinMax = "+solution);
        System.out.println(miniMaxAlgo.count);

        // Exercise 2

        // run alpha-beta algorithm
        AlphaBetaAlgo alphaBetaAlgo = new AlphaBetaAlgo();
        // call the right method and print the result
        Integer exercise =alphaBetaAlgo.alphaBeta(tree,Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Alpha beta = "+exercise);
        System.out.println(+alphaBetaAlgo.count);

        /*
         * Exercise 3
         * Complete your algorithms to count the number of explored nodes.
         * You should find 36 nodes for minimax evaluation
         * and 21 nodes for the alpha beta evaluation.
         * */

    }
}
