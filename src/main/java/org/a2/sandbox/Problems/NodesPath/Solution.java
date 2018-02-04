package org.a2.sandbox.Problems.NodesPath;

import org.a2.sandbox.DataStructures.Graph.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean solve(Node from, Node to) {
        return breadthFirstSearch(from, to);
    }

    private boolean breadthFirstSearch(Node from, Node to) {
        if (from == null || to == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<Node>();

        // Start from the origin
        queue.add(from);

        while (!queue.isEmpty()) {
            Node node = queue.remove(); // Pop
            if (node.visited) {
                continue;
            }
            if (node.name.equals(to.name)) {
                System.out.println("found: " + node);
                return true;
            }
            node.visited = true;
            System.out.println(node);
            queue.addAll(node.children);
        }

        return false;
    }

    public boolean depthFirstSearch(Node from, Node to) {
        if (from == null || to == null) {
            return false;
        }

        if(from.visited){
            return false;
        }

        from.visited = true;
        System.out.println(from);

        if (from.name.equals(to.name)) {
            System.out.println("found: " + from);
            return true;
        } else {
            for (Node node : from.children) {
                if(depthFirstSearch(node, to)){
                    return true;
                }
            }
        }

        return false;
    }
}
