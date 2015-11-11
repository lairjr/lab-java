/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author lairjr
 */
public class Tree {
    private Node _root;
    
    public Tree() {
        _root = new Node();
    }
    
    public void Add(Integer key) {
        Add0(key, _root);
    }
    
    private void Add0(Integer key, Node father) {
        if (father.getKey() > key) {
            if (father.getLeft() != null) 
                Add0(key, father.getLeft());
            else
                father.setLeft(new Node(key));
        } else {
            if (father.getRight()!= null) 
                Add0(key, father.getRight());
            else
                father.setRight(new Node(key));
        }
    }
    
    public String Test(String input) {
        return input;
    }
    
    public void SetRoot(Node nodeRoot) {
        _root = nodeRoot;
    }
    
    public ArrayList<Node> GetNodesByLevel() {
        ArrayList<Node> nodePrintList = new ArrayList<>();
        Queue<Node> nodeQueue = new ArrayDeque<>();
        
        if (_root == null) 
            throw new IllegalArgumentException("Null root node");
        
        Node currentNode = _root;
        
        while (currentNode != null) {
            if (currentNode.getLeft() != null)
                nodeQueue.add(currentNode.getLeft());
            if (currentNode.getRight() != null)
                nodeQueue.add(currentNode.getRight());
            
            nodePrintList.add(currentNode);
            currentNode = nodeQueue.poll();
        }
        
        return nodePrintList;
    }
    
    public Integer GetNodesByLevelCountOperations() {
        Integer operationsCount = 0;
        
        ArrayList<Node> nodePrintList = new ArrayList<>(); // operations +1
        Queue<Node> nodeQueue = new ArrayDeque<>(); // operations +1
        
        if (_root == null) // operations +1
            throw new IllegalArgumentException("Null root node"); // operations +1
        
        Node currentNode = _root; // operations +1
        
        while (currentNode != null) { // operations +1n 
            if (currentNode.getLeft() != null) // operations +1n
                nodeQueue.add(currentNode.getLeft()); // operations +1n
            if (currentNode.getRight() != null) // operations +1n
                nodeQueue.add(currentNode.getRight()); // operations +1n
            
            nodePrintList.add(currentNode); // operations +1n
            currentNode = nodeQueue.poll(); // operations +1n
            operationsCount += 7;
        }
        
        // operations +1
        operationsCount+= 6;
        
        return operationsCount;
    }
}
