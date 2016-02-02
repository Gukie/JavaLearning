/*
 * Copyright (c) 2015 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.test;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class TestUtil
{

    private static final String LTE_KEYWORD = "lte";

    private static final String WCDMA_KEYWORD = "wcdma";

    private static final String SMALLCELL_KEYWORD = "smallcell";

    private static final String BTSSM_FILE_KEYWORD = "BTSSiteEM";

    private static final String PACKAGETYPE_WIN64_SUFFIX = "_x64.exe";

    private static final String PACKAGETYPE_LINUX64_SUFFIX = "_x64.bin";

    private static final String PACKAGETYPE_linux_i686_rpm_SUFFIX = "-1.i686.rpm";

    private static final String PACKAGE_TYPE_linux_noarch_rpm_SUFFIX = "-1.noarch.rpm";

    public static void main( String[] args )
    {
        boolean isValid = true;
        isValid = isValid && validateChanges();
        isValid = isValid && validateChanges();
        testString();

        System.out.println( getBranch( "BTSSiteEM-WN80-0_160_0_x64.bin" ) );
        System.out.println( getBuild( "BTSSiteEM-LTE31_x64.bin" ) );

        TestUtil tUtil = new TestUtil();
        if( tUtil.isPushableFile( "https://bescme.access.nokiasiemensnetworks.com/isource/svnroot/BTS_D_SE_UICA/wcdma/installer/tags/7.2.1728/Setup/BTSSiteEM-WN70-7.2.1728_x64.bin" ) )
        {
            System.out.println( "pushable" );
        }
        else
        {
            System.out.println( "not pushable" );
        }

        testBasicStr();
        System.out.println( "############createSampleValuesWithNegativeOnes############" );
        createSampleValuesWithNegativeOnes( 100, 2340L );

    }

    private static void testBasicStr()
    {
        String str = "2012";
        System.out.println( String.valueOf( str ).substring( 2 ) );

    }

    private static String getBranch( String fileName )
    {
        int length = "BTSSiteEM".length();
        int startIndex = length + 1;
        int endIndex = fileName.lastIndexOf( "_x64.bin" );
        return fileName.substring( startIndex, endIndex );
    }

    private static String getBuild( String fileName )
    {
        int startIndex = fileName.lastIndexOf( "-" ) + 1;
        int endIndex = getBuildEndIndex( fileName );
        String build = fileName.substring( startIndex, endIndex );
        if( Character.isDigit( build.charAt( 0 ) ) )
        {
            return build;
        }
        return "no build number";
    }

    private static int getBuildEndIndex( String fileName )
    {
        if( fileName.contains( PACKAGETYPE_LINUX64_SUFFIX ) )
        {
            return fileName.indexOf( PACKAGETYPE_LINUX64_SUFFIX );
        }
        if( fileName.contains( PACKAGE_TYPE_linux_noarch_rpm_SUFFIX ) )
        {
            return fileName.indexOf( PACKAGE_TYPE_linux_noarch_rpm_SUFFIX );
        }

        if( fileName.contains( PACKAGETYPE_linux_i686_rpm_SUFFIX ) )
        {
            return fileName.indexOf( PACKAGETYPE_linux_i686_rpm_SUFFIX );
        }

        if( fileName.contains( PACKAGETYPE_WIN64_SUFFIX ) )
        {
            return fileName.indexOf( PACKAGETYPE_WIN64_SUFFIX );
        }
        return fileName.lastIndexOf( "." );
    }

    private static boolean validateChanges()
    {
        System.out.println( "validate changes" );
        return false;
    }

    private static void testString()
    {
        try{
            String str = "LLLDDDREEW1334FFEDD";
            System.out.println( str.substring( 0, -1 ) );
        }
        catch( Exception e )
        {
            
        }
        

    }

    private boolean isPushableFile( String path )
    {
        if( !( isSupportedProductSvnUrl( path ) && isBTSSMFileUrl( path ) ) )
        {
            return false;
        }
        return true;
    }

    private boolean isBTSSMFileUrl( String url )
    {
        return url.contains( BTSSM_FILE_KEYWORD );
    }

    private boolean isSupportedProductSvnUrl( String path )
    {
//        List<String> segmentsList = new ArrayList<>();
//        for(String segment: path.split( "/" )){
//            if
//        }
//        path.split( "/" );
        return isSmallCellSvnUrl( path ) || isWcdmaSvnUrl( path ) || isLteSvnUrl( path );
    }

    private static boolean isSmallCellSvnUrl( String path )
    {
        return path.contains( "/" + SMALLCELL_KEYWORD + "/" );
    }

    private static boolean isLteSvnUrl( String path )
    {
        return path.contains( "/" + LTE_KEYWORD + "/" );
    }

    private static boolean isWcdmaSvnUrl( String path )
    {
        return path.contains( "/" + WCDMA_KEYWORD + "/" );
    }

    public static void createSampleValuesWithNegativeOnes( int sampleCount, Long max )
    {
        for( int i = 0; i < sampleCount; i++ )
        {
            boolean negativeOrNot = ThreadLocalRandom.current().nextBoolean();
            long longVal = ThreadLocalRandom.current().nextLong( max );
            System.out.println( ( new BigDecimal( negativeOrNot ? ( -1 ) * longVal : longVal ) ) );
        }

    }
}

