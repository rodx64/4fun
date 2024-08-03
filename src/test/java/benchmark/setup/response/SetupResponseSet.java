package benchmark.setup.response;

import java.util.Map;

public abstract class SetupResponseSet extends ResponseSet {

    public static Map<Object, Long> addingMap() {
        addAll(hashSet);
        addAll(linkedHashSet);
        addAll(treeSet);
        return insert;
    }

    public static Map<Object, Long> removingMap() {
        removeAll(hashSet);
        removeAll(linkedHashSet);
        removeAll(treeSet);
        return delete;
    }

    public static Map<Object, Long> containsMap() {
        contains(hashSet);
        contains(linkedHashSet);
        contains(treeSet);
        return contains;
    }

    public static Map<Object, Long> next() {
        next(hashSet);
        next(linkedHashSet);
        next(treeSet);
        return next;
    }

}
