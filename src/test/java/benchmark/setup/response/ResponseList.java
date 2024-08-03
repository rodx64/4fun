package benchmark.setup.response;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static benchmark.setup.Constants.MAX_SIZE;

public class ResponseList extends Response {

    protected final static List<Integer> arrayList = new ArrayList<>();
    protected final static List<Integer> linkedList = new LinkedList<>();

    protected static void addAll(List<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_SIZE; i++) {
            list.add(i);
        }
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        insert.put(list.getClass().getSimpleName(), duration);
    }

    protected static void addByIndex(List<Integer> list) {
        startTime = System.currentTimeMillis();
        list.add(0, MAX_SIZE + 1);
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        insertFirst.put(list.getClass().getSimpleName(), duration);
    }

    /**
     * If you look in the worst case (MAX_SIZE), both lists could be faster. Because both will need to touch all
     */
    protected static void getByIndex(List<Integer> list) {
        int index = MAX_SIZE / 4;
        startTime = System.currentTimeMillis();
        list.get(index);
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        readByIndex.put(list.getClass().getSimpleName(), duration);
    }

    protected static void contains(List<Integer> list) {
        int index = MAX_SIZE / 4;
        startTime = System.currentTimeMillis();
        list.contains(index);
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        readByValue.put(list.getClass().getSimpleName(), duration);
    }

    protected static void removeFirst(List<Integer> list) {
        startTime = System.currentTimeMillis();
        list.remove(0);
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        deleteFirst.put(list.getClass().getSimpleName(), duration);
    }

    protected static void removeLast(List<Integer> list) {
        int last = list.size() - 1;
        if(list instanceof LinkedList){
            startTime = System.currentTimeMillis();
            ((LinkedList<Integer>) list).removeLast();
        } else {
            startTime = System.currentTimeMillis();
            list.remove(last);
        }
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        deleteLast.put(list.getClass().getSimpleName(), duration);
    }

}
