package Problems;

import org.a2.sandbox.Problems.SmallestDiference.Solution;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SmallestDifferenceTest {

    public static final int DATASET = 300000;

    @Test
    public void firstTestFast() {
        Solution solution = new Solution();

        ArrayList<Integer> first = new ArrayList<>();
        for (int i = 0; i < DATASET/10; i++) {
            first.add(Double.valueOf((Math.random() * DATASET)).intValue());
        }

        ArrayList<Integer> second = new ArrayList<>();
        for (int i = 0; i < DATASET/10; i++) {
            second.add(Double.valueOf((Math.random() * DATASET)).intValue());
        }

        long startTime = System.currentTimeMillis();
        solution.solveFast(first, second);
        System.out.println("Fast: " + (System.currentTimeMillis() - startTime));

        assertTrue(true);
    }

    @Test
    public void firstTestSlow() {
        Solution solution = new Solution();

        ArrayList<Integer> first = new ArrayList<>();
        for (int i = 0; i < DATASET/10; i++) {
            first.add(Double.valueOf((Math.random() * DATASET)).intValue());
        }

        ArrayList<Integer> second = new ArrayList<>();
        for (int i = 0; i < DATASET/10; i++) {
            second.add(Double.valueOf((Math.random() * DATASET)).intValue());
        }

        long startTime = System.currentTimeMillis();
        solution.solveSlow(first, second);
        System.out.println("Slow: " + (System.currentTimeMillis() - startTime));

        assertTrue(true);
    }
}
