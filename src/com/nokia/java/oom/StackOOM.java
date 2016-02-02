/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.oom;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class StackOOM
{
    private int stackLen = 1;

    public void stackLeak()
    {
        stackLen++;
        stackLeak();
    }

    public static void main( String[] args )
    {
        StackOOM stackOOM = new StackOOM();
        try
        {
            stackOOM.stackLeak();
        }
        catch( Throwable e )
        {
            System.out.println( stackOOM.stackLen );
            throw e;
        }

    }

}
