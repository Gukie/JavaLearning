/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.concurrency.chapter6;

import java.util.Timer;
import java.util.TimerTask;

import javax.management.RuntimeErrorException;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TimerExceptionTest
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Timer timer = new Timer();
        timer.schedule( new ThrowTask(), 1L );
        System.out.println( "1 seconds" );
        timer.schedule( new ThrowTask(), 2L );
        System.out.println( "3 seconds" );
    }

    static class ThrowTask extends TimerTask
    {

        /**
         * @see java.util.TimerTask#run()
         */
        public void run()
        {
            throw new RuntimeErrorException( null );
        }

    }

}
