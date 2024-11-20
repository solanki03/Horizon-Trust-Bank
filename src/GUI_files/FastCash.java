package GUI_files;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Constants.CommonConstants;

public class FastCash extends JFrame implements ActionListener{
    
    JButton rs1, rs2, rs3, rs4, rs5, rs6, backButton;
    JLabel msgLabel;
    String pinNo;
    
    public FastCash(String pinNo){

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

        // create a label to display msg
        JLabel textLabel = new JLabel("Select Cash Withdrawl Amount");
        textLabel.setBounds(240, 200, 280, 30);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        imglabel.add(textLabel);

        // create a label to display withdrawn amount msg
        msgLabel = new JLabel();
        msgLabel.setBounds(215, 240, 280, 30);
        msgLabel.setForeground(Color.RED);
        msgLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        imglabel.add(msgLabel);

        // create buttons to withdraw amount using Fast Cash
        rs1 = new JButton("Rs. 100");
        rs1.setBounds(190, 300, 130, 20);
        rs1.setFont(new Font("Calibri", Font.BOLD, 13));
        rs1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(rs1);
        rs1.addActionListener(this);

        rs2 = new JButton("Rs. 500");
        rs2.setBounds(375, 300, 130, 20);
        rs2.setFont(new Font("Calibri", Font.BOLD, 13));
        rs2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(rs2);
        rs2.addActionListener(this);

        rs3 = new JButton("Rs. 1000");
        rs3.setBounds(190, 335, 130, 20);
        rs3.setFont(new Font("Calibri", Font.BOLD, 13));
        rs3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(rs3);
        rs3.addActionListener(this);

        rs4 = new JButton("Rs. 2000");
        rs4.setBounds(375, 335, 130, 20);
        rs4.setFont(new Font("Calibri", Font.BOLD, 13));
        rs4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(rs4);
        rs4.addActionListener(this);

        rs5 = new JButton("Rs. 5000");
        rs5.setBounds(190, 370, 130, 20);
        rs5.setFont(new Font("Calibri", Font.BOLD, 13));
        rs5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(rs5);
        rs5.addActionListener(this);

        rs6 = new JButton("Rs. 10000");
        rs6.setBounds(375, 370, 130, 20);
        rs6.setFont(new Font("Calibri", Font.BOLD, 13));
        rs6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(rs6);
        rs6.addActionListener(this);

        // CREATE A BACK PIN BUTTON
        backButton = new JButton("BACK");
        backButton.setBounds(375, 408, 130, 20);
        backButton.setFont(new Font("Calibri", Font.BOLD, 12));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(backButton);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            
            if(ae.getSource() == backButton){

                // close the current window and open ATM Transaction window
                setVisible(false);
                new AtmTransaction(pinNo).setVisible(true);
    
            } else {

                // accessing the text from the button directly & store it in amout. 
                // substring(4) --> means it'll skip 1st 4 characters then it'll store the text. 
                // ex - Rs. 100 --> skips 1st 4 chars(Rs. ) & get the value(100)
                String amount = ((JButton)ae.getSource()).getText().substring(4); 
                CommonConstants cc = new CommonConstants();

                //chech the account has balance or not
                ResultSet resultSet = cc.s.executeQuery("select * from Bank where PIN = '" +pinNo+"'");
                int balance = 0;

                while(resultSet.next()){
                    if(resultSet.getString("typeOf_Transaction").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                // check if user hits back-button/ user has less amount in bank than withdrawl amount, then display insufficient balance.
                if(ae.getSource() != backButton && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }

                // for cash withdrawl ---
                Date date = new Date();
                cc.s.executeUpdate("insert into bank values('"+pinNo+"', '"+date+"', 'Cash Withdrawl', '"+amount+"')");
                msgLabel.setText("Rs. "+ amount + " Debited Successfully!");

            }
            
        } catch (Exception p) {
            p.printStackTrace();
        }
    }
}
