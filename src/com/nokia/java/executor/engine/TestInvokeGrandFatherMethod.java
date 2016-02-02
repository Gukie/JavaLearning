/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.executor.engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.util.ArrayList;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *         <p>
 *         This tuturiol only works on JDK1.7.
 *         </p>
 */
public class TestInvokeGrandFatherMethod
{


    public static void main( String[] args )
    {
        TestInvokeGrandFatherMethod test = new TestInvokeGrandFatherMethod();
        Son son = test.new Son();
        son.thinking();
    }

    class GrandFather
    {
        public void thinking()
        {
            System.out.println( "I am GrandFather" );
        }
    }

    class Father extends GrandFather
    {
        public void thinking()
        {
            System.out.println( "I am Father" );
        }
    }

    class Son extends Father
    {
        public void thinking()
        {
            //Here, son want to invoke GrandFather's thinking() method
            System.out.println( "I am Son, and I am trying to invoke my GrandFather's thinking() method" );
            try
            {
                final MethodType methodType = MethodType.methodType( void.class );
                MethodHandle methodHandle =
                    MethodHandles.lookup().findSpecial( GrandFather.class, "thinking", methodType, getClass() );
//                MethodHandle MH_duper = Listie.lookup().findSpecial(
//                    Object.class, "toString" , methodType(String.class), Listie.class);

                methodHandle.invokeExact( this );
            }
            catch( Throwable e )
            {

                e.printStackTrace();
            }
        }
    }

    static class Listie extends ArrayList
    {
        public String toString()
        {
            return "[wee Listie]";
        }

        static Lookup lookup()
        {
            return MethodHandles.lookup();
        }
    }

}
