package org.a2.sandbox.DataStructures.Graph;

import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Node> children;
    public boolean visited = false;

    public Node(String name) {
        this.children = new ArrayList<Node>();
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
