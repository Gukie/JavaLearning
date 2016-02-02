/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.concurrency.chapter6;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class ScheduledThreadPoolExecutorTest
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {

        ScheduledExecutorService service = Executors.newScheduledThreadPool( 3 );

        service.schedule( new ThrowTask(), 1L, TimeUnit.SECONDS );
        System.out.println( "1 seconds" );
        service.schedule( new ThrowTask(), 2L, TimeUnit.SECONDS );
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
