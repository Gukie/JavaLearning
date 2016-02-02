/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestNonBlockingSync
{

    private static AtomicInteger race = new AtomicInteger( 0 );

    private final static int threadCount = 20000;
    public static void main( String[] args )
    {

        for( int i = 0; i < threadCount; i++ )
        {
            Thread thread = new Thread( new Runnable()
            {

                public void run()
                {
                    for( int j = 0; j < 10000; j++ )
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

        System.out.println( race.get() );
    }

    public static void increase()
    {
        race.incrementAndGet(); // this is an atomic operation.
    }

}
