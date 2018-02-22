import java.awt.*;

class note{
public static void main(String arg[]){

Frame win=new Frame("Notepad");
TextArea txt=new TextArea();

MenuBar bar=new MenuBar();

Menu file=new Menu("File");
Menu edit=new Menu("Edit");
Menu format=new Menu("Format");
Menu view=new Menu("View");
Menu help=new Menu("Help");

MenuItem newf=new MenuItem("new         ctrl+N");
MenuItem open=new MenuItem("open        ctrl+O");
MenuItem save=new MenuItem("Save         ctrl+s");
MenuItem saveas=new MenuItem("Save As...");
MenuItem page=new MenuItem("Page setup...");
MenuItem prnt=new MenuItem("Print...      ctrl+P");
MenuItem exit=new MenuItem("Exit");

MenuItem undo=new MenuItem("Undo");
MenuItem cut=new MenuItem("cut");
MenuItem copy=new MenuItem("copy");
MenuItem paste=new MenuItem("Paste");
MenuItem delete=new MenuItem("delete");
MenuItem find=new MenuItem("Find..");
MenuItem next=new MenuItem("Find Next");
MenuItem replace=new MenuItem("Replace");
MenuItem got=new MenuItem("Goto...  ");
MenuItem select=new MenuItem("Select All");
MenuItem time=new MenuItem("Time/Date");

MenuItem word=new MenuItem("Word Wrap");
MenuItem font=new MenuItem("Font...");

MenuItem status= new MenuItem("Status Bar");
MenuItem vhelp=new MenuItem("View Help");
MenuItem about=new MenuItem("About notepad");


win.setBounds(0,0,500,500);

bar.add(file);
bar.add(edit);
bar.add(format);
bar.add(view);
bar.add(help);

file.add(newf);
file.add(open);
file.add(save);
file.add(saveas);
file.add(page);
file.add(prnt);
file.add(exit);

edit.add(undo);
edit.add(cut);
edit.add(copy);
edit.add(paste);
edit.add(delete);
edit.add(find);
edit.add(next);
edit.add(replace);
edit.add(got);
edit.add(select);
edit.add(time);

format.add(word);
format.add(font);
view.add(status);
help.add(vhelp);
help.add(about);

win.add(txt);
win.setMenuBar(bar);
win.show();

}
}