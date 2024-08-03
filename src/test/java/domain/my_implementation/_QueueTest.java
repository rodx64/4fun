package domain.my_implementation;

import domain.my_implementation._Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class _QueueTest {

    @Test
    void validateMyQueue() {
        _Queue queue = new _Queue(4);
        assertEquals(4, queue.first.value);
        assertEquals(4, queue.last.value);
        assertEquals(1, queue.length);
        queue.printQueue();
    }

    @Test
    void validateMyEnqueue() {
        _Queue queue = new _Queue(1);
        assertEquals(1, queue.first.value);
        assertEquals(1, queue.last.value);
        assertEquals(1, queue.length);

        queue.enqueue(2);
        assertEquals(1, queue.first.value);
        assertEquals(2, queue.last.value);
        assertEquals(2, queue.length);

        queue.enqueue(3);
        assertEquals(1, queue.first.value);
        assertEquals(3, queue.last.value);
        assertEquals(3, queue.length);
    }

    @Test
    void validateMyDequeue() {
        _Queue queue = new _Queue(1);
        assertEquals(1, queue.first.value);
        assertEquals(1, queue.last.value);
        assertEquals(1, queue.length);

        queue.enqueue(2);
        assertEquals(1, queue.first.value);
        assertEquals(2, queue.last.value);
        assertEquals(2, queue.length);

        queue.dequeue();
        assertEquals(2, queue.first.value);
        assertEquals(2, queue.last.value);
        assertEquals(1, queue.length);

        queue.dequeue();
        assertNull(queue.first);
        assertNull(queue.last);
        assertEquals(0, queue.length);
    }

}