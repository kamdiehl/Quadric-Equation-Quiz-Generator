package model;
import java.util.ArrayList;

public abstract class Surface {

    ArrayList<Term> termList = new ArrayList<Term>(4);
    // Array list called termList containing data type Term has 4 spots,
    // the first three are for the ax^2, by^2, and cz^2 terms, and the
    // last one is for d (an arbitrary integer)

    public void createTerm(int co, int var, int si) {

        Term newTerm = new Term(co, var, si);
        termList.add(newTerm);
// still don't get what this boi does can't remember why i made it
    }

    public String eqToString() {
        String eq = "";
        for (int i = 0; i < 4; i++) {
            if (termList.get(i).getSide() == 0) {
                String termX = "";

                if (termList.get(i).getCoefficient() > 0 && i != 0) {
                    termX += "+ ";
                }
                if (termList.get(i).getCoefficient() < 0) {
                    termX += "- ";
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

