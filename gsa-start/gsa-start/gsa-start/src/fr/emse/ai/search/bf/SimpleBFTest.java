package fr.emse.ai.search.bf;

import fr.emse.ai.search.solver.DepthFirstTreeSearch;
import fr.emse.ai.search.uc.UniformCostProblem;
import fr.emse.ai.search.uc.UniformCostSearch;

public class SimpleBFTest {

    public static void main(String[] args) {
        BestFirstProblem p1 = new BestFirstProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());

        System.out.println("Solution to problem using bfs : ");
        System.out.println(new UniformCostSearch().solve(p1).pathToString());
    }
}