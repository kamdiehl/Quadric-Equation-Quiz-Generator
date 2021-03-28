package model;

import model.equations.*;

// This class creates 1 quiz question (an equation) that will be added to the list of questions in QuestionMaster.
public class QuizEntry {
    private String question;
    private String answer;

    int maxValue = 10;
    int minValue = 1;


    // Constructor
    public QuizEntry() {
        generateSurfaceQ();
        this.question = getQuestion();
        this.answer = getAnswer();

    }


    // EFFECTS: Generates random number to randomly call a surface to construct an equation.
    public void generateSurfaceQ() {
        int maxSurfaceCount = 8;
        int randNum = (int)(Math.random() * (maxSurfaceCount - 1 + 1) + 1);

        if (randNum == 1) {
            sphereQuestion();
        } else if (randNum == 2) {
            ellipsoidQuestion();
        } else if (randNum == 3) {
            coneQuestion();
        } else if (randNum == 4) {
            ellipticParaboloidQuestion();
        } else if (randNum == 5) {
            hyperbolicParaboloidQuestion();
        } else if (randNum == 6) {
            hyperboloidOfOneQuestion();
        } else if (randNum == 7) {
            hyperboloidOfTwoQuestion();
        } else if (randNum == 8) {
            circularCylinderQuestion();
        }
    }


    // EFFECTS: Generates a sphere equation to present to user
    void sphereQuestion() {
        Sphere s = new Sphere();
        s.generateSphere(maxValue, minValue);
        question = s.eqToString();
        answer = "sphere";
    }


    // EFFECTS: Generates an ellipsoid equation to present to user
    void ellipsoidQuestion() {
        Ellipsoid e = new Ellipsoid();
        e.generateEllipsoid(maxValue, minValue);
        question = e.eqToString();
        answer = "ellipsoid";
    }


    // EFFECTS: Generates a cone equation to present to user
    void coneQuestion() {
        Cone c = new Cone();
        c.generateCone(maxValue, minValue);
        question = c.eqToString();
        answer = "cone";
    }


    // EFFECTS: Generates a hyperboloid of one sheet equation to present to user
    void hyperboloidOfOneQuestion() {
        HyperboloidOfOne h1 = new HyperboloidOfOne();
        h1.generateHyperboloidOfOne(maxValue, minValue);
        question = h1.eqToString();
        answer = "hyperboloid of one sheet";
    }


    // EFFECTS: Generates a hyperboloid of two sheets equation to present to user
    void hyperboloidOfTwoQuestion() {
        HyperboloidOfTwo h2 = new HyperboloidOfTwo();
        h2.generateHyperboloidOfTwo(maxValue, minValue);
        question = h2.eqToString();
        answer = "hyperboloid of two sheets";
    }


    // EFFECTS: Generates a hyperbolic paraboloid equation to present to user
    void hyperbolicParaboloidQuestion() {
        HyperbolicParaboloid hp = new HyperbolicParaboloid();
        hp.generateHyperParaboloid(maxValue, minValue);
        question = hp.eqToString();
        answer = "hyperbolic paraboloid";
    }


    // EFFECTS: Generates a elliptic paraboloid equation to present to user
    void ellipticParaboloidQuestion() {
        Paraboloid ep = new Paraboloid();
        ep.generateParaboloid(maxValue, minValue);
        question = ep.eqToString();
        answer = "paraboloid";
    }

    // EFFECTS: Generates a circular cylinder equation to present to user
    void circularCylinderQuestion() {
        CircularCylinder ep = new CircularCylinder();
        ep.generateCircularCylinder(maxValue, minValue);
        question = ep.eqToString();
        answer = "circular cylinder";
    }




    // getters

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


}
