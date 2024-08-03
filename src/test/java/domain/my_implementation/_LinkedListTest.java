package domain.my_implementation;

import domain.my_implementation._LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _LinkedListTest {

    @Test
    void validateMyLinkedList() {
        _LinkedList linkedList = new _LinkedList(4);

        assertEquals(4, linkedList.head.value);
        assertEquals(4, linkedList.tail.value);
        linkedList.printList();
    }

    @Test
    void validateMyAppend() {
        _LinkedList linkedList = new _LinkedList(1);
        linkedList.append(3);
        linkedList.append(7);

        assertEquals(1, linkedList.head.value);
        assertEquals(7, linkedList.tail.value);
        assertEquals(3, linkedList.length);
    }

    @Test
    void validateMyRemoveLast() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);
        linkedList.removeLast();

        assertEquals(12, linkedList.head.value);
        assertEquals(2, linkedList.length);
        assertEquals(88, linkedList.tail.value);

        linkedList.removeLast();
        linkedList.removeLast();

        assertEquals(0, linkedList.length);
        assertNull(linkedList.head);
        assertNull(linkedList.tail);

        linkedList.removeLast();
        assertEquals(0, linkedList.length);
    }

    @Test
    void validateMyPrepend() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);
        assertEquals(3, linkedList.length);
        assertEquals(12, linkedList.head.value);

        linkedList.prepend(11);
        assertEquals(4, linkedList.length);
        assertEquals(11, linkedList.head.value);
        assertEquals(7, linkedList.tail.value);
    }

    @Test
    void validateMyRemoveFirst() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);

        assertEquals(12, linkedList.head.value);
        assertEquals(7, linkedList.tail.value);
        assertEquals(3, linkedList.length);

        linkedList.removeFirst();
        assertEquals(88, linkedList.head.value);
        assertEquals(7, linkedList.tail.value);
        assertEquals(2, linkedList.length);

        linkedList.removeFirst();
        assertEquals(7, linkedList.head.value);
        assertEquals(7, linkedList.tail.value);
        assertEquals(1, linkedList.length);

        linkedList.removeFirst();
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
        assertEquals(0, linkedList.length);
    }

    @Test
    void validateMyGet() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);

        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(3));
        assertEquals(12, linkedList.get(0).value);
        assertEquals(88, linkedList.get(1).value);
        assertEquals(7, linkedList.get(2).value);
    }

    @Test
    void validateMySet() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);

        assertEquals(12, linkedList.get(0).value);
        assertEquals(88, linkedList.get(1).value);
        assertEquals(7, linkedList.get(2).value);

        assertFalse(linkedList.set(-1, 13));
        assertFalse(linkedList.set(3, 13));

        assertTrue(linkedList.set(2, 13));
        assertEquals(13, linkedList.get(2).value);
    }

    @Test
    void validateMyInsert() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);

        assertEquals(12, linkedList.get(0).value);
        assertEquals(88, linkedList.get(1).value);
        assertEquals(7, linkedList.get(2).value);

        linkedList.insert(1, 99);
        assertEquals(12, linkedList.get(0).value);
        assertEquals(99, linkedList.get(1).value);
        assertEquals(88, linkedList.get(2).value);
        assertEquals(7, linkedList.get(3).value);
    }

    @Test
    void validateMyRemove() {
        _LinkedList linkedList = new _LinkedList(12);
        linkedList.append(88);
        linkedList.append(7);
        linkedList.append(32);
        linkedList.append(9);

        assertNull(linkedList.remove(-1));
        assertNull(linkedList.remove(5));

        linkedList.remove(1);

        assertEquals(12, linkedList.get(0).value);
        assertEquals(7, linkedList.get(1).value);
        assertEquals(32, linkedList.get(2).value);
        assertEquals(9, linkedList.get(3).value);
        assertNull(linkedList.get(4));
    }

    @Test
    void validateMyReverse() {
        _LinkedList linkedList = new _LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        assertEquals(1, linkedList.get(0).value);
        assertEquals(2, linkedList.get(1).value);
        assertEquals(3, linkedList.get(2).value);
        assertEquals(4, linkedList.get(3).value);


        linkedList.reverse();
        assertEquals(4, linkedList.get(0).value);
        assertEquals(3, linkedList.get(1).value);
        assertEquals(2, linkedList.get(2).value);
        assertEquals(1, linkedList.get(3).value);
        assertNull(linkedList.get(4));
    }
}