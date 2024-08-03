package benchmark.setup.response;

import java.util.Map;

public class SetupResponseMap extends ResponseMap {

    public static Map<Object, Long> puttingMap() {
        putAll(hashMap);
        putAll(linkedHashMap);
        putAll(treeMap);
        return insert;
    }
    public static Map<Object, Long> gettingMap() {
        getByIndex(hashMap);
        getByIndex(linkedHashMap);
        getByIndex(treeMap);
        return readByIndex;
    }
    public static Map<Object, Long> removingMap() {
        removeByIndex(hashMap);
        removeByIndex(linkedHashMap);
        removeByIndex(treeMap);
        return delete;
    }

    public static Map<Object, Long> containsMap() {
        contains(hashMap);
        contains(linkedHashMap);
        contains(treeMap);
        return contains;
    }

}
