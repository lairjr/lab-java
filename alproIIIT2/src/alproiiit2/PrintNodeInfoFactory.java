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
    public PrintNodeInfo create(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Node has a null value.");
        
        Integer leftDashCount = getLeftDashCount(node.getLeft(), true);
        Integer rightDashCount = getRightDashCount(node.getRight(), true);
        
        if (node.isRoot()) {
            Integer totalLeftColumns = getTotalLeftColumns(node.getLeft(), true);
            Integer padLeft = totalLeftColumns + leftDashCount;
            return new PrintNodeInfo(node.getKey(), leftDashCount, rightDashCount, padLeft);
        }
        
        return new PrintNodeInfo(node.getKey(), leftDashCount, rightDashCount);
    }

    private Integer getLeftDashCount(Node node, Boolean isTheFirst) {
        if (node != null) {
            Integer dashCount = String.valueOf(node.getKey()).length();
            dashCount += getLeftDashCount(node.getRight(), false);
            if (isTheFirst) 
                return dashCount;
            
            dashCount += getLeftDashCount(node.getLeft(), false);
            return dashCount;
        }
        return 0;
    }

    private Integer getRightDashCount(Node node, Boolean isTheFirst) {
        if (node != null) {
            Integer dashCount = String.valueOf(node.getKey()).length();
            dashCount += getRightDashCount(node.getLeft(), false);
            if (isTheFirst) 
                return dashCount;
            
            dashCount += getRightDashCount(node.getRight(), false);
            return dashCount;
        }
        return 0;
    }

    private Integer getTotalLeftColumns(Node node, Boolean isTheFirst) {
        if (node != null) {
            Integer leftColumns = getTotalLeftColumns(node.getLeft(), false);
            Integer rigthColumns = getTotalLeftColumns(node.getRight(), false);
            if (isTheFirst)
                return leftColumns + rigthColumns;
            return leftColumns + rigthColumns + String.valueOf(node.getKey()).length();
        }
        return 0;
    }
}
