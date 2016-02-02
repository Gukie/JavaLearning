/*
 * Copyright (c) 2014 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.classloader;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class Parent
{
    static
    {
        System.out.println( "Parent speak..." );
    }

    public static final int value = 45;
}
