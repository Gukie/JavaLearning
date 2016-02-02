/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a> Not work when JDK is larger than 1.6.
 */

public class RunttimeConstantPoolOOM
{

    public static void main( String[] args )
    {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while( true )
        {
            list.add( String.valueOf( i++ ).intern() );
        }
    }
}
