package Problems;

import org.a2.sandbox.Problems.NextDayBits.Solution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NextDayBitsTest {

    @Test
    public void testFirstUseCase() {
        // GIVEN
        Solution solution = new Solution();
        ArrayList<Integer> expected = new ArrayList<>();
        int[] input = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;

        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(0);

        // WHEN
        List<Integer> result = solution.cellCompete(input, days);

        // THEN
        assertEquals(expected, result);
    }
}
