package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;
public class Calculator  extends JFrame{
	//create variables that will hold the numbers used in the calculations
	double firstNum=0,secondNum=0,result=0,memory=0;
	String command;//command will hold the input of an operation eg. +,-
	boolean calculation;// a boolean that determins if the numbers in the display are the result of a calculation
	
	public Calculator(){

		//create all the required panels, and buttons and textFeilds
		JPanel panel = new JPanel();
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bPlus = new JButton("+");
		JButton bMinus = new JButton("-");
		JButton bPoint = new JButton(".");
		JButton bC = new JButton("C");
		JButton bCE = new JButton("CE");
		JButton bDiv = new JButton("/");
		JButton bMul = new JButton("*");
		JButton bBS = new JButton("\u2190");
		JButton bEquals = new JButton("=");
		JButton bMC = new JButton("MC");
		JButton bMR = new JButton("MR");
		JButton bMS = new JButton("MS");
		JButton bMPlus = new JButton("M+");
		JButton bMMinus = new JButton("M-");
		JButton bNeg = new JButton("\u00B1");
		JButton bRoot = new JButton("\u221A");
		JButton bPow = new JButton("^");
		JButton bInverse= new JButton("l/x");
		
		JTextField display = new JTextField(30);
		display.setEditable(false);//means the user can only edit the display via the buttons
		display.setHorizontalAlignment(SwingConstants.RIGHT);//Aligns the text in the display to the right
		panel.setLayout(new MigLayout("wrap 5"));//sets the layout and tells it to wrap after every 5th element
		panel.add(display,"span,wrap");//tells the text field to span the panel and wrap after it 
		//row 1
		panel.add(bMC,"grow");//all the buttons are set to grow so that they fit the panel exactly
		panel.add(bMR,"grow");
		panel.add(bMS,"grow");
		panel.add(bMPlus,"grow");
		panel.add(bMMinus,"grow");
		//row2
		panel.add(bBS,"grow");
		panel.add(bCE,"grow");
		panel.add(bC,"grow");
		panel.add(bNeg,"grow");
		panel.add(bRoot,"grow");
		//row3
		panel.add(b7,"grow");
		panel.add(b8,"grow");
		panel.add(b9,"grow");
		panel.add(bDiv,"grow");
		panel.add(bPlus,"grow");
	
		//row 4
		panel.add(b4,"grow");
		panel.add(b5,"grow");
		panel.add(b6,"grow");
		panel.add(bMul,"grow");
		panel.add(bPow,"grow");
		//row 5
		panel.add(b1,"grow");
		panel.add(b2,"grow");
		panel.add(b3,"grow");
		panel.add(bMinus,"grow");
		panel.add(bInverse,"grow");
		
		//row 6
		panel.add(b0,"grow, span 2");// the 0 button is set to span two rows
		panel.add(bPoint,"grow");
		panel.add(bEquals,"grow, span 2");//sets the equals button to span two rows
		add(panel, BorderLayout.CENTER);
		
		//set action listeners for each of the buttons
		
		bBS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bs=null;//a string that will be reset to the number in the text field minus the last number and displayed
				if(!calculation){//makes sure that the text field can't be backspaced if its the product of a calculation
				if(display.getText().length()!=0){//makes sure you wont get an error if you try to backspace an empty text field
					 StringBuilder sb = new StringBuilder(display.getText());//sets the numbers in the text field to a string variable sb that can be edited
					sb.deleteCharAt(display.getText().length()-1);//removes the last character from sb
					bs=sb.toString();//sets the value of bs to the value in sb so it can be displayed
					display.setText(bs);
				}
				}
			}
		});
		bCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(null);//clears the value in the text field
			}
		});
		bC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resets all the values stored in the calculator
				display.setText(null);
				firstNum=0;
				secondNum=0;
				result=0;
				command=null;
				//memory=0;
				
			}
		});
		bPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the first number and the command so they can be used in the equals action listener
				firstNum=Double.parseDouble(display.getText());
				display.setText("");
				command=("+");
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//makes sure than when a number button is pressed the value isn't just added onto the end of the result of a calculation 
				if(!calculation){
					String num = display.getText() + b7.getText();
					display.setText(num);
	//if the text field isn't the product of a calculation, adds the value onto the end of the value in the text field
					}else{
						String num =b7.getText();
						display.setText(num);//this will reset the display to the value of the button while the value in the text field is the product of a calculation 
						calculation=false;//calculation is set to false here so that the user can continue to add numbers while the text field isn't the product of a calculation 
					}
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b8.getText();
					display.setText(num);
					}else{
						String num =b8.getText();
						display.setText(num);
						calculation=false;
					}
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b9.getText();
					display.setText(num);
					}else{
						String num =b9.getText();
						display.setText(num);
						calculation=false;
					}
			}
		});
		bDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the first number and the command so they can be used in the equals action listener
				firstNum=Double.parseDouble(display.getText());
				display.setText("");
				command=("/");
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b4.getText();
					display.setText(num);
					}else{
						String num =b4.getText();
						display.setText(num);
						calculation=false;
					}
				
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b5.getText();
					display.setText(num);
					}else{
						String num =b5.getText();
						display.setText(num);
						calculation=false;
					}
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b6.getText();
					display.setText(num);
					}else{
						String num =b6.getText();
						display.setText(num);
						calculation=false;
					}
			}
		});
		bMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the first number and the command so they can be used in the equals action listener
				firstNum=Double.parseDouble(display.getText());
				display.setText("");
				command=("*");
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b1.getText();
					display.setText(num);
					}else{
						String num =b1.getText();
						display.setText(num);
						calculation=false;
					}
				
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b2.getText();
					display.setText(num);
					}else{
						String num =b2.getText();
						display.setText(num);
						calculation=false;
					}
				
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b3.getText();
					display.setText(num);
					}else{
						String num =b3.getText();
						display.setText(num);
						calculation=false;
					}
			}
		});
		bMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the first number and the command so they can be used in the equals action listener
				firstNum=Double.parseDouble(display.getText());
				display.setText("");
				command=("-");
			
			}
		});
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calculation){
					String num = display.getText() + b0.getText();
					display.setText(num);
					}else{
						String num =b0.getText();
						display.setText(num);
						calculation=false;
					}
			}
		});
		bPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().contains("."))//makes sure you cant have a number with two decimal points
		          {
		          display.setText(display.getText() + bPoint.getText());//places a decimal point on the end of the number in the text field
		          }else if(display.getText().equals(null)){//if there is nothing in the text field set the text field to . and let the user add from there 
		        	  display.setText(bPoint.getText());
		          }
			}
		});
		bEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//takes in the value in the text field and sets it to secondNum which is used to complete the calculation
				secondNum = Double.parseDouble(display.getText());
				calculation=true;//makes sure that the product of these calculations can't be backspaced and that you can add numbers onto the end of them via the buttons 
				//each if statement takes in firstNum and seconfNum and calculates and displays the result based on the coomand 
				if(command=="+"){
					result=firstNum + secondNum;
					display.setText(String.valueOf(result));
				}else if(command=="-"){
					result=firstNum - secondNum;
					display.setText(String.valueOf(result));
				}else if(command=="/"){
					result=firstNum / secondNum;
					display.setText(String.valueOf(result));
				}else if(command=="*"){
					result=firstNum * secondNum;
					display.setText(String.valueOf(result));
				}else if(command=="^"){
					result=Math.pow(firstNum,secondNum) ;
					display.setText(String.valueOf(result));
				}//end if
			}
		});
		bMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clears the value saved in the memory variable 
				memory=0;
			display.setText(String.valueOf(memory));
			}
		});
		bMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//displays the value stored in the memory in the text field
				calculation=true;
				display.setText(String.valueOf(memory));
			}
		});
		bMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the value of the memory to the value in the text field  
				memory=Double.parseDouble(display.getText());
				display.setText(null);
			}
		});
		bMPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the value in the memory variable to itself plus the value in the text field
				calculation=true;
				memory=memory + Double.parseDouble(display.getText());
				display.setText(String.valueOf(memory));
			}
		});
		bMMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the value in the memory variable to itself minus the value in the text field
				calculation=true;
				memory=memory - Double.parseDouble(display.getText());
				display.setText(String.valueOf(memory));
			}
		});
		bNeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the value in the text field to a minus
				firstNum=Double.parseDouble(display.getText())*-1;
				display.setText(String.valueOf(firstNum));
			}
		});
		bRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//takes in the value in the display and displays its square root
				firstNum=Double.parseDouble(display.getText());
				if(firstNum>0){
					calculation=true;
					firstNum=Math.sqrt(firstNum);
					display.setText(String.valueOf(firstNum));
				}
			}
		});
		
		bPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the first number and the command so they can be used in the equals action listener
				firstNum=Double.parseDouble(display.getText());
				display.setText("");
				command=("^");
				
		
			}
		});
		bInverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//takes in the value in the display and displays its inverse value 
				calculation=true;
				firstNum=Double.parseDouble(display.getText());
				if(firstNum==0){
					display.setText("ERROR");//displays an error if the user tries to get the inverse of 0 
				}else{
					calculation=true;
					firstNum=1/firstNum;
					display.setText(String.valueOf(firstNum));
				}
				
				
			}
		});
		
		
		
	}

	//main method 
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.setTitle("Calculator");
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setSize(300,270);
		calc.setVisible(true);

	}
}