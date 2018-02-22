// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:10:01 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CamelNotationLogic.java


public class CamelNotationLogic
{

    public CamelNotationLogic()
    {
    }

    private static String removeCharAt(String word, int pos)
    {
        StringBuilder builder = new StringBuilder(word);
        builder.deleteCharAt(pos);
        return builder.toString();
    }

    public static String getClass(String value)
    {
        String str[] = value.split("_");
        value = "";
        for(int i = 0; i < str.length; i++)
        {
            String ch = (new StringBuilder()).append("").append(str[i].charAt(0)).toString().toUpperCase();
            str[i] = removeCharAt(str[i], 0).toLowerCase();
            value = (new StringBuilder()).append(value).append(ch).append(str[i]).toString();
        }

        return value;
    }

    public static String getVaraible(String value)
    {
        String str[] = value.split("_");
        String ch = (new StringBuilder()).append("").append(str[0].charAt(0)).toString().toLowerCase();
        str[0] = removeCharAt(str[0], 0).toLowerCase();
        value = (new StringBuilder()).append(ch).append(str[0]).toString();
        for(int i = 1; i < str.length; i++)
        {
            ch = (new StringBuilder()).append("").append(str[i].charAt(0)).toString().toUpperCase();
            str[i] = removeCharAt(str[i], 0).toLowerCase();
            value = (new StringBuilder()).append(value).append(ch).append(str[i]).toString();
        }

        return value;
    }
}
