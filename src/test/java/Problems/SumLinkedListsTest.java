package Problems;

import org.a2.sandbox.DataStructures.LinkedList;
import org.a2.sandbox.Problems.SumLinkedLists.Solution;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SumLinkedListsTest {

    @Test
    public void testSum(){

        Solution solution = new Solution();
        LinkedList<Integer> inputA = new LinkedList<Integer>();
        LinkedList<Integer> inputB = new LinkedList<Integer>();
        LinkedList<Integer> expected = new LinkedList<Integer>();

        inputA.add(7).add(1).add(6);
        inputB.add(5).add(9).add(2);

        expected.add(2).add(1).add(9);

        LinkedList<Integer> result = solution.solve(inputA, inputB);

        assertTrue(result.equals(expected));
    }

    @Test
    public void testSumReversed(){

        Solution solution = new Solution();
        LinkedList<Integer> inputA = new LinkedList<Integer>();
        LinkedList<Integer> inputB = new LinkedList<Integer>();
        LinkedList<Integer> expected = new LinkedList<Integer>();

        inputA.add(6).add(1).add(7);
        inputB.add(2).add(9).add(5);

        expected.add(9).add(1).add(2);

        LinkedList<Integer> result = solution.solveReversed(inputA, inputB);

        assertTrue(result.equals(expected));
    }
}

