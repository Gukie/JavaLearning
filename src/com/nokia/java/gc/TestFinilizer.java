/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.gc;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 */
public class TestFinilizer
{
    private static TestFinilizer save;

    {
        System.out.println( "init" );
    }

    public static void main( String[] args ) throws InterruptedException
    {

        new TestFinilizer();
        testGc();
        testGc();

    }

    private static void testGc() throws InterruptedException
    {
//        save = null;
        System.out.println( "testGc,save:" + save );
        System.gc();
        Thread.sleep( 500 );
        if( save == null )
        {
            System.out.println( "Dead" );
        }
        else
        {
            System.out.println( "Alive" );
        }
    }

    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println( "finilize,save:" + save );
        save = this;
    }

}
