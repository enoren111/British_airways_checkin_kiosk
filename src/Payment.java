

import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Payment extends MainFrame implements ActionListener {
	    String seatType, foodType ;
	    int total_fee;
	    JButton b1,b2;
	    JTextField jt1, jt2;
	    String bookNumber;
	    JPanel mainPanel = new JPanel();
	public Payment(String foodType, String seatType, int total_fee, String bookNumber){
		this.foodType=foodType;
		this.seatType=seatType;
		this.total_fee=total_fee;
		this.bookNumber=bookNumber;
		Container container2 = this.getContentPane();
		container2.add(mainPanel);
		mainPanel.setLayout(new GridLayout(4, 1));
		JLabel label3 = new JLabel("                            Please complete your payment:");
		label3.setFont(new Font("Calibri",Font.BOLD,40));
		label3.setForeground(Color.RED);
		mainPanel.add(label3);	
		JPanel panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createTitledBorder("EXTRA OPTION"));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		mainPanel.add(panel1);
		JTextArea textArea = new JTextArea(35,58);
		textArea.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(textArea);
		if(this.foodType=="gourmet menu"&&this.seatType=="normal") {
		textArea.setText("Your selections:" + "\n" + "meal: gourmet menu $50" + "\n" + "seat: normal $0" + "\n" + "You need to pay $"+this.total_fee);
		textArea.setFont(new Font("Calibri",Font.BOLD,22));}
		if(this.seatType=="special"&&this.foodType!="gourmet menu") {
			textArea.setText("Your selections:" + "\n" + "meal: "+ this.foodType + " $0" + "\n" + "seat: special $80" + "\n" + "You need to pay $"+this.total_fee);
			textArea.setFont(new Font("Calibri",Font.BOLD,22));}
		if(this.foodType=="gourmet menu"&&this.seatType=="special"){
			textArea.setText("Your selections:" + "\n" + "meal: "+ this.foodType + " $50" + "\n" + "seat: special $80" + "\n" + "You need to pay $"+this.total_fee);
			textArea.setFont(new Font("Calibri",Font.BOLD,22));}
		if(this.foodType!="gourmet menu"&&this.seatType=="normal"){
			textArea.setText("Your selections:" + "\n" + "meal: "+ this.foodType + " $0" + "\n" + "seat: normal $0" + "\n" + "You need to pay $"+this.total_fee);
			textArea.setFont(new Font("Calibri",Font.BOLD,22));}
		
		JPanel panel2 = new JPanel();
		mainPanel.add(panel2);
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Credit Card for Payment"));
		jt1 = new JTextField(20);
		jt2 = new JTextField(20);
		jt1.setBorder(BorderFactory.createTitledBorder("Account Number"));
		jt2.setBorder(BorderFactory.createTitledBorder("Password"));
		
		JPanel panel3 = new JPanel();
		panel2.add(panel3);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.add(jt1);
		panel3.add(jt2);
		b1 = new JButton("Pay");
		panel3.add(b1);
		b1.addActionListener(this);
		JLabel label4 = new JLabel("Notice:" +"\n" + "Please click on 'pay' button without inputing your credit card account and password if your cost is $0");
		label4.setForeground(Color.RED);
		label4.setFont(new Font("Calibri",Font.BOLD,15));
		panel2.add(label4, BorderLayout.SOUTH);
		
		
		JPanel panel4 = new JPanel();
		mainPanel.add(panel4);
		
		b2 = new JButton("Back");
		panel4.add(b2);		
		b2.addActionListener(this);
		
		
		init(mainPanel);
		
		this.setVisible(true);// Let the frame is visible
		this.setTitle("Flight Check In");// Set the title of frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Let the frame can be closed
		

	}
	// Override the method of the interface ActionListener
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1) {
					if ("".equals(jt1.getText()) || "".equals(jt2.getText())){
						JOptionPane.showMessageDialog(null, "Please input your credit card number and password to complete your payment", "Payment error",
								JOptionPane.WARNING_MESSAGE);}
						else {
							this.dispose();
							boardingpass boarding=new boardingpass(bookNumber);
							}
					}
					
				// Press the exit button, then close the program
				else if (e.getSource() == b2) {
					this.dispose();
					FlightFrame myframe = new FlightFrame(bookNumber);
					System.out.println("bookNumber");
				}
			}
}
