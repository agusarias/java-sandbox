package org.a2.sandbox.Problems.SumLinkedLists;

import org.a2.sandbox.DataStructures.LinkedList;

public class Solution {

    private static final int BASE = 10;

    public LinkedList<Integer> solve(LinkedList<Integer> inputA, LinkedList<Integer> inputB) {
        Integer valueA = arrayValue(inputA);
        Integer valueB = arrayValue(inputB);

        return serializeValue(valueA + valueB);
    }

    public LinkedList<Integer> solveReversed(LinkedList<Integer> inputA, LinkedList<Integer> inputB) {
        Integer valueA = arrayValueReversed(inputA);
        Integer valueB = arrayValueReversed(inputB);

        return serializeValueReversed(valueA + valueB);
    }

    private LinkedList<Integer> serializeValue(int value) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (value > 0) {
            Integer digit = value % BASE;
            result.add(digit);
            value = (value - digit) / BASE;
        }
        return result;
    }

    private LinkedList<Integer> serializeValueReversed(int value) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (value > 0) {
            Integer digit = value % BASE;
            result.addFirst(digit);
            value = (value - digit) / BASE;
        }
        return result;
    }

    private Integer arrayValue(LinkedList<Integer> input) {
        Integer value = 0;
        Integer multiplier = 1;
        while (input.hasNext()) {
            value += input.next() * multiplier;
            multiplier *= BASE;
        }
        return value;
    }

    private Integer arrayValueReversed(LinkedList<Integer> input) {
        Integer value = 0;
        while (input.hasNext()) {
            value *= BASE;
            value += input.next();
        }
        return value;
    }

}
