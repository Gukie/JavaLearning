/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.gc;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class ReferenceCountingGC
{
    public Object instance = null;

    private static final int oneMB = 1024 * 1024;

    private byte[] bigSize = new byte[ 2 * oneMB ];
    public static void main( String[] args )
    {
        testGC();
    }

    public static void testGC()
    {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;
        System.gc();
    }

}
