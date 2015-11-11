/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lairjr
 */
public class TreeTest {
    
    public TreeTest() {
    }
    
    private Tree _sut;
    private ArrayList<Node> _result;
    
    @Before
    public void setUp() {
        _sut = new Tree();
    }

    @Test
    public void shouldReturnCorrectlyFromASimpleTree1() {
        GivenATree(new Integer [] { 5, 3, 7, 2, 8 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 5, 3, 7, 2, 8 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromASimpleTree2() {
        GivenATree(new Integer [] { 3, 1, 7 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 3, 1, 7 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromASimpleTree3() {
        GivenATree(new Integer [] { 2, 1, 0, 3, 5 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 2, 1, 3, 0, 5 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromASimpleTree4() {
        GivenATree(new Integer [] { 4, 3, 5, 6, 1 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 4, 3, 5, 1, 6 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromASimpleTree5() {
        GivenATree(new Integer [] { 5, 7, 8, 4, 2 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 5, 4, 7, 2, 8 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromAComplexTree1() {
        GivenATree(new Integer [] { 3, 1, 0 , 2, 5, 6, 9 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 3, 1, 5, 0, 2, 6, 9 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromAComplexTree2() {
        GivenATree(new Integer [] { 0, 13, 7, 3, 2, 9, 10 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 0, 13, 7, 3, 9, 2, 10 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromAComplexTree3() {
        GivenATree(new Integer [] { 3, 4, 7, 6, 5, 0, 2 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 3, 0, 4, 2, 7, 6, 5 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromAComplexTree4() {
        GivenATree(new Integer [] { 3, 2, 1, 7, 6, 8, 5, 4, 9 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 3, 2, 7, 1, 6, 8, 5, 9, 4 });
    }
    
    @Test
    public void shouldReturnCorrectlyFromAComplexTree5() {
        GivenATree(new Integer [] { 0, 1, 2, 3, 4 });
        WhenGetNodesByLevelIsCalled();
        ThenResultShouldBe(new Integer [] { 0, 1, 2, 3, 4 });
    }

    private void GivenATree(Integer[] keyList) {
        _sut.SetRoot(new Node(keyList[0]));
        
        for (Integer index = 1; index < keyList.length; index++){
            _sut.Add(keyList[index]);
        }
    }

    private void WhenGetNodesByLevelIsCalled() {
        _result = _sut.GetNodesByLevel();
    }

    private void ThenResultShouldBe(Integer[] expectedResultArray) {
        for (Integer index = 0; index < _result.size() - 1; index++) {
            Integer nodeKey = _result.get(index).getKey();
            assertEquals(nodeKey, expectedResultArray[index]);
        }
        assertEquals(_result.size(), expectedResultArray.length);
    }
    
}
