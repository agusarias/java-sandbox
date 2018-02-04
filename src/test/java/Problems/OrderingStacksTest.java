package Problems;

import org.a2.sandbox.Problems.OrderingStacks.Solution;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class OrderingStacksTest {

    @Test
    public void testFirst(){
        // GIVEN
        Solution solution = new Solution();
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> expected = new Stack<Integer>();

        input.push(1);
        input.push(16);
        input.push(8);
        input.push(7);
        input.push(3);

        expected.push(16);
        expected.push(8);
        expected.push(7);
        expected.push(3);
        expected.push(1);

        // WHEN
        Stack<Integer> result = solution.solve(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testSecond(){
        // GIVEN
        Solution solution = new Solution();
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> expected = new Stack<Integer>();

        input.push(1);
        input.push(16);
        input.push(8);
        input.push(17);
        input.push(99);
        input.push(53);
        input.push(22);
        input.push(41);
        input.push(89);
        input.push(73);
        input.push(39);

        expected.push(99);
        expected.push(89);
        expected.push(73);
        expected.push(53);
        expected.push(41);
        expected.push(39);
        expected.push(22);
        expected.push(17);
        expected.push(16);
        expected.push(8);
        expected.push(1);

        // WHEN
        Stack<Integer> result = solution.solve(input);

        // THEN
        assertEquals(expected, result);
    }
}
