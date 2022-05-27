package boundary;

import control.Customer;
import control.Seat;
import control.Seats;
import control.Ticket;
import entity.SeatButton;
import entity.SeatButtons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class FlightFrame extends MainFrame implements ActionListener {

	JButton b1, b2;
	int seatFee;
	String mySeatState;
	String mySeatType;
	String mySeatId;
	Ticket myTicket;
	Customer CustomerDatabase;
	Seats SeatsDatabase;
	String bookNumber;
	JPanel mainPanel = new JPanel();

	SeatButton seatButton1;
	SeatButton seatButton2;
	SeatButton seatButton3;
	SeatButton seatButton4;
	SeatButton seatButton5;
	SeatButton seatButton6;
	SeatButton seatButton7;
	SeatButton seatButton8;
	SeatButton seatButton9;
	SeatButton seatButton10;
	SeatButton seatButton11;
	SeatButton seatButton12;
	SeatButton seatButton13;
	SeatButton seatButton14;
	SeatButton seatButton15;
	SeatButton seatButton16;
	SeatButton seatButton17;
	SeatButton seatButton18;
	SeatButton seatButton19;
	SeatButton seatButton20;
	SeatButton seatButton21;
	SeatButton seatButton22;
	SeatButton seatButton23;
	SeatButton seatButton24;
	SeatButton seatButton25;
	SeatButton seatButton26;
	SeatButton seatButton27;
	SeatButton seatButton28;
	SeatButton seatButton29;
	SeatButton seatButton30;
	SeatButton seatButton31;
	SeatButton seatButton32;
	ArrayList<SeatButton> seats = new SeatButtons().Buttons;

	public FlightFrame(String bookNumber) {
		/**
		 * Create container object, The operation of components in javax.swing need to
		 * operate under the container
		 */
		this.bookNumber = bookNumber;
		CustomerDatabase = new Customer();
		SeatsDatabase = new Seats();

//		seatButton1 = new SeatButton("wideSeat.png", 0 ,0,"0","special","1");
//		seatButton2 = new SeatButton("wideSeat.png", 75 ,0,"0","special","2");
//		seatButton3 = new SeatButton("normalSeat.png", 500 ,0,"0","normal","3");
//		seatButton4 = new SeatButton("normalSeat.png", 550 ,0,"0","normal","4");
//		seatButton5 = new SeatButton("normalSeat.png", 600 ,0,"0","normal","5");
//		seatButton6 = new SeatButton("normalSeat.png", 650 ,0,"0","normal","6");
//		seatButton7 = new SeatButton("wideSeat.png", 1050 ,0,"0","special","7");
//		seatButton8 = new SeatButton("wideSeat.png", 1125 ,0,"0","special","8");
//		seatButton9 = new SeatButton("wideSeat.png", 0 ,70,"0","special","9");
//		seatButton10 = new SeatButton("wideSeat.png", 75 ,70,"0","special","10");
//		seatButton11 = new SeatButton("normalSeat.png", 500 ,70,"0","normal","11");
//		seatButton12 = new SeatButton("normalSeat.png", 550 ,70,"0","normal","12");
//		seatButton13 = new SeatButton("normalSeat.png", 600,70,"0","normal","13");
//		seatButton14 = new SeatButton("normalSeat.png", 650,70,"0","normal","14");
//		seatButton15 = new SeatButton("wideSeat.png", 1050 ,70,"0","special","15");
//		seatButton16 = new SeatButton("wideSeat.png", 1125 ,70,"0","special","16");
//		seatButton17 = new SeatButton("wideSeat.png", 0 ,140,"0","special","17");
//		seatButton18 = new SeatButton("wideSeat.png", 75 ,140,"0","special","18");
//		seatButton19 = new SeatButton("normalSeat.png", 500 ,140,"0","normal","19");
//		seatButton20 = new SeatButton("normalSeat.png", 550 ,140,"0","normal","20");
//		seatButton21 = new SeatButton("normalSeat.png", 600 ,140,"0","normal","21");
//		seatButton22 = new SeatButton("normalSeat.png", 650 ,140,"0","normal","22");
//		seatButton23 = new SeatButton("wideSeat.png", 1050 ,140,"0","special","23");
//		seatButton24 = new SeatButton("wideSeat.png", 1125 ,140,"0","special","24");
//		seatButton25 = new SeatButton("wideSeat.png", 0 ,210,"0","special","25");
//		seatButton26 = new SeatButton("wideSeat.png", 75 ,210,"0","special","26");
//		seatButton27 = new SeatButton("normalSeat.png", 500 ,210,"0","normal","27");
//		seatButton28= new SeatButton("normalSeat.png", 550 ,210,"0","normal","28");
//		seatButton29 = new SeatButton("normalSeat.png", 600,210,"0","normal","29");
//		seatButton30 = new SeatButton("normalSeat.png", 650,210,"0","normal","30");
//		seatButton31 = new SeatButton("wideSeat.png", 1050 ,210,"0","special","31");
//		seatButton32 = new SeatButton("wideSeat.png", 1125 ,210,"0","special","32");
//
//		seats.add(seatButton1);
//		seats.add(seatButton2);
//		seats.add(seatButton3);
//		seats.add(seatButton4);
//		seats.add(seatButton5);
//		seats.add(seatButton6);
//		seats.add(seatButton7);
//		seats.add(seatButton8);
//		seats.add(seatButton9);
//		seats.add(seatButton10);
//		seats.add(seatButton11);
//		seats.add(seatButton12);
//		seats.add(seatButton13);
//		seats.add(seatButton14);
//		seats.add(seatButton15);
//		seats.add(seatButton16);
//		seats.add(seatButton17);
//		seats.add(seatButton18);
//		seats.add(seatButton19);
//		seats.add(seatButton20);
//		seats.add(seatButton21);
//		seats.add(seatButton22);
//		seats.add(seatButton23);
//		seats.add(seatButton24);
//		seats.add(seatButton25);
//		seats.add(seatButton26);
//		seats.add(seatButton27);
//		seats.add(seatButton28);
//		seats.add(seatButton29);
//		seats.add(seatButton30);
//		seats.add(seatButton31);
//		seats.add(seatButton32);

		for (SeatButton seat:seats) {
			seat.setSeats(seats);
		}

		SeatButton[] seatButtons = new SeatButton[32];
		for (int i = 0; i < seatButtons.length; i++) {
			seatButtons[i] = seats.get(i);
		}

		for (Seat seat: SeatsDatabase.seatList) {
			System.out.println("-----------------------");
			System.out.println(seat.toString());
			String seatState = seat.getSeatState();
			String seatNumber = seat.getSeatNumber();
			System.out.println(seatState);
			if (seatState.equals("-1")) {
				System.out.println(seatNumber);
				for (int i = 0; i < seatButtons.length; i++) {
					if (seatButtons[i].SeatId.equals(seatNumber) ) {
						seatButtons[i].SeatState = "-1";
						seatButtons[i].changeSeatState("red");
					}
				}
			}
			else if (seatState.equals("1")) {
				System.out.println(seatNumber);
				for (int i = 0; i < seatButtons.length; i++) {
					if (seatButtons[i].SeatId.equals(seatNumber) ) {
						seatButtons[i].SeatState = "1";
						seatButtons[i].changeSeatState("green");
					}
				}
			}

		}

//		System.out.println(seatButton12.SeatState);
//		myTicket = database.checkBookNumber(bookNumber);
//		mySeatState = myTicket.getSeatNumber().split(" ")[0];
//		mySeatType = myTicket.getSeatNumber().split(" ")[1];
//		mySeatId = myTicket.getSeatNumber().split(" ")[2];
//		System.out.println(mySeatState);
//		System.out.println(mySeatType);
//		System.out.println(mySeatId);


		Container container = this.getContentPane();
		container.add(mainPanel);
		mainPanel.setSize(1200,1000);
		mainPanel.setLayout(null);// Set the frame to a grid layout of 9 rows and 1 column
		// Add a label on the first line of the frame to inform the user to complete the
		// information editing
		JLabel label1 = new JLabel("                                                              Please choose your seat below:");
		label1.setFont(new Font("Calibri",Font.BOLD,30));
		label1.setForeground(Color.black);
		label1.setBounds(0,0,1000,120);
		mainPanel.add(label1);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0,100,1200,300);
		panel1.setBorder(BorderFactory.createTitledBorder(""));
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

		for (SeatButton seat: seats) {
			seat_Panel_inside.add(seat);
		}



		JPanel panel2 = new JPanel();
		panel2.setBounds(0,220,1200,250);

		//panel2.setBorder(BorderFactory.createTitledBorder(""));
		panel2.setLayout(null);
		ImageIcon wideIcon = new ImageIcon("src/boundary/wideSeat.png");
		ImageIcon normalIcon = new ImageIcon("src/boundary/normalSeat.png");


		JLabel wideSeat = new JLabel(wideIcon);
		JLabel normalSeat = new JLabel(normalIcon);
		JLabel normalSeatUnselected = new JLabel(normalIcon);
		JLabel normalSeatSelected = new JLabel(normalIcon);

		normalSeatUnselected.setOpaque(true);
		normalSeatSelected.setOpaque(true);
		normalSeatUnselected.setBackground(Color.green);
		normalSeatSelected.setBackground(Color.red);



		JLabel wideFont = new JLabel("Wide Seat: ");
		JLabel normalFont = new JLabel("Normal Seat: ");
		JLabel unselectedFont = new JLabel("Your selection: ");
		JLabel selectedFont = new JLabel("Seat Selected: ");

		wideFont.setFont(new java.awt.Font("Dialog", 1, 15));
		normalFont.setFont(new java.awt.Font("Dialog", 1, 15));
		unselectedFont.setFont(new java.awt.Font("Dialog", 1, 15));
		selectedFont.setFont(new java.awt.Font("Dialog", 1, 15));

		wideSeat.setBounds(240,200,50,50);
		normalSeat.setBounds(100,200,50,50);
		normalSeatUnselected.setBounds(600,200,50,50);
		normalSeatSelected.setBounds(420,200,50,50);

		wideFont.setBounds(160,200,100,50);
		normalFont.setBounds(0,200,100,50);
		unselectedFont.setBounds(480,200,150,50);
		selectedFont.setBounds(300,200,150,50);


		panel2.add(wideSeat);
		panel2.add(normalSeat);
		panel2.add(normalSeatUnselected);
		panel2.add(normalSeatSelected);

		panel2.add(wideFont);
		panel2.add(normalFont);
		panel2.add(unselectedFont);
		panel2.add(selectedFont);

		mainPanel.add(panel1);
		mainPanel.add(panel2);



		b1 = new JButton("Next step");
		b1.setBounds(650,500,100,50);
		b2 = new JButton("Back");
		b2.setBounds(450,500,100,50);

		b1.addActionListener(this);
		b2.addActionListener(this);

		b1.setVisible(true);
		b2.setVisible(true);
		mainPanel.add(b1);
		mainPanel.add(b2);


		mainPanel.setVisible(true);



		init(mainPanel);



		this.setVisible(true);// Let the frame is visible
		this.setTitle("Seat Selection");// Set the title of frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Let the frame can be closed


	}

	//Calculate the total fee for extra option



	// Override the method of the interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			System.exit(0);
		}
		int check = CheckSelection();
		if (check == 0) {
			JOptionPane.showMessageDialog(this,"You didn't choose a seat!","Warning",0);
		}
		else {
			this.seatFee = 0;
			for (SeatButton seatButton :seats) {
				if (seatButton.SeatState == "1" && seatButton.SeatType.equals("special")) {
					this.seatFee = 80;
				}
			}
			int sure = JOptionPane.showConfirmDialog(this,"Your bonus fee is: "+this.seatFee+"$"+"\n"+"Are you sure about your choice?","Hint",2,1);
			if(sure == 0) {
				if (e.getSource() == b1) {
					for (SeatButton seatButton:seats) {
						if(seatButton.SeatState == "1") {
							mySeatState = "-1";
							mySeatId = seatButton.SeatId;
							mySeatType = seatButton.SeatType;
							String mySeatNumber = mySeatState + " " + mySeatType + " " + mySeatId;
							System.out.println(mySeatNumber);
							myTicket.setSeatNumber(mySeatNumber);
							System.out.println(myTicket.toString());
							CustomerDatabase.replace(myTicket);
							for (Ticket ticket:CustomerDatabase.ticketHashSet){
								System.out.println(ticket.toString());
							}
							CustomerDatabase.write();
							this.dispose();
							MealSelections selectMeal = new MealSelections(this.bookNumber, this.seatFee);
						}
					}

					CustomerDatabase.replace(myTicket);
					CustomerDatabase.write();


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

	public static void main(String[] args) {
		new FlightFrame("123");
	}
}
