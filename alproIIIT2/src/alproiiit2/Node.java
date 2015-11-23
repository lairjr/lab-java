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
    private final Boolean _isRoot;
    private Integer _level;
    
    public Node() {
        _isRoot = false;
    }
    
    public Node(Integer key) {
        _key = key;
        _isRoot = false;
        _level = 0;
    }
    
    public Node(Integer key, Boolean isRoot) {
        _key = key;
        _isRoot = isRoot;
        if (isRoot)
            _level = 0;
    }
    
    public Node(Integer key, Boolean isRoot, Integer level) {
        _key = key;
        _isRoot = isRoot;
        _level = level;
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

    /**
     * @return the _isRoot
     */
    public Boolean isRoot() {
        return _isRoot;
    }

    /**
     * @return the _level
     */
    public Integer getLevel() {
        return _level;
    }

    /**
     * @param _height the _level to set
     */
    public void setLevel(Integer _height) {
        this._level = _height;
    }
}
