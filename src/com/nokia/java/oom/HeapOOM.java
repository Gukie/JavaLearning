/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class HeapOOM
{



    public static void main( String[] args )
    {
        List<TestObjec> list = new ArrayList<HeapOOM.TestObjec>();
        while(true){
            list.add( new TestObjec() );
        }
    }

    static class TestObjec
    {

    }

}
