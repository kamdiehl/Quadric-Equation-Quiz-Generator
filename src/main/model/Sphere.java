package model;

public class Sphere extends Surface {
// sub-class of Surface

    public Sphere() {
        // Equation: ax^2 + by^2 + cz^2 = d where (a = b = c)
    }

    public void generateSphere(Quiz quiz) {
        int co1;
        co1 = (int)(Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());
        int co4;
        co4 = (int)(Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

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


