/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 */
public class TestVolatile
{

    private static int race = 0;

    public static void increase()
    {
        race++; // this is not an atomic operation.
    }

    public int decrease( double x, Object obj )
    {
        double b = 23.3;
        System.out.println( b + x );

        long c = 23L;
        System.out.println( c * x );

        int i = 23;
        System.out.println( i * x );

        String string = "";
        System.out.println( string );
        List<String> strings = new ArrayList<String>();
        strings.add( string );

        return strings.size();

    }

    public static void main( String[] args )
    {

        for( int i = 0; i < 20; i++ )
        {
            Thread thread = new Thread( new Runnable()
            {

                public void run()
                {
                    for( int j = 0; j < 1000; j++ )
                    {
                        increase();
                    }
                }
            } );

            thread.start();
        }

        while( Thread.activeCount() > 1 )
        {
            Thread.yield();
        }

        System.out.println( race );

    }

}
