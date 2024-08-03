package benchmark.setup.response;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static benchmark.setup.Constants.MAX_SIZE;

public class ResponseSet extends Response {
    protected final static Set<Integer> hashSet = new HashSet<>();
    protected final static Set<Integer> treeSet = new TreeSet<>();
    protected final static Set<Integer> linkedHashSet = new LinkedHashSet<>();

    protected static void addAll(Set<Integer> set) {
        startTime = System.nanoTime();
        for (int i = 0; i < MAX_SIZE; i++) {
            set.add(i);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        insert.put(set.getClass().getSimpleName(), duration);
    }

    protected static void removeAll(Set<Integer> set) {
        startTime = System.nanoTime();
        for (int i = 0; i < MAX_SIZE; i++) {
            set.remove(i);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        delete.put(set.getClass().getSimpleName(), duration);
    }

    protected static void contains(Set<Integer> set) {
        startTime = System.nanoTime();
        set.contains(MAX_SIZE / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        contains.put(set.getClass().getSimpleName(), duration);
    }

    protected static void next(Set<Integer> set) {
        final Iterator<Integer> iterator = set.iterator();
        startTime = System.nanoTime();
        iterator.next();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        next.put(set.getClass().getSimpleName(), duration);
    }

}
