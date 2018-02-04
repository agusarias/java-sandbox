package DataStructures;

import org.a2.sandbox.DataStructures.LinkedList.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    @Test
    public void addSome() {
        // GIVEN
        LinkedList<String> words = new LinkedList<String>();

        // WHEN
        words.add("Oh");
        words.add("My");
        words.add("Code");

        // THEN
        assertEquals(3, (int) words.size());
        assertFalse(words.isEmpty());
        assertTrue(words.contains("Oh"));
        assertTrue(words.contains("My"));
        assertTrue(words.contains("Code"));
    }

    @Test
    public void addThenRemove() {
        // GIVEN
        LinkedList<String> words = new LinkedList<String>();

        words.add("Oh");
        words.add("My");
        words.add("Code");

        // WHEN
        boolean result = words.remove("My");

        // THEN
        assertEquals(2, (int) words.size());
        assertTrue(result);
        assertFalse(words.isEmpty());
        assertTrue(words.contains("Oh"));
        assertFalse(words.contains("My"));
        assertTrue(words.contains("Code"));
    }


    @Test
    public void addThenRemoveAndGetLast() {
        // GIVEN
        LinkedList<String> words = new LinkedList<String>();

        words.add("Oh");
        words.add("My");
        words.add("Code");

        // WHEN
        boolean result = words.remove("Code");

        // THEN
        assertEquals(2, (int) words.size());
        assertEquals("My", words.getLast());
        assertTrue(result);
        assertFalse(words.isEmpty());
        assertTrue(words.contains("Oh"));
        assertTrue(words.contains("My"));
        assertFalse(words.contains("Code"));
    }

    @Test
    public void addThenRemoveAndAddAgain() {
        // GIVEN
        LinkedList<String> words = new LinkedList<String>();

        // WHEN
        words.add("Oh");
        words.add("My");
        words.add("Code");
        boolean result = words.remove("Code");
        words.add("Code");

        // THEN
        assertEquals(3, (int) words.size());
        assertEquals("Code", words.getLast());
        assertTrue(result);
        assertFalse(words.isEmpty());
        assertTrue(words.contains("Oh"));
        assertTrue(words.contains("My"));
        assertTrue(words.contains("Code"));
    }

    @Test
    public void testEqualityTrue() {
        // GIVEN
        LinkedList<Integer> inputA = new LinkedList<Integer>();
        LinkedList<Integer> inputB = new LinkedList<Integer>();

        // WHEN
        inputA.add(7).add(1).add(6);
        inputB.add(7).add(1).add(6);

        // THEN
        assertTrue(inputA.equals(inputB));
    }

    @Test
    public void testEqualityFalseShort() {
        // GIVEN
        LinkedList<Integer> inputA = new LinkedList<Integer>();
        LinkedList<Integer> inputB = new LinkedList<Integer>();

        // WHEN
        inputA.add(7).add(1).add(6);
        inputB.add(7).add(1);

        // THEN
        assertFalse(inputA.equals(inputB));
    }

    @Test
    public void testEqualityFalseShortOther() {
        // GIVEN
        LinkedList<Integer> inputA = new LinkedList<Integer>();
        LinkedList<Integer> inputB = new LinkedList<Integer>();

        // WHEN
        inputA.add(7).add(1);
        inputB.add(7).add(1).add(6);

        // THEN
        assertFalse(inputA.equals(inputB));
    }

    @Test
    public void testEqualityFalseDifferent() {
        // GIVEN
        LinkedList<Integer> inputA = new LinkedList<Integer>();
        LinkedList<Integer> inputB = new LinkedList<Integer>();

        // WHEN
        inputA.add(7).add(1).add(6);
        inputB.add(5).add(9).add(2);

        // THEN
        assertFalse(inputA.equals(inputB));
    }


}
