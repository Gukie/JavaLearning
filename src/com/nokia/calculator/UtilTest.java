/*
 * Copyright (c) 2014 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.calculator;




/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class UtilTest
{
    public static void main( String[] args )
    {

//        Balloon red = new Balloon( "Red" ); //memory reference 50
//        Balloon blue = new Balloon( "Blue" ); //memory reference 100


        teste();
        teste1();
        
        int [][][] a = new int[1][2][-1];
        System.out.println( a );

    }

    private static void teste()
    {
        int i = 15;
        for( ; i < 30; i++ )
        {
            if(i % 2 == 0){
                i += 2;
            }
        }

        System.out.println( "teste:" + i );
    }

    private static void teste1()
    {
        for( int i = 15; i < 30; i++ )
        {
            if( i % 2 == 0 )
            {
                i += 2;
            }
            System.out.println( i );
        }

    }
}
