package all;

import all.TreePackage.BinaryNode;
import all.TreePackage.BinarySearchTree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private BinarySearchTree<String> tempTree;
    private BinarySearchTree<String> reservedWordsTree;
    private BinarySearchTree<String> identifiersTree;
    private BinarySearchTree<String> reservedTree;

    public Parser(){
        tempTree = new BinarySearchTree<>();
        reservedWordsTree = new BinarySearchTree<>();
        identifiersTree = new BinarySearchTree<>();
        reservedTree = new BinarySearchTree<>();
    }

    public void initializeReservedWords(String filePath){
        ArrayList<String> reservedWords = new ArrayList<>();
        File f = new File(filePath);
        try(Scanner scanner = new Scanner(f)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.trim().length() > 0){
                    reservedWords.add(line);
                    }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        reservedWords.sort(null);
        reservedWordsTree.setRootNode(setBalancedBST(reservedWords, 0, reservedWords.size() - 1));
    }

    private BinaryNode<String> setBalancedBST(ArrayList<String> sortedList, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode<String> node = new BinaryNode<>(sortedList.get(mid));
        node.setLeftChild(setBalancedBST(sortedList, start, mid - 1));
        node.setRightChild(setBalancedBST(sortedList, mid + 1, end));
        return node;
    }

    public void getIdentifiers(String filePath){
        ArrayList<String> identifiers = new ArrayList<>();
        ArrayList<String> reserved = new ArrayList<>();
        File f = new File(filePath);
        try(Scanner scanner = new Scanner(f)){
            while(scanner.hasNextLine()){
                String lineCode = scanner.nextLine();
                String[] tokens = lineCode.replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+"); //had to google this
                for(String token : tokens){
                    if(!identifiers.contains(token) && !reservedWordsTree.contains(token)){
                        identifiers.add(token);
                    }
                    if(!reserved.contains(token) && reservedWordsTree.contains(token)){
                        reserved.add(token);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        identifiers.sort(null);
        identifiersTree.setRootNode(setBalancedBST(identifiers, 0, identifiers.size() - 1));

        reserved.sort(null);
        reservedTree.setRootNode(setBalancedBST(reserved, 0, reserved.size() - 1));
    }

    public BinarySearchTree<String> getIdentifiersTree() {
        return identifiersTree;
    }

    public BinarySearchTree<String> getReservedTree(){
        return reservedTree;
    }
}
