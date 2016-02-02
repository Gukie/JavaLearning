/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.javac;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestJavac
{

    public static void main( String[] args )
    {
        Arrays.asList( 1,2,3);
    }

    public int test( List<Integer> list )
    {
        return list.size();
    }

    public String test1( List<String> list )
    {
        return "";
    }

}
