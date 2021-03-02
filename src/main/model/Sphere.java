package model;

// sub-class of Surface, contains the criteria needed for an equation of a sphere.
public class Sphere extends Surface {
    int maxValue;
    int minValue;

    public Sphere() {
        // Equation: ax^2 + by^2 + cz^2 = d where (a = b = c)
    }

    // REQUIRES: co1, co4 > 0.
    // EFFECTS: creates the coefficients for each term in the equation of a sphere.
    public void generateSphere(int maxRange, int minRange) {
        maxValue = maxRange;
        minValue = minRange;

        int co1 = (int)(Math.random() * (maxValue - minValue + 1) + minValue);

        int co4 = (int)(Math.random() * (maxValue - minValue + 1) + minValue);

        // ax^2 + by^2 + cz^2 = d where (a = b = c)
        // var = the variable the coefficient is attached to (x,y,z)
        // co1 = Randomly generated variable
        // si = Which side the term is on, 0 being left side of "=" and 1 being right side of "="

        createTerm(co1,1, 0);
        createTerm(co1,2, 0);
        createTerm(co1,3, 0);
        createTerm(co4,4, 1);


    }
}


