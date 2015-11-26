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
public class PrintNodeInfoFactory implements IPrintNodeInfoFactory {
    @Override
    public PrintNodeInfo create(Node node, Node treeRoot) {
        if (node == null|| treeRoot == null)
            throw new IllegalArgumentException("Node has a null value.");
        
        Integer leftDashNumber = getLeftDashNumber(node.getLeft());
        Integer rightDashNumber = getRightDashNumber(node.getRight());
        Integer minorValuesLenght = getMinorValuesLenght(node.getKey(), treeRoot);
        Integer padLeft = minorValuesLenght - leftDashNumber;
        
        return new PrintNodeInfo(node.getKey(), leftDashNumber, rightDashNumber, padLeft);        
    }
    
    private Integer getLeftDashNumber(Node leftNode) {
        Integer widthCount = 0;
        if (leftNode == null)
            return widthCount;
        
        Integer rightWidth = getTreeWidth(leftNode.getRight());
        return rightWidth + String.valueOf(leftNode.getKey()).length();
    }
    
    private Integer getRightDashNumber(Node rightNode) {
        Integer widthCount = 0;
        if (rightNode == null)
            return widthCount;
        
        Integer leftWidth = getTreeWidth(rightNode.getLeft());
        return leftWidth + String.valueOf(rightNode.getKey()).length();
    }
    
    private Integer getTreeWidth(Node node) {
        Integer widthCount = 0;
        if (node == null) 
            return widthCount;
        
        widthCount += getTreeWidth(node.getLeft());
        widthCount += getTreeWidth(node.getRight());
        
        return widthCount + String.valueOf(node.getKey()).length();
    }
    
    private Integer getMinorValuesLenght(Integer nodeKey, Node treeRoot) {
        return getMinorValuesLenght0(nodeKey, treeRoot);
    }
    
    private Integer getMinorValuesLenght0(Integer nodeKey, Node node) {
        if (node != null) {
            Integer count = 0;
            count += getMinorValuesLenght0(nodeKey, node.getLeft());
            count += getMinorValuesLenght0(nodeKey, node.getRight());
            if (nodeKey > node.getKey())
                count += String.valueOf(node.getKey()).length();
            return count;
        }
        return 0;
    }

    @Override
    public Integer createCountOperations(Node treeRoot) {
        return getNumberOfNodes(treeRoot) * 5;
    }
    
    public Integer getNumberOfNodes(Node node) {
        Integer count = 0;
        if (node == null)
            return count;
        
        count += getNumberOfNodes(node.getLeft());
        count += getNumberOfNodes(node.getRight());
        
        return count + 1;
    }
}
