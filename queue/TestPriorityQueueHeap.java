package queue;

import myExceptions.ExceptionIsEmpty;

public class TestPriorityQueueHeap {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueHeap<String> queue = new PriorityQueueHeap<String>();
        
        // Agregamos los elementos y su prioridad
        // 13, 14, 16, 24, 21, 19, 68, 65, 26, 32, 31
        System.out.println("Agregando elementos");
        queue.enqueue("13", 13);
        System.out.println(queue);
        queue.enqueue("14", 14);
        System.out.println(queue);
        queue.enqueue("16", 16);
        System.out.println(queue);
        queue.enqueue("24", 24);
        System.out.println(queue);
        queue.enqueue("21", 21);
        System.out.println(queue);
        queue.enqueue("19", 19);
        System.out.println(queue);
        queue.enqueue("68", 68);
        System.out.println(queue);
        queue.enqueue("65", 65);
        System.out.println(queue);
        queue.enqueue("26", 26);
        System.out.println(queue);
        queue.enqueue("32", 32);
        System.out.println(queue);
        queue.enqueue("31", 31);
        System.out.println(queue);
        
        // Prueba de elemento con más y menos prioridad
        System.out.println("\nMuestra el primer y último elemento de la cola de prioridad");
        System.out.println(queue.front() + ", " + queue.back() + "\n" );

        // Quitamos los elementos según su prioridad
        System.out.println("Quitando elementos de la cola de prioridad");
        for (int i = 0; i < 11; i++) {
            queue.dequeue();
            System.out.println(queue);
        }
    }
}