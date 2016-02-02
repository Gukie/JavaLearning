/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.concurrency;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class ObjectSharing
{

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread
    {
        public void run()
        {
            while( !ready )
            {
                Thread.yield();
            }
            System.out.println( number );
        }
    }
    public static void main( String[] args )
    {
        new ReaderThread().start();
        number = 43;
        ready = true;

    }

}
