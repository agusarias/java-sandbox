package Problems;

import org.a2.sandbox.DataStructures.LinkedList;
import org.a2.sandbox.Problems.RemoveDup.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveDupTest {

    @Test
    public void testDuplicateStrings(){

        Solution<String> solution = new Solution<String>();
        LinkedList<String> words = new LinkedList<String>();

        words.add("Oh");
        words.add("My");
        words.add("My");
        words.add("Code!");

        solution.solve(words);

        assertTrue(!words.isEmpty());
        assertEquals(3, (int) words.size());
        assertTrue(words.contains("My"));
    }
}

