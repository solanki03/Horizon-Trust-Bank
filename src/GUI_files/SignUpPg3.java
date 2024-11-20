package GUI_files;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Constants.CommonConstants;

public class SignUpPg3 extends JFrame implements ActionListener {

    JRadioButton savingAccButton, fdAccButton, currentAccButton, rdAccButton;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submitButton, cancelButton;
    String formno;

    public SignUpPg3(String formno) {
        // set the tite of the game
        super("New Account Details - Page 3");

        // set the size of the GUI
        setSize(850, 800);

        // set layout null to place components in the page
        setLayout(null);

        // set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create the background color of GUI
        getContentPane().setBackground(CommonConstants.REG_COLOR);

        this.formno = formno;
        addComponents();
    }

    private void addComponents() {

        // create a Account Details label
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setBounds(290, 40, 320, 30);
        accountDetails.setForeground(CommonConstants.TEXT_COLOR);
        accountDetails.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(accountDetails);

        // create a Account Type label
        JLabel accountType = new JLabel("Account Type:");
        accountType.setBounds(100, 150, 150, 30);
        accountType.setForeground(CommonConstants.TEXT_COLOR);
        accountType.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(accountType);

        // create a radio button for Account Type
        savingAccButton = new JRadioButton("Savings Account");
        savingAccButton.setBounds(100, 200, 200, 30);
        savingAccButton.setFont(new Font("Arial", Font.BOLD, 16));
        savingAccButton.setForeground(CommonConstants.TEXT_COLOR);
        savingAccButton.setBackground(CommonConstants.REG_COLOR);
        add(savingAccButton);

        fdAccButton = new JRadioButton("Fixed Deposit Account");
        fdAccButton.setBounds(450, 200, 250, 30);
        fdAccButton.setFont(new Font("Arial", Font.BOLD, 16));
        fdAccButton.setForeground(CommonConstants.TEXT_COLOR);
        fdAccButton.setBackground(CommonConstants.REG_COLOR);
        add(fdAccButton);

        currentAccButton = new JRadioButton("Current Account");
        currentAccButton.setBounds(100, 230, 200, 30);
        currentAccButton.setFont(new Font("Arial", Font.BOLD, 16));
        currentAccButton.setForeground(CommonConstants.TEXT_COLOR);
        currentAccButton.setBackground(CommonConstants.REG_COLOR);
        add(currentAccButton);

        rdAccButton = new JRadioButton("Recurring Deposit Account");
        rdAccButton.setBounds(450, 230, 250, 30);
        rdAccButton.setFont(new Font("Arial", Font.BOLD, 16));
        rdAccButton.setForeground(CommonConstants.TEXT_COLOR);
        rdAccButton.setBackground(CommonConstants.REG_COLOR);
        add(rdAccButton);

        // add fuctionality to select any one of the two options
        ButtonGroup AccTypeGroup = new ButtonGroup();
        AccTypeGroup.add(savingAccButton);
        AccTypeGroup.add(fdAccButton);
        AccTypeGroup.add(currentAccButton);
        AccTypeGroup.add(rdAccButton);

        // create a Card number label
        JLabel cardNoLabel = new JLabel("Card Number:");
        cardNoLabel.setBounds(100, 300, 150, 30);
        cardNoLabel.setForeground(CommonConstants.TEXT_COLOR);
        cardNoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(cardNoLabel);

        // create a Dummy Card number label
        JLabel dummyCardNoLabel = new JLabel("XXXX-XXXX-XXXX-5854");
        dummyCardNoLabel.setBounds(330, 300, 250, 30);
        dummyCardNoLabel.setForeground(CommonConstants.TEXT_COLOR);
        dummyCardNoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(dummyCardNoLabel);

        // create a label to display msg --> card info
        JLabel msgLabel1 = new JLabel("Your 16 Digit Card Number");
        msgLabel1.setBounds(100, 330, 300, 20);
        msgLabel1.setForeground(CommonConstants.TEXT_COLOR);
        msgLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(msgLabel1);

        // create a pin number label
        JLabel pinNoLabel = new JLabel("PIN:");
        pinNoLabel.setBounds(100, 370, 150, 30);
        pinNoLabel.setForeground(CommonConstants.TEXT_COLOR);
        pinNoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pinNoLabel);

        // create a Dummy Pin number label
        JLabel dummyPinNoLabel = new JLabel("XXXX");
        dummyPinNoLabel.setBounds(330, 370, 100, 30);
        dummyPinNoLabel.setForeground(CommonConstants.TEXT_COLOR);
        dummyPinNoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(dummyPinNoLabel);

