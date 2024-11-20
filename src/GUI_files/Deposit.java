package GUI_files;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Constants.CommonConstants;

public class Deposit extends JFrame implements ActionListener{

    JTextField depositAmoutnTF;
    JButton depositButton,backButton;
    JLabel msgLabel;
    String pinNo;

    public Deposit(String pinNo){

        // set the size of the GUI
        setSize(900, 900);

        // set layout null to place components in the page
        setLayout(null);

        // set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // remove the upper panel from the GUI ---> use Exit button to close the window
        setUndecorated(true);
        
        this.pinNo = pinNo;
        addComponents();
    }

	private void addComponents() {
		
        // add atm image to the frame
        ImageIcon atmLogo = new ImageIcon(ClassLoader.getSystemResource("Icons/atm_image.png"));
        Image img = atmLogo.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(0, 0, 900, 900);
        add(imglabel);

        // create a deposite label
        JLabel textLabel = new JLabel("Enter the amount you want to deposite");
        textLabel.setBounds(215, 200, 280, 30);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        imglabel.add(textLabel);

        // create a JTextField to get deposited amount
        depositAmoutnTF = new JTextField();
        depositAmoutnTF.setBounds(215, 250, 270, 25);
        depositAmoutnTF.setFont(new Font("Arial", Font.BOLD, 15));
        imglabel.add(depositAmoutnTF);

        // create a label to display deposit msg
        msgLabel = new JLabel();
        msgLabel.setBounds(215, 300, 280, 30);
        msgLabel.setForeground(Color.ORANGE);
        msgLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        imglabel.add(msgLabel);

        // CREATE A DEPOSIT BUTTON
        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(375, 372, 130, 20);
        depositButton.setFont(new Font("Calibri", Font.BOLD, 13));
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(depositButton);
        depositButton.addActionListener(this);

        // CREATE A BACK BUTTON
        backButton = new JButton("BACK");
        backButton.setBounds(375, 408, 130, 20);
        backButton.setFont(new Font("Calibri", Font.BOLD, 13));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(backButton);
        backButton.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == depositButton){

            String depositS = depositAmoutnTF.getText();
            Date date = new Date();

            if(depositS.isBlank()){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposite");
            } else {
                try {
                    CommonConstants conn = new CommonConstants();
                    String query = "insert into Bank values('" + pinNo + "','" + date + "', 'Deposit','" + depositS + "')";

                    conn.s.executeUpdate(query);
                    msgLabel.setText("Rs. "+ depositS +" Credited Successfully!");

                    // clear the deposit amount text field
                    depositAmoutnTF.setText("");

                } catch (Exception x) {
                    x.printStackTrace();
                }
            }

        }else if(ae.getSource() == backButton){

            // close the current window and open ATM Transaction window
            setVisible(false);
            new AtmTransaction(pinNo).setVisible(true);

        }
    }
}
