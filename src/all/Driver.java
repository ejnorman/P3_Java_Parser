package all;

import all.TreePackage.BinarySearchTree;

public class Driver {
    public static void main(String[] args) {
        Parser p = new Parser();
        p.initializeReservedWords("src/reservedWords.txt");
        p.getIdentifiers("src/all/Palindrome.java");
        BinarySearchTree<String> identifiers = p.getIdentifiersTree();
        BinarySearchTree<String> reserved = p.getReservedTree();
        identifiers.iterativeInorderTraverse();
        System.out.println();
        reserved.iterativeInorderTraverse();
    }
}
