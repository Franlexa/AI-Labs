package fr.emse.ai.search.Bottle;

import fr.emse.ai.search.bf.HeuristicState;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class BottleProblem implements Problem {

    Bottles initialState = new Bottles(0, 0);
    Bottles finalState1 = new Bottles(0, 2);
    Bottles finalState2 = new Bottles(2, 0);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState1) || state.equals(finalState2);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        actions.add(Actions.fillb1);
        actions.add(Actions.fillb2);
        actions.add(Actions.emptyb1);
        actions.add(Actions.emptyb2);
        actions.add(Actions.transferb1);
        actions.add(Actions.transferb2);
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {

        Bottles currentState = (Bottles) state;

        if (action.equals(Actions.fillb1)) return new Bottles(4, currentState.y);
        if (action.equals(Actions.fillb2)) return new Bottles(currentState.x, 3);
        if (action.equals(Actions.emptyb1)) return new Bottles(0, currentState.y);
        if (action.equals(Actions.emptyb2)) return new Bottles(currentState.x, 0);

        if (action.equals(Actions.transferb1)) {
            // Transfer from bottle 2 to bottle 1
            int transferAmount = Math.min(currentState.y, 4 - currentState.x);
            return new Bottles(currentState.x + transferAmount, currentState.y - transferAmount);
        }

        if (action.equals(Actions.transferb2)) {
            // Transfer from bottle 1 to bottle 2
            int transferAmount = Math.min(currentState.x, 3 - currentState.y);
            return new Bottles(currentState.x - transferAmount, currentState.y + transferAmount);
        }

        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
