package main.java.TrigSeries;

import main.java.TrigSeries.Sin;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.sin(Math.PI/2)+", "+ Math.sin(-1)+", "+Math.sin(4)+"\n");
        System.out.println(Sin.sin(Math.PI/2,0.0)+", "+ Sin.sin(Double.NaN,0.0)+", "+Sin.sin(Double.POSITIVE_INFINITY,0.0));
    }
}
