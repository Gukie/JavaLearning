/*
 * Copyright (c) 2014 Nokia Solutions and Networks. All rights reserved.                         
 */
package com.nokia.bean;

/**
 * @author <a href="mailto:shu.1.gu@nsn.com">Jason</a>
 *
 */
public class Balloon
{

    private String color;

    public Balloon()
    {
    }

    public Balloon( String c )
    {
        this.color = c;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String color )
    {
        this.color = color;
    }
}
