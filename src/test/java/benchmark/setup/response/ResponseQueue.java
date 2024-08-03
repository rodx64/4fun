package benchmark.setup.response;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import static benchmark.setup.Constants.MAX_SIZE;

public class ResponseQueue extends Response {

    protected final static Queue<Integer> arrayDeque = new ArrayDeque<>();
    protected final static Queue<Integer> priorityQueue = new PriorityQueue<>();

    protected static void offer(Queue<Integer> queue) {
        startTime = System.nanoTime();
        queue.offer(MAX_SIZE);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        insert.put(queue.getClass().getSimpleName(), duration);
    }

    protected static void peek(Queue<Integer> queue) {
        startTime = System.nanoTime();
        queue.peek();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        readByIndex.put(queue.getClass().getSimpleName(), duration);
    }

    protected static void poll(Queue<Integer> queue) {
        final Iterator<Integer> iterator = queue.iterator();
        startTime = System.nanoTime();
        queue.poll();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        deleteFirst.put(queue.getClass().getSimpleName(), duration);
    }

    protected static void removeByValue(Queue<Integer> queue) {
        Random rand = new Random();
        int randomNum = rand.nextInt((MAX_SIZE - 1) + 1) + 1;
        startTime = System.nanoTime();
        queue.remove(randomNum);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        delete.put(queue.getClass().getSimpleName(), duration);
    }

}
