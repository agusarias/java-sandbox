package org.a2.sandbox.Problems.OrderingStacks;

import java.util.Stack;

public class Solution {

    public Stack<Integer> solve(Stack<Integer> stack) {

        Stack<Integer> aux = new Stack<Integer>();

        // Find biggest and smallest numbers of stack, insert the rest in aux
        Integer size = stack.size();
        Integer iterations;
        Integer max = null;
        Integer min = null;

        for (int index = 0; index < size / 2; index++) {
            iterations = size - index * 2;
            while (!stack.isEmpty() && iterations-- > 0) {
                Integer current = stack.pop();
                Integer toInsert = current;
                if (max == null || current > max) {
                    toInsert = max;
                    max = current;
                }
                if (toInsert != null) {
                    aux.push(toInsert);
                }
            }
            stack.push(max);

            iterations = size - index * 2 - 1;
            while (!aux.isEmpty() && iterations-- > 0) {
                Integer current = aux.pop();
                Integer toInsert = current;
                if (min == null || current < min) {
                    toInsert = min;
                    min = current;
                }
                if (toInsert != null) {
                    stack.push(toInsert);
                }
            }
            aux.push(min);
            max = min = null;
            
            System.out.println("Stack: ");
            System.out.println(stack);
            System.out.println("Aux: ");
            System.out.println(aux);
        }

        // After ordering half the stack, push all
        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }

        return stack;
    }
}
