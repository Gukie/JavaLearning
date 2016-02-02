/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.executor.engine;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestWorkedBlock
{

    public static void main( String[] args )
    {
        
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        int t = 0;
        System.gc();
    }

    public void test( int a )
    {
        /*
         * before using local variable, the variable should be initialized 
         * since it does not have a phase called initialization as Class variable has.
         */
        int c = 9;
        System.out.println( c );
    }

}
