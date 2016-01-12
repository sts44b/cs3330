/*Name: Seanmichael Stanley
 * Date: 4/21/14
 * TA: Matt England
 * Section: D
 * Lab Code : Blues 2-0
 */

package sts44b.cs3330.lab10;

import java.awt.FlowLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Calculator extends JFrame implements WindowListener, ActionListener {


private JTextField text1 = new JTextField(16);
private JButton btn1;
private JButton btn2;
private JButton btn3;
private JButton btn4;
private JButton btn5;
private JButton btn6;
private JButton btn7;
private JButton btn8;
private JButton btn9;
private JButton btn0;
private JButton btnMinus;
private JButton btnPlus;
private JButton btnDivide;
private JButton btnMultiply;
private JButton btnSin;
private JButton btnCos;
private JButton btnTan;
private JButton btnEquals;
private JButton btnPnt;
private JButton btnClear;
private JPanel panel1;
private JPanel panel2;

//constructor to add buttons and textfield to the GUI
public Calculator(String title) {
		super("Calculator");
		setLayout(new FlowLayout());
		addWindowListener(this);
	
		panel1 = new JPanel();
		panel1.setSize(300,300);
		panel1.setVisible(true);

		panel2 = new JPanel();
		panel2.setSize(200,200);
		panel2.setLayout(new GridLayout(5, 4, 4, 4));
		panel2.setVisible(true);
		
		text1.setEditable(false);
		btn0 = new JButton ("0");
		btn1 = new JButton ("1");
		btn2 = new JButton ("2");
		btn3 = new JButton ("3");
		btn4 = new JButton ("4");
		btn5 = new JButton ("5");
		btn6 = new JButton ("6");
		btn7 = new JButton ("7");
		btn8 = new JButton ("8");
		btn9 = new JButton ("9");
		btnPnt = new JButton(".");
		btnClear = new JButton("C");
		btnPlus = new JButton (" + ");
		btnMinus = new JButton (" - ");
		btnMultiply = new JButton (" * ");
		btnDivide = new JButton (" / ");
		btnEquals = new JButton ("=");
		btnSin = new JButton ("Sin");
		btnCos = new JButton ("Cos");
		btnTan = new JButton ("Tan");
		
		btnClear.addActionListener(this);
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btnEquals.addActionListener(this);
		btnMinus.addActionListener(this);
		btnPlus.addActionListener(this);
		btnMultiply.addActionListener(this);
		btnDivide.addActionListener(this);
		btnSin.addActionListener(this);
		btnCos.addActionListener(this);
		btnTan.addActionListener(this);
		
		add(text1);
		add(panel2);

		panel2.add(btn7);
		panel2.add(btn8);
		panel2.add(btn9);
		panel2.add(btnDivide);
		
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btnMultiply);
		
		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(btn3);
		panel2.add(btnMinus);
		
		panel2.add(btn0);
		panel2.add(btnPnt);
		panel2.add(btnClear);
		panel2.add(btnPlus);
		
		panel2.add(btnEquals);
		panel2.add(btnSin);
		panel2.add(btnCos);
		panel2.add(btnTan);
	}


//class to handle button clicks "ButtonHnadler"
	public void actionPerformed(ActionEvent e) {
		int num1, num2, answer;
		String displayAnswer;
		double trig, trigAnswer;
		
		if (e.getSource() == btn0){
			text1.setText(text1.getText() + "0");
		}
		
		else if (e.getSource() == btn1){
			text1.setText(text1.getText() + "1");
		}
		
		else if (e.getSource() == btn2){
			text1.setText(text1.getText() + "2");
		}
		
		else if (e.getSource() == btn3){
			text1.setText(text1.getText() + "3");
		}
		
		else if (e.getSource() == btn4){
			text1.setText(text1.getText() + "4");
		}
		
		else if (e.getSource() == btn5){
			text1.setText(text1.getText() + "5");
		}
		
		else if (e.getSource() == btn6){
			text1.setText(text1.getText() + "6");
		}
		
		else if (e.getSource() == btn7){
			text1.setText(text1.getText() + "7");
		}
		
		else if (e.getSource() == btn8){
			text1.setText(text1.getText() + "8");
		}
		
		else if (e.getSource() == btn9){
			text1.setText(text1.getText() + "9");
		}
		
		else if (e.getSource() == btnClear){
			text1.setText("");
		}
		
		else if (e.getSource() == btnPlus){
			text1.setText(text1.getText() + " + ");
		}
		
		else if (e.getSource() == btnMinus){
			text1.setText(text1.getText() + " - ");
		}
		
		else if (e.getSource() == btnMultiply){
			text1.setText(text1.getText() + " * ");
		}
		
		else if (e.getSource() == btnDivide){
			text1.setText(text1.getText() + " / ");
		}
		
		else if (e.getSource() == btnSin){
			text1.setText("Sin ");
		}
		
		else if (e.getSource() == btnCos){
			text1.setText(text1.getText() + "Cos ");
		}
		
		else if (e.getSource() == btnTan){
			text1.setText(text1.getText() + "Tan ");
		}
		
		//Handles calculations when equals button is clicked
		else if (e.getSource() == btnEquals){			
			
			if (text1.getText().contains("+")){
				String tok[] = text1.getText().split(" ");
				num1 = Integer.parseInt(tok[0]);
				num2 = Integer.parseInt(tok[2]);
				answer = num1 + num2;
				displayAnswer = String.valueOf(answer);
				text1.setText(displayAnswer);
			}
			
			else if (text1.getText().contains("-")){
				String tok[] = text1.getText().split(" ");
				num1 = Integer.parseInt(tok[0]);
				num2 = Integer.parseInt(tok[2]);
				answer = num1 - num2;
				displayAnswer = String.valueOf(answer);
				text1.setText(displayAnswer);
			}
			
			else if (text1.getText().contains("*")){
				String tok[] = text1.getText().split(" ");
				num1 = Integer.parseInt(tok[0]);
				num2 = Integer.parseInt(tok[2]);
				answer = num1 * num2;
				displayAnswer = String.valueOf(answer);
				text1.setText(displayAnswer);
			}
			
			else if (text1.getText().contains("/")){
				String tok[] = text1.getText().split(" ");
				num1 = Integer.parseInt(tok[0]);
				num2 = Integer.parseInt(tok[2]);
				answer = num1 / num2;
				displayAnswer = String.valueOf(answer);
				text1.setText(displayAnswer);
			}
			
			else if (text1.getText().contains("Sin")){
				String tok[] = text1.getText().split(" ");
				trig = Double.parseDouble(tok[1]);
				trigAnswer = Math.sin(trig);
				displayAnswer = String.valueOf(trigAnswer);
				text1.setText(displayAnswer);
			}
			
			else if (text1.getText().contains("Cos")){
				String tok[] = text1.getText().split(" ");
				trig = Double.parseDouble(tok[1]);
				trigAnswer = Math.cos(trig);
				displayAnswer = String.valueOf(trigAnswer);
				text1.setText(displayAnswer);
			}
			
			else if (text1.getText().contains("Tan")){
				String tok[] = text1.getText().split(" ");
				trig = Double.parseDouble(tok[1]);
				trigAnswer = Math.tan(trig);
				displayAnswer = String.valueOf(trigAnswer);
				text1.setText(displayAnswer);
			}
		}
		
	}

	public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
	
	public void windowClosed(WindowEvent e) {
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator("Calculator");
		calculator.setSize(300, 300);
		calculator.setVisible(true);
	}

}