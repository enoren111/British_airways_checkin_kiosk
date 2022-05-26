package boundary;

import control.Customer;
import control.Ticket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class FlightFrame extends MainFrame implements ActionListener {
	JComboBox<String> ord_option, ext_option;
	JButton b1, b2, b3;
	int extraFee;
	String mySeatState;
	String mySeatType;
	String mySeatId;
	Ticket myTicket;
	Customer database;
	String bookNumber;
	JPanel mainPanel = new JPanel();

	SeatButton seatButton1 = new SeatButton("unselected.png", 0 ,0,"0","special","1");
	SeatButton seatButton2 = new SeatButton("unselected.png", 75 ,0,"0","special","2");
	SeatButton seatButton3 = new SeatButton("unselected.png", 500 ,0,"0","normal","3");
	SeatButton seatButton4 = new SeatButton("unselected.png", 550 ,0,"0","normal","4");
	SeatButton seatButton5 = new SeatButton("unselected.png", 600 ,0,"0","normal","5");
	SeatButton seatButton6 = new SeatButton("unselected.png", 650 ,0,"0","normal","6");
	SeatButton seatButton7 = new SeatButton("unselected.png", 1050 ,0,"0","special","7");
	SeatButton seatButton8 = new SeatButton("unselected.png", 1125 ,0,"0","special","8");
	SeatButton seatButton9 = new SeatButton("unselected.png", 0 ,50,"0","special","9");
	SeatButton seatButton10 = new SeatButton("unselected.png", 75 ,50,"0","special","10");
	SeatButton seatButton11 = new SeatButton("unselected.png", 500 ,50,"0","normal","11");
	SeatButton seatButton12 = new SeatButton("unselected.png", 550 ,50,"0","normal","12");
	SeatButton seatButton13 = new SeatButton("unselected.png", 600,50,"0","normal","13");
	SeatButton seatButton14 = new SeatButton("unselected.png", 650,50,"0","normal","14");
	SeatButton seatButton15 = new SeatButton("unselected.png", 1050 ,50,"0","special","15");
	SeatButton seatButton16 = new SeatButton("unselected.png", 1125 ,50,"0","special","16");
	ArrayList<SeatButton> seats = new ArrayList<>();

	public FlightFrame(String bookNumber) {
		/**
		 * Create container object, The operation of components in javax.swing need to
		 * operate under the container
		 */
		this.bookNumber = bookNumber;
		database = new Customer();

		SeatButton[] seatButtons = new SeatButton[16];
		seatButtons[0] = seatButton1;
		seatButtons[1] = seatButton2;
		seatButtons[2] = seatButton3;
		seatButtons[3] = seatButton4;
		seatButtons[4] = seatButton5;
		seatButtons[5] = seatButton6;
		seatButtons[6] = seatButton7;
		seatButtons[7] = seatButton8;
		seatButtons[8] = seatButton9;
		seatButtons[9] = seatButton10;
		seatButtons[10] = seatButton11;
		seatButtons[11] = seatButton12;
		seatButtons[12] = seatButton13;
		seatButtons[13] = seatButton14;
		seatButtons[14] = seatButton15;
		seatButtons[15] = seatButton16;

		for (Ticket ticket: database.ticketHashSet) {
			System.out.println("-----------------------");
			System.out.println(ticket.toString());
			String SeatState = ticket.getSeatNumber().split(" ")[0];
			String SeatId = ticket.getSeatNumber().split(" ")[2];
			System.out.println(SeatState);
			if (SeatState.equals("-1")) {
				System.out.println(SeatId);
				for (int i = 0; i < seatButtons.length; i++) {
					if (seatButtons[i].SeatId.equals(SeatId) ) {
						seatButtons[i].SeatState = "-1";
						seatButtons[i].changeSeatState();
					}
				}
			}

		}

		System.out.println(seatButton12.SeatState);
		myTicket = database.checkBookNumber(bookNumber);
		mySeatState = myTicket.getSeatNumber().split(" ")[0];
		mySeatType = myTicket.getSeatNumber().split(" ")[1];
		mySeatId = myTicket.getSeatNumber().split(" ")[2];
//		System.out.println(mySeatState);
//		System.out.println(mySeatType);
//		System.out.println(mySeatId);


		Container container = this.getContentPane();
		container.add(mainPanel);
		mainPanel.setLayout(new GridLayout(4, 1));// Set the frame to a grid layout of 9 rows and 1 column
		// Add a label on the first line of the frame to inform the user to complete the
		// information editing
		JLabel label1 = new JLabel("                     Please choose your seat and meal below:");
		label1.setFont(new Font("Calibri",Font.BOLD,30));
		label1.setForeground(Color.black);
		mainPanel.add(label1);

		JPanel panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createTitledBorder("Seat (a wide seat is $80)"));
		panel1.setLayout(null);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0,15,1200,300);

		//Seat_Panel_inside
		JPanel seat_Panel_inside = new JPanel();
		seat_Panel_inside.setLayout(null);

		seat_Panel_inside.setPreferredSize(new Dimension(1200,300));
		seat_Panel_inside.setVisible(true);


		jsp.getViewport().add(seat_Panel_inside);
		jsp.validate();
		panel1.add(jsp);

		seats.add(seatButton1);
		seats.add(seatButton2);
		seats.add(seatButton3);
		seats.add(seatButton4);
		seats.add(seatButton5);
		seats.add(seatButton6);
		seats.add(seatButton7);
		seats.add(seatButton8);
		seats.add(seatButton9);
		seats.add(seatButton10);
		seats.add(seatButton11);
		seats.add(seatButton12);
		seats.add(seatButton13);
		seats.add(seatButton14);
		seats.add(seatButton15);
		seats.add(seatButton16);
		seat_Panel_inside.add(seatButton1);
		seat_Panel_inside.add(seatButton2);
		seat_Panel_inside.add(seatButton3);
		seat_Panel_inside.add(seatButton4);
		seat_Panel_inside.add(seatButton5);
		seat_Panel_inside.add(seatButton6);
		seat_Panel_inside.add(seatButton7);
		seat_Panel_inside.add(seatButton8);
		seat_Panel_inside.add(seatButton9);
		seat_Panel_inside.add(seatButton10);
		seat_Panel_inside.add(seatButton11);
		seat_Panel_inside.add(seatButton12);
		seat_Panel_inside.add(seatButton13);
		seat_Panel_inside.add(seatButton14);
		seat_Panel_inside.add(seatButton15);
		seat_Panel_inside.add(seatButton16);


		JPanel panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createTitledBorder("Meal"));
		JPanel panel7 = new JPanel();
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel7);

		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel7.add(panel3);
		panel7.add(panel4);
		b1 = new JButton("Next step");
		b1.setSize(200,200);
		b2 = new JButton("Back");
		b2.setSize(300,500);
		panel3.add(b2);
		panel4.add(b1);
		b1.addActionListener(this);
		b2.addActionListener(this);


		// Create and name two panels for the selection of year and month ComboBox
		JPanel panel5 = new JPanel();
		panel5.setBorder(BorderFactory.createTitledBorder("ordinary option"));
		// Insert these two panels into panel2
		panel2.add(panel5);
		ord_option = new JComboBox<String>();
		panel5.add(ord_option);
		ord_option.addItem("standard");
		ord_option.addItem("vegetarian");
		ord_option.addItem("halal");
		ord_option.addItem("gourmet menu");
		JLabel label2 = new JLabel("Gourmet menu is $50");
		panel2.add(label2);


		init(mainPanel);



		this.setVisible(true);// Let the frame is visible
		this.setTitle("Flight Check In");// Set the title of frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Let the frame can be closed


	}

	//Calculate the total fee for extra option
	public void calFee() {
		if(ord_option.getSelectedItem().toString().equals("gourmet menu")) {
			this.extraFee=50;
		}
		if(mySeatType.equals("special")) {
			this.extraFee=80;
		}
		if(mySeatType.equals("special") && ord_option.getSelectedItem().toString().equals("gourmet menu")) {
			this.extraFee=130;
		}

	}


	// Override the method of the interface ActionListener
	public void actionPerformed(ActionEvent e) {
		int check = CheckSelection();
		if (check == 0) {
			JOptionPane.showMessageDialog(this,"You didn't choose a seat!","Warning", JOptionPane.ERROR_MESSAGE);
		}
		else if(check > 1) {
			JOptionPane.showMessageDialog(this,"You choose more than one seat!","Warning", JOptionPane.ERROR_MESSAGE);
		}
		else {
			int sure = JOptionPane.showConfirmDialog(this,"Are you sure about your choice?","Hint", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(sure == 0) {
				if (e.getSource() == b1) {
					for (SeatButton seatButton:seats) {
						if(seatButton.SeatState.equals("1")) {
							mySeatState = "-1";
							mySeatId = seatButton.SeatId;
							mySeatType = seatButton.SeatType;
							String mySeatNumber = mySeatState + " " + mySeatType + " " + mySeatId;
							System.out.println(mySeatNumber);
							myTicket.setSeatNumber(mySeatNumber);
							System.out.println(myTicket.toString());
							database.replace(myTicket);
							for (Ticket ticket:database.ticketHashSet){
								System.out.println(ticket.toString());
							}
							database.write();
						}
					}
					myTicket.setFoodType(ord_option.getSelectedItem().toString());
					database.replace(myTicket);
					database.write();
					this.calFee();
					if(!mySeatType.equals("special") && !ord_option.getSelectedItem().toString().equals("gourmet menu")) {
						this.dispose();
						boardingpass boarding=new boardingpass(bookNumber);
					}
					else {
						this.dispose();
						Payment pay = new Payment(ord_option.getSelectedItem().toString(), mySeatType, this.extraFee, bookNumber);
					}
				}

				// Press the exit button, then close the program
				else if (e.getSource() == b2) {
					System.exit(0);
				}
			}
		}
	}
	public int CheckSelection(){
		int check = 0;
		for (SeatButton seatButton:seats) {
			if (seatButton.SeatState == "1"){
				check++;
			}
		}
		return check;
	}
}
