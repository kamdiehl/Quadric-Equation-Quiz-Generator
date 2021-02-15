package model;

import ui.QuestionMaster;

// sub-class of Surface, contains the criteria needed for an equation of a sphere.
public class Sphere extends Surface {

    public Sphere() {
        // Equation: ax^2 + by^2 + cz^2 = d where (a = b = c)
    }

    public void generateSphere(QuestionMaster questionMaster) {
        int co1 = (int)(Math.random() * (questionMaster.getMaxValue() - questionMaster.getMinValue() + 1)
                + questionMaster.getMinValue());
        int co4 = (int)(Math.random() * (questionMaster.getMaxValue() - questionMaster.getMinValue() + 1)
                + questionMaster.getMinValue());

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


