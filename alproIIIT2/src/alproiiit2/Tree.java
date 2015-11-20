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
    
    /**
     * @return the _root
     */
    public Node getRoot() {
        return _root;
    }

    public void setRoot(Integer _rootKey) {
        this._root = new Node(_rootKey, true);
    }
    
    public void add(Integer key) {
        add0(key, getRoot());
    }
    
    private void add0(Integer key, Node father) {
        if (father.getKey() > key) {
            if (father.getLeft() != null) 
                add0(key, father.getLeft());
            else
                father.setLeft(new Node(key));
        } else {
            if (father.getRight()!= null) 
                add0(key, father.getRight());
            else
                father.setRight(new Node(key));
        }
    }
    
    public ArrayList<Node> getNodesByLevel() {
        ArrayList<Node> nodePrintList = new ArrayList<>();
        Queue<Node> nodeQueue = new ArrayDeque<>();
        
        if (getRoot() == null) 
            throw new IllegalArgumentException("Null root node");
        
        Node currentNode = getRoot();
        
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
    
    public Integer getNodesByeLvelCountOperations() {
        Integer operationsCount = 0;
        
        ArrayList<Node> nodePrintList = new ArrayList<>(); // operations +1
        Queue<Node> nodeQueue = new ArrayDeque<>(); // operations +1
        
        if (getRoot() == null) // operations +1
            throw new IllegalArgumentException("Null root node"); // operations +1
        
        Node currentNode = getRoot(); // operations +1
        
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
