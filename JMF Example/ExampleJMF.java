import javax.swing.JDialog;

import javax.swing.JFrame;

import javax.swing.UIManager;

import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.plaf.metal.MetalLookAndFeel;

 

public class ExampleJMF

{

public static void main(String[] args)

{

JFrame.setDefaultLookAndFeelDecorated(true);

JDialog.setDefaultLookAndFeelDecorated(true);

 

try

{

UIManager.setLookAndFeel(new MetalLookAndFeel());

}

catch(UnsupportedLookAndFeelException e)

{

e.printStackTrace();
}

 

new exampleFrame();

}

}