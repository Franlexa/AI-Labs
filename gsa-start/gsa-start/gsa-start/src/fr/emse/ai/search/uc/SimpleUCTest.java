package fr.emse.ai.search.uc;

import fr.emse.ai.search.simple.SimpleOrientedGraphProblem;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class SimpleUCTest {

    public static void main(String[] args) {
        UniformCostProblem p1 = new UniformCostProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());

        System.out.println("Solution to problem using uc : ");
        System.out.println(new UniformCostSearch().solve(p1).pathToString());
    }
}