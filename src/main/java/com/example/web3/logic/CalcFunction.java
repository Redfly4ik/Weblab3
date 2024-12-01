package com.example.web3.logic;

import java.util.Arrays;
public class CalcFunction {
    private static final double a = -0.5;
    private static final double b = 2;
    double[] xValues;
    double[] yValues;

    public CalcFunction(double start, double end, double step) {

        calculate(start,end,step);
    }


    public void calculate(double start, double end, double step) {

        int n = (int) countStep(start, end, step);
        xValues = new double[n];
        yValues = new double[n];

        for (int i = 0; i < n; i++) {
            xValues[i] = start + i * step ;
            yValues[i] = function(xValues[i]);
        }
    }

    public int getIndexOfMin(){
        int minI = 0;
        for (int i = 0; i < yValues.length; i++) {
            if (yValues[minI] > yValues[i]) minI = i;
        }
        return minI;
    }

    public int getIndexOfMax(){
        int maxI = 0;
        for (int i = 0; i < yValues.length; i++) {
            if (yValues[maxI] < yValues[i]) maxI = i;
        }
        return maxI;
    }

    public double countStep(double start, double end, double step) {
        if (start==end) return 0;
        return (int) ((end - start) / step + 1);
    }

    public double function(double x) {
        if (x <= 0.7) {
            return 1;
        } else if (x > 1.4) {
            return Math.exp(a * x) * Math.cos(b * x);
        } else {
            return a * Math.pow(x, 2) * Math.log(x);
        }
    }



    public double getX(int i) {
        return xValues[i];
    }

    public double getY(int i) {
        return yValues[i];
    }

    public double[] getXArr() {
        return xValues;
    }

    public double[] getYArr() {
        return yValues;
    }

    public double getSum() {
        return Arrays.stream(yValues).sum();
    }
    public double getAverage() {
        return getSum()/yValues.length;
    }
}
