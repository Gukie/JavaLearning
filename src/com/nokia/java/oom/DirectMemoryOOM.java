/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.oom;

import sun.misc.Unsafe;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class DirectMemoryOOM
{
    private static final int oneMB = 1024 * 1024;

    public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException
    {

        java.lang.reflect.Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible( true );
        Unsafe unsafe = ( Unsafe ) unsafeField.get( null );
        while( true )
        {
            unsafe.allocateMemory( oneMB );
        }

    }
}
