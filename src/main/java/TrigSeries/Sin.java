package main.java.TrigSeries;

import java.math.BigInteger;

import static java.lang.Math.max;
import static java.lang.Math.pow;


public class Sin {

    public static Double sin(Double x, Double eps)
    {
        if (x.isInfinite() || x.isNaN()|| eps.isInfinite() || eps.isNaN() )
            return Double.NaN;
        double result = 0.0;
        double term = x;
        int n = 1;

        while (Math.abs(term) > eps) {
            result += term;
            term *= -x * x / (2 * n * (2 * n + 1));
            n++;
        }

//        for( int i = 0; i < eps; i++)
//            result += (pow(-1,i) * pow(x, 2 * i +1)) / getFactorial(2 * i + 1);

        return result;
    }

    private static long getFactorial(int n){
        long result = 1;

        for (int i = 2; i <= n; i++)
            result *= i;

        return result;
    }
}
