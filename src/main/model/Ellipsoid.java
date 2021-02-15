package model;

import ui.QuestionMaster;

// sub-class of Surface, contains the criteria needed for an equation of a ellipsoid. This includes 4 coefficients
// attached to variables in the createTerm method.
public class Ellipsoid extends Surface {

    public Ellipsoid() {
        // Equation: ax^2 + by^2 + cz^2 = d
    }

    // REQUIRES: minValue > 0
    // MODIFIES:
    // EFFECTS: Generates 4 integer coefficients for each term in the ellipsoid equation.
    public void generateEllipsoid(QuestionMaster questionMaster) {
// they could all equal, so fix
        int co1 = (int)(Math.random() * (questionMaster.getMaxValue() - questionMaster.getMinValue() + 1)
                + questionMaster.getMinValue());

        int co2 = (int)(Math.random() * (questionMaster.getMaxValue() - questionMaster.getMinValue() + 1)
                + questionMaster.getMinValue());

        int co3 = (int)(Math.random() * (questionMaster.getMaxValue() - questionMaster.getMinValue() + 1)
                + questionMaster.getMinValue());

        int co4 = (int)(Math.random() * (questionMaster.getMaxValue() - questionMaster.getMinValue() + 1)
                + questionMaster.getMinValue());

        // ax^2 + by^2 + cz^2 = d where a,b,c are random coefficients.
        // var = the variable the coefficient is attached to (x,y,z)
        // co1 = Randomly generated variable
        // si = Which side the term is on, 0 being left side of "=" and 1 being right side of "="

        createTerm(co1, 1, 0); // ax^2 = 0
        createTerm(co2, 2, 0); // by^2 = 0
        createTerm(co3, 3, 0); // cz^2 = 0
        createTerm(co4, 4, 1); // 0 = d
    }

}
