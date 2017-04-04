package name2unicode;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class name2unicode extends JFrame implements ActionListener{
	JPanel row1 = new JPanel();
	JLabel name = new JLabel("Your name: ",JLabel.RIGHT);
	JLabel unicode = new JLabel("Unicode: ",JLabel.LEFT);
	JTextField names = new JTextField("Enter your name please",40);
	JTextArea unicodes = new JTextArea();
	JPanel row2 = new JPanel();
	JButton transfer = new JButton("Transfer");
	//transfer.addActionListener(this);
	
	public name2unicode(){
		super("name2unicode ------ Powered by HUYUNHAN");
		setLookAndFeel();
		setSize(800,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		transfer.addActionListener(this);
		unicodes.setLineWrap(true);
		FlowLayout lay =new FlowLayout();
		setLayout(lay);
		
		FlowLayout lay0 =  new FlowLayout();
		row1.setLayout(lay0);
		row1.add(name);
		row1.add(names);
		row1.add(unicode);
		row1.add(unicodes);
		add(row1);
		
		BorderLayout lay1 = new BorderLayout();
		row2.setLayout(lay1);
		row2.add(transfer,BorderLayout.SOUTH);
		add(row2);
		
		setVisible(true);
	}
	
	private static void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plat.nimbus.NimbusLookAndFeel");
		}catch(Exception exc){
			//ignore error
		}
	}
	
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		String getname = names.getText();
		int c = 0;
		for(int i=0;i<getname.length();i++){
			c = (int)(getname.charAt(i));
			unicodes.append("\\u" + Integer.toHexString(c));
			System.out.println("\\u" + Integer.toHexString(c));
		}
		//method name2unicode
	}
	
	public static void main(String[] arguments){
		name2unicode.setLookAndFeel();
		name2unicode frame = new name2unicode();
	}
}
