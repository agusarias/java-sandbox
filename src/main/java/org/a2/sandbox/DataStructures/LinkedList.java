package org.a2.sandbox.DataStructures;

public class LinkedList<E> {
    private Node<E> root;
    private Node<E> last;
    private Node<E> index;

    private Integer size = 0;


    public LinkedList<E> add(E element) {
        Node<E> newNode = new Node<E>(element);

        if (this.last == null) {
            this.index = this.last = this.root = newNode;
        } else {
            // Insert last
            this.last.next = newNode;
            newNode.previous = this.last;
            this.last = newNode;
        }
        this.size++;

        return this;
    }

    public LinkedList<E> addFirst(E element) {
        Node<E> newNode = new Node<E>(element);

        if (this.last == null) {
            this.index = this.last = this.root = newNode;
        } else {
            // Insert first
            this.root.previous= newNode;
            newNode.next = this.root;
            this.root = newNode;
        }
        this.size++;

        return this;
    }

    public Integer size() {
        return this.size;
    }

    public boolean contains(E element) {
        return this.findNode(element) != null;
    }

    public boolean remove(E element) {
        Node<E> nodeToRemove = this.findNode(element);
        return this.remove(nodeToRemove);
    }

    public boolean remove(Node<E> nodeToRemove) {

        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove.previous != null) {
            nodeToRemove.previous.next = nodeToRemove.next;
        } else {
            this.index = this.root = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = nodeToRemove.previous;
        } else {
            this.last = nodeToRemove.previous;
        }

        if (nodeToRemove.equals(this.index)){
            this.index = nodeToRemove.previous;
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

    public E next(){
        Node<E> current = this.index;
        this.index = current.next;
        return current.data;
    }

    public Node<E> nextNode(){
        Node<E> current = this.index;
        this.index = current.next;
        return current;
    }

    public void reset(){
        this.index = this.root;
    }

    public boolean hasNext(){
        return this.index != null;
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

    public boolean equals(LinkedList<E> other){
        this.reset();
        other.reset();

        while (this.hasNext() && other.hasNext()){
            if(!this.next().equals(other.next())){
                return false;
            }
        }

        return this.hasNext() == other.hasNext();
    }

}