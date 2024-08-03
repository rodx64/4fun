package domain.my_implementation;

public class _BinarySearchTree {

    /**
     * Details:
     * + Tree Basics
     * -   Full Tree -> Every node points to zero or two other nodes
     * -   Perfect Tree -> All tree nodes are filled
     * -   Complete Tree -> Fills the Tree from Left to Right with no gaps
     * -   All Trees have only one Parent
     * <p>
     * + Binary Search
     * -  From parent to child, the value on the left is the smallest and the value on the right is the largest.
     */

    Node root;

    public _BinarySearchTree() {
        root = null;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        while (true) {
            if (newNode.value == temp.value) return false; // avoiding duplicity

            if (newNode.value < temp.value) {
                if (temp.left == null) { // if the spot is open, put newNode there
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left; // else, the spot value is the new temp value
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node tmp = root;

        while (tmp != null) {
            if (value < tmp.value) {
                tmp = tmp.left;
            } else if (value > tmp.value) {
                tmp = tmp.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
