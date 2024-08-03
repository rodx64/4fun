package benchmark.setup.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Response {
    protected static long startTime = 0;
    protected static long endTime = 0;
    protected static long duration = 0;
    protected final static Map<Object, Long> insert = new HashMap<>();
    protected final static Map<Object, Long> insertFirst = new HashMap<>();
    protected final static Map<Object, Long> readByIndex = new HashMap<>();
    protected final static Map<Object, Long> readByValue = new HashMap<>();
    protected final static Map<Object, Long> delete = new HashMap<>();
    protected final static Map<Object, Long> deleteFirst = new HashMap<>();
    protected final static Map<Object, Long> deleteLast = new HashMap<>();
    protected final static Map<Object, Long> deleteMiddle = new HashMap<>();
    protected final static Map<Object, Long> contains = new HashMap<>();
    protected final static Map<Object, Long> next = new HashMap<>();

    public static Map.Entry<Object, Long> getFaster(Map<Object, Long> map) {
        return Collections.min(map.entrySet(), Map.Entry.comparingByValue());
    }

    public static Map.Entry<Object, Long> getSlower(Map<Object, Long> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue());
    }
}
