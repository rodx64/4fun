package benchmark.setup.response;

import java.util.Map;

public abstract class SetupResponseQueue extends ResponseQueue {

    public static Map<Object, Long> addingMap() {
        offer(arrayDeque);
        offer(priorityQueue);
        return insert;
    }
    public static Map<Object, Long> readFirst() {
        peek(arrayDeque);
        peek(priorityQueue);
        return readByIndex;
    }

    public static Map<Object, Long> removingHeadMap() {
        poll(arrayDeque);
        poll(priorityQueue);
        return deleteFirst;
    }

    public static Map<Object, Long> removingMap() {
        removeByValue(arrayDeque);
        removeByValue(priorityQueue);
        return delete;
    }

}
