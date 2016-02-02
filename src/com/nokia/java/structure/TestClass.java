/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.structure;

import com.nokia.bean.Balloon;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public final class TestClass extends TestParent implements TestInterface
{
    private static String helloStr = "Hello Test";

    private final static int weight = 99;

    private Balloon balloon = new Balloon();

    public synchronized int addCount( final int yellow )
    {
        System.out.println( helloStr );
        System.out.println( yellow );
        return weight;
    }
}
