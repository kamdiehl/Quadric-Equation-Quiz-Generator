package model;

public class Quiz {

    // These provide the range of what the coefficients a,b,c can exist between
    private int maxValue = 10;
    private int minValue = 1;

    public Quiz(int maxVal, int minVal) {
        maxValue = maxVal;
        minValue = minVal;

    }

    // Getters

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }
}
