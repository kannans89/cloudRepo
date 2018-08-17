package com.techlabs.percent.calculator;


public class PercentCalculator {

    public String xPercentOfY(long firstNo, long secondNo) {

        double ans = (float) (((float) firstNo / 100) * secondNo);
        String a = String.format("%.2f", ans);
        if (a.equals("NaN") || a.equals("Infinity") || a.equals("0.00"))
            return "";
        else
            return a;

    }

    public String xIsWhatPercentOfY(long firstNo, long secondNo) {
        double ans = (float) (((float) firstNo * 100) / secondNo);
        String a = String.format("%.2f", ans);
        if (a.equals("NaN") || a.equals("Infinity") || a.equals("0.00"))
            return "";
        else
            return a;
    }

    public String percentChangeFromXtoY(long firstNo, long secondNo) {
        double ans = (((float) (secondNo - firstNo) / firstNo) * 100);
        String a = String.format("%.2f", ans);
        if (a.equals("NaN") || a.equals("Infinity") || secondNo==0)
            return "";
        return a;
    }

}
