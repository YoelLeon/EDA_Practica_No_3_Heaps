package queue;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> heap;

    public Heap() {
        heap = new ArrayList<E>();
    }

    public void insert(E element) {

    }

    public E remove() {

        return null;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}