package model;

import java.util.ArrayList;

public abstract class Surface {
// Abstract class that deals with the creation of the equation by conjoining the terms.

    private String localEql = "";

    ArrayList<Term> termList = new ArrayList<Term>(4);
    // Array list called termList containing data type Term has 4 spots,
    // the first three are for the ax^2, by^2, and cz^2 terms, and the
    // last one is for d (an arbitrary integer)

    // MODIFIES: this
    // EFFECTS: Adds new term to the list of terms needed for an equation
    public void createTerm(int co, int var, int si) {

        Term newTerm = new Term(co, var, si);
        termList.add(newTerm);

    }


    // MODIFIES: this
    // EFFECTS: Combines the string version of the LHS with the string version of the RHS
    public String eqToString() {
        String eq = "";
        eq += lhsEq();
        eq += "= ";
        eq += rhsEq();
        return eq;

    }

    // REQUIRES: instantiated array list of terms.
    // EFFECTS: Turns the LHS of the equation (including the variables) into a string.
    public String lhsEq() {
        for (int i = 0; i < 4; i++) {
            if (termList.get(i).getSide() == 0) {
                String termX = "";

                if (termList.get(i).getCoefficient() > 0 && i != 0) {
                    termX += "+ ";
                }

                termX += termList.get(i).getCoefficient();

                if (termList.get(i).getVariable() == 1) {
                    termX += "x^2 ";
                }
                if (termList.get(i).getVariable() == 2) {
                    termX += "y^2 ";
                }
                if (termList.get(i).getVariable() == 3) {
                    termX += "z^2 ";
                }
                if (termList.get(i).getVariable() == 4) {
                    termX += termList.get(i).getCoefficient();
                }
                localEql += termX;
            }
        }
        return localEql;
    }

    // REQUIRES: instantiated array list of terms.
    // EFFECTS: Turns the RHS of the equation into a string.
    public String rhsEq() {
        String localEq = "";
        for (int i = 0; i < 4; i++) {
            if (termList.get(i).getSide() == 1) {
                String termX = "";

                if (termList.get(i).getVariable() == 1) {
                    termX += "x^2 ";
                }
                if (termList.get(i).getVariable() == 2) {
                    termX += "y^2 ";
                }
                if (termList.get(i).getVariable() == 3) {
                    termX += "z^2 ";
                }
                if (termList.get(i).getVariable() == 4) {
                    termX += termList.get(i).getCoefficient();
                }
                localEq += termX;
            }
        }
        return localEq;
    }


}

