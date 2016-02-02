/*
 * Copyright (c) 2014 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.useful;


/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class UsefulTest
{

    public static void main( String[] args )
    {
        String[] arrs =
            { "btsSessionLoginDelay", "btsMaxFailedLoginAttempts", "btsFailedLoginCountingPeriod",
             "btsAccountLockoutDuration" };
        String prefix = "ATTR_LUAC_";
        for( String string : arrs )
        {
            System.out.println( prefix + getUpperStr( string ) );
        }

        if( null instanceof Boolean )
        {
            System.out.println( "null" + "" );
        }
        else
        {
            System.out.println( "null sle" + "" );
        }

        testFile();
    }

    /**
     * 
     */
    private static void testFile()
    {
    }

    private static String getUpperStr( String str )
    {
        return str.toUpperCase();
    }

}
