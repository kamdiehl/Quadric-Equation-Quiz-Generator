package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.*;
import model.Quiz;
import model.Sphere;


class SurfaceTests {
    String quadSphere;
    String quadEllipsoid;
    String quadCone;

    @BeforeEach
    public void setup() {
        quadSphere = new String("x^2 + y^2 + z^2 = 9");
        quadEllipsoid = new String("2x^2 + 3y^2 + 4z^2 = 9");
        quadCone = new String("2x^2 + 3y^2 - 4z^2 = 1");
    }


}