        // create a label to display msg --> pin info
        JLabel msgLabel2 = new JLabel("Your 4 Digit PIN Number");
        msgLabel2.setBounds(100, 400, 300, 20);
        msgLabel2.setForeground(CommonConstants.TEXT_COLOR);
        msgLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(msgLabel2);

        // create a Services Required label
        JLabel serviceRType = new JLabel("Services Required:");
        serviceRType.setBounds(100, 450, 200, 30);
        serviceRType.setForeground(CommonConstants.TEXT_COLOR);
        serviceRType.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(serviceRType);

        // create JCheckBoxs for Services Required field
        c1 = new JCheckBox("ATM Card");
        c1.setForeground(CommonConstants.TEXT_COLOR);
        c1.setBackground(CommonConstants.REG_COLOR);
        c1.setBounds(100, 500, 200, 30);
        c1.setFont(new Font("Arial", Font.BOLD, 16));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setForeground(CommonConstants.TEXT_COLOR);
        c2.setBackground(CommonConstants.REG_COLOR);
        c2.setBounds(350, 500, 200, 30);
        c2.setFont(new Font("Arial", Font.BOLD, 16));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setForeground(CommonConstants.TEXT_COLOR);
        c3.setBackground(CommonConstants.REG_COLOR);
        c3.setBounds(100, 540, 200, 30);
        c3.setFont(new Font("Arial", Font.BOLD, 16));
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setForeground(CommonConstants.TEXT_COLOR);
        c4.setBackground(CommonConstants.REG_COLOR);
        c4.setBounds(350, 540, 200, 30);
        c4.setFont(new Font("Arial", Font.BOLD, 16));
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setForeground(CommonConstants.TEXT_COLOR);
        c5.setBackground(CommonConstants.REG_COLOR);
        c5.setBounds(100, 580, 200, 30);
        c5.setFont(new Font("Arial", Font.BOLD, 16));
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setForeground(CommonConstants.TEXT_COLOR);
        c6.setBackground(CommonConstants.REG_COLOR);
        c6.setBounds(350, 580, 200, 30);
        c6.setFont(new Font("Arial", Font.BOLD, 16));
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setForeground(CommonConstants.TEXT_COLOR);
        c7.setBackground(CommonConstants.REG_COLOR);
        c7.setBounds(100, 635, 600, 20);
        c7.setFont(new Font("Arial", Font.BOLD, 13));
        add(c7);

        // CREATE A SUBMIT BUTTON
        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(250, 685, 150, 26);
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(submitButton);
        submitButton.addActionListener(this);

        // CREATE A CANCEL BUTTON
        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(450, 685, 150, 26);
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cancelButton);
        cancelButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submitButton) {

            String accountType = null;
            // check which option is selected
            if (savingAccButton.isSelected()) {
                accountType = "Savings Account";
            } else if (fdAccButton.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (currentAccButton.isSelected()) {
                accountType = "Current Account";
            } else if (rdAccButton.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String generateCardNo = "" + Math.abs((random.nextLong() % 9000000L) + 5030859000000000L);

            String generatePIN = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            // in case of facility, it can have a lot of fields. That's why we are concating
            // it.
            String facility = "";

            if (c1.isSelected()) {
                facility += " ATM Card";
            }
            if (c2.isSelected()) {
                facility += " Internet Banking";
            }
            if (c3.isSelected()) {
                facility += " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility += " Email & SMS Alerts";
            }
            if (c5.isSelected()) {
                facility += " Cheque Book";
            }
            if (c6.isSelected()) {
                facility += " E-Statement";
            }

            try {

                if (!savingAccButton.isSelected() && !fdAccButton.isSelected() && !currentAccButton.isSelected()
                        && !rdAccButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Account type is required!");
                } else if (!c1.isSelected() && !c2.isSelected() && !c3.isSelected() && !c4.isSelected()
                        && !c5.isSelected() && !c6.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please select you service requirements!");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Select the datail confirmation checkbox to proceed further");
                } else {

                    // access the CommonConstants class and write the table query
                    CommonConstants cc = new CommonConstants();
                    String query1 = "insert into signupThree values('" + formno + "','" + accountType + "','"
                            + generateCardNo + "','" + generatePIN
                            + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + generateCardNo + "','" + generatePIN
                            + "')";

                    cc.s.executeUpdate(query1);
                    cc.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,
                            "Card Number:  " + generateCardNo + "\nPIN Number:  " + generatePIN);

                    // close the current window and open Deposit window
                    setVisible(false);
                    new Deposit(generatePIN).setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancelButton) {

            // close the current window and open Login Page window
            setVisible(false);
            new LoginPage().setVisible(true);

        }
    }

}
