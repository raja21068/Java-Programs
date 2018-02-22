// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:11:04 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Main.java

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main
{

    public Main()
    {
    }

    public static void main(String args[])
        throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        (new MainFrame()).setVisible(true);
    }
}
