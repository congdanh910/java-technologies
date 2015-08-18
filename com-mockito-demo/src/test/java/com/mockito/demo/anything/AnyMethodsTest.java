package com.mockito.demo.anything;

import com.mockito.demo.exception.DemoException;

import static junit.framework.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


/**
 * Created by CongDanh on 8/18/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class AnyMethodsTest {

    @Mock
    private AnyMethods anyMethods;

    @Before
    public void setup() {
        System.out.println("AnyMethods will start the testing ............");
    }

    @Test
    public void getNameTest() {
        String name = "Danh";
        String expect = "Hello : Danh";
        when(anyMethods.hello(name)).thenReturn(expect);
        String actual = anyMethods.hello(name);
//        assertEquals(expect, actual);
        verify(anyMethods).hello(name);
    }

//    @Test(expected = DemoException.class)
//    public void getFirstNameWithException() throws DemoException {
//        anyMethods.getFirstName(null);
//    }
//
//    @Test
//    public void getFirstNameWithExcepted() throws DemoException {
//        String except = "Danh";
//        String actual = anyMethods.getFirstName("Danh Ho");
//        Assert.assertEquals(except, actual);
//    }

    @Test
    public void getFistNameWithEmpty() {

    }

    @After
    public void end() {
        System.out.println("AnyMethods will stop the testing ............");
    }
}
