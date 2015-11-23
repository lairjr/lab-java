/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * @author lairjr
 */
public class PrintTreeHandler implements IPrintTreeHandler {
    private final IPrintNodeInfoFactory _printNodeInfoFactory;
    
    public PrintTreeHandler(IPrintNodeInfoFactory printNodeInfoFactory) {
        _printNodeInfoFactory = printNodeInfoFactory;
    }
    
    @Override
    public void printTree(Node treeRoot) {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        
        if (treeRoot == null) 
            throw new IllegalArgumentException("Null root node");
        
        Node currentNode = treeRoot;
        Integer currentLevel = currentNode.getLevel();
        Integer currentLineColumn = 0;
        
        while (currentNode != null) {
            if (currentNode.getLeft() != null)
                nodeQueue.add(currentNode.getLeft());
            if (currentNode.getRight() != null)
                nodeQueue.add(currentNode.getRight());
            
            if (!Objects.equals(currentLevel, currentNode.getLevel())) {
                System.out.println();
                currentLevel = currentNode.getLevel();
                currentLineColumn = 0;
            }
            
            PrintNodeInfo printNodeInfo = _printNodeInfoFactory.create(currentNode, treeRoot);
            String nodeInfoString = printNodeInfo.toString().substring(currentLineColumn);
            System.out.print(nodeInfoString);
            currentLineColumn += nodeInfoString.length();
            
            currentNode = nodeQueue.poll();
        }
        System.out.println();
    }

    @Override
    public Integer printTreeNumberOfOperations(Node treeRoot) {
        Integer numberOfOperations = 0;
        Queue<Node> nodeQueue = new ArrayDeque<>(); // numberOfOperations + 1
        
        if (treeRoot == null) // numberOfOperations + 1
            throw new IllegalArgumentException("Null root node"); // numberOfOperations + 1
        
        Node currentNode = treeRoot; // numberOfOperations + 1
        Integer currentLevel = currentNode.getLevel(); // numberOfOperations + 1
        Integer currentLineColumn = 0; // numberOfOperations + 1
        
        while (currentNode != null) { // numberOfOperations + 1n
            if (currentNode.getLeft() != null) // numberOfOperations + 1n
                nodeQueue.add(currentNode.getLeft()); // numberOfOperations + 1n
            if (currentNode.getRight() != null) // numberOfOperations + 1n
                nodeQueue.add(currentNode.getRight()); // numberOfOperations + 1n
            
            if (!Objects.equals(currentLevel, currentNode.getLevel())) { // numberOfOperations + 1n
                System.out.println(); // numberOfOperations + 1n
                currentLevel = currentNode.getLevel(); // numberOfOperations + 1n
                currentLineColumn = 0; // numberOfOperations + 1n
            }
            
            PrintNodeInfo printNodeInfo = _printNodeInfoFactory.create(currentNode, treeRoot); // numberOfOperations + 1n
            String nodeInfoString = printNodeInfo.toString().substring(currentLineColumn); // numberOfOperations + 1n
            System.out.print(nodeInfoString); // numberOfOperations + 1n
            currentLineColumn += nodeInfoString.length(); // numberOfOperations + 1n
            
            currentNode = nodeQueue.poll(); // numberOfOperations + 1n
            
            numberOfOperations += 14;
        }
        System.out.println(); // numberOfOperations + 1
        
        numberOfOperations += 7;
        
        return numberOfOperations;
    }
}
