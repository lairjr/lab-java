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
}
