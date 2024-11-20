package GUI_files;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Constants.CommonConstants;

public class MiniStatement extends JFrame {

    String pinNo;

    public MiniStatement(String pinNo){

        // set the tite of the frame
        super("Mini Statement");

        // set the size of the GUI
        setSize(400, 600);

        // set layout null to place components in the page
        setLayout(null);

        // set location of frame on the page
        setLocation(20,20);

        // prevent any resize of our GUI
        setResizable(false);

        //create the background color of GUI
        getContentPane().setBackground(Color.WHITE);

        this.pinNo = pinNo;
        addComponents();
    }

    private void addComponents() {

        // add logo to the frame
        ImageIcon logo2 = new ImageIcon(ClassLoader.getSystemResource("Icons/bankLogo.png"));
        Image img = logo2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(100, 12, 30, 30);
        add(imglabel);

        // create a label to display bank name
        JLabel bankLabel = new JLabel("Horizon Trust Bank");
        bankLabel.setBounds(140, 20, 130, 20);
        bankLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        add(bankLabel);
        
        // create a label to display mini statement
        JLabel miniStatementLabel = new JLabel();
        miniStatementLabel.setBounds(20, 110, 300, 300);
        miniStatementLabel.setFont(new Font("Calibri", Font.BOLD, 12));
        add(miniStatementLabel);

        // create a card label
        JLabel cardNoLabel = new JLabel();
        cardNoLabel.setBounds(20, 80, 300, 20);
        cardNoLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        add(cardNoLabel);

        // create a label to display balance
        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 450, 350, 20);
        balanceLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        add(balanceLabel);

        try {

            CommonConstants cc = new CommonConstants();
            ResultSet resultSet = cc.s.executeQuery("select * from login where PIN_Number = '" +pinNo+"'");

            // display the card no. in the frame
            while (resultSet.next()) {
                cardNoLabel.setText("Card Number: " + resultSet.getString("Card_Number").substring(0,4) + "XXXXXXXX" + resultSet.getString("Card_Number").substring(12));
            }

        } catch (Exception p) {
            p.printStackTrace();
        }

        try {

            int balance = 0;
            CommonConstants cc = new CommonConstants();
            ResultSet resultSet = cc.s.executeQuery("select * from Bank where PIN = '" +pinNo+"'");

            // display the account statement in the frame
            while (resultSet.next()) {

                miniStatementLabel.setText(miniStatementLabel.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("typeOf_Transaction") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");

                if(resultSet.getString("typeOf_Transaction").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            balanceLabel.setText("Your current account balance is Rs. " + balance);

        } catch (Exception q) {
            q.printStackTrace();
        }
    }
    
}
