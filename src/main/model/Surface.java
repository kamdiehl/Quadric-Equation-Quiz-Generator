package model;

import java.util.ArrayList;

public abstract class Surface {

    ArrayList<Term> termList = new ArrayList<Term>(4); //WHY ISNT TERM USED
    // Array list called termList containing data type Term has 4 spots,
    // the first three are for the ax^2, by^2, and cz^2 terms, and the
    // last one is for d (an arbitrary integer)

    // HOW DO I WRITE A CLAUSE FOR THIS DON'T FORGET ABOUT IT
    public void createTerm(int co, int var, int si) {

        Term newTerm = new Term(co, var, si);
        termList.add(newTerm);

    }

    public String eqToString() {
        String eq = "";
        for (int i = 0; i < 4; i++) {
            if (termList.get(i).getSide() == 0) {
                String termX = "";

                if (termList.get(i).getCoefficient() > 0 && i != 0) {
                    termX += "+ ";
                }

                termX += termList.get(i).getCoefficient();

                if (termList.get(i).getVariable() == 1) {
                    termX += "x^2 ";
                }
                if (termList.get(i).getVariable() == 2) {
                    termX += "y^2 ";
                }
                if (termList.get(i).getVariable() == 3) {
                    termX += "z^2 ";
                }
                if (termList.get(i).getVariable() == 4) {
                    termX += termList.get(i).getCoefficient();
                }
                eq += termX;

            }

        }
        eq += "= ";

        for (int i = 0; i < 4; i++) {
            if (termList.get(i).getSide() == 1) {
                String termX = "";

                if (termList.get(i).getVariable() == 1) {
                    termX += "x^2 ";
                }
                if (termList.get(i).getVariable() == 2) {
                    termX += "y^2 ";
                }
                if (termList.get(i).getVariable() == 3) {
                    termX += "z^2 ";
                }
                if (termList.get(i).getVariable() == 4) {
                    termX += termList.get(i).getCoefficient();
                }
                eq += termX;

            }

        }
        return eq;

    }

}

