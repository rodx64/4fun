package domain.my_implementation;

import domain.my_implementation._BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class _BinarySearchTreeTest {

    @Test
    void validateMyBinarySearchTree() {
        _BinarySearchTree bst = new _BinarySearchTree();
        assertEquals("_BinarySearchTree", bst.getClass().getSimpleName());
        assertNotNull(bst);
        assertNull(bst.root);
    }

    @Test
    void givenBinarySearchTree_whenInsertSameValue_thenReturnFalse() {
        _BinarySearchTree bst = new _BinarySearchTree();
        boolean wasInserted = bst.insert(10);
        assertTrue(wasInserted);
        assertEquals(bst.root.value, 10);

        boolean wasPossibleToInsertSame = bst.insert(10);

        assertNull(bst.root.right);
        assertNull(bst.root.left);
        assertFalse(wasPossibleToInsertSame);
    }

    @Test
    void givenBinarySearchTree_whenInsertDifferentValueOnRight_thenReturnTrue() {
        _BinarySearchTree bst = new _BinarySearchTree();
        boolean wasInserted = bst.insert(10);
        assertTrue(wasInserted);
        assertEquals(bst.root.value, 10);

        bst.insert(11);

        assertNull(bst.root.left);
        assertNotNull(bst.root.right);
        assertEquals(bst.root.right.value, 11);
    }

    @Test
    void givenBinarySearchTree_whenInsertDifferentValueOnLeft_thenReturnTrue() {
        _BinarySearchTree bst = new _BinarySearchTree();
        boolean wasInserted = bst.insert(10);
        assertTrue(wasInserted);
        assertEquals(bst.root.value, 10);

        bst.insert(9);

        assertNull(bst.root.right);
        assertNotNull(bst.root.left);
    }

    @Test
    void givenFilledBinarySearchTree_whenSearchAValidValue_thenReturnTrue() {
        _BinarySearchTree bst = new _BinarySearchTree();
        bst.insert(7);
        bst.insert(9);
        bst.insert(15);
        bst.insert(13);
        bst.insert(11);
        bst.insert(8);
        bst.insert(17);
        assertTrue(bst.contains(11));
    }

    @Test
    void givenFilledBinarySearchTree_whenSearchAnInvalidValue_thenReturnTrue() {
        _BinarySearchTree bst = new _BinarySearchTree();
        bst.insert(7);
        bst.insert(9);
        bst.insert(15);
        bst.insert(13);
        bst.insert(11);
        bst.insert(8);
        bst.insert(17);
        assertFalse(bst.contains(14));
    }

}