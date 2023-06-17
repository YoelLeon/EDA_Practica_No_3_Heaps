package queue;

import myExceptions.ExceptionIsEmpty;

public class PriorityQueueHeap<T extends Comparable<T>> {
        private Heap<PriorityElement<T>> heap;
        private SkipList<PriorityElement<T>> skipList;

    public PriorityQueueHeap() {
            heap = new Heap<>();
            skipList = new SkipList<>();
     }

    public void enqueue(T element, int priority) {
        PriorityElement<T> priorityElement = new PriorityElement<>(element, priority);
        heap.insert(priorityElement);
        skipList.insert(priorityElement);
    }
    
    public T dequeue() throws ExceptionIsEmpty {
    if (heap.isEmpty()) {
        throw new ExceptionIsEmpty("Priority queue is empty");
    }
    PriorityElement<T> priorityElement = heap.remove();
    skipList.remove(priorityElement);
    return priorityElement.getElement();
}

    public T front() throws ExceptionIsEmpty {
        return heap.first().getElement();
    }

    public T back() throws ExceptionIsEmpty {
        return heap.last().getElement();
    }

    private class PriorityElement<E extends Comparable<E>> implements Comparable<PriorityElement<E>> {
        private E element;
        private int priority;

        public PriorityElement(E element, int priority) {
            this.element = element;
            this.priority = priority;
        }

        public E getElement() {
            return element;
        }

        public int getPriority() {
            return priority;
        }

        public int compareTo(PriorityElement<E> other) {
            return Integer.compare(this.priority, other.getPriority());
        }

        public String toString() {
            return this.element.toString();
        }
    }
    

    public String toString() {
        return heap.toString();
    }
}