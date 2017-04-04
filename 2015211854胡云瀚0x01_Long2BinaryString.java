package java.study.onclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class L2B extends JFrame implements ActionListener{
	JPanel pan = new JPanel();
	JButton ok = new JButton("OK");
	JLabel ints = new JLabel("Integer:");
	JTextField numbers = new JTextField("Enter an Integer please",20);
	JTextArea binstr = new JTextArea(1,60);
	public L2B (){
		super("long2binary");
		setLookAndFeel();
		setSize(1200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ok.addActionListener(this);
		FlowLayout flo = new FlowLayout();
		pan.add(ints);
		pan.add(numbers);
		pan.add(binstr);
		pan.add(ok);
		pan.setLayout(flo);
		add(pan);
		setVisible(true);
	}
	
	public void Method(long number) {
		binstr.setText("");
		System.out.println(Long.toBinaryString(number));
		try{
			for(int i = 0;i < 63;i++){
				if(((1L << (63 - i)) & number) != 0){
					//System.out.print("1");
					binstr.append("1");
				}
				else{
					binstr.append("0");
				}
			}
		}catch(Exception exc){
			binstr.setText("ERROR:This is not a number or this number is too big!");
		}
	}
	
	private static void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
		}catch(Exception exc){
			//ignore
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		try{
			Method(Long.parseLong(numbers.getText()));
		}catch(Exception exc){
			binstr.setText("ERROR:This is not a number or this number is too big!");
		}
	}
	public static void main(String[] args){
		L2B.setLookAndFeel();
		L2B frame = new L2B();
	}
}