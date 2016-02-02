/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.executor.engine;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 */
public class TestStaticDispatch
{
    static abstract class Human
    {
    }

    static class Man extends Human
    {
    }

    static class Woman extends Human
    {
    }

    public void sayHello( Human human )
    {
        System.out.println( "human" );
    }

    public void sayHello( Man man )
    {
        System.out.println( "Man" );
    }

    public void sayHello( Woman woman )
    {
        System.out.println( "Woman" );
    }

    public static void main( String[] args )
    {
        Human man = new Man();
        Human woman = new Woman();

        TestStaticDispatch tr = new TestStaticDispatch();

        tr.sayHello( man );
        tr.sayHello( woman );
    }

}
