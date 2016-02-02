/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.oom;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class StringInternTest
{

    public static void main( String[] args )
    {
        String str1 = new StringBuilder( "Hello" ).append( "Gukie" ).toString();
        System.out.println( str1 == str1.intern() );

        String str2 = new StringBuilder( "ja" ).append( "va" ).toString();
        System.out.println( str2 == str2.intern() );

    }

}
