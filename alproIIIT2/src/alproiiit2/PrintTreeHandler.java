/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author lairjr
 */
public class PrintTreeHandler {
    private final IPrintNodeInfoFactory _printNodeInfoFactory;
    
    public PrintTreeHandler(IPrintNodeInfoFactory printNodeInfoFactory) {
        _printNodeInfoFactory = printNodeInfoFactory;
    }
    
    public void printTree(Node root) {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        
        if (root == null) 
            throw new IllegalArgumentException("Null root node");
        
        Node currentNode = root;
        
        while (currentNode != null) {
            if (currentNode.getLeft() != null)
                nodeQueue.add(currentNode.getLeft());
            if (currentNode.getRight() != null)
                nodeQueue.add(currentNode.getRight());
            
            PrintNodeInfo printNodeInfo = _printNodeInfoFactory.create(currentNode);
            printNode(printNodeInfo);
            
            currentNode = nodeQueue.poll();
        }
    }

    private void printNode(PrintNodeInfo printNodeInfo) {
    }
}
