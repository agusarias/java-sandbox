package org.a2.sandbox.Problems.RemoveDup;

import org.a2.sandbox.DataStructures.LinkedList.LinkedList;
import org.a2.sandbox.DataStructures.LinkedList.Node;

import java.util.HashSet;

public class Solution<E> {

    public LinkedList<E> solve(LinkedList<E> input) {
        Node<E> current;
        HashSet<E> hashSet = new HashSet<E>();
        while (input.hasNext()) {
            current = input.nextNode();
            if (hashSet.contains(current.data)) {
                input.remove(current);
            } else {
                hashSet.add(current.data);
            }
        }
        return input;
    }
}
