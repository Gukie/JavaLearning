/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.thread;

import java.util.Vector;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestVector
{

    private static Vector<Integer> myVector = new Vector<Integer>();
    public static void main( String[] args )
    {

        testThreadSafe();
    }

    private static void testThreadSafe()
    {
        while( true )
        {

            for( int i = 0; i < 10; i++ )
            {
                myVector.add( i );
            }

            Thread removeT = new Thread( new Runnable()
            {

                public void run()
                {
                    for( int i = 0; i < myVector.size(); i++ )
                    {
                        myVector.remove( i );
                    }
                }
            } );

            Thread printT = new Thread( new Runnable()
            {

                public void run()
                {
                    for( int i = 0; i < myVector.size(); i++ )
                    {
                        myVector.get( i );
                    }
                }
            } );

            removeT.start();
            printT.start();

            while( Thread.activeCount() > 20 )
            {
//                System.out.println( "active count:" + Thread.activeCount() );
            }
        }
    }

}
