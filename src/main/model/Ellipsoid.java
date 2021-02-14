package model;

public class Ellipsoid extends Surface {
    // sub-class of abstract class Surface

    public Ellipsoid() {
        // Equation: ax^2 + by^2 + cz^2 = d
    }

    // REQUIRES: minValue > 0
    // MODIFIES:
    // EFFECTS: Generates 4 integer coefficients for each term in the ellipsoid equation.
    public void generateEllipsoid(Quiz quiz) {
// they could all equal, so fix
        int co1;
        co1 = (int)(Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

        int co2;
        co2 = (int)(Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

        int co3;
        co3 = (int)(Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

        int co4;
        co4 = (int)(Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

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
