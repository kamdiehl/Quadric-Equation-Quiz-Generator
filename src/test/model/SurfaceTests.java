package model;

import org.junit.jupiter.api.Test;
import ui.QuestionMaster;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Test class where model directory methods are tested
class SurfaceTests {


    @Test
    void testTermConstructor() {
        Term term1 = new Term(3,1,0);
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

        Term testX = new Term(2, 1, 0);
        Term testY = new Term(2, 2, 0);
        Term testZ = new Term(2, 3, 0);
        Term testD = new Term(9, 4, 1);

        s.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide());
        s.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide());
        s.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide());
        s.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide());

        s.generateSphere(q);
        String eq = s.eqToString();

        assertEquals("2x^2 + 2y^2 + 2z^2 = 9",eq);

    }

    @Test
    void testEllipsoidToString() {
        Ellipsoid e = new Ellipsoid();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0);
        Term testY = new Term(4, 2, 0);
        Term testZ = new Term(6, 3, 0);
        Term testD = new Term(9, 4, 1);

        e.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide());
        e.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide());
        e.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide());
        e.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide());

        e.generateEllipsoid(q);
        String eq = e.eqToString();

        assertEquals("2x^2 + 4y^2 + 6z^2 = 9",eq);

    }

    @Test
    void testConeToString() {
        Cone c = new Cone();
        QuestionMaster q = new QuestionMaster(10,10,1);

        Term testX = new Term(2, 1, 0);
        Term testY = new Term(4, 2, 0);
        Term testZ = new Term(-6, 3, 0);
        Term testD = new Term(9, 4, 1);

        c.createTerm(testX.getCoefficient(),testX.getVariable(), testX.getSide());
        c.createTerm(testY.getCoefficient(),testY.getVariable(), testY.getSide());
        c.createTerm(testZ.getCoefficient(),testZ.getVariable(), testZ.getSide());
        c.createTerm(testD.getCoefficient(),testD.getVariable(), testD.getSide());

        c.generateCone(q);
        String eq = c.eqToString();

        assertEquals("2x^2 + 4y^2 -6z^2 = 9",eq);

    }


}



