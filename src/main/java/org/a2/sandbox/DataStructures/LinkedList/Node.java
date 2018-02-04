package org.a2.sandbox.DataStructures.LinkedList;

public class Node<E> {
    public Node<E> next,
            previous;

    public E data;

    public Node(E data) {
        this.data = data;
    }

    public Node(Node next, Node previous, E data) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }
}