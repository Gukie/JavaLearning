/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.classparser;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class FieldResolution
{
    static int i = 3;
    static
    {
        i = 100;
        System.out.println( i );
    }

//    static int i = 3;

    interface Interface0
    {
        int A = 0;
    }

    interface Interface1 extends Interface0
    {
        int A = 1;
    }

    interface Interface2
    {
        int A = 2;
    }

    static class Parent implements Interface1
    {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2
    {
        public static int A = 4;
    }

    public static void main( String[] args )
    {
        System.out.println( Sub.A );
    }

}
