package org.a2.sandbox.DataStructures;

public class LinkedList<E> {
    Node<E> root;
    Node<E> last;
    Integer size = 0;


    public void add(E element) {
        Node<E> newNode = new Node<E>(element);

        if (this.last == null) {
            this.last = this.root = newNode;
        } else {
            // Insert last
            this.last.next = newNode;
            newNode.previous = this.last;
            this.last = newNode;
        }
        this.size++;
    }

    public Integer size() {
        return this.size;
    }

    public boolean contains(E element) {
        return this.findNode(element) != null;
    }

    public boolean remove(E element) {
        Node<E> nodeToRemove = this.findNode(element);

        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove.previous != null) {
            nodeToRemove.previous.next = nodeToRemove.next;
        } else {
            this.root = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = nodeToRemove.previous;
        } else {
            this.last = nodeToRemove.previous;
        }

        this.size--;

        return true;
    }

    public E getLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.last.data;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    private Node<E> findNode(E element) {
        if (this.isEmpty()) {
            return null;
        }

        Node<E> current = this.root;
        while (!current.data.equals(element)) {
            if (current.next != null) {
                current = current.next;
            } else {
                return null;
            }
        }
        return current;
    }

}

class Node<E> {
    Node<E> next,
            previous;

    E data;

    public Node(E data) {
        this.data = data;
    }

    public Node(Node next, Node previous, E data) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }
}