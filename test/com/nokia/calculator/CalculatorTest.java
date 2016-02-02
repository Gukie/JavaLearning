/*
 * Copyright (c) 2014 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.calculator;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class CalculatorTest
{

    private Calculator myCalculator;
    @Before
    public void setUp() throws Exception
    {
        myCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception
    {
        myCalculator = null;
    }

    @Test
    public void testAdd()
    {
        int operator1 = 1;
        int operator2 = 2;
        Assert.assertEquals( 3, myCalculator.add( operator1, operator2 ) );
    }

    @Test
    public void testMinus()
    {
        int operator1 = 1;
        int operator2 = 2;
        Assert.assertEquals( 1, myCalculator.minus( operator2, operator1 ) );
    }

    @Test
    public void testMultiple()
    {
        int operator1 = 1;
        int operator2 = 2;
        Assert.assertEquals( 2, myCalculator.multiple( operator1, operator2 ) );
    }

    @Test
    public void testDivide()
    {
        int operator1 = 4;
        int operator2 = 2;
        Assert.assertEquals( 2, myCalculator.divide( operator1, operator2 ) );
    }

    @Test
    public void testOthers()
    {
        List<String> lst = new ArrayList<>();
        lst.add( "1" );
        Assert.assertFalse( lst.contains( null ) );
    }

}
