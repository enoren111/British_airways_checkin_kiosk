package boundary;

import control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealSelection extends MainFrame implements ActionListener{
    Ticket myTicket;
    Flight myFlight;
    Customer CustomerDatabase;
    Seats SeatsDatabase;
    String mealChoice;
    int extraFee;
    int seatFee;
    int mealFee;
    JButton b1, b2;
    JCheckBox optionStandard;
    JCheckBox optionVegetarian;
    JCheckBox optionHalal;
    JCheckBox optionGourmet;
    JPanel mainPanel = new JPanel();

    public MealSelection(Ticket myTicket, Flight myFlight, int seatFee) {
        /*
          Create container object, The operation of components in javax.swing need to
          operate under the container
         */
        this.seatFee=seatFee;
        this.extraFee=seatFee;
        this.myTicket = myTicket;
        this.myFlight = myFlight;
        CustomerDatabase = new Customer();
        SeatsDatabase = new Seats(myTicket.getFlightNumber());
        Container container = this.getContentPane();
        container.add(mainPanel);
        mainPanel.setSize(1200,1000);
        mainPanel.setLayout(null);

        JLabel label1 = new JLabel("                                                           Please choose your meals below:");
        label1.setFont(new Font("Calibri",Font.BOLD,30));
        label1.setForeground(Color.black);
        label1.setBounds(0,0,1000,100);
        mainPanel.add(label1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0,80,1200,420);
        panel2.setBorder(BorderFactory.createTitledBorder("Meal Choices"));
        panel2.setLayout(null);
        mainPanel.add(panel2);
        JLabel standard = new JLabel();
        JLabel vegetarian = new JLabel();
        JLabel halal = new JLabel();
        JLabel gourmetMenu = new JLabel();
        ImageIcon icon1 = new ImageIcon("image/standard.png");
        ImageIcon icon2 = new ImageIcon("image/vegetarian.png");
        ImageIcon icon3 = new ImageIcon("image/halal.png");
        ImageIcon icon4 = new ImageIcon("image/gourmet.png");
        icon1.setImage(icon1.getImage().getScaledInstance(280,260,Image.SCALE_DEFAULT));
        icon2.setImage(icon2.getImage().getScaledInstance(280,260,Image.SCALE_DEFAULT));
        icon3.setImage(icon3.getImage().getScaledInstance(280,260,Image.SCALE_DEFAULT));
        icon4.setImage(icon4.getImage().getScaledInstance(280,260,Image.SCALE_DEFAULT));
        standard.setIcon(icon1);
        vegetarian.setIcon(icon2);
        halal.setIcon(icon3);
        gourmetMenu.setIcon(icon4);
        panel2.add(standard);
        panel2.add(vegetarian);
        panel2.add(halal);
        panel2.add(gourmetMenu);

        standard.setBounds(10, 15, 300, 300);
        vegetarian.setBounds(305, 15, 300, 300);
        halal.setBounds(600, 15, 300, 300);
        gourmetMenu.setBounds(895, 15, 300, 300);

        optionStandard = new JCheckBox("Standard   0$");
        optionVegetarian = new JCheckBox("Vegetarian   10$");
        optionHalal = new JCheckBox("Halal   10$");
        optionGourmet = new JCheckBox("Gourmet Menu  50$");
        panel2.add(optionVegetarian);
        panel2.add(optionStandard);
        panel2.add(optionHalal);
        panel2.add(optionGourmet);

        optionStandard.setBounds(80, 300, 150, 20);
        optionVegetarian.setBounds(375, 300, 150, 20);
        optionHalal.setBounds(685, 300, 150, 20);
        optionGourmet.setBounds(950, 300, 150, 20);

        JLabel label2=new JLabel("<html><body><p>*An additional pay will be paid for each additional option<br/>" +
                "*Once you click on 'Next' button, you will not change your selections(meals and seat)</p></body></html>");

        //JLabel label2 = new JLabel("Notice: An additional $30 will be paid for each additional option");
        label2.setForeground(Color.red);
        label2.setFont(new Font("Calibri",Font.BOLD,20));
        label2.setBounds(0, 330, 1000, 120);
        panel2.add(label2);



        b1 = new JButton("Next");
        b1.setBounds(650,500,80,50);
        b2 = new JButton("Back");
        b2.setBounds(450,500,80,50);

        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setVisible(true);
        b2.setVisible(true);
        mainPanel.add(b1);
        mainPanel.add(b2);


        mainPanel.setVisible(true);



        init(mainPanel);



        this.setVisible(true);// Let the frame is visible
        this.setTitle("Meal Selection");// Set the title of frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Let the frame can be closed

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Seat mySeat = new Seat("0","0");
            for (Seat seat: SeatsDatabase.seatList) {
                if (seat.getSeatNumber().equals(myTicket.getSeatNumber())) {
                    seat.setSeatState("-1");
                    mySeat = seat;
                }
            }

            SeatsDatabase.replace(mySeat);
            SeatsDatabase.write();

            if(optionStandard.isSelected() && !optionVegetarian.isSelected()
                    && !optionHalal.isSelected() && !optionGourmet.isSelected())
            {
                this.mealChoice="Standard";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionVegetarian.isSelected() && !optionStandard.isSelected()
                    && !optionHalal.isSelected() && !optionGourmet.isSelected())
            {
                this.mealChoice="Vegetarian";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();

            }
            if(optionGourmet.isSelected() && !optionVegetarian.isSelected()
                    && !optionHalal.isSelected() && !optionStandard.isSelected())
            {
                this.mealChoice="Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionHalal.isSelected() && !optionVegetarian.isSelected()
                    && !optionStandard.isSelected() && !optionGourmet.isSelected())
            {
                this.mealChoice="Halal";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionStandard.isSelected() && optionVegetarian.isSelected()
                    && !optionHalal.isSelected() && !optionGourmet.isSelected()) {
                this.mealChoice="Standard and Vegetarian";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionStandard.isSelected() && optionHalal.isSelected() && !optionVegetarian.isSelected()
                    && !optionGourmet.isSelected()) {
                this.mealChoice="Standard and Halal";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionStandard.isSelected() && optionGourmet.isSelected() && !optionVegetarian.isSelected()
                    && !optionHalal.isSelected()) {
                this.mealChoice="Standard and Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionVegetarian.isSelected() && optionHalal.isSelected()
                    && !optionStandard.isSelected() && !optionGourmet.isSelected()) {
                this.mealChoice="Vegetarian and Halal";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionVegetarian.isSelected() && optionGourmet.isSelected() && !optionStandard.isSelected()
                    && !optionHalal.isSelected()) {
                this.mealChoice="Vegetarian and Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionHalal.isSelected() && optionGourmet.isSelected() && !optionVegetarian.isSelected()
                    && !optionStandard.isSelected()) {
                this.mealChoice="Halal and Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionStandard.isSelected() && optionVegetarian.isSelected() && optionHalal.isSelected() && !optionGourmet.isSelected()) {
                this.mealChoice="Standard; Vegetarian and Halal";
                myTicket.setFoodType(this.mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionStandard.isSelected() && optionVegetarian.isSelected() && optionGourmet.isSelected() && !optionHalal.isSelected()) {
                this.mealChoice="Standard; Vegetarian and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
                mealFee=new mealprice(mealChoice).calculatePrice();
            }
            if(optionHalal.isSelected() && optionVegetarian.isSelected() && optionGourmet.isSelected() && !optionStandard.isSelected()) {
                this.mealChoice="Vegetarian; Halal and Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);

            }
            if(optionHalal.isSelected() && optionVegetarian.isSelected() && optionGourmet.isSelected() && optionStandard.isSelected()) {
                this.mealChoice="Standard; Vegetarian; Halal and Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);

            }

            if(!optionStandard.isSelected() && !optionVegetarian.isSelected()
                    && !optionHalal.isSelected() && !optionGourmet.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Please choose your meals", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            CustomerDatabase.replace(myTicket);
            CustomerDatabase.write();
            this.dispose();
            new Payment(myTicket,this.seatFee,this.mealFee,myFlight);

        }
        else if (e.getSource()==b2) {
            this.dispose();
            new FlightFrame(myTicket, myFlight);
        }
    }

}
