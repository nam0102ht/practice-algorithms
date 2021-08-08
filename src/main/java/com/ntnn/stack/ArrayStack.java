package com.ntnn.stack;

public class ArrayStack<E> implements Stack<E>{
    public static final int CAPACITY = 100;
    private E[] arr;
    private int t;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        arr = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) throws IllegalArgumentException {
        if (t == CAPACITY) {
            throw new IllegalArgumentException("Stack is full");
        }
        arr[++t] = e;
    }

    @Override
    public E pop() {
        if(isEmpty()) return null;
        E e = arr[t];
        arr[t] = null;
        return e;
    }

    @Override
    public E top() {
        if(isEmpty()) return null;
        return arr[t];
    }
}
