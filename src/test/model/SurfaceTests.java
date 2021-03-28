package model;

import com.oracle.javafx.jmx.json.JSONReader;
import javafx.scene.input.Clipboard;
import model.equations.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;
import com.oracle.javafx.jmx.json.JSONReader; // my project wouldn't compile and said to import this?

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void testQuestionMasterLength() {
        QuestionMaster qm1 = new QuestionMaster(10,10,1);
        assertEquals(10, qm1.getQuizLength());
        qm1.setQuizLength(11);
        assertEquals(11, qm1.getQuizLength());
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
    void testCircularCylinderToString() {
        CircularCylinder c = new CircularCylinder();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(2, 2, 0, false);
        Term testZ = new Term(0, 3, 0, true);
        Term testD = new Term(9, 4, 1, false);

        c.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        c.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        c.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        c.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        c.generateCircularCylinder(q.getMaxValue(), q.getMinValue());
        String eq = c.eqToString();

        assertEquals("2x^2 + 2y^2 + 0z = 9",eq);

    }

    @Test
    void testHyperParaboloidToString() {
        HyperbolicParaboloid c = new HyperbolicParaboloid();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(-3, 2, 0, false);
        Term testZ = new Term(-4, 3, 0, true);
        Term testD = new Term(0, 4, 1, false);

        c.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        c.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        c.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        c.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        c.generateHyperParaboloid(q.getMaxValue(), q.getMinValue());
        String eq = c.eqToString();

        assertEquals("2x^2 -3y^2 -4z = 0",eq);

    }

    @Test
    void testParaboloidToString() {
        Paraboloid c = new Paraboloid();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(2, 2, 0, false);
        Term testZ = new Term(3, 3, 0, true);
        Term testD = new Term(9, 4, 1, false);

        c.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        c.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        c.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        c.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        c.generateParaboloid(q.getMaxValue(), q.getMinValue());
        String eq = c.eqToString();

        assertEquals("2x^2 + 2y^2 + 3z = 9",eq);

    }

    @Test
    void testHyperOfOneToString() {
        HyperboloidOfOne hp = new HyperboloidOfOne();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0, false);
        Term testY = new Term(2, 2, 0, false);
        Term testZ = new Term(-6, 3, 0, false);
        Term testD = new Term(9, 4, 1, false);

        hp.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        hp.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        hp.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        hp.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        hp.generateHyperboloidOfOne(q.getMaxValue(), q.getMinValue());
        String eq = hp.eqToString();

        assertEquals("2x^2 + 2y^2 -6z^2 = 9", eq);

    }

    @Test
    void testHyperOfTwoToString() {
        HyperboloidOfTwo hp = new HyperboloidOfTwo();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(-2, 1, 0, false);
        Term testY = new Term(-2, 2, 0, false);
        Term testZ = new Term(6, 3, 0, false);
        Term testD = new Term(9, 4, 1, false);

        hp.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide(), testX.getNotSquared());
        hp.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide(), testY.getNotSquared());
        hp.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide(), testZ.getNotSquared());
        hp.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide(), testD.getNotSquared());

        hp.generateHyperboloidOfTwo(q.getMaxValue(), q.getMinValue());
        String eq = hp.eqToString();

        assertEquals("-2x^2 -2y^2 + 6z^2 = 9", eq);

    }


    @Test
    void testSphereQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.sphereQuestion();

        assertEquals("sphere", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "cone");
        assertNotEquals(equation.getAnswer(), "ellipsoid");
    }

    @Test
    void testEllipsoidQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.ellipsoidQuestion();

        assertEquals("ellipsoid", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "cone");
        assertNotEquals(equation.getAnswer(), "sphere");
    }

    @Test
    void testConeQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.coneQuestion();

        assertEquals("cone", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "ellipsoid");
        assertNotEquals(equation.getAnswer(), "sphere");
    }

    @Test
    void testCylinderQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.circularCylinderQuestion();

        assertEquals("circular cylinder", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "ellipsoid");
        assertNotEquals(equation.getAnswer(), "sphere");
    }

    @Test
    void testHyperOfOneQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.hyperboloidOfOneQuestion();

        assertEquals("hyperboloid of one sheet", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "ellipsoid");
        assertNotEquals(equation.getAnswer(), "sphere");
    }

    @Test
    void testHyperOfTwoQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.hyperboloidOfTwoQuestion();

        assertEquals("hyperboloid of two sheets", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "ellipsoid");
        assertNotEquals(equation.getAnswer(), "sphere");
    }

    @Test
    void testHyperParaboloidQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.hyperbolicParaboloidQuestion();

        assertEquals("hyperbolic paraboloid", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "ellipsoid");
        assertNotEquals(equation.getAnswer(), "sphere");
    }

    @Test
    void testParaboloidQuestion() {

        QuizEntry equation = new QuizEntry();
        equation.ellipticParaboloidQuestion();

        assertEquals("paraboloid", equation.getAnswer());
        assertNotEquals(equation.getAnswer(), "ellipsoid");
        assertNotEquals(equation.getAnswer(), "sphere");
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



    // STATS ----------------

    @Test
    void testAddStats() {
        StatValue stat = new StatValue(StatCategory.CorrectAnswers, 3);
        ArrayList<StatValue> statList = new ArrayList<>();
        statList.add(stat);
        StatsManager statsManager = new StatsManager("statHistory");
        statsManager.addStat(stat);
        assertEquals(statsManager.getAllStats(), statList);

    }

    @Test
    void testToJsonStatValue() {
        StatValue statValue = new StatValue(StatCategory.CorrectAnswers, 10);
        assertEquals(StatCategory.CorrectAnswers, statValue.getCategory());
        assertEquals(10, statValue.getValue());
        assertEquals("CorrectAnswers: 10", statValue.toString());

        JSONObject jsonObject = statValue.toJson();
        assertFalse(jsonObject.isEmpty());
        assertEquals(2, jsonObject.length());

    }


    @Test
    void testJsonStatManager() {

        StatsManager statsManager = new StatsManager("statHistory");
        StatValue stat1 = new StatValue(StatCategory.CorrectAnswers, 10);
        StatValue stat2 = new StatValue(StatCategory.IncorrectAnswers, 10);
        StatValue stat3 = new StatValue(StatCategory.QuestionsAsked, 20);

        statsManager.addStat(stat1);
        statsManager.addStat(stat2);
        statsManager.addStat(stat3);

        JSONObject jsonObject = statsManager.toJson();
        assertFalse(jsonObject.isEmpty());

        List statList = statsManager.getAllStats();
        assertEquals(3, statList.toArray().length);

        assertEquals(statsManager.getStatHistory(), "statHistory");
        assertEquals(statsManager.getOverallCorrectAnswers(), 0);
        assertEquals(statsManager.getOverallIncorrectAnswers(), 0);



    }



}



