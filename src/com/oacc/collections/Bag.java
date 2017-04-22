package com.oacc.collections;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by sarcoma on 23/01/17.
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        public Item item;
        public Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        N++;
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

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
        Bag<String> collection = new Bag<>();
        StdOut.println(collection.isEmpty());
        collection.add("Test 1");
        collection.add("Test 2");
        collection.add("Test 3");
        for(String s:collection) {
            StdOut.println(s);
        }
        StdOut.println(collection.size());
    }
}
