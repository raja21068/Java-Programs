import java.util.Vector;
import javax.swing.JButton;

class AddingGramsThread extends Thread
{
	private NGramsForm ngrams;
	private int catID;
	AddingGramsThread(NGramsForm ngrams,int catID)
	{
		this.ngrams = ngrams;
		this.catID = catID;
	}
	
	public void run()
	{
		ngrams.addButton.setEnabled(false);
		ngrams.clearButton.setEnabled(false);
		
		try{
		int i=0;
		for(int k=0 ; k<ngrams.gramsVector.size(); k++)
			i = DataBaseManager.insertGrams(catID, (String)ngrams.gramsVector.elementAt(k));
		if(i>0){
			javax.swing.JOptionPane.showMessageDialog(null, "Successfully Inserted!!");
			ngrams.clearAll();
		}
		}catch(Exception ex){ex.printStackTrace();}
		
		ngrams.addButton.setEnabled(true);
		ngrams.clearButton.setEnabled(true);
	}
}
