package model;

// sub-class of Surface, contains the criteria needed for an equation of a ellipsoid. This includes 4 coefficients
// attached to variables in the createTerm method.
public class Ellipsoid extends Surface {
    int maxValue;
    int minValue;

    public Ellipsoid() {
        // Equation: ax^2 + by^2 + cz^2 = d
    }

    // REQUIRES: co1, co2, co3 > 0.
    // EFFECTS: Generates 4 integer coefficients for each term in the ellipsoid equation.
    public void generateEllipsoid(int maxRange, int minRange) {
        maxValue = maxRange;
        minValue = minRange;

        int co1 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co2 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co3 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co4 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);

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
