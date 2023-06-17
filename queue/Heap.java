package queue;

import java.util.ArrayList;

import myExceptions.ExceptionIsEmpty;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public Heap() {
        heap = new ArrayList<T>();
    }

    public void insert(T element) {
        if (heap.isEmpty()) {
            heap.add(element);
            return;
        }
        heap.add(0, element);
        int index;
        for (int i = 0; i < 2; i++) {
            index = 0;
            while (index < heap.size()) {
                int leftChildIndex = 2 * index + 1;
                int rightChildIndex = 2 * index + 2;
                int maxChildIndex = -1;
                if (leftChildIndex < heap.size()) {
                    if (rightChildIndex < heap.size()) {
                        maxChildIndex = heap.get(leftChildIndex).compareTo(heap.get(rightChildIndex)) > 0
                                ? leftChildIndex
                                : rightChildIndex;
                    } else {
                        maxChildIndex = leftChildIndex;
                    }
                    if (heap.get(index).compareTo(heap.get(maxChildIndex)) < 0) {
                        T temp = heap.get(maxChildIndex);
                        heap.set(maxChildIndex, heap.get(index));
                        heap.set(index, temp);
                        index = maxChildIndex;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public T remove() throws ExceptionIsEmpty {
        if (heap.isEmpty())
            throw new ExceptionIsEmpty("Heap is empty");
        T root = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            int index = 0;
            int size = heap.size();
            while (index < size / 2) {
                int leftChildIndex = 2 * index + 1;
                int rightChildIndex = 2 * index + 2;
                int maxIndex = leftChildIndex;
                if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) > 0) {
                    maxIndex = rightChildIndex;
                }
                if (heap.get(index).compareTo(heap.get(maxIndex)) < 0) {
                    T temp = heap.get(index);
                    heap.set(index, heap.get(maxIndex));
                    heap.set(maxIndex, temp);
                    index = maxIndex;
                } else {
                    break;
                }
            }
        }
        return root;
    }

    public T first() throws ExceptionIsEmpty {
        if (heap.isEmpty())
            throw new ExceptionIsEmpty("Heap is empty");
        T root = heap.get(0);
        return root;
    }

    public T last() throws ExceptionIsEmpty {
        if (heap.isEmpty())
            throw new ExceptionIsEmpty("Heap is empty");
        T last = heap.get(heap.size() - 1);
        return last;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < heap.size(); i++) {
            str += heap.get(i);
            if (i < heap.size() - 1)
                str += ", ";
        }
        str += "]";
        return str;
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}