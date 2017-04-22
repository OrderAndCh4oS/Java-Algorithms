package com.oacc.collections;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by sarcoma on 23/01/17.
 */
public class Stack<Item> implements Iterable<Item> {
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

    public void push(Item item) {
        N++;
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
    }

    public Item pop() {
        N--;
        Item item = first.item;
        first = first.next;
        return item;
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

        @Override
        public void remove() {
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String args[]) {
        Stack<String> collection = new Stack<>();
        StdOut.println(collection.isEmpty());
        collection.push("First");
        collection.push("Second");
        collection.push("Third");
        for (String s : collection) {
            StdOut.println(s);
        }
        collection.pop();
        for (String s : collection) {
            StdOut.println(s);
        }
        StdOut.println(collection.size());
    }

}
