package org.a2.sandbox.Problems.Example;

public class Solution {

    protected static final String description = "given a nxn matrix, a start position, and an end position, find the optimum way out";

    public Result solve(Input input) {
        Input parsedInput = (Input) input;

        String result = this.flipWord(parsedInput.getWord());

        return new Result(result);
    }

    private String flipWord(String input) {
        char[] chars = input.toCharArray();
        char[] aux = new char[chars.length];

        int idx;

        for (idx = 0; idx < chars.length; idx++) {
            aux[chars.length - idx - 1] = chars[idx];
        }

        return new String(aux);
    }
}


