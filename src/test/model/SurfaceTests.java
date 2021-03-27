package model;

import model.equations.Cone;
import model.equations.Ellipsoid;
import model.equations.Sphere;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Test class where model directory methods are tested
class SurfaceTests {


    @Test
    void testTermConstructor() {
        Term term1 = new Term(3,1,0, false);
        assertEquals(3, term1.getCoefficient());
        assertEquals(1, term1.getVariable());
        assertEquals(0, term1.getSide());

    }

    @Test
    void testQuestionMasterCon() {
        QuestionMaster qm1 = new QuestionMaster(10, 10, 1);
        assertEquals(10, qm1.getQuizLength());
        assertEquals(10, qm1.getMaxValue());
        assertEquals(1, qm1.getMinValue());
    }

    @Test
    void testSphereToString() {
        Sphere s = new Sphere();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(2, 2, 0, false);
        Term testZ = new Term(2, 3, 0, false);
        Term testD = new Term(9, 4, 1, false);

        s.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        s.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        s.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        s.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        s.generateSphere(q.getMaxValue(), q.getMinValue());
        String eq = s.eqToString();

        assertEquals("2x^2 + 2y^2 + 2z^2 = 9",eq);

    }

    @Test
    void testEllipsoidToString() {
        Ellipsoid e = new Ellipsoid();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(4, 2, 0, false);
        Term testZ = new Term(6, 3, 0, false);
        Term testD = new Term(9, 4, 1, false);

        e.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        e.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        e.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        e.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        e.generateEllipsoid(q.getMaxValue(), q.getMinValue());
        String eq = e.eqToString();

        assertEquals("2x^2 + 4y^2 + 6z^2 = 9",eq);

    }

    @Test
    void testConeToString() {
        Cone c = new Cone();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(4, 2, 0, false);
        Term testZ = new Term(-6, 3, 0, false);
        Term testD = new Term(9, 4, 1, false);

        c.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        c.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        c.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        c.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        c.generateCone(q.getMaxValue(), q.getMinValue());
        String eq = c.eqToString();

        assertEquals("2x^2 + 4y^2 -6z^2 = 9",eq);

    }


    @Test
    void testSphereQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.sphereQuestion();

        assertEquals("sphere", equation.getAnswer());
        assertFalse("cone".equals(equation.getAnswer()));
        assertFalse("ellipsoid".equals(equation.getAnswer()));
    }

    @Test
    void testEllipsoidQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.ellipsoidQuestion();

        assertEquals("ellipsoid", equation.getAnswer());
        assertFalse("cone".equals(equation.getAnswer()));
        assertFalse("sphere".equals(equation.getAnswer()));
    }

    @Test
    void testConeQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.coneQuestion();

        assertEquals("cone", equation.getAnswer());
        assertFalse("ellipsoid".equals(equation.getAnswer()));
        assertFalse("sphere".equals(equation.getAnswer()));
    }


    @Test
    void testCreateNewQuestionList() {

        int numOfQuestions = 5;
        QuestionMaster newQuiz = new QuestionMaster(numOfQuestions, 10, 1);

        List<QuizEntry> questionList = newQuiz.createNewQuestionList(numOfQuestions);

        assertEquals(5, questionList.size());

        List<QuizEntry> testGet = newQuiz.getQuestionList();

        assertEquals(5, testGet.size());

        // prior to starting
        assertEquals(0, newQuiz.getCorrectAnswers());


    }


}



