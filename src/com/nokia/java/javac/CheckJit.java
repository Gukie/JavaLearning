/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.javac;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class CheckJit
{

    private static final int LOOP_TIMES = 1500;
    public static void main( String[] args )
    {
        for( int i = 0; i < 5; i++ )
        {
            testCalSum();
            System.out.println( "***********excuete " + i );
        }

    }
    private static void testCalSum()
    {
        int sum = 0;
        for( int i = 0; i < LOOP_TIMES; i++ )
        {
            sum += calSum();
        }

        System.out.println( sum );
    }

    private static long calSum()
    {
        long sum = 0;
        for( int i = 0; i < 1010; i++ )
        {
            sum += doubleValue( i );
        }
        return sum;

    }

    private static long doubleValue( int i )
    {
        for( int j = 0; j < 100009; j++ );
        return i * 2;
    }

}
