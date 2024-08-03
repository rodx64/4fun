package domain.my_implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Simplifying the structure of LinkedList
// Generic structure idea (resources/structure/linked-list-structure-idea.txt)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class _LinkedList {

    /**
     * Details:
     * - Linked Lists don't have sequential space in memory, so they don't have indexes.
     * - They have HEAD and TAIL, and between these the other data scattered in memory point to each other (pointer)
     */

    Node head;
    Node tail;
    int length;

    public _LinkedList(int value) {
        Node nodeA = new Node(value);
        head = nodeA;
        tail = nodeA;
        length = 1;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        // If the length is zero, the new node will be unique and will have a Head and Tail in it's own
        if (length == 0)
            head = newNode;
        else
            tail.next = newNode;

        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0)
            tail = newNode;
        else
            newNode.next = head;

        head = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        // We initialize two support variables to move through the list
        Node tmp = head;
        Node prev = head;

        // The previous value of tmp will be stored in prev
        // Tmp will move forward as long as next exists
        while (tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
        }

        // Coming to the end of the list, the new tail value is what is stored in prev
        // And next must be set to null
        tail = prev;
        tail.next = null;

        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return tmp;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        // Creating a pointer to the Head
        Node tmp = head;

        head = head.next;
        tmp.next = null;

        length--;

        if (length == 0)
            tail = null;

        return tmp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
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
        if (index < 0 || index > length) return false;

        if (index == length) {
            append(value);
            return true;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        Node prev = get(index - 1);
        Node newNode = new Node(value);
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index >= length || index < 0) return null;
        if (index == length - 1) return removeLast();
        if (index == 0) return removeFirst();

        Node prev = get(index - 1);
        Node tmp = prev.next;

        prev.next = tmp.next;
        tmp.next = null;
        length--;

        return prev;
    }

    public Node reverse() {
        if (length == 0) return null;

        Node tmp = head;
        head = tail;
        tail = tmp;

        Node before = null;
        Node after = tmp.next;

        for (int i = 0; i < length; i++) {
            // moving After through nodes
            // (before) -> (tmp) -> (after*)
            after = tmp.next;

            // turning arrows
            // from: (before) -> (tmp) -> (after) -> ...
            // to:   (before) <- (tmp) (after) -> ...
            // * creates a gap between tmp/after
            tmp.next = before;

            // moving Before through nodes
            // from:   (before) <- (tmp) (after) -> ...
            // to:     null <- (tmp | before*) (after) -> ...
            before = tmp;

            // moving tmp through nodes
            // from:   null <- (tmp | before*) (after) -> ...
            // to:     null <- (before) (after | tmp*) -> ...
            tmp = after;
        }

        return head;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
