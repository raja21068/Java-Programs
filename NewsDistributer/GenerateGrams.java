import java.io.*;
import java.util.*;
import javax.swing.*;

class GenerateGrams implements Runnable
{
	private Thread t;
	private NGramsForm form;
	private String str="";
	
	GenerateGrams(NGramsForm form)
	{
		this.form = form;
		readFile(form.browseText.getText());
		t = new Thread(this,"Genrate Forms Thread");
		t.start();
	}
	
	private void readFile(String fileName)
	{
		File f = new File(fileName);
		if(f.exists())
		{
			try{
				try(DataInputStream in = new DataInputStream(new FileInputStream(f));)
				{
					String s;
					while((s = in.readLine()) != null)
						str = str + s + ' ';
				}
			}catch(Exception ex){}
		}
	}
	
	public void run()
	{
		int n=2;
		Vector v = new Vector();
		
		if(str.contains(" "))
		{
			String words[] = str.split(" ");
			if(words.length < n)
				t.stop();
			boolean stop = false;
			
			form.bar.setMinimum(0);
			form.bar.setMaximum(words.length);
			form.bar.setValue(0);
			
			int i=0;
			while(i < words.length && !stop)
			{
				String s = "";
				for(int k=i ; k<i+n ; k++)
				{
					s = s + words[k] + " ";
					if(k == words.length-1)
						stop = true;
				}
				v.addElement(s);
				i++;
				form.bar.setValue(i);
			}
			i++;
			form.bar.setValue(i);

		}
		
		else
		{
			char ch[] = str.toCharArray();
			if(ch.length < n)
				t.stop();
			boolean stop = false;
			
			form.bar.setMinimum(0);
			form.bar.setMaximum(ch.length);
			form.bar.setValue(0);
			int i=0;
			while(i < ch.length && !stop)
			{
				String s = "";
				for(int k=i ; k<i+n ; k++)
				{
					s = s + ch[k];
					if(k == ch.length-1)
						stop = true;
				}
				v.addElement(s);
				i++;
				form.bar.setValue(i);
			}
			i++;
			form.bar.setValue(i);
		}
		
		
		form.list.setListData(v);
		form.gramsVector = v;
		
		form.clearButton.setEnabled(true);
		form.addButton.setEnabled(true);
	}
}
