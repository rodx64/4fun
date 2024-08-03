package domain.my_implementation;

import domain.my_implementation._DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _DoublyLinkedListTest {

    @Test
    void validateMyDoublyLinkedList() {
        _DoublyLinkedList dll = new _DoublyLinkedList(7);
        dll.printList();

        assertEquals(7, dll.getHead().value);
        assertEquals(7, dll.getTail().value);
        assertEquals(1, dll.getLength());
    }

    @Test
    void validateAppend() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);

        assertEquals(1, dll.getHead().value);
        assertEquals(3, dll.getTail().value);
        assertEquals(3, dll.getLength());
    }

    @Test
    void validateRemoveLast() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);

        assertEquals(1, dll.getHead().value);
        assertEquals(3, dll.getTail().value);
        assertEquals(3, dll.getLength());

        dll.removeLast();
        assertEquals(1, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(2, dll.getLength());

        dll.removeLast();
        assertEquals(1, dll.getHead().value);
        assertEquals(1, dll.getTail().value);
        assertEquals(1, dll.getLength());

        dll.removeLast();
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getLength());
    }

    @Test
    void validatePrepend() {
        _DoublyLinkedList dll = new _DoublyLinkedList(2);
        dll.append(3);

        assertEquals(null, dll.getHead().prev);
        assertEquals(2, dll.getHead().value);
        assertEquals(3, dll.getTail().value);
        assertEquals(null, dll.getTail().next);
        assertEquals(2, dll.getLength());

        dll.prepend(1);
        assertEquals(null, dll.getHead().prev);
        assertEquals(1, dll.getHead().value);
        assertEquals(3, dll.getTail().value);
        assertEquals(null, dll.getTail().next);
        assertEquals(3, dll.getLength());
    }

    @Test
    void validateRemoveFirst() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(2);
        assertEquals(1, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(2, dll.getLength());

        dll.removeFirst();
        assertEquals(2, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(1, dll.getLength());

        dll.removeFirst();
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getLength());
    }

    @Test
    void validateGet() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);

        assertNull(dll.get(-1));
        assertEquals(1, dll.get(0).value);
        assertEquals(2, dll.get(1).value);
        assertEquals(3, dll.get(2).value);
        assertEquals(4, dll.get(3).value);
        assertNull(dll.get(5));
    }

    @Test
    void validateSet() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        assertEquals(1, dll.get(0).value);
        assertTrue(dll.set(0, 10));
        assertEquals(10, dll.get(0).value);
        assertFalse(dll.set(4, 11));
    }

    @Test
    void validateInsert() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(3);
        dll.append(4);
        dll.append(6);

        dll.insert(1, 2);
        assertEquals(1, dll.get(0).value);

        dll.insert(4, 5);
        assertNull(dll.get(-1));
        assertEquals(1, dll.get(0).value);
        assertEquals(2, dll.get(1).value);
        assertEquals(3, dll.get(2).value);
        assertEquals(4, dll.get(3).value);
        assertEquals(5, dll.get(4).value);
        assertEquals(6, dll.get(5).value);
        assertNull(dll.get(6));
    }

    @Test
    void validateRemove() {
        _DoublyLinkedList dll = new _DoublyLinkedList(1);
        dll.append(2);
        dll.append(10);
        dll.append(3);

        dll.remove(2);
        assertEquals(1, dll.get(0).value);
        assertEquals(2, dll.get(1).value);
        assertEquals(3, dll.get(2).value);
    }
}