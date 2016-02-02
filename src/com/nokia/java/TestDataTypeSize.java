/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;


/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 */
public class TestDataTypeSize
{

    private static final Runtime myRuntime = Runtime.getRuntime();

    private static final MemoryMXBean myMemoryManager = ManagementFactory.getMemoryMXBean();

    private static final int myObjectNum = 100000;

    private static long myBeforeAllocatingHeapSize;

    private static long myAfterAllocatingHeapSize;

    private static Object[] myObjects;

//    private static long myBeforeAllocatingStackSize;
//
//    private static long myAfterAllocatingStackSize;
//
//    
//
//    private static int[] myIntArray;
//
//    private static long[] myLongArray;
//
//    private static double[] myDoubleArray;
//
//    private static float[] myFloatArray;
//
//    private static byte[] myByteArray;
//
//    private static char[] myCharArray;

    static
    {
        myObjects = new Object[ myObjectNum ];
//        myIntArray = new int[ myObjectNum ];
//        myLongArray = new long[ myObjectNum ];
//        myDoubleArray = new double[ myObjectNum ];
//        myFloatArray = new float[ myObjectNum ];
//        myByteArray = new byte[ myObjectNum ];
//        myCharArray = new char[ myObjectNum ];
    }

    public static void main( String[] args ) throws Exception
    {
        testObjectSize();
//        testPrimitiveDataTypeSize();
        clear();
    }

//    private static void testPrimitiveDataTypeSize() throws Exception
//    {
//        System.out.println( "*********====== primitive data type Size=======*********" );
//        myBeforeAllocatingStackSize = getStackSize();
////        allocateIntMemory();
//        int idr = 231;
////        System.out.println( idr );
//        myAfterAllocatingStackSize = getStackSize();
//        printStackSize();
//    }
//
//    private static void printStackSize()
//    {
//        final int size =
//            Math.round( ( ( float ) ( myAfterAllocatingStackSize - myBeforeAllocatingStackSize ) ) / myObjectNum );
//        System.out.println( "'before' stack: " + myBeforeAllocatingStackSize + ", 'after' stack: " +
//            myAfterAllocatingStackSize );
//        System.out.println( "stack delta: " + ( myAfterAllocatingStackSize - myBeforeAllocatingStackSize ) + ", {" +
//            myIntArray[0] + "} size = " + size + " bytes" );
//    }

    private static long getStackSize() throws Exception
    {
        runGc();
        return getUsedStackMemory();
    }

    private static void testObjectSize() throws Exception
    {
        System.out.println( "*********====== Object Size=======*********" );
        myBeforeAllocatingHeapSize = getHeapSize();
        System.out.println( "beforeHeapSize:" + myBeforeAllocatingHeapSize + ",beforeHeapSize From Memory Bean:" +
            myMemoryManager.getHeapMemoryUsage().getUsed() + ",committed:" +
            myMemoryManager.getHeapMemoryUsage().getCommitted() );
        allocateObjectMemory();
        myAfterAllocatingHeapSize = getHeapSize();
        System.out.println( "afterHeapSize:" + myBeforeAllocatingHeapSize + ",afterHeapSize From Memory Bean:" +
            myMemoryManager.getHeapMemoryUsage().getUsed() );
        printObjectSize();
    }

    private static long getHeapSize() throws Exception
    {
        runGc();
        return getUsedMemory();
    }

    private static void allocateObjectMemory() throws Exception
    {
        for( int i = 0; i < myObjectNum; i++ )
        {
//            Object object = new Object();
//            Object object = new Integer( i );
//            Object object = new Long( i );
//            Object object = new String();
            Object object = new Byte( ( byte ) i );

            myObjects[i] = object;
        }
    }

//    private static void allocateIntMemory() throws Exception
//    {
//        
//        for( int i = 0; i < myObjectNum; i++ )
//        {
//            myIntArray[i] = i * 2 + 1;
//        }
//    }
//
//    private static void allocateLongMemory() throws Exception
//    {
//        for( int i = 0; i < myObjectNum; i++ )
//        {
//            myLongArray[i] = i * 2 + 1;
//        }
//    }
//
//    private static void allocateByteMemory() throws Exception
//    {
//        for( int i = 0; i < myObjectNum; i++ )
//        {
//            myByteArray[i] = ( byte ) ( i % 128 + 1 );
//        }
//    }
//
//    private static void allocateFloatMemory() throws Exception
//    {
//        for( int i = 0; i < myObjectNum; i++ )
//        {
//            myFloatArray[i] = i * 2 + 1;
//        }
//    }
//
//    private static void allocateDoubleMemory() throws Exception
//    {
//        for( int i = 0; i < myObjectNum; i++ )
//        {
//            myDoubleArray[i] = i * 2 + 1;
//        }
//    }
//
//    private static void allocateCharMemory() throws Exception
//    {
//        for( int i = 0; i < myObjectNum; i++ )
//        {
//            myCharArray[i] = ( char ) ( i * 2 + 1 );
//        }
//    }

    private static void printObjectSize()
    {
        final int size =
            Math.round( ( ( float ) ( myAfterAllocatingHeapSize - myBeforeAllocatingHeapSize ) ) / myObjectNum );
        System.out.println( "'before' heap: " + myBeforeAllocatingHeapSize + ", 'after' heap: " +
            myAfterAllocatingHeapSize );
        System.out.println( "heap delta: " + ( myAfterAllocatingHeapSize - myBeforeAllocatingHeapSize ) + ", {" +
            myObjects[0].getClass() + "} size = " + size + " bytes" );
    }


    private static void clear()
    {
        for( Object object : myObjects )
        {
            if( null != object )
            {
                object = null;
            }
        }
        myObjects = null;
//        myIntArray = null;
//        myLongArray = null;
//        myDoubleArray = null;
//        myFloatArray = null;
//        myByteArray = null;
//        myCharArray = null;
    }

    private static long getUsedMemory()
    {
        return myRuntime.totalMemory() - myRuntime.freeMemory();
    }

    private static long getUsedStackMemory()
    {
        return myMemoryManager.getNonHeapMemoryUsage().getUsed();
    }

    private static void runGc() throws Exception
    {
//        long usedMem = getUsedMemory();
//        long tmpUsedMem = Long.MAX_VALUE;
//        for( int i = 0; i < 5000; i++ )
//        {
//            myRuntime.runFinalization();
//            myRuntime.gc();
//            Thread.yield();
//
//            tmpUsedMem = usedMem;
//            usedMem = getUsedMemory();
//            if( usedMem >= tmpUsedMem )
//            {
//                break;
//            }
//        }

        myRuntime.runFinalization();
        myRuntime.gc();
    }

}
