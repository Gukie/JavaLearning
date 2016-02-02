/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.javac;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestBoxing
{

    public static void main( String[] args )
    {
        testBoxing();
    }

    private static void testBoxing()
    {
        Integer a = 100;
        Integer b = 32;
        Integer c = 132;

        Integer d = 33;
        Integer e = 133;
        Integer f = 133;
        Long y = 33L;

        System.out.println( c == d );
        System.out.println( e == f );
        System.out.println( c == ( a + b ) );
        System.out.println( c.equals( a + b ) );
        System.out.println( y.equals( a + b ) );
//        System.out.println( ( a + b ).equals( y ) );  //(a+b) will be auto-unbox, so it is a primitive type, cannot invoke equals()
        System.out.println( y == ( a + b ) );
    }

}
