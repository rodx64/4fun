package setup.dataStructures.stack;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class _Stack {

    /**
     *  Details:
     *  -   LIFO -> Last In First Out
     *
     *  -   The "best" way to reproduce a Stack is using a LinkedList,
     *      because from the beginning always is O(1) to Push AND Remove items.
     *      And it's great for a LIFO
     *
     */

    private Node top;
    private int height;

    public _Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node tmp = top;
        while(tmp != null){
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public void push(int i) {
        Node newNode = new Node(i);
        if(height > 0) newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop() {
        if(height == 0) return null;

        Node tmp = top;
        top = top.next;
        tmp.next = null;
        height--;
        return tmp;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
}
