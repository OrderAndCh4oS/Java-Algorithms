package com.oacc.collections;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by sarcoma on 23/01/17.
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        N++;
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    public Item dequeue() {
        N--;
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String args[]) {
        Queue<String> collection = new Queue<>();
        collection.enqueue("First");
        collection.enqueue("Second");
        collection.enqueue("Third");
        StdOut.println(collection.size());
        for(String s:collection) {
            StdOut.println(s);
        }
        StdOut.println(collection.dequeue());
        StdOut.println(collection.size());
        StdOut.println(collection.isEmpty());

    }
}
