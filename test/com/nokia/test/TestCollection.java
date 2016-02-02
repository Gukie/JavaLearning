/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 */
public class TestCollection
{
    private static Map<String, String> map = new HashMap<String, String>();

    public static void main( String[] args )
    {
        map.put( "1", "11" );
        map.put( "2", "22" );
        map.put( "3", "33" );

        System.out.println( "size:" + map.size() );
        testRemove();
        System.out.println( "size:" + map.size() );

        String[] parameters = { "", "1", "2" };
        String[] tmpParameters = Arrays.copyOfRange( parameters, 1, parameters.length );
        for( String tmpP : tmpParameters )
        {
            System.out.println( tmpP );
        }

        int len = Charset.forName( "UTF-8" ).encode( "古1" ).limit();
        System.out.println( "len:" + len );

    }

    private static void testRemove()
    {
        Set<Entry<String, String>> entry = map.entrySet();
        Iterator<Entry<String, String>> iterator = entry.iterator();

        while( iterator.hasNext() )
        {
            iterator.next();
            iterator.remove();
        }
    }


}
