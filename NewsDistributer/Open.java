import java.awt.FileDialog;
import javax.swing.JDialog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;

class Open
{
	private NewsDistributer nd;
	
	Open(NewsDistributer nd)
	{
		this.nd = nd;
		open();
	}
	
	private void open()
	{
		JDialog dialog = new JDialog();
		FileDialog d = new FileDialog(dialog,"Open...",FileDialog.LOAD);
		d.setVisible(true);
		nd.openFileText.setText(d.getDirectory());
		
		File f = new File(d.getDirectory());
		String files[] = f.list(new Filtering());
		Vector v = new Vector();
		for(int k=0 ; k<files.length ; k++)
			v.addElement(files[k]);
		nd.list.setListData(v);
			
	}
	
	static String openFile()
	{
		String source="";
		
		JDialog dialog = new JDialog();
		FileDialog d = new FileDialog(dialog,"Open...",FileDialog.LOAD);
		d.setVisible(true);
		
		if(d.getDirectory() != null && d.getFile() != null)
		{
			if(d.getFile().endsWith("txt"))
				source = d.getDirectory() + d.getFile();
		}
		
		return source;
	}
	
}


class Filtering implements FilenameFilter
{
	
	public boolean accept(File dir,String name)
	{
		if(dir.isDirectory())
			return name.endsWith("txt");
		
		else
			return false;
	}
}