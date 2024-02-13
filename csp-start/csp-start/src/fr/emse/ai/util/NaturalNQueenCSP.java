package fr.emse.ai.util;

import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.Variable;

public class NaturalNQueenCSP extends CSP {

    public NaturalNQueenCSP(int noQueen){
        for (int i = 0; i < noQueen;i++) {
            addVariable(new Variable(i+));
        }

    }



}
