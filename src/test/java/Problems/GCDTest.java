package Problems;

import org.a2.sandbox.Problems.GreatestCommonDivisor.GCD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GCDTest {

    @Test
    public void testFirstUseCase() {
        // GIVEN
        GCD solution = new GCD();
        Integer expected = 2;
        int[] input = {2, 4, 6, 8, 10};

        // WHEN
        Integer result = solution.generalizedGCD(input.length, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testSecondUseCase() {
        // GIVEN
        GCD solution = new GCD();
        Integer expected = 1;
        int[] input = {2, 3, 4, 5, 6};

        // WHEN
        Integer result = solution.generalizedGCD(input.length, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testThirdUseCase() {
        // GIVEN
        GCD solution = new GCD();
        Integer expected = 5;
        int[] input = {25, 15, 75, 10, 100};

        // WHEN
        Integer result = solution.generalizedGCD(input.length, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testFourthUseCase() {
        // GIVEN
        GCD solution = new GCD();
        Integer expected = 1;
        int[] input = {25, 15, 75, 10, 100, 100, 100, 100, 99};

        // WHEN
        Integer result = solution.generalizedGCD(input.length, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testFifthUseCase() {
        // GIVEN
        GCD solution = new GCD();
        Integer expected = 1;
        int[] input = {1,1,1};

        // WHEN
        Integer result = solution.generalizedGCD(input.length, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testSixthUseCase() {
        // GIVEN
        GCD solution = new GCD();
        Integer expected = 1;
        int[] input = {10, 11, 10};

        // WHEN
        Integer result = solution.generalizedGCD(input.length, input);

        // THEN
        assertEquals(expected, result);
    }
}
