/*
 * Copyright (c) 2014 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.classloader;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class Child extends Parent
{

    static
    {
        System.out.println( "Child speak..." );
    }
}
