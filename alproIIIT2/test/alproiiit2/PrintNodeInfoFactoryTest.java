/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lairjr
 */
public class PrintNodeInfoFactoryTest {
    private final IPrintNodeInfoFactory _sut;
    private final Tree _tree;
    private PrintNodeInfo _printNodeInfo;
    
    public PrintNodeInfoFactoryTest() {
        _sut = new PrintNodeInfoFactory();
        _tree = new Tree();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void Create_ShouldThrowExceptionForNull() {
        _sut.create(null);
    }
    
    @Test
    public void Create_ShouldCountOneLengthNodeCorrectly() {
        GivenATree(new Integer [] { 1 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(1, 0, 0);
    }
    
    @Test
    public void Create_ShouldCountOneLengthLeftNodeCorrectly() {
        GivenATree(new Integer [] { 2, 1 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(2, 1, 0);
    }
    
    
    @Test
    public void Create_ShouldCountOneLengthRightNodeCorrectly() {  
        GivenATree(new Integer [] { 2, 3 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(2, 0, 1);
    }
    
    @Test
    public void Create_ShouldCountThreeLengthLeftNodeCorrectly() {     
        GivenATree(new Integer [] { 123, 100 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(123, 3, 0);
    }
    
    @Test
    public void Create_ShouldCountThreeLengthRigthNodeCorrectly() {            
        GivenATree(new Integer [] { 123, 234 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(123, 0, 3);
    }
    
    
    @Test
    public void Create_ShouldCountThreeLengthBothNodeCorrectly() {    
        GivenATree(new Integer [] { 353, 346, 367 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(353, 3, 3);
    }
    
    @Test
    public void Create_ShouldCountFourthLevelNodeCorrectly() {        
        GivenATree(new Integer [] { 332, 297, 353, 346, 367, 276, 290, 325, 318 });
        WhenCreateIsFired();
        ThenPrintNodeInfoShouldHas(332, 9, 6);
    }

    private void GivenATree(Integer[] keyList) {
        _tree.setRoot(keyList[0]);
        
        for (Integer index = 1; index < keyList.length; index++){
            _tree.add(keyList[index]);
        }
    }
    
    private void ThenPrintNodeInfoShouldHas(Integer key, Integer leftDashNumber, Integer rightDashNumber) {
        if (key != null)
            assertEquals(_printNodeInfo.getKey(), key);
        if (leftDashNumber != null)
            assertEquals(_printNodeInfo.getLeftDashNumber(), leftDashNumber);
        if (rightDashNumber != null)
            assertEquals(_printNodeInfo.getRightDashNumber(), rightDashNumber);
    }
    
    private void WhenCreateIsFired() {
        _printNodeInfo = _sut.create(_tree.getRoot());
    }
}
