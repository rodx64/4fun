package benchmark.setup.response;

import java.util.Map;

public class SetupResponseList extends ResponseList {

    public static Map<Object, Long> addingAll(){
        addAll(arrayList);
        addAll(linkedList);
        return insert;
    }
    public static Map<Object, Long> addingByIndex(){
        addByIndex(arrayList);
        addByIndex(linkedList);
        return insertFirst;
    }
    public static Map<Object, Long> lookingByIndex(){
        getByIndex(arrayList);
        getByIndex(linkedList);
        return readByIndex;
    }
    public static Map<Object, Long> lookingByValue(){
        contains(arrayList);
        contains(linkedList);
        return readByValue;
    }

    public static Map<Object, Long> removingFirst(){
        removeFirst(arrayList);
        removeFirst(linkedList);
        return deleteFirst;
    }
    public static Map<Object, Long> removingLast(){
        removeLast(arrayList);
        removeLast(linkedList);
        return deleteLast;
    }
}


