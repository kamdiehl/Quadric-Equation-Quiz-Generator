package model.equations;

import model.Surface;

public class CircularCylinder extends Surface {
    int maxValue;
    int minValue;

    public CircularCylinder() {
        // Equation: ax^2 + ay^2 + 0z = d where (z = 0)
    }

    // REQUIRES: co3 = 0 and co1 = co2.
    // EFFECTS: creates the coefficients for each term in the equation of a circular cylinder.
    public void generateCircularCylinder(int maxRange, int minRange) {
        maxValue = maxRange;
        minValue = minRange;

        int co1 = (int)(Math.random() * (maxValue - minValue + 1) + minValue);

        int co3 = 0;

        int co4 = (int)(Math.random() * (maxValue - minValue + 1) + minValue);

        // ax^2 + by^2 + cz^2 = d where (a = b = c)
        // var = the variable the coefficient is attached to (x,y,z)
        // co1 = Randomly generated variable
        // si = Which side the term is on, 0 being left side of "=" and 1 being right side of "="

        createTerm(co1,1, 0, false);
        createTerm(co1,2, 0, false);
        createTerm(co3,3, 0, true);
        createTerm(co4,4, 1, false);


    }
}
