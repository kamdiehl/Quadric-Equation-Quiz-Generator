package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SurfaceTests {

    @BeforeEach
    void setup() {

        Sphere s = new Sphere();
        QuestionMaster q = new QuestionMaster(10, 10, 1);

    }

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
    void testSphere() {

    }



}