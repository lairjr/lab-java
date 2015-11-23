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
        _sut.create(null, null);
    }
    
    @Test
    public void Create_ShouldCountOneLengthNodeCorrectly() {
        GivenATree(new Integer [] { 1 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(1, 0, 0, null);
    }
    
    @Test
    public void Create_ShouldCountOneLengthLeftNodeCorrectly() {
        GivenATree(new Integer [] { 2, 1 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(2, 1, 0, null);
    }
    
    
    @Test
    public void Create_ShouldCountOneLengthRightNodeCorrectly() {  
        GivenATree(new Integer [] { 2, 3 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(2, 0, 1, null);
    }
    
    @Test
    public void Create_ShouldCountThreeLengthLeftNodeCorrectly() {     
        GivenATree(new Integer [] { 123, 100 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(123, 3, 0, null);
    }
    
    @Test
    public void Create_ShouldCountThreeLengthRigthNodeCorrectly() {            
        GivenATree(new Integer [] { 123, 234 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(123, 0, 3, null);
    }
    
    
    @Test
    public void Create_ShouldCountThreeLengthBothNodeCorrectly() {    
        GivenATree(new Integer [] { 353, 346, 367 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(353, 3, 3, null);
    }
    
    @Test
    public void Create_ShouldCountFourthLevelNodeCorrectly() {        
        GivenATree(new Integer [] { 332, 297, 353, 346, 367, 276, 290, 325, 318 });
        WhenCreateIsFiredWithRoot();
        ThenPrintNodeInfoShouldHas(332, 9, 6, null);
    }
    
    @Test
    public void Create_Should() {        
        //GivenATree(new Integer [] { 262, 80, 332, 3, 164, 297, 353, 73, 115, 199, 276, 325, 346, 367, 24, 143, 192, 220, 290, 318, 10, 31, 171, 206, 255, 45, 234, 38, 52, 241 });
        //WhenCreateIsFiredWithNode(262);
        //ThenPrintNodeInfoShouldHas(262, 9, 6, null);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber80() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(80);
        ThenPrintNodeInfoShouldHas(80, 15, 0, 0);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber3() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(3);
        ThenPrintNodeInfoShouldHas(3, 0, 14, 0);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber73() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(73);
        ThenPrintNodeInfoShouldHas(73, 10, 0, 3);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber24() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(24);
        ThenPrintNodeInfoShouldHas(24, 2, 2, 1);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber10() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(10);
        ThenPrintNodeInfoShouldHas(10, 0, 0, 1);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber31() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(31);
        ThenPrintNodeInfoShouldHas(31, 0, 4, 5);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber45() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(45);
        ThenPrintNodeInfoShouldHas(45, 2, 2, 7);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber38() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(38);
        ThenPrintNodeInfoShouldHas(38, 0, 0, 7);
    }
    
    @Test
    public void Create_ShouldCountCorrectyFromSampleOnNumber52() {        
        GivenATree(new Integer [] { 80, 3, 73, 24, 10, 31, 45, 38, 52 });
        WhenCreateIsFiredWithNode(52);
        ThenPrintNodeInfoShouldHas(52, 0, 0, 11);
    }

    private void GivenATree(Integer[] keyList) {
        _tree.setRoot(keyList[0]);
        
        for (Integer index = 1; index < keyList.length; index++){
            _tree.add(keyList[index]);
        }
    }
    
    private void ThenPrintNodeInfoShouldHas(Integer key, Integer leftDashNumber, Integer rightDashNumber, Integer padLeft) {
        if (key != null) 
           assertEquals(_printNodeInfo.getKey(), key);
        if (leftDashNumber != null)
            assertEquals(_printNodeInfo.getLeftDashNumber(), leftDashNumber);
        if (rightDashNumber != null)
            assertEquals(_printNodeInfo.getRightDashNumber(), rightDashNumber);
        if (padLeft != null)
            assertEquals(_printNodeInfo.getPadLeft(), padLeft);
    }
    
    private void WhenCreateIsFiredWithRoot() {
        _printNodeInfo = _sut.create(_tree.getRoot(), _tree.getRoot());
    }
    
    private void WhenCreateIsFiredWithNode(Integer nodeKey) {
        Node currentNode = _tree.findNode(nodeKey);
        _printNodeInfo = _sut.create(currentNode, _tree.getRoot());
    }
}
