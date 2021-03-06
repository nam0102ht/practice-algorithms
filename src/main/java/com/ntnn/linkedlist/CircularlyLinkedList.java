package com.ntnn.linkedlist;


public class CircularlyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node next;

        public Node() {}

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node<E> tail;
    private int size;

    public CircularlyLinkedList( ) {
        tail = null;
        size = 0;
    }

    // access methods
    public int size( ) { return size; }

    public boolean isEmpty( ) { return size == 0; }

    public E first( ) { // returns (but does not remove) the first element
        if (isEmpty( )) return null;
        return (E) tail.getNext().getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement( );
    }

    // update methods
    public void rotate( ) { // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
            tail = tail.getNext(); // the old head becomes the new tail
    }
    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext( ));
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext(); // now new element becomes the tail
    }

    public E removeFirst( ) { // removes and returns the first element
        if (isEmpty( )) return null; // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null; // must be the only node left
        else tail.setNext(head.getNext( )); // removes head from the list
        this.size = this.size - 1;
        return head.getElement();
    }

    public void printCircular() {
        if (size == 0) return;
        Node<E> currentNode = tail;
        System.out.println();
        do {
            System.out.print(currentNode.getElement().toString() + " ");
            currentNode = currentNode.getNext();
        } while (currentNode != tail);
    }

    public int getSize() {return size;}


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> circularlyLinkedList = new CircularlyLinkedList<>();
        circularlyLinkedList.addFirst(1);
        circularlyLinkedList.addFirst(3);
        circularlyLinkedList.addFirst(4);
        circularlyLinkedList.addLast(5);
        circularlyLinkedList.printCircular();
        circularlyLinkedList.rotate();
        circularlyLinkedList.printCircular();
    }

}
