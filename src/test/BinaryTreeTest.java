import all.TreePackage.BinaryNode;
import all.TreePackage.BinarySearchTree;
import all.TreePackage.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void BinaryTree(){
        BinaryTree<Integer> bt = new BinaryTree<>(4);
        assertEquals(4, bt.getRootData());
    }

    @Test
    void setRootData() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.setRootData(4);
        assertEquals(4, tree.getRootData());
    }

    @Test
    void getRootData() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        assertEquals(5, tree.getRootData());
    }

    @Test
    void isEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        tree.add(5);
        tree.add(2);
        tree.add(7);
        assertFalse(tree.isEmpty());
    }

    @Test
    void clear() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @Test
    void getHeight() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        assertEquals(3, tree.getHeight());
    }

    @Test
    void getNumberOfNodes() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        assertEquals(3, tree.getNumberOfNodes());
    }

    @Test
    void setRootNode() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        BinaryNode<Integer> root = new BinaryNode<>(4);
        tree.setRootNode(root);
        assertEquals(4, tree.getRootData());
    }

    @Test
    void getRootNode() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        BinaryNode<Integer> root = tree.getRootNode();
        assertEquals(5, tree.getRootData());
    }

    @Test
    void getPreorderIterator() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(4);
        tree.add(1);
        Iterator<Integer> it = tree.getPreorderIterator();
        it.next();
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
    }

    @Test
    void getPostorderIterator() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(4);
        tree.add(1);
        Iterator<Integer> it = tree.getPostorderIterator();
        it.next();
        it.next();
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
    }

    @Test
    void getInorderIterator() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(4);
        tree.add(1);
        Iterator<Integer> it = tree.getInorderIterator();
        it.next();
        it.next();
        assertEquals(4, it.next());
        assertTrue(it.hasNext());
    }

    @Test
    void getLevelOrderIterator() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(4);
        tree.add(1);
        Iterator<Integer> it = tree.getLevelOrderIterator();
        it.next();
        it.next();
        assertEquals(7, it.next());
        assertTrue(it.hasNext());
    }

    @Test
    void iterativeInorderTraverseString() {
    }
}
