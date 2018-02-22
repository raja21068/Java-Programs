// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:11:37 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   QueryBuilder.java

import java.util.Vector;

public class QueryBuilder
{

    public QueryBuilder()
    {
    }

    public static String generateSelectQuery(String tableName, Vector columsName, Vector columnsType)
    {
        String query = "SELECT ";
        for(int i = 0; i < columsName.size(); i++)
        {
            String columnName = (String)columsName.elementAt(i);
            query = (new StringBuilder()).append(query).append(columnName).toString();
            if(columsName.size() != i + 1)
                query = (new StringBuilder()).append(query).append(", ").toString();
        }

        query = (new StringBuilder()).append(query).append(" FROM ").append(tableName).toString();
        return query;
    }

    public static String generateUpdateQuery(String tableName, String primeryKey, Vector columsName, Vector columnsType)
    {
        String query = (new StringBuilder()).append("UPDATE ").append(tableName).append(" SET ").toString();
        for(int i = 0; i < columsName.size(); i++)
        {
            String columnName = (String)columsName.elementAt(i);
            String type = (String)columnsType.elementAt(i);
            if(columnName.equals(primeryKey))
                continue;
            query = (new StringBuilder()).append(query).append(columnName).append("=").toString();
            columnName = TypeCasting.getQuatation(type, CamelNotationLogic.getVaraible(columnName));
            query = (new StringBuilder()).append(query).append(columnName).toString();
            if(columsName.size() != i + 1)
                query = (new StringBuilder()).append(query).append(", ").toString();
        }

        query = (new StringBuilder()).append(query).append(" WHERE ").append(primeryKey).append("=\"+").append(CamelNotationLogic.getVaraible(primeryKey)).toString();
        return query;
    }

    public static String generateDeleteQuery(String tableName, String primeryKey)
    {
        String query = (new StringBuilder()).append("DELETE FROM ").append(tableName).append(" WHERE ").append(primeryKey).append("=\"+").append(CamelNotationLogic.getVaraible(primeryKey)).toString();
        return query;
    }

    public static String getInsertArgument(String primeryKey, Vector columnsName)
    {
        String arg = "";
        for(int i = 0; i < columnsName.size(); i++)
        {
            String columnName = (String)columnsName.elementAt(i);
            if(columnName.equals(primeryKey))
                continue;
            arg = (new StringBuilder()).append(arg).append("String ").append(CamelNotationLogic.getVaraible(columnName)).toString();
            if(columnsName.size() != i + 1)
                arg = (new StringBuilder()).append(arg).append(", ").toString();
        }

        return arg;
    }

    public static String getUpdateArgument(Vector columnsName)
    {
        String arg = "";
        for(int i = 0; i < columnsName.size(); i++)
        {
            String columnName = (String)columnsName.elementAt(i);
            arg = (new StringBuilder()).append(arg).append("String ").append(CamelNotationLogic.getVaraible(columnName)).toString();
            if(columnsName.size() != i + 1)
                arg = (new StringBuilder()).append(arg).append(", ").toString();
        }

        return arg;
    }

    public static String generateInsertQuery(String tableName, String primeryKey, Vector columnsName, Vector columnsType)
    {
        String query = (new StringBuilder()).append("INSERT INTO ").append(tableName).append("(").toString();
        for(int i = 0; i < columnsName.size(); i++)
        {
            String columnName = (String)columnsName.elementAt(i);
            if(columnName.equals(primeryKey))
                continue;
            query = (new StringBuilder()).append(query).append(columnName).toString();
            if(columnsName.size() != i + 1)
                query = (new StringBuilder()).append(query).append(", ").toString();
        }

        query = (new StringBuilder()).append(query).append(") VALUES (").toString();
        for(int i = 0; i < columnsName.size(); i++)
        {
            String columnName = (String)columnsName.elementAt(i);
            String type = (String)columnsType.elementAt(i);
            if(columnName.equals(primeryKey))
                continue;
            columnName = TypeCasting.getQuatation(type, CamelNotationLogic.getVaraible(columnName));
            query = (new StringBuilder()).append(query).append(columnName).toString();
            if(columnsName.size() != i + 1)
                query = (new StringBuilder()).append(query).append(", ").toString();
        }

        query = (new StringBuilder()).append(query).append(")").toString();
        return query;
    }
}
