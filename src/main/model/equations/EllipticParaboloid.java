package model.equations;

import model.Surface;

public class EllipticParaboloid extends Surface {
    int maxValue;
    int minValue;

    public EllipticParaboloid() {
        // Equation: ax^2 + by^2 - cz = 0
    }

    // REQUIRES: co1, co2 > 0 and co3 < 0 and co4 = 0.
    // EFFECTS: Generates 4 integer coefficients for each term in the Hyperboloid of one sheet equation.
    public void generateParaboloid(int maxRange, int minRange) {
        maxValue = maxRange;
        minValue = minRange;

        int co1 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co2 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co3 = (int)(Math.random() * (maxValue - minValue + 1)
                + minValue);
        co3 = -co3;

        int co4 = 0;

        // ax^2 + by^2 + cz^2 = d where a,b,c are random coefficients.
        // var = the variable the coefficient is attached to (x,y,z)
        // co1 = Randomly generated variable
        // si = Which side the term is on, 0 being left side of "=" and 1 being right side of "="

        createTerm(co1, 1, 0, false); // ax^2 = 0
        createTerm(co2, 2, 0, false); // by^2 = 0
        createTerm(co3, 3, 0, true); // cz = 0 <- z is NOT squared
        createTerm(co4, 4, 1, false); // 0 = d
    }
}
