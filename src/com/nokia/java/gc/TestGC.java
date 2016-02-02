/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.gc;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestGC
{

    private static final int oneMB = 1024 * 1024;
    public static void main( String[] args )
    {
        byte[] allocation1 = new byte[ oneMB ];
        byte[] allocation2 = new byte[ 6 * oneMB ];
        byte[] allocation3 = new byte[ 8 * oneMB ];
        byte[] allocation4 = new byte[ 1 * oneMB ];

        System.out.println( allocation1 );
        System.out.println( allocation2 );
        System.out.println( allocation3 );
        System.out.println( allocation4 );
    }

}
