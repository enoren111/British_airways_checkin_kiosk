package boundary;

import control.Customer;
import control.Flight;
import control.Ticket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Payment extends MainFrame implements ActionListener {
	String seatType, foodType ;
	int total_fee, mealFee, seatFee;
	Ticket myTicket;
	Customer database;
	JButton b1,b2;
	JTextField jt1, jt2;
	String bookNumber;
	JPanel mainPanel = new JPanel();
	Flight myFlight;

	public Payment(Ticket myTicket, int totalFee, int seatFee, int mealFee, Flight myFlight){
		this.myTicket = myTicket;
		this.myFlight = myFlight;
		this.total_fee=totalFee;
		this.seatFee=seatFee;
		this.mealFee=mealFee;
		database = new Customer();
		this.foodType=myTicket.getFoodType();
		this.seatType=myTicket.getSeatNumber();

		Container container2 = this.getContentPane();
		container2.add(mainPanel);
		mainPanel.setSize(1200,1000);
		mainPanel.setLayout(null);


		JLabel label3 = new JLabel("                                                       Please complete your payment:");
		label3.setFont(new Font("Calibri",Font.BOLD,30));
		label3.setForeground(Color.black);
		label3.setBounds(0,0,1000,100);
		mainPanel.add(label3);


		JPanel panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createTitledBorder("EXTRA OPTION"));
		panel1.setBounds(0, 80, 1200, 200);
		mainPanel.add(panel1);
		String strMsg1 = "You total fee: " + this.total_fee + "$" +", including";
		String strMsg2 ="Seat: " + this.seatType+ "   , Fee:" + this.seatFee + "$";
		String strMsg3 ="Meal: " + this.foodType+ "   , Fee:" + this.mealFee + "$";
		String strMsg = "<html><body>" + strMsg1 + "<br>" + strMsg2 + "<br>" + strMsg3 + "<body></html>";
		JLabel label = new JLabel(strMsg);
		panel1.add(label);
		label.setForeground(Color.black);
		label.setFont(new Font("Calibri",Font.BOLD,40));

		JPanel panel2 = new JPanel();
		//BorderLayout layout=new BorderLayout();
		//panel2.setLayout(layout);
		mainPanel.add(panel2);
		//panel2.setBounds(0, 280, 1200, 220);
		//It would not show the credit card panel if your selections are free
		if(this.total_fee==0) {
			panel2.setBounds(0, 278, 1200, 219);
			JLabel bg = new JLabel();
			ImageIcon icon = new ImageIcon("src\\payment.png");
			icon.setImage(icon.getImage().getScaledInstance(1200,219,Image.SCALE_DEFAULT));
			bg.setIcon(icon);
			panel2.add(bg);
			bg.setBounds(0, 0, 1200, 219);
			b2 = new JButton("Next");
			b2.setBounds(500,450,150,45);
			b2.addActionListener(this);
			mainPanel.add(b2);
		}
		//It would show the credit card panel if your selections are paying
		else {
			panel2.setBounds(0, 280, 1200, 220);
			panel2.setBorder(BorderFactory.createTitledBorder("Credit Card for Payment"));
			panel2.setLayout(null);
			jt1 = new JTextField(20);
			jt2 = new JTextField(20);
			jt1.setBorder(BorderFactory.createTitledBorder("Account Number"));
			jt2.setBorder(BorderFactory.createTitledBorder("Password"));
			jt1.setBounds(350,80,150,40);
			jt2.setBounds(520,80,150,40);
			panel2.add(jt1);
			panel2.add(jt2);
			b1 = new JButton("Pay");
			b1.setBounds(540+150,80,80,40);
			panel2.add(b1);
			b1.addActionListener(this);
		}




		init(mainPanel);

		this.setVisible(true);// Let the frame is visible
		this.setTitle("Payment Information");// Set the title of frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Let the frame can be closed


	}
	// Override the method of the interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if ("".equals(jt1.getText()) || "".equals(jt2.getText())){
				JOptionPane.showMessageDialog(null, "Please input your credit card number and password to complete your payment", "Payment error",
						JOptionPane.WARNING_MESSAGE);}
			else if(jt1.getText().equals(myTicket.getCreditCard())&&jt2.getText().equals(myTicket.getCreditCardPassword())) {
				JOptionPane.showMessageDialog(null, "Pay successfully!", "Hint",JOptionPane.PLAIN_MESSAGE);
				this.dispose();
				new boardingpass(myTicket,myFlight);
			}
			else{
				System.out.println("Wrong account number or password!");
			}
		}

		// Press the 'next' button, then enter the next page
		else if (e.getSource() == b2) {
			this.dispose();
			new boardingpass(myTicket,myFlight);
		}
	}
}
