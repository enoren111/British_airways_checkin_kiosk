package boundary;

import control.*;
import entity.SeatButton;
import entity.SeatButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightFrame extends MainFrame implements ActionListener {

	JButton b1, b2;
	int seatFee;
	Ticket myTicket;
	Flight myFlight;
	Customer CustomerDatabase;
	Seats SeatsDatabase;
	JPanel mainPanel = new JPanel();



	ArrayList<SeatButton> seats;

	public FlightFrame(Ticket myTicket, Flight myFlight) {
		/*
		  Create container object, The operation of components in javax.swing need to
		  operate under the container
		 */
		this.myTicket = myTicket;
		this.myFlight = myFlight;
		seats = new SeatButtons().Buttons;
		CustomerDatabase = new Customer();
		SeatsDatabase = new Seats(myTicket.getFlightNumber());

		for (SeatButton seat:seats) {
			seat.setSeats(seats);
			seat.setMyTicket(myTicket);
		}

		SeatButton[] seatButtons = new SeatButton[32];
		for (int i = 0; i < seatButtons.length; i++) {
			seatButtons[i] = seats.get(i);
		}

		for (Seat seat: SeatsDatabase.seatList) {
			String seatState = seat.getSeatState();
			String seatNumber = seat.getSeatNumber();
			if (seatState.equals("-1")) {
				for (SeatButton seatButton : seatButtons) {
					if (seatButton.SeatId.equals(seatNumber)) {
						seatButton.SeatState = "-1";
						seatButton.changeSeatState("red");
					}
				}
			}
		}

		for (SeatButton seatButton : seatButtons) {
			if (seatButton.getSeatId().equals(myTicket.getSeatNumber())) {
				seatButton.SeatState = "1";
				seatButton.changeSeatState("green");
			}
		}



		Container container = this.getContentPane();
		container.add(mainPanel);
		mainPanel.setSize(1200,1000);
		mainPanel.setLayout(null);// Set the frame to a grid layout of 9 rows and 1 column
		// Add a label on the first line of the frame to inform the user to complete the
		// information editing
		JLabel label1 = new JLabel("                                                              " +
				                    "Please choose your seat below:");
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

		wideFont.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		normalFont.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		unselectedFont.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		selectedFont.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));

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

	// Override the method of the interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			for (SeatButton seatButton:seats) {
				if(seatButton.SeatState.equals("1") ) {
					myTicket.setSeatNumber(seatButton.getSeatId());
				}
			}
			this.dispose();
			new InformationConfirm(myTicket,myFlight);
		}

		else {
			int check = CheckSelection();
			if (check == 0) {
				JOptionPane.showMessageDialog(this,"You didn't choose a seat!","Warning", JOptionPane.ERROR_MESSAGE);
			}
			else {
				this.seatFee = 0;
				for (SeatButton seatButton :seats) {
					if (seatButton.SeatState.equals("1") && seatButton.SeatType.equals("special")) {
						this.seatFee = 80;
					}
				}

				String[] options = { "OK ", "CANCEL " };

				int sure = JOptionPane.showOptionDialog(this,"Your bonus fee is: "
						+this.seatFee+"$"+"\n"+"Are you sure about your choice?","Hint",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						null,options,options[0]);

				if(sure == 0) {
					if (e.getSource() == b1) {
						for (SeatButton seatButton:seats) {
							if(seatButton.SeatState.equals("1") ) {
								myTicket.setSeatNumber(seatButton.getSeatId());
								this.dispose();
								new MealSelection(myTicket, myFlight,this.seatFee);
							}
						}
					}
				}
			}

		}
	}
	public int CheckSelection(){
		int check = 0;
		for (SeatButton seatButton:seats) {
			if (seatButton.SeatState.equals("1")){
				check++;
			}
		}
		return check;
	}

}
