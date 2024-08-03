package domain.my_implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class _DoublyLinkedList {

    /**
     * Details:
     * basic diff (prev on Node)
     */

    private Node head;
    private Node tail;
    private int length;

    public _DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node tmp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }
        length--;
        return tmp;
    }

    public void prepend(int i) {
        Node newNode = new Node(i);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node tmp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }
        length--;
        return tmp;
    }

    public Node get(int index) {
        if (index >= length || index < 0) return null;
        Node tmp = head;
        if (index < length / 2) {
            for (int j = 0; j < index; j++) tmp = tmp.next;
        } else {
            tmp = tail;
            for (int j = length - 1; j > index; j--) tmp = tmp.prev;
        }

        return tmp;
    }

    public boolean set(int index, int value) {
        Node tmp = get(index);
        if (tmp != null) {
            tmp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 1) return removeFirst();
        if (index == length - 1) return removeLast();

        Node tmp = get(index);

        tmp.next.prev = tmp.prev;
        tmp.prev.next = tmp.next;
        tmp.next = null;
        tmp.prev = null;
        length--;
        return tmp;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
}
