import all.TreePackage.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void getEntry() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        assertEquals(bst.getEntry(3), 3);
    }

    @Test
    void contains() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        assertTrue(bst.contains(4));
    }

    @Test
    void add() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(5);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        String inorder = "1 2 3 4 5 ";
        assertEquals(inorder, bst.iterativeInorderTraverseString());
    }

    @Test
    void remove() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(1);
        bst.remove(3);
        String inorder = "1 2 4 ";
        assertEquals(inorder, bst.iterativeInorderTraverseString());
    }
}
