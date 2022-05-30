package control;

import javax.swing.*;

public class mealselect {
    JCheckBox jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4;
    Ticket myTicket;
    String mealChoice;



    public mealselect(Ticket myTicket,JCheckBox jCheckBox1,JCheckBox jCheckBox2,
                      JCheckBox jCheckBox3,JCheckBox jCheckBox4){
        this.myTicket=myTicket;
        this.jCheckBox1=jCheckBox1;
        this.jCheckBox2=jCheckBox2;
        this.jCheckBox3=jCheckBox3;
        this.jCheckBox4=jCheckBox4;
    }

    public String showSelectMessage(){

        if(!jCheckBox1.isSelected() && !jCheckBox2.isSelected()
                && !jCheckBox3.isSelected() && !jCheckBox4.isSelected())
        {
            String[] options={"OK"};
            JOptionPane.showOptionDialog(null, "Please choose your meals", "Warning",
                    JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,
                    null,options,options[0]);
        }

        else {
            if(jCheckBox1.isSelected() && !jCheckBox2.isSelected()
                    && !jCheckBox3.isSelected() && !jCheckBox4.isSelected())
            {
                mealChoice="Standard";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox2.isSelected() && !jCheckBox1.isSelected()
                    && !jCheckBox3.isSelected() && !jCheckBox4.isSelected())
            {
                this.mealChoice="Vegetarian";
                myTicket.setFoodType(this.mealChoice);
            }
            if(jCheckBox4.isSelected() && !jCheckBox2.isSelected()
                    && !jCheckBox3.isSelected() && !jCheckBox1.isSelected())
            {
                this.mealChoice="Gourmet Menu";
                myTicket.setFoodType(this.mealChoice);
            }
            if(jCheckBox3.isSelected() && !jCheckBox2.isSelected()
                    && !jCheckBox1.isSelected() && !jCheckBox4.isSelected())
            {
                mealChoice="Halal";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox1.isSelected() && jCheckBox2.isSelected()
                    && !jCheckBox3.isSelected() && !jCheckBox4.isSelected()) {
                mealChoice="Standard and Vegetarian";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox1.isSelected() && jCheckBox3.isSelected() && !jCheckBox2.isSelected()
                    && !jCheckBox4.isSelected()) {
                mealChoice="Standard and Halal";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox1.isSelected() && jCheckBox4.isSelected() && !jCheckBox2.isSelected()
                    && !jCheckBox3.isSelected()) {
                mealChoice="Standard and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox2.isSelected() && jCheckBox3.isSelected()
                    && !jCheckBox1.isSelected() && !jCheckBox4.isSelected()) {
                mealChoice="Vegetarian and Halal";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox2.isSelected() && jCheckBox4.isSelected() && !jCheckBox1.isSelected()
                    && !jCheckBox3.isSelected()) {
                mealChoice="Vegetarian and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox3.isSelected() && jCheckBox4.isSelected() && !jCheckBox2.isSelected()
                    && !jCheckBox1.isSelected()) {
                mealChoice="Halal and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox1.isSelected() && jCheckBox2.isSelected() &&
                    jCheckBox3.isSelected() && !jCheckBox4.isSelected()) {
                mealChoice="Standard; Vegetarian and Halal";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox1.isSelected() && jCheckBox2.isSelected() && jCheckBox4.isSelected() && !jCheckBox3.isSelected()) {
                mealChoice="Standard; Vegetarian and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox3.isSelected() && jCheckBox2.isSelected() && jCheckBox4.isSelected() && !jCheckBox1.isSelected()) {
                mealChoice="Vegetarian; Halal and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
            }
            if(jCheckBox3.isSelected() && jCheckBox2.isSelected() && jCheckBox4.isSelected() && jCheckBox1.isSelected()) {
                mealChoice="Standard; Vegetarian; Halal and Gourmet Menu";
                myTicket.setFoodType(mealChoice);
            }

        }

        return mealChoice;
    }
}
