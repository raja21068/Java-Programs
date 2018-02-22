import java.io.*;
import java.awt.*; 

class FileDemo2{
public static void main(String arg[])throws Exception {
Frame win=new Frame();

FileDialog dialog=new FileDialog(win,"open....",FileDialog.LOAD);

dialog.show();
System.out.println(dialog.getDirectory() + dialog.getFile());

//File f=new File(dialog.getDirectory() + dialog.getFile());

}
}