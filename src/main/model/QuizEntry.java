package model;

public class QuizEntry {
    private String question;
    private String answer;

    int maxValue = 10;
    int minValue = 1;

    public QuizEntry() {
        generateSurfaceQ();

    }

    public void generateSurfaceQ() {
        int maxSurfaceCount = 3;
        int randNum = (int)(Math.random() * (maxSurfaceCount - 1 + 1) + 1);

        if (randNum == 1) {
            sphereQuestion();
        }

        if (randNum == 2) {
            ellipsoidQuestion();
        }

        if (randNum == 3) {
            coneQuestion();
        }
    }

    // EFFECTS: Generates a sphere equation to present to user
    void sphereQuestion() {
        Sphere s = new Sphere();
        s.generateSphere(maxValue, minValue);
        System.out.println(s.eqToString());
        question = s.eqToString();
        answer = "sphere";
    }

    // EFFECTS: Generates an ellipsoid equation to present to user
    void ellipsoidQuestion() {
        Ellipsoid e = new Ellipsoid();
        e.generateEllipsoid(maxValue, minValue);
        System.out.println(e.eqToString());
        question = e.eqToString();
        answer = "ellipsoid";
    }

    // EFFECTS: Generates a cone equation to present to user
    void coneQuestion() {
        Cone c = new Cone();
        c.generateCone(maxValue, minValue);
        System.out.println(c.eqToString());
        question = c.eqToString();
        answer = "cone";
    }





    // getters

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


}
