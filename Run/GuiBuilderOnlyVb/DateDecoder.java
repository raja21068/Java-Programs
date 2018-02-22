// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:10:52 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DateDecoder.java

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDecoder
{

    public DateDecoder()
    {
    }

    public static String getDateFormat(Date date)
    {
        if(date == null)
        {
            return "";
        } else
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
            String str = format.format(date);
            return str;
        }
    }
}
