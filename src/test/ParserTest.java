import all.Parser;
import all.TreePackage.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void initializeReservedWords() {
        Parser p = new Parser();
        p.initializeReservedWords("src/reservedWords.txt");
        String reservedWords = "abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import instanceof int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws transient true try var void volatile while ";
        assertEquals(reservedWords, p.getReservedWordsTree().iterativeInorderTraverseString());
    }

    @Test
    void getIdentifiers() {
        Parser p = new Parser();
        p.initializeReservedWords("src/reservedWords.txt");
        p.getIdentifiers("src/all/Palindrome.java");
        String identifiers = "0 1 A Palindrome String System all ans args charAt equals i isPalindrome length main out println rev str tacocat toLowerCase ";
        assertEquals(identifiers, p.getIdentifiersTree().iterativeInorderTraverseString());
        String reserved = "boolean class false for if int package public return static true void ";
        assertEquals(reserved, p.getReservedTree().iterativeInorderTraverseString());
    }

    @Test
    void getIdentifiersTree() {
        Parser p = new Parser();
        p.initializeReservedWords("src/reservedWords.txt");
        p.getIdentifiers("src/all/Palindrome.java");
        BinarySearchTree<String> identifiersTree = p.getIdentifiersTree();
        String identifiers = "0 1 A Palindrome String System all ans args charAt equals i isPalindrome length main out println rev str tacocat toLowerCase ";
        assertEquals(identifiers, identifiersTree.iterativeInorderTraverseString());
    }

    @Test
    void getReservedTree() {
        Parser p = new Parser();
        p.initializeReservedWords("src/reservedWords.txt");
        p.getIdentifiers("src/all/Palindrome.java");
        BinarySearchTree<String> reservedTree = p.getReservedTree();
        String reserved = "boolean class false for if int package public return static true void ";
        assertEquals(reserved, reservedTree.iterativeInorderTraverseString());
    }

    @Test
    void getReservedWords() {
        Parser p = new Parser();
        p.initializeReservedWords("src/reservedWords.txt");
        BinarySearchTree<String> reservedWordsTree = p.getReservedWordsTree();
        String reservedWords = "abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import instanceof int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws transient true try var void volatile while ";
        assertEquals(reservedWords, reservedWordsTree.iterativeInorderTraverseString());
    }
}
