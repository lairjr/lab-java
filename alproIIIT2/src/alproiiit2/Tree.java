/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

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
        Integer currentLevel = father.getLevel() + 1;
        if (father.getKey() > key) {
            if (father.getLeft() != null) 
                add0(key, father.getLeft());
            else
                father.setLeft(new Node(key, false, currentLevel));
        } else {
            if (father.getRight()!= null) 
                add0(key, father.getRight());
            else
                father.setRight(new Node(key, false, currentLevel));
        }
    }
    
    public Node findNode(Integer searchKey) {
        return findNode0(searchKey, _root);
    }
    
    public Node findNode0(Integer searchKey, Node node) {
        if (node.getKey().equals(searchKey)) 
            return node;
        if (node.getKey() < searchKey)
            return findNode0(searchKey, node.getRight());
        if (node.getKey() > searchKey)
            return findNode0(searchKey, node.getLeft());
        return null;
    }
}
