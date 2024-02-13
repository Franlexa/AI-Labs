package fr.emse.ai.csp.simplecsp;

import fr.emse.ai.csp.australia.MapCSP;
import fr.emse.ai.csp.core.*;

public class SimpleCSPTest {
    public static void main(String[] args) {
        SimpleCSP csp = new SimpleCSP();

        System.out.println("The Domain of X: "+csp.getDomain(SimpleCSP.X));
        System.out.println("The Domain of Y: "+csp.getDomain(SimpleCSP.Y));
        System.out.println("The Domain of Z: "+csp.getDomain(SimpleCSP.Z));

        AC3Strategy ac = new  AC3Strategy();
        ac.reduceDomains(csp);

        System.out.println("The Domain of X: "+csp.getDomain(SimpleCSP.X));
        System.out.println("The Domain of Y: "+csp.getDomain(SimpleCSP.Y));
        System.out.println("The Domain of Z: "+csp.getDomain(SimpleCSP.Z));

        BacktrackingStrategy bts = new BacktrackingStrategy();
        bts.addCSPStateListener(new CSPStateListener() {
            @Override
            public void stateChanged(Assignment assignment, CSP csp) {
                System.out.println("Assignment evolved : " + assignment);
            }

            @Override
            public void stateChanged(CSP csp) {
                System.out.println("CSP evolved : " + csp);
            }
        });
        double start = System.currentTimeMillis();
        Assignment sol = bts.solve(csp);
        double end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve = " + (end - start));

    }
}


