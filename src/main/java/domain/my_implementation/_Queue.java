package domain.my_implementation;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class _Queue {

    /**
     * Details:
     * FIFO
     */

    Node first;
    Node last;
    int length;

    public _Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node tmp = first;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if (length == 0) return null;

        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }

        length--;
        return first;
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
