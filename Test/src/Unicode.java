import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.ComponentOrientation;

public class Unicode{
	TextArea area;
	Unicode(){
	System.out.println((char)39);
	System.out.println((char)92);
		String st="\n0600=\u0600  \n0601=\u0601 \n0602=\u0602 \n0603=\u0603" +
				"\n0604=\u0604  \n0605=\u0605 \n0606=\u0606 \n0607=\u0607" +
				"\n0608=\u0608  \n0609=\u0609 \n0610=\u0610 \n0611=\u0611" +
				"\n0612=\u0612  \n0613=\u0613 \n0614=\u0614 \n0615=\u0615" +
				"\n0616=\u0616  \n0617=\u0617 \n0618=\u0618 \n0619=\u0619" +
				"\n0620=\u0620  \n0621=\u0621 \n0622=\u0622 \n0623=\u0623" +
				"\n0624=\u0624  \n0625=\u0625 \n0626=\u0626 \n0627=\u0627" +
				"\n0628=\u0628  \n0629=\u0629 \n0630=\u0630 \n0631=\u0631" +
				"\n0632=\u0632  \n0633=\u0633 \n0634=\u0634 \n0635=\u0635" +
				"\n0636=\u0636  \n0637=\u0637 \n0638=\u0638 \n0639=\u0639" +
				"\n0640=\u0640  \n0641=\u0641 \n0642=\u0642 \n0643=\u0643" +
				"\n060A=\u060A \n060B=\u060B \n060C=\u060C \n060D=\u060D" +
				"\n060E=\u060E \n060F=\u060F \n06AA=\u06AA \n06AB=\u06AB" +
				"\n06AC=\u06AC \n06AD=\u06AD \n06AE=\u06AE \n06AF=\u06AF";
				char c= '\u0022';
				System.out.println(c);

		
		area = new TextArea(st);
		area.applyComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		area.setFont(new Font("arial",Font.BOLD,40));
		JFrame frame = new JFrame("\u0645\u06CC\u0631\u0627 \u067E\u0631\u0648\u06AF\u0631\u0627\u0645");
		frame.setLayout(null);
		area.setBounds(0,0,200,650);
		frame.getContentPane().add(area);
		frame.setBounds(100,10,250,700);
		frame.show();
	}
	public static void main(String arg[]){
		new Unicode();
	}
}