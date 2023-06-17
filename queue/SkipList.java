import java.util.Random;

public class SkipList<T extends Comparable<T>> {
    private static final int MAX_LEVEL = 32; // Número máximo de niveles en la Skip List
    private Node<T> head; // Nodo de la cabeza de la Skip List
    private int level; // Nivel actual de la Skip List
    private Random random; // Generador de números aleatorios

    public SkipList() {
        head = new Node<>(null, MAX_LEVEL);
        level = 0;
        random = new Random();
    }

    public void insert(T value) {
        int newLevel = randomLevel();
        if (newLevel > level) {
            level = newLevel;
        }

        Node<T> newNode = new Node<>(value, newLevel);
        Node<T> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }

            if (i <= newLevel) {
                newNode.forward[i] = current.forward[i];
                current.forward[i] = newNode;
            }
        }
    }

    public boolean remove(T value) {
        Node<T> current = head;
        boolean removed = false;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }

            if (current.forward[i] != null && current.forward[i].value.equals(value)) {
                current.forward[i] = current.forward[i].forward[i];
                removed = true;
            }
        }

        return removed;
    }

    public boolean contains(T value) {
        Node<T> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }

            if (current.forward[i] != null && current.forward[i].value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    private int randomLevel() {
        int level = 0;
        while (random.nextDouble() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T>[] forward;

        @SuppressWarnings("unchecked")
        public Node(T value, int level) {
            this.value = value;
            forward = new Node[level + 1];
        }
    }
}