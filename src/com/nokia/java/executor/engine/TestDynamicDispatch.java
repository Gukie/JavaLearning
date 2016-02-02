/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.executor.engine;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 */
public class TestDynamicDispatch
{
    static abstract class Human
    {
        protected abstract void sayHello();
    }

    static class Man extends Human
    {

        protected void sayHello()
        {
            System.out.println( " hello, Man" );
        }
    }

    static class Woman extends Human
    {

        protected void sayHello()
        {
            System.out.println( " hello, Woman" );
        }
    }

    public static void main( String[] args )
    {
        Human man = new Man();
        Human woman = new Woman();

        man.sayHello();
        woman.sayHello();

        man = new Woman();
        man.sayHello();
    }

}
