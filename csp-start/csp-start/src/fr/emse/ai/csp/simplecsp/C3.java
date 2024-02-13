package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.Constraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class C3 implements Constraint {

    private Variable var1;
    private Variable var2;
    private List<Variable> scope;

    public C3(Variable var1, Variable var2) {
        this.var1 = var1;
        this.var2 = var2;
        scope = new ArrayList<Variable>(2);
        scope.add(var1);
        scope.add(var2);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        Integer value1 = (Integer) assignment.getAssignment(var1);
        Integer value2 = (Integer) assignment.getAssignment(var2);

        if (value1 == null || value2 == null || value1<value2)
            return true ;
        else
            return false;

    }
}

