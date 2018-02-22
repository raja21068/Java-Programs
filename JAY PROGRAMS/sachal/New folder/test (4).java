import java.awt.*;

class Test {
    public static void main(String arg[]){

       Frame win = new Frame();
       TextArea area = new TextArea();

     MenuBar menuBar = new MenuBar();

     Menu fileMenu = new Menu("File");
     Menu editMenu = new Menu("Edit");

     MenuItem newItem = new MenuItem ("New");
     MenuItem openItem = new MenuItem ("Open...");
     MenuItem copyItem = new MenuItem ("Copy");
     MenuItem pasteItem = new MenuItem ("Paste");

         win.setBounds(0,0,300,300);
         win.add(area);
         win.setMenuBar(menuBar);         

         menuBar.add(fileMenu);
         menuBar.add(editMenu);

         fileMenu.add(newItem);
         fileMenu.add(openItem);
         editMenu.add(copyItem);
         editMenu.add(pasteItem);

         win.show();
    }
}