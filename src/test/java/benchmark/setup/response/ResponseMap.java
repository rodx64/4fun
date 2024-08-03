package benchmark.setup.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static benchmark.setup.Constants.MAX_SIZE;

public class ResponseMap extends Response {

    protected final static Map<Integer, String> hashMap = new HashMap<>();
    protected final static Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    protected final static Map<Integer, String> treeMap = new TreeMap<>();

    protected static void putAll(Map<Integer, String> map) {
        startTime = System.nanoTime();
        for (int i = 0; i < MAX_SIZE; i++) {
            map.put(i, "Test" + i);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        insert.put(map.getClass().getSimpleName(), duration);
    }

    protected static void getByIndex(Map<Integer, String> map) {
        int index = MAX_SIZE / 3;
        startTime = System.nanoTime();
        map.get(index);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        readByIndex.put(map.getClass().getSimpleName(), duration);
    }

    protected static void removeByIndex(Map<Integer, String> map) {
        startTime = System.nanoTime();
        for (int i = 0; i < MAX_SIZE; i++) {
            map.remove(i);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        delete.put(map.getClass().getSimpleName(), duration);
    }

    protected static void contains(Map<Integer, String> map) {
        startTime = System.nanoTime();
        map.containsKey(MAX_SIZE / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        contains.put(map.getClass().getSimpleName(), duration);
    }

}
