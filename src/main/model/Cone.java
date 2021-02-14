package model;

public class Cone extends Surface {
    // sub-class of abstract class Surface

    public Cone() {
        // Equation: ax^2 + by^2 - cz^2 = d
    }

    public void generateCone(Quiz quiz) {

        int co1;
        co1 = (int) (Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

        int co2;
        co2 = (int) (Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

        int co3;
        co3 = (int) (Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());
        co3 = -co3;

        int co4;
        co4 = (int) (Math.random() * (quiz.getMaxValue() - quiz.getMinValue() + 1) + quiz.getMinValue());

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
