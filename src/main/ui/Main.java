package ui;

import model.*;
import model.Quiz;
import model.Sphere;


public class Main {
    public static void main(String[] args) {

        new QuadricApp();

        Sphere s = new Sphere();
        Quiz q = new Quiz(10, 1);
        s.generateSphere(q);
        String eq = s.eqToString();
        System.out.println(eq);

        Ellipsoid  e = new Ellipsoid();
        e.generateEllipsoid(q);
        String eeq = e.eqToString();
        System.out.println(eeq);

        Cone c = new Cone();
        c.generateCone(q);
        String ceq = c.eqToString();
        System.out.println(ceq);



    }
}
