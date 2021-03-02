package model;

// sub-class of Surface, contains the criteria needed for an equation of a cone. This includes 4 coefficients
// attached to variables in the createTerm method. One coefficient is negative.
public class Cone extends Surface {
    int maxValue;
    int minValue;

    public Cone() {
        // Equation: ax^2 + by^2 - cz^2 = d
    }

    // REQUIRES: co1, co2, co3 > 0.
    // EFFECTS: creates the coefficients for each term in the equation of a cone.
    public void generateCone(int maxRange, int minRange) {
        maxValue = maxRange;
        minValue = minRange;

        int co1 = (int) (Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co2 = (int) (Math.random() * (maxValue - minValue + 1)
                + minValue);

        int co3 = (int) (Math.random() * (maxValue - minValue + 1)
                + minValue);
        co3 = -co3;

        int co4 = (int) (Math.random() * (maxValue - minValue + 1)
                + minValue);

        // ax^2 + by^2 - cz^2 = d where a,b,c are random coefficients.
        // var = the variable the integer coefficient is attached to (x,y,z)
        // co1,2,3,4 = Randomly generated integer between max and min
        // si = Which side the term is on, 0 being left side of "=" and 1 being right side of "="

        createTerm(co1,1, 0); // ax^2 = 0
        createTerm(co2,2, 0); // by^2 = 0
        createTerm(co3,3, 0); // -cz^2 = 0
        createTerm(co4,4, 1); // 0 = d
    }
}
