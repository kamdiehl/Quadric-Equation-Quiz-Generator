package model;

public class Term {
// A term represents a grouping in the equation of a surface.
// Ex. In the equation 2x^2 + 5y^2 = 6 , 2x^2 is considered 1 term.

    private int coefficient;
    private int variable;
    private int side;
    private boolean notSquared;

    // Constructor
    public Term(int co, int var, int si, boolean ns) {
        coefficient = co; // Represents the integer (a,b,c) attached to a variable (x,y,z)
        variable = var;   // Represents the variable (x,y,z)
        side = si;        // Represents which side of the equation the term is on
        notSquared = ns;  //  with 0 = LHS and 1 = RHS
                          // notSquared represents whether the variable is an exception and not z^2.
    }

   // Getters

    public int getCoefficient() {
        return coefficient;
    }

    public int getSide() {
        return side;
    }

    public int getVariable() {
        return variable;
    }

    public boolean getNotSquared() {
        return notSquared;
    }
}
