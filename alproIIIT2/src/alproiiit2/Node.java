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
public class Node {
    private Node _left;
    private Node _right;
    private Integer _key;
    
    public Node() {
    }
    
    public Node(Integer key) {
        _key = key;
    }

    /**
     * @return the _left
     */
    public Node getLeft() {
        return _left;
    }

    /**
     * @param _left the _left to set
     */
    public void setLeft(Node _left) {
        this._left = _left;
    }

    /**
     * @return the _right
     */
    public Node getRight() {
        return _right;
    }

    /**
     * @param _right the _right to set
     */
    public void setRight(Node _right) {
        this._right = _right;
    }

    /**
     * @return the _key
     */
    public Integer getKey() {
        return _key;
    }

    /**
     * @param _key the _key to set
     */
    public void setKey(Integer _key) {
        this._key = _key;
    }
}
