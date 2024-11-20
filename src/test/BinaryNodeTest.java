import all.TreePackage.BinaryNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNodeTest {

    @Test
    void BinaryNode() {
        BinaryNode binaryNode = new BinaryNode();
        assertNull(binaryNode.getData());
    }

    @Test
    void isLeaf() {
        BinaryNode<Integer> bn = new BinaryNode<>(2);
        assertTrue(bn.isLeaf());
        BinaryNode<Integer> bnLeft = new BinaryNode<>(4);
        bn.setLeftChild(bnLeft);
        assertFalse(bn.isLeaf());
    }

    @Test
    void copy() {
        BinaryNode<Integer> bn = new BinaryNode<>(2);
        bn.setLeftChild(new BinaryNode<>(4));
        BinaryNode<Integer> copy = bn.copy();
        assertEquals(bn.getData(), copy.getData());
    }
}
