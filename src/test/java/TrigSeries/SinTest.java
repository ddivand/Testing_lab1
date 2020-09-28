package test.java.TrigSeries;

import main.java.TrigSeries.Sin;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinTest {

    @Test
    public void inflectionPoints(){
        assertEquals("sin(pi)=0", Math.sin(Math.PI), Sin.sin(Math.PI,1E-6), 0.00001);
        assertEquals("sin(-pi)=0", Math.sin(-Math.PI), Sin.sin(-Math.PI,1E-6), 0.00001);
        assertEquals("sin(0)=0", Math.sin(0.0), Sin.sin(0.0,1E-6), 0.00001);
    }

    @Test
    public void extremumPoints(){
        assertEquals("sin(pi/2)=1", Math.sin(Math.PI/2), Sin.sin(Math.PI/2,1E-6), 0.00001);
        assertEquals("sin(-pi/2)=-1", Math.sin(-Math.PI/2), Sin.sin(-Math.PI/2,1E-6), 0.00001);
    }

    @Test
    public void precision(){
        assertEquals("eps = 1", 0.5, Sin.sin(Math.PI/6,1E-8), 1E-8);
        assertEquals("eps = 1", 0.5, Sin.sin(Math.PI/6,1E-14), 1E-14);
    }

    @Test
    public void infToNan(){
        assertEquals("not Nan",Double.NaN, Sin.sin(Double.POSITIVE_INFINITY,1E-6), 0.00001);
        assertEquals("not Nan",Double.NaN, Sin.sin(Double.NEGATIVE_INFINITY,1E-6), 0.00001);
    }

    @Test
    public void NanIsNan(){
        assertEquals("not Nan",Double.NaN, Sin.sin(Double.NaN,1E-6), 0.00001);
    }

    @Test
    public void invalidEps(){
        assertEquals("not Nan",Double.NaN, Sin.sin(Double.NaN,Double.POSITIVE_INFINITY), 0.00001);
        assertEquals("not Nan",Double.NaN, Sin.sin(Double.NaN,Double.NEGATIVE_INFINITY), 0.00001);
        assertEquals("not Nan",Double.NaN, Sin.sin(Double.NaN,Double.NaN), 0.00001);
    }

}
