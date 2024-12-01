package com.example.web3.logic;

import com.example.web3.logic.CalcFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcFunctionTest {
    double start = 0.8;
    double end = 2.0;
    double step = 0.005;
    public static final double eps = 1e-6;
    CalcFunction calcFunction;

    @BeforeEach
    void setUp() {
        calcFunction = new CalcFunction(start, end, step);
    }

    @Test
    void testGetIndexOfMax() {
        calcFunction.calculate(0.1, 1, 0.001);
        Assertions.assertEquals(0, calcFunction.getIndexOfMax());
    }

    @Test
    void testGetIndexOfMin() {
        calcFunction.calculate(0.1, 1, 0.001);
        Assertions.assertEquals(900, calcFunction.getIndexOfMin());
    }

    @Test
    void testFunctionInDifferentRanges() {
        // Проверка при x <= 0.7
        Assertions.assertEquals(1.0, calcFunction.function(0.5), eps);

        // Проверка при 0.7 < x <= 1.4
        double x1 = 1.0;
        double expected1 = -0.5 * Math.pow(x1, 2) * Math.log(x1);
        Assertions.assertEquals(expected1, calcFunction.function(x1), eps);

        // Проверка при x > 1.4
        double x2 = 2.0;
        double expected2 = Math.exp(-0.5 * x2) * Math.cos(2 * x2);
        Assertions.assertEquals(expected2, calcFunction.function(x2), eps);
    }

    @Test
    void testCountStep() {
        Assertions.assertEquals(9, calcFunction.countStep(1, 5, 0.5));
        Assertions.assertEquals(241, calcFunction.countStep(start, end, step));
    }

    @Test
    void testArrayYValues() {
        calcFunction.calculate(start, end, step);
        Assertions.assertEquals(-0.42342627594830196, calcFunction.getY(175), eps);
    }

    @Test
    void testArrayXValues() {
        calcFunction.calculate(start, end, step);


        Assertions.assertEquals(1.675, calcFunction.getX(175), eps);
    }

    @Test
    void testGetSum() {
        calcFunction.calculate(0, 3, 0.004);
        Assertions.assertEquals(117.89288902380359, calcFunction.getSum(), eps);
    }

    @Test
    void testGetAverage() {
        calcFunction.calculate(0, 3, 0.004);
        Assertions.assertEquals(0.15698121041784766, calcFunction.getAverage(), eps);
    }
}
