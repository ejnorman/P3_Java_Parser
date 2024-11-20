package all;

import all.TreePackage.BinaryNode;
import all.TreePackage.BinarySearchTree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private BinarySearchTree<String> reservedWordsTree;
    private BinarySearchTree<String> identifiersTree;
    private BinarySearchTree<String> reservedTree;

    public Parser(){
        reservedWordsTree = new BinarySearchTree<>();
        identifiersTree = new BinarySearchTree<>();
        reservedTree = new BinarySearchTree<>();
    }

    /**
     * Create a binary search tree of reserved java words from text file
     * @param filePath path where text file of reserved words is located
     */
    public void initializeReservedWords(String filePath){
        ArrayList<String> reservedWords = new ArrayList<>();
        File f = new File(filePath);
        try(Scanner scanner = new Scanner(f)){
            while(scanner.hasNextLine()){ //read in every word
                String line = scanner.nextLine();
                if(!line.trim().isEmpty()){ //there were empty lines in the .txt originally
                    reservedWords.add(line); //add to list
                    }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        reservedWords.sort(null); //technically it is already sorted in the .txt
        reservedWordsTree.setRootNode(setBalancedBST(reservedWords, 0, reservedWords.size() - 1));
    }

    /**
     * Creates balanced tree from sorted list
     * @param sortedList sorted list of String values
     * @param start first index of window of values
     * @param end last index of window of values
     * @return root of balanced BST
     */
    private BinaryNode<String> setBalancedBST(ArrayList<String> sortedList, int start, int end){
        if(start > end){ //if went through all Strings in list
            return null; //then child does not exist
        }
        int mid = (start + end) / 2;
        BinaryNode<String> node = new BinaryNode<>(sortedList.get(mid)); //node is median value of window
        node.setLeftChild(setBalancedBST(sortedList, start, mid - 1)); //get median from left window
        node.setRightChild(setBalancedBST(sortedList, mid + 1, end)); //get median from right window
        return node;
    }

    /**
     * From a given java file create two balanced BSTs, one for reserved words, another for identifiers
     * @param filePath path where java file can be found
     */
    public void getIdentifiers(String filePath){
        ArrayList<String> identifiers = new ArrayList<>();
        ArrayList<String> reserved = new ArrayList<>();
        File f = new File(filePath);
        try(Scanner scanner = new Scanner(f)){
            while(scanner.hasNextLine()){//read through every line
                String lineCode = scanner.nextLine();
                //replace all punctuation with spaces, then split the line into an array of Strings
                String[] tokens = lineCode.replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+"); //had to google this
                for(String token : tokens){
                    if(!token.trim().isEmpty()) { //make sure we get rid of spaces and empty strings
                        if (!identifiers.contains(token) && !reservedWordsTree.contains(token)) { //if not a duplicate and not a reserved word
                            identifiers.add(token);
                        }
                        if (!reserved.contains(token) && reservedWordsTree.contains(token)) { //if not a duplicate and is a reserved word
                            reserved.add(token);
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        //Create identifiers tree
        identifiers.sort(null);
        identifiersTree.setRootNode(setBalancedBST(identifiers, 0, identifiers.size() - 1));
        //Create reserved words tree
        reserved.sort(null);
        reservedTree.setRootNode(setBalancedBST(reserved, 0, reserved.size() - 1));
    }

    /**
     * Get the tree with identifiers from java file
     * @return BST of identifiers
     */
    public BinarySearchTree<String> getIdentifiersTree() {
        return identifiersTree;
    }

    /**
     * Get the tree with reserved words from java file
     * @return BST of reserved words from java file
     */
    public BinarySearchTree<String> getReservedTree(){
        return reservedTree;
    }

    /**
     * Get BST of reserved words found in Java
     * @return BST of reserved words
     */
    public BinarySearchTree<String> getReservedWordsTree(){
        return reservedWordsTree;
    }
}
