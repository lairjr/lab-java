/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lairjr
 */
public class TreeTest {
    
    public TreeTest() {
    }
    
    private String _result;
    private String _input;
    private Tree _sut;
    
    @Before
    public void setUp() {
        _sut = new Tree();
    }

    @Test
    public void testShouldBeFiredAndReturnNonNull() {
        GivenTheInput("Test");
        WhenTestIsFired();
        ThenResultShouldNotBeNull();
    }
    
    @Test
    public void testShouldBeFiredAndReturnExpectedValue() {
        GivenTheInput("Test");
        WhenTestIsFired();
        ThenResultShouldHasTheExpectedValue("Test");
    }
    
    public void GivenTheInput(String input) {
        _input = input;
    }
    
    public void WhenTestIsFired() {
        _result = _sut.Test(_input);
    }
    
    public void ThenResultShouldNotBeNull() {
        assertNotNull(_result);
    }
    
    public void ThenResultShouldHasTheExpectedValue(String expectedValue) {
        assertSame(_result, expectedValue);
    }
}
