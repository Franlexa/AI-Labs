package fr.emse.ai.search.bf;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class BestFirstSearch extends AbstractTreeSearch {

    public Collection<Node> initFrontier() {
        return new ArrayList<Node>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        Node bestNode = ((ArrayList<Node>) frontier).get(0);

        for (int i = 1; i < frontier.size(); i++) {
            Node node = ((ArrayList<Node>) frontier).get(i);

            if (((HeuristicState)node.getState()).getHValue() < ((HeuristicState)bestNode.getState()).getHValue()) {
                bestNode = node;
            }
        }
        frontier.remove(bestNode);
        return bestNode;

        }
    }
