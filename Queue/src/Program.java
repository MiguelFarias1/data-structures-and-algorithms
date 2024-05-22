package src;

import src.implementations.Queue;

public class Program {
    public static void main(String[] args) {
        
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        try {
            for(var elemento : queue) System.out.println(elemento);
        }

        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}