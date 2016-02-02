/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.executor.engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestDynamicInvoke
{

    static class ClassA
    {

        public void println( String s )
        {
            System.out.println( "ClassA: " + s );
        }
    }
    public static void main( String[] args )
    {
        for( int i = 0; i < 10; i++ )
        {
            Object object = System.currentTimeMillis() % 3 == 0 ? System.out : new ClassA();
            MethodHandle methodHandle = getMethodHandler( object );
            try
            {
                methodHandle.invokeExact( "Ni Hao" );
                methodHandle.invoke( "he she and it" );
            }
            catch( Throwable e )
            {
                e.printStackTrace();
            }
        }
    }

    private static MethodHandle getMethodHandler(Object receiver)
    {
        MethodType methodType = java.lang.invoke.MethodType.methodType( void.class, String.class );
        try
        {
            return MethodHandles.lookup().findVirtual( receiver.getClass(), "println", methodType ).bindTo( receiver );
        }
        catch( NoSuchMethodException | IllegalAccessException e )
        {
            e.printStackTrace();
        }
        return null;
    }

}
