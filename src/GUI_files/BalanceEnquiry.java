package GUI_files;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Constants.CommonConstants;

public class BalanceEnquiry extends JFrame implements ActionListener{

    String pinNo;
    JButton backButton;

    public BalanceEnquiry(String pinNo){

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
        
        // create a Back button
        backButton = new JButton("BACK");
        backButton.setBounds(375, 408, 130, 20);
        backButton.setFont(new Font("Calibri", Font.BOLD, 13));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(backButton);
        backButton.addActionListener(this);

        CommonConstants cc = new CommonConstants();
        int balance = 0;
        try {
            //chech the account has balance or not
                ResultSet resultSet = cc.s.executeQuery("select * from Bank where PIN = '" +pinNo+"'");

                while(resultSet.next()){
                    if(resultSet.getString("typeOf_Transaction").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
        } catch (Exception p) {
            p.printStackTrace();
        }

        // create a label to display balance enquiry msg
        JLabel textLabel = new JLabel("Your Current Account Balance:");
        textLabel.setBounds(200, 260, 310, 60);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        imglabel.add(textLabel);

        // create a label to display balance 
        JLabel balanceLabel = new JLabel("Rs. " + balance);
        balanceLabel.setBounds(200, 290, 250, 60);
        balanceLabel.setForeground(Color.GREEN);
        balanceLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        imglabel.add(balanceLabel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // close the current window and open ATM Transaction window
        setVisible(false);
        new AtmTransaction(pinNo).setVisible(true);
    }
    
}
