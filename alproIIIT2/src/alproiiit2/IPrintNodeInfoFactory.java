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
public interface IPrintNodeInfoFactory {
    PrintNodeInfo create(Node node, Node treeRoot);
    Integer createCountOperations(Node treeRoot);
}
